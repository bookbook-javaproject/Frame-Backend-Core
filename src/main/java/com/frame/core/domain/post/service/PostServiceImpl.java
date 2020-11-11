package com.frame.core.domain.post.service;

import com.frame.core.domain.post.domain.usecase.CreatePostUseCase;
import com.frame.core.domain.post.dto.CreatePostRequest;
import com.frame.core.infra.springBoot.security.AuthenticationFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final AuthenticationFacade authenticationFacade;

    private final CreatePostUseCase createPostUseCase;

    @Override
    public void createPost(CreatePostRequest request) {
        createPostUseCase.execute(
                authenticationFacade.getEmail(),
                request.getContent(),
                request.getContentType(),
                request.getAccessType()
        );
    }
}
