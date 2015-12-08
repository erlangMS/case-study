package br.unb.sae.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TB_TipoQuestinario")
public class TipoQuestionarioVo {

	@Id
    @Column(name = "TQuCodigo", nullable = false, insertable = true, updatable = true)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Column(name = "TQuDenominacao", nullable = false, insertable = true, updatable = true, unique = true)
	private String denominacao;

	@Column(name = "TQuExtinto", nullable = false, insertable = true, updatable = true)
	private boolean extinto = false;
	
	public TipoQuestionarioVo() {
		super();
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

	public boolean isExtinto() {
		return extinto;
	}

	public void setExtinto(boolean extinto) {
		this.extinto = extinto;
	}

	
}
