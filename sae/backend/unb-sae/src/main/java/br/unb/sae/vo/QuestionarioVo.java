package br.unb.sae.vo;

import java.io.Serializable;
import java.util.Date;

public class QuestionarioVo implements Serializable {

	private static final long serialVersionUID = 5515922866139266680L;

	private Integer id;

	private String denominacao;
	
	private Date dataInicio;

	private Date dataFim;

	private TipoQuestionarioVo tipoQuestionario;
	
	public QuestionarioVo() {
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


	public Date getDataInicio() {
		return dataInicio;
	}


	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}


	public Date getDataFim() {
		return dataFim;
	}


	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}


	public TipoQuestionarioVo getTipoQuestionario() {
		return tipoQuestionario;
	}


	public void setTipoQuestionario(TipoQuestionarioVo tipoQuestionario) {
		this.tipoQuestionario = tipoQuestionario;
	}


	
}
