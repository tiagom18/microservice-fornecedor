package br.com.microservice.fornecedor.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class InfoFornecedor implements Serializable {

	private static final long serialVersionUID = 7915038820583474048L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String nome;

	private String estado;

	private String endereco;
	
	

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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public InfoFornecedor(Long id, String nome, String estado, String endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.estado = estado;
		this.endereco = endereco;
	}

	public InfoFornecedor() {

	}
}
