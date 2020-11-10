package com.frame.core.domain.post.domain.usecase;

import com.frame.core.domain.post.domain.entity.Post.Post;
import com.frame.core.domain.post.domain.entity.Post.enums.AccessType;
import com.frame.core.domain.post.domain.entity.Post.enums.ContentType;
import com.frame.core.domain.post.domain.repository.PostRepository;
import com.frame.core.domain.user.domain.entity.enums.FavoriteType;
import com.frame.core.global.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;


@RequiredArgsConstructor
public class CreatePostUseCaseImpl implements CreatePostUseCase {
    private final PostRepository postRepository;

    @Override
    public void execute(String writer, String content, String contentType, String accessType) {
        postRepository.save(
                Post.builder()
                .content(content)
                .accessType(generateAccessType(accessType))
                .contentType(generateContentType(contentType))
                .createdAt(LocalDateTime.now())
                .writer(writer)
                .build()
        );
    }

    private AccessType generateAccessType(String accessType) {
        if (accessType.equals("PRIVATE")) return AccessType.PRIVATE;
        if (accessType.equals("PUBLIC")) return AccessType.PUBLIC;
        throw new NotFoundException(); // TODO BAD REQUEST EXCEPTION
    }

    private ContentType generateContentType(String contentType) {
        if (contentType.equals("SENSIBILITY")) return ContentType.SENSIBILITY;
        if (contentType.equals("LIFE")) return ContentType.LIFE;
        if (contentType.equals("PHILOSOPHY")) return ContentType.PHILOSOPHY;
        if (contentType.equals("ROMANCE")) return ContentType.ROMANCE;
        throw new NotFoundException(); // TODO BAD REQ EXCEPTION
    }
}
