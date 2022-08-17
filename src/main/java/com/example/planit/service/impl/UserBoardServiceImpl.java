package com.example.planit.service.impl;

import com.example.planit.entity.UserBoardEntity;
import com.example.planit.repository.UserBoardRepository;
import com.example.planit.service.UserBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserBoardServiceImpl implements UserBoardService {

    @Autowired
    UserBoardRepository repository;

    @Override
    public List<UserBoardEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public UserBoardEntity getById(int id) {
        return repository.getReferenceById(id);
    }

    @Override
    public void save(UserBoardEntity entity) {
        repository.save(entity);
    }

    @Override
    public void delete(UserBoardEntity entity) {
        repository.delete(entity);
    }
}
