package com.residencia.ecommerce.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.residencia.ecommerce.entities.ProdutoPedido;
import com.residencia.ecommerce.repositories.ProdutoPedidoRepository;
import com.residencia.ecommerce.vo.ProdutoPedidoVO;
import com.residencia.ecommerce.vo.Views.ProdutoPedidoView;

@Service
public class ProdutoPedidoService {

	@Autowired 
	ProdutoPedidoRepository produtoPedidoRepository;
	
	public ProdutoPedidoView findById(Integer id) {
		ProdutoPedido ProdutoPedido = produtoPedidoRepository.findById(id).get();
		ProdutoPedidoView produtoPedidoView = converteEntidadeParaView(ProdutoPedido);
		return produtoPedidoView;
	}

	public List<ProdutoPedidoView> findAllView(Integer pagina, Integer qtdRegistros) throws Exception {
		Pageable page = null;
		List<ProdutoPedido> listProdutoPedido = null;
		List<ProdutoPedido> listProdutoPedidoComPaginacao = null;
		List<ProdutoPedidoView> listProdutoPedidoView = new ArrayList<>();

		try {
			if (null != pagina && null != qtdRegistros) {

				page = PageRequest.of(pagina, qtdRegistros);
				listProdutoPedidoComPaginacao = produtoPedidoRepository.findAll(page).getContent();

				for (ProdutoPedido lProdutoPedidoVO : listProdutoPedidoComPaginacao) {
					listProdutoPedidoView.add(converteEntidadeParaView(lProdutoPedidoVO));
				}

			} else {
				listProdutoPedido = produtoPedidoRepository.findAll();

				for (ProdutoPedido lProdutoPedido : listProdutoPedido) {
					listProdutoPedidoView.add(converteEntidadeParaView(lProdutoPedido));
				}

			}
		} catch (Exception e) {
			throw new Exception("Não foi possível recuperar a lista de pedidos ::" + e.getMessage());
		}

		return listProdutoPedidoView;
	}
	
	public ProdutoPedidoVO save(ProdutoPedidoVO produtoPedidoVO) {
		ProdutoPedido novoProdutoPedidoVO = converteVOParaEntidade(produtoPedidoVO);
		produtoPedidoRepository.save(novoProdutoPedidoVO);
		return converteEntidadeParaVO(novoProdutoPedidoVO);
	}

	public ProdutoPedidoVO update(ProdutoPedidoVO produtoPedidoVO, Integer id) {
		ProdutoPedido produtoPedido = converteVOParaEntidade(produtoPedidoVO);
		ProdutoPedido novoProdutoPedido = produtoPedidoRepository.save(produtoPedido);
		return converteEntidadeParaVO(novoProdutoPedido);
	}

	public Long count() {
		return produtoPedidoRepository.count();
	}

	public ProdutoPedidoVO converteEntidadeParaVO(ProdutoPedido produtoPedido) {
		ProdutoPedidoVO produtoPedidoVO = new ProdutoPedidoVO();
		
		produtoPedidoVO.setProdutoPedidoId(produtoPedido.getProdutoPedidoId());
		produtoPedidoVO.setPreco(produtoPedido.getPreco());
		produtoPedidoVO.setQuantidade(produtoPedido.getQuantidade());
		produtoPedidoVO.setProduto(produtoPedido.getProduto());
		produtoPedidoVO.setPedido(produtoPedido.getPedido());
		
		return produtoPedidoVO;
		
	}

	public ProdutoPedido converteVOParaEntidade(ProdutoPedidoVO produtoPedidoVO) {
		ProdutoPedido produtoPedido = new ProdutoPedido();
		
		produtoPedido.setProdutoPedidoId(produtoPedidoVO.getProdutoPedidoId());
		produtoPedido.setPreco(produtoPedidoVO.getPreco());
		produtoPedido.setQuantidade(produtoPedidoVO.getQuantidade());
		produtoPedido.setProduto(produtoPedidoVO.getProduto());
		produtoPedido.setPedido(produtoPedidoVO.getPedido());
		
		return produtoPedido;
	}
	
	public void delete (Integer id) {
		produtoPedidoRepository.deleteById(id);
	}
	
	public ProdutoPedidoView converteEntidadeParaView(ProdutoPedido produtoPedido) {
		ProdutoPedidoView produtoPedidoView = new ProdutoPedidoView();
			
		produtoPedidoView.setNomeProduto(produtoPedido.getProduto().getNome());
		produtoPedidoView.setQuantidadeProdutoNoPedido(produtoPedido.getQuantidade());
		
		return produtoPedidoView;
		
	}

}