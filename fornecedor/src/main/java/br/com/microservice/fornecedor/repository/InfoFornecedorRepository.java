package br.com.microservice.fornecedor.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import br.com.microservice.fornecedor.modelo.InfoFornecedor;

public interface InfoFornecedorRepository extends JpaRepository<InfoFornecedor, Long> {

	InfoFornecedor findByEstado(String estado);

	
}
