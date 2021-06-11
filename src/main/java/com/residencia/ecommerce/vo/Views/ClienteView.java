package com.residencia.ecommerce.vo.Views;

import java.util.List;

public class ClienteView {
	
	private String nome;
	private String email;
	private Integer cpf;
	private List<PedidoClienteView> listPedidoClienteView;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getCpf() {
		return cpf;
	}
	public void setCpf(Integer cpf) {
		this.cpf = cpf;
	}
	public List<PedidoClienteView> getListPedidoClienteView() {
		return listPedidoClienteView;
	}
	public void setListPedidoClienteView(List<PedidoClienteView> listPedidoClienteView) {
		this.listPedidoClienteView = listPedidoClienteView;
	}
	
	

}
