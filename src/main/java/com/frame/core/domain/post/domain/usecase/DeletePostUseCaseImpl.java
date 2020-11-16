package com.frame.core.domain.post.domain.usecase;

import com.frame.core.domain.post.domain.entity.Post.Post;
import com.frame.core.domain.post.domain.repository.PostRepository;
import com.frame.core.domain.user.domain.exception.UnAuthorizedException;
import com.frame.core.global.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class DeletePostUseCaseImpl implements DeletePostUseCase {
    private final PostRepository postRepository;

    @Override
    public void execute(String email, Long postId) {
        Optional<Post> optionalPost = postRepository.findById(postId);
        if (!optionalPost.isPresent()) {
            throw new NotFoundException();
        }
        Post post = optionalPost.get();
        if (!email.equals(post.getWriter())) {
            throw new UnAuthorizedException();
        }
        postRepository.deleteById(postId);
    }
}
