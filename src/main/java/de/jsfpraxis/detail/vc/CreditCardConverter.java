package de.jsfpraxis.detail.vc;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 * JSF-Konvertierer für Kreditkartennummern.
 * <p>
 * Erlaubt sind 16 Ziffern oder 4 mal 4 Ziffern mit Leerzeichen oder Minus als Trenner, also z.B.
 * <ul>
 *   <li>1234234534564567</li>
 *   <li>1234 2345 3456 4567</li>
 *   <li>1234-2345-3456-4567</li>
 * </ul>
 * 
 */
@FacesConverter("creditcard")
//@FacesConverter(forClass = CreditCard.class)
//@FacesConverter(forClass = CreditCard.class, value = "creditcard") // Warnung im Log: @FacesConverter is using both value and forClass, only value will be applied
public class CreditCardConverter implements Converter<CreditCard> {
	
	private static final FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Keine Kreditkartennummer", "Keine Kreditkartennummer");
 

	@Override
	public CreditCard getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null) {
			return null;
		}
		// wir prüfen nur ein bisschen und lassen den Rest den Konstruktor machen
		CreditCard nummer = null;
		String[] quads = new String[] {};
		value = value.trim();
		if (value.indexOf('-') != -1) {
			quads = value.split("-");
		} else if (value.indexOf(' ') != -1) {
			quads = value.split(" ");
		} else if (value.length() == 16){
			quads = new String[] { value.substring(0, 4), value.substring(4, 8), value.substring(8, 12), value.substring(12, 16)};
		}
		if (quads.length != 4) {
			throw new ConverterException(message);
		}
		try {
			nummer = new CreditCard(quads[0], quads[1], quads[2], quads[3]);	
		} catch (Exception e) {
			throw new ConverterException(message);
		}
		return nummer;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, CreditCard value) {
		return value.toString();
	}

}
