package br.unb.questionario.model;

public enum TipoResposta {
	EscolhaUma(0),
	MultiplaEscolha(1),
	Subjetiva(2),
	Texto(3),
	Combo(4),
	Data(5);
	
	
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
