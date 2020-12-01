package com.frame.core.domain.post.service;

import com.frame.core.domain.post.dto.*;

public interface PostService {
    public void createPost(CreatePostRequest request);

    public void comment(CommentRequest request);

    public void sympathize(SympathizeRequest request);

    public GetPostsResponse getPosts(String sortType);

    public GetPostsResponse getUserPosts(String email);

    public GetPostsResponse getMyPosts(String accessType);

    public GetSympatheticPostsResponse getSympatheticPosts();

    public GetPostDetailResponse getPostDetail(Long postId);

    public void updatePost(UpdatePostRequest request);

    public void deletePost(DeletePostRequest request);

    public void deleteComment(DeleteCommentRequest request);

    public GetPostsResponse getHighlightPost();

    public GetPostsResponse getPostsWithSearch(String q);
}
