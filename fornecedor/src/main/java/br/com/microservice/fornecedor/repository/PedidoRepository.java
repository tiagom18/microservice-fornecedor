package br.com.microservice.fornecedor.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.microservice.fornecedor.modelo.Pedido;
import br.com.microservice.fornecedor.modelo.Produto;


public interface PedidoRepository extends JpaRepository<Pedido, Long>{

	Page<Pedido> findByProduto(@RequestParam("produto") Produto produto, Pageable paginacao);

	
	

}