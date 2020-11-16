package com.frame.core.domain.user.domain.usecase;


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
public class SendAuthEmailUseCaseImpl implements SendAuthEmailUseCase {
    private final EmailAuthRepository emailAuthRepository;
    private final JavaMailSender mailSender;
    private final PasswordService passwordService;

    @Value("${spring.mail.username}")
    private String FROM_ADDRESS;

    @Override
    public void execute(String email) {
        String code = UUID.randomUUID().toString();
        emailAuthRepository.save(
                EmailAuth.builder()
                    .email(email)
                    .authCode(code)
                    .build());
        mailSender.send(generateEmail(email, code));
    }

    @Override
    public void execute(String email, String nickName, String password) {
        String code = UUID.randomUUID().toString();
        emailAuthRepository.save(EmailAuth.builder()
                .email(email)
                .authCode(code)
                .nickName(nickName)
                .password(passwordService.encode(password))
                .build());
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
