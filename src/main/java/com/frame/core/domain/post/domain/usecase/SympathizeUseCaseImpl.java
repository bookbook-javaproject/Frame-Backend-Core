package com.frame.core.domain.post.domain.usecase;


import com.frame.core.domain.post.domain.repository.PostDetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SympathizeUseCaseImpl implements SympathizeUseCase {
    private final PostDetailRepository postDetailRepository;

    @Override
    public void execute(String email, Long postId) {
        postDetailRepository.findById(postId).ifPresent(
                postDetail -> {
                    if (postDetail.getHearts().contains(email)) {
                        postDetail.getHearts().remove(email);
                    } else {
                        postDetail.getHearts().add(email);
                    }
                    postDetailRepository.save(postDetail);
                }
        );
    }
}
