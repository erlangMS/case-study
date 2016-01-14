package br.unb.sae.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.erlangms.EmsUtil;
import br.erlangms.EmsValidationException;

@Entity
@Table(name="TB_Ocorrencia")
public class Ocorrencia {

	@Id
    @Column(name = "OcoCodigo", nullable = false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

    @Column(name="OcoCodigoAluno")
    private Integer aluno;

    @Column(name = "OcoPeriodo", nullable = false, length = 6)
    private String periodo;

    @Column(name = "OcoDataInicio", nullable = true)
    private Date dataInicio;

    @Column(name = "OcoDataFim", nullable = true)
    private Date dataFim;

    @Column(name = "OcoJustificativa", nullable = false)
    private String justificativa;

    @Column(name = "OcoSuspendeBolsaAlimentacao", nullable = false)
    private Boolean suspendeBolsaAlimentacao = true;

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
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

	public String getJustificativa() {
		return justificativa;
	}

	public void setJustificativa(String justificativa) {
		this.justificativa = justificativa;
	}

	public Integer getAluno() {
		return aluno;
	}

	public void setAluno(Integer aluno) {
		this.aluno = aluno;
	}

	public Boolean getSuspendeBolsaAlimentacao() {
		return suspendeBolsaAlimentacao;
	}

	public void setSuspendeBolsaAlimentacao(Boolean suspendeBolsaAlimentacao) {
		this.suspendeBolsaAlimentacao = suspendeBolsaAlimentacao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void validar(){
		EmsValidationException erro = new EmsValidationException();
		
		if (!EmsUtil.isFieldStrValid(getJustificativa())){
			erro.addError("Informe a justificativa da ocorrência.");
		}

		if (!EmsUtil.isFieldStrValid(getPeriodo())){
			erro.addError("Informe o período da ocorrência.");
		}
		
		if (!EmsUtil.isDateValid(getDataInicio())){
			erro.addError("Informe a data de início da ocorrência.");
		}

		if(!EmsUtil.isDateFinalAfterDateInitial(getDataInicio(), getDataFim()))  {
			erro.addError("Data fim deve ser maior que data início da ocorrência.");
		}

		if(erro.getErrors().size() > 0) {
			throw erro;
		}
		
	}
	
}
