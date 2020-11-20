package com.frame.core.domain.post.domain.usecase;

import com.frame.core.domain.post.domain.entity.Post.Post;

import java.util.List;

public interface GetTopPostUseCase {
    public List<Long> execute();
}
