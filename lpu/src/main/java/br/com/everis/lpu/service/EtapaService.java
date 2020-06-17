package br.com.everis.lpu.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.everis.lpu.modelo.Etapa;
import br.com.everis.lpu.repositorios.EtapaRepositorio;
import br.com.everis.lpu.service.exception.CadastroEtapaException;

@Service
public class EtapaService {
	
	@Autowired
	private EtapaRepositorio etapaRepositorio;
	
	@Transactional
	public void salvar(Etapa etapa) {
		Optional<Etapa> etapaOptional =  etapaRepositorio.findByNomeIgnoreCase(etapa.getNome());
		if(etapaOptional.isPresent())
			throw new CadastroEtapaException("Esta etapa já está cadastrada");
		
		etapaRepositorio.save(etapa);
	}
	
	public Etapa buscarEtapaPeloNome(String nome) {
		Etapa etapa = null;
		
		Optional<Etapa> optionalEtapa = etapaRepositorio.findByNomeIgnoreCase(nome);
		
		if(optionalEtapa.isPresent()) 
			etapa = optionalEtapa.get();
		
		return etapa;
	}
}
