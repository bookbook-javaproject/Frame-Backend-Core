package com.frame.core.domain.user.domain.usecase;

import java.util.List;

public interface GetFollowingUseCase {
    public List<String> execute(String email);
}
