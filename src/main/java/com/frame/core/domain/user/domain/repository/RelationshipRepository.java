package com.frame.core.domain.user.domain.repository;

import com.frame.core.domain.user.domain.entity.Relationship;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RelationshipRepository extends MongoRepository<Relationship, String> {
    Optional<Relationship> findByEmail(String email);
}
