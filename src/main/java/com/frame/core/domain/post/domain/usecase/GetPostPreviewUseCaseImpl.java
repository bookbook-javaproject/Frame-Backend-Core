package com.frame.core.domain.post.domain.usecase;

import com.frame.core.domain.post.domain.entity.Post.Post;
import com.frame.core.domain.post.domain.repository.PostRepository;
import com.frame.core.global.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetPostPreviewUseCaseImpl implements GetPostPreviewUseCase {
    private final PostRepository postRepository;

    @Override
    public Post execute(Long postId) {
        return postRepository.findById(postId).orElseThrow(NotFoundException::new);
    }
}
