package com.frame.core.domain.user.service;

import com.frame.core.domain.post.dto.UserPreview;
import com.frame.core.domain.user.domain.entity.EmailAuth;
import com.frame.core.domain.user.domain.entity.User;
import com.frame.core.domain.user.domain.usecase.*;
import com.frame.core.domain.user.dto.*;
import com.frame.core.infra.springBoot.security.AuthenticationFacade;
import com.frame.core.infra.springBoot.security.JwtProvider;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private final GetUserUseCase getUserUseCase;
    private final CreateUserUseCase createUserUseCase;
    private final CertifyUserUseCase certifyUserUseCase;
    private final ChangePasswordUseCase changePasswordUseCase;
    private final SetProfileUseCase setProfileUseCase;
    private final FollowUserUseCase followUserUseCase;
    private final GetFollowingUseCase getFollowingUseCase;
    private final GetFollowerUseCase getFollowerUseCase;
    private final SendAuthEmailUseCase sendAuthEmailUseCase;
    private final CertifyAuthCodeUseCase certifyAuthCodeUseCase;

    private final JwtProvider jwtProvider;
    private final AuthenticationFacade authenticationFacade;

    @Override
    public GetUserResponse getUser() {
        User user = getUserUseCase.execute(authenticationFacade.getEmail());
        return GetUserResponse.builder()
                .email(user.getEmail())
                .favoriteType(String.valueOf(user.getFavoriteType()))
                .nickname(user.getNickname())
                .imageUri(user.getImageUri())
                .description(user.getDescription())
                .userType(user.getUserType() ? String.valueOf(user.getUserType().name()) : "null")
                .build();
    }

    @Override
    public GetUserResponse getUser(String email) {
        User user = getUserUseCase.execute(email);
        return GetUserResponse.builder()
                .email(user.getEmail())
                .favoriteType(String.valueOf(user.getFavoriteType()))
                .nickname(user.getNickname())
                .imageUri(user.getImageUri())
                .description(user.getDescription())
                .build();
    }

    @Override
    public void registerService(RegisterRequest request) {
        sendAuthEmailUseCase.execute(request.getEmail(), request.getNickname(), request.getPassword());
    }

    @Override
    public LoginResponse login(LoginRequest request) {
        certifyUserUseCase.execute(request.getEmail(), request.getPassword());
        return LoginResponse.builder()
                .accessToken(jwtProvider.generateAccessToken(request.getEmail()))
                .refreshToken(jwtProvider.generateRefreshToken(request.getEmail()))
                .build();
    }

    @Override
    public void changePasswordService(ChangePasswordRequest request) {
        changePasswordUseCase.execute(request.getAuthCode(), request.getNewPassword());
    }

    @Override
    public void setProfile(SetProfileRequest request) {
        setProfileUseCase.execute(
                authenticationFacade.getEmail(),
                request.getNickname(),
                request.getDescription(),
                request.getFavoriteType(),
                request.getImageUri());
    }

    @Override
    public void setRelation(RelationRequest request) {
        followUserUseCase.execute(
                authenticationFacade.getEmail(),
                request.getEmail()
        );
    }

    @Override
    public GetRelationResponse getRelation(String email) {
        List<UserPreview> followers = new ArrayList<UserPreview>();
        List<UserPreview> followings = new ArrayList<UserPreview>();

        for (String userEmail: getFollowerUseCase.execute(email)){
            User user = getUserUseCase.execute(userEmail);
            followers.add(
                    UserPreview.builder()
                            .nickname(user.getNickname())
                            .email(user.getEmail())
                            .imageUri(user.getImageUri())
                            .build()
            );
        }

        for (String userEmail: getFollowingUseCase.execute(email)){
            User user = getUserUseCase.execute(userEmail);
            followings.add(
                    UserPreview.builder()
                            .nickname(user.getNickname())
                            .email(user.getEmail())
                            .imageUri(user.getImageUri())
                            .build()
            );
        }

       return GetRelationResponse.builder()
               .follower(followers)
               .following(followings)
               .build();
    }

    @Override
    public GetRelationNumberResponse getRelationNumber(String email) {
        return GetRelationNumberResponse.builder()
                .follower(getFollowerUseCase.execute(email).size())
                .following(getFollowingUseCase.execute(email).size())
                .build();
    }

    @Override
    public void getAuthCodeForChangePassword(GetAuthCodeRequest request) {
        sendAuthEmailUseCase.execute(request.getEmail());
    }

    @Override
    public void certifyAuthCode(String authCode) {
        EmailAuth emailAuth = certifyAuthCodeUseCase.execute(authCode);
        createUserUseCase.execute(
                emailAuth.getEmail(),
                emailAuth.getNickName(),
                emailAuth.getPassword());
    }
}
