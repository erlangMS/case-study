package br.unb.questionario.model;

public enum TipoResposta {

	MultiplaEscola(1),
	Subjetiva(2),
	EscolhaUma(3);
	
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
