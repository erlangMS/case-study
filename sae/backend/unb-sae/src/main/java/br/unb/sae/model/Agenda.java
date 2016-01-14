package br.unb.sae.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import br.erlangms.EmsUtil;
import br.erlangms.EmsValidationException;
import br.unb.sae.infra.SaeInfra;

@Entity
@Table(name="TB_Agenda",
	uniqueConstraints = {@UniqueConstraint(columnNames={"AgePeriodo", "AgeCamCodigoCampus"})}
)
public class Agenda implements Serializable {

	private static final long serialVersionUID = 4514450478730109792L;

	@Id
    @Column(name = "AgeCodigo", nullable = false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

    @Column(name = "AgePeriodo", nullable = false, length = 5)
    private String periodo;

    @Column(name = "AgeDataHora", nullable = false, length = 8)
    private Date dataHora;

    @Column(name = "AgeCamCodigoCampus", nullable = false)
    private Integer campus;

    @Column(name = "AgeQtdAtendente", nullable = false)
    private Integer quantidadeAtendentes = 3;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public void validar() {
		EmsValidationException erro = new EmsValidationException();

		if(!EmsUtil.isFieldObjectValid(getDataHora())){
			erro.addError("Informe a data e hora do agendamento.");
		}
		
		
		if (getQuantidadeAtendentes() == null){
			erro.addError("Informe a quantidade de atendentes.");
		}

		if (getCampus() == null){
			erro.addError("Informe o campus da agenda.");
		}

		if (getPeriodo() == null){
			erro.addError("Informe o período da agenda.");
		}
		
		if (erro.getErrors().size() == 0 && existeProjecaoDeAgendaParaDataInicioInformada()){
			erro.addError("Já existe projeção na agenda para a data de início.");
		}
		
		if(erro.getErrors().size() > 0) {
			throw erro;
		}
		
	}

	private boolean existeProjecaoDeAgendaParaDataInicioInformada() {
		Integer idAgenda = getId();
		int idCampus = getCampus(); 
		Date dataFim = getDataHora();
		if (idAgenda != null){ 
			return SaeInfra.getInstance()
				.getAgendaRepository()
				.getStreams()
				.where(a -> a.getCampus() == idCampus && 
						    a.getDataHora().equals(dataFim) &&
						    a.getId() != idAgenda
						)
				.count() > 0;
		}else{
			return SaeInfra.getInstance()
				.getAgendaRepository()
				.getStreams()
				.where(a -> a.getCampus() == idCampus && 
						    a.getDataHora().equals(dataFim)
						)
				.count() > 0;
		}
	}
    
}