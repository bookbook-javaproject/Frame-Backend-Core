package com.frame.core.domain.post.service;

import com.frame.core.domain.post.domain.entity.Post.Post;
import com.frame.core.domain.post.domain.entity.Post.PostDetail;
import com.frame.core.domain.post.domain.usecase.CommentUseCase;
import com.frame.core.domain.post.domain.usecase.CreatePostUseCase;
import com.frame.core.domain.post.domain.usecase.GetPostsUseCase;
import com.frame.core.domain.post.domain.usecase.SympathizeUseCase;
import com.frame.core.domain.post.dto.*;
import com.frame.core.infra.springBoot.security.AuthenticationFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final AuthenticationFacade authenticationFacade;

    private final CreatePostUseCase createPostUseCase;
    private final CommentUseCase commentUseCase;
    private final SympathizeUseCase sympathizeUseCase;
    private final GetPostsUseCase getPostsUseCase;

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
            .comments() // TODO
            .hearts() // TODO
            .writerEmail(post.getWriter())
            .createdAt(post.getCreatedAt())
            .build());
        }
        return GetPostResponse.builder().posts(postPreviews).build();
    }
}
