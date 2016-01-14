package br.unb.sae.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.erlangms.EmsUtil;
import br.erlangms.EmsValidationException;
import br.unb.sae.infra.SaeInfra;

@Entity
@Table(name = "TB_EstudoPreliminar")
public class EstudoPreliminar {

	@Id
	@Column(name = "EPrCodigo", nullable = false, insertable = true, updatable = true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "EPrPeriodo", nullable = false, insertable = true, updatable = true, length = 5)
	private String periodo;

	@Column(name = "EPrDataHora", nullable = false, insertable = true, updatable = true, length = 8)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataHora;

	@Column(name = "EPrPontuacaoPreliminar", nullable = false, insertable = true, updatable = true)
	private double pontuacaoPreliminar = 0.0;

	@Column(name = "EPrAluMatricula")
	private Integer aluno;

	@Column(name = "EPrQueCodigoQuestionario", nullable = false, insertable = true, updatable = true)
	private Integer questionario;

	public EstudoPreliminar() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}

	public double getPontuacaoPreliminar() {
		return pontuacaoPreliminar;
	}

	public void setPontuacaoPreliminar(double pontuacaoPreliminar) {
		this.pontuacaoPreliminar = pontuacaoPreliminar;
	}

	public Integer getAluno() {
		return aluno;
	}

	public void setAluno(Integer aluno) {
		this.aluno = aluno;
	}

	public Integer getQuestionario() {
		return questionario;
	}

	public void setQuestionario(Integer questionario) {
		this.questionario = questionario;
	}

	public void validar() {
		EmsValidationException erro = new EmsValidationException();

		if (!EmsUtil.isFieldStrValid(getPeriodo(), 5)) {
			erro.addError("Informe um período válido.");
		}

		if (!EmsUtil.isDateValid(getDataHora())) {
			erro.addError("Informe uma data e hora.");
		}
		

		if (erro.getErrors().size() > 0) {
			throw erro;
		}

	}

	public void registraResposta(RespostaEstudoPreliminar resposta) {
		resposta.validar();
		resposta.setEstudoPreliminar(this);
		SaeInfra.getInstance()
			.getEstudoPreliminarRepository()
			.insertOrUpdate(resposta);
	}

	public void removeResposta(int resposta) {
		SaeInfra.getInstance()
			.getEstudoPreliminarRepository()
			.delete(RespostaEstudoPreliminar.class, resposta);
	}

	public List<RespostaEstudoPreliminar> getRespostas() {
		int thisEstudo = this.getId();
		return SaeInfra.getInstance()
				.getEstudoPreliminarRepository()
				.getStreams(RespostaEstudoPreliminar.class)
				.where(c -> c.getEstudoPreliminar().getId() == thisEstudo).toList();
	}

	public RespostaEstudoPreliminar findResposta(Integer id) {
		return SaeInfra.getInstance().getEstudoPreliminarRepository().findById(RespostaEstudoPreliminar.class, id);
	}

}