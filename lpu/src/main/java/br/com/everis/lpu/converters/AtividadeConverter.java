package br.com.everis.lpu.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import br.com.everis.lpu.modelo.Atividade;

public class AtividadeConverter  implements Converter<String, Atividade>{

	@Override
	public Atividade convert(String codigo) {
		if(!StringUtils.isEmpty(codigo)) {
			Atividade atividade = new Atividade();
			atividade.setId(Long.parseLong(codigo));
			return atividade;
		}
		
		return null;
	}

}
