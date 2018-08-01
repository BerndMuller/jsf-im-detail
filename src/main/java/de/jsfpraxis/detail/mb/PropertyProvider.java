package de.jsfpraxis.detail.mb;

import javax.inject.Named;

/**
 * 
 * @author Bernd Müller
 *
 */
@Named
public class PropertyProvider {

	public PropertyProvider() {
	}

	public String getMessage() {
		return "This is the very important message from PropertyProvider";
	}
	
}
