package com.frame.core.domain.post.domain.entity.Post;

import com.frame.core.domain.post.domain.entity.Post.enums.AccessType;
import com.frame.core.domain.post.domain.entity.Post.enums.ContentType;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Builder
@Getter
@Table(name = "tbl_post")
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    @Id
    @Column(name = "post_number")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postNumber;

    @Setter
    @Column(name = "content", length = 1000)
    private String content;

    @Setter
    @Column(name = "content_type")
    @Enumerated(EnumType.STRING)
    private ContentType contentType;

    @Setter
    @Column(name = "access_type")
    @Enumerated(EnumType.STRING)
    private AccessType accessType;

    @Column(name = "writer", length = 255)
    private String writer;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
