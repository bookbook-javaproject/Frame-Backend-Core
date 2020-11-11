package com.frame.core.domain.post.domain.usecase;

public interface CreatePostUseCase {
    public void execute(String writer, String content, String contentType, String accessType);
}
