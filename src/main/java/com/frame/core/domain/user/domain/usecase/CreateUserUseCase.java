package com.frame.core.domain.user.domain.usecase;

public interface CreateUserUseCase {
    public void run(String email, String nickname, String password);
}
