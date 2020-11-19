package com.frame.core.domain.notice.service;

import com.frame.core.domain.notice.domain.entity.Notice;
import com.frame.core.domain.notice.domain.usecase.GetNoticesUseCase;
import com.frame.core.domain.notice.dto.NoticePreview;
import com.frame.core.domain.notice.dto.NoticeResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Service
@RequiredArgsConstructor
public class NoticeServiceImpl implements NoticeService {
    private final GetNoticesUseCase getNoticesUseCase;

    @Override
    public NoticeResponse getNotices() {
        List<NoticePreview> noticePreviews = new ArrayList<NoticePreview>();

        for (Notice notice: getNoticesUseCase.execute()) {
            noticePreviews.add(
                    NoticePreview.builder()
                            .title(notice.getTitle())
                            .content(notice.getContent())
                            .createdAt(notice.getCreatedAt())
                            .build()
            );
        }

        return NoticeResponse.builder()
                .notices(noticePreviews)
                .build();
    }
}
