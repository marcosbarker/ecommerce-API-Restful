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

import com.residencia.ecommerce.entities.Produto;
import com.residencia.ecommerce.services.ProdutoService;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	ProdutoService produtoService;

	@GetMapping("/{id}")
	public ResponseEntity<Produto> findById(@PathVariable Integer id) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(produtoService.findById(id), headers, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Produto>> findAll() throws Exception {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(produtoService.findAll(), headers, HttpStatus.OK);
	}

	@GetMapping("/count")
	public Long count() {
		return produtoService.count();
	}

	@PostMapping
	public ResponseEntity<Produto> save(@RequestBody Produto produto) {

		HttpHeaders headers = new HttpHeaders();

		Produto novoProduto = produtoService.save(produto);

		if (null != novoProduto)
			return new ResponseEntity<>(novoProduto, headers, HttpStatus.OK);
		else
			return new ResponseEntity<>(novoProduto, headers, HttpStatus.BAD_REQUEST);
	}

	@PutMapping("/{id}")
	public Produto update(@RequestBody Produto produto, Integer id) {
		return produtoService.update(produto, id);
	}

	@DeleteMapping("/{id}")
	public void DeleteById(@PathVariable Integer id) {
		produtoService.delete(id);
	}

}