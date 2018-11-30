package de.jsfpraxis.detail.events;

import java.util.logging.Logger;

import javax.faces.event.AbortProcessingException;
import javax.faces.event.SystemEvent;
import javax.faces.event.SystemEventListener;

public class JsfReadyListener implements SystemEventListener {

	private static Logger log = Logger.getLogger(JsfReadyListener.class.getCanonicalName()); 
	
	public JsfReadyListener() {
		log.info("Konstruktor aufgerufen"); 	
	}

	@Override
	public boolean isListenerForSource(Object object) {
		log.info("isListenerForSource() aufgerufen: " + object.getClass().getCanonicalName()); 
		return true;
	}

	@Override
	public void processEvent(SystemEvent se) throws AbortProcessingException {
		log.info("processEvent() aufgerufen: " + se.getClass().getCanonicalName()); 
	}

}
