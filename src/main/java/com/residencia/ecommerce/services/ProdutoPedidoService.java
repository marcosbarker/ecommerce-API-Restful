package com.residencia.ecommerce.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.ecommerce.entities.ProdutoPedido;
import com.residencia.ecommerce.repositories.ProdutoPedidoRepository;

@Service
public class ProdutoPedidoService {
	
	@Autowired
	public ProdutoPedidoRepository produtoPedidoRepository;
	
	public List<ProdutoPedido> findAll(){
		return produtoPedidoRepository.findAll();
		
	}
	
	public Optional<ProdutoPedido> findById(Integer id){
		return produtoPedidoRepository.findById(id);
		
	}

}