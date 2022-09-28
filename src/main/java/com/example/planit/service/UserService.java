package com.example.planit.service;

import com.example.planit.entity.BoardEntity;
import com.example.planit.entity.UserEntity;
import org.springframework.security.core.Authentication;

import java.util.List;
import java.util.Optional;

public interface UserService extends CrudService<UserEntity> {
    UserEntity findByEmail(String email);
    UserEntity getUserFromAuth(Authentication authentication);
}
