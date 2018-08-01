package de.jsfpraxis.detail.vc;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("emailValidator")
public class EmailValidator implements Validator<String> {

	@Override
	public void validate(FacesContext context, UIComponent component, String email) throws ValidatorException {
		if (email == null || email.isEmpty()) {
			return; // sollte @NotNull oder RequiredValidator pruefen
		}
		if (! email.matches(".+@.+\\..+")) {
			throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Fehlerhafte E-Mail-Syntax", "Fehlerhafte E-Mail-Syntax"));
		}
		
	}

}
