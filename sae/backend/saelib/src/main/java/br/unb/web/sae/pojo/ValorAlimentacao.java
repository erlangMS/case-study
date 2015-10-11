package br.unb.web.sae.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="ValorAlimentacao")
public class ValorAlimentacao implements Serializable {

	private static final long serialVersionUID = -1690297538495635030L;

	@Id
    @Column(name = "IdValorAlimetacao", nullable = false, insertable = true, updatable = true)
	private Integer id;

    @Basic
    @Column(name = "Campus", nullable = false, insertable = true, updatable = true)
    private Integer campus;

    @Basic
    @Column(name = "InicioVigencia", nullable = false, insertable = true, updatable = true)
    private Timestamp inicioVigencia;

    @Basic
    @Column(name = "FimVigencia", nullable = true, insertable = true, updatable = true)
    private Timestamp fimVigencia;

    @Basic
    @Column(name = "PagaBeneficio", nullable = false, insertable = true, updatable = true)
    private Boolean pagaBeneficio;

    @Basic
    @Column(name = "GeraArquivoRU", nullable = false, insertable = true, updatable = true)
    private Boolean geraArquivoRu;

    @Basic
    @Column(name = "ValorBeneficio", nullable = false, insertable = true, updatable = true, precision = 2)
    private BigDecimal valorBeneficio;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ValorAlimentacao that = (ValorAlimentacao) o;

        if (id != null ? !id.equals(that.id) : that.id != null)
            return false;
        if (campus != null ? !campus.equals(that.campus) : that.campus != null) return false;
        if (inicioVigencia != null ? !inicioVigencia.equals(that.inicioVigencia) : that.inicioVigencia != null)
            return false;
        if (fimVigencia != null ? !fimVigencia.equals(that.fimVigencia) : that.fimVigencia != null) return false;
        if (pagaBeneficio != null ? !pagaBeneficio.equals(that.pagaBeneficio) : that.pagaBeneficio != null)
            return false;
        if (geraArquivoRu != null ? !geraArquivoRu.equals(that.geraArquivoRu) : that.geraArquivoRu != null)
            return false;
        if (valorBeneficio != null ? !valorBeneficio.equals(that.valorBeneficio) : that.valorBeneficio != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (campus != null ? campus.hashCode() : 0);
        result = 31 * result + (inicioVigencia != null ? inicioVigencia.hashCode() : 0);
        result = 31 * result + (fimVigencia != null ? fimVigencia.hashCode() : 0);
        result = 31 * result + (pagaBeneficio != null ? pagaBeneficio.hashCode() : 0);
        result = 31 * result + (geraArquivoRu != null ? geraArquivoRu.hashCode() : 0);
        result = 31 * result + (valorBeneficio != null ? valorBeneficio.hashCode() : 0);
        return result;
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer idValorAlimetacao) {
		this.id = idValorAlimetacao;
	}

	public Integer getCampus() {
		return campus;
	}

	public void setCampus(Integer campus) {
		this.campus = campus;
	}

	public Timestamp getInicioVigencia() {
		return inicioVigencia;
	}

	public void setInicioVigencia(Timestamp inicioVigencia) {
		this.inicioVigencia = inicioVigencia;
	}

	public Timestamp getFimVigencia() {
		return fimVigencia;
	}

	public void setFimVigencia(Timestamp fimVigencia) {
		this.fimVigencia = fimVigencia;
	}

	public Boolean getPagaBeneficio() {
		return pagaBeneficio;
	} 	

	public void setPagaBeneficio(Boolean pagaBeneficio) {
		this.pagaBeneficio = pagaBeneficio;
	}

	public Boolean getGeraArquivoRu() {
		return geraArquivoRu;
	}

	public void setGeraArquivoRu(Boolean geraArquivoRu) {
		this.geraArquivoRu = geraArquivoRu;
	}

	public BigDecimal getValorBeneficio() {
		return valorBeneficio;
	}

	public void setValorBeneficio(BigDecimal valorBeneficio) {
		this.valorBeneficio = valorBeneficio;
	}
    
    
}