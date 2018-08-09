package de.jsfpraxis.detail.vc;

import java.util.ResourceBundle;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.LengthValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;

@Named
@RequestScoped
public class CustomMessageController {

	private String text;

	public CustomMessageController() {
	}

	/**
	 * Dieser Validierer prüft für die Input-Komponente bei vorhandenem
	 * LengthValidator, ob Min/Max gerade so erreicht wurden und erzeugt dann
	 * eine Info-Message.
	 * 
	 * @param context FacesContext des Request
	 * @param component Eingabekomponente
	 * @param value Eingegebener Wert
	 * @throws ValidatorException Falls nicht valide
	 */
	public void validateText(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		int min = 0, max = 0;
		int length = ((String) value).length();
		Validator<?>[] validator = ((UIInput) component).getValidators();
		String bundleName = context.getApplication().getMessageBundle();
		ResourceBundle bundle = ResourceBundle.getBundle(bundleName);
		for (int i = 0; i < validator.length; i++) {
			if (validator[i] instanceof LengthValidator) {
				LengthValidator lv = (LengthValidator) validator[i];
				min = lv.getMinimum();
				max = lv.getMaximum();
				if (length == min || length == max) {
					String message = bundle.getString("de.jsfpraxis.MINMAX");
					String messageDetail = bundle.getString("de.jsfpraxis.MINMAX_detail");
					context.addMessage(component.getClientId(context),
							new FacesMessage(FacesMessage.SEVERITY_INFO,
									message, messageDetail));
				}
			}
		}
	}

	// Getter und Setter
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}

}
