package com.frame.core.domain.post.domain.usecase;


import java.util.List;

public interface GetHeartsUseCase {
    public List<String> execute(Long postId);
}
