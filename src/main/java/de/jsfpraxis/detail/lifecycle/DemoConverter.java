package de.jsfpraxis.detail.lifecycle;

import java.util.logging.Logger;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("demoConverter")
public class DemoConverter implements Converter<Integer> {
	
	private static final Logger log = Logger.getLogger(DemoConverter.class.getCanonicalName());

	@Override
	public Integer getAsObject(FacesContext context, UIComponent component, String  value) {
		log.info("getAsObject: " + value);
		return Integer.valueOf(value);
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Integer value) {
		log.info("getAsString: " + value);
		return null;
	}

}
