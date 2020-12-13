package com.api.marvel.consumoApiMarvel;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({("com.api.marvel.model"),("com.api.marvel.controller")})
public class ConsumoApiMarvelApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumoApiMarvelApplication.class, args);
	}

}
