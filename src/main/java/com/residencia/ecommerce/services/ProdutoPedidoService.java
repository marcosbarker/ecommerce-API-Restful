package com.residencia.ecommerce.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.residencia.ecommerce.entities.Pedido;
import com.residencia.ecommerce.entities.ProdutoPedido;
import com.residencia.ecommerce.repositories.ProdutoPedidoRepository;
import com.residencia.ecommerce.repositories.ProdutoRepository;
import com.residencia.ecommerce.vo.CadastrarNovoPedidoVO;
import com.residencia.ecommerce.vo.ProdutoPedidoVO;
import com.residencia.ecommerce.vo.Views.ProdutoPedidoView;

@Service
public class ProdutoPedidoService {

	@Autowired 
	ProdutoPedidoRepository produtoPedidoRepository;
	
	@Autowired 
	PedidoService pedidoService;
	
	@Autowired 
	ProdutoService produtoService;
	
	@Autowired 
	ProdutoRepository produtoRepository;
	
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
	
	public ProdutoPedido novoProdutoPedido(CadastrarNovoPedidoVO cadastrarNovoPedidoVO, Pedido pedido) {
		ProdutoPedido novoProdutoPedido = converteCadastroPedidoParaEntidade(cadastrarNovoPedidoVO, pedido);
		produtoPedidoRepository.save(novoProdutoPedido);
		return novoProdutoPedido;
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
		produtoPedidoVO.setPreco((int) produtoPedido.getPreco());
		produtoPedidoVO.setQuantidade(produtoPedido.getQuantidade());
		produtoPedidoVO.setProdutoVO(produtoService.converteEntidadeParaVO(produtoPedido.getProduto()));
		produtoPedidoVO.setPedidoVO(pedidoService.converteEntidadeParaVO(produtoPedido.getPedido()));
		
		return produtoPedidoVO;
		
	}

	public ProdutoPedido converteVOParaEntidade(ProdutoPedidoVO produtoPedidoVO) {
		ProdutoPedido produtoPedido = new ProdutoPedido();
		
		produtoPedido.setProdutoPedidoId(produtoPedidoVO.getProdutoPedidoId());
		produtoPedido.setPreco(produtoPedidoVO.getPreco());
		produtoPedido.setQuantidade(produtoPedidoVO.getQuantidade());
		produtoPedido.setProduto(produtoService.converteVOParaEntidade(produtoPedidoVO.getProdutoVO()));
		produtoPedido.setPedido(pedidoService.converteVOParaEntidade(produtoPedidoVO.getPedidoVO()));
		
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
	
	public ProdutoPedido converteCadastroPedidoParaEntidade(CadastrarNovoPedidoVO cadastrarNovoPedidoVO, Pedido pedido) {
		
		ProdutoPedido novoProdutoPedido = new ProdutoPedido();
		
		novoProdutoPedido.setProduto(produtoRepository.findByNome(cadastrarNovoPedidoVO.getNomeProduto()));
		novoProdutoPedido.setQuantidade(cadastrarNovoPedidoVO.getQuantidadeProduto());
		novoProdutoPedido.setPreco(novoProdutoPedido.getProduto().getPreco());
		novoProdutoPedido.setPedido(pedido);// POTENCIAL DE ERROR
		
		return novoProdutoPedido;
	}

}