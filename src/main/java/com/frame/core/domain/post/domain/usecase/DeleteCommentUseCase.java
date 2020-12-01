package com.frame.core.domain.post.domain.usecase;

public interface DeleteCommentUseCase {
    public void execute(String email, Long postId, int commentIndex);
}
