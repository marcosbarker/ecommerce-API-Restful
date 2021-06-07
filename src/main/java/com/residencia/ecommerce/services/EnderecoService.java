package com.residencia.ecommerce.services;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.residencia.ecommerce.entities.Endereco;
import com.residencia.ecommerce.repositories.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	public EnderecoRepository enderecoRepository;

	public Endereco findById(Integer id) {
		return enderecoRepository.findById(id).get();
	}

	public List<Endereco> findAll() {
		return enderecoRepository.findAll();
	}

	public Endereco save(Endereco endereco) {
		return enderecoRepository.save(endereco);
	}

	public Endereco update(Endereco endereco, Integer id) {
		endereco.setEnderecoId(id);
		return enderecoRepository.save(endereco);
	}

	public void delete(Integer id) {
		enderecoRepository.deleteById(id);
	}

}
