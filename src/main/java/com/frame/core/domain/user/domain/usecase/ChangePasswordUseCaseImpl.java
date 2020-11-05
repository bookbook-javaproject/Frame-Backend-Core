package com.frame.core.domain.user.domain.usecase;


import com.frame.core.domain.user.domain.entity.EmailAuth;
import com.frame.core.domain.user.domain.exception.UnAuthorizedException;
import com.frame.core.domain.user.domain.repository.EmailAuthRepository;
import com.frame.core.domain.user.domain.repository.UserRepository;
import com.frame.core.domain.user.domain.service.PasswordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ChangePasswordUseCaseImpl implements ChangePasswordUseCase {
    private final EmailAuthRepository emailAuthRepository;
    private final UserRepository userRepository;
    private final PasswordService passwordService;

    @Override
    public void execute(String authCode, String newPassword) {
        EmailAuth emailAuth = emailAuthRepository.findByAuthCode(authCode)
                .orElseThrow(UnAuthorizedException::new);

        userRepository.findById(emailAuth.getEmail()).ifPresent(user -> {
            user.changePassword(passwordService.encode(newPassword));
            userRepository.save(user);

            emailAuthRepository.delete(emailAuth);
        });
    }
}
