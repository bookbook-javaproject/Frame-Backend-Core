package com.frame.core.domain.post.domain.usecase;

import com.frame.core.domain.post.domain.entity.Post.Post;
import com.frame.core.domain.post.domain.entity.Post.PostDetail;

public interface GetPostsUseCase {
    public Iterable<Post> execute(String sortType);
}
