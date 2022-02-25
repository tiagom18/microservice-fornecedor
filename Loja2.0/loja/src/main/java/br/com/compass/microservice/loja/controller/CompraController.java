package br.com.compass.microservice.loja.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.compass.microservice.loja.controller.dto.CompraDTO;
import br.com.compass.microservice.loja.service.CompraService;


@RestController
@RequestMapping("/compra")

public class CompraController {
	@Autowired
	private CompraService compraservice;

	@RequestMapping(method = RequestMethod.POST)
	public void realizaCompra(@RequestBody CompraDTO compra) {
		compraservice.realizaCompra(compra);

	}

}
