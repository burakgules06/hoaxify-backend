package com.hoaxify.ws.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Users {
    @Id
    @GeneratedValue
    private Long id;
    private String username;
    private String displayName;
    private String email;
    private String password;
}
