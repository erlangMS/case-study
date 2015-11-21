package br.unb.sae.model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.erlangms.EmsValidationException;
import br.unb.sae.infra.SaeInfra;

@Entity
@Table(name="Agenda")
public class Agenda implements Serializable {

	private static final long serialVersionUID = 4514450478730109792L;

	@Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

    @Column(name = "periodo", nullable = false, insertable = true, updatable = true, length = 5)
    private String semestreAno;

    @Column(name = "dataInicio", nullable = false, insertable = true, updatable = true, length = 8)
    private Date dataInicio;
    
    @Column(name = "dataFim", nullable = false, insertable = true, updatable = true, length = 8)
    private Date dataFim;

    @Column(name = "HoraInicio", nullable = false, insertable = true, updatable = true, length = 5)
    private String horaInicio;

    @Column(name = "HoraFim", nullable = false, insertable = true, updatable = true, length = 5)
    private String horaFim;

    @Column(name = "Campus", nullable = false, insertable = true, updatable = true)
    private Integer campus;

    @Column(name = "quantidadeAtendente", nullable = false, insertable = true, updatable = true)
    private Integer quantidadeAtendentes = 3;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	
	public String getSemestreAno() {
		return semestreAno;
	}

	public void setSemestreAno(String semestreAno) {
		this.semestreAno = semestreAno;
	}

	public void validar() {
		EmsValidationException erro = new EmsValidationException();

		if (getDataInicio() == null){
			erro.addError("Informe a data de início da agenda.");
		}

		if (getDataFim() == null){
			erro.addError("Informe a data fim da agenda.");
		}

		if (getDataInicio() != null &&
			getDataFim() != null &&
			getDataInicio().after(getDataFim())){
				erro.addError("A data fim da agenda deve ser maior que a data de início.");
		}

		if (getHoraInicio() == null){
			erro.addError("Informe a hora de início da agenda.");
		}
		
		if (getHoraFim() == null){
			erro.addError("Informe a hora de fim da agenda.");
		}

		if (getQuantidadeAtendentes() == null){
			erro.addError("Informe a quantidade de atendentes.");
		}

		try {
			if (getHoraInicio() != null &&
				getHoraFim() != null &&
				(new SimpleDateFormat("HH:mm")).parse(getHoraInicio()).after((new SimpleDateFormat("HH:mm")).parse(getHoraFim()))){
					erro.addError("A hora fim deve ser maior que a hora de início.");
				}
		} catch (ParseException e) {
			erro.addError("Informe um horário válido.");
		}

		if (getCampus() == null){
			erro.addError("Informe o Campus da agenda.");
		}

		if (getSemestreAno() == null){
			erro.addError("Informe o ano e semestre da agenda.");
		}
		
		if (existeProjecaoDeAgendaParaDataInicioInformada()){
			erro.addError("Já existe projeção na agenda para a data de início.");
		}
		
		if(erro.getErrors().size() > 0) {
			throw erro;
		}
		
	}

	private boolean existeProjecaoDeAgendaParaDataInicioInformada() {
		int idCampus = getCampus(); 
		Date dataFim = getDataFim();
		return SaeInfra.getInstance()
			.getAgendaRepository()
			.getStreams()
			.where(a -> a.getCampus() == idCampus && 
					    (a.getDataFim().after(dataFim) || a.getDataFim().equals(dataFim)))
			.count() > 0; 
	}


    
}