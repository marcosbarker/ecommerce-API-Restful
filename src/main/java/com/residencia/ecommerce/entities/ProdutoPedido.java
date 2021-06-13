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
	@Column(name = "produtospedidosid")
	private Integer produtoPedidoId;

	@Column(name = "quantidade")
	private Integer quantidade;

	@Column(name = "preco")
	private double preco;

	// relacionamento com produto
	@OneToOne
	@JoinColumn(name = "produtoid", referencedColumnName = "produtoid")
	private Produto produto;
	
	// relacionamento com pedido
	@OneToOne
	@JoinColumn(name = "pedidoid", referencedColumnName = "pedidoid")
	private Pedido pedido;
	
	public Integer getProdutoPedidoId() {
		return produtoPedidoId;
	}

	public void setProdutoPedidoId(Integer produtoPedidoId) {
		this.produtoPedidoId = produtoPedidoId;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	
	

}