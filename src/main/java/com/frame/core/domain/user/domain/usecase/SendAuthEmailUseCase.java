package com.frame.core.domain.user.domain.usecase;

public interface SendAuthEmailUseCase {
    public void execute(String email);

    public void execute(String email, String nickName, String password);
}
