package br.unb.web.sae.pojo;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="EstudosSocioEconomicosPreliminares")
@IdClass(br.unb.web.sae.pojo.EstudosSocioEconomicosPreliminaresPK.class)
public class EstudosSocioEconomicosPreliminares implements Serializable {

	private static final long serialVersionUID = 2301982583916113474L;

	@Id
    @Column(name = "Aluno", nullable = false, insertable = true, updatable = true)
	private Integer aluno;

    @Id
    @Column(name = "SemestreAno", nullable = false, insertable = true, updatable = true, length = 5)
    private String semestreAno;

    @Basic
    @Column(name = "EnsinoMedio", nullable = false, insertable = true, updatable = true, length = 27)
    private String ensinoMedio;

    @Basic
    @Column(name = "EnsinoSuperior", nullable = true, insertable = true, updatable = true, length = 32)
    private String ensinoSuperior;

    @Basic
    @Column(name = "RendaFamiliar", nullable = false, insertable = true, updatable = true, length = 28)
    private String rendaFamiliar;

    @Basic
    @Column(name = "MembroGrupoFamiliar", nullable = false, insertable = true, updatable = true, length = 10)
    private String membroGrupoFamiliar;

    @Basic
    @Column(name = "LocalMoradiaAluno", nullable = false, insertable = true, updatable = true, length = 57)
    private String localMoradiaAluno;

    @Basic
    @Column(name = "ComoResideAluno", nullable = false, insertable = true, updatable = true, length = 32)
    private String comoResideAluno;

    @Basic
    @Column(name = "ComoResideFamiliaAluno", nullable = false, insertable = true, updatable = true, length = 32)
    private String comoResideFamiliaAluno;

    @Basic
    @Column(name = "MeioTransporte", nullable = false, insertable = true, updatable = true, length = 19)
    private String meioTransporte;

    @Basic
    @Column(name = "ProblemaSaudeFamilia", nullable = false, insertable = true, updatable = true, length = 10)
    private String problemaSaudeFamilia;

    @Basic
    @Column(name = "Pontos", nullable = false, insertable = true, updatable = true)
    private Byte pontos;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EstudosSocioEconomicosPreliminares that = (EstudosSocioEconomicosPreliminares) o;

        if (aluno != null ? !aluno.equals(that.aluno) : that.aluno != null) return false;
        if (semestreAno != null ? !semestreAno.equals(that.semestreAno) : that.semestreAno != null) return false;
        if (ensinoMedio != null ? !ensinoMedio.equals(that.ensinoMedio) : that.ensinoMedio != null) return false;
        if (ensinoSuperior != null ? !ensinoSuperior.equals(that.ensinoSuperior) : that.ensinoSuperior != null)
            return false;
        if (rendaFamiliar != null ? !rendaFamiliar.equals(that.rendaFamiliar) : that.rendaFamiliar != null)
            return false;
        if (membroGrupoFamiliar != null ? !membroGrupoFamiliar.equals(that.membroGrupoFamiliar) : that.membroGrupoFamiliar != null)
            return false;
        if (localMoradiaAluno != null ? !localMoradiaAluno.equals(that.localMoradiaAluno) : that.localMoradiaAluno != null)
            return false;
        if (comoResideAluno != null ? !comoResideAluno.equals(that.comoResideAluno) : that.comoResideAluno != null)
            return false;
        if (comoResideFamiliaAluno != null ? !comoResideFamiliaAluno.equals(that.comoResideFamiliaAluno) : that.comoResideFamiliaAluno != null)
            return false;
        if (meioTransporte != null ? !meioTransporte.equals(that.meioTransporte) : that.meioTransporte != null)
            return false;
        if (problemaSaudeFamilia != null ? !problemaSaudeFamilia.equals(that.problemaSaudeFamilia) : that.problemaSaudeFamilia != null)
            return false;
        if (pontos != null ? !pontos.equals(that.pontos) : that.pontos != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = aluno != null ? aluno.hashCode() : 0;
        result = 31 * result + (semestreAno != null ? semestreAno.hashCode() : 0);
        result = 31 * result + (ensinoMedio != null ? ensinoMedio.hashCode() : 0);
        result = 31 * result + (ensinoSuperior != null ? ensinoSuperior.hashCode() : 0);
        result = 31 * result + (rendaFamiliar != null ? rendaFamiliar.hashCode() : 0);
        result = 31 * result + (membroGrupoFamiliar != null ? membroGrupoFamiliar.hashCode() : 0);
        result = 31 * result + (localMoradiaAluno != null ? localMoradiaAluno.hashCode() : 0);
        result = 31 * result + (comoResideAluno != null ? comoResideAluno.hashCode() : 0);
        result = 31 * result + (comoResideFamiliaAluno != null ? comoResideFamiliaAluno.hashCode() : 0);
        result = 31 * result + (meioTransporte != null ? meioTransporte.hashCode() : 0);
        result = 31 * result + (problemaSaudeFamilia != null ? problemaSaudeFamilia.hashCode() : 0);
        result = 31 * result + (pontos != null ? pontos.hashCode() : 0);
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

	public String getEnsinoMedio() {
		return ensinoMedio;
	}

	public void setEnsinoMedio(String ensinoMedio) {
		this.ensinoMedio = ensinoMedio;
	}

	public String getEnsinoSuperior() {
		return ensinoSuperior;
	}

	public void setEnsinoSuperior(String ensinoSuperior) {
		this.ensinoSuperior = ensinoSuperior;
	}

	public String getRendaFamiliar() {
		return rendaFamiliar;
	}

	public void setRendaFamiliar(String rendaFamiliar) {
		this.rendaFamiliar = rendaFamiliar;
	}

	public String getMembroGrupoFamiliar() {
		return membroGrupoFamiliar;
	}

	public void setMembroGrupoFamiliar(String membroGrupoFamiliar) {
		this.membroGrupoFamiliar = membroGrupoFamiliar;
	}

	public String getLocalMoradiaAluno() {
		return localMoradiaAluno;
	}

	public void setLocalMoradiaAluno(String localMoradiaAluno) {
		this.localMoradiaAluno = localMoradiaAluno;
	}

	public String getComoResideAluno() {
		return comoResideAluno;
	}

	public void setComoResideAluno(String comoResideAluno) {
		this.comoResideAluno = comoResideAluno;
	}

	public String getComoResideFamiliaAluno() {
		return comoResideFamiliaAluno;
	}

	public void setComoResideFamiliaAluno(String comoResideFamiliaAluno) {
		this.comoResideFamiliaAluno = comoResideFamiliaAluno;
	}

	public String getMeioTransporte() {
		return meioTransporte;
	}

	public void setMeioTransporte(String meioTransporte) {
		this.meioTransporte = meioTransporte;
	}

	public String getProblemaSaudeFamilia() {
		return problemaSaudeFamilia;
	}

	public void setProblemaSaudeFamilia(String problemaSaudeFamilia) {
		this.problemaSaudeFamilia = problemaSaudeFamilia;
	}

	public Byte getPontos() {
		return pontos;
	}

	public void setPontos(Byte pontos) {
		this.pontos = pontos;
	}
    
    
}
