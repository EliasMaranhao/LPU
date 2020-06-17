package br.com.everis.lpu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.everis.lpu.modelo.Lpu;

@Controller
@RequestMapping("/lpu/lpu")
public class LpuController {
	
	@RequestMapping("/novo")
	public String novo(Lpu lpu) {
		return "lpu/CadastroLpu";
	}
	
}
