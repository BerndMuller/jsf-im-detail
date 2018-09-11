package de.jsfpraxis.detail.events;

import java.io.IOException;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Managed Bean zur Demonstration von ...
 * 
 * @author Bernd Müller
 *
 */
@Named("nc")
@RequestScoped
public class NavigationController {
	
	private static final Logger logger = Logger.getLogger(NavigationController.class.getCanonicalName());
	
	@Inject
	ExternalContext externalContext;
	
	public NavigationController() {
	}

	public void stay() {
		logger.info("'stay()' aufgerufen");
	}
	
	public String stayToo() {
		logger.info("'stayToo()' aufgerufen");
		return null;
	}
	
	public String toTarget() {
		logger.info("'toTarget()' aufgerufen");
		return "navigation-target.jsf";
	}

	public String toTargetWithRedirect() {
		logger.info("'toTarget()' aufgerufen");
		return "navigation-target.jsf?faces-redirect=true";
	}

	public void dasBuchImNetz() throws IOException {
		logger.info("ExternalContext: " + externalContext.getContext());
		externalContext.redirect("https://www.jsfpraxis.de");
	}
}
