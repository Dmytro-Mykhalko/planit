package com.example.planit.service.impl;

import com.example.planit.entity.BoardEntity;
import com.example.planit.repository.BoardRepository;
import com.example.planit.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    BoardRepository boardRepository;

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
}
