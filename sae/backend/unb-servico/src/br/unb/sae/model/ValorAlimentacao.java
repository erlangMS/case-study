package br.unb.sae.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

import javax.inject.Inject;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.erlangms.EmsValidationException;
import br.unb.sae.infra.InfraFactory;


@Entity
@Table(name="ValorAlimentacao")
public class ValorAlimentacao implements Serializable {

	private static final long serialVersionUID = -1690297538495635030L;

	@Inject	@Transient InfraFactory infra;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ValorAlimentacao that = (ValorAlimentacao) o;

        if (id != null ? !id.equals(that.id) : that.id != null)
            return false;
        if (campus != null ? !campus.equals(that.campus) : that.campus != null) return false;
        if (inicioVigencia != null ? !inicioVigencia.equals(that.inicioVigencia) : that.inicioVigencia != null)
            return false;
        if (fimVigencia != null ? !fimVigencia.equals(that.fimVigencia) : that.fimVigencia != null) return false;
        if (pagaBeneficio != null ? !pagaBeneficio.equals(that.pagaBeneficio) : that.pagaBeneficio != null)
            return false;
        if (valorBeneficio != null ? !valorBeneficio.equals(that.valorBeneficio) : that.valorBeneficio != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (campus != null ? campus.hashCode() : 0);
        result = 31 * result + (inicioVigencia != null ? inicioVigencia.hashCode() : 0);
        result = 31 * result + (fimVigencia != null ? fimVigencia.hashCode() : 0);
        result = 31 * result + (pagaBeneficio != null ? pagaBeneficio.hashCode() : 0);
        result = 31 * result + (valorBeneficio != null ? valorBeneficio.hashCode() : 0);
        return result;
    }

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
    
	private void validar(ValorAlimentacao obj) {
		EmsValidationException validation = new EmsValidationException();
		
		if (obj.getCampus() == null){
			validation.addError("O campo campus é obrigatório.");
		}
		
		if (obj.getInicioVigencia() == null){
			validation.addError("O campo data de início de vigência é obrigatório.");
		}

		if(obj.getPagaBeneficio() == null) {
			validation.addError("Informe se paga benefício.");
		}
		
		if(obj.getValorBeneficio() == null) {
			validation.addError("O campo valor do benefício é obrigatório.");
		}

		if(obj.getFimVigencia() != null && 
		   obj.getInicioVigencia() != null && 
		   obj.getFimVigencia().before(obj.getInicioVigencia())) {
				validation.addError("A data do fim de vigência deve ser maior que a data de início de vigência.");
		}
		
		if (obj.getId() == null){
			if (infra.getValorAlimentacaoRepository().existePeriodoVigenciaAberto(obj)){
				validation.addError("Existe registro com período em aberto.");
			}
		}else{
			if (infra.getValorAlimentacaoRepository().existePeriodoFimMaiorPeriodoInicio(obj)){
				validation.addError("Existe registro com período vigência maior ou igual ao período vigência inicial.");
			}
		}

		if(validation.getErrors().size() > 0) {
			throw validation;
		}
	}
	
}
