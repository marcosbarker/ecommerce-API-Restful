package com.residencia.ecommerce.vo;


public class ProdutoPedidoVO {

	private Integer produtoPedidoId;
	private Integer quantidade;
	private Integer preco;
	private ProdutoVO produtoVO; 
	private PedidoVO pedidoVO;
	
	
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

	public Integer getPreco() {
		return preco;
	}

	public void setPreco(Integer preco) {
		this.preco = preco;
	}

	public ProdutoVO getProdutoVO() {
		return produtoVO;
	}

	public void setProdutoVO(ProdutoVO produtoVO) {
		this.produtoVO = produtoVO;
	}

	public PedidoVO getPedidoVO() {
		return pedidoVO;
	}

	public void setPedidoVO(PedidoVO pedidoVO) {
		this.pedidoVO = pedidoVO;
	}
	
	

}