package br.com.microservice.fornecedor.controller.form;

import javax.validation.constraints.NotNull;

import br.com.microservice.fornecedor.modelo.InfoFornecedor;
import br.com.microservice.fornecedor.modelo.Produto;
import br.com.microservice.fornecedor.repository.InfoFornecedorRepository;
import br.com.microservice.fornecedor.repository.ProdutoRepository;

public class InfoFornecedorForm {

	@NotNull
	private String nome;
	@NotNull
	private String estado;
	@NotNull
	private String endereco;
	
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
	public InfoFornecedor converter() {
		return new InfoFornecedor(nome, estado, endereco);
	}
	
	
	public InfoFornecedor atualizar(Long id, InfoFornecedorRepository fornecedorRepository) {
		InfoFornecedor infoFornecedor = fornecedorRepository.getOne(id);
		infoFornecedor.setEndereco(this.endereco);
		infoFornecedor.setEstado(this.estado);
		infoFornecedor.setNome(this.nome);
	
		return infoFornecedor;
	
}
}
