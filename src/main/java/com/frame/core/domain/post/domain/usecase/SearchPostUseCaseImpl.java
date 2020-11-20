package com.frame.core.domain.post.domain.usecase;

import com.frame.core.domain.post.domain.entity.Post.Post;
import com.frame.core.domain.post.domain.entity.Post.enums.AccessType;
import com.frame.core.domain.post.domain.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SearchPostUseCaseImpl implements SearchPostUseCase {
    private final PostRepository postRepository;

    @Override
    public Iterable<Post> execute(String q) {
        return postRepository.findAllByContentLikeAndAccessType(q, AccessType.PUBLIC);
    }
}
