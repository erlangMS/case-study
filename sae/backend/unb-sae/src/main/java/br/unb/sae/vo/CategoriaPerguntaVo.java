package br.unb.sae.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TB_Categoria")
public class CategoriaPerguntaVo {

	@Id
    @Column(name = "CatCodigo", nullable = false, insertable = true, updatable = true)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Column(name = "CatDenominacao", nullable = false, insertable = true, updatable = true, unique = true)
	private String denominacao;

	public CategoriaPerguntaVo() {
		super();
	}

	public CategoriaPerguntaVo(Integer id, String denominacao) {
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

	
}
