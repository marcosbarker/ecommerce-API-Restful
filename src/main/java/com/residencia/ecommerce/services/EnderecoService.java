package com.residencia.ecommerce.services;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.residencia.ecommerce.entities.Cliente;
import com.residencia.ecommerce.entities.Endereco;
import com.residencia.ecommerce.repositories.EnderecoRepository;
import com.residencia.ecommerce.vo.ClienteVO;
import com.residencia.ecommerce.vo.EnderecoVO;

@Service
public class EnderecoService {

	@Autowired
	public EnderecoRepository enderecoRepository;

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

	public Endereco save(Endereco endereco) {
		return enderecoRepository.save(endereco);
	}

	public Long count() {
		return enderecoRepository.count();
	}

	public Endereco update(Endereco endereco, Integer id) {
		endereco.setEnderecoId(id);
		return enderecoRepository.save(endereco);
	}
	
	private EnderecoVO converteEntidadeParaVO(Endereco endereco) {
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
		
		for (Cliente lCliente : endereco.getListCliente()) {
			
		}
		
		return enderecoVO;
	}
	
	//Fazer metodo de conversao de VO para Entidade -> falta entender o SAVE

	public void delete(Integer id) {
		enderecoRepository.deleteById(id);
	}

}
