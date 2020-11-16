package com.frame.core.domain.post.domain.usecase;

import com.frame.core.domain.post.domain.entity.Post.Post;
import com.frame.core.domain.post.domain.repository.PostDetailRepository;
import com.frame.core.domain.post.domain.repository.PostRepository;
import com.frame.core.global.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class GetTopPostUseCaseImpl implements GetTopPostUseCase {
    private final PostRepository postRepository;
    private final PostDetailRepository postDetailRepository;

    @Override
    public Post execute() {
        return postRepository.findById(
                postDetailRepository.findTop10ByOrderByHearts().getPostNumber()
        ).orElseThrow(NotFoundException::new);
    }
}
