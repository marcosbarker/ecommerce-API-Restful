package com.residencia.ecommerce.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "produtoPedido")
public class ProdutoPedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "produtoPedidoId")
	private Integer produtoPedidoId;
	
	@Column(name = "produtoId")
	private Integer produtoId;
	
	@Column(name = "pedidosId")
	private Integer pedidosId;
	
	@Column(name = "quantidade")
	private Integer quantidade;
	
	@Column(name = "preco")
	private Integer preco;

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