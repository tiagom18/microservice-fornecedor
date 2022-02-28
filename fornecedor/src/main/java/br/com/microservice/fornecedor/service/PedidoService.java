package br.com.microservice.fornecedor.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.microservice.fornecedor.controller.form.PedidoForm;
import br.com.microservice.fornecedor.modelo.Pedido;
import br.com.microservice.fornecedor.repository.PedidoRepository;
import br.com.microservice.fornecedor.repository.ProdutoRepository;

@Service
public class PedidoService {
	@Autowired
	PedidoRepository pedidoRepository;
	@Autowired
	ProdutoRepository produtoRepository;
	
	public Pedido cadastrar(PedidoForm form) {
		
			Pedido pedido = new Pedido();
			Pedido produto = form.converter();
			
			return pedidoRepository.save(produto);
		}

	

	
	
	public Pedido detalhar(Long id) {
		return this.pedidoRepository.findById(id).orElse(new Pedido());
	
		}
	
	
	public Pedido atualizar( Long id, PedidoForm form) {
		Optional<Pedido> optional = pedidoRepository.findById(id);
		if (optional.isPresent()) {
			Pedido pedido = form.atualizar(id, pedidoRepository);
			return pedidoRepository.save(pedido);
			
		}
		return new Pedido();

	}
	
	public Pedido remover(@PathVariable Long id) {
		Optional<Pedido> optional = pedidoRepository.findById(id);
		if (optional.isPresent()) {
			pedidoRepository.deleteById(id);
			return pedidoRepository.save(id);
		}
		return null;

	}
}


