package br.com.microservice.fornecedor.controller.dto;

import br.com.microservice.fornecedor.modelo.InfoFornecedor;

public class InfoFornecedorDto {
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

	public InfoFornecedorDto(InfoFornecedor infoFornecedor) {
		this.endereco = infoFornecedor.getEndereco();
		this.estado = infoFornecedor.getEstado();
		this.nome = infoFornecedor.getNome();
		this.id = infoFornecedor.getId();

	}
}
