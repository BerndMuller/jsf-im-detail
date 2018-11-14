package de.jsfpraxis.detail.events;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.el.ValueExpression;
import javax.faces.application.FacesMessage;
import javax.faces.component.html.HtmlInputText;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named("cust2Controller") // Klasse gibts schon im Package vc
@ViewScoped
public class CustomerController implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(CustomerController.class.getCanonicalName());

	private Customer customer;
	
	@Inject
	FacesContext facesContext;

	public CustomerController() {
		customer = new Customer();
	}

	public void save() {
		logger.info("save() aufgerufen");
	}
	
	public void dataChanged(ValueChangeEvent event) {
		logger.info("dataChanged()");
		logger.info(event.getComponent().toString());
		logger.info("Client-Id: " + event.getComponent().getClientId());
		logger.info("Id: " + event.getComponent().getId());
		logger.info("Old Value: " + event.getOldValue());
		logger.info("New Value: " + event.getNewValue());
		logger.info("source " + event.getSource());
		facesContext.addMessage(null, new FacesMessage("Property " + event.getComponent().getId() + " wurde geändert."));
		logger.info("property: " + getPropertyForEvent(event));
	}

	/**
	 * Name des Propertys, das geändert wurde.
	 * 
	 * @param event auslösendes VCE
	 * @return Name des Propertys, das geändert wurde.
	 */
	private String getPropertyForEvent(ValueChangeEvent event) {
		HtmlInputText input= (HtmlInputText) event.getComponent();
		ValueExpression valueExpression = input.getValueExpression("value");
		String elString = valueExpression.getExpressionString();
		return elString.substring(elString.lastIndexOf(".") + 1, elString.length()-1).trim();
	}
	
	
	
		
	// Getter und Setter
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}
