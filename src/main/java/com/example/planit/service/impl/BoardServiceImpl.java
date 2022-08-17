package com.example.planit.service.impl;

import com.example.planit.entity.BoardEntity;
import com.example.planit.repository.BoardRepository;
import com.example.planit.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    @Autowired
    BoardRepository repository;

    @Override
    public List<BoardEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public BoardEntity getById(int id) {
        return repository.getReferenceById(id);
    }

    @Override
    public void save(BoardEntity entity) {
        repository.save(entity);
    }

    @Override
    public void delete(BoardEntity entity) {
        repository.delete(entity);
    }
}
