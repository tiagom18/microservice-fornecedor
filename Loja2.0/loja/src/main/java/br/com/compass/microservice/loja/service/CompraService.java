package br.com.compass.microservice.loja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import br.com.compass.microservice.loja.controller.dto.CompraDTO;
import br.com.compass.microservice.loja.controller.dto.InfoFornecedorDTO;

public class CompraService {
	@Autowired
 private RestTemplate client;
	
	
	public void realizaCompra(CompraDTO compra) {
		
            RestTemplate client = new RestTemplate();
            ResponseEntity<InfoFornecedorDTO> exchange = 
            client.exchange("http://fornecedor/fornecedor"+
            compra.getEndereco().getEstado(),HttpMethod.GET,null,InfoFornecedorDTO.class);
	}

}
