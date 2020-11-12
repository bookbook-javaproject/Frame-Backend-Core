package com.frame.core.domain.post.domain.usecase;

import com.frame.core.domain.post.domain.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

public interface DeletePostDetailUseCase {
    public void execute(String email,Long postId);
}
