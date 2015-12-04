package br.unb.questionario.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.erlangms.EmsUtil;
import br.erlangms.EmsValidationException;

@Entity
@Table(name="RespostaPergunta")
public class RespostaPergunta {

	@Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Column(name = "descricao", nullable = false, insertable = true, updatable = true, unique = true)
	private String descricao;

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="pergunta_Id")
    private Pergunta pergunta;

	@Column(name = "valor_resposta", nullable = false, insertable = true, updatable = true)
	private Long valorResposta;
    	
	
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

	public Long getValorResposta() {
		return valorResposta;
	}

	public void setValorResposta(Long valorResposta) {
		this.valorResposta = valorResposta;
	}

	public void validar() {
		EmsValidationException erro = new EmsValidationException();
		
		if (!EmsUtil.isFieldStrValid(getDescricao())){
			erro.addError("Informe a descrição da resposta.");
		}

		if (!EmsUtil.isFieldObjectValid(getValorResposta())){
			erro.addError("Informe o valor da resposta.");
		}

		if (!EmsUtil.isFieldObjectValid(getPergunta())){
			erro.addError("Informe a pergunta a qual a resposta se destina.");
		}

		if(erro.getErrors().size() > 0) {
			throw erro;
		}
	}

	
}
