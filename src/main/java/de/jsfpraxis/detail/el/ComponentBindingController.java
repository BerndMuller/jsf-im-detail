package de.jsfpraxis.detail.el;

import javax.enterprise.context.RequestScoped;
import javax.faces.component.html.HtmlOutputText;
import javax.inject.Named;

@Named("cbController")
@RequestScoped
public class ComponentBindingController {

	HtmlOutputText output;

	public ComponentBindingController() {
	}

	public void change() {
		output.setValue("Ein anderer Text");
	}

	// Getter und Setter
	public HtmlOutputText getOutput() {
		return output;
	}
	public void setOutput(HtmlOutputText output) {
		this.output = output;
	}
	
}
