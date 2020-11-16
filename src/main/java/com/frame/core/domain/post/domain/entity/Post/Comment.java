package com.frame.core.domain.post.domain.entity.Post;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class Comment {
    private String writer;

    private String comment;

    private LocalDateTime createdAt;
}
