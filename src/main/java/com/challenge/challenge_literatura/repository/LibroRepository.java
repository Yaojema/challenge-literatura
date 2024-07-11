package com.challenge.challenge_literatura.repository;

import com.challenge.challenge_literatura.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LibroRepository extends JpaRepository<Libro, Long> {

    @Query("SELECT l FROM Libro l JOIN l.autor")
    List<Libro> listarAutores();

    @Query("SELECT l FROM Libro l JOIN l.autor a WHERE :year BETWEEN a.nacimiento AND a.fallecimiento")
    List<Libro> buscarPorAnio(int year);

    @Query("SELECT l FROM Libro l WHERE l.idioma = :idioma")
    List<Libro> buscarIdioma(String idioma);
}
