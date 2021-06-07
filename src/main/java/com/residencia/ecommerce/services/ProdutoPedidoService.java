package com.residencia.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.ecommerce.entities.ProdutoPedido;
import com.residencia.ecommerce.repositories.ProdutoPedidoRepository;

@Service
public class ProdutoPedidoService {

	@Autowired
	ProdutoPedidoRepository produtoPedidoRepository;

	public ProdutoPedido findById(Integer id) {
		return produtoPedidoRepository.findById(id).get();
	}

	public List<ProdutoPedido> findAll() {
		return produtoPedidoRepository.findAll();
	}

	public Long count() {
		return produtoPedidoRepository.count();
	}

	public ProdutoPedido save(ProdutoPedido produtoPedido) {
		ProdutoPedido novoProdutoPedido = produtoPedidoRepository.save(produtoPedido);
		return novoProdutoPedido;
	}

	public ProdutoPedido update(ProdutoPedido produtoPedido, Integer id) {
		produtoPedido.setProdutoPedidoId(id);
		return this.save(produtoPedido);
	}

	public void delete(Integer id) {
		produtoPedidoRepository.deleteById(id);
	}

}