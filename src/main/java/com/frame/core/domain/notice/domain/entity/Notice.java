package com.frame.core.domain.notice.domain.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Builder
@Getter
@Table(name = "tbl_notice")
@NoArgsConstructor
@AllArgsConstructor
public class Notice {
    @Id
    @Column(name = "notice_number")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long noticeNumber;

    @Column(name = "title", length = 255)
    private String title;

    @Column(name = "content", length = 1000)
    private String content;

    @Column(name = "created_at")
    @CreatedDate
    private LocalDateTime createdAt;
}
