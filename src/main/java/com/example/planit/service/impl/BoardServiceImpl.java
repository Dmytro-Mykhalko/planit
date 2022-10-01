package com.example.planit.service.impl;

import com.example.planit.entity.BoardEntity;
import com.example.planit.entity.UserEntity;
import com.example.planit.repository.BoardRepository;
import com.example.planit.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    @Override
    public List<BoardEntity> findAll() {
        return boardRepository.findAll();
    }

    @Override
    public BoardEntity getById(int id) {
        return boardRepository.getReferenceById(id);
    }

    @Override
    public BoardEntity save(BoardEntity entity) {
        return boardRepository.save(entity);
    }

    @Override
    public void delete(BoardEntity entity) {
        boardRepository.delete(entity);
    }

    @Override
    public BoardEntity getBoardByName(UserEntity user, String boardName) {
        return boardRepository.findByUserAndName(user.getId(), boardName)
                .orElseThrow(() -> new IllegalArgumentException("Board NOT FUND with name: " + boardName));
    }

    @Override
    public void deleteById(int id) {
        boardRepository.deleteById(id);
    }
}
