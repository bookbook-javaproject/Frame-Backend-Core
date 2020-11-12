package com.frame.core.domain.user.domain.usecase;

import com.frame.core.domain.user.domain.repository.RelationshipRepository;
import com.frame.core.global.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GetFollowerUseCaseImpl implements GetFollowerUseCase {
    private final RelationshipRepository relationshipRepository;

    @Override
    public List<String> execute(String email) {
        return relationshipRepository.findByEmail(email).orElseThrow(NotFoundException::new).getFollower();
    }
}
