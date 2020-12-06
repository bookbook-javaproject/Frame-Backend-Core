package com.frame.core.domain.user.domain.repository;

import com.frame.core.domain.user.domain.entity.User;
import com.frame.core.domain.user.domain.entity.enums.UserType;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
    Iterable<User> findAllByUserType(UserType userType);
}
