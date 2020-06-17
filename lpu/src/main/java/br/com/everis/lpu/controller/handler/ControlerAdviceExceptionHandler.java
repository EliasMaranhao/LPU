package br.com.everis.lpu.controller.handler;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.everis.lpu.service.exception.UsuarioLoginException;

@ControllerAdvice
public class ControlerAdviceExceptionHandler {
	
	@ExceptionHandler(UsuarioLoginException.class)
	public void handleUsuarioLoginException(UsuarioLoginException e) {
		
	}
	
}
