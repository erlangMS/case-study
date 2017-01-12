package br.unb.questionario.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import br.erlangms.EmsUtil;
import br.erlangms.EmsValidationException;

@Entity
@Table(name = "TB_Resposta",
	uniqueConstraints = {@UniqueConstraint(columnNames={"ResPerCodigoPergunta", "ResValorResposta"})}
)
public class RespostaPergunta {

	@Id
	@Column(name = "ResCodigo", nullable = false, insertable = true, updatable = true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "ResDescricao", nullable = false, insertable = true, updatable = true)
	private String descricao;

	@Column(name = "ResPerCodigoPergunta", nullable = false, insertable = true, updatable = true)
	private Integer pergunta;

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

	public Integer getPergunta() {
		return pergunta;
	}

	public void setPergunta(Integer
			pergunta) {
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

		if (getPergunta() == null || (getPergunta() != null && getPergunta() == 0)) {
			erro.addError("Informe a pergunta a qual a resposta se destina.");
		}

		if (erro.getErrors().size() > 0) {
			throw erro;
		}
	}

}
