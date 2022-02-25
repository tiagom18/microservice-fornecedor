package br.com.compass.microservice.fornecedor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.compass.microservice.fornecedor.model.Fornecedor;
import br.com.compass.microservice.fornecedor.repository.FornecedorRepository;

@Service
public class FornecedorService {

	@Autowired
	private FornecedorRepository fornecedorRepository;

	public Fornecedor informacaoPorEstado(String estado) {
         
		
		return fornecedorRepository.findByEstado(estado);
	}

}
