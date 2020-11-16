package com.frame.core.domain.post.dto;

import lombok.Getter;

import javax.validation.constraints.NotEmpty;

@Getter
public class UpdatePostRequest {
    private Long postId;

    @NotEmpty
    private String content;

    @NotEmpty
    private String contentType;

    @NotEmpty
    private String accessType;
}
