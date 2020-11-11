package com.frame.core.domain.post.domain.entity.Post;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public class Comment {
    private String writer;

    private String comment;

    private LocalDateTime createdAt;
}
