package de.jsfpraxis.detail.vc.wb;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * 
 * @author Bernd Müller
 *
 */
@Constraint(validatedBy = PasswordValidator.class)
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Password {

	String message() default "Passwörter stimmen nicht überein";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};

}
