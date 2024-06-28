package com.challenge.challenge_literatura.principal;

import com.challenge.challenge_literatura.repository.LiteraturaRepository;

import java.util.Scanner;

public class Principal {

    private Scanner teclado = new Scanner(System.in);
    private final String URL_BASE = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=91ae4334";
    private LiteraturaRepository repositorio;

    public Principal(LiteraturaRepository repository) {
        this.repositorio = repository;
    }

    public void muestraElMenu() {
        var opcion = -1;
        while (opcion != 0) {
            var menu = """
                    1 - Buscar series 
                    2 - Buscar episodios
                    3 - Mostrar series buscadas
                    4 - Buscar series por titulo
                    5 - Top 5 mejores series
                    6 - Buscar series por categoria
                    7 - Filtrar series por temporadas y evaluacion
                    8 - Buscar episodios por titulo
                    9 - Cinco episodios por serie
                    
                                  
                    0 - Salir
                    """;
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
//                    buscarSerieWeb();
                    break;
                case 2:
//                    buscarEpisodioPorSerie();
                    break;
                case 3:
//                    mostrarSeriesBuscadas();
                    break;
                case 4:
//                    buscarSeriePorTitulo();
                    break;
                case 5:
//                    buscarTop5Series();
                    break;
                case 6:
//                    buscarSeriesPorCategoria();
                    break;
                case 7:
//                    filtrarSeriesPorTemporadaYEvaluacion();
                    break;
                case 8:
//                    buscarEpisodiosPorTitulo();
                    break;
                case 9:
//                    top5Episodios();
                    break;
                case 0:
                    System.out.println("Cerrando la aplicación...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }

    }

}
