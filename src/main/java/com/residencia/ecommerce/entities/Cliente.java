package com.residencia.ecommerce.entities;

import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "client")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "clientid ")
	private Integer clientId;

	@Column(name = "email")
	private String email;

	@Column(name = "username", unique = true)
	private String username;

	@Column(name = "senha")
	private String senha;

	@Column(name = "nome")
	private String nome;

	@Column(name = "cpf", unique = true)
	private Integer cpf;

	@Column(name = "telefone")
	private String telefone;

	@Column(name = "datadenascimento")
	private Calendar dataDeNascimento;

	@ManyToOne
	@JoinColumn(name = "enderecoid", referencedColumnName = "enderecoid")
	private Endereco endereco;

	@OneToMany(mappedBy = "cliente")
	private List<Pedido> listPedido;

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

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Pedido> getListPedido() {
		return listPedido;
	}

	public void setListPedido(List<Pedido> listPedido) {
		this.listPedido = listPedido;
	}

	
	
}
