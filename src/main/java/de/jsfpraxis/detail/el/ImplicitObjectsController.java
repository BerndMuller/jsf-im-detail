package de.jsfpraxis.detail.el;

import java.util.Map;

import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.HeaderMap;
import javax.faces.annotation.InitParameterMap;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named("ioc")
@RequestScoped
public class ImplicitObjectsController {

	@Inject
	FacesContext facesContext;
	
	@Inject
	@HeaderMap
	Map<String, String> header;
	
	@Inject
	UIViewRoot view;
	
	@Inject
	@InitParameterMap
	Map<String, String> initParam;

	public ImplicitObjectsController() {
	}

	public Map<String, String> getHeader() {
		//header.forEach((k, v) -> System.out.println((k + ":" + v)));
		return header;
	}

	public UIViewRoot getView() {
		return view;
	}
	
	public Map<String, String> getInitParam() {
		return initParam;
	}

	public String getStateSavingMethod() {
		// identisch zu initParam..get('javax.faces.STATE_SAVING_METHOD')
		return facesContext.getApplication().getStateManager().isSavingStateInClient(facesContext) ? "client" : "server";
	}
	
}
