package com.example.planit.service.impl;

import com.example.planit.entity.UserEntity;
import com.example.planit.repository.UserRepository;
import com.example.planit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository repository;

    @Override
    public List<UserEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public UserEntity getById(int id) {
        return repository.getReferenceById(id);
    }

    @Override
    public void save(UserEntity entity) {
        repository.save(entity);
    }

    @Override
    public void delete(UserEntity entity) {
        repository.delete(entity);
    }

}
