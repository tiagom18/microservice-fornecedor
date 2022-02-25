package br.com.compass.microservice.loja.controller.dto;

import java.util.List;

public class CompraDTO {
 private List<ItemDaCompraDTO> itens;
 
 private enderecoDTO endereco;

public List<ItemDaCompraDTO> getItens() {
	return itens;
}

public void setItens(List<ItemDaCompraDTO> itens) {
	this.itens = itens;
}

public enderecoDTO getEndereco() {
	return endereco;
}

public void setEndereco(enderecoDTO endereco) {
	this.endereco = endereco;
} 
 
 
}
