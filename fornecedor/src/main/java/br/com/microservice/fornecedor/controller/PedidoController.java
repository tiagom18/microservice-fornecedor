package br.com.microservice.fornecedor.controller;

import java.net.URI;
import java.util.Optional;

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
import br.com.microservice.fornecedor.repository.PedidoRepository;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
	

		
		
		@Autowired
		private PedidoRepository pedidoRepository;
		
		
		@PostMapping
		@Transactional
		@CacheEvict(value = "listaDePedido", allEntries = true)
		public ResponseEntity<PedidoDto> cadastrar(@RequestBody @Valid PedidoForm form, UriComponentsBuilder uriBuilder) {
			Pedido produto = form.converter();
			pedidoRepository.save(produto);
			URI uri = uriBuilder.path("/produto/{id}").buildAndExpand(produto.getId()).toUri();
			return ResponseEntity.created(uri).body(new PedidoDto(produto));

		}

		@GetMapping("/{id}")
		public ResponseEntity<PedidoDto> detalhar(@PathVariable Long id) {
			Optional<Pedido> produto = pedidoRepository.findById(id);
			if (produto.isPresent()) {
				return ResponseEntity.ok(new PedidoDto(produto.get()));
			}
			return ResponseEntity.notFound().build();

		}

		@PutMapping("/{id}")
		@Transactional
		@CacheEvict(value = "listaDePedido", allEntries = true)
		public ResponseEntity<PedidoDto> atualizar(@PathVariable Long id, @RequestBody @Valid PedidoForm form) {
			Optional<Pedido> optional = pedidoRepository.findById(id);
			if (optional.isPresent()) {
				Pedido produto = form.atualizar(id, pedidoRepository);
				return ResponseEntity.ok(new PedidoDto(produto));
			}
			return ResponseEntity.notFound().build();

		}

		@DeleteMapping("/{id}")
		@Transactional
		@CacheEvict(value = "listaDePedido", allEntries = true)
		public ResponseEntity<?> remover(@PathVariable Long id) {
			Optional<Pedido> optional = pedidoRepository.findById(id);
			if (optional.isPresent()) {
				pedidoRepository.deleteById(id);
				return ResponseEntity.ok().build();
			}
			return ResponseEntity.notFound().build();

		}
	}


