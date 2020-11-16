package com.frame.core.domain.post.service;

import com.frame.core.domain.post.dto.*;

public interface PostService {
    public void createPost(CreatePostRequest request);

    public void comment(CommentRequest request);

    public void sympathize(SympathizeRequest request);

    public GetPostsResponse getPosts(String sortType);

    public GetUserPostsResponse getUserPosts(String accessType);

    public GetSympatheticPostsResponse getSympatheticPosts();

    public GetPostDetailResponse getPostDetail(Long postId);

    public void updatePost(UpdatePostRequest request);

    public void deletePost(DeletePostRequest request);
}
