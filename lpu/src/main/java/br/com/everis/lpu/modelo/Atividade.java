package br.com.everis.lpu.modelo;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@SuppressWarnings("serial")
@Entity
@Table(name="atividade")
public class Atividade extends EntidadeAbstrata<Long>{
	
	@NotNull(message = "O nome é obrigatorio")
	@NotBlank(message = "O nome não pode estar vazio")
	private String nome;
	
	@NotNull(message = "A duração é obrigatorio")
	@NotBlank(message = "A duração não pode estar vazio")
	private String duracao;
	
	@NotNull(message = "A etapa é obrigatorio")
	@ManyToOne
	@JoinColumn(name="etapa_id")
	private Etapa etapa;
	
	@OneToMany(mappedBy = "atividade")
	private Set<ItemAtividade> itensAtividade;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDuracao() {
		return duracao;
	}

	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}

	public Etapa getEtapa() {
		return etapa;
	}

	public void setEtapa(Etapa etapa) {
		this.etapa = etapa;
	}

	public Set<ItemAtividade> getItensAtividade() {
		return itensAtividade;
	}

	public void setItensAtividade(Set<ItemAtividade> itensAtividade) {
		this.itensAtividade = itensAtividade;
	}
	
}
