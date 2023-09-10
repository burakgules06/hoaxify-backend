package com.hoaxify.ws.controller;


import com.hoaxify.ws.error.ApiError;
import com.hoaxify.ws.model.Users;
import com.hoaxify.ws.repository.UserRepository;
import com.hoaxify.ws.service.UserService;
import com.hoaxify.ws.shared.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/api/1.0/users")
    public ResponseEntity<?> createUser(@RequestBody Users users){
        String username = users.getUsername();
        if (username == null || username.isEmpty()){
            ApiError error = new ApiError(400,"Validation Error", "/api/1.0/users");
            Map<String, String> validationErrors = new HashMap<>();
            validationErrors.put("username", "Username cannot be null");
            error.setValidationErrors(validationErrors);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        }
        return ResponseEntity.ok(new GenericResponse("user created"));
    }
}
