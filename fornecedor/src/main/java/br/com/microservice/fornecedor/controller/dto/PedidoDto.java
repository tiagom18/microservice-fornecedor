package br.com.microservice.fornecedor.controller.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.microservice.fornecedor.modelo.Pedido;

public class PedidoDto {
	private Long id;
	private int quantidade;
	private List<ProdutoDto> produto;

	public PedidoDto(Pedido pedido) {
		this.id = pedido.getId();
		this.quantidade = pedido.getQuantidade();
		this.produto = new ArrayList<>();
		this.produto.addAll(produto);

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public List<ProdutoDto> getProduto() {
		return produto;
	}

	public void setProduto(List<ProdutoDto> produto) {
		this.produto = produto;
	}

}
