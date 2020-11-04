package com.frame.core.domain.user.domain.usecase;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FollowUserUseCaseImpl implements FollowUserUseCase {
    @Override
    public void execute(String email, String followEmail) {

    }
}
