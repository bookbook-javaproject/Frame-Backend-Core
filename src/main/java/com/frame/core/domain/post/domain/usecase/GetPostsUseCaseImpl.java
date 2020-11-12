package com.frame.core.domain.post.domain.usecase;

import com.frame.core.domain.post.domain.entity.Post.Post;
import com.frame.core.domain.post.domain.entity.Post.PostDetail;
import com.frame.core.domain.post.domain.repository.PostDetailRepository;
import com.frame.core.domain.post.domain.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;


@Component
@RequiredArgsConstructor
public class GetPostsUseCaseImpl implements GetPostsUseCase {
    private final PostRepository postRepository;
    private final PostDetailRepository postDetailRepository;

    @Override
    public Iterable<Post> execute(String sortType) {
        if (sortType.equals("recency")) {
            return postRepository.findAllByAccessType_Public();

//            for (Post post: allPosts) {
//                postDetailRepository.findById(post.getPostNumber()).ifPresent(
//                        postDetail -> {
//                            posts.put(post, postDetail);
//                        }
//                );
//            }
        } else {
            // TODO 필터 추가
        }
    }
}
