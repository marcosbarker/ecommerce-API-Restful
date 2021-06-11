package com.residencia.ecommerce.vo;

import java.util.Calendar;


public class ProdutoVO {

	private Integer produtoId;
	private String nome;
	private String descricao;
	private String preco;
	private String quantidadeEmEstoque;
	private Calendar dataDeCadastroDoProduto;
	private String imagem;
	private CategoriaVO categoriaVO;
	private ProdutoPedidoVO produtoPedidoVO;

	public Integer getProdutoId() {
		return produtoId;
	}

	public void setProdutoId(Integer produtoId) {
		this.produtoId = produtoId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}

	public String getQuantidadeEmEstoque() {
		return quantidadeEmEstoque;
	}

	public void setQuantidadeEmEstoque(String quantidadeEmEstoque) {
		this.quantidadeEmEstoque = quantidadeEmEstoque;
	}

	public Calendar getDataDeCadastroDoProduto() {
		return dataDeCadastroDoProduto;
	}

	public void setDataDeCadastroDoProduto(Calendar dataDeCadastroDoProduto) {
		this.dataDeCadastroDoProduto = dataDeCadastroDoProduto;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public CategoriaVO getCategoriaVO() {
		return categoriaVO;
	}

	public void setCategoriaVO(CategoriaVO categoriaVO) {
		this.categoriaVO = categoriaVO;
	}

	public ProdutoPedidoVO getProdutoPedidoVO() {
		return produtoPedidoVO;
	}

	public void setProdutoPedidoVO(ProdutoPedidoVO produtoPedidoVO) {
		this.produtoPedidoVO = produtoPedidoVO;
	}
	
	

}