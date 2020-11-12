package com.frame.core.domain.post.dto;

import lombok.Getter;

@Getter
public class CommentRequest {
    private Long postId;

    private String comment;
}
