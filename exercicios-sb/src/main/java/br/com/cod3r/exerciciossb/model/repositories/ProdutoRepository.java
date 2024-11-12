package br.com.cod3r.exerciciossb.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.cod3r.exerciciossb.model.entities.Produto;

/*
 * 
 * e o extends PagingAndSortingRepository ele permite fazer consulta por paginação 
 * e extends CrudRepository<T,Identificador>  aqui estamos extends de outra interface 
 * e essa interface nos permite fazer o crud. Porém antes precisamos informar 
 * a nossa entidade e qual o tipo do identificador dela, observe que só pode ser 
 * classe wraps 
 * obs 1: uma interface pode extends de outra interface
 * obs 2: no Spring 3.0.0 o PagingAndSortingRepository não funciona como antes,
 * ele foi substituido por JpaRepository. Por motivos desconhecidos ele não tem mais os mesmos metodos de antigamente.
 * 
 */

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
	//o spring ele contem uma das varias conversões e esssa é uma das que ele tem, repare bem "findBy|nome que vc quiser|Containing|IgnoreCase|
	public Iterable<Produto> findByNomeContainingIgnoreCase(String parteNome);
	
	//passando query também é possivel 
	@Query("SELECT p FROM Produto p WHERE p.nome LIKE %:nome%")
	public Iterable<Produto> searchByNomeLike(@Param("nome") String nome);
	
	}
