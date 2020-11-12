package com.frame.core.domain.post.domain.usecase;

import com.frame.core.domain.post.domain.entity.Post.Comment;
import com.frame.core.domain.post.domain.repository.PostDetailRepository;
import com.frame.core.global.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GetCommentsUseCaseImpl implements GetCommentsUseCase {
    private final PostDetailRepository postDetailRepository;

    @Override
    public List<Comment> execute(Long postId) {
        return postDetailRepository.findById(postId).orElseThrow(NotFoundException::new).getComments();
    }
}
