package com.frame.core.domain.user.dto;

import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
public class RegisterRequest {
    @Email
    private String email;

    @NotEmpty
    @Size(min = 1, max = 12)
    private String nickname;

    @NotEmpty
    @Size(min = 6, max = 30)
    private String password;
}
