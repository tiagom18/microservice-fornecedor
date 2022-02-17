package br.com.microservice.fornecedor.service;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.microservice.fornecedor.repository.InfoProvedorRepository;

public interface IInfoProvedorService {

	private static final Logger log = LoggerFactory.getLogger(InfoService.class);

	@Autowired
	private InfoProvedorRepository infoProvedorRepository;

	public InfoFornecedor getInfoPorEstado(String estado) {
	    log.info("informaÃ§Ãµes buscadas");
	    return infoRepository.findByEstado(estado);
}
