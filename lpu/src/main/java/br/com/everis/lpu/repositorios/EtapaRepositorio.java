package br.com.everis.lpu.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.everis.lpu.modelo.Etapa;

@Repository
public interface EtapaRepositorio extends JpaRepository<Etapa, Long>{
	
	public Optional<Etapa> findByNomeIgnoreCase(String nome);
	
}
