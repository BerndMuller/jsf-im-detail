package de.jsfpraxis.detail.i18n;

import java.util.Locale;

import org.junit.Assert;
import org.junit.Test;

public class LocaleConverterTest {
	
	private static final LocaleConverter lc = new LocaleConverter();

	@Test
	public void getAsObject() {
		Assert.assertEquals(Locale.GERMAN, lc.getAsObject(null, null, "de"));
	}
	
	@Test
	public void getAsString() {
		Assert.assertEquals("de", lc.getAsString(null, null, Locale.GERMAN));
	}
	
	
}
