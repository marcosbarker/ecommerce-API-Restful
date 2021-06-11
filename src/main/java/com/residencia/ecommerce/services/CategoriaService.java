package com.residencia.ecommerce.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.residencia.ecommerce.entities.Categoria;
import com.residencia.ecommerce.entities.Produto;
import com.residencia.ecommerce.repositories.CategoriaRepository;
import com.residencia.ecommerce.vo.CategoriaVO;
import com.residencia.ecommerce.vo.ProdutoVO;


@Service
public class CategoriaService {

	
	@Autowired 
	CategoriaRepository categoriaRepository;
	
	@Autowired 
	ProdutoService produtoService;
	
	public CategoriaVO findById(Integer id) {
		Categoria categoria = categoriaRepository.findById(id).get();
		CategoriaVO categoriaVO = converteEntidadeParaVO(categoria);
		return categoriaVO;
	}

	public List<CategoriaVO> findAllVO(Integer pagina, Integer qtdRegistros) throws Exception {
		Pageable page = null;
		List<Categoria> listCategoria = null;
		List<Categoria> listCategoriaComPaginacao = null;
		List<CategoriaVO> listCategoriaVO = new ArrayList<>();

		try {
			if (null != pagina && null != qtdRegistros) {

				page = PageRequest.of(pagina, qtdRegistros);
				listCategoriaComPaginacao = categoriaRepository.findAll(page).getContent();

				for (Categoria lCategoria : listCategoriaComPaginacao) {
					listCategoriaVO.add(converteEntidadeParaVO(lCategoria));
				}

			} else {
				listCategoria = categoriaRepository.findAll();

				for (Categoria lCategoria : listCategoria) {
					listCategoriaVO.add(converteEntidadeParaVO(lCategoria));
				}

			}
		} catch (Exception e) {
			throw new Exception("Não foi possível recuperar a lista de pedidos ::" + e.getMessage());
		}

		return listCategoriaVO;
	}
	
	public CategoriaVO save(CategoriaVO categoriaVO) {
		Categoria novaCategoria = converteVOParaEntidade(categoriaVO);
		categoriaRepository.save(novaCategoria);
		return converteEntidadeParaVO(novaCategoria);
	}

	public CategoriaVO update(CategoriaVO categoriaVO, Integer id) {
		Categoria categoria = converteVOParaEntidade(categoriaVO);
		Categoria novaCategoria = categoriaRepository.save(categoria);
		return converteEntidadeParaVO(novaCategoria);
	}

	public Long count() {
		return categoriaRepository.count();
	}

	public CategoriaVO converteEntidadeParaVO(Categoria categoria) {
		CategoriaVO categoriaVO = new CategoriaVO();
		List<ProdutoVO> listProdutoVO = new ArrayList<>();
		
		categoriaVO.setCategoriaId(categoria.getCategoriaId());
		categoriaVO.setNome(categoria.getNome());
		categoriaVO.setDescricao(categoria.getDescricao());
		
		
		for (Produto lProduto : categoria.getListProduto()) {
			listProdutoVO.add(produtoService.converteEntidadeParaVO(lProduto));
		}
		categoriaVO.setListProdutoVO(listProdutoVO);
		return categoriaVO;
		
	}

	public Categoria converteVOParaEntidade(CategoriaVO categoriaVO) {
		Categoria categoria = new Categoria();
		List<Produto> listProduto = new ArrayList<>();
		
		categoria.setCategoriaId(categoriaVO.getCategoriaId());
		categoria.setNome(categoriaVO.getNome());
		categoria.setDescricao(categoriaVO.getDescricao());
		
		
		for (ProdutoVO lProdutoVO : categoriaVO.getListProdutoVO()) {
			listProduto.add(produtoService.converteVOParaEntidade(lProdutoVO));
		}
		
		return categoria;
	}
	
	public void delete (Integer id) {
		categoriaRepository.deleteById(id);
	}
}