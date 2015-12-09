package br.unb.sae.vo;

import java.io.Serializable;

public class PerguntaVo implements Serializable {

	private static final long serialVersionUID = 2499910716298997993L;

	private Integer id;

	private String enunciado;

	private TipoRespostaVo tipoResposta;

	private CategoriaPerguntaVo categoria;

	private PerguntaVo perguntaRelacionada;

	private boolean ativa = true;
	
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



}
