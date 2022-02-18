package br.com.microservice.fornecedor.dto;

public class ItemPedidoDTO {
	private long id;

	private int quantidadePedido;

	public ItemPedidoDTO(int quantidadePedido) {

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

	

	
}
