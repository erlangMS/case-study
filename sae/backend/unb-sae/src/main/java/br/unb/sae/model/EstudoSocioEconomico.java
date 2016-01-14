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
@Table(name="EstudoSocioEconomicos")
public class EstudoSocioEconomico {

	@Id
    @Column(name = "ESECodigo", nullable = false, insertable = true, updatable = true)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Column(name = "ESEPeriodo", nullable = false, insertable = true, updatable = true, length = 5)
	private String periodo;

	@Column(name = "ESEDataHora", nullable = false, insertable = true, updatable = true)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataHora;

	@Column(name = "ESEPontuacaoCalculada", nullable = false, insertable = true, updatable = true)
	private double pontuacaoCalculada = 0.0;

	@Column(name = "ESEPontuacaoAtribuida", nullable = false, insertable = true, updatable = true)
	private double pontuacaoAtribuida = 0.0;

	@Column(name = "ESEPontuacaoFinal", nullable = false, insertable = true, updatable = true)
	private double pontuacaoFinal = 0.0;

	@Column(name = "ESEAluMatricula", nullable = false)
	private Integer aluno;

	@Column(name = "ESEClassificacaoCEU", nullable = true, insertable = true, updatable = true)
	private Integer classificacaoCEU = 1;

	@Column(name = "ESEParecerTecnico", nullable = true, insertable = true, updatable = true, length = 8000)
	private String parecer;

	@Column(name = "ESEPontuacaoParecer", nullable = true, insertable = true, updatable = true)
	private double pontuacaoParecer = 0.0;

	@Column(name = "ESEJustificativa", nullable = true, insertable = true, updatable = true, length = 8000)
	private String justificativa;

	@Column(name = "ESEQueCodigoQuestionario", nullable = false, insertable = true, updatable = true)
	private Integer questionario;

	@Column(name = "ESESituacao", nullable = false, insertable = true, updatable = true)
	private Integer situacao = 0;

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

	public double getPontuacaoCalculada() {
		return pontuacaoCalculada;
	}

	public void setPontuacaoCalculada(double pontuacaoCalculada) {
		this.pontuacaoCalculada = pontuacaoCalculada;
	}

	public double getPontuacaoAtribuida() {
		return pontuacaoAtribuida;
	}

	public void setPontuacaoAtribuida(double pontuacaoAtribuida) {
		this.pontuacaoAtribuida = pontuacaoAtribuida;
	}

	public double getPontuacaoFinal() {
		return pontuacaoFinal;
	}

	public void setPontuacaoFinal(double pontuacaoFinal) {
		this.pontuacaoFinal = pontuacaoFinal;
	}

	public Integer getAluno() {
		return aluno;
	}

	public void setAluno(Integer aluno) {
		this.aluno = aluno;
	}

	public Integer getClassificacaoCEU() {
		return classificacaoCEU;
	}

	public void setClassificacaoCEU(Integer classificacaoCEU) {
		this.classificacaoCEU = classificacaoCEU;
	}

	public String getParecer() {
		return parecer;
	}

	public void setParecer(String parecer) {
		this.parecer = parecer;
	}

	public double getPontuacaoParecer() {
		return pontuacaoParecer;
	}

	public void setPontuacaoParecer(double pontuacaoParecer) {
		this.pontuacaoParecer = pontuacaoParecer;
	}

	public String getJustificativa() {
		return justificativa;
	}

	public void setJustificativa(String justificativa) {
		this.justificativa = justificativa;
	}

	public Integer getQuestionario() {
		return questionario;
	}

	public void setQuestionario(Integer questionario) {
		this.questionario = questionario;
	}

	public Integer getSituacao() {
		return situacao;
	}

	public void setSituacao(Integer situacao) {
		this.situacao = situacao;
	}

	public void validar() {
		EmsValidationException erro = new EmsValidationException();

		if (!EmsUtil.isFieldStrValid(getPeriodo(), 5)) {
			erro.addError("Informe um período válido.");
		}

		if (!EmsUtil.isDateValid(getDataHora())) {
			erro.addError("Informe uma data e hora.");
		}
		
		if (!EmsUtil.isFieldObjectValid(getQuestionario())) {
			erro.addError("Informe o questionário.");
		}

		if (!EmsUtil.isFieldObjectValid(getAluno())) {
			erro.addError("Informe o aluno.");
		}

		if (!EmsUtil.isFieldObjectValid(getSituacao())) {
			erro.addError("Informe a situação.");
		}

		if (erro.getErrors().size() > 0) {
			throw erro;
		}
	}

	public RespostaEstudoSocioEconomico registraResposta(RespostaEstudoSocioEconomico resposta) {
		resposta.validar();
		resposta.setEstudo(this);
		return SaeInfra.getInstance()
			.getEstudoPreliminarRepository()
			.insertOrUpdate(resposta);
	}

	public void removeResposta(int resposta) {
		SaeInfra.getInstance()
			.getEstudoPreliminarRepository()
			.delete(RespostaEstudoSocioEconomico.class, resposta);
	}

	public List<RespostaEstudoSocioEconomico> getRespostas() {
		int thisEstudo = this.getId();
		return SaeInfra.getInstance()
				.getEstudoPreliminarRepository()
				.getStreams(RespostaEstudoSocioEconomico.class)
				.where(c -> c.getEstudoSocioEconomico().getId() == thisEstudo).toList();
	}

	public RespostaEstudoSocioEconomico findResposta(Integer id) {
		return SaeInfra.getInstance().
				getEstudoPreliminarRepository().
				findById(RespostaEstudoSocioEconomico.class, id);
	}
	
}
