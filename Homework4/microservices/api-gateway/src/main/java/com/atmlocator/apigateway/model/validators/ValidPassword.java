package com.atmlocator.apigateway.model.validators;
/*
    Created by Labina on 30-Jan-22
*/
import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE, FIELD, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = PasswordConstraintValidator.class)
@Documented
public @interface ValidPassword {
    String message() default "Password should contain at least 6 characters, one digit, one capital letter and one special character and no keyboard or alphabetical sequences!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
