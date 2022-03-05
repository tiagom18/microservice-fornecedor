package br.com.microservice.fornecedor.service;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import br.com.microservice.fornecedor.controller.dto.PedidoProdutoDto;
import br.com.microservice.fornecedor.modelo.ItemPedido;
import br.com.microservice.fornecedor.modelo.Pedido;
import br.com.microservice.fornecedor.modelo.Produto;
import br.com.microservice.fornecedor.repository.PedidoRepository;
import br.com.microservice.fornecedor.repository.ProdutoRepository;

@Service
public class PedidoService {
    
    @Autowired
    private PedidoRepository pedidoRepository;
    
    @Autowired
    private ProdutoRepository produtoRepository;

    public Pedido realizaPedido(List<PedidoProdutoDto> itens) {
        
        if(itens == null) {
            return null;
        }
        
        List<ItemPedido> itemPedido = ItemPedido(itens);
        Pedido pedido = new Pedido(itemPedido);
        pedido.setTempoDePreparo(itens.size());
        return pedidoRepository.save(pedido);
    }
    
    public Pedido getPedidoPorId(Long id) {
        return this.pedidoRepository.findById(id).orElse(new Pedido());
    }

    private List<ItemPedido> ItemPedido(List<PedidoProdutoDto> itens) {
        
        List<Long> idsProdutos = itens
                .stream()
                .map(item -> item.getId())
                .collect(Collectors.toList());
        
        List<Produto> pedidoProduto = produtoRepository.findById(idsProdutos);
        
        List<ItemPedido> pedidoItens = itens
            .stream()
            .map(item -> {
                Produto produto = pedidoProduto
                        .stream()
                        .filter(p -> p.getId() == item.getId())
                        .findFirst().get();
                
                ItemPedido itemPedido = new ItemPedido();
                itemPedido.setProduto(produto);
                itemPedido.setQuantidade(item.getQuantidade());
                return itemPedido;
            })
            .collect(Collectors.toList());
        return pedidoItens;
    }
}