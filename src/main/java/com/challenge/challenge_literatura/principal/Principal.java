package com.challenge.challenge_literatura.principal;

import com.challenge.challenge_literatura.model.Datos;
import com.challenge.challenge_literatura.model.DatosLiteratura;
import com.challenge.challenge_literatura.repository.AutoresRepository;
import com.challenge.challenge_literatura.service.ConsumoAPI;
import com.challenge.challenge_literatura.service.ConvierteDatos;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;
import java.util.Scanner;

public class Principal {

    private Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private ConvierteDatos conversor = new ConvierteDatos();
    private final String URL = "https://gutendex.com/books/";
    private AutoresRepository repository;

    @Autowired
    public Principal(AutoresRepository repository){
        this.repository = repository;
    }

    public void mostrarMenu(){
        int opc = -1;
        while (opc != 0){

            String menu =
                    """
                    ------------------------
                    Bienvenido a Literatura
                    ------------------------
                         MENU PRINCIPAL
                    ------------------------
                    1: Buscar Libro por Titulo
                    2: Listar Libros por nombre
                    3: Listar autores
                    4: Listar libros por año
                    5: Listar por idioma
                    
                    0: Salir
                    """;
            System.out.println(menu);
            try {
                opc = Integer.parseInt(teclado.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un número válido.");
                continue;
            }
            switch(opc){
                case 1:
                    buscarPorTitulo();
                    break;
                case 2:
                    System.out.println("Case 2");
                    break;
                case 3:
                    System.out.println("Case 3");
                    break;
                case 4:
                    System.out.println("Case 4");
                    break;
                case 5:
                    System.out.println("Case 5");
                    break;
                case 0:
                    System.out.println("Cerrando app..");
                    break;
                default:
                    System.out.println("Incorrecto");
            }

        } // End While
    }

    public void buscarPorTitulo(){
        System.out.println("Introduzca el nombre del libro a buscar");
        String nombre = teclado.nextLine();
        String json = consumoAPI.obtenerDatos(URL + "?search=" + nombre.replace(" ","+").toLowerCase());
        if (json.isEmpty() || json.contains("\"count\":0")) {
            System.out.println("Libro no encontrado!");
            return;
        }
        Datos datos = conversor.obtenerDatos(json, Datos.class);
        Optional<DatosLiteratura> libroBuscado = datos.literaturas().stream().findFirst();
        if (libroBuscado.isPresent()) {
            DatosLiteratura libro = libroBuscado.get();
            System.out.println(
                    "\n------------- LIBRO 📚  --------------" +
                            "\nTítulo: " + libro.titulo() +
                            "\nAutor: " + libro.autor().stream().findFirst().orElse("Desconocido") +
                            "\nIdioma: " + libro.idiomas().stream().findFirst().orElse("Desconocido") +
                            "\nNúmero de descargas: " + libro.numeroDescargas() +
                            "\n--------------------------------------\n"
            );
            // Resto del código para guardar en BD
        } else {
            System.out.println("Libro no encontrado!");
        }
    }

}
