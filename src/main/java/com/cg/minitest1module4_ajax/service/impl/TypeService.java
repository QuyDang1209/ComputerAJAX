package com.cg.minitest1module4_ajax.service.impl;

import com.cg.minitest1module4_ajax.model.Type;
import com.cg.minitest1module4_ajax.repository.ITypeRepository;
import com.cg.minitest1module4_ajax.service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TypeService implements ITypeService {
    @Autowired
    private ITypeRepository typeService;

    @Override
    public Iterable<Type> findAll() {
        return typeService.findAll();
    }

    @Override
    public Optional<Type> findById(Long id) {
        return typeService.findById(id);
    }

    @Override
    public Type save(Type type) {
       return typeService.save(type);
    }

    @Override
    public void remove(Long id) {
    typeService.deleteById(id);
    }
}
