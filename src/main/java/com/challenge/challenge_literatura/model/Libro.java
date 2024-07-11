package com.challenge.challenge_literatura.model;

import jakarta.persistence.*;

@Table(name = "libros")
@Entity(name = "Libro")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "titulo", columnDefinition = "VARCHAR(100)", nullable = false, unique = true)
    private String titulo;

    @ManyToOne(targetEntity = Autor.class ,fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_autor")
    private Autor autor;

    @Column(name = "idioma",columnDefinition = "VARCHAR(20)")
    private String idioma;
//    private List<String> idioma;

    @Column(name = "descargas")
    private Integer descargas;

// CONSTRUCTOR v1
    public Libro(DatosLibro datosLibro){
        this.titulo = datosLibro.titulo();
        this.autor =new Autor(datosLibro.autor().get(0));
        this.idioma = datosLibro.idiomas().get(0);
        this.descargas = datosLibro.descargas();
    }
// CONSTRUCTOR
    public Libro() {}
//    public Libro(Integer id, String titulo, Autor autor, List<String> idioma, Integer descargas) {
//        this.id = id;
//        this.titulo = titulo;
//        this.autor = autor;
//        this.idioma = idioma;
//        this.descargas = descargas;
//    }

    // SETTER Y GETTER

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
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


    ///////


    @Override
    public String toString() {
        return "----- LIBRO -----\n" +
                "Titulo: " + titulo + "\n" +
                "Autor: " + autor.getNombre() + "\n" +
                "Idioma:" + idioma + '\n' +
                "Numero de descargas: " + descargas + "\n" +
                "----------------";
    }
}




