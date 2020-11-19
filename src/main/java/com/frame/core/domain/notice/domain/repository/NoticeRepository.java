package com.frame.core.domain.notice.domain.repository;

import com.frame.core.domain.notice.domain.entity.Notice;
import org.springframework.data.repository.CrudRepository;

public interface NoticeRepository extends CrudRepository<Notice, Long> {
}
