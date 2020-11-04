package com.frame.core.domain.user.domain.usecase;


import com.frame.core.domain.user.domain.exception.UnAuthorizedException;
import com.frame.core.domain.user.domain.repository.UserRepository;
import com.frame.core.domain.user.domain.service.PasswordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ChangePasswordUseCaseImpl implements ChangePasswordUseCase {
    private final UserRepository userRepository;
    private final PasswordService passwordService;

    @Override
    public void execute(String email, String currentPassword, String newPassword) {
        userRepository.findById(email).ifPresent(user -> {
            if (passwordService.matches(currentPassword, user.getPassword())) {
                user.changePassword(passwordService.encode(newPassword));
                userRepository.save(user);
            } else {
                throw new UnAuthorizedException();
            }
        });
    }
}
