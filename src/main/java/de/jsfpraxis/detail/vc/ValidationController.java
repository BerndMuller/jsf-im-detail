package de.jsfpraxis.detail.vc;

import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;

@Named("vc")
@RequestScoped
public class ValidationController {
	
	private static final Logger logger = Logger.getLogger(ValidationController.class.getCanonicalName());

	private String textValue;
	private Long longValue;
	private Double doubleValue;
	private String email;
	
	public String submit() {
		return null;
	}
	
	public void listener(AjaxBehaviorEvent event) {
		logger.info("textValue: " + textValue);
		logger.info("longValue: " + longValue);
		logger.info("doubleValue: " + doubleValue);
		logger.info("email: " + email);
	}

	public void validateEmail(FacesContext context, UIComponent component, Object email) throws ValidatorException {
		if (email == null) {
			return; // sollte @NotNull oder RequiredValidator pruefen
		}
		if (!((String) email).matches(".+@.+\\..+")) {
			throw new ValidatorException(new FacesMessage("Fehlerhafte E-Mail-Syntax"));
		}
	}
	
	// Getter und Setter
	public Double getDoubleValue() {
		return doubleValue;
	}
	public void setDoubleValue(Double doubleValue) {
		this.doubleValue = doubleValue;
	}

	public String getTextValue() {
		return textValue;
	}
	public void setTextValue(String textValue) {
		this.textValue = textValue;
	}

	public Long getLongValue() {
		return longValue;
	}
	public void setLongValue(Long longValue) {
		this.longValue = longValue;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

}
