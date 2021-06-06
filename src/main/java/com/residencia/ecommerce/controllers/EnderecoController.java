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

import com.residencia.ecommerce.entities.Endereco;
import com.residencia.ecommerce.services.EnderecoService;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

	@Autowired
	public EnderecoService enderecoService;

	@GetMapping("/{id}")
	public ResponseEntity<Endereco> findById(@PathVariable Integer id) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(enderecoService.findById(id), headers, HttpStatus.OK);
	}

	@GetMapping("/list")
	public ResponseEntity<List<Endereco>> findAll() throws Exception {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(enderecoService.findAll(), headers, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Endereco> save(@RequestBody Endereco endereco) {
		HttpHeaders headers = new HttpHeaders();
		Endereco novoEndereco = enderecoService.save(endereco);

		if (null != novoEndereco)
			return new ResponseEntity<>(novoEndereco, headers, HttpStatus.OK);
		else
			return new ResponseEntity<>(novoEndereco, headers, HttpStatus.BAD_REQUEST);
	}

	@PutMapping
	public Endereco update(Endereco endereco, Integer id) {
		return enderecoService.update(endereco, id);
	}

	@DeleteMapping("/{id}")
	public void DeleteById(@PathVariable Integer id) {
		enderecoService.delete(id);
	}

}
