package br.com.microservice.fornecedor.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.microservice.fornecedor.repository.PedidoRepository;
import br.com.microservice.fornecedor.repository.ProdutoRepository;

@Service
public interface IPedidoService {
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private ProdutoRepository produtoRepository;

}
