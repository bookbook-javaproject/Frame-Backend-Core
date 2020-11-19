package com.frame.core.domain.submission.domain.usecase;

import com.frame.core.domain.submission.domain.entity.AuthorSubmissionAuth;
import com.frame.core.domain.submission.domain.repository.AuthorSubmissionAuthRepository;
import com.frame.core.domain.user.domain.entity.EmailAuth;
import com.frame.core.domain.user.domain.repository.EmailAuthRepository;
import com.frame.core.domain.user.domain.service.PasswordService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class SendEmailForAuthUseCaseImpl implements SendEmailForAuthUseCase {
    private final AuthorSubmissionAuthRepository authorSubmissionAuthRepository;

    private final JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String FROM_ADDRESS;

    @Override
    public void execute(String email) {
        String code = UUID.randomUUID().toString();

        authorSubmissionAuthRepository.save(
                AuthorSubmissionAuth.builder()
                .authCode(code)
                .certification(false)
                .email(email)
                .build()
        );
        mailSender.send(generateEmail(email, code));
    }

    private SimpleMailMessage generateEmail(String email, String code) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setFrom(FROM_ADDRESS);
        message.setSubject("FRAME 인증 코드 입니다");
        message.setText(code);

        return message;
    }
}
