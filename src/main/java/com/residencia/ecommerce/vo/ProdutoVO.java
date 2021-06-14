package com.residencia.ecommerce.vo;

import java.time.LocalDate;
import java.util.Calendar;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class ProdutoVO {

	private Integer produtoId;
	
	@NotBlank(message = "Insira o nome do produto a ser cadastrado")
	private String nome;
	
	@NotBlank(message = "Insira a descrição do produto a ser cadastrado")
	private String descricao;
	
	@NotNull(message = "Insira o valor do produto a ser cadastrado")
	@Min (value = 1, message = "Valor invalido" )
	private Double preco;
	
	@NotNull(message = "Insira a quantidade do estoque do produto a ser cadastrado")
	private Integer quantidadeEmEstoque;
	
	private String nomeCategoria;
	
	private LocalDate dataDeCadastroDoProduto;
	
	private CategoriaVO categoriaVO;

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

	public LocalDate getDataDeCadastroDoProduto() {
		return dataDeCadastroDoProduto;
	}

	public void setDataDeCadastroDoProduto(LocalDate dataDeCadastroDoProduto) {
		this.dataDeCadastroDoProduto = dataDeCadastroDoProduto;
	}

	public CategoriaVO getCategoriaVO() {
		return categoriaVO;
	}

	public void setCategoriaVO(CategoriaVO categoriaVO) {
		this.categoriaVO = categoriaVO;
	}

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	
	
	

}