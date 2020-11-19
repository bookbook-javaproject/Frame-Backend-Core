package com.frame.core.domain.submission.domain.usecase;

public interface CreateAnthologyApplicationUseCase {
    public void execute(String email, String link, String fileId);
}
