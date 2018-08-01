package de.jsfpraxis.detail.lifecycle;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("demoValidator")
public class DemoValidator implements Validator<Integer> {

	@Override
	public void validate(FacesContext context, UIComponent component, Integer value) throws ValidatorException {
		if (1 <= value.intValue() && value.intValue() <= 100) {
			// is valid
		} else {
			throw new ValidatorException(new FacesMessage("nicht zwischen 1 und 100"));
		}
	}

}
