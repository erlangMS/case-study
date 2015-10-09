package br.unb.web.sae.pojo;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="DatasDescartadas")
@IdClass(br.unb.web.sae.pojo.DatasDescartadasPK.class)
public class DatasDescartadas implements Serializable {

	private static final long serialVersionUID = -1981535715560223620L;

	@Id
    @Column(name = "SemestreAno", nullable = false, insertable = true, updatable = true, length = 5)
	private String semestreAno;

    @Id
    @Column(name = "Data", nullable = false, insertable = true, updatable = true)
    private Timestamp data;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DatasDescartadas that = (DatasDescartadas) o;

        if (semestreAno != null ? !semestreAno.equals(that.semestreAno) : that.semestreAno != null) return false;
        if (data != null ? !data.equals(that.data) : that.data != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = semestreAno != null ? semestreAno.hashCode() : 0;
        result = 31 * result + (data != null ? data.hashCode() : 0);
        return result;
    }

	public String getSemestreAno() {
		return semestreAno;
	}

	public void setSemestreAno(String semestreAno) {
		this.semestreAno = semestreAno;
	}

	public Timestamp getData() {
		return data;
	}

	public void setData(Timestamp data) {
		this.data = data;
	}
    
    
}
