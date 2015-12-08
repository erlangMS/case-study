package br.unb.sae.vo;

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

@Entity
@Table(name = "TB_Pergunta")
public class PerguntaVo implements Serializable {

	private static final long serialVersionUID = 2499910716298997993L;

	@Id
	@Column(name = "PerCodigo", nullable = false, insertable = true, updatable = true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "PerEnunciado", nullable = false, insertable = true, updatable = true, unique = true)
	private String enunciado;

	@Column(name = "PerTipoResposta", nullable = false, insertable = true, updatable = true)
	private TipoRespostaVo tipoResposta;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PerCatCodigoCategoria")
	private CategoriaPerguntaVo categoria;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = true, targetEntity = PerguntaVo.class)
	@JoinColumn(name = "PerCodigoPerguntaRelacionada")
	private PerguntaVo perguntaRelacionada;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = false, mappedBy = "pergunta", targetEntity = RespostaPerguntaVo.class)
	private List<RespostaPerguntaVo> respostas;
	
	@Column(name = "PerAtiva")
	private boolean ativa = true;

	@Transient
	@OneToMany(mappedBy = "perguntas", orphanRemoval = true)
	private QuestionarioVo questionario;
	
	public PerguntaVo() {
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

	public TipoRespostaVo getTipoResposta() {
		return tipoResposta;
	}

	public void setTipoResposta(TipoRespostaVo tipoResposta) {
		this.tipoResposta = tipoResposta;
	}

	public CategoriaPerguntaVo getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaPerguntaVo categoria) {
		this.categoria = categoria;
	}

	public PerguntaVo getPerguntaRelacionada() {
		return perguntaRelacionada;
	}

	public void setPerguntaRelacionada(PerguntaVo perguntaRelacionada) {
		this.perguntaRelacionada = perguntaRelacionada;
	}

	public boolean isAtiva() {
		return ativa;
	}

	public void setAtiva(boolean ativa) {
		this.ativa = ativa;
	}

	public QuestionarioVo getQuestionario() {
		return questionario;
	}

	public void setQuestionario(QuestionarioVo questionario) {
		this.questionario = questionario;
	}

	public void setRespostas(List<RespostaPerguntaVo> respostas) {
		this.respostas = respostas;
	}


}
