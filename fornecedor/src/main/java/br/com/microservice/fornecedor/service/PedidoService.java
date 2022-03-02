package br.com.microservice.fornecedor.service;

import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.microservice.fornecedor.controller.dto.PedidoDto;
import br.com.microservice.fornecedor.controller.form.PedidoForm;
import br.com.microservice.fornecedor.modelo.Pedido;
import br.com.microservice.fornecedor.repository.PedidoRepository;
import br.com.microservice.fornecedor.repository.ProdutoRepository;

@Service
public class PedidoService {
	@Autowired
	PedidoRepository pedidoRepository;
	@Autowired
	ProdutoRepository produtoRepository;
	
	public Pedido cadastrar(PedidoForm form) {
		
			Pedido pedido = new Pedido();
			Pedido produto = form.converter();
			
			return pedidoRepository.save(produto);
		}

	

	
	

	
	@GetMapping("/{id}")
    public ResponseEntity<PedidoDto> detalhar(@PathVariable Long id) {
        Optional<Pedido> pedido = pedidoRepository.findById(id);
        if (pedido.isPresent()) {
            return ResponseEntity.ok(new PedidoDto(pedido.get()));
        }
        return ResponseEntity.notFound().build();

    }
	
	
	
	@PutMapping("/{id}")
    @Transactional
    public ResponseEntity<PedidoDto> atualizar(@PathVariable Long id, @RequestBody @Valid PedidoForm form) {
        Optional<Pedido> optional = pedidoRepository.findById(id);
        if (optional.isPresent()) {
        	Pedido pedido = form.atualizar(id, pedidoRepository);
            return ResponseEntity.ok(new PedidoDto(pedido));
        }
        return ResponseEntity.notFound().build();

    }

	
	@DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> remover(@PathVariable Long id) {
        Optional<Pedido> optional = pedidoRepository.findById(id);
        if(optional.isPresent()) {
        	pedidoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();

    }
}


