package com.frame.core.domain.post.domain.usecase;

import com.frame.core.domain.post.dto.UpdatePostRequest;

public interface UpdatePostUseCase {
    public void execute(String email, UpdatePostRequest request);
}
