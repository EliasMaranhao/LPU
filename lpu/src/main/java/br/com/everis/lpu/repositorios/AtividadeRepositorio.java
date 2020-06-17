package br.com.everis.lpu.repositorios;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.everis.lpu.modelo.Atividade;
import br.com.everis.lpu.modelo.Etapa;

@Repository
public interface AtividadeRepositorio extends JpaRepository<Atividade, Long>{
	
	public Optional<Atividade> findByNomeIgnoreCaseAndEtapa(String nome, Etapa etapa);
	public Optional<List<Atividade>> findByEtapa(Etapa etapa);
}
