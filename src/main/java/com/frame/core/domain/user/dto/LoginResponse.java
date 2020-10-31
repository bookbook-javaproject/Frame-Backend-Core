package com.frame.core.domain.user.dto;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class LoginResponse {
    private String accessToken;

    private String refreshToken;
}
