package br.com.microservice.fornecedor.controller.form;

import java.util.List;

import br.com.microservice.fornecedor.modelo.Pedido;
import br.com.microservice.fornecedor.modelo.Produto;

public class ItemPedidoForm {

	private Produto produto;
	private Pedido pedido;
	private int quantidade;
	private List<Produto> produtoLista;
	
	
	
	
	public Pedido getPedido() {
		return pedido;
	}
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
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
	public List<Produto> getProdutoLista() {
		return produtoLista;
	}
	public void setProdutoLista(List<Produto> produtoLista) {
		this.produtoLista = produtoLista;
	}
	

	
	
	
}
