package com.frame.core.domain.user.domain.usecase;

public interface ChangePasswordUseCase {
    public void execute(String authCode, String newPassword);
}
