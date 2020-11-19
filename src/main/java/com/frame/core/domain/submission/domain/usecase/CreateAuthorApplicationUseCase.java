package com.frame.core.domain.submission.domain.usecase;

public interface CreateAuthorApplicationUseCase {
    public void execute(String email, String link, String goal);
}
