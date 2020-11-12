package com.frame.core.domain.user.domain.repository;

import com.frame.core.domain.user.domain.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
}
