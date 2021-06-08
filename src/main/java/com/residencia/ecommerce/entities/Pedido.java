package com.residencia.ecommerce.entities;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pedido")
public class Pedido {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pedidoid")
	private Integer pedidoId;
	
	@Column(name = "numerodopedido")
	private Integer numeroDoPedido;
	
	@Column(name = "listadeprodutosdopedido")
	private Integer listaDeProdutosDoPedido;
	
	@Column(name = "valortotaldopedido")
	private BigDecimal valorTotalDoPedido;
	
	@Column(name = "datadopedido")
	private Calendar dataDoPedido;
	
	@Column(name = "status")
	private String status;
	
	//relacionamento com cliente
	@ManyToOne
	@JoinColumn(name = "clientid", referencedColumnName = "clientid")
	private Cliente clienteid;
	
	//relacionameno com produtoPedido
	@OneToOne
	@JoinColumn(name = "produtoPedido")
	private ProdutoPedido produtoPedido;

	public Integer getPedidoId() {
		return pedidoId;
	}

	public void setPedidoId(Integer pedidoId) {
		this.pedidoId = pedidoId;
	}

	public Integer getNumeroDoPedido() {
		return numeroDoPedido;
	}

	public void setNumeroDoPedido(Integer numeroDoPedido) {
		this.numeroDoPedido = numeroDoPedido;
	}

	public Integer getListaDeProdutosDoPedido() {
		return listaDeProdutosDoPedido;
	}

	public void setListaDeProdutosDoPedido(Integer listaDeProdutosDoPedido) {
		this.listaDeProdutosDoPedido = listaDeProdutosDoPedido;
	}

	public BigDecimal getValorTotalDoPedido() {
		return valorTotalDoPedido;
	}

	public void setValorTotalDoPedido(BigDecimal valorTotalDoPedido) {
		this.valorTotalDoPedido = valorTotalDoPedido;
	}

	public Calendar getDataDoPedido() {
		return dataDoPedido;
	}

	public void setDataDoPedido(Calendar dataDoPedido) {
		this.dataDoPedido = dataDoPedido;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Cliente getClienteid() {
		return clienteid;
	}

	public void setClienteid(Cliente clienteid) {
		this.clienteid = clienteid;
	}

	public ProdutoPedido getProduto() {
		return produtoPedido;
	}

	public void setProduto(ProdutoPedido produto) {
		this.produtoPedido = produto;
	}
	
	
}