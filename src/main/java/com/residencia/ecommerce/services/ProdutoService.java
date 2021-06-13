package com.residencia.ecommerce.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.residencia.ecommerce.entities.Produto;
import com.residencia.ecommerce.repositories.ProdutoRepository;

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

	public ProdutoView findById(Integer id) {
		Produto produto = produtoRepository.findById(id).get();
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

	public ProdutoVO save(ProdutoVO produtoVO) {
		Produto novoProduto = converteVOParaEntidade(produtoVO);
		produtoRepository.save(novoProduto);
		return converteEntidadeParaVO(novoProduto);
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
		  
		  produtoVO.setProdutoPedidoVO(produtoPedidoService.converteEntidadeParaVO(produto.getProdutoPedido()));
		  
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
		  produto.setCategoria(categoriaService.converteVOParaEntidade(produtoVO.getCategoriaVO()));
		  
		  produto.setProdutoPedido(produtoPedidoService.converteVOParaEntidade(produtoVO.getProdutoPedidoVO()));
	  
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