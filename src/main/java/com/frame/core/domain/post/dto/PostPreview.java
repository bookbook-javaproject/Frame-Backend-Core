package com.frame.core.domain.post.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Getter
public class PostPreview {
    private Long postId;

    private UserPreview writer;

    private LocalDateTime createdAt;

    private String content;

    private List<String> hearts;

    private Long comments;
}
