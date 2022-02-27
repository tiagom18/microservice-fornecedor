package br.com.microservice.fornecedor.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.microservice.fornecedor.controller.dto.ProdutoDto;
import br.com.microservice.fornecedor.controller.form.PedidoForm;
import br.com.microservice.fornecedor.modelo.Pedido;
import br.com.microservice.fornecedor.service.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
	

		
		
		@Autowired
		private PedidoService pedidoService;
		
		
		@PostMapping
		@Transactional
		@CacheEvict(value = "listaDePedido", allEntries = true)
		public Pedido cadastrar(@RequestBody @Valid PedidoForm form,List<ProdutoDto> produto) {
			return pedidoService.cadastrar(form,produto) ;
		}

		
		
	
		@GetMapping("/{id}")
		public Pedido detalhar(@PathVariable Long id) {
		return pedidoService.detalhar(id);

		}

		@PutMapping("/{id}")
		@Transactional
		@CacheEvict(value = "listaDePedido", allEntries = true)
		public Pedido atualizar(@PathVariable Long id, @RequestBody @Valid PedidoForm form) {
			return pedidoService.atualizar(id, form);

		}

		@DeleteMapping("/{id}")
		@Transactional
		@CacheEvict(value = "listaDePedido", allEntries = true)
		public Pedido remover(@PathVariable Long id) {
		
			return pedidoService.remover(id);

		}
	}


