package br.com.compass.microservice.loja.controller.dto;

import org.springframework.web.bind.annotation.RequestMapping;

public class ItemDaCompraDTO {
private Long id; 
private int quatidade;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public int getQuatidade() {
	return quatidade;
}
public void setQuatidade(int quatidade) {
	this.quatidade = quatidade;
}


}
