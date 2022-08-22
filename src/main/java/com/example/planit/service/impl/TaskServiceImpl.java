package com.example.planit.service.impl;

import com.example.planit.entity.TaskEntity;
import com.example.planit.repository.TaskRepository;
import com.example.planit.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskRepository repository;

    @Override
    public List<TaskEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public TaskEntity getById(int id) {
        return repository.getReferenceById(id);
    }

    @Override
    public TaskEntity save(TaskEntity entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(TaskEntity entity) {
        repository.delete(entity);
    }
}
