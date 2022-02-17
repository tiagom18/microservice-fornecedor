package br.com.microservice.fornecedor.dto;

import lombok.Data;
import lombok.ToString;


@ToString
@Data
public class ItemPedidoDTO {
	private long id;
	private int quantidade;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public ItemPedidoDTO(long id, int quantidade) {
		
		this.id = id;
		this.quantidade = quantidade;
	}
	
	
public ItemPedidoDTO() {
		
		
	}
}
