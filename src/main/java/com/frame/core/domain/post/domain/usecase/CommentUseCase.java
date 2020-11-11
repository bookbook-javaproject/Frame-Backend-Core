package com.frame.core.domain.post.domain.usecase;

public interface CommentUseCase {
    public void execute(String writer, Long postId, String comment);
}
