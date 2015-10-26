package br.com.caelum.vraptor.annotation;

import static java.lang.annotation.ElementType.METHOD;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({METHOD})
@Retention(RetentionPolicy.SOURCE)
public @interface View {
	
}

