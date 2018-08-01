package de.jsfpraxis.detail.vc;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Controller zur Demonstration des immediate-Attributs bei Eingabekomponenten.
 * <p>
 * 
 * @author Bernd Müller
 *
 */
@Named("ic")
@RequestScoped
public class ImmediateController {

	private static Logger logger = Logger.getLogger(ImmediateController.class.getCanonicalName());
	
	private static final String LANG1 = "Deutsch";
	private static final String LANG2 = "Englisch";
	
	private String address;
	private String language = LANG1;
	private Map<String, String> addressLabels;
	private Map<String, String> languageLabels;

	@Inject
	FacesContext facesContext;

	
	public ImmediateController() {
		logger.info("Neuer ImmediateHandler erzeugt");
		addressLabels = new HashMap<String, String>(2);
		addressLabels.put(LANG1, "Anschrift");
		addressLabels.put(LANG2, "Address");
		languageLabels = new HashMap<String, String>(2);
		languageLabels.put(LANG1, "Sprache");
		languageLabels.put(LANG2, "Language");
	}

	public String save() {
		logger.info("save() aufgerufen");
		return null;
	}

	public void languageChanged(ValueChangeEvent vce) {
		logger.info("languageChanged() aufgerufen");
		logger.info("Neuer Wert: " + vce.getNewValue());
		language = (String) vce.getNewValue();
		facesContext.renderResponse();
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	
	
	public String[] getLanguages() {
		return new String[] { LANG1, LANG2};
	}

	
	public Map<String, String> getAddressLabels() {
		return addressLabels;
	}

	
	public Map<String, String> getLanguageLabels() {
		return languageLabels;
	}
	

}
