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
@Table(name="Pontuacao")
@IdClass(br.unb.web.sae.pojo.PontuacaoPK.class)
public class Pontuacao implements Serializable {
	private static final long serialVersionUID = -8126219309174062663L;

	@Id
    @Column(name = "Aluno", nullable = false, insertable = true, updatable = true)
	private Integer aluno;

    @Id
    @Column(name = "SemestreAno", nullable = false, insertable = true, updatable = true, length = 5)
    private String semestreAno;

    @Id
    @Column(name = "DataPontuacao", nullable = false, insertable = true, updatable = true)
    private Timestamp dataPontuacao;

    @Basic
    @Column(name = "ProfissaoAluno", nullable = false, insertable = true, updatable = true, length = 400)
    private String profissaoAluno;

    @Basic
    @Column(name = "PtsProfissaoAluno", nullable = false, insertable = true, updatable = true)
    private Byte ptsProfissaoAluno;

    @Basic
    @Column(name = "CidadeAluno", nullable = false, insertable = true, updatable = true, length = 400)
    private String cidadeAluno;

    @Basic
    @Column(name = "PtsCidadeAluno", nullable = false, insertable = true, updatable = true)
    private Byte ptsCidadeAluno;

    @Basic
    @Column(name = "ProfissaoPai", nullable = false, insertable = true, updatable = true, length = 400)
    private String profissaoPai;

    @Basic
    @Column(name = "PtsProfissaoPai", nullable = false, insertable = true, updatable = true)
    private Byte ptsProfissaoPai;

    @Basic
    @Column(name = "ProfissaoMae", nullable = false, insertable = true, updatable = true, length = 400)
    private String profissaoMae;

    @Basic
    @Column(name = "PtsProfissaoMae", nullable = false, insertable = true, updatable = true)
    private Byte ptsProfissaoMae;

    @Basic
    @Column(name = "ProfissaoMantCon", nullable = false, insertable = true, updatable = true, length = 400)
    private String profissaoMantCon;

    @Basic
    @Column(name = "PtsProfissaoMantCon", nullable = false, insertable = true, updatable = true)
    private Byte ptsProfissaoMantCon;

    @Basic
    @Column(name = "FaixaDeRenda", nullable = false, insertable = true, updatable = true, length = 400)
    private String faixaDeRenda;

    @Basic
    @Column(name = "PtsFaixaDeRenda", nullable = false, insertable = true, updatable = true)
    private Byte ptsFaixaDeRenda;

    @Basic
    @Column(name = "ParecerTecnico", nullable = false, insertable = true, updatable = true, length = 600)
    private String parecerTecnico;

    @Basic
    @Column(name = "PtsParecerTecnico", nullable = false, insertable = true, updatable = true)
    private Short ptsParecerTecnico;

    @Basic
    @Column(name = "Pontuacao", nullable = false, insertable = true, updatable = true, precision = 0)
    private Float pontuacao;

    @Basic
    @Column(name = "Independente", nullable = true, insertable = true, updatable = true, length = 3)
    private String independente;

    @Basic
    @Column(name = "AssistenteSocial", nullable = false, insertable = true, updatable = true, length = 60)
    private String assistenteSocial;

    @Basic
    @Column(name = "ClassificacaoCEU", nullable = true, insertable = true, updatable = true)
    private Short classificacaoCeu;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pontuacao pontuacao1 = (Pontuacao) o;

