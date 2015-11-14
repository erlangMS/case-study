package br.unb.sae.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ProjetaAgenda")
public class ProjetaAgenda implements Serializable {
	private static final long serialVersionUID = -6216031949818403992L;

	@Id
    @Column(name = "id", nullable = false, insertable = true, updatable = true)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Column(name = "SemestreAno", nullable = false, insertable = true, updatable = true, length = 5)
	private String semestreAno;

    @Column(name = "DataInicio", nullable = false, insertable = true, updatable = true)
    private Timestamp dataInicio;

    @Basic
    @Column(name = "DataFim", nullable = false, insertable = true, updatable = true)
    private Timestamp dataFim;

    @Id
    @Column(name = "Campus", nullable = false, insertable = true, updatable = true)
    private Integer campus;

    @Basic
    @Column(name = "QtdAtendimentoM", nullable = false, insertable = true, updatable = true)
    private Byte qtdAtendimentoM;

    @Basic
    @Column(name = "HoraInicioM", nullable = true, insertable = true, updatable = true, length = 5)
    private String horaInicioM;

    @Basic
    @Column(name = "HoraInicioT", nullable = true, insertable = true, updatable = true, length = 5)
    private String horaInicioT;

    @Basic
    @Column(name = "QtdAtendimentoT", nullable = false, insertable = true, updatable = true)
    private Byte qtdAtendimentoT;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProjetaAgenda that = (ProjetaAgenda) o;

        if (semestreAno != null ? !semestreAno.equals(that.semestreAno) : that.semestreAno != null) return false;
        if (dataInicio != null ? !dataInicio.equals(that.dataInicio) : that.dataInicio != null) return false;
        if (dataFim != null ? !dataFim.equals(that.dataFim) : that.dataFim != null) return false;
        if (campus != null ? !campus.equals(that.campus) : that.campus != null) return false;
        if (qtdAtendimentoM != null ? !qtdAtendimentoM.equals(that.qtdAtendimentoM) : that.qtdAtendimentoM != null)
            return false;
        if (horaInicioM != null ? !horaInicioM.equals(that.horaInicioM) : that.horaInicioM != null) return false;
        if (horaInicioT != null ? !horaInicioT.equals(that.horaInicioT) : that.horaInicioT != null) return false;
        if (qtdAtendimentoT != null ? !qtdAtendimentoT.equals(that.qtdAtendimentoT) : that.qtdAtendimentoT != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = semestreAno != null ? semestreAno.hashCode() : 0;
        result = 31 * result + (dataInicio != null ? dataInicio.hashCode() : 0);
        result = 31 * result + (dataFim != null ? dataFim.hashCode() : 0);
        result = 31 * result + (campus != null ? campus.hashCode() : 0);
        result = 31 * result + (qtdAtendimentoM != null ? qtdAtendimentoM.hashCode() : 0);
        result = 31 * result + (horaInicioM != null ? horaInicioM.hashCode() : 0);
        result = 31 * result + (horaInicioT != null ? horaInicioT.hashCode() : 0);
        result = 31 * result + (qtdAtendimentoT != null ? qtdAtendimentoT.hashCode() : 0);
        return result;
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

	public Integer getCampus() {
		return campus;
	}

	public void setCampus(Integer campus) {
		this.campus = campus;
	}

	public Byte getQtdAtendimentoM() {
		return qtdAtendimentoM;
	}

	public void setQtdAtendimentoM(Byte qtdAtendimentoM) {
		this.qtdAtendimentoM = qtdAtendimentoM;
	}

	public String getHoraInicioM() {
		return horaInicioM;
	}

	public void setHoraInicioM(String horaInicioM) {
		this.horaInicioM = horaInicioM;
	}

	public String getHoraInicioT() {
		return horaInicioT;
	}

	public void setHoraInicioT(String horaInicioT) {
		this.horaInicioT = horaInicioT;
	}

	public Byte getQtdAtendimentoT() {
		return qtdAtendimentoT;
	}

	public void setQtdAtendimentoT(Byte qtdAtendimentoT) {
		this.qtdAtendimentoT = qtdAtendimentoT;
	}
    
    
}
