package br.com.microservice.fornecedor.dto;

import br.com.microservice.fornecedor.modelo.Produto;

public class ItemPedidoDTO {
	private long id;

	private int quantidadePedido;
	private Produto produto;

	public ItemPedidoDTO(int quantidadePedido, Produto produto) {
		this.produto = produto;
		this.quantidadePedido = quantidadePedido;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getQuantidadePedido() {
		return quantidadePedido;
	}

	public void setQuantidadePedido(int quantidadePedido) {
		this.quantidadePedido = quantidadePedido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	

}
