package de.jsfpraxis.detail.mb;

import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@SuppressWarnings("serial")
@Named
@ViewScoped
public class ViewScopedController implements Serializable {

	public ViewScopedController() {
	}

	public String reload() {
		return null;
	}
}
