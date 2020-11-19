package com.frame.core.domain.submission.domain.repository;

import com.frame.core.domain.submission.domain.entity.AuthorSubmission;
import org.springframework.data.repository.CrudRepository;

public interface AuthorSubmissionRepository extends CrudRepository<AuthorSubmission, String> {
}
