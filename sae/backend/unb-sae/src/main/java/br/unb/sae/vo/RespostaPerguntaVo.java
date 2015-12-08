package br.unb.sae.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TB_Resposta")
public class RespostaPerguntaVo {

	@Id
	@Column(name = "ResCodigo", nullable = false, insertable = true, updatable = true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "ResDescricao", nullable = false, insertable = true, updatable = true, unique = true)
	private String descricao;

	@ManyToOne(fetch = FetchType.EAGER, optional = false, targetEntity = PerguntaVo.class)
	@JoinColumn(name = "ResPerCodigoPergunta")
	private PerguntaVo pergunta;

	@Column(name = "ResValorResposta", nullable = false, insertable = true, updatable = true)
	private float valorResposta;

	public RespostaPerguntaVo() {
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

	public PerguntaVo getPergunta() {
		return pergunta;
	}

	public void setPergunta(PerguntaVo pergunta) {
		this.pergunta = pergunta;
	}

	public float getValorResposta() {
		return valorResposta;
	}

	public void setValorResposta(float valorResposta) {
		this.valorResposta = valorResposta;
	}


}
