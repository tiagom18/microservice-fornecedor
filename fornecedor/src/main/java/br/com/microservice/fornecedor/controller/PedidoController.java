package br.com.microservice.fornecedor.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.microservice.fornecedor.controller.dto.PedidoDto;
import br.com.microservice.fornecedor.controller.dto.PedidoProdutoDto;
import br.com.microservice.fornecedor.controller.form.PedidoForm;
import br.com.microservice.fornecedor.modelo.Pedido;
import br.com.microservice.fornecedor.modelo.Produto;
import br.com.microservice.fornecedor.repository.PedidoRepository;
import br.com.microservice.fornecedor.service.PedidoService;
import io.swagger.v3.oas.annotations.Operation;


@RestController
@RequestMapping("/pedido")
public class PedidoController {

	@Autowired
	private PedidoRepository pedidoRepository;
	
    @Autowired
    private PedidoService pedidoService;

    @RequestMapping(method = RequestMethod.POST)
    @Operation(summary = "Cadastra um pedido novo", description = "Para cadastrar um novo pedido passe o ID do produto nescessario e a quantidade")
    public Pedido realizaPedido(@RequestBody List<PedidoProdutoDto> produtos) {
        return pedidoService.realizaPedido(produtos);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Mostra um pedido por ID", description = "Para mostrar um pedido passe o ID do pedido")
    public ResponseEntity<Optional<Pedido>> getPedidoPorId(@PathVariable Long id) {
        return pedidoService.getPedidoPorId(id);
    }
  
    @DeleteMapping("/{id}")
    @Operation(summary = "Remove um pedido por ID", description = "Para remover um pedido passe o ID do pedido")
    public ResponseEntity<Pedido> deletaPedidoPorId(@PathVariable Long id) {
        return pedidoService.remover(id);
    }
    
}