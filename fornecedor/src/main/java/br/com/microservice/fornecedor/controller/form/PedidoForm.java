package br.com.microservice.fornecedor.controller.form;

import java.util.List;

import javax.validation.constraints.NotNull;

import br.com.microservice.fornecedor.modelo.Pedido;
import br.com.microservice.fornecedor.modelo.Produto;
import br.com.microservice.fornecedor.repository.PedidoRepository;

public class PedidoForm {
	

	@NotNull
	private int quantidade;
	
	private List<Produto> produtos;

	
	
	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}



	
	

	public Pedido atualizar(Long id, PedidoRepository pedidoRepository) {
		Pedido pedido = pedidoRepository.getOne(id);
		pedido.setProdutos(produtos);
		pedido.setQuantidade(this.quantidade);
		return pedido;
		
		
	}

	public Pedido converter() {
		return new Pedido(produtos, quantidade);
	}

	
}
