package br.com.everis.lpu.modelo;

public enum Topico {
	
	ALTERACAO_FLUXO_MENU("Alteração de Fluxo - Menu"),
	ALTERACAO_FLUXO_TRIAGEM("Alteração de Fluxo = Triagem"),
	ALTERACAO_FLUXO_BOLHA_INFORMACIONAL("Alteração de Fluxo - Bolha ou Informacional"),
	NOVO_FLUXO_TRIAGEM("Novo Fluxo - Triagem"),
	NOVO_FLUXO_MENU("Novo Fluxo - Menu"),
	NOVO_FLUXO_BOLHA_INFORMACIONAL("Novo Fluxo - Bolha ou Informacional"),
	EXCLUSAO_FLUXO_TRIAGEM("Exclusão de Fluxo - Triagem"),
	EXCLUSAO_FLUXO_MENU("Exclusão de Fluxo - Menu"),
	EXCLUSAO_FLUXO_BOLHA_INFORMACIONAL("Exclusão de Fluxo - Bolha ou Informacional"),
	CADASTRO_TEMPLATE_PROMOCOES("Cadastro de Template de Promoções"),
	ROTEAMENTO("Roteamento"),
	INTEGRACOES("Integrações");
	
	public String topico;
	
	Topico(String valor) {
		topico = valor;
	}
	
	public String getTopico() {
		return topico;
	}
}
