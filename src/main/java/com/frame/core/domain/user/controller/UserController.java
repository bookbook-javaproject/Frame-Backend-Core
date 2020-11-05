package com.frame.core.domain.user.controller;


import com.frame.core.domain.user.dto.*;
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

    @PostMapping("/auth")
    @ResponseStatus(value = HttpStatus.OK)
    public LoginResponse login(@RequestBody @Valid LoginRequest request) {
        return userService.login(request);
    }

    @PatchMapping("/password")
    @ResponseStatus(value = HttpStatus.OK)
    public void changePassword(@RequestBody @Valid ChangePasswordRequest request) { userService.changePasswordService(request); }
        userService.changePasswordService(request);
    }

    @PutMapping("/profile")
    @ResponseStatus(value = HttpStatus.OK)
    public void setProfile(@RequestBody @Valid SetProfileRequest request) {
        userService.setProfile(request);
    }

    @PutMapping("/relation")
    @ResponseStatus(value = HttpStatus.OK)
    public void setRelation(@RequestBody @Valid RelationRequest request) { userService.setRelation(request); }
}
