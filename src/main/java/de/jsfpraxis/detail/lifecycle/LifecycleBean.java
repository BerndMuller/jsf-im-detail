package de.jsfpraxis.detail.lifecycle;

import javax.enterprise.context.RequestScoped;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlOutputText;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Named;
import java.util.logging.Logger;

@Named
@RequestScoped
public class LifecycleBean {

	private static final Logger log = Logger.getLogger(LifecycleBean.class.getCanonicalName());
	
	private Integer input;
	private Integer output;
	
	private HtmlInputText inputComponent;
	private HtmlOutputText outputComponent;
	
	public LifecycleBean() {
	}

	public void assign() {
		log.info("action() called. set 'output' to value of 'input'");
		output = input;
	}
	
    public void inputChanged(ValueChangeEvent event) {
        log.info("change old value '" + event.getOldValue() + "' to new value '" + event.getNewValue() + "'");
    }
    
	// getter and setter
	public Integer getInput() {
		log.info("getInput() returns " + input);
		return input;
	}
	public void setInput(Integer input) {
		log.info("setInput(" + input + ")");
		this.input = input;
	}

	
	public Integer getOutput() {
		log.info("getOutput() returns " + output);
		return output;
	}
	public void setOutput(Integer output) {
		log.info("setOutput(" + output + ")");
		this.output = output;
	}

	
	public HtmlInputText getInputComponent() {
		log.info("getInputComponent() returns " + inputComponent);
		return inputComponent;
	}
	public void setInputComponent(HtmlInputText inputComponent) {
		log.info("setInputComponent(" + inputComponent + ")");
		this.inputComponent = inputComponent;
	}

	
	public HtmlOutputText getOutputComponent() {
		log.info("getOutputComponent() returns " + outputComponent);
		return outputComponent;
	}
	public void setOutputComponent(HtmlOutputText outputComponent) {
		log.info("setOutputComponent(" + outputComponent + ")");
		this.outputComponent = outputComponent;
	}


}
