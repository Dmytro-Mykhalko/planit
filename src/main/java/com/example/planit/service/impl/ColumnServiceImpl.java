package com.example.planit.service.impl;

import com.example.planit.entity.ColumnEntity;
import com.example.planit.repository.ColumnRepository;
import com.example.planit.service.ColumnService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ColumnServiceImpl implements ColumnService {

    private final ColumnRepository columnRepository;

    @Override
    public List<ColumnEntity> findAll() {
        return columnRepository.findAll();
    }

    @Override
    public ColumnEntity getById(int id) {
        return columnRepository.getReferenceById(id);
    }

    @Override
    public ColumnEntity save(ColumnEntity entity) {
        return columnRepository.save(entity);
    }

    @Override
    public void delete(ColumnEntity entity) {
        columnRepository.delete(entity);
    }

    @Override
    public void deleteById(int id) {
        columnRepository.deleteById(id);
    }
}
