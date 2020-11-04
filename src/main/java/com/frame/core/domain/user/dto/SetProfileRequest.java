package com.frame.core.domain.user.dto;

import lombok.Getter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter
public class SetProfileRequest {
    private String description;

    @NotEmpty
    @Size(min = 1, max = 12)
    private String nickname;

    private String favoriteType;

    private String imageUri;
}
