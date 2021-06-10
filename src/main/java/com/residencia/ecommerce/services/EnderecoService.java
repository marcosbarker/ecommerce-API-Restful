package com.residencia.ecommerce.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.residencia.ecommerce.entities.Cliente;
import com.residencia.ecommerce.entities.Endereco;
import com.residencia.ecommerce.repositories.EnderecoRepository;
import com.residencia.ecommerce.vo.ClienteVO;
import com.residencia.ecommerce.vo.EnderecoVO;

@Service
public class EnderecoService {

	@Autowired
	public EnderecoRepository enderecoRepository;
	
	@Autowired
	public ClienteService clienteService;

	public EnderecoVO findById(Integer id) {
		Endereco endereco = enderecoRepository.findById(id).get();
		return converteEntidadeParaVO(endereco);
	}

	public List<EnderecoVO> findAll(Integer pagina, Integer qtdRegistros) throws Exception{
		Pageable page = null;
		List<Endereco> listEndereco= null;
		List<Endereco> listEnderecoComPaginacao = null;
		List<EnderecoVO> listEnderecoVO = new ArrayList();
		try {
			if (null != pagina && null != qtdRegistros) {

				page = PageRequest.of(pagina, qtdRegistros);
				listEnderecoComPaginacao = enderecoRepository.findAll(page).getContent();

				for (Endereco lEndereco : listEnderecoComPaginacao) {
					listEnderecoVO.add(converteEntidadeParaVO(lEndereco));
				}

			} else {
				listEndereco = enderecoRepository.findAll();

				for (Endereco lEndereco : listEndereco) {
					listEnderecoVO.add(converteEntidadeParaVO(lEndereco));
				}

			}
		} catch (Exception e) {
			throw new Exception("Não foi possível recuperar a lista de pedidos ::" + e.getMessage());
		}
		return listEnderecoVO;
	}
	
	public Long count() {
		return enderecoRepository.count();
	}

	public Endereco save(EnderecoVO enderecoVO, ClienteVO clienteVO) {
		Endereco novoEndereco = converteVOParaEntidade(enderecoVO, clienteVO);
		enderecoRepository.save(novoEndereco);
		return novoEndereco;
	}

	public EnderecoVO update(EnderecoVO enderecoVO, Integer id) {
		Endereco endereco = converteVOParaEntidade1(enderecoVO, id);
		enderecoRepository.save(endereco);
		return converteEntidadeParaVO(endereco);
	}
	
	public EnderecoVO converteEntidadeParaVO(Endereco endereco) {
		EnderecoVO enderecoVO = new EnderecoVO();
		List<ClienteVO> listClienteVO = new ArrayList<>();
		
		enderecoVO.setEnderecoId(endereco.getEnderecoId());
		enderecoVO.setLogradouro(endereco.getRua());
		enderecoVO.setNumero(endereco.getNumero());
		enderecoVO.setComplemento(endereco.getComplemento());
		enderecoVO.setBairro(endereco.getBairro());
		enderecoVO.setLocalidade(endereco.getCidade());
		enderecoVO.setUf(endereco.getEstado());
		enderecoVO.setCep(endereco.getCep());
		
		if(endereco.getListCliente() != null) {
		for (Cliente lCliente : endereco.getListCliente()) {
			listClienteVO.add(clienteService.converteEntidadeParaVO(lCliente));
		}
		}
		return enderecoVO;
	}
	
	public Endereco converteVOParaEntidade(EnderecoVO enderecoVO, ClienteVO clienteVO) {
		Endereco endereco = new Endereco();
		
		
		endereco.setEnderecoId(enderecoVO.getEnderecoId());
		endereco.setRua(enderecoVO.getLogradouro());
		
		if(enderecoVO.getNumero() == null) {
			endereco.setNumero(clienteVO.getNumeroCasa());
		}else {
		endereco.setNumero(enderecoVO.getNumero());
		}
		
		endereco.setComplemento(enderecoVO.getComplemento());
		endereco.setBairro(enderecoVO.getBairro());
		endereco.setCidade(enderecoVO.getLocalidade());
		endereco.setEstado(enderecoVO.getUf());
		endereco.setCep(enderecoVO.getCep());
		
		if (enderecoVO.getListClienteVO() != null) {
			List<Cliente> listCliente = new ArrayList<>();
			
		for (ClienteVO lClienteVO : enderecoVO.getListClienteVO()) {
			
		}
		}
		
		return endereco;
	}
	
	public Endereco converteVOParaEntidade1(EnderecoVO enderecoVO, Integer id) {
		Endereco endereco = new Endereco();
		
		
		endereco.setEnderecoId(enderecoVO.getEnderecoId());
		endereco.setRua(enderecoVO.getLogradouro());
		endereco.setNumero(enderecoVO.getNumero());		
		endereco.setComplemento(enderecoVO.getComplemento());
		endereco.setBairro(enderecoVO.getBairro());
		endereco.setCidade(enderecoVO.getLocalidade());
		endereco.setEstado(enderecoVO.getUf());
		endereco.setCep(enderecoVO.getCep());
		
		if (enderecoVO.getListClienteVO() != null) {
			List<Cliente> listCliente = new ArrayList<>();
			
		for (ClienteVO lClienteVO : enderecoVO.getListClienteVO()) {
			
			}
		}
		
		return endereco;
	}
	
	//Fazer metodo de conversao de VO para Entidade -> falta entender o SAVE

	public void delete(Integer id) {
		enderecoRepository.deleteById(id);
	}
	
	public EnderecoVO consultarCep(String cep) {
		RestTemplate restTemplate = new RestTemplate();
		String uri = "https://viacep.com.br/ws/{cep}/json/";	
		Map<String, String> params = new HashMap<String, String>();
		params.put("cep", cep);
			
		EnderecoVO enderecoVO = restTemplate.getForObject(uri, EnderecoVO.class, params);
			
		return enderecoVO;
	  }

}
