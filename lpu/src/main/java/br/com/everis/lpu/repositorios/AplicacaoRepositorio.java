package br.com.everis.lpu.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.everis.lpu.modelo.Aplicacao;

public interface AplicacaoRepositorio extends JpaRepository<Aplicacao, Long>{
	
	public Optional<Aplicacao> findByNomeIgnoreCase(String nome);
	
}
