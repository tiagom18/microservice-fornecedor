package br.com.microservice.fornecedor.service;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.microservice.fornecedor.dto.ItemPedidoDTO;
import br.com.microservice.fornecedor.modelo.Pedido;
import br.com.microservice.fornecedor.modelo.Roupa;
import br.com.microservice.fornecedor.repository.PedidoRepository;
import br.com.microservice.fornecedor.repository.RoupaRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoR;
	@Autowired
	private RoupaRepository roupaR;

	public Pedido realizarPedido(List<ItemPedidoDTO> itens) {
		List<Pedido> itemPedido = toPedido(itens);
		Pedido pedido = new Pedido();
		return pedidoR.save(pedido);
	}

	private List<Pedido> toPedido(List<ItemPedidoDTO> itens) {
		List<Long> idsRoupas = itens.stream().map(item -> item.getId()).collect(Collectors.toList());

		List<Roupa> produtosDoPedido = roupaR.findById(idsRoupas);

		List<Pedido> pedidoItens = itens.stream().map(item -> {
			Roupa roupa = produtosDoPedido.stream().filter(p -> p.getId() == item.getId()).findFirst().get();

			Pedido pedido = new Pedido();
			pedido.setRoupa(roupa);
			pedido.setQuantidade(item.getQuantidade());
			return pedido;

		}).collect(Collectors.toList());
		return pedidoItens;
	}
	public Pedido getPedidoPorId(Long id) {
		return this.pedidoR.findById(id).orElse(new Pedido());
	}
}
