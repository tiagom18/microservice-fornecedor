package br.com.microservice.fornecedor.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.microservice.fornecedor.dto.ItemPedidoDTO;
import br.com.microservice.fornecedor.modelo.Pedido;

public interface PedidoRepository extends CrudRepository<Pedido, Long> {

	Pedido deleteByItem(List<ItemPedidoDTO> iten);
	Pedido quantidadeByItem(List <ItemPedidoDTO> itens);



}
