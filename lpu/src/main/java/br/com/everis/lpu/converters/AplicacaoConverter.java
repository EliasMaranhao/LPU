package br.com.everis.lpu.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import br.com.everis.lpu.modelo.Aplicacao;

public class AplicacaoConverter implements Converter<String, Aplicacao>{
	
	@Override
	public Aplicacao convert(String codigo) {
		if(!StringUtils.isEmpty(codigo)) {
			Aplicacao aplicacao = new Aplicacao();
			aplicacao.setId(Long.parseLong(codigo));
			return aplicacao;
		}
		
		return null;
	}
}