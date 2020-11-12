package com.frame.core.domain.post.domain.entity.Post;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Builder
@Getter
@Document(collection = "col_post_detail")
public class PostDetail {
    @Id
    private Long postNumber;

    private List<String> hearts;

    private List<Comment> comments;
}
