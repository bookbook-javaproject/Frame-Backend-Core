package com.frame.core.domain.post.domain.usecase;

import com.frame.core.domain.post.domain.entity.Post.Post;
import com.frame.core.domain.post.domain.entity.Post.PostDetail;
import com.frame.core.domain.post.domain.repository.PostDetailRepository;
import com.frame.core.domain.post.domain.repository.PostRepository;
import com.frame.core.global.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class GetSympatheticPostsUseCaseImpl implements GetSympatheticPostsUseCase {
    private final PostRepository postRepository;
    private final PostDetailRepository postDetailRepository;

    @Override
    public List<Post> execute(String email) {
        List<Post> posts = new ArrayList<Post>();

        for (PostDetail postDetail: postDetailRepository.findAll()) {
            if (postDetail.getHearts().contains(email)) {
                posts.add(postRepository.findById(postDetail.getPostNumber()).orElseThrow(
                        NotFoundException::new
                ));
            }
        }

        return posts;
    }
}
