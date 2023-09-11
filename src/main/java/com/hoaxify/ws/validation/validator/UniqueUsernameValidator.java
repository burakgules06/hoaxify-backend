package com.hoaxify.ws.validation.validator;

import com.hoaxify.ws.model.entity.Users;
import com.hoaxify.ws.repository.UserRepository;
import com.hoaxify.ws.validation.UniqueUsername;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

    @Autowired
    UserRepository userRepository;
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        Users user = userRepository.findByUsername(s);
        return user == null;
    }
}
