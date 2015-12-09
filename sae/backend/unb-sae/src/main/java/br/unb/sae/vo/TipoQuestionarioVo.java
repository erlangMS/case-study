package br.unb.sae.vo;


public class TipoQuestionarioVo {

	private Integer id;

	private String denominacao;

	private boolean extinto = false;
	
	public TipoQuestionarioVo() {
		super();
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

	public boolean isExtinto() {
		return extinto;
	}

	public void setExtinto(boolean extinto) {
		this.extinto = extinto;
	}

	
}
