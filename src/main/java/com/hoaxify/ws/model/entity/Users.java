package com.hoaxify.ws.model.entity;


import com.hoaxify.ws.validation.UniqueUsername;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Users {
    @Id
    @GeneratedValue
    private Long id;
    @NotNull
    @NotEmpty
    @Size(min=4, max = 255)
    @UniqueUsername
    private String username;
    @NotNull
    @NotEmpty
    @Size(min=4, max = 255)
    private String displayName;
    private String email;
    @NotEmpty
    @NotNull
    @Size
    @Size(min=4, max = 255)
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$")
    private String password;
}
