package com.challenge.challenge_literatura.model;

public class Autores {
    private Long id;
    private String nombre;
    private Integer nacimiento;
    private Integer muerte;

    //Contructors & Empty
    public Autores(String nombre, Integer nacimiento, Integer muerte) {
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

    public Integer getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(Integer nacimiento) {
        this.nacimiento = nacimiento;
    }

    public Integer getMuerte() {
        return muerte;
    }

    public void setMuerte(Integer muerte) {
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

