package com.frame.core.domain.user.domain.usecase;

import com.frame.core.domain.user.domain.exception.UnAuthorizedException;
import com.frame.core.domain.user.domain.repository.RelationshipRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FollowUserUseCaseImpl implements FollowUserUseCase {
    private final RelationshipRepository relationshipRepository;

    @Override
    public void execute(String email, String followEmail) {
        if (email.equals(followEmail)) throw new UnAuthorizedException();
        relationshipRepository.findByEmail(followEmail).ifPresent(
                relationship -> {
                    if (relationship.getFollower().contains(email)) {
                        relationshipRepository.findByEmail(email).ifPresent(
                                myRelationship -> {
                                    myRelationship.getFollowing().remove(followEmail);
                                    relationshipRepository.save(myRelationship);
                                }
                        );
                        relationship.getFollower().remove(email);
                        relationshipRepository.save(relationship);
                    } else {
                        relationshipRepository.findByEmail(email).ifPresent(
                                myRelationship -> {
                                    myRelationship.getFollowing().add(followEmail);
                                    relationshipRepository.save(myRelationship);
                                }
                        );
                        relationship.getFollower().add(email);
                        relationshipRepository.save(relationship);

                    }
                }
        );
    }
}
