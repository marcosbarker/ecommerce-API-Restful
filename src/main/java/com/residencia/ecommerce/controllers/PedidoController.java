package com.residencia.ecommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.residencia.ecommerce.entities.Categoria;
import com.residencia.ecommerce.entities.Pedido;
import com.residencia.ecommerce.services.PedidoService;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
	
	@Autowired
	PedidoService pedidoService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Pedido> findById(@PathVariable Integer id) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(pedidoService.findById(id), headers, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Pedido>> findAll() throws Exception {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(pedidoService.findAll(), headers, HttpStatus.OK);
	}
	
	@GetMapping("/count")
	public Long count() {
		return pedidoService.count();
	}
	
	@PostMapping
	public ResponseEntity<Pedido> save(@RequestBody Pedido pedido){
		
		HttpHeaders headers = new HttpHeaders();
		
		Categoria novoPedido = pedidoService.save(pedido);
		
		if(null != novoPedido)
			return new ResponseEntity<>(novoPedido, headers, HttpStatus.OK);
		else
			return new ResponseEntity<>(novoPedido, headers, HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping("/{id}")
	public Categoria update(@RequestBody Pedido pedido, Integer id) {
		return pedidoService.update(pedido, id);
	}

	@DeleteMapping("/{id}")
	public void DeleteById(@PathVariable Integer id) {
		pedidoService.delete(id);
	}
}
