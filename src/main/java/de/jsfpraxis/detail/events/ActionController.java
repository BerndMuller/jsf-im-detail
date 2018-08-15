package de.jsfpraxis.detail.events;

import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

@Named
@RequestScoped
public class ActionController {
	
	private static Logger logger = Logger.getLogger(ActionController.class.getCanonicalName());

	private String text;
	private String message;
	
	public ActionController() {
	}

	public void myActionListener(ActionEvent event) {
		message = "Action-Listener aufgerufen mit '" + text + "'";
		logger.info(message);
	}


	public void myActionMethod() {
		message = "Action-Methode aufgerufen mit '" + text + "'";
		logger.info(message);
	}
	
	public void actionMethodWithParam(Integer i) {
		message = "Parametrisierte Action-Methode aufgerufen mit '" + text + "' und Parameter '" + i + "'";
		logger.info(message);
	}
	
	public Integer[] getParams() {
		return new Integer[] {1,2,3,4,5,6,7,8,9,10};
	}
	
	// Getter und Setter
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
