package com.frame.core.domain.post.domain.usecase;

import com.frame.core.domain.post.domain.entity.Post.Post;

public interface GetDetailPostUseCase {
    public Post execute(String email, Long postNumber);
}
