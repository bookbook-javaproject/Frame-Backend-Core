package com.frame.core.domain.post.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PostPreview {
    private Long postId;

    private String writerEmail;

    private String createdAt;

    private String content;

    private Long hearts;

    private Long comments;
}
