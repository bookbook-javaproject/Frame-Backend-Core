package com.frame.core.domain.notice.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
public class NoticeResponse {
    private List<NoticePreview> notices;
}
