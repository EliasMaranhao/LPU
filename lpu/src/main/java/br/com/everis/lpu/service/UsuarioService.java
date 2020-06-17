package br.com.everis.lpu.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.everis.lpu.modelo.Usuario;
import br.com.everis.lpu.repositorios.UsuarioRepositorio;
import br.com.everis.lpu.service.exception.CadastroDemandaException;
import br.com.everis.lpu.service.exception.UsuarioLoginException;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	@Transactional
	public void salvar(Usuario usuario) {
		usuarioRepositorio.save(usuario);
	}
	
	public Usuario buscarUsuario(Usuario usuario) {
		
		String email = usuario.getEmail();
		String senha = usuario.getSenha();
		
		Optional<Usuario> optionalUsuario = usuarioRepositorio.findByEmailAndSenha(email, senha); 
		
		if(optionalUsuario.isPresent())
			usuario = optionalUsuario.get();
		else 
			throw new UsuarioLoginException("Email ou senha inválida");
		
		return usuario;
	}
}
