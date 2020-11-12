package com.frame.core.domain.user.domain.usecase;

import com.frame.core.domain.user.domain.entity.enums.FavoriteType;
import com.frame.core.domain.user.domain.repository.UserRepository;
import com.frame.core.global.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SetProfileUseCaseImpl implements SetProfileUseCase {
    private final UserRepository userRepository;

    @Override
    public void execute(String email, String nickname, String description, String favoriteType, String imageUri) {
        userRepository.findById(email).ifPresent(user -> {
            user.changeDescription(description);
            user.changeImageUri(imageUri);
            user.changeNickname(nickname);
            user.changeFavoriteType(generateFavoriteType(favoriteType));

            userRepository.save(user);
        });
    }

    private FavoriteType generateFavoriteType(String favoriteType) {
        if (favoriteType.equals("SENSIBILITY")) return FavoriteType.SENSIBILITY;
        if (favoriteType.equals("LIFE")) return FavoriteType.LIFE;
        if (favoriteType.equals("PHILOSOPHY")) return FavoriteType.PHILOSOPHY;
        if (favoriteType.equals("ROMANCE")) return FavoriteType.ROMANCE;
        throw new NotFoundException(); // TODO EXCEPtION OF BAD REQUEST
    }
}
