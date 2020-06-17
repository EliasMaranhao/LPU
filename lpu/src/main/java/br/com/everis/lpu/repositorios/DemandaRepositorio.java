package br.com.everis.lpu.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.everis.lpu.modelo.Demanda;

public interface DemandaRepositorio extends JpaRepository<Demanda, Long>{
	
	public Optional<Demanda> findByAlfaNumericoIgnoreCase(String alfaNumerico);
	
}
