package com.residencia.ecommerce.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.residencia.ecommerce.entities.Pedido;
import com.residencia.ecommerce.repositories.PedidoRepository;
import com.residencia.ecommerce.vo.CadastrarNovoPedidoVO;
import com.residencia.ecommerce.vo.PedidoVO;
import com.residencia.ecommerce.vo.Views.PedidoClienteView;

@Service
public class PedidoService {
	
	@Autowired 
	PedidoRepository pedidoRepository;
	
	@Autowired
	ClienteService clienteSerivce;
	
	@Autowired
	ProdutoPedidoService produtoPedidoService;
	
	
	public PedidoClienteView findById(Integer id) {
		Pedido pedido = pedidoRepository.findById(id).get();
		PedidoClienteView pedidoClienteView = converteEntidadeParaView(pedido);
		return pedidoClienteView;
	}

	public List<PedidoClienteView> findAllView(Integer pagina, Integer qtdRegistros) throws Exception {
		Pageable page = null;
		List<Pedido> listPedido = null;
		List<Pedido> listPedidoComPaginacao = null;
		List<PedidoClienteView> listPedidoClienteView = new ArrayList<>();

		try {
			if (null != pagina && null != qtdRegistros) {

				page = PageRequest.of(pagina, qtdRegistros);
				listPedidoComPaginacao = pedidoRepository.findAll(page).getContent();

				for (Pedido lPedido : listPedidoComPaginacao) {
					listPedidoClienteView.add(converteEntidadeParaView(lPedido));
				}

			} else {
				listPedido = pedidoRepository.findAll();

				for (Pedido lPedido : listPedido) {
					listPedidoClienteView.add(converteEntidadeParaView(lPedido));
				}

			}
		} catch (Exception e) {
			throw new Exception("Não foi possível recuperar a lista de pedidos ::" + e.getMessage());
		}

		return listPedidoClienteView;
	}
	
	public PedidoVO save(PedidoVO pedidoVO) {
		Pedido novaPedido = converteVOParaEntidade(pedidoVO);
		pedidoRepository.save(novaPedido);
		return converteEntidadeParaVO(novaPedido);
	}
	
	public PedidoClienteView novoPedido(CadastrarNovoPedidoVO cadastrarNovoPedidoVO) {
		
		Pedido novaPedido = converteCadastroPedidoParaEntidade(cadastrarNovoPedidoVO);
		pedidoRepository.save(novaPedido);
		
		novaPedido.setProdutoPedido(produtoPedidoService.novoProdutoPedido(cadastrarNovoPedidoVO, novaPedido));
		novaPedido.setValorTotalDoPedido(novaPedido.getProdutoPedido().getPreco() * novaPedido.getProdutoPedido().getQuantidade());
		
		pedidoRepository.save(novaPedido);
		
		List<Pedido> lPedido = clienteSerivce.getCliente().getListPedido();
		lPedido.add(novaPedido);
		clienteSerivce.getCliente().setListPedido(lPedido);
		
		return converteEntidadeParaView(novaPedido);
	}
	
	public Pedido saveReturnEntidade(Pedido pedido) {
		return pedidoRepository.save(pedido);
		
	}

	public PedidoVO update(PedidoVO pedidoVO, Integer id) {
		Pedido pedido = converteVOParaEntidade(pedidoVO);
		Pedido novoPedido = pedidoRepository.save(pedido);
		return converteEntidadeParaVO(novoPedido);
	}

	public Long count() {
		return pedidoRepository.count();
	}

	public PedidoVO converteEntidadeParaVO(Pedido pedido) {
		PedidoVO pedidoVO = new PedidoVO();
		
		pedidoVO.setPedidoId(pedido.getPedidoId());
		pedidoVO.setNumeroDoPedido(pedido.getNumeroDoPedido());
		pedidoVO.setValorTotalDoPedido(pedido.getValorTotalDoPedido());
		pedidoVO.setDataDoPedido(pedido.getDataDoPedido());
		pedidoVO.setStatus(pedido.getStatus());
		pedidoVO.setClienteVO(clienteSerivce.converteEntidadeParaVO(pedido.getCliente()));
		pedidoVO.setProdutoPedidoVO(produtoPedidoService.converteEntidadeParaVO(pedido.getProdutoPedido()));
		
		return pedidoVO;
		
	}

	public Pedido converteVOParaEntidade(PedidoVO pedidoVO) {
		Pedido pedido = new Pedido();
	
		pedido.setPedidoId(pedidoVO.getPedidoId());
		pedido.setNumeroDoPedido(pedidoVO.getNumeroDoPedido());
		pedido.setValorTotalDoPedido(pedidoVO.getValorTotalDoPedido());
		pedido.setDataDoPedido(pedidoVO.getDataDoPedido());
		pedido.setStatus(pedidoVO.getStatus());
		pedido.setCliente(clienteSerivce.converteVOParaEntidade(pedidoVO.getClienteVO(), null));
		pedido.setProdutoPedido(produtoPedidoService.converteVOParaEntidade(pedidoVO.getProdutoPedidoVO()));
		
		
		
		return pedido;
	}
	
	
	public void delete (Integer id) {
		pedidoRepository.deleteById(id);
	}
	
	public PedidoClienteView converteEntidadeParaView(Pedido pedido) {
		PedidoClienteView pedidoClienteView = new PedidoClienteView();
		
		pedidoClienteView.setNumeroDoPedido(pedido.getNumeroDoPedido());
		pedidoClienteView.setDataDoPedido(pedido.getDataDoPedido());
		pedidoClienteView.setValorTotalDoPedido(pedido.getValorTotalDoPedido());
		pedidoClienteView.setStatus(pedido.getStatus());
		pedidoClienteView.setProdutoPedidoView(produtoPedidoService.converteEntidadeParaView(pedido.getProdutoPedido()));
		
		return pedidoClienteView;
	}
	
	public Pedido converteCadastroPedidoParaEntidade(CadastrarNovoPedidoVO cadastrarNovoPedidoVO) {
		
		Pedido novoPedido = new Pedido();
		
		novoPedido.setCliente(clienteSerivce.getCliente());
		novoPedido.setNumeroDoPedido((int) (count()+1));
		novoPedido.setStatus("Finalizado");

		
		return novoPedido;
	}

	

}