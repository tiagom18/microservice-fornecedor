package br.com.microservice.fornecedor.modelo;


import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;
	
	private String estado;
	
	private String descricao;
	



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



	public Produto(Long id, String nome, String descricao) {
		this.id = id;
		this.nome = nome;
	
	}

	public Produto() {

	}
}
