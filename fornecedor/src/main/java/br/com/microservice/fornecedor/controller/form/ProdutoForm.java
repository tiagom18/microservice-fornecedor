package br.com.microservice.fornecedor.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.microservice.fornecedor.modelo.Cor;
import br.com.microservice.fornecedor.modelo.Modelo;
import br.com.microservice.fornecedor.modelo.Produto;
import br.com.microservice.fornecedor.modelo.Tamanho;
import br.com.microservice.fornecedor.repository.ProdutoRepository;

public class ProdutoForm {
	
	@NotNull
	private Cor cor;
	@NotNull
	private Tamanho tamanho;
	@NotNull
	private Modelo modelo;
	@NotNull@NotEmpty@Length(min = 1)
	private String nome;
	@NotNull
	private double preco;
	
	
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public Cor getCor() {
		return cor;
	}
	public void setCor(Cor cor) {
		this.cor = cor;
	}
	public Tamanho getTamanho() {
		return tamanho;
	}
	public void setTamanho(Tamanho tamanho) {
		this.tamanho = tamanho;
	}
	public Modelo getModelo() {
		return modelo;
	}
	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	public Produto converter() {
		return new Produto(cor, tamanho, modelo, nome,preco);
	}
	
	
	public Produto atualizar(Long id,ProdutoRepository produtoRepository) {
		Produto produto = produtoRepository.getOne(id);
		produto.setCor(this.cor);
		produto.setTamanho(this.tamanho);
		produto.setModelo(this.modelo);
		produto.setNome(this.nome);
		produto.setPreco(this.preco);
		return produto;
		
		
	}
	
	
	
}



