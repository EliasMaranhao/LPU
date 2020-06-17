package br.com.everis.lpu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.everis.lpu.modelo.Dashboard;
import br.com.everis.lpu.modelo.Demanda;
import br.com.everis.lpu.repositorios.DemandaRepositorio;

@Service
public class DashboardService {
	
	@Autowired
	DemandaRepositorio demandaRepositorio;
	
	public Dashboard getDashboard(Long codigo) {
		Demanda demanda = demandaRepositorio.getOne(codigo);
		
		Dashboard dashboard = new Dashboard();
		dashboard.setDemada(demanda);
		
		return dashboard;
	}
}
