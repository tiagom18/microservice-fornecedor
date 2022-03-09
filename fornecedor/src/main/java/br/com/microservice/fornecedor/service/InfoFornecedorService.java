package br.com.microservice.fornecedor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.microservice.fornecedor.modelo.InfoFornecedor;
import br.com.microservice.fornecedor.repository.InfoFornecedorRepository;

@Service
public class InfoFornecedorService {
	

	@Autowired
	private InfoFornecedorRepository ir;

	public InfoFornecedor getInfoFornecedorPorEstado(String estado) {
		
		return ir.findByEstado(estado);
	}

}
