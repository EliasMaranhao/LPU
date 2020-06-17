package br.com.everis.lpu.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.everis.lpu.modelo.Dashboard;
import br.com.everis.lpu.modelo.Topico;
import br.com.everis.lpu.service.DashboardService;

@Controller
@RequestMapping("/lpu/dashboard")
public class DashboardController {
	
	private static final String DASHBOARD_VIEW = "lpu/Dashboard";
	
	@Autowired
	private DashboardService service;
	
	@RequestMapping("/resumo")
	public ModelAndView resumo(@RequestParam("codigoOi") String codigoOi, @RequestParam("codigo") Long codigo) {
		ModelAndView mv = new ModelAndView(DASHBOARD_VIEW);
		
		Dashboard dashboard = service.getDashboard(codigo);
		
		mv.addObject("nome", dashboard.getDemada().getAplicacao().getNome());
		mv.addObject("codigoOi", dashboard.getDemada().getAlfaNumerico());
		mv.addObject("descricao", dashboard.getDemada().getDescricao());
		
		
		System.out.println("Código Oi: " + dashboard.getDemada().getAlfaNumerico());
		System.out.println("Código:" + dashboard.getDemada().getId());
		return mv;
	}
	
	@ModelAttribute("todosTopicos")
	public List<Topico> listaTodosTopicos(){
		return Arrays.asList(Topico.values());
	}
}
