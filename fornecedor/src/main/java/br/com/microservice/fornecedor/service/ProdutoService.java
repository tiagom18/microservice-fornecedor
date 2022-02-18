package br.com.microservice.fornecedor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.microservice.fornecedor.modelo.Produto;
import br.com.microservice.fornecedor.repository.RoupaRepository;

@Service
public class ProdutoService {

	@Autowired
	private RoupaRepository roupaR;

	public List<Produto> getRoupasPorEstado(String estado) {
		
		return this.roupaR.findByEstado(estado);
	}
}
