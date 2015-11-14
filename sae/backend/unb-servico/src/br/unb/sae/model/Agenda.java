package br.unb.sae.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Agenda")
public class Agenda implements Serializable {

	private static final long serialVersionUID = 4514450478730109792L;

	@Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

    @Basic
    @Column(name = "periodo", nullable = false, insertable = true, updatable = true, length = 5)
    private String periodo;

    @Basic
    @Column(name = "dataInicio", nullable = false, insertable = true, updatable = true, length = 8)
    private Date dataInicio;
    
    @Basic
    @Column(name = "dataFim", nullable = false, insertable = true, updatable = true, length = 8)
    private Date dataFim;

    @Basic
    @Column(name = "HoraInicio", nullable = false, insertable = true, updatable = true, length = 5)
    private String horaInicio;

    @Basic
    @Column(name = "HoraFim", nullable = false, insertable = true, updatable = true, length = 5)
    private String horaFim;

    @Basic
    @Column(name = "Campus", nullable = false, insertable = true, updatable = true)
    private Integer campus;

    @Basic
    @Column(name = "quantidadeAtendente", nullable = false, insertable = true, updatable = true)
    private Integer quantidadeAtendentes;

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

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public String getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(String horaInicio) {
		this.horaInicio = horaInicio;
	}

	public String getHoraFim() {
		return horaFim;
	}

	public void setHoraFim(String horaFim) {
		this.horaFim = horaFim;
	}

	public Integer getCampus() {
		return campus;
	}

	public void setCampus(Integer campus) {
		this.campus = campus;
	}

	public Integer getQuantidadeAtendentes() {
		return quantidadeAtendentes;
	}

	public void setQuantidadeAtendentes(Integer quantidadeAtendentes) {
		this.quantidadeAtendentes = quantidadeAtendentes;
	}

   
    
}