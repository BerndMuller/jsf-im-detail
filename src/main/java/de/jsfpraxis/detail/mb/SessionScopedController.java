package de.jsfpraxis.detail.mb;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.logging.Logger;

@SuppressWarnings("serial")
@Named
@SessionScoped
public class SessionScopedController implements Serializable {

	private static final Logger log = Logger.getLogger(SessionScopedController.class.getCanonicalName());
	
	public SessionScopedController() {
		log.info("Konstruktor aufgerufen: " + this.getClass().getCanonicalName());
	}

	@PostConstruct
	public void init() {
		log.info("@PostConstruct aufgerufen: " + this.getClass().getCanonicalName());
	}
	
}
