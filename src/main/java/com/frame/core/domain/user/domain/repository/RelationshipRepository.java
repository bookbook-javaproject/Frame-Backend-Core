package com.frame.core.domain.user.domain.repository;

import com.frame.core.domain.user.domain.entity.Relationship;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RelationshipRepository extends MongoRepository<Relationship, String> {

}
