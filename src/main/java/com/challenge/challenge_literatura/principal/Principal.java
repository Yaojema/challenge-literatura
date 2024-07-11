package com.challenge.challenge_literatura.principal;

import com.challenge.challenge_literatura.ConsumoAPI;
import com.challenge.challenge_literatura.ConvierteDatos;
import com.challenge.challenge_literatura.model.DatosLibro;
import com.challenge.challenge_literatura.model.DatosLiteratura;
import com.challenge.challenge_literatura.model.Libro;
import com.challenge.challenge_literatura.repository.LibroRepository;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {


    private final Scanner teclado = new Scanner(System.in);
    private final ConsumoAPI consumoAPI = new ConsumoAPI();
    private final String URL_BASE = "https://gutendex.com/books/?search=";
    private final ConvierteDatos conversor = new ConvierteDatos();
    private final List<DatosLiteratura> datosLiteratura = new ArrayList<>();

    private final LibroRepository repository;
    public Principal(LibroRepository libroRepository) {
        this.repository = libroRepository;
    }

    public void muestraMenu(){

        System.out.println();
        System.out.println("INICIO APLICACION");
        var opcion = 1;
        while (opcion != 0){
            var menu = """
                    1 - Buscar titulo y guardar
                    2 - Mostrar libros registrados
                    3 - Mostrar autores
                    4 - Mostrar por año
                    5 - Mostrar por idioma
                    
                    0 - Salir
                    """;
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion){
                case 1 -> buscarLibro();
                case 2 -> listar();
                case 3 -> listarAutores();
                case 4 -> buscarPorRangoAnio();
                case 5 -> buscarPoridioma();
                case 0 -> System.out.println("Cerrando aplicacion...");
                default -> System.out.println("Opcion invalida");
            }
        }
    }

    private void buscarLibro(){
        System.out.println("Ingresar el libro para buscar");
        String nombreLibro = teclado.nextLine();
        String json = consumoAPI.obtenerDatos(URL_BASE + nombreLibro.replace(" ", "%20"));
        List<DatosLibro> libros = conversor.obtenerDatos(json, DatosLiteratura.class).libro();
        Optional<DatosLibro> libroOptional = libros.stream()
                .filter(lib -> lib.titulo().toLowerCase().contains(nombreLibro.toLowerCase()))
                .findFirst();
        if(libroOptional.isPresent()){
            var book = new Libro(libroOptional.get());
            try{
                repository.save(book);
            } catch (DataIntegrityViolationException data){
                System.out.println("El libro ya esta registrado");
            }
            leerLibros(book);
        }
    }

    private void listar(){
        List<Libro> libros = repository.findAll();
        libros.forEach(this::leerLibros);
    }

    private void listarAutores(){
        List<Libro> libroAutores = repository.listarAutores();
        libroAutores.forEach(this::leerAutores);
    }

    private void buscarPorRangoAnio(){
        System.out.println("Ingresar año");
        int year = teclado.nextInt();
        List<Libro> libroAutores = repository.buscarPorAnio(year);
        libroAutores.forEach(this::leerAutores);
    }

    private void buscarPoridioma(){
        System.out.println("""
                Ingrese el idioma a buscar de los libros:
                es - español
                en - inglés
                fr - francés
                pt - potugués
                """);
        String idioma = teclado.nextLine();
        List<Libro> libros = repository.buscarIdioma(idioma);
        libros.forEach(this::leerLibros);
    }

    // Procedimientos de sup para impresión

    private void leerLibros(Libro libro){
        System.out.printf("""
                        
                        ----- LIBROS -----
                        Titulo: %s
                        Autor: %s
                        Idioma: %s
                        Numero de descargas: %d
                        --------------------
                        """,
                libro.getTitulo(),
                libro.getAutor().getNombre(),
                libro.getIdioma(),
                libro.getDescargas());
    }

    private void leerAutores(Libro libro){
        System.out.printf("""
                        
                        ----- Autores -----
                        Autor: %s
                        Año de nacimiento: %d
                        Año de fallecimiento: %d
                        Titulo: %s
                        --------------------
                        """,
                libro.getAutor().getNombre(),
                libro.getAutor().getNacimiento(),
                libro.getAutor().getFallecimiento(),
                libro.getTitulo());
    }
}
