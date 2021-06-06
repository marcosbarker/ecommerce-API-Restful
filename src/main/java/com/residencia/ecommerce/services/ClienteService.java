package com.residencia.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.ecommerce.entities.Cliente;
import com.residencia.ecommerce.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired 
	ClienteRepository clienteRepository;
	
	public Cliente FindById(Integer id) {
		return clienteRepository.findById(id).get();
	}
	
	public List<Cliente> FindAll() {
		return clienteRepository.findAll();
	}
	
	public Long count() {
		return clienteRepository.count();
	}
	
	public Cliente save(Cliente cliente) {
		Cliente novoCliente = clienteRepository.save(cliente);
		return novoCliente;
		
	}
	
	public Cliente update (Cliente cliente, Integer id) {
		cliente.setClientId(id);
		return this.save(cliente);
	}
	
	public void delete(Integer id) {
		clienteRepository.deleteById(id);
	}
	

}
