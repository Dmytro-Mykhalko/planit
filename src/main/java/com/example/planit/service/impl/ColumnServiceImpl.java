package com.example.planit.service.impl;

import com.example.planit.entity.ColumnEntity;
import com.example.planit.repository.ColumnRepository;
import com.example.planit.service.ColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColumnServiceImpl implements ColumnService {

    @Autowired
    ColumnRepository repository;

    @Override
    public List<ColumnEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public ColumnEntity getById(int id) {
        return repository.getReferenceById(id);
    }

    @Override
    public ColumnEntity save(ColumnEntity entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(ColumnEntity entity) {
        repository.delete(entity);
    }
}
