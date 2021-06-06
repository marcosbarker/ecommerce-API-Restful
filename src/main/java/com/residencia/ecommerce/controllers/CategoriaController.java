package com.residencia.ecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.residencia.ecommerce.services.CategoriaService;

@RestController
@RequestMapping("/Categoria")
public class CategoriaController {
	
	@Autowired
	public CategoriaService categoriaService;
	
}