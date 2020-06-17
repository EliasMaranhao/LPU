package br.com.everis.lpu.modelo;

public enum StatusDemanda {
	
	ABERTO("Aberto"), 
	EM_DESENVOLVIMENTO("Em desenvolvimento"),
	EM_TESTE_UNITARIO("Em teste unitário"),
	EM_TESTE_INTEGRADO("Em teste integrado"),
	EM_UAT("Em teste UAT"),
	FECHADO("Fechado"), 
	CANCELADO("Cancelado"), 
	AGUARDANDO_CLIENTE("Aguardando cliente"),
	AGUARDANDO_TERCEIRO("Aguardando terceiro");
	
	private String status;
	
	StatusDemanda(String status){
		this.status = status;
	}
	
	public String getStatus() {
		return this.status;
	}
}
