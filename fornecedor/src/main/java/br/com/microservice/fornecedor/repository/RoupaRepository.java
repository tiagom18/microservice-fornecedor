package br.com.microservice.fornecedor.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.microservice.fornecedor.modelo.Cor;
import br.com.microservice.fornecedor.modelo.Modelo;
import br.com.microservice.fornecedor.modelo.Produto;
import br.com.microservice.fornecedor.modelo.Tamanho;

public interface RoupaRepository extends CrudRepository<Produto, Long> {

	List<Produto> findById(List<Long> idsRoupas);
	Produto findByCor(Cor cor);
	Produto findByTamanho(Tamanho tamanho);
	Produto findByModelo(Modelo modelo);
	

}
