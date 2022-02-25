package br.com.compass.microservice.fornecedor.repository;
import org.springframework.data.repository.CrudRepository;

import br.com.compass.microservice.fornecedor.model.Fornecedor;

public interface FornecedorRepository extends CrudRepository <Fornecedor, Long> {

	
	
	Fornecedor findByEstado (String estado);
}
