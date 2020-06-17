package br.com.everis.lpu.modelo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Login {
	
	@NotNull @NotBlank(message = "Favor infomar o email")
	private String email;
	
	@NotNull @NotBlank(message = "Favor infomar a senha")
	private String senha;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	
}
