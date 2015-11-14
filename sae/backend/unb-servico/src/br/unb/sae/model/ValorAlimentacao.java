package br.unb.sae.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.erlangms.EmsValidationException;
import br.unb.sae.infra.InfraFactory;


@Entity
@Table(name="ValorAlimentacao")
public class ValorAlimentacao implements Serializable {

	private static final long serialVersionUID = -1690297538495635030L;

	@Id
    @Column(name = "IdValorAlimetacao", nullable = false, insertable = true, updatable = true)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

    @Basic
    @Column(name = "Campus", nullable = false, insertable = true, updatable = true)
    private Integer campus;

    @Basic
    @Column(name = "InicioVigencia", nullable = false, insertable = true, updatable = true)
    private Date inicioVigencia;

    @Basic
    @Column(name = "FimVigencia", nullable = true, insertable = true, updatable = true)
    private Date fimVigencia;

    @Basic
    @Column(name = "PagaBeneficio", nullable = false, insertable = true, updatable = true)
    private Boolean pagaBeneficio;

    @Basic
    @Column(name = "ValorBeneficio", nullable = false, insertable = true, updatable = true, precision = 10)
    private BigDecimal valorBeneficio;

	public Integer getId() {
		return id;
	}

	public void setId(Integer idValorAlimetacao) {
		this.id = idValorAlimetacao;
	}

	public Integer getCampus() {
		return campus;
	}

	public void setCampus(Integer campus) {
		this.campus = campus;
	}

	public Date getInicioVigencia() {
		return inicioVigencia;
	}

	public void setInicioVigencia(Date inicioVigencia) {
		this.inicioVigencia = inicioVigencia;
	}

	public Date getFimVigencia() {
		return fimVigencia;
	}

	public void setFimVigencia(Date fimVigencia) {
		this.fimVigencia = fimVigencia;
	}

	public Boolean getPagaBeneficio() {
		return pagaBeneficio;
	} 	

	public void setPagaBeneficio(Boolean pagaBeneficio) {
		this.pagaBeneficio = pagaBeneficio;
	}

	public BigDecimal getValorBeneficio() {
		return valorBeneficio;
	}

	public void setValorBeneficio(BigDecimal valorBeneficio) {
		this.valorBeneficio = valorBeneficio;
	}
    
	public void validar() {
		EmsValidationException validation = new EmsValidationException();
		
		if (getCampus() == null){
			validation.addError("O campo campus é obrigatório.");
		}
		
		if (getInicioVigencia() == null){
			validation.addError("O campo data de início de vigência é obrigatório.");
		}

		if(getPagaBeneficio() == null) {
			validation.addError("Informe se paga benefício.");
		}
		
		if(getValorBeneficio() == null) {
			validation.addError("O campo valor do benefício é obrigatório.");
		}

		if(getFimVigencia() != null && 
		   getInicioVigencia() != null && 
		   getFimVigencia().before(getInicioVigencia())) {
				validation.addError("A data do fim de vigência deve ser maior que a data de início de vigência.");
		}
		
		if (getId() == null){
			if (InfraFactory.getInstance().getValorAlimentacaoRepository().existePeriodoVigenciaAbertoEmCampus(getCampus())){
				validation.addError("Existe registro com período em aberto.");
			}
		}else{
			if (InfraFactory.getInstance().getValorAlimentacaoRepository().existePeriodoFimMaiorPeriodoInicioQueEsteValorAlimentacao(this)){
				validation.addError("Existe registro com período vigência maior ou igual ao período vigência inicial.");
			}
		}

		if(validation.getErrors().size() > 0) {
			throw validation;
		}
	}
	
}
