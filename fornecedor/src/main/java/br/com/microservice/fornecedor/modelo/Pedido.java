package br.com.microservice.fornecedor.modelo;



import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.springframework.boot.autoconfigure.domain.EntityScan;
@EntityScan
public class Pedido {
	private int id;
	private Double valorTotal;

	@Enumerated(EnumType.STRING)
	private Status status;
	@Enumerated(EnumType.STRING)
	private Cor cor;
	@Enumerated(EnumType.STRING)
	private Tamanho tamanho;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "pedidoId")
	private List<ItemPedido> itens;

	public Pedido(Double valorTotal, Status status, Cor cor, Tamanho tamanho) {

		this.valorTotal = valorTotal;
		this.status = status;
		this.cor = cor;
		this.tamanho = tamanho;

	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public List<ItemPedido> getItens() {
		return itens;
	}

	public void setItens(List<ItemPedido> itens) {
		this.itens = itens;
	}

	public Pedido() {

	}
}