package com.residencia.ecommerce.services;

import java.util.Random;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.residencia.ecommerce.entities.Cliente;
import com.residencia.ecommerce.exception.EmailException;
import com.residencia.ecommerce.repositories.ClienteRepository;
import com.residencia.ecommerce.vo.EsqueciSenhaVO;

import javassist.tools.rmi.ObjectNotFoundException;

@Service
public class AuthService {
	
	@Autowired
    private ClienteRepository clienteRepository;

   
    
    @Autowired
    private EmailService emailService;
    
   

    public boolean sendNewPassword(EsqueciSenhaVO esqueciSenhaVO) throws ObjectNotFoundException, MessagingException, EmailException {
        
        Cliente cliente = clienteRepository.findByEmail(esqueciSenhaVO.getEmail()); 
      
        if (cliente == null) {
            return false;
        }

        else {
	        String newPass = newPassword();
	        cliente.setSenha(new BCryptPasswordEncoder().encode(newPass));
	      
	        clienteRepository.save(cliente);
	     
	        emailService.emailNovaSenha(cliente, newPass);
	        return true;
        } 
    }

    
    private String newPassword() {
        char[] vet = new char[5];
        for(int i = 0; i < 5; i++) {
            vet[i] = randomChar(); 
         }    
        return new String(vet);
     
    }
    
    
    private char randomChar() {
    	 Random rand = new Random();
    	 
        int opcao = rand.nextInt(3); 
        if(opcao == 0) { 
            return(char) (rand.nextInt(10) + 48); 
            
        }
        else if(opcao == 1) { 
            return(char) (rand.nextInt(26) + 65); 
            
        } else {
            return(char) (rand.nextInt(26) + 97); 
            
        }
    }

}
