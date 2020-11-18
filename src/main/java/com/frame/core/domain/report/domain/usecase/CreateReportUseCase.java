package com.frame.core.domain.report.domain.usecase;

public interface CreateReportUseCase {
    public void execute(String email, Long postId, String content);
}
