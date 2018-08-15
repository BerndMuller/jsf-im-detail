package de.jsfpraxis.detail.events;

import java.util.logging.Logger;

import javax.faces.component.html.HtmlInputTextarea;
import javax.faces.context.FacesContext;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;

/**
 * Lösung der Aufgabe "Action-Listener mit UIComponent.findComponent()"
 *  
 * @author Bernd Müller
 *
 */
public class MyActionListenerWithFindComponent implements ActionListener {

	@Override
	public void processAction(ActionEvent ae) throws AbortProcessingException {
		HtmlInputTextarea textarea = (HtmlInputTextarea) FacesContext.getCurrentInstance().getViewRoot().findComponent("form:textarea");
		if (textarea == null) {
			Logger.getLogger(MyActionListenerWithFindComponent.class.getCanonicalName()).info("Textarea nicht gefunden");
			return;
		}
		if (textarea.getValue() == null) {
			textarea.setValue("");
		}
		textarea.setValue(((String) textarea.getValue()).concat(
				"processAction() von " + this.getClass().getSimpleName() + " aufgerufen.\n"));
	}
	
}
