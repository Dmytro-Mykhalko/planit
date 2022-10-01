package com.example.planit.service;

import com.example.planit.entity.BoardEntity;
import com.example.planit.entity.UserEntity;

import java.util.List;

public interface BoardService extends CrudService<BoardEntity> {
    BoardEntity getBoardByName(UserEntity user, String boardName);
}
