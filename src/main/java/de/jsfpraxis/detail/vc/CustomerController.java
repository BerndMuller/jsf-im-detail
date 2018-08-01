package de.jsfpraxis.detail.vc;

import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class CustomerController {
	
	private static final Logger logger = Logger.getLogger(CustomerController.class.getCanonicalName());

	private Customer customer;

	public CustomerController() {
		customer = new Customer();
	}
	
	public String save() {
		logger.info("saved: " + customer);
		return "customer-ok.jsf?faces-redirect=true";
	}

	// Getter und Setter
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
}
