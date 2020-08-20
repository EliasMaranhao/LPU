package br.com.everis.lpu.modelo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/*
 * Class Join Table to Lpu And Atividade
 * */

@Entity
@Table(name="item_atividade")
public class ItemAtividade extends EntidadeAbstrata<Long>{
	
private static final long serialVersionUID = 1L;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "atividade_id")
	private Atividade atividade;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "lpu_id")
	private Lpu lpu;
	
	@NotNull
	@Column(nullable = false, length = 2)
	private int quantidade;
	
	@NotBlank
	@Column(nullable = false, length = 8)
	private String totalHorasAtividade;
	
	@NotBlank
	@Column(nullable = false, length = 8)
	private String totalHorasDecAtividade;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private Topico topico;
	
	public Atividade getAtividade() {
		return atividade;
	}

	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}

	public int getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public Topico getTopico() {
		return topico;
	}
	
	public void setTopico(Topico topico) {
		this.topico = topico;
	}
	
	public String getTotalHorasAtividade() {
		return totalHorasAtividade;
	}

	public void setTotalHorasAtividade(String totalHorasAtividade) {
		this.totalHorasAtividade = totalHorasAtividade;
	}

	public String getTotalHorasDecAtividade() {
		return totalHorasDecAtividade;
	}

	public void setTotalHorasDecAtividade(String totalHorasDecAtividade) {
		this.totalHorasDecAtividade = totalHorasDecAtividade;
	}
	
	public Lpu getLpu() {
		return lpu;
	}

	public void setLpu(Lpu lpu) {
		this.lpu = lpu;
	}
	
}