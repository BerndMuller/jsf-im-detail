package de.jsfpraxis.detail.html5;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Named;


/**
 * Managed Bean zur Demonstration von Pass-Through-Attributes und Pass-Through-Elements.
 * 
 * @author Bernd Müller
 *
 */
@Named("ptc")
@RequestScoped
public class PassThroughController {
	
	private static final Logger log = Logger.getLogger(PassThroughController.class.getCanonicalName());
			
	private String email1;
	private String email2;
	private String email3;
	
	public PassThroughController() {
	}

	public String save() {
		log.info("Gespeicherte E-Mail-Adresse 1: " + email1);
		log.info("Gespeicherte E-Mail-Adresse 2: " + email2);
		log.info("Gespeicherte E-Mail-Adresse 3: " + email3);
		return null;
	}
	
	@SuppressWarnings("serial")
	public Map<String, Object> getAttributes() {
		return new HashMap<String, Object>() {{
			put("type", "email");
			put("placeholder", "E-Mail");
		}};
	}
	
	/**
	 * Listener, um Komponententyp eines Pass-Through-Elements zu bestimmen.
	 *  
	 * 
	 * @param event das auslösende Ajax-Event
	 */
	public void listener(AjaxBehaviorEvent event) {
		log.info("Komponente ist: " + event.getComponent().getClass().getCanonicalName());
	}

	
	// Getter und Setter
	public String getEmail1() {
		return email1;
	}
	public void setEmail1(String email1) {
		this.email1 = email1;
	}

	public String getEmail2() {
		return email2;
	}
	public void setEmail2(String email2) {
		this.email2 = email2;
	}

	public String getEmail3() {
		return email3;
	}
	public void setEmail3(String email3) {
		this.email3 = email3;
	}
	
}
