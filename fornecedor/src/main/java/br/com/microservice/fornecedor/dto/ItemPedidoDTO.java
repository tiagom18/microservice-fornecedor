package br.com.microservice.fornecedor.dto;

public class ItemPedidoDTO {
	private long id;

	private int quantidade;

	public ItemPedidoDTO(int quantidade) {

		this.quantidade = quantidade;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade() {
		this.quantidade = quantidade;

	}
}
