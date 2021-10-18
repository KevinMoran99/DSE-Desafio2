/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dse.desafio2.demo.controller;

import com.dse.desafio2.demo.model.Person;
import com.dse.desafio2.demo.service.PersonService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author kevin
 */
@RestController
@RequestMapping("/person")
@CrossOrigin(origins = "*")
@EntityScan(basePackages = "com.dse.desafio2.demo.model")
public class PersonController {
    
    @Autowired
    PersonService service;
    
    @PostMapping()
    public ResponseEntity<String> create(@RequestBody @Valid Person person) {
        return service.create(person);
    }
    
    @GetMapping()
    public List<Person> read() {
        return service.read();
    }
    
    @PutMapping()
    public ResponseEntity<String> update(@RequestBody @Valid Person person) {
        return service.update(person);
    }
    
    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        return service.delete(id);
    }
}
