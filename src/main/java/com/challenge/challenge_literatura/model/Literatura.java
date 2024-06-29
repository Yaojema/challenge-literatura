package com.challenge.challenge_literatura.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "literatura")
public class Literatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "titulo",columnDefinition = "VARCHAR(50)")
    private String titulo;

    @OneToOne(targetEntity = Autores.class, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id_autor")
    private Autores autor;

    @Column(columnDefinition = "VARCHAR(10)")
    private String idioma;

    @Column(name = "descargas")
    private Integer descargas;

    //*** Constructor
    public Literatura(String titulo, Autores autor, String idioma, Integer descargas) {
        this.titulo = titulo;
        this.autor = autor;
        this.idioma = idioma;
        this.descargas = descargas;
    }
    public Literatura() {
    }
    //****Set-Get
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autores getAutor() {
        return autor;
    }

    public void setAutor(Autores autor) {
        this.autor = autor;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Integer getDescargas() {
        return descargas;
    }

    public void setDescargas(Integer descargas) {
        this.descargas = descargas;
    }

    // To String
    @Override
    public String toString() {
        return
                ", titulo='" + titulo +
                ", autor=" + autor +
                ", idioma='" + idioma +
                ", descargas=" + descargas;
    }
}

