/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dse.desafio2.demo.model;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 *
 * @author kevin
 */
@Entity
@Table
public class Person implements Serializable {
    @Id
    @Column(name = "id" ,nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false)
    @NotEmpty(message = "El nombre es requerido")
    private String name;
    
    @Column(nullable = false)
    @NotEmpty(message = "El apellido es requerido")
    private String lastname;
    
    @Column(nullable = false)
    @NotEmpty(message = "El email es requerido")
    @Email(message = "No se ingresó un email válido")
    private String email;
    
    @Column(nullable = false)
    @NotNull(message = "La altura es requerida")
    @Min(value = 1, message = "La altura debe ser un valor positivo en centímetros")
    private Integer height;
    
    @Column(nullable = false)
    @NotNull(message = "La fecha de nacimiento es requerida")
    private LocalDate birthday;
    
    @Column(nullable = false)
    @NotNull(message = "El estado es requerido")
    private boolean active;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    
    
}
