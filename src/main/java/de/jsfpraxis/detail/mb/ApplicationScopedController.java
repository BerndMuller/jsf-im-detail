package de.jsfpraxis.detail.mb;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named
@ApplicationScoped
public class ApplicationScopedController {
	
	private static final Logger log = Logger.getLogger(ApplicationScopedController.class.getCanonicalName());
	
	public ApplicationScopedController() {
	}
	
	@PostConstruct
	public void init() {
		log.info("@PostConstruct aufgerufen: " + this.getClass().getCanonicalName());
	}
}
