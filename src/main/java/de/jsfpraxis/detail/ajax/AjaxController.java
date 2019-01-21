package de.jsfpraxis.detail.ajax;

import java.io.Serializable;
import java.util.Objects;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class AjaxController implements Serializable {
	
	private static final Logger logger = Logger.getLogger(AjaxController.class.getCanonicalName());
	private static final long serialVersionUID = 1L;
	
	private Customer customer;

	public AjaxController() {
		customer = new Customer();
	}
	
	public void save() {
		logger.info("saved: " + customer);
	}
	
	/**
	 * Whole name of customer. 
	 * 
	 * @return whole name of customer, i.e. 'firstname blank lastname' 
	 */
	public String wholeCustomerName() {
		return (Objects.isNull(customer.getFirstName()) ? "" : customer.getFirstName())
				+ " "
				+ (Objects.isNull(customer.getLastName()) ? "" : customer.getLastName());
	}
	
	public void ajaxListener(AjaxBehaviorEvent event) {
		logger.info("Ajax-Event von Komponente " + event.getComponent().getId());
	}
	
	
	@PostConstruct
	public void init() {
		logger.info("New instance created");
	}

	// Getter und Setter
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
