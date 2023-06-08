package br.com.cod3r.exerciciossB.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrimeiroController {

	@GetMapping(path = {"/ola", "/saudacao"} )
	public String ola() {
		return "olá spring boot !";
	}

}
