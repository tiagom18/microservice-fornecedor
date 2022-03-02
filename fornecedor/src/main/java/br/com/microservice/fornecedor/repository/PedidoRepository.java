package br.com.microservice.fornecedor.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import br.com.microservice.fornecedor.modelo.Pedido;
import br.com.microservice.fornecedor.modelo.Produto;

@Component
public interface PedidoRepository extends JpaRepository<Pedido, Long>{

	Pedido save(Long id);

	Pedido save(Produto produto);


	

	
	

		
	

}