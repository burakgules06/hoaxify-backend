package com.hoaxify.ws.controller;
import com.hoaxify.ws.error.ApiError;
import com.hoaxify.ws.exception.NotUniqueMailException;
import com.hoaxify.ws.model.entity.Users;
import com.hoaxify.ws.service.UserService;
import com.hoaxify.ws.shared.GenericResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/api/1.0/users")
    public GenericResponse createUser(@Valid @RequestBody Users user){
        userService.saveUser(user);
        return new GenericResponse("User Created");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError handleValidationException(MethodArgumentNotValidException exception){
        ApiError error = new ApiError(400,"Validation Error", "/api/1.0/users");
        Map<String, String> validationErrors = new HashMap<>();
        for(FieldError fieldError : exception.getBindingResult().getFieldErrors()){
            validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        //var validationErrors = exception.getBindingResult().getFieldErrors().stream().collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
        error.setValidationErrors(validationErrors);
        return error;
    }

    @ExceptionHandler(NotUniqueMailException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError handleMailValidationException(NotUniqueMailException exception){
        ApiError error = new ApiError(400,"Validation Error", "/api/1.0/users");
        Map<String, String> validationErrors = new HashMap<>();
        validationErrors.put("email", "E-mail already taken");
        //var validationErrors = exception.getBindingResult().getFieldErrors().stream().collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
        error.setValidationErrors(validationErrors);
        return error;
    }
}
