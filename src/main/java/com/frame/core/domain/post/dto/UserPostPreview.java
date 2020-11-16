package com.frame.core.domain.post.dto;


import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class UserPostPreview {
    private Long postId;

    private String content;

    private String writer;

    private LocalDateTime createdAt;
}
