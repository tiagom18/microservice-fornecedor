package br.com.microservice.fornecedor.controller;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.microservice.fornecedor.controller.dto.InfoFornecedorDto;
import br.com.microservice.fornecedor.controller.form.InfoFornecedorForm;
import br.com.microservice.fornecedor.modelo.InfoFornecedor;
import br.com.microservice.fornecedor.repository.InfoFornecedorRepository;
import br.com.microservice.fornecedor.service.InfoFornecedorService;
import io.swagger.v3.oas.annotations.Operation;
@RestController
@RequestMapping("/infoFornecedor")
public class InfoFornecedorController {
	

	@Autowired
	private InfoFornecedorService infoFornecedorService;
	
	@RequestMapping("/{estado}")
	@Operation(hidden = true)
	public InfoFornecedor getInfoPorEstado(@PathVariable String estado) {

		return infoFornecedorService.getInfoFornecedorPorEstado(estado);
	}
	

		
		
		@Autowired
		private InfoFornecedorRepository infoFornecedorRepository;
		
		
		@PostMapping
		@Transactional
		@CacheEvict(value = "listaDeFornecedor", allEntries = true)
	    @Operation(summary = "Cadastra um fornecedor novo", description = "Para cadastrar um novo fornecedor passe Nome, Estado e endereço")
		public ResponseEntity<InfoFornecedorDto> cadastrar(@RequestBody @Valid InfoFornecedorForm form, UriComponentsBuilder uriBuilder) {
			InfoFornecedor infoFornecedor = form.converter();
			infoFornecedorRepository.save(infoFornecedor);
			URI uri = uriBuilder.path("/infoFornecedor/{id}").buildAndExpand(infoFornecedor.getId()).toUri();
			return ResponseEntity.created(uri).body(new InfoFornecedorDto(infoFornecedor));

		}

		@PutMapping("/{id}")
		@Transactional
		@CacheEvict(value = "listaDeFornecedor", allEntries = true)
		@Operation(summary = "Atualiza um fornecedor por ID", description = "Para atualizar um fornecedor passe o ID do fornecedor e altere as informacoes a baixo")
		public ResponseEntity<InfoFornecedorDto> atualizar(@PathVariable Long id, @RequestBody @Valid InfoFornecedorForm form) {
			Optional<InfoFornecedor> optional = infoFornecedorRepository.findById(id);
			if (optional.isPresent()) {
				InfoFornecedor infoFornecedor = form.atualizar(id, infoFornecedorRepository);
				return ResponseEntity.ok(new InfoFornecedorDto(infoFornecedor));
			}
			return ResponseEntity.notFound().build();

		}

		@DeleteMapping("/{id}")
		@Transactional
		@CacheEvict(value = "listaDeFornecedor", allEntries = true)
		@Operation(summary = "Remove um fornecedor por ID", description = "Para remover um fornecedor passe o ID do fornecedor")
		public ResponseEntity<?> remover(@PathVariable Long id) {
			Optional<InfoFornecedor> optional = infoFornecedorRepository.findById(id);
			if (optional.isPresent()) {
				infoFornecedorRepository.deleteById(id);
				return ResponseEntity.ok().build();
			}
			return ResponseEntity.notFound().build();

		}
	}