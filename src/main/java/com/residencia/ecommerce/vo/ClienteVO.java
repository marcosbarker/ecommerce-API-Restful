package com.residencia.ecommerce.vo;

import java.util.Calendar;
import java.util.List;


public class ClienteVO {
	
	
	private Integer clientId;
	private String email;
	private String username;
	private String senha;
	private String nome;
	private Integer cpf;
	private String telefone;
	private Calendar dataDeNascimento;
	private EnderecoVO enderecoVO;
	private List<PedidoVO> listPedidoVO;
	
	private String cep;
	private Integer numeroCasa;
	
	public Integer getClientId() {
		return clientId;
	}
	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getCpf() {
		return cpf;
	}
	public void setCpf(Integer cpf) {
		this.cpf = cpf;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public Calendar getDataDeNascimento() {
		return dataDeNascimento;
	}
	public void setDataDeNascimento(Calendar dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}
	public EnderecoVO getEnderecoVO() {
		return enderecoVO;
	}
	public void setEnderecoVO(EnderecoVO enderecoVO) {
		this.enderecoVO = enderecoVO;
	}
	public void setListPedidoVO(List<PedidoVO> listPedidoVO) {
		this.listPedidoVO = listPedidoVO;
	}
	public List<PedidoVO> getListPedidoVO() {
		return listPedidoVO;
	}
	
	
	
	
	
	
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public Integer getNumeroCasa() {
		return numeroCasa;
	}
	public void setNumeroCasa(Integer numeroCasa) {
		this.numeroCasa = numeroCasa;
	}
	
}
