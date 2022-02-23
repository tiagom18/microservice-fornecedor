package br.com.microservice.fornecedor.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.microservice.fornecedor.modelo.Cor;
import br.com.microservice.fornecedor.modelo.Modelo;
import br.com.microservice.fornecedor.modelo.Produto;
import br.com.microservice.fornecedor.modelo.Tamanho;


public interface ProdutoRepository extends JpaRepository<Produto, Long>{

	Page<Produto> findByCor(@RequestParam("cor") Cor cor, Pageable paginacao);
	Page<Produto> findByTamanho(@RequestParam("tamanho") Tamanho tamanho, Pageable paginacao);
	Page<Produto> findByModelo(@RequestParam("modelo") Modelo modelo, Pageable paginacao);
	
	

}