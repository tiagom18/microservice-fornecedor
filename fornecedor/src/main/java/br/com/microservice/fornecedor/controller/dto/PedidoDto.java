package br.com.microservice.fornecedor.controller.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.microservice.fornecedor.modelo.Pedido;
import br.com.microservice.fornecedor.modelo.Produto;

public class PedidoDto {
	private Long id;
	private int quantidade;
	private List<ProdutoDto> produtos;

	public PedidoDto(Pedido pedido) {
		this.id = pedido.getId();
		this.quantidade = pedido.getQuantidade();
		this.produtos = new ArrayList<>();
		this.produtos.addAll(produtos);

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
		return produtos;
	}

	public void setProduto(List<ProdutoDto> produtos) {
		this.produtos = produtos;
	}
	public static List<PedidoDto> converter(List<Pedido> pedido) {

        return pedido.stream().map(PedidoDto::new).collect(Collectors.toList());
    }
}
