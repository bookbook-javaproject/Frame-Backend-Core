package com.frame.core.domain.user.dto;


import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
public class ChangePasswordRequest {
    @NotEmpty
    @Size(min = 36, max= 36)
    private String authCode;

    @NotEmpty
    @Size(min = 6, max = 30)
    private String newPassword;
}
