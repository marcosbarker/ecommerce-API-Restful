package com.residencia.ecommerce.vo.Views;

import java.util.List;

public class ClienteView {
	
	private String nome;
	private String email;
	private String cpf;
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
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String string) {
		this.cpf = string;
	}
	public List<PedidoClienteView> getListPedidoClienteView() {
		return listPedidoClienteView;
	}
	public void setListPedidoClienteView(List<PedidoClienteView> listPedidoClienteView) {
		this.listPedidoClienteView = listPedidoClienteView;
	}
	
	

}
