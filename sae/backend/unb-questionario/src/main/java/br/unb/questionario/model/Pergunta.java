package br.unb.questionario.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import br.erlangms.EmsUtil;
import br.erlangms.EmsValidationException;
import br.unb.questionario.infra.QuestionarioInfra;

@Entity
@Table(name = "TB_Pergunta",
	uniqueConstraints = {@UniqueConstraint(columnNames={"PerCatCodigoCategoria", "PerEnunciado"})}
)
public class Pergunta implements Serializable {

	private static final long serialVersionUID = 2499910716298997993L;

	@Id
	@Column(name = "PerCodigo", nullable = false, insertable = true, updatable = true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "PerEnunciado", nullable = false, insertable = true, updatable = true, unique = true)
	private String enunciado;

	@Column(name = "PerTipoResposta", nullable = false, insertable = true, updatable = true)
	private Integer tipoResposta;

	@Column(name = "PerCatCodigoCategoria", nullable = false, insertable = true, updatable = true)
	private Integer categoria;

	@Column(name = "PerCodigoPerguntaRelacionada", nullable = true, insertable = true, updatable = true)
	private Integer perguntaRelacionada;
	
	@Column(name = "PerAtiva")
	private boolean ativa = true;

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

	public Integer getTipoResposta() {
		return tipoResposta;
	}

	public void setTipoResposta(Integer tipoResposta) {
		this.tipoResposta = tipoResposta;
	}

	public Integer getCategoria() {
		return categoria;
	}

	public void setCategoria(Integer categoria) {
		this.categoria = categoria;
	}

	public Integer getPerguntaRelacionada() {
		return perguntaRelacionada;
	}

	public void setPerguntaRelacionada(Integer perguntaRelacionada) {
		this.perguntaRelacionada = perguntaRelacionada;
	}

	public boolean isAtiva() {
		return ativa;
	}

	public void setAtiva(boolean ativa) {
		this.ativa = ativa;
	}

	public void validar() {
		EmsValidationException erro = new EmsValidationException();

		/*if (!EmsUtil.isFieldObjectValid(getCategoria())) {
			erro.addError("Informe a categoria da pergunta.");
		}*/

		if (!EmsUtil.isFieldStrValid(getEnunciado())) {
			erro.addError("Informe a denominação.");
		}

		/*if (!EmsUtil.isFieldObjectValid(getTipoResposta())) {
			erro.addError("Informe o tipo de resposta.");
		}*/

		if (erro.getErrors().size() > 0) {
			throw erro;
		}
	}

	public RespostaPergunta registraResposta(RespostaPergunta resposta) {
		resposta.setPergunta(this.id);
		resposta.validar();
		return QuestionarioInfra.getInstance()
			.getPerguntaRepository()
			.insertOrUpdate(resposta);
	}

	public void removeResposta(int idResposta) {
		QuestionarioInfra.getInstance()
			.getPerguntaRepository()
			.delete(RespostaPergunta.class, idResposta);
	}

	public List<RespostaPergunta> getRespostas() {
		Pergunta thisPergunta = this;
		return QuestionarioInfra.getInstance()
			.getPerguntaRepository()
			.getStreams(RespostaPergunta.class)
			.where(p -> p.getPergunta().equals(thisPergunta)).toList();
	}

}
