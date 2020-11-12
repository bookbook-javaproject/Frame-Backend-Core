package com.frame.core.domain.post.service;

import com.frame.core.domain.post.dto.CommentRequest;
import com.frame.core.domain.post.dto.CreatePostRequest;
import com.frame.core.domain.post.dto.SympathizeRequest;

public interface PostService {
    public void createPost(CreatePostRequest request);

    public void comment(CommentRequest request);

    public void sympathize(SympathizeRequest request);
}
