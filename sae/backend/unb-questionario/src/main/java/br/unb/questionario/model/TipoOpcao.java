package br.unb.questionario.model;

public enum TipoOpcao {
	Entrada(0),
	RespostaQuestionario(1),
	Servico(2),
	Sitab(3);
		
	private int codigo;
	private String denominacao;
	
	TipoOpcao(int codigo) {
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
