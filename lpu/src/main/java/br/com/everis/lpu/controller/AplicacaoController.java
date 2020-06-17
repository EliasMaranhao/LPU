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

import br.com.everis.lpu.modelo.Aplicacao;
import br.com.everis.lpu.repositorios.AplicacaoRepositorio;
import br.com.everis.lpu.service.AplicacaoService;
import br.com.everis.lpu.service.exception.CadastroAplicationException;

@Controller
@RequestMapping("/lpu/aplicacao")
public class AplicacaoController {
	private static final String CADASTRO_VIEW = "lpu/CadastroAplicacao";
	private static final String PESQUISA_VIEW = "lpu/PesquisaAplicacao";
	
	@Autowired
	private AplicacaoService aplicacaoService;
	
	@Autowired
	private AplicacaoRepositorio aplicacaoRepositorio;
	
	@RequestMapping("/novo")
	public ModelAndView novo(Aplicacao aplicacao) {
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		
		return mv;
	}
	
	@RequestMapping("/pesquisar")
	public ModelAndView pesquisar() {
		List<Aplicacao> todas = aplicacaoRepositorio.findAll();
		ModelAndView mv = new ModelAndView(PESQUISA_VIEW);
		mv.addObject("lista", todas);
		return mv;
	}
	
	@RequestMapping("{codigo}")
	public ModelAndView edicao(@PathVariable("codigo") Aplicacao aplicacao) {
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		mv.addObject(aplicacao);
		return mv;
	}
	
	@RequestMapping(value = "/novo", method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid Aplicacao aplicacao, BindingResult result, Model model, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			return novo(aplicacao);
		}
		
		try {
			aplicacaoService.salvar(aplicacao);
			attributes.addFlashAttribute("sucesso", "Nova aplicação salva com sucesso!");
		}catch (CadastroAplicationException e) {
			result.rejectValue("nome", e.getMessage(), e.getMessage());
			return novo(aplicacao);
		}
	
		return new ModelAndView("redirect:/lpu/aplicacao/novo");
	}
}
