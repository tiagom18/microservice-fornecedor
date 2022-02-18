package br.com.microservice.fornecedor.modelo;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

public class ItemPedido {
private long id;
private int quantidade;
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
	return quantidade;
}
public void setQuantidade(int quantidade) {
	this.quantidade = quantidade;
}
public Produto getProduto() {
	return produto;
}
public void setProduto(Produto produto) {
	this.produto = produto;
}


}
