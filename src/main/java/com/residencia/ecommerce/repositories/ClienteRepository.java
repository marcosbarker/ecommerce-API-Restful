package com.residencia.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.residencia.ecommerce.entities.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository <Cliente, Integer> {
			public Cliente findByUsername(String username);
			public Cliente findByEmail(String email);
			public Cliente findByCpf(String cpf);
}
