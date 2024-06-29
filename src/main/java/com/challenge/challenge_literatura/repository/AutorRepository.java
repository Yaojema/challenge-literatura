package com.challenge.challenge_literatura.repository;

import com.challenge.challenge_literatura.model.Autores;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autores, Long> {
}
