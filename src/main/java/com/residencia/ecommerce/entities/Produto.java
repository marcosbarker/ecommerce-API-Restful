package com.residencia.ecommerce.entities;

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
	private double preco;

	@Column(name = "quantidadeestoque")
	private Integer quantidadeEmEstoque;

	@Column(name = "datadecadastro")
	private Calendar dataDeCadastroDoProduto;

//	@Column(name = "imagem")
//	private String imagem; // ver conversao de imagem em base64

	// relacionamento com categoria
	@ManyToOne
	@JoinColumn(name = "categoriaid", referencedColumnName = "categoriaid")
	private Categoria categoria;

	// relacionamento com produtoPedido
	@OneToOne(mappedBy = "produto")
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

//	public String getImagem() {
//		return imagem;
//	}
//
//	public void setImagem(String imagem) {
//		this.imagem = imagem;
//	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public ProdutoPedido getProdutoPedido() {
		return produtoPedido;
	}

	public void setProdutoPedido(ProdutoPedido produtoPedido) {
		this.produtoPedido = produtoPedido;
	}

}