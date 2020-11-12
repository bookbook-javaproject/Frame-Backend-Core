package com.frame.core.domain.post.dto;

import lombok.Getter;

@Getter
public class CreatePostRequest {
    private String content;

    private String contentType;

    private String accessType;
}
