package com.frame.core.domain.post.domain.usecase;

import com.frame.core.domain.post.domain.entity.Post.Post;

public interface GetUserPostUseCase {
    public Iterable<Post> execute(String email, String accessType);
}

