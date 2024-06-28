package com.challenge.challenge_literatura;

import com.challenge.challenge_literatura.principal.Principal;
import com.challenge.challenge_literatura.repository.LiteraturaRepository;
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
//		Principal principal = new Principal(repository);
//		principal.muestraElMenu();

	}

}
