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
public class GetTopPostUseCaseImpl implements GetTopPostUseCase {
    private final PostRepository postRepository;
    private final PostDetailRepository postDetailRepository;

    @Override
    public List<Long> execute() {
        List<Long> postIds = new ArrayList<Long>();

        for (PostDetail postDetail: postDetailRepository.findTop10ByOrderByHeartsDesc()) {
            postIds.add(postDetail.getPostNumber());
        }

        return postIds;
    }
}
