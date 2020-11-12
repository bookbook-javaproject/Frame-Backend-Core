package com.frame.core.domain.post.service;

import com.frame.core.domain.post.dto.*;

public interface PostService {
    public void createPost(CreatePostRequest request);

    public void comment(CommentRequest request);

    public void sympathize(SympathizeRequest request);

    public GetPostResponse getPosts(GetPostRequest request);

    public GetPostDetailResponse getPostDetail(Long postId);
}
