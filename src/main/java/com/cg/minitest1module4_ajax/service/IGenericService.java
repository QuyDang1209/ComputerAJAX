package com.cg.minitest1module4_ajax.service;

import com.cg.minitest1module4_ajax.model.Computer;

import java.util.Optional;

public interface IGenericService<T>{
    Iterable<T> findAll();
    Optional<T> findById(Long id);
    T save(T t);
    void remove(Long id);
}
