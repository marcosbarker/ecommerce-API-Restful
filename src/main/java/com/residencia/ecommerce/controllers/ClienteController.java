package com.residencia.ecommerce.controllers;

import java.util.List;

import javax.mail.MessagingException;
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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.residencia.ecommerce.exception.EmailException;
import com.residencia.ecommerce.services.ClienteService;
import com.residencia.ecommerce.services.EmailService;
import com.residencia.ecommerce.vo.ClienteVO;
import com.residencia.ecommerce.vo.Views.ClienteView;


@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
    private ClienteService clienteService;
	
	@Autowired
	private EmailService emailService;
	
	@GetMapping("/{id}")
	public ResponseEntity<ClienteView> findById(@PathVariable Integer id) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(clienteService.findById(id), 
				headers, HttpStatus.OK);
	}
	
	@GetMapping("/myinfo")
	public ResponseEntity<ClienteView> findMyInfo() {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(clienteService.findMyInfo(clienteService.getCliente()), 
				headers, HttpStatus.OK);
	}
	
	@GetMapping("/listar-todos")
	public ResponseEntity<List<ClienteView>> findAllView(
			@RequestParam(required = false) Integer pagina,
			@RequestParam(required = false) Integer qtdRegistros) 
					throws Exception {
		
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(clienteService.findAllView(pagina, 
				qtdRegistros), headers, HttpStatus.OK);
	}
	
	@GetMapping("/count")
	public Long count() {
		return clienteService.count();
	}
	
	@PostMapping("/cadastro")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<ClienteVO> save(@Valid @RequestBody ClienteVO clienteVO) throws MessagingException, EmailException{
		HttpHeaders headers = new HttpHeaders();
	
		ClienteVO novoClienteVO = clienteService.save(clienteVO);
		
		if(null != novoClienteVO) {
			emailService.emailCadastro(novoClienteVO);
			return new ResponseEntity<>(novoClienteVO, headers, HttpStatus.OK);
		}
			
		else {
			return new ResponseEntity<>(novoClienteVO, headers, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/{id}")
    public ClienteVO update(@PathVariable Integer id, @RequestBody ClienteVO clienteVO){
       return clienteService.update(clienteVO, id);
    }
	
	@DeleteMapping("/{id}")
	public void DeleteById (@PathVariable Integer id) {
		clienteService.delete(id);
    }

}
