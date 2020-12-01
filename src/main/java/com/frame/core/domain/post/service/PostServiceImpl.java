package com.frame.core.domain.post.service;

import com.frame.core.domain.post.domain.entity.Post.Comment;
import com.frame.core.domain.post.domain.entity.Post.Post;
import com.frame.core.domain.post.domain.usecase.*;
import com.frame.core.domain.post.dto.*;
import com.frame.core.domain.user.domain.entity.User;
import com.frame.core.domain.user.domain.usecase.GetUserUseCase;
import com.frame.core.infra.springBoot.security.AuthenticationFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final AuthenticationFacade authenticationFacade;

    private final CreatePostUseCase createPostUseCase;
    private final CommentUseCase commentUseCase;
    private final SympathizeUseCase sympathizeUseCase;
    private final GetPostsUseCase getPostsUseCase;
    private final GetPostDetailUseCase getPostDetailUseCase;
    private final UpdatePostUseCase updatePostUseCase;
    private final DeletePostUseCase deletePostUseCase;
    private final GetCommentsUseCase getCommentsUseCase;
    private final GetHeartsUseCase getHeartsUseCase;
    private final GetUserPostUseCase getUserPostUseCase;
    private final GetSympatheticPostsUseCase getSympatheticPostsUseCase;
    private final GetTopPostUseCase getTopPostUseCase;
    private final GetPostPreviewUseCase getPostPreviewUseCase;
    private final SearchPostUseCase searchPostUseCase;
    private final GetUserUseCase getUserUseCase;

    @Override
    public void createPost(CreatePostRequest request) {
        createPostUseCase.execute(
                authenticationFacade.getEmail(),
                request.getContent(),
                request.getContentType(),
                request.getAccessType()
        );
    }

    @Override
    public void comment(CommentRequest request) {
        commentUseCase.execute(
                authenticationFacade.getEmail(),
                request.getPostId(),
                request.getComment()
        );
    }

    @Override
    public void sympathize(SympathizeRequest request) {
        sympathizeUseCase.execute(
                authenticationFacade.getEmail(),
                request.getPostId()
        );
    }

    @Override
    public GetPostsResponse getPosts(String sortType) {
        List<PostPreview> postPreviews = new ArrayList<PostPreview>();
        for (Post post : getPostsUseCase.execute(sortType)) {
            User user = getUserUseCase.execute(post.getWriter());
            postPreviews.add(PostPreview.builder()
            .postId(post.getPostNumber())
            .content(post.getContent())
            .comments((long) getCommentsUseCase.execute(post.getPostNumber()).size())
            .hearts(getHeartsUseCase.execute(post.getPostNumber()))
            .writer(UserPreview.builder()
                    .email(user.getEmail())
                    .nickname(user.getNickname())
                    .imageUri(user.getImageUri())
                    .build())
            .createdAt(post.getCreatedAt())
            .build());
        }
        return GetPostsResponse.builder().posts(postPreviews).build();
    }

    @Override
    public GetPostsResponse getMyPosts(String accessType) {
        List<PostPreview> postPreviews = new ArrayList<PostPreview>();
        for (Post post: getUserPostUseCase.execute(
                authenticationFacade.getEmail(), accessType)) {
            User user = getUserUseCase.execute(post.getWriter());
            postPreviews.add(PostPreview.builder()
                    .postId(post.getPostNumber())
                    .content(post.getContent())
                    .comments((long) getCommentsUseCase.execute(post.getPostNumber()).size())
                    .hearts(getHeartsUseCase.execute(post.getPostNumber()))
                    .writer(UserPreview.builder()
                            .email(user.getEmail())
                            .nickname(user.getNickname())
                            .imageUri(user.getImageUri())
                            .build())
                    .createdAt(post.getCreatedAt())
                    .build());
        }
        return GetPostsResponse.builder().posts(postPreviews).build();
    }

    @Override
    public GetPostsResponse getUserPosts(String email) {
        List<PostPreview> postPreviews = new ArrayList<PostPreview>();
        for (Post post: getUserPostUseCase.execute(
                email, "public")) {
            User user = getUserUseCase.execute(post.getWriter());
            postPreviews.add(PostPreview.builder()
                    .postId(post.getPostNumber())
                    .content(post.getContent())
                    .comments((long) getCommentsUseCase.execute(post.getPostNumber()).size())
                    .hearts(getHeartsUseCase.execute(post.getPostNumber()))
                    .writer(UserPreview.builder()
                            .email(user.getEmail())
                            .nickname(user.getNickname())
                            .imageUri(user.getImageUri())
                            .build())
                    .createdAt(post.getCreatedAt())
                    .build());
        }
        return GetPostsResponse.builder().posts(postPreviews).build();
    }

    @Override
    public GetSympatheticPostsResponse getSympatheticPosts() {
        List<PostPreview> postPreviews = new ArrayList<PostPreview>();
        for (Post post : getSympatheticPostsUseCase.execute(authenticationFacade.getEmail())) {
            User user = getUserUseCase.execute(post.getWriter());
            postPreviews.add(PostPreview.builder()
                    .postId(post.getPostNumber())
                    .content(post.getContent())
                    .comments((long) getCommentsUseCase.execute(post.getPostNumber()).size())
                    .hearts(getHeartsUseCase.execute(post.getPostNumber()))
                    .writer(UserPreview.builder()
                            .email(user.getEmail())
                            .nickname(user.getNickname())
                            .imageUri(user.getImageUri())
                            .build())
                    .createdAt(post.getCreatedAt())
                    .build());
        }
        return GetSympatheticPostsResponse.builder().posts(postPreviews).build();
    }

    @Override
    public GetPostDetailResponse getPostDetail(Long postId) {
        Post post = getPostDetailUseCase.execute(authenticationFacade.getEmail(), postId);
        User user = getUserUseCase.execute(post.getWriter());
        List<CommentPreview> commentPreviews = new ArrayList<CommentPreview>();
        for (Comment comment: getCommentsUseCase.execute(postId)) {
            User commentWriter = getUserUseCase.execute(comment.getWriter());
            commentPreviews.add(CommentPreview.builder()
                    .comment(comment.getComment())
                    .createdAt(comment.getCreatedAt())
                    .writer(UserPreview.builder()
                            .nickname(commentWriter.getNickname())
                            .email(commentWriter.getEmail())
                            .imageUri(commentWriter.getImageUri())
                            .build())
                    .build());
        }

        return GetPostDetailResponse.builder()
                .postId(postId)
                .writer(UserPreview.builder()
                    .email(user.getEmail())
                    .nickname(user.getNickname())
                    .imageUri(user.getImageUri())
                    .build())
                .content(post.getContent())
                .createdAt(post.getCreatedAt())
                .hearts(getHeartsUseCase.execute(postId))
                .comments(commentPreviews)
                .build();
    }

    @Override
    public void updatePost(UpdatePostRequest request) {
        updatePostUseCase.execute(
                authenticationFacade.getEmail(),
                request.getPostId(),
                request.getContent(),
                request.getAccessType(),
                request.getContentType()
        );
    }
  
    @Override
    public void deletePost(DeletePostRequest request) {
        deletePostUseCase.execute(authenticationFacade.getEmail(), request.getPostId());
    }

    @Override
    public GetPostsResponse getHighlightPost() {
        List<PostPreview> postPreviews = new ArrayList<PostPreview>();
        for (Long postId: getTopPostUseCase.execute()) {
            Post post = getPostPreviewUseCase.execute(postId);
            User user = getUserUseCase.execute(post.getWriter());
            postPreviews.add(PostPreview.builder()
            .writer(UserPreview.builder()
                    .email(user.getEmail())
                    .nickname(user.getNickname())
                    .imageUri(user.getImageUri())
                    .build())
            .hearts(getHeartsUseCase.execute(postId))
            .comments((long) getCommentsUseCase.execute(postId).size())
            .content(post.getContent())
            .postId(post.getPostNumber())
            .createdAt(post.getCreatedAt())
            .build());
        }
        return GetPostsResponse.builder().posts(postPreviews).build();
    }

    @Override
    public GetPostsResponse getPostsWithSearch(String q) {
        List<PostPreview> postPreviews = new ArrayList<PostPreview>();
        for (Post post: searchPostUseCase.execute(q)) {
            User user = getUserUseCase.execute(post.getWriter());
            postPreviews.add(PostPreview.builder()
                    .writer(UserPreview.builder()
                            .email(user.getEmail())
                            .nickname(user.getNickname())
                            .imageUri(user.getImageUri())
                            .build())
                    .hearts(getHeartsUseCase.execute(post.getPostNumber()))
                    .comments((long) getCommentsUseCase.execute(post.getPostNumber()).size())
                    .content(post.getContent())
                    .postId(post.getPostNumber())
                    .createdAt(post.getCreatedAt())
                    .build());
        }
        return GetPostsResponse.builder().posts(postPreviews).build();
    }
}
