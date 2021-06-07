package com.residencia.ecommerce.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.ecommerce.entities.Categoria;
import com.residencia.ecommerce.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	CategoriaRepository categoriaRepository;

	public Categoria findById(Integer id) {
		return categoriaRepository.findById(id).get();
	}

	public List<Categoria> findAll() {
		return categoriaRepository.findAll();
	}

	public Long count() {
		return categoriaRepository.count();
	}

	public Categoria save(Categoria categoria) {
		Categoria novaCategoria = categoriaRepository.save(categoria);
		return novaCategoria;
	}

	public Categoria update(Categoria categoria, Integer id) {
		categoria.setCategoriaId(id);
		return this.save(categoria);
	}

	public void delete(Integer id) {
		categoriaRepository.deleteById(id);
	}

}