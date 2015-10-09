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
@Table(name="Parametros")
public class Parametros implements Serializable {
	private static final long serialVersionUID = -5779852635937996382L;

	@Id
    @Column(name = "Data", nullable = false, insertable = true, updatable = true)
	private Timestamp data;

    @Basic
    @Column(name = "RendaMensalMedia", nullable = false, insertable = true, updatable = true, precision = 4)
    private BigDecimal rendaMensalMedia;

    @Basic
    @Column(name = "AteAno1", nullable = false, insertable = true, updatable = true)
    private Short ateAno1;

    @Basic
    @Column(name = "DeAno2", nullable = false, insertable = true, updatable = true)
    private Short deAno2;

    @Basic
    @Column(name = "AteAno2", nullable = false, insertable = true, updatable = true)
    private Short ateAno2;

    @Basic
    @Column(name = "DeAno3", nullable = false, insertable = true, updatable = true)
    private Short deAno3;

    @Basic
    @Column(name = "AteAno3", nullable = false, insertable = true, updatable = true)
    private Short ateAno3;

    @Basic
    @Column(name = "DeAno4", nullable = false, insertable = true, updatable = true)
    private Short deAno4;

    @Basic
    @Column(name = "ValorBolsaPos", nullable = false, insertable = true, updatable = true, precision = 4)
    private BigDecimal valorBolsaPos;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Parametros that = (Parametros) o;

        if (data != null ? !data.equals(that.data) : that.data != null) return false;
        if (rendaMensalMedia != null ? !rendaMensalMedia.equals(that.rendaMensalMedia) : that.rendaMensalMedia != null)
            return false;
        if (ateAno1 != null ? !ateAno1.equals(that.ateAno1) : that.ateAno1 != null) return false;
        if (deAno2 != null ? !deAno2.equals(that.deAno2) : that.deAno2 != null) return false;
        if (ateAno2 != null ? !ateAno2.equals(that.ateAno2) : that.ateAno2 != null) return false;
        if (deAno3 != null ? !deAno3.equals(that.deAno3) : that.deAno3 != null) return false;
        if (ateAno3 != null ? !ateAno3.equals(that.ateAno3) : that.ateAno3 != null) return false;
        if (deAno4 != null ? !deAno4.equals(that.deAno4) : that.deAno4 != null) return false;
        if (valorBolsaPos != null ? !valorBolsaPos.equals(that.valorBolsaPos) : that.valorBolsaPos != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = data != null ? data.hashCode() : 0;
        result = 31 * result + (rendaMensalMedia != null ? rendaMensalMedia.hashCode() : 0);
        result = 31 * result + (ateAno1 != null ? ateAno1.hashCode() : 0);
        result = 31 * result + (deAno2 != null ? deAno2.hashCode() : 0);
        result = 31 * result + (ateAno2 != null ? ateAno2.hashCode() : 0);
        result = 31 * result + (deAno3 != null ? deAno3.hashCode() : 0);
        result = 31 * result + (ateAno3 != null ? ateAno3.hashCode() : 0);
        result = 31 * result + (deAno4 != null ? deAno4.hashCode() : 0);
        result = 31 * result + (valorBolsaPos != null ? valorBolsaPos.hashCode() : 0);
        return result;
    }

	public Timestamp getData() {
		return data;
	}

	public void setData(Timestamp data) {
		this.data = data;
	}

	public BigDecimal getRendaMensalMedia() {
		return rendaMensalMedia;
	}

	public void setRendaMensalMedia(BigDecimal rendaMensalMedia) {
		this.rendaMensalMedia = rendaMensalMedia;
	}

	public Short getAteAno1() {
		return ateAno1;
	}

	public void setAteAno1(Short ateAno1) {
		this.ateAno1 = ateAno1;
	}

	public Short getDeAno2() {
		return deAno2;
	}

	public void setDeAno2(Short deAno2) {
		this.deAno2 = deAno2;
	}

	public Short getAteAno2() {
		return ateAno2;
	}

	public void setAteAno2(Short ateAno2) {
		this.ateAno2 = ateAno2;
	}

	public Short getDeAno3() {
		return deAno3;
	}

	public void setDeAno3(Short deAno3) {
		this.deAno3 = deAno3;
	}

	public Short getAteAno3() {
		return ateAno3;
	}

	public void setAteAno3(Short ateAno3) {
		this.ateAno3 = ateAno3;
	}

	public Short getDeAno4() {
		return deAno4;
	}

	public void setDeAno4(Short deAno4) {
		this.deAno4 = deAno4;
	}

	public BigDecimal getValorBolsaPos() {
		return valorBolsaPos;
	}

	public void setValorBolsaPos(BigDecimal valorBolsaPos) {
		this.valorBolsaPos = valorBolsaPos;
	}
    
}
