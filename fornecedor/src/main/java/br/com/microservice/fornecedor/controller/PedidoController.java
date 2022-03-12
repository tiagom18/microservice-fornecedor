package br.com.microservice.fornecedor.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.microservice.fornecedor.controller.dto.PedidoDto;
import br.com.microservice.fornecedor.controller.dto.PedidoProdutoDto;
import br.com.microservice.fornecedor.modelo.Pedido;
import br.com.microservice.fornecedor.service.PedidoService;


@RestController
@RequestMapping("pedido")
public class PedidoController {


    @Autowired
    private PedidoService pedidoService;

    @RequestMapping(method = RequestMethod.POST)
    public Pedido realizaPedido(@RequestBody List<PedidoProdutoDto> produtos) {
        return pedidoService.realizaPedido(produtos);
    }

    @RequestMapping("/{id}")
    public ResponseEntity<Optional<Pedido>> getPedidoPorId(@PathVariable Long id) {
        return pedidoService.getPedidoPorId(id);
    }
}