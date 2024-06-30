package com.challenge.challenge_literatura;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChallengeLiteraturaApplication implements CommandLineRunner {

//	@Autowired
//	private LiteraturaRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(ChallengeLiteraturaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Inicio APP");
//		var consumoApi = new ConsumoAPI();
//		var json = consumoApi.obtenerDatos("https://gutendex.com/books/?search=middlemarch");
//		var json = consumoApi.obtenerDatos("https://gutendex.com/books/1513/");
//		System.out.println(json);
//		ConvierteDatos conversor = new ConvierteDatos();
//		var datos = conversor.obtenerDatos(json, DatosLiteratura.class);
//		System.out.println(datos);
		System.out.println("APP ENDs");
//		Principal principal = new Principal(repository);
//		principal.muestraElMenu();

	}

}
