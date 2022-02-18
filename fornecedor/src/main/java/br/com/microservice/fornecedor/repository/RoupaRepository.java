package br.com.microservice.fornecedor.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.microservice.fornecedor.modelo.Roupa;

public interface RoupaRepository extends CrudRepository<Roupa, Long> {

	List<Roupa> findByEstado(String estados);

	List<Roupa> findById(List<Long> ids);

}
