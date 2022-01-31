package com.atmlocator.apigateway.model.validators;
/*
    Created by Labina on 30-Jan-22
*/
import com.atmlocator.apigateway.model.AuthSignupRequestVO;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator
        implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }
    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context){
        AuthSignupRequestVO user = (AuthSignupRequestVO) obj;
        context.disableDefaultConstraintViolation();
        context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate())
                .addPropertyNode( "matchingPassword" ).addConstraintViolation();
        return user.getPassword() != null && user.getMatchingPassword() != null && user.getPassword().equals(user.getMatchingPassword());
    }
}