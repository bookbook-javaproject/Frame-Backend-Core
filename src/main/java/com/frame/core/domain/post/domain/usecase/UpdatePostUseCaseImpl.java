package com.frame.core.domain.post.domain.usecase;

import com.frame.core.domain.post.domain.entity.Post.Post;
import com.frame.core.domain.post.domain.entity.Post.enums.AccessType;
import com.frame.core.domain.post.domain.entity.Post.enums.ContentType;
import com.frame.core.domain.post.domain.repository.PostRepository;
import com.frame.core.domain.user.domain.exception.UnAuthorizedException;
import com.frame.core.global.exceptions.BadRequestException;
import com.frame.core.global.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UpdatePostUseCaseImpl implements UpdatePostUseCase {
    private final PostRepository postRepository;

    @Override
    public void execute(String email, Long postId, String content, String accessType, String contentType) {
        Optional<Post> optionalPost = postRepository.findById(postId);
        if (!optionalPost.isPresent()) {
            throw new NotFoundException();
        }
        Post post = optionalPost.get();
        if (!email.equals(post.getWriter())) {
            throw new UnAuthorizedException();
        }
        post.changeContent(content);
        post.changeAccessType(generateAccessType(accessType));
        post.changeContentType(generateContentType(contentType));

        postRepository.save(post);
    }

    private AccessType generateAccessType(String accessType) {
        if (accessType.equals("PRIVATE")) return AccessType.PRIVATE;
        if (accessType.equals("PUBLIC")) return AccessType.PUBLIC;
        throw new BadRequestException();
    }

    private ContentType generateContentType(String contentType) {
        if (contentType.equals("SENSIBILITY")) return ContentType.SENSIBILITY;
        if (contentType.equals("LIFE")) return ContentType.LIFE;
        if (contentType.equals("PHILOSOPHY")) return ContentType.PHILOSOPHY;
        if (contentType.equals("ROMANCE")) return ContentType.ROMANCE;
        throw new BadRequestException();
    }
}
