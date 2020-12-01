package com.frame.core.domain.post.domain.usecase;

import com.frame.core.domain.post.domain.repository.PostDetailRepository;
import com.frame.core.domain.user.domain.exception.UnAuthorizedException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteCommentUseCaseImpl implements DeleteCommentUseCase {
    private final PostDetailRepository postDetailRepository;

    @Override
    public void execute(String email, Long postId, int commentIndex) {
        postDetailRepository.findById(postId).ifPresent(
                postDetail -> {
                    if (postDetail.getComments().get(commentIndex).getWriter().equals(email)) {
                        postDetailRepository.save(postDetail.deleteComment(commentIndex));
                    } else throw new UnAuthorizedException();
                }
        );
    }
}
