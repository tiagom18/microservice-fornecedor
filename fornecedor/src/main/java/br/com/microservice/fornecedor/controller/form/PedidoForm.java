package br.com.microservice.fornecedor.controller.form;

import javax.validation.constraints.NotNull;

import br.com.microservice.fornecedor.modelo.Pedido;
import br.com.microservice.fornecedor.modelo.Produto;
import br.com.microservice.fornecedor.repository.PedidoRepository;

public class PedidoForm {

	@NotNull
	private int quantidade;
	@NotNull
	private Produto produto;


	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Pedido atualizar(Long id, PedidoRepository pedidoRepository) {
		Pedido pedido = pedidoRepository.getById(id);

		return pedido;

	}

	public Pedido converter() {

		return new Pedido();
	}

}