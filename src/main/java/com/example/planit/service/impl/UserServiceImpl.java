package com.example.planit.service.impl;

import com.example.planit.entity.BoardEntity;
import com.example.planit.entity.UserEntity;
import com.example.planit.repository.BoardRepository;
import com.example.planit.repository.UserRepository;
import com.example.planit.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BoardRepository boardRepository;

    @Override
    public List<UserEntity> findAll() {
        log.info("Getting all the users");
        return userRepository.findAll();
    }

    @Override
    public UserEntity getById(int id) {
        log.info("Getting a user by ID: {}", id);
        return userRepository.getReferenceById(id);
    }

    @Override
    public UserEntity save(UserEntity entity) {
        log.info("Saving user {}", entity.getId());
        return userRepository.save(entity);
    }

    @Override
    public void delete(UserEntity entity) {
        log.info("Deleting user {}", entity.getId());
        userRepository.delete(entity);
    }

    @Override
    public UserEntity findByEmail(String email) {
        log.info("Searching user by email: {}", email);
        return userRepository.findByEmail(email);
    }

    @Override
    public BoardEntity addBoard(UserEntity user, BoardEntity board) {
        log.info("Adding a board {} for user", board.getName());
        boardRepository.save(board);
        user.getBoards().add(board);
        return board;
    }
}
