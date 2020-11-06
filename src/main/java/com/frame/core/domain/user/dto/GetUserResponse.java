package com.frame.core.domain.user.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class GetUserResponse {
    private String email;

    private String nickname;

    private String imageUri;

    private String description;
}
