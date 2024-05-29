package com.cg.minitest1module4_ajax.service.impl;

import com.cg.minitest1module4_ajax.model.Computer;
import com.cg.minitest1module4_ajax.repository.IComputerRepository;
import com.cg.minitest1module4_ajax.service.IComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service

public class ComputerService implements IComputerService {
    @Autowired
    private IComputerRepository computerRepository;
    @Override
    public Iterable<Computer> findAll() {
        return computerRepository.findAll();
    }

    @Override
    public Optional<Computer> findById(Long id) {
        return computerRepository.findById(id);
    }

    @Override
    public Computer save(Computer computer) {
        return computerRepository.save(computer);
    }

    @Override
    public void remove(Long id) {
        computerRepository.deleteById(id);
    }


}
