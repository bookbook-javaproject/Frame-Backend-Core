package com.frame.core.domain.user.domain.usecase;

import com.frame.core.domain.user.domain.entity.Relationship;
import com.frame.core.domain.user.domain.entity.User;
import com.frame.core.domain.user.domain.exception.UserAlreadyExistsException;
import com.frame.core.domain.user.domain.repository.RelationshipRepository;
import com.frame.core.domain.user.domain.repository.UserRepository;
import com.frame.core.domain.user.domain.service.PasswordService;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
@RequiredArgsConstructor
public class CreateUserUseCaseImpl implements CreateUserUseCase {
    private final UserRepository userRepository;
    private final RelationshipRepository relationshipRepository;

    @Override
    public void execute(String email, String nickname, String password) {
        userRepository.findById(email).ifPresent(
            user -> { throw new UserAlreadyExistsException();}
        );

        userRepository.save(
                User.builder()
                .email(email)
                .nickname(nickname)
                .password(password)
                .build()
        );

        relationshipRepository.save(Relationship.builder().email(email)
                .follower(Collections.emptyList())
                .following(Collections.emptyList()).build());
    }
}
