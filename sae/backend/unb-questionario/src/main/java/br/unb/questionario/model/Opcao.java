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
@Table(name = "TB_Opcao",
	uniqueConstraints = {@UniqueConstraint(columnNames={"OpcPerCodigoPergunta", "OpcValorResposta"})}
)
public class Opcao {

	@Id
	@Column(name = "OpcCodigo", nullable = false, insertable = true, updatable = true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "OpcDescricao", nullable = false, insertable = true, updatable = true)
	private String descricao;

	@Column(name = "OpcPerCodigoPergunta", nullable = false, insertable = true, updatable = true)
	private Integer pergunta;

	@Column(name = "OpcValorResposta", nullable = false, insertable = true, updatable = true)
	private float valorResposta;
	
	@Column(name = "OpcAtiva", nullable = true, insertable = true, updatable = true)
	private boolean ativa = true;

	public Opcao() {
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
			erro.addError("Informe a descrição da opção.");
		}

		if (!EmsUtil.isFieldObjectValid(getValorResposta())) {
			erro.addError("Informe o valor da opção.");
		}

		if (getPergunta() == null || (getPergunta() != null && getPergunta() == 0)) {
			erro.addError("Informe a pergunta a qual a opção se destina.");
		}

		if (erro.getErrors().size() > 0) {
			throw erro;
		}
	}

	public boolean isAtiva() {
		return ativa;
	}

	public void setAtiva(boolean ativa) {
		this.ativa = ativa;
	}

}
