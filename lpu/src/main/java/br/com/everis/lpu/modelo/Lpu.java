package br.com.everis.lpu.modelo;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

@SuppressWarnings("serial")
@Entity
public class Lpu extends EntidadeAbstrata<Long>{
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date dataCriacao;
	
	@OneToMany(mappedBy = "lpu")
	private Set<ItemAtividade> itensAtividade;
	
	@OneToOne(mappedBy = "lpu")
	private Demanda demanda;
	
	private String criadaPor;
	private String descricao;
	
	private String etapaAnaliseValidacaoBriefing;
	private String etapaDesenho;
	private String etapaAprovacaoOi;
	private String etapaCenarioTeste;
	private String etapaCriacaoGmudLiberacao;
	private String etapaDesenvolvimento;
	private String etapaTesteIntegrado;
	private String etapaAcompanhamentoUAT;
	private String etapaPreparoImplantcao;
	private String etapaPosRelease;
	private String totalHorasLpu;
	private String totalHorasDecLpu;
	
	@Transient
	private String lpu_codigoFormatado;
	
	public Date getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public String getCriadaPor() {
		return criadaPor;
	}
	public void setCriadaPor(String criadaPor) {
		this.criadaPor = criadaPor;
	}
	public Set<ItemAtividade> getItensAtividade() {
		return itensAtividade;
	}
	public void setItensAtividade(Set<ItemAtividade> itensAtividade) {
		this.itensAtividade = itensAtividade;
	}
	public Demanda getDemanda() {
		return demanda;
	}
	public void setDemanda(Demanda demanda) {
		this.demanda = demanda;
	}
	public String getEtapaAnaliseValidacaoBriefing() {
		return etapaAnaliseValidacaoBriefing;
	}
	public void setEtapaAnaliseValidacaoBriefing(String etapaAnaliseValidacaoBriefing) {
		this.etapaAnaliseValidacaoBriefing = etapaAnaliseValidacaoBriefing;
	}
	public String getEtapaDesenho() {
		return etapaDesenho;
	}
	public void setEtapaDesenho(String etapaDesenho) {
		this.etapaDesenho = etapaDesenho;
	}
	public String getEtapaAprovacaoOi() {
		return etapaAprovacaoOi;
	}
	public void setEtapaAprovacaoOi(String etapaAprovacaoOi) {
		this.etapaAprovacaoOi = etapaAprovacaoOi;
	}
	public String getEtapaCenarioTeste() {
		return etapaCenarioTeste;
	}
	public void setEtapaCenarioTeste(String etapaCenarioTeste) {
		this.etapaCenarioTeste = etapaCenarioTeste;
	}
	public String getEtapaCriacaoGmudLiberacao() {
		return etapaCriacaoGmudLiberacao;
	}
	public void setEtapaCriacaoGmudLiberacao(String etapaCriacaoGmudLiberacao) {
		this.etapaCriacaoGmudLiberacao = etapaCriacaoGmudLiberacao;
	}
	public String getEtapaDesenvolvimento() {
		return etapaDesenvolvimento;
	}
	public void setEtapaDesenvolvimento(String etapaDesenvolvimento) {
		this.etapaDesenvolvimento = etapaDesenvolvimento;
	}
	public String getEtapaTesteIntegrado() {
		return etapaTesteIntegrado;
	}
	public void setEtapaTesteIntegrado(String etapaTesteIntegrado) {
		this.etapaTesteIntegrado = etapaTesteIntegrado;
	}
	public String getEtapaAcompanhamentoUAT() {
		return etapaAcompanhamentoUAT;
	}
	public void setEtapaAcompanhamentoUAT(String etapaAcompanhamentoUAT) {
		this.etapaAcompanhamentoUAT = etapaAcompanhamentoUAT;
	}
	public String getEtapaPreparoImplantcao() {
		return etapaPreparoImplantcao;
	}
	public void setEtapaPreparoImplantcao(String etapaPreparoImplantcao) {
		this.etapaPreparoImplantcao = etapaPreparoImplantcao;
	}
	public String getEtapaPosRelease() {
		return etapaPosRelease;
	}
	public void setEtapaPosRelease(String etapaPosRelease) {
		this.etapaPosRelease = etapaPosRelease;
	}
	public String getTotalHorasLpu() {
		return totalHorasLpu;
	}
	public void setTotalHorasLpu(String totalHorasLpu) {
		this.totalHorasLpu = totalHorasLpu;
	}
	public String getTotalHorasDecLpu() {
		return totalHorasDecLpu;
	}
	public void setTotalHorasDecLpu(String totalHorasDecLpu) {
		this.totalHorasDecLpu = totalHorasDecLpu;
	}
	
	public String getLpu_codigoFormatado() {
		lpu_codigoFormatado = String.format("LPU-%04d", getId());
		return lpu_codigoFormatado;
	}
	
	public void setLpu_codigoFormatado(String lpu_codigoFormatado) {
		this.lpu_codigoFormatado = lpu_codigoFormatado;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
