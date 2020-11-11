package com.frame.core.domain.post.domain.usecase;

import com.frame.core.domain.post.domain.entity.Post.Comment;
import com.frame.core.domain.post.domain.repository.PostDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class CommentUseCaseImpl implements CommentUseCase {
    private final PostDetailRepository postDetailRepository;

    @Override
    public void execute(String writer, Long postId, String comment) {
        postDetailRepository.findById(postId).ifPresent(
                postDetail -> {
                    postDetail.getComments().add(
                            Comment.builder()
                            .comment(comment)
                            .writer(writer)
                            .createdAt(LocalDateTime.now())
                            .build()
                    );
                    postDetailRepository.save(
                            postDetail
                    );
                }
        );
    }
}
