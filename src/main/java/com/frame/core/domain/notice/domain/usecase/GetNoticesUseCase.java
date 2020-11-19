package com.frame.core.domain.notice.domain.usecase;

import com.frame.core.domain.notice.domain.entity.Notice;

public interface GetNoticesUseCase {
    public Iterable<Notice> execute();
}
