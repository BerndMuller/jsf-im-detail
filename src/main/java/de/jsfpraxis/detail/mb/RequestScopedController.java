package de.jsfpraxis.detail.mb;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.ManagedProperty;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class RequestScopedController {

	private static final Logger log = Logger.getLogger(RequestScopedController.class.getCanonicalName());

	
	@Inject
	@ManagedProperty("#{propertyProvider.message}")
	private String messageFromPropertyProvider;
	
	@Inject
	PropertyProvider propertyProvider;
	
	
	public RequestScopedController() {
	}

	@PostConstruct
	public void init() {
		log.info("@PostConstruct aufgerufen: " + this.getClass().getCanonicalName());
	}
	

	// Getter und Setter
	public String getMessageFromPropertyProvider() {
		return messageFromPropertyProvider;
	}

	public String getMessageFromPropertyProviderWithoutManagedProperty() {
		return propertyProvider.getMessage();
	}

}
