package br.com.microservice.fornecedor.modelo;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.boot.autoconfigure.domain.EntityScan;
@EntityScan
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	@Enumerated(EnumType.STRING)
	private Cor cor;
	@Enumerated(EnumType.STRING)
	private Tamanho tamanho;
	@Enumerated(EnumType.STRING)
	private Modelo modelo;

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
