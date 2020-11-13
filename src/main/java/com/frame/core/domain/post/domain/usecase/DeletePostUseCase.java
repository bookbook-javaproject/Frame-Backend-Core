package com.frame.core.domain.post.domain.usecase;

public interface DeletePostUseCase {
    public void execute(String email, Long postId);
}
