/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dse.desafio2.demo.service;

import com.dse.desafio2.demo.model.Person;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.hibernate.SessionFactory;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author kevin
 */
@Service
public class PersonService {
    
    @Autowired
    private SessionFactory sessionFactory;
    
    public ResponseEntity<String> create(Person person) {
        try (Session session = sessionFactory.openSession()) {
            session.save(person);
            session.close();
        }
        return ResponseEntity.ok("Registro creado con éxito.");
    }
    
    public List<Person> read() {
        Query query;
        try (Session session = sessionFactory.openSession()) {
            query = session.createQuery("from Person");
            List<Person> list = query.list();
            session.close();
            return list;
        }
    }
    
    public ResponseEntity<String> update(Person person) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query query = session
                    .createQuery("from Person where id = :id")
                    .setParameter("id", person.getId());
            Person per = (Person)query.getSingleResult();
            
            per.setName(person.getName());
            per.setLastname(person.getLastname());
            per.setEmail(person.getEmail());
            per.setHeight(person.getHeight());
            per.setBirthday(person.getBirthday());
            per.setActive(person.isActive());
            
            session.update(per);
            session.getTransaction().commit();
            session.close();
            return ResponseEntity.ok("Registro modificado con éxito.");
        }
    }
    
    public ResponseEntity<String> delete(Long id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            Query query = session
                    .createQuery("from Person where id = :id")
                    .setParameter("id", id);
            Person per = (Person)query.getSingleResult();
            session.delete(per);
            session.getTransaction().commit();
            session.close();
            return ResponseEntity.ok("Registro eliminado con éxito.");
        }
    }
    
}
