package br.com.microservice.loja.teste;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import br.com.microservice.loja.dto.CompraDTO;
import br.com.microservice.loja.dto.EnderecoDTO;
import br.com.microservice.loja.dto.ItemDaCompraDTO;
import br.com.microservice.loja.service.CompraService;



public class TesteCompra {

	@Mock
	private CompraService cs;
	@Mock
	private CompraDTO c;
	@Mock
	private EnderecoDTO e;
	@Mock
	private ItemDaCompraDTO i;

	@Test
	void Compra() {
	CompraDTO compra = new CompraDTO();
	ItemDaCompraDTO itemcompra = new ItemDaCompraDTO();
	compra.setEndereco(e);
	itemcompra.setId(1);
	itemcompra.setQuantidade(2);
	itemcompra.setId(2);
	itemcompra.setQuantidade(2);
	compra.getItens();
	compra.getEndereco();
	
		
	}

}
