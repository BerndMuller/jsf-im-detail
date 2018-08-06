package de.jsfpraxis.detail.vc.wb;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * 
 * @author Bernd Müller
 *
 */
public class PasswordValidator implements ConstraintValidator<Password, PasswordHolder> {
	
	@Inject
	FacesContext facesContext;

	@Override
	public boolean isValid(PasswordHolder passwordHolder, ConstraintValidatorContext context) {
		boolean result = passwordHolder.getPassword1().equals(passwordHolder.getPassword2());
		if (result) {
			facesContext.addMessage(null, new FacesMessage("Passwörter stimmen überein"));
		}
		return result;
	}

}
