package br.com.microservice.fornecedor.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.microservice.fornecedor.controller.dto.PedidoProdutoDto;
import br.com.microservice.fornecedor.modelo.Pedido;
import br.com.microservice.fornecedor.service.PedidoService;
import io.swagger.v3.oas.annotations.Operation;


@RestController
@RequestMapping("pedido")
public class PedidoController {


    @Autowired
    private PedidoService pedidoService;

    @RequestMapping(method = RequestMethod.POST)
    @Operation(summary = "Cadastra um pedido novo", description = "Para cadastrar um novo pedido passe o ID do produto nescessario e a quantidade")
    public Pedido realizaPedido(@RequestBody List<PedidoProdutoDto> produtos) {
        return pedidoService.realizaPedido(produtos);
    }

    @RequestMapping("/{id}")
    public ResponseEntity<Optional<Pedido>> getPedidoPorId(@PathVariable Long id) {
        return pedidoService.getPedidoPorId(id);
    }
}