package com.example.planit.service;

import com.example.planit.entity.BoardEntity;
import com.example.planit.entity.UserEntity;

public interface UserService extends CrudService<UserEntity> {
    UserEntity findByEmail(String email);
    BoardEntity addBoard(UserEntity user, BoardEntity board);
}
