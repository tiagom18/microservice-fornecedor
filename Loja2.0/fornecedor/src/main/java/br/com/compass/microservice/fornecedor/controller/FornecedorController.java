package br.com.compass.microservice.fornecedor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.compass.microservice.fornecedor.model.Fornecedor;
import br.com.compass.microservice.fornecedor.service.FornecedorService;

@RestController
@RequestMapping("/informacao")
public class FornecedorController {
	
	@Autowired
	private FornecedorService fornecedorService;
	
	@RequestMapping("/{estado}") 
		public Fornecedor getInformacaoPorEstado (String estado) {
		
		return fornecedorService.informacaoPorEstado(estado);
			
		}
	}


