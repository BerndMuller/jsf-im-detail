package de.jsfpraxis.detail.vc;

import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class CustomerBVController {
	
	private static final Logger logger = Logger.getLogger(CustomerBVController.class.getCanonicalName());

	private CustomerBV customer;
	private String validationGroup; // nur eine Gruppe

	public CustomerBVController() {
		customer = new CustomerBV();
		validationGroup = NichtVolljaehrigGruppe.class.getCanonicalName();
		//validationGroup = VolljaehrigGruppe.class.getCanonicalName();
	}
	
	public String save() {
		logger.info("saved: " + customer);
		return "customer-ok.jsf?faces-redirect=true";
	}

	// Getter und Setter
	public CustomerBV getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerBV customer) {
		this.customer = customer;
	}

	
	public String getValidationGroup() {
		return validationGroup;
	}
	
}
