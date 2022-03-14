package br.com.microservice.fornecedor.teste;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import br.com.microservice.fornecedor.modelo.InfoFornecedor;
import br.com.microservice.fornecedor.repository.InfoFornecedorRepository;
import br.com.microservice.fornecedor.service.InfoFornecedorService;


public class TesteFornecedor {

	@Mock
	private InfoFornecedorService is;

	@Mock
	private InfoFornecedorRepository fr;
	
	@Test
	void Infofornecedor() {
	InfoFornecedor forne = new InfoFornecedor();
	
	forne.setNome("maria das modas ");
	forne.setEstado("Goias");
	forne.setEndereco("quadra 44");
	forne.getNome();
	forne.getEndereco();
	forne.getEstado();
	
	}

}
