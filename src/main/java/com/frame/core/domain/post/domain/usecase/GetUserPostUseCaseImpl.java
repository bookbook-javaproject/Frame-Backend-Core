package com.frame.core.domain.post.domain.usecase;

import com.frame.core.domain.post.domain.entity.Post.Post;
import com.frame.core.domain.post.domain.entity.Post.enums.AccessType;
import com.frame.core.domain.post.domain.repository.PostRepository;
import com.frame.core.domain.user.domain.entity.User;
import com.frame.core.global.exceptions.BadRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class GetUserPostUseCaseImpl implements GetUserPostUseCase {
    private final PostRepository postRepository;

    @Override
    public Iterable<Post> execute(String email, String accessType) {
        return postRepository.findAllByAccessTypeAndWriter(generateAccessType(accessType), email);
    }

    private AccessType generateAccessType(String accessType) {
        if (accessType.equals("public")) return AccessType.PUBLIC;
        if (accessType.equals("private")) return AccessType.PRIVATE;
        throw new BadRequestException();
    }
}
