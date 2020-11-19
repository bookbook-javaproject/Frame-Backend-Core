package com.frame.core.domain.notice.domain.usecase;

import com.frame.core.domain.notice.domain.entity.Notice;
import com.frame.core.domain.notice.domain.repository.NoticeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetNoticesUseCaseImpl implements GetNoticesUseCase {
    private final NoticeRepository noticeRepository;

    @Override
    public Iterable<Notice> execute() {
        return noticeRepository.findAll();
    }
}
