package br.com.everis.lpu.modelo;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "aplicacao")
public class Aplicacao extends EntidadeAbstrata<Long>{
	
	@NotNull(message = "O nome é obrigatorio")
	@NotBlank(message = "Favor preencher o nome da aplicação")
	private String nome;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
