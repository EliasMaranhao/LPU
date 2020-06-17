package br.com.everis.lpu.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.everis.lpu.modelo.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long>{

	public Optional<Usuario> findByEmailAndSenha(String email, String senha);
	
}
