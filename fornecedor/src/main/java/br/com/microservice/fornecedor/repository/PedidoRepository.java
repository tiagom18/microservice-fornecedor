package br.com.microservice.fornecedor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import br.com.microservice.fornecedor.controller.dto.PedidoDto;
import br.com.microservice.fornecedor.modelo.Pedido;

@Component
public interface PedidoRepository extends JpaRepository<Pedido, Long>{

	Pedido save(Long id);
	
	

		
	

}