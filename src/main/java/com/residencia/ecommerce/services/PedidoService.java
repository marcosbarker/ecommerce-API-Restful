package com.residencia.ecommerce.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.residencia.ecommerce.entities.Pedido;
import com.residencia.ecommerce.repositories.PedidoRepository;

public class PedidoService {
	
	@Autowired
	PedidoRepository pedidorepository;
	
	public Pedido findById(Integer id) {
		return pedidorepository.findById(id).get();
	}
	
	public java.util.List<Pedido> findAll() {
		return pedidorepository.findAll();
	}
	
	public Long count() {
		return pedidorepository.count();
	}

	public Pedido save(Pedido pedido) {
		Object novoPedido = pedidorepository.save(pedido);
		return (Pedido) novoPedido;
	}

	public Pedido update(Pedido pedido, Integer id) {
		pedido.setPedidoId(id);
		return this.save(pedido);
	}

	public void delete(Integer id) {
		pedidorepository.deleteById(id);
	}

}