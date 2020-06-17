package br.com.everis.lpu.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.everis.lpu.modelo.Aplicacao;
import br.com.everis.lpu.repositorios.AplicacaoRepositorio;
import br.com.everis.lpu.service.exception.CadastroAplicationException;

@Service
public class AplicacaoService {
	
	@Autowired
	private AplicacaoRepositorio aplicacaoRepositorio;
	
	@Transactional
	public void salvar(Aplicacao aplicacao) {
		Optional<Aplicacao> aplicacaoOptional =  aplicacaoRepositorio.findByNomeIgnoreCase(aplicacao.getNome());
		if(aplicacaoOptional.isPresent())
			throw new CadastroAplicationException("Esta aplicação ja foi cadastrada");
			
		aplicacaoRepositorio.save(aplicacao);
	}
}
