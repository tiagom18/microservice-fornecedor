package br.com.microservice.fornecedor.modelo;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Estoque {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private int qtd;

	public int getQtd() {
		return qtd;
	}

	public void setQtd(int qtd) {
		this.qtd = qtd;
	}

	public Estoque(int qtd, List<Produto> produtos) {

		this.qtd = qtd;

	}

}
