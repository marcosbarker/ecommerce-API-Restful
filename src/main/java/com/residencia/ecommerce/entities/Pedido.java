package com.residencia.ecommerce.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
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
	
	@Column(name = "numeropedido")
	private Integer numeroDoPedido;
	
	@Column(name = "valortotal")
	private double valorTotalDoPedido;
	
	@Column(name = "datadopedido")
	private LocalDate dataDoPedido;
	
	@Column(name = "status")
	private String status;
	
	//relacionamento com cliente
	@ManyToOne
	@JoinColumn(name = "clientid", referencedColumnName = "clientid")
	private Cliente cliente;
	
	//relacionameno com produtoPedido
	@OneToOne(mappedBy = "pedido")
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

	public double getValorTotalDoPedido() {
		return valorTotalDoPedido;
	}

	public void setValorTotalDoPedido(double valorTotalDoPedido) {
		this.valorTotalDoPedido = valorTotalDoPedido;
	}

	public LocalDate getDataDoPedido() {
		return dataDoPedido;
	}

	public void setDataDoPedido(LocalDate dataDoPedido) {
		this.dataDoPedido = dataDoPedido;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ProdutoPedido getProdutoPedido() {
		return produtoPedido;
	}

	public void setProdutoPedido(ProdutoPedido produto) {
		this.produtoPedido = produto;
	}
	
	
}