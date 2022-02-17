package br.com.microservice.fornecedor.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.microservice.fornecedor.modelo.Roupa;
import br.com.microservice.fornecedor.repository.ProdutoRepository;

@Service
public interface IProdutoService {
	private ProdutoRepository produtoR;
	
	public List<Roupa> getProdutoPorEstado(String estado){
		return produtoR.findByEstado(estado);
	}
	 
}
