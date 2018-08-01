package de.jsfpraxis.detail.vc;

import javax.faces.convert.ConverterException;

import org.junit.Assert;
import org.junit.Test;

public class CreditCardConverterTest {
	
	private static final String creditCardNumber = "1234 2345 3456 4567";
	private static final CreditCardConverter ccc = new CreditCardConverter();
	private static final String[] creditCardQuads = creditCardNumber.split(" ");
	private static final CreditCard card1 = new CreditCard(creditCardQuads[0], creditCardQuads[1], creditCardQuads[2], creditCardQuads[3]);
	
	@Test
	public void getAsObjectWithBlanks() {
		Assert.assertEquals(card1, ccc.getAsObject(null, null, creditCardNumber));
	}

	@Test
	public void getAsObjectWithoutBlanks() {
		Assert.assertEquals(card1, ccc.getAsObject(null, null, creditCardNumber.replaceAll(" ", "")));
	}

	@Test
	public void getAsObjectWithMinus() {
		Assert.assertEquals(card1, ccc.getAsObject(null, null, creditCardNumber.replaceAll(" ", "-")));
	}

	@Test(expected = ConverterException.class)
	public void getAsObjectWrongSeparator() {
		Assert.assertEquals(card1, ccc.getAsObject(null, null, creditCardNumber.replaceAll(" ", "+")));
	}

	@Test(expected = ConverterException.class)
	public void getAsObjectWrongSize() {
		Assert.assertEquals(card1, ccc.getAsObject(null, null, "123456789"));
	}

	@Test
	public void getAsString() {
		Assert.assertEquals(creditCardNumber, ccc.getAsString(null, null, card1));
	}
}
