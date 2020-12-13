package com.api.marvel.consumoApiMarvel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({("com.api.marvel.model"),("com.api.marvel.controller")})
public class ConsumoApiMarvelApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumoApiMarvelApplication.class, args);
	}

}
