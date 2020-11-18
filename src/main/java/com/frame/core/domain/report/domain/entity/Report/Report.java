package com.frame.core.domain.report.domain.entity.Report;

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
@Table(name = "tbl_report")
@NoArgsConstructor
@AllArgsConstructor
public class Report {
    @Id
    @Column(name = "report_number")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reportNumber;

    @Column(name = "content", length = 1000)
    private String content;

    @Column(name = "post_number")
    private Long postNumber;

    @Column(name = "reporter")
    private String reporter;

    @Column(name = "created_at")
    @CreatedDate
    private LocalDateTime createdAt;
}
