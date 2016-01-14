package br.unb.sae.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import br.erlangms.EmsValidationException;

@Entity
@Table(name="TB_AssinaturaTermoBa",
	uniqueConstraints = {@UniqueConstraint(columnNames={"ATBAluMatricula", "ATBPeriodo"})}
)
public class AssinaturaTermoBa {

	@Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Column(name="ATBAluMatricula", nullable = false)
    private Integer aluno;

    @Column(name = "ATBPeriodo", nullable = false, insertable = true, updatable = true, length = 5)
    private String periodo;

    @Column(name = "ATBDataAssinatura", nullable = false)
    private Date dataAssinatura;

    @Column(name = "ATBValorAlimentacao", nullable = true)
    private Boolean valorAlimentacao = false;

    @Column(name = "ATBBanco", nullable = true, length = 3)
    private String banco;

    @Column(name = "ATBAgencia", nullable = true, length = 6)
    private String agencia;

    @Column(name = "ATBConta", nullable = true, length = 10)
    private String conta;

    @Column(name = "ATBVigenciaExtra", nullable = true)
    private Date periodoExtra;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAluno() {
		return aluno;
	}

	public void setAluno(Integer aluno) {
		this.aluno = aluno;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
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

		if (getPeriodo() == null){
			erro.addError("Informe o período.");
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

