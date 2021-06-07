package com.residencia.ecommerce.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.ecommerce.entities.Produto;
import com.residencia.ecommerce.repositories.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	ProdutoRepository produtoRepository;

	public Produto findById(Integer id) {
		return produtoRepository.findById(id).get();
	}

	public List<Produto> findAll() {
		return produtoRepository.findAll();
	}

	public Long count() {
		return produtoRepository.count();
	}

	public Produto save(Produto produto) {
		Produto novoProduto = produtoRepository.save(produto);
		return novoProduto;
	}

	public Produto update(Produto produto, Integer id) {
		produto.setProdutoId(id);
		return this.save(produto);
	}

	public void delete(Integer id) {
		produtoRepository.deleteById(id);
	}

}