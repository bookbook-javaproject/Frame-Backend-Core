package com.frame.core.domain.post.dto;

import lombok.Getter;

@Getter
public class UpdatePostRequest extends CreatePostRequest {
    private Long postId;
}
