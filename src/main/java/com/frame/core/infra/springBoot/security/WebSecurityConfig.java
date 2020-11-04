package com.frame.core.infra.springBoot.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private final JwtProvider jwtProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .sessionManagement().disable()
                .formLogin().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST,"/user").permitAll()
                .antMatchers(HttpMethod.POST, "/user/auth").permitAll()
                .antMatchers(HttpMethod.PATCH,"/user/password").permitAll()
                .anyRequest().authenticated()
                .and()
                .apply(new JwtConfigure(jwtProvider));
    }
}
