package de.jsfpraxis.detail.events;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ValueChangeEvent;
import javax.faces.event.ValueChangeListener;
import javax.inject.Named;

@Named("ccl")
public class CustomerChangedListener implements ValueChangeListener {

	private static final Logger logger = Logger.getLogger(CustomerChangedListener.class.getCanonicalName());
	
	public CustomerChangedListener() {
		logger.info("erzeugt");
	}


	@Override
	public void processValueChange(ValueChangeEvent event) throws AbortProcessingException {
		logger.info(event.getComponent().toString());
		logger.info("Client-Id: " + event.getComponent().getClientId());
		logger.info("Id: " + event.getComponent().getId());
		logger.info("Old Value: " + event.getOldValue());
		logger.info("New Value: " + event.getNewValue());
	}

	
	@PostConstruct
	public void init() {
		logger.info("erzeugt in init()");
	}
}
