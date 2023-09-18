package com.hoaxify.ws.model.entity;


import com.hoaxify.ws.validation.UniqueUsername;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"email"}))
public class Users {
    @Id
    @GeneratedValue
    private Long id;
    @NotBlank(message = "{hoaxify.constraint.username.notblank}")
    //@Size(min=4, max = 255)
    @UniqueUsername
    private String username;
    @NotNull
    @NotEmpty
    @Size(min=3, max = 255)
    private String displayName;

    @Email
    @NotBlank
    private String email;
    @NotEmpty
    @NotNull
    @Size(min=4, max = 255)
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$")
    private String password;
}
