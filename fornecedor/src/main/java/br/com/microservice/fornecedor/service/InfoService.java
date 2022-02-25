package br.com.microservice.fornecedor.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.microservice.fornecedor.modelo.InfoFornecedor;
import br.com.microservice.fornecedor.repository.InfoFornecedorRepository;

@Service
public class InfoService {
	private static final Logger log = LoggerFactory.getLogger(InfoService.class);

	@Autowired
	private InfoFornecedorRepository ir;

	public InfoFornecedor getInfoPorEstado(String estado) {
		log.info("informacao buscada");
		return ir.findByEstado(estado);
	}

}
