package com.challenge.challenge_literatura.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "literatura")
public class Literatura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String autor;
    private LocalDate fecha_nacimiento;
    private LocalDate fecha_muerte;
    private String idioma;
    private Integer descargas;
}

