package com.frame.core.domain.report.domain.repository;

import com.frame.core.domain.post.domain.entity.Post.Post;
import com.frame.core.domain.report.domain.entity.Report.Report;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReportRepository extends CrudRepository<Report, Long> {
    Iterable<Report> findAllByPostNumber(Long postNumber);
}
