package br.unb.web.sae.pojo;


import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Construtor")
public class Construtor implements Serializable {

	private static final long serialVersionUID = -4511159885901755257L;

	@Id
    @Column(name = "Codigo", nullable = false, insertable = true, updatable = true, length = 40)
	private String codigoStr;

    @Basic
    @Column(name = "Titulo", nullable = false, insertable = true, updatable = true, length = 60)
    private String titulo;

    @Basic
    @Column(name = "Visao", nullable = false, insertable = true, updatable = true, length = 50)
    private String visao;

    @Basic
    @Column(name = "Definicao", nullable = false, insertable = true, updatable = true)
    private String definicao;

    @Basic
    @Column(name = "Criacao", nullable = false, insertable = true, updatable = true)
    private Timestamp criacao;

    @Basic
    @Column(name = "Atualizacao", nullable = false, insertable = true, updatable = true)
    private Timestamp atualizacao;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Construtor that = (Construtor) o;

        if (codigoStr != null ? !codigoStr.equals(that.codigoStr) : that.codigoStr != null) return false;
        if (titulo != null ? !titulo.equals(that.titulo) : that.titulo != null) return false;
        if (visao != null ? !visao.equals(that.visao) : that.visao != null) return false;
        if (definicao != null ? !definicao.equals(that.definicao) : that.definicao != null) return false;
        if (criacao != null ? !criacao.equals(that.criacao) : that.criacao != null) return false;
        if (atualizacao != null ? !atualizacao.equals(that.atualizacao) : that.atualizacao != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = codigoStr != null ? codigoStr.hashCode() : 0;
        result = 31 * result + (titulo != null ? titulo.hashCode() : 0);
        result = 31 * result + (visao != null ? visao.hashCode() : 0);
        result = 31 * result + (definicao != null ? definicao.hashCode() : 0);
        result = 31 * result + (criacao != null ? criacao.hashCode() : 0);
        result = 31 * result + (atualizacao != null ? atualizacao.hashCode() : 0);
        return result;
    }

	public String getCodigoStr() {
		return codigoStr;
	}

	public void setCodigoStr(String codigo) {
		this.codigoStr = codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getVisao() {
		return visao;
	}

	public void setVisao(String visao) {
		this.visao = visao;
	}

	public String getDefinicao() {
		return definicao;
	}

	public void setDefinicao(String definicao) {
		this.definicao = definicao;
	}

	public Timestamp getCriacao() {
		return criacao;
	}

	public void setCriacao(Timestamp criacao) {
		this.criacao = criacao;
	}

	public Timestamp getAtualizacao() {
		return atualizacao;
	}

	public void setAtualizacao(Timestamp atualizacao) {
		this.atualizacao = atualizacao;
	}
    
    
    
}
