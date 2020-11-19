package com.frame.core.domain.notice.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class NoticePreview {
    private String title;

    private String content;

    private LocalDateTime createdAt;
}
