package com.residencia.ecommerce.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.ecommerce.config.ApplicationSecurityConfig;
import com.residencia.ecommerce.entities.Cliente;
import com.residencia.ecommerce.repositories.ClienteRepository;
import com.residencia.ecommerce.vo.LoginVO;

@Service
public class LoginService {
	
	@Autowired
	public ClienteRepository clienteRepository;
	
	@Autowired
	public ApplicationSecurityConfig applicationSecurityConfig;
	
	public Cliente verificaLogin(LoginVO loginVO) throws Exception {
		
		if(clienteRepository.findByUsername(loginVO.getUsername()) != null) {
			Cliente cliente = clienteRepository.findByUsername(loginVO.getUsername());
			if(cliente.getSenha() == loginVO.getSenha()) {
				applicationSecurityConfig.configure(null, cliente);
				return cliente;
			}
			return null;
		}
		else {
			return null;
			}
	
		}
}
