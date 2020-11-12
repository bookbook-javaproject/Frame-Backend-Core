package com.frame.core.domain.post.domain.usecase;

import com.frame.core.domain.post.domain.entity.Post.Comment;

import java.util.List;

public interface GetCommentsUseCase {
    public List<Comment> execute(Long postId);
}
