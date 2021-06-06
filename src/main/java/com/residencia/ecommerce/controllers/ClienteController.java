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

import com.residencia.ecommerce.entities.Cliente;
import com.residencia.ecommerce.services.ClienteService;


@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	ClienteService clienteService;
	
	@GetMapping ("/{id}")
	public ResponseEntity<Cliente> findById (@PathVariable Integer id) {
		HttpHeaders headers = new HttpHeaders ();
		return new ResponseEntity <> (clienteService.FindById(id), headers, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<Cliente>> findAll ()
		throws Exception {
			HttpHeaders headers = new HttpHeaders ();
			return new ResponseEntity <> (clienteService.FindAll(), headers, HttpStatus.OK);
		}
	
	@GetMapping("/count")
	public Long count() {
		return clienteService.count();
	}
	
	@PostMapping
	public ResponseEntity<Cliente> save(@RequestBody Cliente aluno){
		
		HttpHeaders headers = new HttpHeaders();
		
		Cliente novoCliente = clienteService.save(aluno);
		
		if(null != novoCliente)
			return new ResponseEntity<>(novoCliente, headers, HttpStatus.OK);
		else
			return new ResponseEntity<>(novoCliente, headers, HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping("/{id}")
    public Cliente update(@RequestBody Cliente cliente, Integer id){
       return clienteService.update(cliente, id);
    }
	
	@DeleteMapping("/{id}")
	public void DeleteById (@PathVariable Integer id) {
		clienteService.delete(id);
    }

}
