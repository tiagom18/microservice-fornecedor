package br.com.microservice.fornecedor.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.microservice.fornecedor.modelo.InfoFornecedor;

public interface InfoProvedorRepository extends CrudRepository<InfoFornecedor, Long> {

	InfoFornecedor findByEstado(String estado);
}
