package br.com.microservice.fornecedor.modelo;



import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class ItemPedido {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    @NotNull
    @OneToOne
    private Produto produto;
    @NotNull
    private int quantidade;

  

    public ItemPedido() {
		
	}

	public ItemPedido(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public long getId() {
        return id;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getValorTotal() {
        return quantidade * produto.getPreco();
    }
}