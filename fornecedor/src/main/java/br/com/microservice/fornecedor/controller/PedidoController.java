package br.com.microservice.fornecedor.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.microservice.fornecedor.controller.dto.PedidoDto;
import br.com.microservice.fornecedor.controller.form.PedidoForm;
import br.com.microservice.fornecedor.modelo.Pedido;
import br.com.microservice.fornecedor.modelo.Produto;
import br.com.microservice.fornecedor.repository.PedidoRepository;
import br.com.microservice.fornecedor.service.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
	

		
		
		@Autowired
		private PedidoService pedidoService;
		@Autowired
		private PedidoRepository pedidoRepository;
		
		@PostMapping
		@Transactional
		@CacheEvict(value = "listaDePedido", allEntries = true)
		public ResponseEntity<PedidoDto> cadastrar(@RequestBody @Valid PedidoForm form, UriComponentsBuilder uriBuilder) {
			
			Pedido pedido = form.converter();
			pedidoRepository.save(pedido);
			URI uri = uriBuilder.path("/produto/{id}").buildAndExpand(pedido.getId()).toUri();
			return ResponseEntity.created(uri).body(new PedidoDto(pedido));

		}

	
		
	
		@GetMapping("/{id}")
		public ResponseEntity<PedidoDto> detalhar(@PathVariable Long id) {
		return pedidoService.detalhar(id);

		}

		
		@PutMapping("/{id}")
		@Transactional
		@CacheEvict(value = "listaDePedido", allEntries = true)
		public ResponseEntity<PedidoDto> atualizar(@PathVariable Long id, @RequestBody @Valid PedidoForm form) {
			return pedidoService.atualizar(id, form);

		}

		@DeleteMapping("/{id}")
		@Transactional
		@CacheEvict(value = "listaDePedido", allEntries = true)
		public ResponseEntity<?> remover(@PathVariable Long id) {
		
			return pedidoService.remover(id);

		}
	}


