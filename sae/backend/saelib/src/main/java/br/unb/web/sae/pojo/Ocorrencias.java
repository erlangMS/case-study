package br.unb.web.sae.pojo;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="Ocorrencias")
@IdClass(br.unb.web.sae.pojo.OcorrenciasPK.class)
public class Ocorrencias implements Serializable {

	private static final long serialVersionUID = 193556730815541653L;

	@Id
    @Column(name = "Aluno", nullable = false, insertable = true, updatable = true)
	private Integer aluno;

    @Id
    @Column(name = "SemestreAno", nullable = false, insertable = true, updatable = true, length = 6)
    private String semestreAno;

    @Basic
    @Column(name = "DataInicio", nullable = true, insertable = true, updatable = true)
    private Timestamp dataInicio;

    @Basic
    @Column(name = "DataFim", nullable = true, insertable = true, updatable = true)
    private Timestamp dataFim;

    @Basic
    @Column(name = "Texto", nullable = false, insertable = true, updatable = true)
    private String texto;

    @Basic
    @Column(name = "SuspendeBA", nullable = false, insertable = true, updatable = true, length = 1)
    private String suspendeBa;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ocorrencias that = (Ocorrencias) o;

        if (aluno != null ? !aluno.equals(that.aluno) : that.aluno != null) return false;
        if (semestreAno != null ? !semestreAno.equals(that.semestreAno) : that.semestreAno != null) return false;
        if (dataInicio != null ? !dataInicio.equals(that.dataInicio) : that.dataInicio != null) return false;
        if (dataFim != null ? !dataFim.equals(that.dataFim) : that.dataFim != null) return false;
        if (texto != null ? !texto.equals(that.texto) : that.texto != null) return false;
        if (suspendeBa != null ? !suspendeBa.equals(that.suspendeBa) : that.suspendeBa != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = aluno != null ? aluno.hashCode() : 0;
        result = 31 * result + (semestreAno != null ? semestreAno.hashCode() : 0);
        result = 31 * result + (dataInicio != null ? dataInicio.hashCode() : 0);
        result = 31 * result + (dataFim != null ? dataFim.hashCode() : 0);
        result = 31 * result + (texto != null ? texto.hashCode() : 0);
        result = 31 * result + (suspendeBa != null ? suspendeBa.hashCode() : 0);
        return result;
    }

	public Integer getAluno() {
		return aluno;
	}

	public void setAluno(Integer aluno) {
		this.aluno = aluno;
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

	public Timestamp getDataFim() {
		return dataFim;
	}

	public void setDataFim(Timestamp dataFim) {
		this.dataFim = dataFim;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getSuspendeBa() {
		return suspendeBa;
	}

	public void setSuspendeBa(String suspendeBa) {
		this.suspendeBa = suspendeBa;
	}
  
}
