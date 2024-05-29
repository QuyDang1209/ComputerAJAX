package com.cg.minitest1module4_ajax.controller;

import com.cg.minitest1module4_ajax.model.Type;
import com.cg.minitest1module4_ajax.repository.ITypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/type")
@CrossOrigin("*")
public class TypeRestController {
    @Autowired
    private ITypeRepository typeRepository;
    @GetMapping
    public ResponseEntity<Iterable<Type>> listType(){
        return new ResponseEntity<>(typeRepository.findAll(), HttpStatus.OK);
    }
}
