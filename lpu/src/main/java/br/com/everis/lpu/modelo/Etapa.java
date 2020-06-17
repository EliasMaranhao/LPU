package br.com.everis.lpu.modelo;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@SuppressWarnings("serial")
@Entity
@Table(name = "etapa")
public class Etapa extends EntidadeAbstrata<Long>{

	@NotNull(message = "O nome é obrigatorio")
	@NotBlank(message = "Por favor, informe o nome da etapa.")
	private String nome;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
