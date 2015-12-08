package br.unb.questionario.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.erlangms.EmsValidationException;

@Entity
@Table(name="TB_Categoria")
public class CategoriaPergunta {

	@Id
    @Column(name = "CatCodigo", nullable = false, insertable = true, updatable = true)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Column(name = "CatDenominacao", nullable = false, insertable = true, updatable = true, unique = true)
	private String denominacao;

	public CategoriaPergunta() {
		super();
	}

	public CategoriaPergunta(Integer id, String denominacao) {
		super();
		this.id = id;
		this.denominacao = denominacao;
	}

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

	public void validar() {
		EmsValidationException erro = new EmsValidationException();
		
		if (getDenominacao() == null || getDenominacao().isEmpty()){
			erro.addError("Informe a denominação.");
		}

		if(erro.getErrors().size() > 0) {
			throw erro;
		}
	}

	
}
