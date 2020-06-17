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

import br.com.everis.lpu.modelo.Atividade;
import br.com.everis.lpu.repositorios.AtividadeRepositorio;
import br.com.everis.lpu.repositorios.EtapaRepositorio;
import br.com.everis.lpu.service.AtividadeService;
import br.com.everis.lpu.service.exception.CadastroAtividadeException;

@Controller
@RequestMapping("/lpu/atividade")
public class AtividadeController {
	
	private static final String CADASTRO_VIEW = "lpu/CadastroAtividade";
	private static final String PESQUISA_VIEW = "lpu/PesquisaAtividade";
	
	@Autowired
	private EtapaRepositorio etapaRepositorio;
	
	@Autowired
	private AtividadeRepositorio atividadeRepositorio;
	
	@Autowired
	private AtividadeService atividadeService;
	
	@RequestMapping("/novo")
	public ModelAndView novo(Atividade atividade) {
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		mv.addObject("etapas", etapaRepositorio.findAll());
		return mv;
	}
	
	@RequestMapping("/pesquisar")
	public ModelAndView pesquisar() {
		List<Atividade> todasAtividades = atividadeRepositorio.findAll();
		ModelAndView mv = new ModelAndView(PESQUISA_VIEW);
		mv.addObject("listaAtividade", todasAtividades);
		return mv;
	}
	
	@RequestMapping("{id}")
	public ModelAndView edicao(@PathVariable("id") Atividade atividade) {
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		
		System.out.println("Etapa: " + atividade.getEtapa().getNome());
		System.out.println("Id: " + atividade.getEtapa().getId());
		
		mv.addObject(atividade);
		return mv;
	}
	
	@RequestMapping(value = "/novo", method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid Atividade atividade, BindingResult result, Model model, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			return novo(atividade);
		}
		
		try {
			atividadeService.salvar(atividade);
			attributes.addFlashAttribute("sucesso", "Nova atividade salva com sucesso!");
		}catch (CadastroAtividadeException e) {
			result.rejectValue("nome", e.getMessage(), e.getMessage());
			return novo(atividade);
		}
		
		return new ModelAndView("redirect:/lpu/atividade/novo");
	}
}
