package com.challenge.challenge_literatura.model;

public enum Idioma {
    SPANISH("es","español"),
    ENGLISH("en","inglés"),
    FRENCH("fr","francés");

    private String categoriaGutendex;

    private String categoriaGutendexEspanol;

    Idioma(String categoriaGutendex, String categoriaGutendexEspanol) {
        this.categoriaGutendex = categoriaGutendex;
        this.categoriaGutendexEspanol = categoriaGutendexEspanol;
    }

    public static Idioma fromString(String text){
        for(Idioma idioma : Idioma.values()){
            if(idioma.categoriaGutendex.equalsIgnoreCase(text)){
                return idioma;
            }
        }
        throw new IllegalArgumentException("Ningun idioma encontrado de entrada (en): " + text);
    }

    public static Idioma fromEspanol(String text){
        for(Idioma idioma : Idioma.values()){
            if(idioma.categoriaGutendexEspanol.equalsIgnoreCase(text)){
                return idioma;
            }
        }
        throw new IllegalArgumentException("Ningun idioma de entrada (es): " + text);
    }
}
