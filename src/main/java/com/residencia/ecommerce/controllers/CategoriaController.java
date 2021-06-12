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

import com.residencia.ecommerce.services.CategoriaService;
import com.residencia.ecommerce.vo.CategoriaVO;


@RestController
@RequestMapping("/categoria")
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping("/id/{id}")
	public ResponseEntity<CategoriaVO> findById(@PathVariable Integer id) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(categoriaService.findById(id), headers, HttpStatus.OK);
	}
	
	@GetMapping("/nome/{name}")
	public ResponseEntity<CategoriaVO> findByName(@PathVariable String name) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(categoriaService.findByName(name), headers, HttpStatus.OK);
	}
	
	@GetMapping("/listar-todos")
	public ResponseEntity<List<CategoriaVO>> findAllVO(
			@RequestParam(required = false) Integer pagina,
			@RequestParam(required = false) Integer qtdRegistros) 
					throws Exception {
		
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(categoriaService.findAllVO(pagina, 
				qtdRegistros), headers, HttpStatus.OK);
	}
	
	@GetMapping("/count")
	public Long count() {
		return categoriaService.count();
	}
	
	@PostMapping
	public ResponseEntity<CategoriaVO> save(@RequestBody CategoriaVO categoriaVO){
		HttpHeaders headers = new HttpHeaders();
	
		CategoriaVO novoCategoriaVO = categoriaService.save(categoriaVO);
		
		if(null != novoCategoriaVO)
			return new ResponseEntity<>(novoCategoriaVO, headers, HttpStatus.OK);
		else
			return new ResponseEntity<>(novoCategoriaVO, headers, HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping("/{id}")
    public CategoriaVO update(@PathVariable Integer id, @RequestBody CategoriaVO categoriaVO){
       return categoriaService.update(categoriaVO, id);
    }
	
	@DeleteMapping("/{id}")
	public void DeleteById (@PathVariable Integer id) {
		categoriaService.delete(id);
    }

}