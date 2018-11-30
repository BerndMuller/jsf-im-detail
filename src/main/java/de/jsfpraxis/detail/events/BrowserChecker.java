package de.jsfpraxis.detail.events;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.HeaderMap;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.event.PreRenderComponentEvent;
import javax.faces.event.PreRenderViewEvent;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class BrowserChecker {
	
	private static Logger log = Logger.getLogger(BrowserChecker.class.getCanonicalName());
	
	@Inject
	UIViewRoot view;
	
	@Inject
	@HeaderMap
	Map<String, String> header;
	
	@Inject
	FacesContext facesContext;
	
	public BrowserChecker() {
	}

	public void preRenderView(ComponentSystemEvent event) {
		if (!event.getClass().equals(PreRenderViewEvent.class)) {
			return;
		}
		log.info("View aufgerufen: " + view.getViewId());
	}
	
    public void preRenderComponent(ComponentSystemEvent event) {
		if (!event.getClass().equals(PreRenderComponentEvent.class)) {
			return;
		}
    	if (view.getViewId().equals("/events/browser-check.xhtml")
    			&& event.getComponent().getId().equals("check")
    			&& isBrowserTooOld(header.get("User-Agent"))) {
    		facesContext.getApplication().getNavigationHandler().handleNavigation(facesContext, null, "/events/browser-too-old.xhtml?faces-redirect=true");
    	}
    }

    
    /**
     * Checks if browser is too old. Checking only Firefox and Chrome.
     * 
     * <p>
     * Parameter is like "... Firefox/63.0 ..." or "... Chrome/70.0.3538.102 ..."  
     * 
     * @param userAgent the user agent string 
     * @return true, if browser is too old, false otherwise
     */
	private boolean isBrowserTooOld(String userAgent) {
		Arrays.toString(userAgent.split(" "));
    	List<String> browsersWithVersion = Arrays.stream(userAgent.split(" ")).filter(str -> (str.startsWith("Firefox") || str.startsWith("Chrome/"))).collect(Collectors.toList());
    	for (String browserWithVersion : browsersWithVersion) {
    		switch (browserWithVersion.split("/")[0]) {
    			case "Firefox":
    				if (Integer.parseInt(browserWithVersion.split("/")[1].split("\\.")[0]) < 63) {
    					return true;
    				}
    				break;
    			case "Chrome":
    				if (Integer.parseInt(browserWithVersion.split("/")[1].split("\\.")[0]) < 71) {
    					return true;
    				}
    				break;
    		}
		}
    	return false;
	}

}
