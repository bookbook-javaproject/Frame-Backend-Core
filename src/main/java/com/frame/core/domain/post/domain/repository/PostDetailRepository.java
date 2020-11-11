package com.frame.core.domain.post.domain.repository;

import com.frame.core.domain.post.domain.entity.Post.PostDetail;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PostDetailRepository extends MongoRepository<PostDetail, Long> {
}
