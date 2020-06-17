package br.com.everis.lpu.modelo;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import br.com.everis.lpu.anotacoes.alfaNumerico;

@SuppressWarnings("serial")
@Entity
@Table(name="demanda")
public class Demanda extends EntidadeAbstrata<Long>{
	
	@NotNull(message = "O código é obrigatorio")
	@NotBlank(message = "Por favor, informe o código da demanda.")
	@Column(name = "alfa_numerico", unique = true, nullable = false, length = 8)
	@alfaNumerico
	private String alfaNumerico;
	
	@NotNull(message = "A data da release é obrigatoria")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	@Column(name = "data_release")
	private Date dataRelease;
	
	@NotNull(message = "A data de preenchimento é obrigatoria")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	@Column(name = "data_preenchimento")
	private Date dataPreenchimento;
	
	@NotNull(message = "O solicitante é obrigatorio")
	@NotBlank(message = "Por favor, informe o solicitante.")
	private String solicitante;
	
	@NotNull(message = "A descrição é obrigatória")
	@NotBlank(message = "Por favor, informe uma descrição.")
	private String descricao;
	
	@NotNull(message = "A aplicação é obrigatória")
	@ManyToOne
	@JoinColumn(name="aplicacao_id")
	private Aplicacao aplicacao;
	
	@NotNull(message = "A situação é obrigatória")
	@Enumerated(EnumType.STRING)
	@Column(name="situacao")
	private StatusDemanda statusDemanda;
	
	@Column(name="observacao")
	private String observacao;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "lpu_id")
	private Lpu lpu;
	
	@ManyToOne
	@JoinColumn(name="usuario_id")
	private Usuario usuario;

	@PrePersist
	@PreUpdate
	private void prePersistUpdate() {
		alfaNumerico = alfaNumerico.toUpperCase();
	}
	
	public Lpu getLpu() {
		return lpu;
	}

	public void setLpu(Lpu lpu) {
		this.lpu = lpu;
	}

	public Date getDataRelease() {
		return dataRelease;
	}

	public void setDataRelease(Date dataRelease) {
		this.dataRelease = dataRelease;
	}

	public Date getDataPreenchimento() {
		return dataPreenchimento;
	}

	public void setDataPreenchimento(Date dataPreenchimento) {
		this.dataPreenchimento = dataPreenchimento;
	}

	public String getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(String solicitante) {
		this.solicitante = solicitante;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Aplicacao getAplicacao() {
		return aplicacao;
	}

	public void setAplicacao(Aplicacao aplicacao) {
		this.aplicacao = aplicacao;
	}

	public StatusDemanda getStatusDemanda() {
		return statusDemanda;
	}

	public void setStatusDemanda(StatusDemanda statusDemanda) {
		this.statusDemanda = statusDemanda;
	}
	
	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	public String getAlfaNumerico() {
		return alfaNumerico;
	}

	public void setAlfaNumerico(String alfaNumerico) {
		this.alfaNumerico = alfaNumerico;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public boolean isDemandaAberta() {
		return StatusDemanda.ABERTO.equals(this.statusDemanda);
	}
	
	public boolean isDemandaEmDesenvolvimento() {
		return StatusDemanda.EM_DESENVOLVIMENTO.equals(this.statusDemanda);
	}
	
	public boolean isDemandaEmTesteUnitario() {
		return StatusDemanda.EM_TESTE_UNITARIO.equals(this.statusDemanda);
	}
	
	public boolean isDemandaEmTesteIntegrado() {
		return StatusDemanda.EM_TESTE_INTEGRADO.equals(this.statusDemanda);
	}
	
	public boolean isDemandaEmUAT() {
		return StatusDemanda.EM_UAT.equals(this.statusDemanda);
	}
	
	public boolean isDemandaFechada() {
		return StatusDemanda.FECHADO.equals(this.statusDemanda);
	}
	
	public boolean isDemandaCancelada() {
		return StatusDemanda.CANCELADO.equals(this.statusDemanda);
	}
	
	public boolean isDemandaAguardandoCliente() {
		return StatusDemanda.AGUARDANDO_CLIENTE.equals(this.statusDemanda);
	}
	
	public boolean isDemandaAguardandoTerceiro() {
		return StatusDemanda.AGUARDANDO_TERCEIRO.equals(this.statusDemanda);
	}

}
