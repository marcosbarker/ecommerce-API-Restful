package com.residencia.ecommerce.vo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


public class CadastrarNovoPedidoVO {
	
	@NotBlank(message = "Insira qual produto você deseja")
	private String nomeProduto;
	
	@NotNull(message = "Insira a quantidade de produtos que você deseja")
	private Integer quantidadeProduto;
	
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public Integer getQuantidadeProduto() {
		return quantidadeProduto;
	}
	public void setQuantidadeProduto(Integer quantidadeProduto) {
		this.quantidadeProduto = quantidadeProduto;
	}
	
}
