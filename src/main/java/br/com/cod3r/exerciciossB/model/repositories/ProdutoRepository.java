package br.com.cod3r.exerciciossB.model.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.cod3r.exerciciossB.model.entity.Produto;

@Repository
public interface ProdutoRepository 
extends PagingAndSortingRepository<Produto, Integer> {

	public Iterable<Produto> findByNomeContainingIgnoreCase(String parteNome);
	
}
