package br.com.microservice.fornecedor.modelo;

import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

import br.com.microservice.fornecedor.dto.ItemPedidoDTO;

public class Pedido {
	private int id;
	private Double valorTotal;
	private int quantidade;
	@ManyToMany
	@JoinColumn(name = "roupaId")
	private Roupa roupa;

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Roupa getRoupa() {
		return roupa;
	}

	public void setRoupa(Roupa roupa) {
		this.roupa = roupa;
	}

	public Pedido(int id, Double valorTotal, int quantidade, Roupa roupa) {

		this.id = id;
		this.valorTotal = valorTotal;
		this.quantidade = quantidade;
		this.roupa = roupa;

	}

	public Pedido() {

	}
}