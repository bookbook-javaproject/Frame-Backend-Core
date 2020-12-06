package com.frame.core.domain.post.domain.usecase;

import com.frame.core.domain.post.domain.entity.Post.Post;
import com.frame.core.domain.post.domain.entity.Post.PostDetail;
import com.frame.core.domain.post.domain.entity.Post.enums.AccessType;
import com.frame.core.domain.post.domain.repository.PostDetailRepository;
import com.frame.core.domain.post.domain.repository.PostRepository;
import com.frame.core.domain.user.domain.entity.User;
import com.frame.core.domain.user.domain.entity.enums.UserType;
import com.frame.core.domain.user.domain.repository.UserRepository;
import com.frame.core.global.exceptions.BadRequestException;
import com.frame.core.global.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.*;


@Component
@RequiredArgsConstructor
public class GetPostsUseCaseImpl implements GetPostsUseCase {
    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final PostDetailRepository postDetailRepository;

    @Override
    public Iterable<Post> execute(String sortType) {
        if (sortType.equals("recency")) {
            return postRepository.findAllByAccessTypeOrderByPostNumberDesc(AccessType.PUBLIC);
        } else {
            List<Post> authorPosts = new ArrayList<Post>();
            for (User user: userRepository.findAllByUserType(UserType.AUTHOR)) {
                authorPosts.addAll((Collection<? extends Post>) postRepository.findAllByWriter(user.getEmail()));
            }
            List<Post> commonPosts = new ArrayList<Post>();
            for (User user: userRepository.findAllByUserType(null)) {
                commonPosts.addAll((Collection<? extends Post>) postRepository.findAllByWriter(user.getEmail()));
            }

            authorPosts = sortPost(authorPosts);
            authorPosts.addAll(commonPosts);

            return authorPosts;
        }
    }

    private List<Post> sortPost(List<Post> posts) {
        posts.sort(Comparator.comparing(Post::getUpdatedAt));
        return posts;
    }
}
