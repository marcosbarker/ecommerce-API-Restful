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

import com.residencia.ecommerce.services.ProdutoPedidoService;
import com.residencia.ecommerce.vo.ProdutoPedidoVO;
import com.residencia.ecommerce.vo.Views.ProdutoPedidoView;

@RestController
@RequestMapping("/produtoPedido")
public class ProdutoPedidoController {

	@Autowired
	ProdutoPedidoService produtoPedidoService;

	@GetMapping("/{id}")
	public ResponseEntity<ProdutoPedidoView> findById(@PathVariable Integer id) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(produtoPedidoService.findById(id), headers, HttpStatus.OK);
	}

	@GetMapping("/listar-todos")
	public ResponseEntity<List<ProdutoPedidoView>> findAllView(
			@RequestParam(required = false) Integer pagina,
			@RequestParam(required = false) Integer qtdRegistros) 
					throws Exception {
		
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(produtoPedidoService.findAllView(pagina, 
				qtdRegistros), headers, HttpStatus.OK);
	}

	@GetMapping("/count")
	public Long count() {
		return produtoPedidoService.count();
	}

	@PostMapping
	public ResponseEntity<ProdutoPedidoVO> save(@RequestBody ProdutoPedidoVO produtoPedidoVO) {

		HttpHeaders headers = new HttpHeaders();

		ProdutoPedidoVO novoProdutoPedidoVO = produtoPedidoService.save(produtoPedidoVO);

		if (null != novoProdutoPedidoVO)
			return new ResponseEntity<>(novoProdutoPedidoVO, headers, HttpStatus.OK);
		else
			return new ResponseEntity<>(novoProdutoPedidoVO, headers, HttpStatus.BAD_REQUEST);
	}

	@PutMapping("/{id}")
	public ProdutoPedidoVO update(@RequestBody ProdutoPedidoVO produtoPedidoVO, Integer id) {
		return produtoPedidoService.update(produtoPedidoVO, id);
	}

	@DeleteMapping("/{id}")
	public void DeleteById(@PathVariable Integer id) {
		produtoPedidoService.delete(id);
	}

}