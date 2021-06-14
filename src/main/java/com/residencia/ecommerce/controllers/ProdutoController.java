package com.residencia.ecommerce.controllers;

import java.util.List;

import javax.validation.Valid;

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

import com.residencia.ecommerce.services.ProdutoService;
import com.residencia.ecommerce.vo.CategoriaVO;
import com.residencia.ecommerce.vo.ProdutoVO;
import com.residencia.ecommerce.vo.Views.ProdutoView;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

	@Autowired
	ProdutoService produtoService;

	@GetMapping("/{id}")
	public ResponseEntity<ProdutoView> findById(@PathVariable Integer id) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(produtoService.findById(id), headers, HttpStatus.OK);
	}
	
	@GetMapping("/nome/{name}")
	public ResponseEntity<ProdutoView> findByName(@PathVariable String name) {
		HttpHeaders headers = new HttpHeaders();
		
		return new ResponseEntity<>(produtoService.findByName(name), headers, HttpStatus.OK);
	}

	@GetMapping("/listar-todos")
	public ResponseEntity<List<ProdutoView>> findAllView(
			@RequestParam(required = false) Integer pagina,
			@RequestParam(required = false) Integer qtdRegistros) 
					throws Exception {
		
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(produtoService.findAllView(pagina, 
				qtdRegistros), headers, HttpStatus.OK);
	}

	@GetMapping("/count")
	public Long count() {
		return produtoService.count();
	}

	@PostMapping("/novo-produto")
	public ResponseEntity<ProdutoView> save(@Valid @RequestBody ProdutoVO produtoVO) {

		HttpHeaders headers = new HttpHeaders();

		ProdutoView produtoView = produtoService.save(produtoVO);

		if (null != produtoView)
			return new ResponseEntity<>(produtoView, headers, HttpStatus.OK);
		else
			return new ResponseEntity<>(produtoView, headers, HttpStatus.BAD_REQUEST);
	}

	@PutMapping("/{id}")
	public ProdutoVO update(@RequestBody ProdutoVO produtoVO, Integer id) {
		return produtoService.update(produtoVO, id);
	}

	@DeleteMapping("/{id}")
	public void DeleteById(@PathVariable Integer id) {
		produtoService.delete(id);
	}

}