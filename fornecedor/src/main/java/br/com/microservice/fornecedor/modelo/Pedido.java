package br.com.microservice.fornecedor.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToMany;

@Entity
public class Pedido {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@OneToMany
	@JoinColumn(name = "produtoId")
	private List<Produto> produtos = new ArrayList<Produto>();
	
	private int quantidade;



	public Pedido(List<Produto> produtos, int quantidade) {
		
		this.produtos = produtos;
		this.quantidade = quantidade;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}





	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Pedido() {

	}

}