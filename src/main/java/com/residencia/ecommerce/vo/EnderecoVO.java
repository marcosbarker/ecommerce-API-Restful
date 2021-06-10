package com.residencia.ecommerce.vo;

import java.util.List;

import com.residencia.ecommerce.entities.Cliente;

public class EnderecoVO {

	private Integer enderecoId;
	private String cep;
	private String logradouro; // RUA
	private String bairro;
	private String localidade; // CIDADE
	private Integer numero;
	private String complemento;
	private String uf; // ESTADO
	private List<ClienteVO> listClienteVO;

	public Integer getEnderecoId() {
		return enderecoId;
	}

	public void setEnderecoId(Integer enderecoId) {
		this.enderecoId = enderecoId;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public List<ClienteVO> getListClienteVO() {
		return listClienteVO;
	}

	public void setListCliente(List<ClienteVO> listClienteVO) {
		this.listClienteVO = listClienteVO;
	}

}
