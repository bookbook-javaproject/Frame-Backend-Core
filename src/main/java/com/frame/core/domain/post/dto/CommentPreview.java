package com.frame.core.domain.post.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class CommentPreview {
    private UserPreview writer;

    private String comment;

    private LocalDateTime createdAt;
}

