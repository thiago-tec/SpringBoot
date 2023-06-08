package br.com.cod3r.exerciciossB.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/metodos")
public class MetodosHttpController {

	@GetMapping
	public String get() {
		return "requisição get";
	}
	
	@PostMapping
	public String post() {
		return "requisição post";
	}
	
	@PutMapping
	public String put() {
		return "requisição put";
	}
	
	@PatchMapping
	public String patch() {
		return "requisição patch";
	}
	
	@DeleteMapping
	public String delete() {
		return "requisição delete";
	}
	
}
