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
@Table(name="AssinaturaTermoBa")
@IdClass(br.unb.web.sae.pojo.AssinaturaTermoBaPK.class)
public class AssinaturaTermoBa implements Serializable {

	private static final long serialVersionUID = -4298271607671019171L;

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
    @Column(name = "ValorAlimentacao", nullable = true, insertable = true, updatable = true)
    private Boolean valorAlimentacao;

    @Basic
    @Column(name = "Banco", nullable = true, insertable = true, updatable = true, length = 3)
    private String banco;

    @Basic
    @Column(name = "Agencia", nullable = true, insertable = true, updatable = true, length = 5)
    private String agencia;

    @Basic
    @Column(name = "Conta", nullable = true, insertable = true, updatable = true, length = 10)
    private String conta;

    @Basic
    @Column(name = "PeriodoExtra", nullable = true, insertable = true, updatable = true)
    private Timestamp periodoExtra;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AssinaturaTermoBa that = (AssinaturaTermoBa) o;

        if (aluno != null ? !aluno.equals(that.aluno) : that.aluno != null) return false;
        if (semestreAno != null ? !semestreAno.equals(that.semestreAno) : that.semestreAno != null) return false;
        if (data != null ? !data.equals(that.data) : that.data != null) return false;
        if (valorAlimentacao != null ? !valorAlimentacao.equals(that.valorAlimentacao) : that.valorAlimentacao != null)
            return false;
        if (banco != null ? !banco.equals(that.banco) : that.banco != null) return false;
        if (agencia != null ? !agencia.equals(that.agencia) : that.agencia != null) return false;
        if (conta != null ? !conta.equals(that.conta) : that.conta != null) return false;
        if (periodoExtra != null ? !periodoExtra.equals(that.periodoExtra) : that.periodoExtra != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = aluno != null ? aluno.hashCode() : 0;
        result = 31 * result + (semestreAno != null ? semestreAno.hashCode() : 0);
        result = 31 * result + (data != null ? data.hashCode() : 0);
        result = 31 * result + (valorAlimentacao != null ? valorAlimentacao.hashCode() : 0);
        result = 31 * result + (banco != null ? banco.hashCode() : 0);
        result = 31 * result + (agencia != null ? agencia.hashCode() : 0);
        result = 31 * result + (conta != null ? conta.hashCode() : 0);
        result = 31 * result + (periodoExtra != null ? periodoExtra.hashCode() : 0);
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

	public Boolean getValorAlimentacao() {
		return valorAlimentacao;
	}

	public void setValorAlimentacao(Boolean valorAlimentacao) {
		this.valorAlimentacao = valorAlimentacao;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getConta() {
		return conta;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}

	public Timestamp getPeriodoExtra() {
		return periodoExtra;
	}

	public void setPeriodoExtra(Timestamp periodoExtra) {
		this.periodoExtra = periodoExtra;
	}
    
}

