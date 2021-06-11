package com.residencia.ecommerce.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.residencia.ecommerce.entities.Cliente;
import com.residencia.ecommerce.entities.Pedido;
import com.residencia.ecommerce.repositories.ClienteRepository;
import com.residencia.ecommerce.vo.ClienteVO;
import com.residencia.ecommerce.vo.PedidoVO;
import com.residencia.ecommerce.vo.Views.ClienteView;
import com.residencia.ecommerce.vo.Views.PedidoClienteView;

@Service
public class ClienteService {
	
	@Autowired 
	ClienteRepository clienteRepository;
	
	@Autowired
	EnderecoService enderecoService;
	
	@Autowired
	PedidoService pedidoService;
	
	public ClienteView findById(Integer id) {
		Cliente cliente = clienteRepository.findById(id).get();
		ClienteView clienteView = converteEntidadeParaView(cliente);
		return clienteView;
	}

	public List<ClienteView> findAllView(Integer pagina, Integer qtdRegistros) throws Exception {
		Pageable page = null;
		List<Cliente> listCliente = null;
		List<Cliente> listClienteComPaginacao = null;
		List<ClienteView> listClienteView = new ArrayList<>();

		try {
			if (null != pagina && null != qtdRegistros) {

				page = PageRequest.of(pagina, qtdRegistros);
				listClienteComPaginacao = clienteRepository.findAll(page).getContent();

				for (Cliente lCliente : listClienteComPaginacao) {
					listClienteView.add(converteEntidadeParaView(lCliente));
				}

			} else {
				listCliente = clienteRepository.findAll();

				for (Cliente lCliente : listCliente) {
					listClienteView.add(converteEntidadeParaView(lCliente));
				}

			}
		} catch (Exception e) {
			throw new Exception("Não foi possível recuperar a lista de pedidos ::" + e.getMessage());
		}

		return listClienteView;
	}
	
	public ClienteVO save(ClienteVO clienteVO) {
		Cliente novoCliente = converteVOParaEntidade(clienteVO, null);
		clienteRepository.save(novoCliente);
		return converteEntidadeParaVO(novoCliente);
	}

	public ClienteVO update(ClienteVO clienteVO, Integer id) {
		Cliente cliente = converteVOParaEntidade(clienteVO, id);
		Cliente novoCliente = clienteRepository.save(cliente);
		return converteEntidadeParaVO(novoCliente);
	}

	public Long count() {
		return clienteRepository.count();
	}

	public ClienteVO converteEntidadeParaVO(Cliente cliente) {
		ClienteVO clienteVO = new ClienteVO();
		List<PedidoVO>listPedidoVO = new ArrayList();
		

		clienteVO.setClientId(cliente.getClientId());
		clienteVO.setEmail(cliente.getEmail());
		clienteVO.setUsername(cliente.getUsername());
		clienteVO.setSenha(cliente.getSenha());
		clienteVO.setNome(cliente.getNome());
		clienteVO.setCpf(cliente.getCpf());
		clienteVO.setTelefone(cliente.getTelefone());
		clienteVO.setDataDeNascimento(cliente.getDataDeNascimento());
		clienteVO.setEnderecoVO(enderecoService.converteEntidadeParaVO(cliente.getEndereco()));
		
		
		if (cliente.getListPedido() != null) {
			for (Pedido lPedido : cliente.getListPedido()) {
				listPedidoVO.add(pedidoService.converteEntidadeParaVO(lPedido));
			}
			clienteVO.setListPedidoVO(listPedidoVO);
		}

		return clienteVO;
		
		}

	public Cliente converteVOParaEntidade(ClienteVO clienteVO, Integer id) {
		Cliente cliente = new Cliente();
		List<Pedido> listPedido = new ArrayList<>();

		cliente.setClientId(clienteVO.getClientId());
		cliente.setEmail(clienteVO.getEmail());
		cliente.setUsername(clienteVO.getUsername());
		cliente.setSenha(clienteVO.getSenha());
		cliente.setNome(clienteVO.getNome());
		cliente.setCpf(clienteVO.getCpf());
		cliente.setTelefone(clienteVO.getTelefone());
		cliente.setDataDeNascimento(clienteVO.getDataDeNascimento());
		cliente.setEndereco(enderecoService.save(enderecoService.consultarCep(clienteVO.getCep()), clienteVO));
		
		
		if (clienteVO.getListPedidoVO() != null) {
			
		
			for (PedidoVO lPedidoVO : clienteVO.getListPedidoVO()) {
				listPedido.add(pedidoService.converteVOParaEntidade(lPedidoVO));
			}
			cliente.setListPedido(listPedido);
		}

		return cliente;
	}
	
	public void delete (Integer id) {
		clienteRepository.deleteById(id);
	}
	
	public ClienteView converteEntidadeParaView(Cliente cliente) {
		ClienteView clienteView = new ClienteView();
		List<PedidoClienteView> listPedidoClienteView = new ArrayList();
		
		clienteView.setNome(cliente.getNome());
		clienteView.setEmail(cliente.getEmail());
		clienteView.setCpf(cliente.getCpf());
		
		for (Pedido lPedido : cliente.getListPedido()) {
			listPedidoClienteView.add(pedidoService.converteEntidadeParaView(lPedido));
		}
			
		clienteView.setListPedidoClienteView(listPedidoClienteView);
		return clienteView;
	}

}
