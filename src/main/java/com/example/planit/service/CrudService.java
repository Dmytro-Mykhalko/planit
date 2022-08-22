package com.example.planit.service;

import java.util.List;

public interface CrudService<T> {
    List<T> findAll();

    T getById(int id);

    T save(T entity);

    void delete(T entity);
}
