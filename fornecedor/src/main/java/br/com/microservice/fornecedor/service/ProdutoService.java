package br.com.microservice.fornecedor.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.microservice.fornecedor.modelo.Produto;
import br.com.microservice.fornecedor.repository.ProdutoRepository;

@Service
public class ProdutoService {

	private ProdutoRepository produtoRepository;
	
	public List<Produto> getProdutosPorEstado(List<Long> idsProdutos) {
		return produtoRepository.findByIdIn(idsProdutos);
	}

	
}

