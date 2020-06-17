package br.com.everis.lpu.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.everis.lpu.modelo.Atividade;
import br.com.everis.lpu.modelo.Etapa;
import br.com.everis.lpu.modelo.ItemAtividade;
import br.com.everis.lpu.modelo.Lpu;
import br.com.everis.lpu.modelo.Topico;
import br.com.everis.lpu.service.AtividadeService;
import br.com.everis.lpu.service.EtapaService;

@Controller
@RequestMapping("/lpu/atividadeslpu")
public class AtividadesLpuController {
	private static final String CADASTRO_VIEW = "lpu/CadastroAtividadesLpu";
	private Map<String, List<ItemAtividade>> itens = new HashMap<>();
	
	@Autowired
	private EtapaService etapaService;
	@Autowired
	private AtividadeService atividadeService;
	
	@RequestMapping("/adicionarAtividades")
	public ModelAndView adicionarAtividades(@RequestParam("id") Lpu lpu) {
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		
		itens.put("Análise e Validação de Briefing", new ArrayList<>());
		itens.put("Desenho", new ArrayList<>());
		itens.put("Aprovação - Oi", new ArrayList<>());
		itens.put("Cenário de Teste", new ArrayList<>());
		itens.put("Criação Gmud - Liberações", new ArrayList<>());
		itens.put("Desenvolvimento e Teste Unitário", new ArrayList<>());
		itens.put("Teste Integrado", new ArrayList<>());
		
		mv.addObject("analiseValidacaoBriefing", atividadesPorEtapa("Análise e Validação de Briefing"));
		mv.addObject("desenho", atividadesPorEtapa("Desenho"));
		mv.addObject("aprovacaoOi", atividadesPorEtapa("Aprovação - Oi"));
		mv.addObject("cenarioTeste", atividadesPorEtapa("Cenário de Teste"));
		mv.addObject("criacaoGmudLiberacoes", atividadesPorEtapa("Criação Gmud - Liberações"));
		mv.addObject("desenvolvimentoTesteUnitario", atividadesPorEtapa("Desenvolvimento e Teste Unitário"));
		mv.addObject("testeIntegrado", atividadesPorEtapa("Teste Integrado"));
		
		mv.addObject(lpu);
		mv.addObject(new ItemAtividade());
		return mv;
	}
	
	@ModelAttribute("Topicos")
	public List<Topico> listaDeTopicos(){
		return Arrays.asList(Topico.values());
	}
	
	private List<Atividade> atividadesPorEtapa(String nomeEtapa){
		Etapa etapa = etapaService.buscarEtapaPeloNome(nomeEtapa);
		List<Atividade> atividades = atividadeService.buscarAtividadePorEtapa(etapa);
		return atividades ;
	}
}
