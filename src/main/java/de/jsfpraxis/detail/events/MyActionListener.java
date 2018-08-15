package de.jsfpraxis.detail.events;

import java.util.Iterator;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlInputTextarea;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;

public abstract class MyActionListener implements ActionListener {

	@Override
	public void processAction(ActionEvent ae) throws AbortProcessingException {
		HtmlInputTextarea textarea = null;
		List<UIComponent> components = ae.getComponent().getParent().getChildren();
		for (Iterator<UIComponent> iter = components.iterator(); iter.hasNext();) {
			UIComponent element = (UIComponent) iter.next();
			if (element.getId().equals("textarea")) {
				textarea = (HtmlInputTextarea) element;
			}
		}
		if (textarea.getValue() == null) {
			textarea.setValue("");
		}
		textarea.setValue(((String) textarea.getValue()).concat(
				"processAction() von " + this.getClass().getSimpleName() + " aufgerufen.\n"));
	}
	
}
