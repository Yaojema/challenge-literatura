package com.challenge.challenge_literatura.repository;

import com.challenge.challenge_literatura.model.Autores;
import com.challenge.challenge_literatura.model.Idioma;
import com.challenge.challenge_literatura.model.Literatura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AutoresRepository extends JpaRepository<Autores, Long> {
    @Query("SELECT a FROM Autores a WHERE a.nombre LIKE %:nombre%")
    Optional<Autores> buscaElNombreDeAutores(@Param("nombre") String nombre);

    @Query("SELECT l FROM Literatura l WHERE l.titulo LIKE %:nombre%")
    Optional<Literatura> buscarLiteraturaPorNombre(@Param("nombre") String nombre);

    @Query("SELECT a FROM Autores a WHERE a.muerte > :fecha")
    List<Autores> buscarAutoresVivos(@Param("fecha") Integer fecha);

    @Query("SELECT l FROM Literatura l WHERE l.idioma = :idioma")
    List<Literatura> buscarLiteraturasPorIdioma(@Param("idioma") Idioma idioma);

    @Query("SELECT a FROM Autores a WHERE a.nacimiento = :fecha")
    List<Autores> listarAutoresPorNacimiento(@Param("fecha") Integer fecha);

    @Query("SELECT a FROM Autores a WHERE a.muerte = :fecha")
    List<Autores> listarAutoresPorFallecimiento(@Param("fecha") Integer fecha);

    @Query("SELECT l FROM Literatura l")
    List<Literatura> buscarTodosLosLiteraturas();
}
