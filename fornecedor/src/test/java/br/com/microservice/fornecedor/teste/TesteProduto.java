package br.com.microservice.fornecedor.teste;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import br.com.microservice.fornecedor.modelo.Cor;
import br.com.microservice.fornecedor.modelo.Modelo;
import br.com.microservice.fornecedor.modelo.Produto;
import br.com.microservice.fornecedor.modelo.Tamanho;
import br.com.microservice.fornecedor.repository.ProdutoRepository;
import br.com.microservice.fornecedor.service.ProdutoService;

public class TesteProduto {
	@Mock
	private ProdutoService ps;

	@Mock
	private ProdutoRepository pd;
	
	
	@Test
	void Produto() {
	Produto prod = new Produto();
	prod.setCor(Cor.AMARELO);
	prod.setTamanho(Tamanho.G);
	prod.setModelo(Modelo.CALCA);
	prod.getCor();
	prod.getModelo();
	prod.getTamanho();
		
	}
}
