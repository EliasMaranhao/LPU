package br.com.everis.lpu.modelo;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="permissao")
public class Permissao extends EntidadeAbstrata<Long>{
	
	private String descricao;
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
