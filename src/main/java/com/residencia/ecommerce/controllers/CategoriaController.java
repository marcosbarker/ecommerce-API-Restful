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
import com.residencia.ecommerce.services.CategoriaService;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

	@Autowired
	CategoriaService categoriaService;

	@GetMapping("/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable Integer id) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(categoriaService.findById(id), headers, HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Categoria>> findAll() throws Exception {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(categoriaService.findAll(), headers, HttpStatus.OK);
	}

	@GetMapping("/count")
	public Long count() {
		return categoriaService.count();
	}

	@PostMapping
	public ResponseEntity<Categoria> save(@RequestBody Categoria categoria) {

		HttpHeaders headers = new HttpHeaders();

		Categoria novaCategoria = categoriaService.save(categoria);

		if (null != novaCategoria)
			return new ResponseEntity<>(novaCategoria, headers, HttpStatus.OK);
		else
			return new ResponseEntity<>(novaCategoria, headers, HttpStatus.BAD_REQUEST);
	}

	@PutMapping("/{id}")
	public Categoria update(@RequestBody Categoria categoria, Integer id) {
		return categoriaService.update(categoria, id);
	}

	@DeleteMapping("/{id}")
	public void DeleteById(@PathVariable Integer id) {
		categoriaService.delete(id);
	}

}