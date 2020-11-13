package com.frame.core.domain.post.service;

import com.frame.core.domain.post.domain.entity.Post.Post;
import com.frame.core.domain.post.domain.usecase.*;
import com.frame.core.domain.post.dto.*;
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
    private final GetCommentsUseCase getCommentsUseCase;
    private final GetHeartsUseCase getHeartsUseCase;

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
    public GetPostResponse getPosts(GetPostRequest request) {
        List<PostPreview> postPreviews = new ArrayList<PostPreview>();
        for (Post post : getPostsUseCase.execute(request.getSortType())) {
            postPreviews.add(PostPreview.builder()
            .postId(post.getPostNumber())
            .content(post.getContent())
            .comments((long) getCommentsUseCase.execute(post.getPostNumber()).size())
            .hearts((long) getHeartsUseCase.execute(post.getPostNumber()).size())
            .writerEmail(post.getWriter())
            .createdAt(post.getCreatedAt())
            .build());
        }
        return GetPostResponse.builder().posts(postPreviews).build();
    }

    @Override
    public GetPostDetailResponse getPostDetail(Long postId) {
        Post post = getPostDetailUseCase.execute(authenticationFacade.getEmail(), postId);
        return GetPostDetailResponse.builder()
                .postId(postId)
                .writer(post.getWriter())
                .content(post.getContent())
                .createdAt(post.getCreatedAt())
                .hearts(getHeartsUseCase.execute(postId))
                .comments(getCommentsUseCase.execute(postId))
                .build();
    }

    @Override
    public void updatePost(UpdatePostRequest request) {
        updatePostUseCase.execute(authenticationFacade.getEmail(), request);
    }
}
