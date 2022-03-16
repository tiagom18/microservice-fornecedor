package br.com.microservice.fornecedor.teste;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import br.com.microservice.fornecedor.modelo.Cor;
import br.com.microservice.fornecedor.modelo.ItemPedido;
import br.com.microservice.fornecedor.modelo.Modelo;
import br.com.microservice.fornecedor.modelo.Produto;
import br.com.microservice.fornecedor.modelo.Tamanho;
import br.com.microservice.fornecedor.repository.PedidoRepository;
import br.com.microservice.fornecedor.service.PedidoService;

public class TestePedido {

	@Mock
	private PedidoService ps;

	@Mock
	private PedidoRepository pd;
	
	@Test
	void Pedido() {
	Produto prod = new Produto();
	ItemPedido itens  = new ItemPedido();
	prod.setCor(Cor.AMARELO);
	prod.setTamanho(Tamanho.G);
	prod.setModelo(Modelo.CALCA);
	itens.setQuantidade(2);
	itens.getProduto();
	itens.getQuantidade();
		
	}

}
