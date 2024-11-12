package br.com.cod3r.exerciciossb.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.cod3r.exerciciossb.model.entities.Produto;
import br.com.cod3r.exerciciossb.model.repositories.ProdutoRepository;
import jakarta.validation.Valid;

@RestController // falando que esssa classe é o controller
@RequestMapping(path = "/api/produtos") // link que irá bater no http para validar as informações passadas
public class ProdutoController {

	@Autowired // ele automaticamente cria obj dentro do tipo ProdutoRepository
	private ProdutoRepository produtoRepository;

	/*
	@PostMapping // falando que esse metodo vai ser usado como post, quando n tem nenhuma url
					// associada aqui, ele bate na url da classe e faz o post
	public @ResponseBody Produto novoProduto(@RequestParam String nome) { // requestParam indica que o parametro desse
																			// metodo que vai ser recebido na batida do
																			// url.
																			// ResponseBody indica que este produto faz
																			// do corpo da resposta( O corpo da resposta
																			// é o formato de resposta de uma
																			// solicitação de API REST, que é um objeto
																			// JSON )
		Produto produto = new Produto(nome);
		produtoRepository.save(produto);// sem isso ele não irá persistir o produto

		return produto;
	}
	*/

	// desafio
	@PostMapping("/novoProduto2") // não precisa do url se não quiser
	public Produto novoProduto2(@RequestParam(value = "nome") String nome, @RequestParam(value = "preco") double preco,
			@RequestParam(value = "desconto") double desconto) {
		Produto produto = new Produto(nome, preco, desconto);

		produtoRepository.save(produto);
		return produto;
	}

	@RequestMapping(method = {RequestMethod.POST,RequestMethod.PUT})//também podemos passar um metodo para 2 ações
	public Produto novoProduto3(@Valid Produto produto) { // @valid ele vai aplicar as validações passadas na classe
															// produto através da validação nos atributos
		produtoRepository.save(produto);
		return produto;
	}
	
	@GetMapping   
	public Iterable<Produto> obterProdutos() { //consulta normal
		return produtoRepository.findAll();
	}
	
	@GetMapping(path = "/nome/{parteNome}")
	public Iterable<Produto> obterProdutosPorNome(@PathVariable String parteNome) { //consulta por nome
//		return produtoRepository.findByNomeContainingIgnoreCase(parteNome);
		return produtoRepository.searchByNomeLike(parteNome);
	}
	
	@GetMapping(path = "/{id}")
	public Optional<Produto> obterProdutos(@PathVariable int id) { //consulta por id
		return produtoRepository.findById(id);
	}
	
	@GetMapping(path = "/pagina/{numeroPagina}")
	public Iterable<Produto> consultaPaginada(@PathVariable int numeroPagina,@PathVariable int qtdPagina) { //consulta paginada com limitação
		if(qtdPagina >= 5) qtdPagina = 5;
		Pageable page = PageRequest.of(numeroPagina, qtdPagina);
		return produtoRepository.findAll(page);
	}
	
	
	
	@PutMapping
	public Produto alterarProduto(@Valid Produto produto) {
		produtoRepository.save(produto);
		return produto;
	}
	
	@DeleteMapping(path = "/{id}")
	public void deletarProduto(@PathVariable int id) {
		produtoRepository.deleteById(id);
		
	}
	
	

}
