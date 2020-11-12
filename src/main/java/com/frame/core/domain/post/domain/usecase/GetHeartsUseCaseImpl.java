package com.frame.core.domain.post.domain.usecase;

import com.frame.core.domain.post.domain.repository.PostDetailRepository;
import com.frame.core.global.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@RequiredArgsConstructor
public class GetHeartsUseCaseImpl implements GetHeartsUseCase {
    private final PostDetailRepository postDetailRepository;

    @Override
    public List<String> execute(Long postId) {
        return postDetailRepository.findById(postId).orElseThrow(NotFoundException::new).getHearts();
    }
}
