package br.com.everis.lpu.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.everis.lpu.modelo.Login;
import br.com.everis.lpu.modelo.Usuario;
import br.com.everis.lpu.service.UsuarioService;
import br.com.everis.lpu.service.exception.UsuarioLoginException;

@Controller
@RequestMapping("/lpu/login")
public class LoginController {
	
	private static final String LOGIN_VIEW = "lpu/Login";
	private static final String RECUPERAR_SENHA_VIEW = "lpu/RecuperarSenha";
	
	@Autowired
	private UsuarioService usuarioService;
	
	@RequestMapping("/entrar")
	public ModelAndView login(Login login) {
		ModelAndView mv = new ModelAndView(LOGIN_VIEW);
		return  mv;
	}
	
	@RequestMapping("/recuperarSenha")
	public ModelAndView recuperarSenha(Login login) {
		ModelAndView mv = new ModelAndView(RECUPERAR_SENHA_VIEW);
		return  mv;
	}
	
	@RequestMapping(value = "/entrar", method = RequestMethod.POST)
	public ModelAndView login(@Valid Login login, BindingResult result) {
		ModelAndView mv = new ModelAndView(LOGIN_VIEW);
		
		if(result.hasErrors()) {
			return login(login);
		}
		
		Usuario usuario = new Usuario();
		usuario.setEmail(login.getEmail());
		usuario.setSenha(login.getSenha());
		
		try {
			usuario = usuarioService.buscarUsuario(usuario);
			
			System.out.println("Email: " + usuario.getEmail());
			System.out.println("Senha: " + usuario.getSenha());
			System.out.println("Logou");
			
		}catch(UsuarioLoginException e) {
			result.rejectValue("email", e.getMessage(), e.getMessage());
			return login(login);
		}

		return null;
	}
}
