package com.frame.core.infra.springBoot.security;

import com.frame.core.domain.user.domain.repository.UserRepository;
import com.frame.core.global.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class AuthDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public AuthDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository.findById(email)
                .map(AuthDetails::new)
                .orElseThrow(NotFoundException::new);
    }
}
