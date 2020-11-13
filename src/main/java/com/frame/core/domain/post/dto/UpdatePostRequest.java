package com.frame.core.domain.post.dto;

import lombok.Getter;

import javax.validation.constraints.NotEmpty;

@Getter
public class UpdatePostRequest extends CreatePostRequest {
    private Long postId;
}
