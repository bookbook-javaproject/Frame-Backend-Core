package com.frame.core.domain.submission.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Builder
@Entity
@Table(name = "tbl_anthology_submission")
@NoArgsConstructor
@AllArgsConstructor
public class AnthologySubmission {
    @Id
    private String email;

    @Column(name = "link")
    private String link;

    @Column(name = "file_id")
    private String fileId;
}
