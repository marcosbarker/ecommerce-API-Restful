package com.residencia.ecommerce.vo;

import java.util.Calendar;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;



public class ClienteVO {
	
	
	private Integer clientId;
	
	@NotBlank(message = "Insira seu e-mail")
    @Email
    @Pattern(regexp = ".+@.+\\..+", message = "E-mail fornecido não é válido")
	private String email;
	
	@NotBlank(message = "Insira um nome")
	@Size(max = 15, message = "Limite de so {max} caracteres")
	private String username;
	
	@NotBlank(message = "Insira uma senha")
	@Min(message = "Insira uma senha com mais de {value} caracteres", value = 4)
	private String senha;
	
	@NotBlank(message = "Insira um nome")
	private String nome;

	@NotBlank(message = "Insira um CPF")
	@CPF
	@Pattern(regexp = "([0-9]{3}[.]?[0-9]{3}[.]?[0-9]{3}-[0-9]{2})|([0-9]{11})", message = "Insira um CPF válido")
	private String cpf; 
	
	
	@NotBlank(message = "Insira apenas números do seu telefone com DDD.")
	@Size(min = 10, max = 11, message = "Insira número com no mínimo {min} e no máximo {max} dígitos.")
	private String telefone;
	
	
	private Calendar dataDeNascimento;
	
	
	private EnderecoVO enderecoVO;
	private List<PedidoVO> listPedidoVO;
	
	@NotBlank(message = "Insira o seu CEP")
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
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
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
