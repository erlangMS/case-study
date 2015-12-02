package br.unb.questionario.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.erlangms.EmsValidationException;
import br.unb.questionario.infra.extension.ValidateFields;

@Entity
@Table(name="Pergunta")
public class Pergunta implements Serializable {

	private static final long serialVersionUID = 2499910716298997993L;

	public enum TipoResposta {
		MultiplaEscolha, 
		Subjetiva, 
		EscolhaUma;
	}
	
	@Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Column(name = "denominacao", nullable = false, insertable = true, updatable = true, unique = true)
	private String denominacao;
	
	@Column(name = "tipoResposta", nullable = false, insertable = true, updatable = true)
	private TipoResposta tipoResposta;

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="categoria_Id")
    private CategoriaPergunta categoria;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDenominacao() {
		return denominacao;
	}

	public void setDenominacao(String denominacao) {
		this.denominacao = denominacao;
	}

	public TipoResposta getTipoResposta() {
		return tipoResposta;
	}

	public void setTipoResposta(TipoResposta tipoResposta) {
		this.tipoResposta = tipoResposta;
	}

	public CategoriaPergunta getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaPergunta categoria) {
		this.categoria = categoria;
	}

	public void validar() {
		EmsValidationException erro = new EmsValidationException();
		
		if (!ValidateFields.isFieldObjectValid(getCategoria())){
			erro.addError("Informe a categoria da pergunta.");
		}

		if (!ValidateFields.isFieldStrValid(getDenominacao())){
			erro.addError("Informe a denominação.");
		}
		
		if(!ValidateFields.isFieldObjectValid(getTipoResposta())) {
			erro.addError("Informe o tipo de resposta.");
		}

		if(erro.getErrors().size() > 0) {
			throw erro;
		}
	}


	
}
