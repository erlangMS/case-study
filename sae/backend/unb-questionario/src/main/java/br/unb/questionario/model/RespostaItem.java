package br.unb.questionario.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.erlangms.EmsValidationException;

@Entity
@Table(name = "TB_ItemResposta")
public class RespostaItem {

	@Id
	@Column(name = "IReCodigo", nullable = false, insertable = true, updatable = true)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "IReResCodigoOpcao", nullable = true, insertable = true, updatable = true)
	private Integer opcao;
	
	@Column(name = "IReResDescricao", nullable = true, insertable = true, updatable = true)
	private String descricao;
	
	@Column(name = "IReResCodigoResposta", nullable = false, insertable = true, updatable = true)
	private Integer resposta;
	
	@Column(name = "IRePerCodigoPergunta", nullable = false, insertable = true, updatable = true)
	private Integer pergunta;
	

	public RespostaItem() {
		super();
	}

	

	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}




	public Integer getOpcao() {
		return opcao;
	}



	public void setOpcao(Integer opcao) {
		this.opcao = opcao;
	}



	public String getDescricao() {
		return descricao;
	}



	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}



	public void validar() {
		EmsValidationException erro = new EmsValidationException();

		if (erro.getErrors().size() > 0) {
			throw erro;
		}
	}



	public Integer getPergunta() {
		return pergunta;
	}



	public void setPergunta(Integer pergunta) {
		this.pergunta = pergunta;
	}



	public Integer getResposta() {
		return resposta;
	}



	public void setResposta(Integer resposta) {
		this.resposta = resposta;
	}







}
