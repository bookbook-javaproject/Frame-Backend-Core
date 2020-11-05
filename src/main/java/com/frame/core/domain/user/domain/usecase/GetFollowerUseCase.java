package com.frame.core.domain.user.domain.usecase;

import java.util.List;

public interface GetFollowerUseCase {
    public List<String> execute(String email);
}
