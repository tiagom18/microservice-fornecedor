package br.com.microservice.fornecedor.modelo;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class Categoria {
	@Enumerated(EnumType.STRING)
	private Tamanho tamanho;
	@Enumerated(EnumType.STRING)
	private Cor cor;
	@Enumerated(EnumType.STRING)
	private TipoDeRoupa tipoDeRoupa;
	
	public Tamanho getTamanho() {
		return tamanho;
	}
	public void setTamanho(Tamanho tamanho) {
		this.tamanho = tamanho;
	}
	public Cor getCor() {
		return cor;
	}
	public void setCor(Cor cor) {
		this.cor = cor;
	}
	public TipoDeRoupa getTipoDeRoupa() {
		return tipoDeRoupa;
	}
	public void setTipoDeRoupa(TipoDeRoupa tipoDeRoupa) {
		this.tipoDeRoupa = tipoDeRoupa;
	}
	public Categoria(Tamanho tamanho, Cor cor, TipoDeRoupa tipoDeRoupa) {
		
		this.tamanho = tamanho;
		this.cor = cor;
		this.tipoDeRoupa = tipoDeRoupa;
	}
public Categoria() {
	
	}
	
}
