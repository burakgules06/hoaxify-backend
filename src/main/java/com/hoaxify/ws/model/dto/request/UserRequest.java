package com.hoaxify.ws.model.dto.request;

import com.hoaxify.ws.validation.UniqueUsername;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;

public class UserRequest {
    @Size(min=4, max = 255)
    @UniqueUsername
    @NotBlank
    private String username;

    @Size(min=3, max = 255)
    @NotBlank
    private String displayName;

    @Email
    @NotBlank
    private String email;
    @NotBlank
    @Size(min=4, max = 255)
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$")
    private String password;
}
