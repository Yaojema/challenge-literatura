package com.challenge.challenge_literatura.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "autores")
public class Autores {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", columnDefinition = "VARCHAR(50)", unique = true)
    private String nombre;

    @Column(name = "nacimiento")
    private Integer nacimiento;

    @Column(name = "muerte")
    private Integer muerte;

//    @OneToOne(mappedBy = "autor")
    @OneToMany(targetEntity = Literatura.class, fetch = FetchType.EAGER, mappedBy = "autor")
    private List<Literatura> literatura;

    //Contructors & Empty
    public Autores(){}
    public Autores(DatosAutores datosAutores){
        this.nombre = datosAutores.nombre();
        this.nacimiento = datosAutores.nacimiento();
        this.muerte = datosAutores.muerte();
    }

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

    public List<Literatura> getLiteratura() {
        return literatura;
    }

    public void setLiteratura(List<Literatura> literatura) {
        this.literatura = literatura;
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