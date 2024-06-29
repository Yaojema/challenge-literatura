package com.challenge.challenge_literatura.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Autores {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", columnDefinition = "VARCHAR(50)")
    private String nombre;

    @Column(name = "nacimiento",columnDefinition = "DATE")
    private LocalDate nacimiento;

    @Column(name = "muerte",columnDefinition = "DATE")
    private LocalDate muerte;

    //Contructors & Empty
    public Autores(String nombre, LocalDate nacimiento, LocalDate muerte) {
        this.nombre = nombre;
        this.nacimiento = nacimiento;
        this.muerte = muerte;
    }
    public Autores() {}

    // Setters Getters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(LocalDate nacimiento) {
        this.nacimiento = nacimiento;
    }

    public LocalDate getMuerte() {
        return muerte;
    }

    public void setMuerte(LocalDate muerte) {
        this.muerte = muerte;
    }

    //ToString
    @Override
    public String toString() {
        return
                ", nombre='" + nombre +
                ", nacimiento=" + nacimiento +
                ", muerte=" + muerte;
    }
}

