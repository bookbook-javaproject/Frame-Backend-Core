package com.frame.core.domain.user.domain.usecase;

public interface ChangePasswordUseCase {
    public void run(String email, String currentPassword, String newPassword);
}
