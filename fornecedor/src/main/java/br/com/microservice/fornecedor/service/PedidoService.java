package br.com.microservice.fornecedor.service;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.microservice.fornecedor.dto.ItemPedidoDTO;
import br.com.microservice.fornecedor.modelo.Cor;
import br.com.microservice.fornecedor.modelo.ItemPedido;
import br.com.microservice.fornecedor.modelo.Modelo;
import br.com.microservice.fornecedor.modelo.Pedido;
import br.com.microservice.fornecedor.modelo.Produto;
import br.com.microservice.fornecedor.modelo.Status;
import br.com.microservice.fornecedor.modelo.Tamanho;
import br.com.microservice.fornecedor.repository.PedidoRepository;
import br.com.microservice.fornecedor.repository.RoupaRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoR;
	@Autowired
	private RoupaRepository roupaR;

	public Pedido realizarPedido(List<ItemPedidoDTO> itens) {
		List<ItemPedido> itemPedido = toPedido(itens);
		Pedido pedido = new Pedido();
		pedidoR.quantidadeByItem(itens);
		return pedidoR.save(pedido);
	}

	private List<ItemPedido> toPedido(List<ItemPedidoDTO> itens) {
		List<Long> idsRoupas = itens.stream().map(item -> item.getId()).collect(Collectors.toList());

		List<Produto> produtosDoPedido = roupaR.findById(idsRoupas);

		List<ItemPedido> pedidoItens = itens.stream().map(item -> {
			Produto produto = produtosDoPedido.stream().filter(p -> p.getId() == item.getId()).findFirst().get();

			ItemPedido pedido = new ItemPedido();
			pedido.setProduto(produto);
			pedido.setQuantidade(item.getQuantidade());
			return pedido;

		}).collect(Collectors.toList());
		return pedidoItens;
	}
	public Pedido getPedidoPorId(Long id) {
		return this.pedidoR.findById(id).orElse(new Pedido());
	}
	
	public Pedido removerItem(List<ItemPedidoDTO> iten) {
		List<ItemPedido> itemPedido = toPedido(iten);
	return pedidoR.deleteByItem(iten);
	}
}
