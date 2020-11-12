package com.frame.core.domain.post.service;

import com.frame.core.domain.post.domain.usecase.CommentUseCase;
import com.frame.core.domain.post.domain.usecase.CreatePostUseCase;
import com.frame.core.domain.post.domain.usecase.SympathizeUseCase;
import com.frame.core.domain.post.dto.CommentRequest;
import com.frame.core.domain.post.dto.CreatePostRequest;
import com.frame.core.domain.post.dto.SympathizeRequest;
import com.frame.core.infra.springBoot.security.AuthenticationFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final AuthenticationFacade authenticationFacade;

    private final CreatePostUseCase createPostUseCase;
    private final CommentUseCase commentUseCase;
    private final SympathizeUseCase sympathizeUseCase;

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
}
