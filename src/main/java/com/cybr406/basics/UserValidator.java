package com.cybr406.basics;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserValidator implements Validator
{
    @Override
    public boolean supports(Class<?> clazz)
    {
        clazz.equals(User.class);
        return false;
    }

    @Override
    public void validate(Object target, Errors errors)
    {
        ValidationUtils.rejectIfEmptyOrWhitespace(
                errors, "username", "field.required", "Username is a required field.");
        ValidationUtils.rejectIfEmptyOrWhitespace(
                errors, "password", "field.required", "Password is a required field.");
    }
}
