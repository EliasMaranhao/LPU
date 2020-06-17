package br.com.everis.lpu.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.everis.lpu.modelo.Lpu;

@Repository
public interface LpuRepositorio extends JpaRepository<Lpu, Long>{}
