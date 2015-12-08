package br.unb.questionario.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.erlangms.EmsValidationException;
import br.unb.questionario.infra.QuestionarioInfra;
import br.unb.questionario.infra.extension.ValidateFields;

@Entity
@Table(name = "TB_Pergunta")
public class Pergunta implements Serializable {

	private static final long serialVersionUID = 2499910716298997993L;

	@Id
	@Column(name = "PerCodigo", nullable = false, insertable = true, updatable = true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "PerEnunciado", nullable = false, insertable = true, updatable = true, unique = true)
	private String enunciado;

	@Column(name = "PerTipoResposta", nullable = false, insertable = true, updatable = true)
	private TipoResposta tipoResposta;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PerCatCodigoCategoria")
	private CategoriaPergunta categoria;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = true, targetEntity = Pergunta.class)
	@JoinColumn(name = "PerCodigoPerguntaRelacionada")
	private Pergunta perguntaRelacionada;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = false, mappedBy = "pergunta", targetEntity = RespostaPergunta.class)
	private List<RespostaPergunta> respostas;
	
	@Column(name = "PerAtiva")
	private boolean ativa = true;

	@Transient
	@OneToMany(mappedBy = "perguntas", orphanRemoval = true)
	private Questionario questionario;
	
	public Pergunta() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public TipoResposta getTipoResposta() {
		return tipoResposta;
	}

	public void setTipoResposta(TipoResposta tipoResposta) {
		this.tipoResposta = tipoResposta;
	}

	public CategoriaPergunta getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaPergunta categoria) {
		this.categoria = categoria;
	}

	public Pergunta getPerguntaRelacionada() {
		return perguntaRelacionada;
	}

	public void setPerguntaRelacionada(Pergunta perguntaRelacionada) {
		this.perguntaRelacionada = perguntaRelacionada;
	}

	public boolean isAtiva() {
		return ativa;
	}

	public void setAtiva(boolean ativa) {
		this.ativa = ativa;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Questionario getQuestionario() {
		return questionario;
	}

	public void setQuestionario(Questionario questionario) {
		this.questionario = questionario;
	}

	public void setRespostas(List<RespostaPergunta> respostas) {
		this.respostas = respostas;
	}

	public void validar() {
		EmsValidationException erro = new EmsValidationException();

		if (!ValidateFields.isFieldObjectValid(getCategoria())) {
			erro.addError("Informe a categoria da pergunta.");
		}

		if (!ValidateFields.isFieldStrValid(getEnunciado())) {
			erro.addError("Informe a denominação.");
		}

		if (!ValidateFields.isFieldObjectValid(getTipoResposta())) {
			erro.addError("Informe o tipo de resposta.");
		}

		if (erro.getErrors().size() > 0) {
			throw erro;
		}
	}

	public void registraResposta(RespostaPergunta resposta) {
		resposta.setPergunta(this);
		resposta.validar();
		QuestionarioInfra.getInstance().getPerguntaRepository().insertOrUpdate(resposta);
	}

	public void removeResposta(int idResposta) {
		QuestionarioInfra.getInstance().getPerguntaRepository().delete(RespostaPergunta.class, idResposta);
	}

	public List<RespostaPergunta> getRespostas() {
		Pergunta thisPergunta = this;
		return QuestionarioInfra.getInstance().getPerguntaRepository().getStreams(RespostaPergunta.class)
				.where(p -> p.getPergunta().equals(thisPergunta)).toList();
	}

}