        if (aluno != null ? !aluno.equals(pontuacao1.aluno) : pontuacao1.aluno != null) return false;
        if (semestreAno != null ? !semestreAno.equals(pontuacao1.semestreAno) : pontuacao1.semestreAno != null)
            return false;
        if (dataPontuacao != null ? !dataPontuacao.equals(pontuacao1.dataPontuacao) : pontuacao1.dataPontuacao != null)
            return false;
        if (profissaoAluno != null ? !profissaoAluno.equals(pontuacao1.profissaoAluno) : pontuacao1.profissaoAluno != null)
            return false;
        if (ptsProfissaoAluno != null ? !ptsProfissaoAluno.equals(pontuacao1.ptsProfissaoAluno) : pontuacao1.ptsProfissaoAluno != null)
            return false;
        if (cidadeAluno != null ? !cidadeAluno.equals(pontuacao1.cidadeAluno) : pontuacao1.cidadeAluno != null)
            return false;
        if (ptsCidadeAluno != null ? !ptsCidadeAluno.equals(pontuacao1.ptsCidadeAluno) : pontuacao1.ptsCidadeAluno != null)
            return false;
        if (profissaoPai != null ? !profissaoPai.equals(pontuacao1.profissaoPai) : pontuacao1.profissaoPai != null)
            return false;
        if (ptsProfissaoPai != null ? !ptsProfissaoPai.equals(pontuacao1.ptsProfissaoPai) : pontuacao1.ptsProfissaoPai != null)
            return false;
        if (profissaoMae != null ? !profissaoMae.equals(pontuacao1.profissaoMae) : pontuacao1.profissaoMae != null)
            return false;
        if (ptsProfissaoMae != null ? !ptsProfissaoMae.equals(pontuacao1.ptsProfissaoMae) : pontuacao1.ptsProfissaoMae != null)
            return false;
        if (profissaoMantCon != null ? !profissaoMantCon.equals(pontuacao1.profissaoMantCon) : pontuacao1.profissaoMantCon != null)
            return false;
        if (ptsProfissaoMantCon != null ? !ptsProfissaoMantCon.equals(pontuacao1.ptsProfissaoMantCon) : pontuacao1.ptsProfissaoMantCon != null)
            return false;
        if (faixaDeRenda != null ? !faixaDeRenda.equals(pontuacao1.faixaDeRenda) : pontuacao1.faixaDeRenda != null)
            return false;
        if (ptsFaixaDeRenda != null ? !ptsFaixaDeRenda.equals(pontuacao1.ptsFaixaDeRenda) : pontuacao1.ptsFaixaDeRenda != null)
            return false;
        if (parecerTecnico != null ? !parecerTecnico.equals(pontuacao1.parecerTecnico) : pontuacao1.parecerTecnico != null)
            return false;
        if (ptsParecerTecnico != null ? !ptsParecerTecnico.equals(pontuacao1.ptsParecerTecnico) : pontuacao1.ptsParecerTecnico != null)
            return false;
        if (pontuacao != null ? !pontuacao.equals(pontuacao1.pontuacao) : pontuacao1.pontuacao != null) return false;
        if (independente != null ? !independente.equals(pontuacao1.independente) : pontuacao1.independente != null)
            return false;
        if (assistenteSocial != null ? !assistenteSocial.equals(pontuacao1.assistenteSocial) : pontuacao1.assistenteSocial != null)
            return false;
        if (classificacaoCeu != null ? !classificacaoCeu.equals(pontuacao1.classificacaoCeu) : pontuacao1.classificacaoCeu != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = aluno != null ? aluno.hashCode() : 0;
        result = 31 * result + (semestreAno != null ? semestreAno.hashCode() : 0);
        result = 31 * result + (dataPontuacao != null ? dataPontuacao.hashCode() : 0);
        result = 31 * result + (profissaoAluno != null ? profissaoAluno.hashCode() : 0);
        result = 31 * result + (ptsProfissaoAluno != null ? ptsProfissaoAluno.hashCode() : 0);
        result = 31 * result + (cidadeAluno != null ? cidadeAluno.hashCode() : 0);
        result = 31 * result + (ptsCidadeAluno != null ? ptsCidadeAluno.hashCode() : 0);
        result = 31 * result + (profissaoPai != null ? profissaoPai.hashCode() : 0);
        result = 31 * result + (ptsProfissaoPai != null ? ptsProfissaoPai.hashCode() : 0);
        result = 31 * result + (profissaoMae != null ? profissaoMae.hashCode() : 0);
        result = 31 * result + (ptsProfissaoMae != null ? ptsProfissaoMae.hashCode() : 0);
        result = 31 * result + (profissaoMantCon != null ? profissaoMantCon.hashCode() : 0);
        result = 31 * result + (ptsProfissaoMantCon != null ? ptsProfissaoMantCon.hashCode() : 0);
        result = 31 * result + (faixaDeRenda != null ? faixaDeRenda.hashCode() : 0);
        result = 31 * result + (ptsFaixaDeRenda != null ? ptsFaixaDeRenda.hashCode() : 0);
        result = 31 * result + (parecerTecnico != null ? parecerTecnico.hashCode() : 0);
        result = 31 * result + (ptsParecerTecnico != null ? ptsParecerTecnico.hashCode() : 0);
        result = 31 * result + (pontuacao != null ? pontuacao.hashCode() : 0);
        result = 31 * result + (independente != null ? independente.hashCode() : 0);
        result = 31 * result + (assistenteSocial != null ? assistenteSocial.hashCode() : 0);
        result = 31 * result + (classificacaoCeu != null ? classificacaoCeu.hashCode() : 0);
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

	public Timestamp getDataPontuacao() {
		return dataPontuacao;
	}

	public void setDataPontuacao(Timestamp dataPontuacao) {
		this.dataPontuacao = dataPontuacao;
	}

	public String getProfissaoAluno() {
		return profissaoAluno;
	}

	public void setProfissaoAluno(String profissaoAluno) {
		this.profissaoAluno = profissaoAluno;
	}

	public Byte getPtsProfissaoAluno() {
		return ptsProfissaoAluno;
	}

	public void setPtsProfissaoAluno(Byte ptsProfissaoAluno) {
		this.ptsProfissaoAluno = ptsProfissaoAluno;
	}

	public String getCidadeAluno() {
		return cidadeAluno;
	}

	public void setCidadeAluno(String cidadeAluno) {
		this.cidadeAluno = cidadeAluno;
	}

	public Byte getPtsCidadeAluno() {
		return ptsCidadeAluno;
	}

	public void setPtsCidadeAluno(Byte ptsCidadeAluno) {
		this.ptsCidadeAluno = ptsCidadeAluno;
	}

	public String getProfissaoPai() {
		return profissaoPai;
	}

	public void setProfissaoPai(String profissaoPai) {
		this.profissaoPai = profissaoPai;
	}

	public Byte getPtsProfissaoPai() {
		return ptsProfissaoPai;
	}

	public void setPtsProfissaoPai(Byte ptsProfissaoPai) {
		this.ptsProfissaoPai = ptsProfissaoPai;
	}

	public String getProfissaoMae() {
		return profissaoMae;
	}

	public void setProfissaoMae(String profissaoMae) {
		this.profissaoMae = profissaoMae;
	}

	public Byte getPtsProfissaoMae() {
		return ptsProfissaoMae;
	}

	public void setPtsProfissaoMae(Byte ptsProfissaoMae) {
		this.ptsProfissaoMae = ptsProfissaoMae;
	}

	public String getProfissaoMantCon() {
		return profissaoMantCon;
	}

	public void setProfissaoMantCon(String profissaoMantCon) {
		this.profissaoMantCon = profissaoMantCon;
	}

	public Byte getPtsProfissaoMantCon() {
		return ptsProfissaoMantCon;
	}

	public void setPtsProfissaoMantCon(Byte ptsProfissaoMantCon) {
		this.ptsProfissaoMantCon = ptsProfissaoMantCon;
	}

	public String getFaixaDeRenda() {
		return faixaDeRenda;
	}

	public void setFaixaDeRenda(String faixaDeRenda) {
		this.faixaDeRenda = faixaDeRenda;
	}

	public Byte getPtsFaixaDeRenda() {
		return ptsFaixaDeRenda;
	}

	public void setPtsFaixaDeRenda(Byte ptsFaixaDeRenda) {
		this.ptsFaixaDeRenda = ptsFaixaDeRenda;
	}

	public String getParecerTecnico() {
		return parecerTecnico;
	}

	public void setParecerTecnico(String parecerTecnico) {
		this.parecerTecnico = parecerTecnico;
	}

	public Short getPtsParecerTecnico() {
		return ptsParecerTecnico;
	}

	public void setPtsParecerTecnico(Short ptsParecerTecnico) {
		this.ptsParecerTecnico = ptsParecerTecnico;
	}

	public Float getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(Float pontuacao) {
		this.pontuacao = pontuacao;
	}

	public String getIndependente() {
		return independente;
	}

	public void setIndependente(String independente) {
		this.independente = independente;
	}

	public String getAssistenteSocial() {
		return assistenteSocial;
	}

	public void setAssistenteSocial(String assistenteSocial) {
		this.assistenteSocial = assistenteSocial;
	}

	public Short getClassificacaoCeu() {
		return classificacaoCeu;
	}

	public void setClassificacaoCeu(Short classificacaoCeu) {
		this.classificacaoCeu = classificacaoCeu;
	}
    
}
