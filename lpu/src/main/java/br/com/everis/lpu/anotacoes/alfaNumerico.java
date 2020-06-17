package br.com.everis.lpu.anotacoes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.OverridesAttribute;
import javax.validation.Payload;
import javax.validation.constraints.Pattern;

@Target({ElementType.FIELD, ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
@Pattern(regexp = "([a-zA-Z]{3}[-]\\d{4})?")
public @interface alfaNumerico {
	
	@OverridesAttribute(constraint = Pattern.class, name="message")
	String message() default "Código deve seguir o padrão XXX-9999";
	
	Class<?>[]  groups() default {};
	Class<? extends Payload>[] payload() default {};
	
}
