package br.com.microservice.fornecedor.controller;




import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.microservice.fornecedor.dto.ItemPedidoDTO;
import br.com.microservice.fornecedor.modelo.Pedido;
import br.com.microservice.fornecedor.service.IPedidoService;


@RestController
@RequestMapping(" /pedido ")
public class PedidoController {

	@Autowired
	private IPedidoService iPedidoService;

	@RequestMapping(method = RequestMethod.POST)
	public Pedido realizaPedido(@RequestBody List<ItemPedidoDTO> produtos) {
		log.info("Solicitação do pedido recebida");

		return iPedidoService.realizaPedido(produtos);

		return iPedidoService.placePedido(produtos);

	}

	@RequestMapping("/{id}")
	public Pedido getPedidoById(@PathVariable Long id) {
		return iPedidoService.getPedidobyId(id);
	}

}
