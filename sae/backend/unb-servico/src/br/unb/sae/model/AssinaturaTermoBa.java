package br.unb.sae.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import br.erlangms.EmsValidationException;

@Entity
@Table(name="AssinaturaTermoBa")
public class AssinaturaTermoBa {

	@Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="Aluno_Id", nullable = false, insertable = true, updatable = false)
    private AlunoSae aluno;

    @Column(name = "SemestreAno", nullable = false, insertable = true, updatable = true, length = 5)
    private String semestreAno;

    @Column(name = "Data", nullable = false, insertable = true, updatable = true)
    private Date dataAssinatura;

    @Column(name = "ValorAlimentacao", nullable = true, insertable = true, updatable = true)
    private Boolean valorAlimentacao = false;

    @Column(name = "Banco", nullable = true, insertable = true, updatable = true, length = 3)
    private String banco;

    @Column(name = "Agencia", nullable = true, insertable = true, updatable = true, length = 5)
    private String agencia;

    @Column(name = "Conta", nullable = true, insertable = true, updatable = true, length = 10)
    private String conta;

    @Column(name = "PeriodoExtra", nullable = true, insertable = true, updatable = true)
    private Date periodoExtra;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public AlunoSae getAluno() {
		return aluno;
	}

	public void setAluno(AlunoSae aluno) {
		this.aluno = aluno;
	}

	public String getSemestreAno() {
		return semestreAno;
	}

	public void setSemestreAno(String semestreAno) {
		this.semestreAno = semestreAno;
	}

	public Date getDataAssinatura() {
		return dataAssinatura;
	}

	public void setDataAssinatura(Date dataAssinatura) {
		this.dataAssinatura = dataAssinatura;
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

	public Date getPeriodoExtra() {
		return periodoExtra;
	}

	public void setPeriodoExtra(Date periodoExtra) {
		this.periodoExtra = periodoExtra;
	}

	public void validar(){
		EmsValidationException erro = new EmsValidationException();

		if (getSemestreAno() == null){
			erro.addError("Informe o semestre e ano.");
		}
		
		if (getDataAssinatura() == null){
			erro.addError("Informe a data da assinatura.");
		}

		if (getBanco()== null){
			erro.addError("Informe o banco.");
		}

		if (getAgencia() == null){
			erro.addError("Informe a agência.");
		}
		
		if (getConta() == null){
			erro.addError("Informe a conta.");
		}

		if (getDataAssinatura() == null){
			erro.addError("Informe a data da assinatura.");
		}
		
		if (erro.getErrors().size() > 0){
			throw erro;
		}
	}
    
}

