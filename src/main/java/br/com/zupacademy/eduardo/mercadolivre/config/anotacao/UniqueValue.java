package br.com.zupacademy.eduardo.mercadolivre.config.anotacao;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import br.com.zupacademy.eduardo.mercadolivre.config.validacao.UniqueValueValidator;

@Documented
@Constraint(validatedBy = {UniqueValueValidator.class})
@Target({FIELD})
@Retention(RUNTIME)
public @interface UniqueValue {
        
	String message() default "o valor não pode ser duplicado";
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {}; 
	
	String fieldName();
	
	Class<?> domainClass();
}
