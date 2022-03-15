package br.com.microservice.fornecedor.controller.dto;


import org.springframework.data.domain.Page;

import br.com.microservice.fornecedor.modelo.Cor;
import br.com.microservice.fornecedor.modelo.Modelo;
import br.com.microservice.fornecedor.modelo.Produto;
import br.com.microservice.fornecedor.modelo.Tamanho;

public class ProdutoDto {
	private Long id;
	private Cor cor;
	private Tamanho tamanho;
	private Modelo modelo;
	private String nome;
	private double preco;
	
	public ProdutoDto(Produto produto) {
		this.id = produto.getId();
		this.cor = produto.getCor();
		this.tamanho = produto.getTamanho();
		this.modelo = produto.getModelo();
		this.nome = produto.getNome();
		this.setPreco(produto.getPreco());
		}
	
	public ProdutoDto() {
	}

	public Long getId() {
		return id;
	}
	public Cor getCor() {
		return cor;
	}
	public Tamanho getTamanho() {
		return tamanho;
	}
	public Modelo getModelo() {
		return modelo;
	}
	public String getNome() {
		return nome;
	}
	
	public static Page<ProdutoDto> converter(Page<Produto> produto) {
		return produto.map(ProdutoDto::new);
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
}
