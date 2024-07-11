package com.challenge.challenge_literatura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLiteratura(
        @JsonAlias("count") Integer cantidad,
        @JsonAlias("results") List<DatosLibro> libro
) {
}
