package com.challenge.challenge_literatura.model;

import jakarta.persistence.*;

import java.util.List;

@Table(name = "autores")
@Entity(name = "Autor")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", columnDefinition = ("VARCHAR(100)"), nullable = false, unique = true)
    private String nombre;
    @Column(name = "nacimiento")
    private Integer nacimiento;
    @Column(name = "fallecimiento")
    private Integer fallecimiento;

    @OneToMany(targetEntity = Libro.class, mappedBy = "autor")
    private List<Libro> libro;

    // CONSTRUCTOR

    public Autor() {}
    public Autor(DatosAutor datosAutor){
        this.nombre = datosAutor.nombre();
        this.nacimiento = datosAutor.nacimiento();
        this.fallecimiento = datosAutor.fallecimiento();
    }

//    public Autor(Long id, String nombre, Integer nacimiento, Integer fallecimiento, List<Libro> libro) {
//        this.id = id;
//        this.nombre = nombre;
//        this.nacimiento = nacimiento;
//        this.fallecimiento = fallecimiento;
//        this.libro = libro;
//    }

    //SETTERS GETTERS

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

    public Integer getFallecimiento() {
        return fallecimiento;
    }

    public void setFallecimiento(Integer fallecimiento) {
        this.fallecimiento = fallecimiento;
    }

    public List<Libro> getLibro() {
        return libro;
    }

    public void setLibro(List<Libro> libro) {
        this.libro = libro;
    }

    //

    @Override
    public String toString() {
        return "Autor: " +
                "id=" + id +
                ", nombre='" + nombre +
                ", nacimiento=" + nacimiento +
                ", fallecimiento=" + fallecimiento +
                ", libro=" + libro;
    }
}
