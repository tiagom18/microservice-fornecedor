package br.com.microservice.fornecedor.modelo;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

import org.springframework.boot.autoconfigure.domain.EntityScan;
@EntityScan
public class ItemPedido {
	private long id;
	private int quantidadePedido;

	@ManyToMany
	@JoinColumn(name = "produtoId")
	private Produto produto;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getQuantidade() {
		return quantidadePedido;
	}

	public void setQuantidade(int quantidadePedido) {
		this.quantidadePedido = quantidadePedido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

}
