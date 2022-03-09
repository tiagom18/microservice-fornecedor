package br.com.microservice.loja.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.microservice.loja.client.FornecedorClient;
import br.com.microservice.loja.dto.CompraDTO;
import br.com.microservice.loja.dto.InfoFornecedorDTO;
import br.com.microservice.loja.dto.InfoPedidoDTO;
import br.com.microservice.loja.model.Compra;

@Service
public class CompraService {
	
	
	
	@Autowired
	private FornecedorClient fornecedorClient;

	public Compra realizaCompra(CompraDTO compra) {
		
		final String estado = compra.getEndereco().getEstado();
		
		
		InfoFornecedorDTO info = fornecedorClient.getInFornecedorfoPorEstado(estado);
		
	
		InfoPedidoDTO infoPedido = fornecedorClient.realizaPedido(compra.getItens());
		
		Compra compraSalva = new Compra();
		compraSalva.setPedidoId(infoPedido.getId());
	
		compraSalva.setEnderecoDestino(info.getEndereco());
		
		System.out.println(info.getEndereco());
		
		return compraSalva;
	}
	
}
