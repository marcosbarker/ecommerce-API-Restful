package com.residencia.ecommerce.vo;

import java.util.Calendar;

import javax.validation.constraints.NotBlank;


public class ProdutoVO {

	private Integer produtoId;
	
	@NotBlank(message = "Insira o nome do produto a ser cadastrado")
	private String nome;
	
	@NotBlank(message = "Insira a descrição do produto a ser cadastrado")
	private String descricao;
	
	@NotBlank(message = "Insira o valor do produto a ser cadastrado")
	private Double preco;
	
	@NotBlank(message = "Insira a quantidade do estoque do produto a ser cadastrado")
	private Integer quantidadeEmEstoque;
	
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

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public Integer getQuantidadeEmEstoque() {
		return quantidadeEmEstoque;
	}

	public void setQuantidadeEmEstoque(Integer quantidadeEmEstoque) {
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