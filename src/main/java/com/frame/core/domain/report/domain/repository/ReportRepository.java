package com.frame.core.domain.report.domain.repository;

import com.frame.core.domain.post.domain.entity.Post.Post;
import com.frame.core.domain.report.domain.entity.Report.Report;
import org.springframework.data.repository.CrudRepository;


public interface ReportRepository extends CrudRepository<Report, Long> {
}
