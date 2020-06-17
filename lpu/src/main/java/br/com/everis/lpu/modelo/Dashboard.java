package br.com.everis.lpu.modelo;

import java.io.Serializable;
import java.math.BigDecimal;

public class Dashboard implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Demanda demada;
	private Topico topico;
	private BigDecimal bigDecimal;
	private String versaoFluxo;
	private String horaSistema;
	
	public Demanda getDemada() {
		return demada;
	}
	public void setDemada(Demanda demada) {
		this.demada = demada;
	}
	public Topico getTopico() {
		return topico;
	}
	public void setTopico(Topico topico) {
		this.topico = topico;
	}
	public BigDecimal getBigDecimal() {
		return bigDecimal;
	}
	public void setBigDecimal(BigDecimal bigDecimal) {
		this.bigDecimal = bigDecimal;
	}
	public String getVersaoFluxo() {
		return versaoFluxo;
	}
	public void setVersaoFluxo(String versaoFluxo) {
		this.versaoFluxo = versaoFluxo;
	}
	public String getHoraSistema() {
		return horaSistema;
	}
	public void setHoraSistema(String horaSistema) {
		this.horaSistema = horaSistema;
	}
	
}
