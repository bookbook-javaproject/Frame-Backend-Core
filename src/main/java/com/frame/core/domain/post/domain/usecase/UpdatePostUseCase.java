package com.frame.core.domain.post.domain.usecase;

public interface UpdatePostUseCase {
    public void execute(String email, Long postId, String content, String accessType, String contentType);
}
