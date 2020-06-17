package br.com.everis.lpu.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

import br.com.everis.lpu.modelo.Lpu;

public class LpuConverter implements Converter<String, Lpu>{

	@Override
	public Lpu convert(String codigo) {
		if(!StringUtils.isEmpty(codigo)) {
			Lpu lpu = new Lpu();
			lpu.setId(Long.valueOf(codigo));
			return lpu;
		}
		
		return null;
	}

}
