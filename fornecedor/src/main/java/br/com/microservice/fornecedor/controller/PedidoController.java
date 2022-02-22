package br.com.microservice.fornecedor.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.microservice.fornecedor.dto.ItemPedidoDTO;
import br.com.microservice.fornecedor.modelo.Pedido;
import br.com.microservice.fornecedor.service.PedidoService;

@RestController
@RequestMapping("pedido")
public class PedidoController {
	private static final Logger LOG = LoggerFactory.getLogger(PedidoController.class);

	@Autowired
	private PedidoService pedidoService;

	@PostMapping
	public Pedido realizaPedido(@RequestBody List<ItemPedidoDTO> roupas) {
		LOG.info("pedido recebido");
		return pedidoService.realizarPedido(roupas);
	}

	@GetMapping
	public Pedido getPedidoPorId(@PathVariable Long id) {
		return pedidoService.getPedidoPorId(id);
	}

	@DeleteMapping(value = {"id"})
	public Pedido removerItem(@PathVariable Pedido item) {
		return pedidoService.removerItem(item);
	}

}
