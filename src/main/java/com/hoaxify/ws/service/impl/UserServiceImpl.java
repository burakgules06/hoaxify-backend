package com.hoaxify.ws.service.impl;

import com.hoaxify.ws.exception.NotUniqueMailException;
import com.hoaxify.ws.model.entity.Users;
import com.hoaxify.ws.repository.UserRepository;
import com.hoaxify.ws.service.UserService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService{
    UserRepository userRepository;
    PasswordEncoder passwordEncoder;
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }
    @Override
    public Users saveUser(Users users) {
        try {
            users.setPassword(passwordEncoder.encode(users.getPassword()));
            return userRepository.save(users);
        }
        catch (DataIntegrityViolationException e){
            throw new NotUniqueMailException();
        }
    }
}
