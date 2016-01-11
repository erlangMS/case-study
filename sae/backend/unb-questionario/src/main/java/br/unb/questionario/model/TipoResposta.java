package br.unb.questionario.model;

public enum TipoResposta {

	MultiplaEscola(0),
	Subjetiva(1),
	EscolhaUma(2);
	
	private int codigo;
	private String denominacao;
	
	TipoResposta(int codigo) {
		this.codigo = codigo;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDenominacao() {
		return denominacao;
	}

	public void setDenominacao(String denominacao) {
		this.denominacao = denominacao;
	}
	
}
