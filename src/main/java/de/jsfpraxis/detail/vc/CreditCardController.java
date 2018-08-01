package de.jsfpraxis.detail.vc;

import javax.enterprise.context.RequestScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Named;

@Named("ccc")
@RequestScoped
public class CreditCardController {
	
	private CreditCard creditCard1;
	private CreditCard creditCard2;
	private CreditCard creditCard3;
	private CreditCard creditCardSelected;

	public CreditCardController() {
	}

	public void ajaxBehaviorListener(AjaxBehaviorEvent event) {
		System.out.println("huhu");
		System.out.println("Ajax: " + event.getComponent().getParent().getClientId());
		switch(event.getComponent().getParent().getClientId()) {
		case "form:alt1":
			creditCardSelected = creditCard1;
			break;
		case "form:alt2":
			creditCardSelected = creditCard2;
			break;
		case "form:alt3":
			creditCardSelected = creditCard3;
			break;
		default:
		}
	}

	// Getter und Setter
	public CreditCard getCreditCard1() {
		return creditCard1;
	}
	public void setCreditCard1(CreditCard creditCard1) {
		this.creditCard1 = creditCard1;
	}
	
	public CreditCard getCreditCard2() {
		return creditCard2;
	}
	public void setCreditCard2(CreditCard creditCard2) {
		this.creditCard2 = creditCard2;
	}

	public CreditCard getCreditCard3() {
		return creditCard3;
	}
	public void setCreditCard3(CreditCard creditCard3) {
		this.creditCard3 = creditCard3;
	}

	public CreditCard getCreditCardSelected() {
		return creditCardSelected;
	}
	public void setCreditCardSelected(CreditCard creditCardSelected) {
		this.creditCardSelected = creditCardSelected;
	}

}
