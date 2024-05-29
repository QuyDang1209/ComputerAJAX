package com.cg.minitest1module4_ajax.controller;

import com.cg.minitest1module4_ajax.exception.ResourceNotFound;
import com.cg.minitest1module4_ajax.model.Computer;
import com.cg.minitest1module4_ajax.service.IComputerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/computer")
public class ComputerRestComtroller {
    @Autowired
    private IComputerService iComputerService;
    @GetMapping("/{id}")
    public ResponseEntity<Computer> finOneComputer(@PathVariable Long id){
        return new ResponseEntity<> (iComputerService.findById(id).orElseThrow(() -> new ResourceNotFound("ID khong ton tai")), HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<Iterable<Computer>> listComputer() {
        return new ResponseEntity<>(iComputerService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createComputer(@RequestBody Computer computer) {
        return new ResponseEntity<>(iComputerService.save(computer), HttpStatus.CREATED);
    }
    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<?> handleResourceNotFoundException(){
        return new ResponseEntity<>("ID khong ton tai", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Computer> deleteComputer(@PathVariable Long id) {
        Optional<Computer> computerOptional = iComputerService.findById(id);
        if (!computerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        iComputerService.remove(id);
        return new ResponseEntity<>(computerOptional.get(), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Computer> updateComputer(@PathVariable Long id,
                                                   @RequestBody Computer computer){
        Optional<Computer> computerOptional = iComputerService.findById(id);
        if (!computerOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        else {
            computer.setId(id);
            iComputerService.save(computer);
            return new ResponseEntity<>(computerOptional.get(), HttpStatus.OK);
        }
    }
}
