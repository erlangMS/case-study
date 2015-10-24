package br.unb.web.sae.pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Agenda")
public class Agenda implements Serializable {

	private static final long serialVersionUID = 4514450478730109792L;

	@Id
    @Column(name = "Sequencial", nullable = false, insertable = true, updatable = true)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

    @Basic
    @Column(name = "SemestreAno", nullable = false, insertable = true, updatable = true, length = 5)
    private String periodo;

    @Basic
    @Column(name = "DataHora", nullable = false, insertable = true, updatable = true, length = 27)
    @Temporal (TemporalType.TIMESTAMP)
    private Date dataHora;

    @Basic
    @Column(name = "Aluno", nullable = true, insertable = true, updatable = true)
    private Integer matricula;

    @Basic
    @Column(name = "Campus", nullable = false, insertable = true, updatable = true)
    private Integer campus;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Agenda agenda = (Agenda) o;

        if (id != null ? !id.equals(agenda.id) : agenda.id != null) return false;
        if (periodo != null ? !periodo.equals(agenda.periodo) : agenda.periodo != null) return false;
        if (dataHora != null ? !dataHora.equals(agenda.dataHora) : agenda.dataHora != null) return false;
        if (matricula != null ? !matricula.equals(agenda.matricula) : agenda.matricula != null) return false;
        if (campus != null ? !campus.equals(agenda.campus) : agenda.campus != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (periodo != null ? periodo.hashCode() : 0);
        result = 31 * result + (dataHora != null ? dataHora.hashCode() : 0);
        result = 31 * result + (matricula != null ? matricula.hashCode() : 0);
        result = 31 * result + (campus != null ? campus.hashCode() : 0);
        return result;
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public Date getDataHora() {
		return dataHora;
	}

	public void setDataHora(Date dataHora) {
		this.dataHora = dataHora;
	}

	public Integer getMatricula() {
		return matricula;
	}

	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}

	public Integer getCampus() {
		return campus;
	}

	public void setCampus(Integer campus) {
		this.campus = campus;
	}


}
