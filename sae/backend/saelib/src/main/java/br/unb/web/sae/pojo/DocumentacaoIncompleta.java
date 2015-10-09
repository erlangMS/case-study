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
@Table(name="DocumentacaoIncompleta")
@IdClass(br.unb.web.sae.pojo.DocumentacaoIncompletaPK.class)
public class DocumentacaoIncompleta implements Serializable {

	private static final long serialVersionUID = 5469805498031414585L;

	@Id
    @Column(name = "Aluno", nullable = false, insertable = true, updatable = true)
	private Integer aluno;

    @Id
    @Column(name = "SemestreAno", nullable = false, insertable = true, updatable = true, length = 5)
    private String semestreAno;

    @Basic
    @Column(name = "Data", nullable = false, insertable = true, updatable = true)
    private Timestamp data;

    @Basic
    @Column(name = "AssistenteSocial", nullable = true, insertable = true, updatable = true, length = 60)
    private String assistenteSocial;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DocumentacaoIncompleta that = (DocumentacaoIncompleta) o;

        if (aluno != null ? !aluno.equals(that.aluno) : that.aluno != null) return false;
        if (semestreAno != null ? !semestreAno.equals(that.semestreAno) : that.semestreAno != null) return false;
        if (data != null ? !data.equals(that.data) : that.data != null) return false;
        if (assistenteSocial != null ? !assistenteSocial.equals(that.assistenteSocial) : that.assistenteSocial != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = aluno != null ? aluno.hashCode() : 0;
        result = 31 * result + (semestreAno != null ? semestreAno.hashCode() : 0);
        result = 31 * result + (data != null ? data.hashCode() : 0);
        result = 31 * result + (assistenteSocial != null ? assistenteSocial.hashCode() : 0);
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

	public Timestamp getData() {
		return data;
	}

	public void setData(Timestamp data) {
		this.data = data;
	}

	public String getAssistenteSocial() {
		return assistenteSocial;
	}

	public void setAssistenteSocial(String assistenteSocial) {
		this.assistenteSocial = assistenteSocial;
	}
    
    
}
