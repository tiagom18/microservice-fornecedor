package br.com.microservice.fornecedor.controller.dto;

import org.springframework.data.domain.Page;

import br.com.microservice.fornecedor.modelo.Pedido;
import br.com.microservice.fornecedor.modelo.Produto;

public class PedidoDto {
	private Long id;
	private int quantidade;
	private Produto produto;


	public PedidoDto(Pedido pedido) {
		this.id = pedido.getId();
		this.quantidade = pedido.getQuantidade();
		this.produto = getProduto();

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



	public static Page<PedidoDto> converter(Page<Pedido> pedido) {
		return pedido.map(PedidoDto::new);
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
}