package com.residencia.ecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.residencia.ecommerce.entities.Cliente;
import com.residencia.ecommerce.services.LoginService;
import com.residencia.ecommerce.vo.LoginVO;

@RestController
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
	public LoginService loginService;
	
	@PostMapping
	public ResponseEntity<Cliente> save(@RequestBody LoginVO loginVO) throws Exception{
		HttpHeaders headers = new HttpHeaders();
	
		Cliente cliente = loginService.verificaLogin(loginVO);
		
		if(cliente != null)
			return new ResponseEntity<>(cliente, headers, HttpStatus.OK);
		else
			return new ResponseEntity<>(headers, HttpStatus.BAD_REQUEST);
	}
	
}
