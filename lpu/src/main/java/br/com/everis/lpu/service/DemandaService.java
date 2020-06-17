package br.com.everis.lpu.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.everis.lpu.modelo.Demanda;
import br.com.everis.lpu.repositorios.DemandaRepositorio;
import br.com.everis.lpu.service.exception.CadastroDemandaException;

@Service
public class DemandaService {
	
	@Autowired
	private DemandaRepositorio demandaRepositorio;
	
	@Transactional
	public void salvar(Demanda demanda) {
		Optional<Demanda> demandaOptional =  demandaRepositorio.findByAlfaNumericoIgnoreCase(demanda.getAlfaNumerico());
		if(demandaOptional.isPresent())
			throw new CadastroDemandaException("Esta demanda já está cadastrada");
			
		demandaRepositorio.save(demanda);
	}
	
	public Demanda buscarPeloCodigoAlfaNumerico(String alfaNumerico) {
		Demanda demanda = null;
		
		Optional<Demanda> optionalDemanda = demandaRepositorio.findByAlfaNumericoIgnoreCase(alfaNumerico);
		if(optionalDemanda.isPresent()) 
			demanda = optionalDemanda.get();
		else
			throw new CadastroDemandaException("Demanda não localizada");
		
		return demanda;
	}
}
