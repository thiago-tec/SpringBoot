package br.com.cod3r.exerciciossB.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculadora")
public class CalculadoraController {

	@GetMapping("/somar/{valor1}/{valor2}")
	public int somar(@PathVariable int valor1, @PathVariable int valor2) {
		return valor1 + valor2;
	}

	@GetMapping("/subtrair")
	public int subtrair(@RequestParam(name = "valor1") int valor1, @RequestParam(name = "valor2") int valor2) {
		return valor1 - valor2;
	}

}
