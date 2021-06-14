package com.residencia.ecommerce.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.residencia.ecommerce.entities.Categoria;
import com.residencia.ecommerce.entities.Produto;
import com.residencia.ecommerce.repositories.CategoriaRepository;
import com.residencia.ecommerce.repositories.ProdutoRepository;
import com.residencia.ecommerce.vo.CategoriaVO;
import com.residencia.ecommerce.vo.ProdutoVO;
import com.residencia.ecommerce.vo.Views.ProdutoView;

@Service
public class ProdutoService {

	@Autowired
	ProdutoRepository produtoRepository;
	
	@Autowired
	CategoriaService categoriaService;
	
	@Autowired
	ProdutoPedidoService produtoPedidoService;
	
	@Autowired
	CategoriaRepository categoriaRepository;

	public ProdutoView findById(Integer id) {
		Produto produto = produtoRepository.findById(id).get();
		ProdutoView produtoView = converteEntidadeParaView(produto);
		return produtoView;
	}
	
	public ProdutoView findByName(String name) {
		Produto produto = produtoRepository.findByNome(name);
		ProdutoView produtoView = converteEntidadeParaView(produto);
		return produtoView;
	}

	public List<ProdutoView> findAllView(Integer pagina, Integer qtdRegistros) throws Exception {
		Pageable page = null;
		List<Produto> listProduto = null;
		List<Produto> listProdutoComPaginacao = null;
		List<ProdutoView> listProdutoView = new ArrayList<>();

		try {
			if (null != pagina && null != qtdRegistros) {

				page = PageRequest.of(pagina, qtdRegistros);
				listProdutoComPaginacao = produtoRepository.findAll(page).getContent();

				for (Produto lProduto : listProdutoComPaginacao) {
					listProdutoView.add(converteEntidadeParaView(lProduto));
				}

			} else {
				listProduto = produtoRepository.findAll();

				for (Produto lProduto : listProduto) {
					listProdutoView.add(converteEntidadeParaView(lProduto));
				}

			}
		} catch (Exception e) {
			throw new Exception("Não foi possível recuperar a lista de produtos ::" + e.getMessage());
		}

		return listProdutoView;
	}

	public ProdutoView save(ProdutoVO produtoVO) {
		produtoVO.setDataDeCadastroDoProduto(LocalDate.now());
		Produto novoProduto = converteVOParaEntidade(produtoVO);
		produtoRepository.save(novoProduto);
		return converteEntidadeParaView(novoProduto);
	}

	public ProdutoVO update(ProdutoVO produtoVO, Integer id) {
		Produto produto = converteVOParaEntidade(produtoVO);
		Produto novoProduto = produtoRepository.save(produto);
		return converteEntidadeParaVO(novoProduto);
	}

	public Long count() {
		return produtoRepository.count();
	}

	
	  public ProdutoVO converteEntidadeParaVO(Produto produto) { 
		  ProdutoVO produtoVO = new ProdutoVO();
		  
		  produtoVO.setProdutoId(produto.getProdutoId());
		  produtoVO.setNome(produto.getNome());
		  produtoVO.setDescricao(produto.getDescricao());
		  produtoVO.setPreco(produto.getPreco());
		  produtoVO.setQuantidadeEmEstoque(produto.getQuantidadeEmEstoque());
		  produtoVO.setDataDeCadastroDoProduto(produto.getDataDeCadastroDoProduto());
		  produtoVO.setCategoriaVO(categoriaService.converteEntidadeParaVO(produto.getCategoria()));
		  
	
		  return produtoVO;
	  
	 	}
	 

	
	 public Produto converteVOParaEntidade(ProdutoVO produtoVO) {
		 Produto produto = new Produto();
		 
		  produto.setProdutoId(produtoVO.getProdutoId());
		  produto.setNome(produtoVO.getNome());
		  produto.setDescricao(produtoVO.getDescricao());
		  produto.setPreco(produtoVO.getPreco());
		  produto.setQuantidadeEmEstoque((int) produtoVO.getQuantidadeEmEstoque());
		  produto.setDataDeCadastroDoProduto(produtoVO.getDataDeCadastroDoProduto());
		  produto.setCategoria(categoriaRepository.findByNome(produtoVO.getNomeCategoria()));
		  
		
		 
		 return produto; 
	  
	  }
	 

	public void delete(Integer id) {
		produtoRepository.deleteById(id);
	}
	
	public ProdutoView converteEntidadeParaView(Produto produto) {
		ProdutoView produtoView = new ProdutoView();
		
		produtoView.setNome(produto.getNome());
		produtoView.setPreco(produto.getPreco());
		produtoView.setCategoria(produto.getCategoria().getNome());
		
		return produtoView;
	}

}