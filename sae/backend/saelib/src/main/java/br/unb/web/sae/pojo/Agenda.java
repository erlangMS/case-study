package br.unb.web.sae.pojo;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Agenda")
public class Agenda implements Serializable {

	private static final long serialVersionUID = 4514450478730109792L;

	@Id
    @Column(name = "Sequencial", nullable = false, insertable = true, updatable = true)
	private Integer sequencial;

    @Basic
    @Column(name = "SemestreAno", nullable = false, insertable = true, updatable = true, length = 5)
    private String semestreAno;

    @Basic
    @Column(name = "DataHora", nullable = false, insertable = true, updatable = true, length = 27)
    private String dataHora;

    @Basic
    @Column(name = "Aluno", nullable = true, insertable = true, updatable = true)
    private Integer aluno;

    @Basic
    @Column(name = "Campus", nullable = false, insertable = true, updatable = true)
    private Integer campus;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Agenda agenda = (Agenda) o;

        if (sequencial != null ? !sequencial.equals(agenda.sequencial) : agenda.sequencial != null) return false;
        if (semestreAno != null ? !semestreAno.equals(agenda.semestreAno) : agenda.semestreAno != null) return false;
        if (dataHora != null ? !dataHora.equals(agenda.dataHora) : agenda.dataHora != null) return false;
        if (aluno != null ? !aluno.equals(agenda.aluno) : agenda.aluno != null) return false;
        if (campus != null ? !campus.equals(agenda.campus) : agenda.campus != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sequencial != null ? sequencial.hashCode() : 0;
        result = 31 * result + (semestreAno != null ? semestreAno.hashCode() : 0);
        result = 31 * result + (dataHora != null ? dataHora.hashCode() : 0);
        result = 31 * result + (aluno != null ? aluno.hashCode() : 0);
        result = 31 * result + (campus != null ? campus.hashCode() : 0);
        return result;
    }

	public Integer getSequencial() {
		return sequencial;
	}

	public void setSequencial(Integer sequencial) {
		this.sequencial = sequencial;
	}

	public String getSemestreAno() {
		return semestreAno;
	}

	public void setSemestreAno(String semestreAno) {
		this.semestreAno = semestreAno;
	}

	public String getDataHora() {
		return dataHora;
	}

	public void setDataHora(String dataHora) {
		this.dataHora = dataHora;
	}

	public Integer getAluno() {
		return aluno;
	}

	public void setAluno(Integer aluno) {
		this.aluno = aluno;
	}

	public Integer getCampus() {
		return campus;
	}

	public void setCampus(Integer campus) {
		this.campus = campus;
	}
    
    
}
