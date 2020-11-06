package com.frame.core.domain.post.domain.entity.Post;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_post")
public class Post {
    @Id
    @Column(name = "post_number")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postNumber;

    @Column(name = "content", length = 1000)
    private String content;

    @Column(name = "writer", length = 255)
    private String writer;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
