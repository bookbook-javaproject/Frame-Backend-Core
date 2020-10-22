package com.frame.core.domain.user.controller;


import com.frame.core.domain.user.dto.ChangePasswordRequest;
import com.frame.core.domain.user.dto.RegisterRequest;
import com.frame.core.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public void registerAccount(@RequestBody @Valid RegisterRequest request) {
        userService.registerService(request);
    }

    @PatchMapping("/password")
    @ResponseStatus(value = HttpStatus.OK)
    public void changePassword(@RequestBody @Valid ChangePasswordRequest request) {
        userService.changePasswordService(request);
    }

}
