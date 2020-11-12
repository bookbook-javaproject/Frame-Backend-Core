package com.frame.core.domain.user.dto;

import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
public class LoginRequest {
    @Email
    private String email;

    @NotEmpty
    @Size(min = 6, max = 30)
    private String password;
}
