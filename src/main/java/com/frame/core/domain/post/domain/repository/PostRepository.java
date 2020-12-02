package com.frame.core.domain.post.domain.repository;

import com.frame.core.domain.post.domain.entity.Post.Post;
import com.frame.core.domain.post.domain.entity.Post.enums.AccessType;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
    public Iterable<Post> findAllByAccessTypeOrderByPostNumberDesc(AccessType accessType);

    public Iterable<Post> findAllByAccessTypeAndWriter(AccessType accessType, String writer);

    public Iterable<Post> findAllByContentContainsAndAccessType(String content, AccessType accessType);
}
