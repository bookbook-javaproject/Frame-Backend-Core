package com.frame.core.domain.user.controller;


import com.frame.core.domain.user.dto.*;
import com.frame.core.domain.user.service.UserService;
import com.frame.core.infra.springBoot.security.AuthenticationFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    @ResponseStatus(value = HttpStatus.OK)
    public GetUserResponse getUser() {
        return userService.getUser();
    }

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

    @GetMapping("/auth")
    @ResponseStatus(value = HttpStatus.OK)
    public void certifyAuthCode(@RequestParam("auth-code") String authCode) {
        userService.certifyAuthCode(authCode);
    }

    @PostMapping("/password/auth-code")
    @ResponseStatus(value = HttpStatus.OK)
    public void sendAuthCode(@RequestBody @Valid GetAuthCodeRequest request) { userService.getAuthCode(request); }

    @PatchMapping("/password")
    @ResponseStatus(value = HttpStatus.OK)
    public void changePassword(@RequestBody @Valid ChangePasswordRequest request) { userService.changePasswordService(request); }

    @PutMapping("/profile")
    @ResponseStatus(value = HttpStatus.OK)
    public void setProfile(@RequestBody @Valid SetProfileRequest request) {
        userService.setProfile(request);
    }

    @PutMapping("/relation")
    @ResponseStatus(value = HttpStatus.OK)
    public void setRelation(@RequestBody @Valid RelationRequest request) { userService.setRelation(request); }

    @GetMapping("/relation")
    @ResponseStatus(value = HttpStatus.OK)
    public GetRelationResponse getRelation(@RequestParam("email") String email) {
        return userService.getRelation(email); }

    @GetMapping("/relation/number")
    @ResponseStatus(value = HttpStatus.OK)
    public GetRelationNumberResponse getRelationNumber(@RequestParam("email") String email) {
        return userService.getRelationNumber(email); }
}
