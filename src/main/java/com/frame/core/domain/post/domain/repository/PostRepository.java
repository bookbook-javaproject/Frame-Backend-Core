package com.frame.core.domain.post.domain.repository;

import com.frame.core.domain.post.domain.entity.Post.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post, Long> {
    public Iterable<Post> findAllByAccessType_Public();
}
