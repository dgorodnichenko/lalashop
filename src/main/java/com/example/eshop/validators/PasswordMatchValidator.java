package com.example.eshop.validators;

import com.example.eshop.annotations.PasswordMatches;
import com.example.eshop.payload.request.SignupRequest;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordMatchValidator implements ConstraintValidator<PasswordMatches, Object> {
    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        SignupRequest signupRequest = (SignupRequest) value;
        return signupRequest.getPassword().equals(signupRequest.getConfirmPassword());
    }

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {

    }
}
