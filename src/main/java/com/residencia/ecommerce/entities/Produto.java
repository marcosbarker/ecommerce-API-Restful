package com.residencia.ecommerce.entities;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "produtoid")
	private Integer produtoId;

	@Column(name = "nome")
	private String nome;

	@Column(name = "descricao")
	private String descricao;

	@Column(name = "preco")
	private String preco;

	@Column(name = "quantidadeEmEstoque")
	private String quantidadeEmEstoque;

	@Column(name = "dataDeCadastroDoProduto")
	private Calendar dataDeCadastroDoProduto;

	@Column(name = "imagem")
	private String imagem; // ver conversao de imagem em base64

	@Column(name = "categoriaId")
	private Integer categoriaId;

	// relacionamento com categoria
	@ManyToOne
	@JoinColumn(name = "categoriaid", referencedColumnName = "categoriaid")
	private Categoria categoria;

	// relacionamento com produtoPedido
	@ManyToMany
	@JoinColumn(name = "produtoPedidoid", referencedColumnName = "produtoPedidoid")
	private ProdutoPedido produtoPedido;

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

	public Integer getCategoriaId() {
		return categoriaId;
	}

	public void setCategoriaId(Integer categoriaId) {
		this.categoriaId = categoriaId;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}