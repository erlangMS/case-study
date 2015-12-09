package br.unb.sae.vo;


public class RespostaPerguntaVo {

	private Integer id;

	private String descricao;

	private PerguntaVo pergunta;

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
