package de.jsfpraxis.detail.el;

import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named("iaController")
@RequestScoped
public class ImmediateActionController {
	
	private static final Logger logger = Logger.getLogger(ImmediateActionController.class.getCanonicalName());

	//@NotNull
	private String data;
	
	public ImmediateActionController() {
	}

	public String save() {
		logger.info("save() aufgerufen");
		return null;
	}
	
	public String abort() {
		logger.info("abort() aufgerufen");
		return null;
	}

	// Getter und Setter
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
}
