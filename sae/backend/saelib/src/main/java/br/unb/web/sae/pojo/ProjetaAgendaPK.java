package br.unb.web.sae.pojo;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Id;

public class ProjetaAgendaPK implements Serializable {
	private static final long serialVersionUID = -1303672844834952600L;

    @Id
	@Column(name = "SemestreAno", nullable = false, insertable = true, updatable = true, length = 5)
	private String semestreAno;

    @Id
	@Column(name = "DataInicio", nullable = false, insertable = true, updatable = true)
	private Timestamp dataInicio;

    @Id
    @Column(name = "Campus", nullable = false, insertable = true, updatable = true)
    private Integer campus;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProjetaAgendaPK that = (ProjetaAgendaPK) o;

        if (semestreAno != null ? !semestreAno.equals(that.semestreAno) : that.semestreAno != null) return false;
        if (dataInicio != null ? !dataInicio.equals(that.dataInicio) : that.dataInicio != null) return false;
        if (campus != null ? !campus.equals(that.campus) : that.campus != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = semestreAno != null ? semestreAno.hashCode() : 0;
        result = 31 * result + (dataInicio != null ? dataInicio.hashCode() : 0);
        result = 31 * result + (campus != null ? campus.hashCode() : 0);
        return result;
    }

	public String getSemestreAno() {
		return semestreAno;
	}

	public void setSemestreAno(String semestreAno) {
		this.semestreAno = semestreAno;
	}

	public Timestamp getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Timestamp dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Integer getCampus() {
		return campus;
	}

	public void setCampus(Integer campus) {
		this.campus = campus;
	}
    
    
}