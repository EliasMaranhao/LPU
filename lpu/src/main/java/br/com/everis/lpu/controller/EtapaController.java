package br.com.everis.lpu.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.everis.lpu.modelo.Etapa;
import br.com.everis.lpu.repositorios.EtapaRepositorio;
import br.com.everis.lpu.service.EtapaService;
import br.com.everis.lpu.service.exception.CadastroEtapaException;

@Controller
@RequestMapping("/lpu/etapa")
public class EtapaController {

	private static final String CADASTRO_VIEW = "lpu/CadastroEtapa";
	private static final String PESQUISA_VIEW = "lpu/PesquisaEtapa";
	
	@Autowired
	private EtapaService etapaService;
	@Autowired
	private EtapaRepositorio etapaRepositorio;
	
	@RequestMapping("/novo")
	public ModelAndView novo(Etapa etapa) {
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		return mv;
	}
	
	@RequestMapping("/pesquisar")
	public ModelAndView pesquisar() {
		List<Etapa> todas = etapaRepositorio.findAll();
		ModelAndView mv = new ModelAndView(PESQUISA_VIEW);
		mv.addObject("lista", todas);
		return mv;
	}
	
	@RequestMapping("{id}")
	public ModelAndView edicao(@PathVariable("id") Etapa etapa) {
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		mv.addObject(etapa);
		return mv;
	}
	
	@RequestMapping(value = "/novo", method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid Etapa etapa, BindingResult result, Model model, RedirectAttributes attributes) {
		
		if(result.hasErrors()) {
			return novo(etapa);
		}
		
		try {
			etapaService.salvar(etapa);
			attributes.addFlashAttribute("sucesso", "Etapa salva com sucesso!");
		}catch (CadastroEtapaException e) {
			result.rejectValue("nome", e.getMessage(), e.getMessage());
			return novo(etapa);
		}
		
		return new ModelAndView("redirect:/lpu/etapa/novo");
	}
	
}
