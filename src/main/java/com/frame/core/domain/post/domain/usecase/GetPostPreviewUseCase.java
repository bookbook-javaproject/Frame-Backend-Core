package com.frame.core.domain.post.domain.usecase;

import com.frame.core.domain.post.domain.entity.Post.Post;

public interface GetPostPreviewUseCase {
    public Post execute(Long postId);
}
