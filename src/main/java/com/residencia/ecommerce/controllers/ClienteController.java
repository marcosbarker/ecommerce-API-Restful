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
import com.residencia.ecommerce.repositories.ClienteRepository;
import com.residencia.ecommerce.services.AuthService;
import com.residencia.ecommerce.services.ClienteService;
import com.residencia.ecommerce.services.EmailService;
import com.residencia.ecommerce.vo.ClienteVO;
import com.residencia.ecommerce.vo.EsqueciSenhaVO;
import com.residencia.ecommerce.vo.Views.ClienteView;

import javassist.tools.rmi.ObjectNotFoundException;


@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
    private ClienteService clienteService;
	
	@Autowired
    private ClienteRepository clienteRepository;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private AuthService authService;
	
	
	
	@GetMapping("/{id}")
	public ResponseEntity<ClienteView> findById(@PathVariable Integer id) {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(clienteService.findById(id), 
				headers, HttpStatus.OK);
	}
	
	@GetMapping("/myinfo")
	public ResponseEntity<ClienteView> findMyInfo() {
		HttpHeaders headers = new HttpHeaders();
		return new ResponseEntity<>(clienteService.findMyInfo(clienteService.getCliente().getUsername()), 
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
	public ResponseEntity<String> save(@Valid @RequestBody ClienteVO clienteVO) throws MessagingException, EmailException{
		HttpHeaders headers = new HttpHeaders();


		if(null != clienteVO) {
			
			if (clienteRepository.findByUsername(clienteVO.getUsername()) == null) {
				
				if(clienteRepository.findByEmail(clienteVO.getEmail()) == null) {
					
					if(clienteRepository.findByCpf(clienteVO.getCpf()) == null) {
						
						ClienteVO novoClienteVO = clienteService.save(clienteVO);
						emailService.emailCadastro(novoClienteVO, clienteVO.getSenha());
						return new ResponseEntity<>("Parabens" + clienteVO.getNome() + " seu cadastro foi efetuado com Sucesso", headers, HttpStatus.OK);
						
						}
						else {
							return new ResponseEntity<>("CPF ja Cadastrado", headers, HttpStatus.BAD_REQUEST);
						}
						
					}
					else {
						return new ResponseEntity<>("Email ja Cadastrado", headers, HttpStatus.BAD_REQUEST);
					}
					
				}
				else {
					return new ResponseEntity<>("Username ja Cadastrado", headers, HttpStatus.BAD_REQUEST);
				}
				
			}
			else {
				return new ResponseEntity<>("Insira dados validos", headers, HttpStatus.BAD_REQUEST);
			}	
	}
	
	@PutMapping("/atualizar-infos")
    public ClienteVO update(@Valid @RequestBody ClienteVO NovasInfosCliente){
		ClienteVO ClienteParaAtt = clienteService.converteEntidadeParaVO(clienteService.getCliente());
		return clienteService.update(ClienteParaAtt, NovasInfosCliente);
    }
	
	@DeleteMapping("/deletar-minha-conta")
	public void DeleteMinhaConta () {
		
		clienteService.delete(clienteService.getCliente());
		
    }
	
	@PostMapping ("/esqueci-senha")
	public ResponseEntity<String> esqueciSenha(@Valid @RequestBody EsqueciSenhaVO esqueciSenhaVO) throws ObjectNotFoundException, MessagingException, EmailException {
		HttpHeaders headers = new HttpHeaders();
		
		if(authService.sendNewPassword(esqueciSenhaVO)) {
			
			return new ResponseEntity<>("Sua nova senha foi enviada para seu e-mail", headers, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("Email Nao Cadastrado no sistema", headers, HttpStatus.BAD_REQUEST);
		}
	
	}

}
