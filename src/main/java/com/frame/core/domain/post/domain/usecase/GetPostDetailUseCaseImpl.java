package com.frame.core.domain.post.domain.usecase;

import com.frame.core.domain.post.domain.entity.Post.Post;
import com.frame.core.domain.post.domain.entity.Post.enums.AccessType;
import com.frame.core.domain.post.domain.repository.PostRepository;
import com.frame.core.domain.user.domain.exception.UnAuthorizedException;
import com.frame.core.global.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class GetPostDetailUseCaseImpl implements GetPostDetailUseCase {
    private final PostRepository postRepository;

    @Override
    public Post execute(String email, Long postNumber) {
        Optional<Post> optionalPost = postRepository.findById(postNumber);

        optionalPost.ifPresent((
                post -> {
                    Boolean isPrivate = post.getAccessType().equals(AccessType.PRIVATE);
                    if ((isPrivate && !email.equals(post.getWriter()))) {
                        throw new UnAuthorizedException();
                    }
                }));
        return optionalPost.orElseThrow(NotFoundException::new);
    }
}
