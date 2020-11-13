package com.frame.core.domain.post.dto;

import lombok.Getter;

import javax.validation.constraints.NotEmpty;

@Getter
public class CreatePostRequest {
    @NotEmpty
    private String content;

    @NotEmpty
    private String contentType;

    @NotEmpty
    private String accessType;
}
