package br.com.microservice.fornecedor.modelo;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Roupa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private float preco;
	@Enumerated(EnumType.STRING)
	private Categoria categoria;

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public Roupa(Long id, String nome, String descricao, float preco, Categoria categoria) {
		this.id = id;
		this.nome = nome;
		this.categoria = categoria;
		this.preco = preco;
	}

	public Roupa() {

	}
}
