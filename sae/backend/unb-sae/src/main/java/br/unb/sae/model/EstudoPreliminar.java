package br.unb.sae.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.erlangms.EmsUtil;
import br.erlangms.EmsValidationException;
import br.unb.sae.infra.SaeInfra;
import br.unb.sae.vo.QuestionarioVo;

@Entity
@Table(name = "TB_EstudoPreliminar")
public class EstudoPreliminar implements Serializable {

	private static final long serialVersionUID = -4121261049751377228L;

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

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "EPrAluMatricula")
	private AlunoSae aluno;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "EPrQueCodigoQuestionario")
	private QuestionarioVo questinario;

	public EstudoPreliminar() {
		super();
	}

	public EstudoPreliminar(Integer id, String periodo, Date dataHora, double pontuacaoPreliminar, AlunoSae aluno, QuestionarioVo questinario) {
		super();
		this.id = id;
		this.periodo = periodo;
		this.dataHora = dataHora;
		this.pontuacaoPreliminar = pontuacaoPreliminar;
		this.aluno = aluno;
		this.questinario = questinario;
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

	public AlunoSae getAluno() {
		return aluno;
	}

	public void setAluno(AlunoSae aluno) {
		this.aluno = aluno;
	}

	public QuestionarioVo getQuestinario() {
		return questinario;
	}

	public void setQuestinario(QuestionarioVo questinario) {
		this.questinario = questinario;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aluno == null) ? 0 : aluno.hashCode());
		result = prime * result + ((periodo == null) ? 0 : periodo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EstudoPreliminar other = (EstudoPreliminar) obj;
		if (aluno == null) {
			if (other.aluno != null)
				return false;
		} else if (!aluno.equals(other.aluno))
			return false;
		if (periodo == null) {
			if (other.periodo != null)
				return false;
		} else if (!periodo.equals(other.periodo))
			return false;
		return true;
	}

	public void validar() {
		EmsValidationException erro = new EmsValidationException();

		if (!EmsUtil.isFieldStrValid((getPeriodo()))) {
			erro.addError("Informe um período.");
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
		SaeInfra.getInstance().getEstudoPreliminarRepository().insertOrUpdate(resposta);

	}

	public void removeResposta(int resposta) {
		SaeInfra.getInstance().getEstudoPreliminarRepository().delete(RespostaEstudoPreliminar.class, resposta);
	}

	public List<RespostaEstudoPreliminar> getRespostas() {
		int thisEstudo = this.getId();
		return SaeInfra.getInstance().getEstudoPreliminarRepository().getStreams(RespostaEstudoPreliminar.class)
				.where(c -> c.getEstudoPreliminar().getId() == thisEstudo).toList();
	}

	public RespostaEstudoPreliminar findResposta(Integer id) {
		return SaeInfra.getInstance().getEstudoPreliminarRepository().findById(RespostaEstudoPreliminar.class, id);
	}

}