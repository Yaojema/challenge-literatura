package com.challenge.challenge_literatura;

import com.challenge.challenge_literatura.model.DatosLiteratura;
import com.challenge.challenge_literatura.principal.Principal;
import com.challenge.challenge_literatura.repository.LiteraturaRepository;
import com.challenge.challenge_literatura.service.ConsumoAPI;
import com.challenge.challenge_literatura.service.ConvierteDatos;
import org.springframework.beans.factory.annotation.Autowired;
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
		System.out.println("hola");
		var consumoApi = new ConsumoAPI();
		var json = consumoApi.obtenerDatos("https://gutendex.com/books/1513/");
		System.out.println(json);
		ConvierteDatos conversor = new ConvierteDatos();
		var datos = conversor.obtenerDatos(json, DatosLiteratura.class);
		System.out.println(datos);
		System.out.println("Hola2");
//		Principal principal = new Principal(repository);
//		principal.muestraElMenu();

	}

}
