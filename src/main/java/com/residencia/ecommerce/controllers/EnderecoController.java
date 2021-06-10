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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.residencia.ecommerce.entities.Endereco;
import com.residencia.ecommerce.services.EnderecoService;
import com.residencia.ecommerce.vo.ClienteVO;
import com.residencia.ecommerce.vo.EnderecoVO;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

	@Autowired
	public EnderecoService enderecoService;

	@GetMapping("/{id}")
	public ResponseEntity<EnderecoVO> findById(@PathVariable Integer id) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(enderecoService.findById(id), headers, HttpStatus.OK);
	}

	@GetMapping("/list")
	public ResponseEntity<List<EnderecoVO>> findAll(
			@RequestParam(required = false) Integer pagina,
			@RequestParam(required = false) Integer qtdRegistros) 
					throws Exception {
		
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(enderecoService.findAll(pagina, 
				qtdRegistros), headers, HttpStatus.OK);
	}
	
	@GetMapping("/count")
	public Long count() {
		return enderecoService.count();

	}

	@PostMapping
	public ResponseEntity<Endereco> save(@RequestBody EnderecoVO enderecoVO, ClienteVO clienteVO) {
		HttpHeaders headers = new HttpHeaders();
		
		Endereco novoEndereco = enderecoService.save(enderecoVO, clienteVO);

		if (null != novoEndereco)
			return new ResponseEntity<>(novoEndereco, headers, HttpStatus.OK);
		else
			return new ResponseEntity<>(novoEndereco, headers, HttpStatus.BAD_REQUEST);
	}

	@PutMapping
	public EnderecoVO update(EnderecoVO endereco, Integer id) {
		return enderecoService.update(endereco, id);
	}

	@DeleteMapping("/{id}")
	public void DeleteById(@PathVariable Integer id) {
		enderecoService.delete(id);
	}

}
