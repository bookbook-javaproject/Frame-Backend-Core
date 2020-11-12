package com.frame.core.domain.post.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class PostPreview {
    private Long postId;

    private String writerEmail;

    private LocalDateTime createdAt;

    private String content;

    private Long hearts;

    private Long comments;
}
