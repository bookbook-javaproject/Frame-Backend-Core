package com.frame.core.domain.report.domain.dto;

import lombok.Getter;

@Getter
public class CreateReportRequest {
    private Long postId;

    private String content;
}
