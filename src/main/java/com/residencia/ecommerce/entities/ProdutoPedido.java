package com.residencia.ecommerce.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "produtos_pedidos")
public class ProdutoPedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "produtoPedidoid")
	private Integer produtoPedidoId;

	@Column(name = "produtoid")
	private Integer produtoId;

	@Column(name = "pedidosId")
	private Integer pedidosId;

	@Column(name = "quantidade")
	private Integer quantidade;

	@Column(name = "preco")
	private Integer preco;

	// relacionamento com produto
	@OneToOne
	@JoinColumn(name = "produto")
	private Produto produto;
	
	// relacionamento com pedido
	@OneToOne
	@JoinColumn(name = "pedido")
	private Pedido pedido;
	
	public Integer getProdutoPedidoId() {
		return produtoPedidoId;
	}

	public void setProdutoPedidoId(Integer produtoPedidoId) {
		this.produtoPedidoId = produtoPedidoId;
	}

	public Integer getProdutoId() {
		return produtoId;
	}

	public void setProdutoId(Integer produtoId) {
		this.produtoId = produtoId;
	}

	public Integer getPedidosId() {
		return pedidosId;
	}

	public void setPedidosId(Integer pedidosId) {
		this.pedidosId = pedidosId;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Integer getPreco() {
		return preco;
	}

	public void setPreco(Integer preco) {
		this.preco = preco;
	}

}