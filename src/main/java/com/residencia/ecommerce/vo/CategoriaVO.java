package com.residencia.ecommerce.vo;

import java.util.List;

import javax.validation.constraints.NotBlank;


public class CategoriaVO {
	
	private Integer categoriaId;
	
	@NotBlank(message = "Insira o nome da categoria do produto")
	private String nome;
	
	@NotBlank(message = "Insira a descrição da categoria do produto")
	private String descricao;
	private List<ProdutoVO> listProdutoVO;
	
	
	public Integer getCategoriaId() {
		return categoriaId;
	}
	public void setCategoriaId(Integer categoriaId) {
		this.categoriaId = categoriaId;
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
	public List<ProdutoVO> getListProdutoVO() {
		return listProdutoVO;
	}
	public void setListProdutoVO(List<ProdutoVO> listProdutoVO) {
		this.listProdutoVO = listProdutoVO;
	}
	
	

}
