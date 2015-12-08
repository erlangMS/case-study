package br.unb.questionario.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.erlangms.EmsUtil;
import br.erlangms.EmsValidationException;

@Entity
@Table(name = "TB_Resposta")
public class RespostaPergunta {

	@Id
	@Column(name = "ResCodigo", nullable = false, insertable = true, updatable = true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "ResDescricao", nullable = false, insertable = true, updatable = true, unique = true)
	private String descricao;

	@ManyToOne(fetch = FetchType.EAGER, optional = false, targetEntity = Pergunta.class)
	@JoinColumn(name = "ResPerCodigoPergunta")
	private Pergunta pergunta;

	@Column(name = "ResValorResposta", nullable = false, insertable = true, updatable = true)
	private float valorResposta;

	public RespostaPergunta() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Pergunta getPergunta() {
		return pergunta;
	}

	public void setPergunta(Pergunta pergunta) {
		this.pergunta = pergunta;
	}

	public float getValorResposta() {
		return valorResposta;
	}

	public void setValorResposta(float valorResposta) {
		this.valorResposta = valorResposta;
	}

	public void validar() {
		EmsValidationException erro = new EmsValidationException();

		if (!EmsUtil.isFieldStrValid(getDescricao())) {
			erro.addError("Informe a descrição da resposta.");
		}

		if (!EmsUtil.isFieldObjectValid(getValorResposta())) {
			erro.addError("Informe o valor da resposta.");
		}

		if (!EmsUtil.isFieldObjectValid(getPergunta())) {
			erro.addError("Informe a pergunta a qual a resposta se destina.");
		}

		if (erro.getErrors().size() > 0) {
			throw erro;
		}
	}

}
