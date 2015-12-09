package br.unb.sae.vo;


public class CategoriaPerguntaVo {

	private Integer id;

	private String denominacao;

	public CategoriaPerguntaVo() {
		super();
	}

	public CategoriaPerguntaVo(Integer id, String denominacao) {
		super();
		this.id = id;
		this.denominacao = denominacao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDenominacao() {
		return denominacao;
	}

	public void setDenominacao(String denominacao) {
		this.denominacao = denominacao;
	}

	
}
