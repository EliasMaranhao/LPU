package br.com.everis.lpu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.everis.lpu.modelo.Atividade;
import br.com.everis.lpu.modelo.Etapa;
import br.com.everis.lpu.repositorios.AtividadeRepositorio;
import br.com.everis.lpu.service.exception.CadastroAtividadeException;

@Service
public class AtividadeService {
	
	@Autowired
	private AtividadeRepositorio atividadeRepositorio;
	
	@Transactional
	public void salvar(Atividade atividade) {
		Optional<Atividade> atividadeOptional =  atividadeRepositorio.findByNomeIgnoreCaseAndEtapa(atividade.getNome(), atividade.getEtapa());
		if(atividadeOptional.isPresent())
			throw new CadastroAtividadeException("Esta atividade já se encontra cadastrada");
		
		atividadeRepositorio.save(atividade);
	}
	
	public List<Atividade> buscarAtividadePorEtapa(Etapa etapa){
		List<Atividade> atividades = null;
		
		Optional<List<Atividade>> optionalAtividades = atividadeRepositorio.findByEtapa(etapa);
		if(optionalAtividades.isPresent())
			atividades = optionalAtividades.get();
		
		return atividades;
	}
}
