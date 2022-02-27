package br.com.microservice.fornecedor.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.microservice.fornecedor.controller.dto.ProdutoDto;
import br.com.microservice.fornecedor.controller.form.PedidoForm;
import br.com.microservice.fornecedor.modelo.Pedido;
import br.com.microservice.fornecedor.modelo.Produto;
import br.com.microservice.fornecedor.repository.PedidoRepository;
import br.com.microservice.fornecedor.repository.ProdutoRepository;

@Service
public class PedidoService {
	@Autowired
	PedidoRepository pedidoRepository;
	@Autowired
	ProdutoRepository produtoRepository;
	
	public Pedido cadastrar(PedidoForm form, List<ProdutoDto> itens) {
		
			List<Produto> produtos = produto(itens);
			Pedido pedido = new Pedido(produtos);
			pedido = form.converter();
			return pedidoRepository.save(pedido);
		}

	
	public List<Produto> produto(List<ProdutoDto> itens){
		List<Produto> produto = new ArrayList<Produto>();
		List<Pedido> pedido = new ArrayList<Pedido>();
		for (Pedido listaPedido : pedido) {
			listaPedido.getProdutos();
			listaPedido.getQuantidade();
			
		}
		return produto;
				
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


