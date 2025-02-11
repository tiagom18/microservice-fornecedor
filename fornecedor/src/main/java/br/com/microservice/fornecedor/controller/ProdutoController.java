package br.com.microservice.fornecedor.controller;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.microservice.fornecedor.controller.dto.ProdutoDto;
import br.com.microservice.fornecedor.controller.form.ProdutoForm;
import br.com.microservice.fornecedor.modelo.Cor;
import br.com.microservice.fornecedor.modelo.Modelo;
import br.com.microservice.fornecedor.modelo.Produto;
import br.com.microservice.fornecedor.modelo.Tamanho;
import br.com.microservice.fornecedor.repository.ProdutoRepository;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	
		
		@Autowired
		private ProdutoRepository produtoRepository;

		@GetMapping("/cor")
		@Cacheable(value="listaDeProdutoPorCor")
		@Operation(summary = "Mostra um produto por cor", description = "Para mostrar um produto passe a cor do produto, o tamanho da pagina e a quantidade de produtos por pagina")
		public Page<ProdutoDto> listarCor(@RequestParam(required = false) Cor cor, @RequestParam int pagina,
				@RequestParam int quantidade) {

			Pageable paginacao = PageRequest.of(pagina, quantidade);

			if (cor == null) {
				Page<Produto> produto = produtoRepository.findAll(paginacao);
				return ProdutoDto.converter(produto);
			} else {

				Page<Produto> produto = produtoRepository.findByCor(cor, paginacao);
				return ProdutoDto.converter(produto);
			}
		}
		
		@GetMapping("/tamanho")
		@Cacheable(value="listaDeProdutoPorTamanho")
		@Operation(summary = "Mostra um produto por tamanho", description = "Para mostrar um produto passe o tamanho do produto, o tamanho da pagina e a quantidade de produtos por pagina")
		public Page<ProdutoDto> listarTamanho(@RequestParam(required = false) Tamanho tamanho, @RequestParam int pagina,
				@RequestParam int quantidade) {

			Pageable paginacao = PageRequest.of(pagina, quantidade);

			if (tamanho == null) {
				Page<Produto> produto = produtoRepository.findAll(paginacao);
				return ProdutoDto.converter(produto);
			} else {

				Page<Produto> produto = produtoRepository.findByTamanho(tamanho, paginacao);
				return ProdutoDto.converter(produto);
			}
		}
		@GetMapping("/modelo")
		@Cacheable(value="listaDeProdutoPorModelo")
		@Operation(summary = "Mostra um produto por modelo", description = "Para mostrar um produto passe o modelo do produto, o tamanho da pagina e a quantidade de produtos por pagina")
		public Page<ProdutoDto> listarModelo(@RequestParam(required = false) Modelo modelo, @RequestParam int pagina,
				@RequestParam int quantidade) {

			Pageable paginacao = PageRequest.of(pagina, quantidade);

			if (modelo == null) {
				Page<Produto> produto = produtoRepository.findAll(paginacao);
				return ProdutoDto.converter(produto);
			} else {

				Page<Produto> produto = produtoRepository.findByModelo(modelo, paginacao);
				return ProdutoDto.converter(produto);
			}
		}
		@PostMapping
		@Transactional
		@CacheEvict(value = "listaDeProduto", allEntries = true)
	    @Operation(summary = "Cadastra um produto novo", description = "Para cadastrar um novo produto passe a cor (PRETO, BRANCO, ROSA, AZUL, VERDE, AMARELO, VERMELHOR, ROXO),"
	    		+ " tamanho (P, M, G), modelo (VESTIDO, BLUSA, CALCA, CAMISETA, PIJAMA, SAIA), nome e preço")
		public ResponseEntity<ProdutoDto> cadastrar(@RequestBody @Valid ProdutoForm form, UriComponentsBuilder uriBuilder) {
			Produto produto = form.converter();
			produtoRepository.save(produto);
			URI uri = uriBuilder.path("/produto/{id}").buildAndExpand(produto.getId()).toUri();
			return ResponseEntity.created(uri).body(new ProdutoDto(produto));

		}

		@GetMapping("/{id}")
	    @Operation(summary = "Mostra um produto por ID", description = "Para mostrar um produto passe o ID do produto")
		public ResponseEntity<ProdutoDto> detalhar(@PathVariable Long id) {
			Optional<Produto> produto = produtoRepository.findById(id);
			if (produto.isPresent()) {
				return ResponseEntity.ok(new ProdutoDto(produto.get()));
			}
			return ResponseEntity.notFound().build();

		}

		@PutMapping("/{id}")
		@Transactional
		@CacheEvict(value = "listaDeProduto", allEntries = true)
		@Operation(summary = "Atualiza um produto por ID", description = "Para atualizar um produto passe o ID do produto e altere as informacoes a baixo")
		public ResponseEntity<ProdutoDto> atualizar(@PathVariable Long id, @RequestBody @Valid ProdutoForm form) {
			Optional<Produto> optional = produtoRepository.findById(id);
			if (optional.isPresent()) {
				Produto produto = form.atualizar(id, produtoRepository);
				return ResponseEntity.ok(new ProdutoDto(produto));
			}
			return ResponseEntity.notFound().build();

		}

		@DeleteMapping("/{id}")
		@Transactional
		@CacheEvict(value = "listaDeProduto", allEntries = true)
		@Operation(summary = "Remove um produto por ID", description = "Para remover um produto passe o ID do produto")
		public ResponseEntity<?> remover(@PathVariable Long id) {
			Optional<Produto> optional = produtoRepository.findById(id);
			if (optional.isPresent()) {
				produtoRepository.deleteById(id);
				return ResponseEntity.ok().build();
			}
			return ResponseEntity.notFound().build();

		}
	}





