package br.com.microservice.fornecedor.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.microservice.fornecedor.modelo.Produto;

public interface RoupaRepository extends CrudRepository<Produto, Long> {

	List<Produto> findByEstado(String estados);

	List<Produto> findById(List<Long> ids);

}
