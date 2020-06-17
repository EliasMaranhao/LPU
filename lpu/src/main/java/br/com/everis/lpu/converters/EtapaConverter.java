package br.com.everis.lpu.converters;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import br.com.everis.lpu.modelo.Etapa;
import br.com.everis.lpu.repositorios.EtapaRepositorio;

public class EtapaConverter implements Converter<String, Etapa>{
	
	@Autowired
	private EtapaRepositorio etapaRepositorio;
	
	@Override
	public Etapa convert(String id) {
		
		Etapa etapa = null;
		
		if(!StringUtils.isEmpty(id)) {
			
			Optional<Etapa> optionalEtapa = etapaRepositorio.findById(Long.valueOf(id));
			
			if(optionalEtapa.isPresent())
				etapa = optionalEtapa.get();

			return etapa;
		}
		
		return etapa;
	}

}
