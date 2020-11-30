package com.frame.core.domain.post.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;


@Builder
@Getter
public class UserPreview {
    private String email;

    private String nickname;

    private String imageUri;
}
