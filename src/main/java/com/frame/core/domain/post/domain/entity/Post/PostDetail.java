package com.frame.core.domain.post.domain.entity.Post;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "col_post_detail")
public class PostDetail {
    @Id
    private Integer postNumber;

    private List<String> hearts;

    private List<Comment> comments;
}
