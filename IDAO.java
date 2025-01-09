package com.example.demo.DAO;

import java.util.List;
import java.util.Optional;

public interface IDAO<T> {
    Optional<T> findById(Long id);

    T save(T entity);

    void delete(T entity);

    void deleteById(Long id);

    List<T> findAll();
}
