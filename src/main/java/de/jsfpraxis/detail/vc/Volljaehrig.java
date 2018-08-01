package de.jsfpraxis.detail.vc;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = VolljaehrigValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Volljaehrig {
	
	String message() default "Nicht volljährig"; // Fehlermeldung besser mit Resource-Bundle
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
	
}
