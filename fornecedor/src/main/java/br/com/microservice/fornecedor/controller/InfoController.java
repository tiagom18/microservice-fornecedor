package br.com.microservice.fornecedor.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.microservice.fornecedor.modelo.InfoFornecedor;
import br.com.microservice.fornecedor.service.InfoService;

@RestController
@RequestMapping("/info")
public class InfoController {
	
private static final Logger LOG = LoggerFactory.getLogger(InfoController.class);
	
	@Autowired
	private InfoService infoService;
	
	@GetMapping("/{estado}")
	public InfoFornecedor getInfoPorEstado(@PathVariable String estado) {
		LOG.info("recebido pedido do fornecedor de {}", estado);
		return infoService.getInfoPorEstado(estado);
	}
	

}
