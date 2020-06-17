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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.everis.lpu.modelo.Demanda;
import br.com.everis.lpu.modelo.StatusDemanda;
import br.com.everis.lpu.modelo.Usuario;
import br.com.everis.lpu.repositorios.AplicacaoRepositorio;
import br.com.everis.lpu.repositorios.DemandaRepositorio;
import br.com.everis.lpu.service.DemandaService;
import br.com.everis.lpu.service.exception.CadastroDemandaException;

@Controller
@RequestMapping("/lpu/demanda")
public class DemandaController {
	
	private static final String CADASTRO_VIEW = "lpu/CadastroDemanda";
	private static final String PESQUISA_VIEW = "lpu/PesquisaDemanda";
	
	@Autowired
	private AplicacaoRepositorio aplicacaoRepositorio;
	@Autowired
	private DemandaRepositorio demandaRepositorio;
	
	@Autowired
	private DemandaService demandaService;
	
	@RequestMapping("/novo")
	public ModelAndView novo(Demanda demanda) {
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		mv.addObject("aplicacoes", aplicacaoRepositorio.findAll());
		mv.addObject("situacoes", StatusDemanda.values());
		return mv;
	}

	@RequestMapping("/pesquisar")
	public ModelAndView pesquisar() {
		ModelAndView mv = new ModelAndView(PESQUISA_VIEW);
		
		List<Demanda> demandas = demandaRepositorio.findAll();
		mv.addObject("demandas", demandas);
		
		return mv;
	}
	
	@RequestMapping("/demandaByAlfaNumerico")
	public ModelAndView consultarPeloCodigoOi(@RequestParam("alfaNumerico") String alfaNumerico) {
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		
		try {
			Demanda demanda = demandaService.buscarPeloCodigoAlfaNumerico(alfaNumerico);
			mv.addObject(demanda);
			
		}catch (CadastroDemandaException e) {
			mv.addObject("error", "Esta demanda está fechada ou cancelada. Por favor cadastre uma nova demanda!");
			//result.rejectValue("alfaNumerico", e.getMessage(), e.getMessage());
			return novo(new Demanda());
		}
		
		return mv;
	}
	
	@RequestMapping("/editar/{id}")
	public ModelAndView editar(@PathVariable("id") Demanda demanda) {
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		
		if(demanda.isDemandaCancelada() || demanda.isDemandaFechada()) {
			mv.addObject("error", "Esta demanda está fechada ou cancelada. Por favor cadastre uma nova demanda!");
			mv.addObject(new Demanda());
			return mv;
		}
		mv.addObject(demanda);
		return mv;
	}
	
	@RequestMapping(value = "/novo", method = RequestMethod.POST)
	public ModelAndView cadastrar(@Valid Demanda demanda, BindingResult result, Model model, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			return novo(demanda);
		}
		
		try {
			Usuario usuario = new Usuario();
			usuario.setId(1L);
			demanda.setUsuario(usuario);
			demandaService.salvar(demanda);
			attributes.addFlashAttribute("sucesso", "Nova demanda salva com sucesso!");
		}catch (CadastroDemandaException e) {
			result.rejectValue("alfaNumerico", e.getMessage(), e.getMessage());
			return novo(demanda);
		}
		
		return new ModelAndView("redirect:/lpu/demanda/novo");
	}
}
