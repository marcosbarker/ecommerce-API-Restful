package com.residencia.ecommerce.vo;

import java.math.BigDecimal;
import java.util.Calendar;

public class PedidoVO {

	private Integer pedidoId;
	private Integer numeroDoPedido;
	private double valorTotalDoPedido;
	private Calendar dataDoPedido;
	private String status;
	private ClienteVO clienteVO;
	private ProdutoPedidoVO produtoPedidoVO;

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

	public ClienteVO getClienteVO() {
		return clienteVO;
	}

	public void setClienteVO(ClienteVO clienteVO) {
		this.clienteVO = clienteVO;
	}

	public ProdutoPedidoVO getProdutoPedidoVO() {
		return produtoPedidoVO;
	}

	public void setProdutoPedidoVO(ProdutoPedidoVO produtoPedidoVO) {
		this.produtoPedidoVO = produtoPedidoVO;
	}

		
	
}