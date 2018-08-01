package de.jsfpraxis.detail.config;

import javax.annotation.PostConstruct;
import javax.el.ELContextEvent;
import javax.el.ELContextListener;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.Application;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 * Toggle für die CSS-Dateien section-print.css und section-web.css.
 * 
 * Wird verwendet, um Inhalt für Screenshots des Buches zu formatieren. 
 * 
 * @author Bernd Müller
 *
 */
@Named
@ApplicationScoped
public class PrintOrWebToggle {
	
	private static final String PRINT = "section-print.css";
	private static final String WEB = "section-web.css";
	
	private boolean toggle = true;

	public String getValue() {
		return toggle ? WEB : PRINT;
	}
	
	public void toggle() {
		toggle = !toggle;
	}
	
	
	// TODO warum geht das nicht?
	@PostConstruct
	public void init() {
		Application application = FacesContext.getCurrentInstance().getApplication();

		FacesContext.getCurrentInstance().getApplication().addELContextListener(new ELContextListener() {
	        @Override
	        public void contextCreated(ELContextEvent evt) {
	            evt.getELContext().getImportHandler()
	             .importClass("de.jsfpraxis.detail.config.PrintToggle");
	        }
	    });
	}

	
}
