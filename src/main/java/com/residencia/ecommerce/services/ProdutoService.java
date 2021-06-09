package com.residencia.ecommerce.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.residencia.ecommerce.entities.Categoria;
import com.residencia.ecommerce.entities.Produto;
import com.residencia.ecommerce.repositories.ProdutoRepository;

import com.residencia.ecommerce.vo.ProdutoVO;

@Service
public class ProdutoService {

	@Autowired
	ProdutoRepository produtoRepository;

	public ProdutoVO findById(Integer id) {
		Produto produto = produtoRepository.findById(id).get();
		ProdutoVO produtoVO = converteEntidadeParaVO(produto);
		return produtoVO;
	}

	public List<ProdutoVO> findAllVO(Integer pagina, Integer qtdRegistros) throws Exception {
		Pageable page = null;
		List<Produto> listProduto = null;
		List<Produto> listProdutoComPaginacao = null;
		List<ProdutoVO> listProdutoVO = new ArrayList<>();

		try {
			if (null != pagina && null != qtdRegistros) {

				page = PageRequest.of(pagina, qtdRegistros);
				listProdutoComPaginacao = produtoRepository.findAll(page).getContent();

				for (Produto lProduto : listProdutoComPaginacao) {
					listProdutoVO.add(converteEntidadeParaVO(lProduto));
				}

			} else {
				listProduto = produtoRepository.findAll();

				for (Produto lProduto : listProduto) {
					listProdutoVO.add(converteEntidadeParaVO(lProduto));
				}

			}
		} catch (Exception e) {
			throw new Exception("Não foi possível recuperar a lista de produtos ::" + e.getMessage());
		}

		return listProdutoVO;
	}

	public ProdutoVO save(ProdutoVO produtoVO) {
		Produto novoProduto = converteVOParaEntidade(produtoVO, null);
		produtoRepository.save(novoProduto);
		return converteEntidadeParaVO(novoProduto);
	}

	public ProdutoVO update(ProdutoVO produtoVO, Integer id) {
		Produto produto = converteVOParaEntidade(produtoVO, id);
		Produto novoProduto = produtoRepository.save(produto);
		return converteEntidadeParaVO(novoProduto);
	}

	public Long count() {
		return produtoRepository.count();
	}

	/*
	 * private ProdutoVO converteEntidadeParaVO(Produto produto) { ProdutoVO
	 * categoriaVO = new ProdutoVO(); List<ProdutoVO> listProdutoVO = new
	 * ArrayList<>(); // o que listar
	 * 
	 * produtoVO.setProdutoId(produto.getProdutoId());
	 * produtoVO.setNome(produto.getNome());
	 * produtoVO.setDescricao(produto.getDescricao());
	 * 
	 * return produtoVO;
	 * 
	 * }
	 */

	/*
	 * private Produto converteVOParaEntidade(ProdutoVO produtoVO, Integer id) {
	 * Produto categoria = new Produto(); List<?> list? = new ArrayList<>(); // o
	 * que listar
	 * 
	 * categoria.setProdutoId(produtoVO.getProdutoId());
	 * categoria.setNome(produtoVO.getNome());
	 * categoria.setDescricao(produtoVO.getDescricao());
	 * 
	 * for (?VO l?VO : produtoVO.getList?()) {
	 * 
	 * }
	 * 
	 * return produto; }
	 */

	public void delete(Integer id) {
		produtoRepository.deleteById(id);
	}

}