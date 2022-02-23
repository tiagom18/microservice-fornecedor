package br.com.microservice.fornecedor.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
@Entity
public class Estoque {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private int codigo;
	private String nome;
	private double qtTotal;
	private double qtMinima;
	@OneToMany
    private List <Produto> produtos = new ArrayList <Produto>();

   

	public Estoque(int codigo, String nome, double qtTotal, double qtMinima, List<Produto> produtos) {
	
		this.codigo = codigo;
		this.nome = nome;
		this.qtTotal = qtTotal;
		this.qtMinima = qtMinima;
		this.produtos = produtos;
	}


	public List<Produto> getProdutos() {
		return produtos;
	}


	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public double getQtTotal() {
		return qtTotal;
	}


	public void setQtTotal(double qtTotal) {
		this.qtTotal = qtTotal;
	}


	public double getQtMinima() {
		return qtMinima;
	}


	public void setQtMinima(double qtMinima) {
		this.qtMinima = qtMinima;
	}

}
