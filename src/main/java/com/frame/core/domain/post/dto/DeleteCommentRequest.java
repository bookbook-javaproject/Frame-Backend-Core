package com.frame.core.domain.post.dto;

import lombok.Getter;

@Getter
public class DeleteCommentRequest {
    private Long postId;

    private int commentIndex;
}
