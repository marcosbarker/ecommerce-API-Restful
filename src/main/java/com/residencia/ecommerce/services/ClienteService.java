package com.residencia.ecommerce.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.residencia.ecommerce.entities.Categoria;
import com.residencia.ecommerce.entities.Cliente;
import com.residencia.ecommerce.entities.Pedido;
import com.residencia.ecommerce.repositories.ClienteRepository;
import com.residencia.ecommerce.repositories.EnderecoRepository;
import com.residencia.ecommerce.vo.CategoriaVO;
import com.residencia.ecommerce.vo.ClienteVO;
import com.residencia.ecommerce.vo.PedidoVO;

@Service
public class ClienteService {
	
	@Autowired 
	ClienteRepository clienteRepository;
	
	@Autowired
	EnderecoService enderecoService;
	
	public ClienteVO findById(Integer id) {
		Cliente cliente = clienteRepository.findById(id).get();
		ClienteVO clienteVO = converteEntidadeParaVO(cliente);
		return clienteVO;
	}

	public List<ClienteVO> findAllVO(Integer pagina, Integer qtdRegistros) throws Exception {
		Pageable page = null;
		List<Cliente> listCliente = null;
		List<Cliente> listClienteComPaginacao = null;
		List<ClienteVO> listClienteVO = new ArrayList<>();

		try {
			if (null != pagina && null != qtdRegistros) {

				page = PageRequest.of(pagina, qtdRegistros);
				listClienteComPaginacao = clienteRepository.findAll(page).getContent();

				for (Cliente lCliente : listClienteComPaginacao) {
					listClienteVO.add(converteEntidadeParaVO(lCliente));
				}

			} else {
				listCliente = clienteRepository.findAll();

				for (Cliente lCliente : listCliente) {
					listClienteVO.add(converteEntidadeParaVO(lCliente));
				}

			}
		} catch (Exception e) {
			throw new Exception("Não foi possível recuperar a lista de pedidos ::" + e.getMessage());
		}

		return listClienteVO;
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
			List<PedidoVO> listPedidoVO = new ArrayList<>();
			
			for (Pedido lPedido : cliente.getListPedido()) {
				
				// PASSANDO PEDIDO ENTIDADE PARA VO
				
				/*
				PedidoVO pedidoVO = new PedidoVO();
				 
				pedidoVO.setCliente(lPedido.getCliente()); 
				
				pedidoVO.setDataDoPedido(lPedido.getDataDoPedido());
				pedidoVO.setListaDeProdutosDoPedido(lPedido.getListaDeProdutosDoPedido()); //VERIFICAR
				pedidoVO.setNumeroDoPedido(lPedido.getNumeroDoPedido());
				pedidoVO.setPedidoId(lPedido.getPedidoId());
				pedidoVO.setStatus(lPedido.getStatus());
				pedidoVO.setValorTotalDoPedido(lPedido.getValorTotalDoPedido());
				 
				listPedidoVO.add(pedidoVO);
			 	
				 */ 
				
			}

		}

		return clienteVO;
		
	}

	public Cliente converteVOParaEntidade(ClienteVO clienteVO, Integer id) {
		Cliente cliente = new Cliente();
		

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
			List<Pedido> listPedido = new ArrayList<>();
		
			for (PedidoVO lPedidoVO : clienteVO.getListPedidoVO()) {
				
				// PASSANDO PEDIDO VO PARA ENTIDADE
				
				/*
				 
				      // VERIFICAR
				 
				Pedido pedido = new Pedido();
				 
				pedidoVO.setCliente(lPedido.getCliente()); 
				
				pedido.setDataDoPedido(lPedido.getDataDoPedido());
				pedido.setListaDeProdutosDoPedido(lPedido.getListaDeProdutosDoPedido()); //VERIFICAR
				pedido.setNumeroDoPedido(lPedido.getNumeroDoPedido());
				pedido.setPedidoId(lPedido.getPedidoId());
				pedido.setStatus(lPedido.getStatus());
				pedido.setValorTotalDoPedido(lPedido.getValorTotalDoPedido());
				 
				listPedido.add(pedido);
			 	
				 */ 
				
			}
		
		}

		return cliente;
	}
	
	public void delete (Integer id) {
		clienteRepository.deleteById(id);
	}
	

}
