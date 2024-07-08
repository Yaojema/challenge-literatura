package com.challenge.challenge_literatura;

import com.challenge.challenge_literatura.principal.Principal;
import com.challenge.challenge_literatura.repository.AutoresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChallengeLiteraturaApplication implements CommandLineRunner {

	@Autowired
	AutoresRepository autoresRepository;

	public static void main(String[] args) {
		SpringApplication.run(ChallengeLiteraturaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(autoresRepository);
		principal.mostrarMenu();
	}

}
