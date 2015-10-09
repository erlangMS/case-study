package br.unb.web.sae.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="EstudosSocioEconomicos")
@IdClass(br.unb.web.sae.pojo.EstudosSocioEconomicosPK.class)
public class EstudosSocioEconomicos implements Serializable {
	private static final long serialVersionUID = 5471384039041899158L;

	@Id
    @Column(name = "Aluno", nullable = false, insertable = true, updatable = true)
	private Integer aluno;

    @Id
    @Column(name = "SemestreAno", nullable = false, insertable = true, updatable = true, length = 5)
    private String semestreAno;

    @Basic
    @Column(name = "Data", nullable = true, insertable = true, updatable = true)
    private Timestamp data;

    @Basic
    @Column(name = "Motivo", nullable = true, insertable = true, updatable = true)
    private Byte motivo;

    @Basic
    @Column(name = "Nivel", nullable = true, insertable = true, updatable = true, length = 13)
    private String nivel;

    @Basic
    @Column(name = "IsencaoTxVestibular", nullable = true, insertable = true, updatable = true, length = 3)
    private String isencaoTxVestibular;

    @Basic
    @Column(name = "TeveAbatimento", nullable = true, insertable = true, updatable = true, length = 3)
    private String teveAbatimento;
    
    @Basic
    @Column(name = "Raca", nullable = true, insertable = true, updatable = true, length = 10)
    private String raca;
    
    @Basic
    @Column(name = "EnsinoMedio", nullable = true, insertable = true, updatable = true, length = 28)
    private String ensinoMedio;
    
    @Basic
    @Column(name = "EscolaCidade", nullable = true, insertable = true, updatable = true, length = 30)
    private String escolaCidade;
    
    @Basic
    @Column(name = "EscolaNome", nullable = true, insertable = true, updatable = true, length = 50)
    private String escolaNome;
    
    @Basic
    @Column(name = "EscolaUF", nullable = true, insertable = true, updatable = true, length = 2)
    private String escolaUf;
    
    @Basic
    @Column(name = "PreVestibular", nullable = true, insertable = true, updatable = true, length = 28)
    private String preVestibular;

    @Basic
    @Column(name = "EnsinoSuperior", nullable = true, insertable = true, updatable = true, length = 33)
    private String ensinoSuperior;

    @Basic
    @Column(name = "FazCursoFora", nullable = true, insertable = true, updatable = true, length = 50)
    private String fazCursoFora;

    @Basic
    @Column(name = "IESCursoFora", nullable = true, insertable = true, updatable = true, length = 50)
    private String iesCursoFora;
    
    @Basic
    @Column(name = "MensIESCursoFora", nullable = true, insertable = true, updatable = true, precision = 4)
    private BigDecimal mensIesCursoFora;
    
    @Basic
    @Column(name = "FezOutroCurso", nullable = true, insertable = true, updatable = true, length = 50)
    private String fezOutroCurso;

    @Basic
    @Column(name = "IESOutroCurso", nullable = true, insertable = true, updatable = true, length = 50)
    private String iesOutroCurso;

    @Basic
    @Column(name = "ConcluiuOutroCurso", nullable = true, insertable = true, updatable = true, length = 3)
    private String concluiuOutroCurso;

    @Basic
    @Column(name = "OutroCursoNaoConcluido", nullable = true, insertable = true, updatable = true)
    private String outroCursoNaoConcluido;

    @Basic
    @Column(name = "TGM", nullable = true, insertable = true, updatable = true)
    private String tgm;

    @Basic
    @Column(name = "Instituicao", nullable = true, insertable = true, updatable = true, length = 50)
    private String instituicao;

    @Basic
    @Column(name = "Funcao", nullable = true, insertable = true, updatable = true, length = 30)
    private String funcao;

    @Basic
    @Column(name = "Remuneracao", nullable = true, insertable = true, updatable = true, precision = 4)
    private BigDecimal remuneracao;

    @Basic
    @Column(name = "EstaLicenciado", nullable = true, insertable = true, updatable = true, length = 21)
    private String estaLicenciado;

    @Basic
    @Column(name = "Atividade", nullable = true, insertable = true, updatable = true, length = 30)
    private String atividade;

    @Basic
    @Column(name = "RendaMensal", nullable = true, insertable = true, updatable = true, precision = 4)
    private BigDecimal rendaMensal;

    @Basic
    @Column(name = "DependeRenda", nullable = true, insertable = true, updatable = true, length = 3)
    private String dependeRenda;

    @Basic
    @Column(name = "AnoAposent", nullable = true, insertable = true, updatable = true)
    private Integer anoAposent;

    @Basic
    @Column(name = "ProfissaoExercida", nullable = true, insertable = true, updatable = true, length = 30)
    private String profissaoExercida;

    @Basic
    @Column(name = "MotivoAposent", nullable = true, insertable = true, updatable = true, length = 18)
    private String motivoAposent;

    @Basic
    @Column(name = "ValorAposent", nullable = true, insertable = true, updatable = true, precision = 4)
    private BigDecimal valorAposent;

    @Basic
    @Column(name = "AtividadeExercida", nullable = true, insertable = true, updatable = true, length = 30)
    private String atividadeExercida;

    @Basic
    @Column(name = "PensaoVitaliciaAluno", nullable = true, insertable = true, updatable = true, precision = 4)
    private BigDecimal pensaoVitaliciaAluno;

    @Basic
    @Column(name = "BolsaGraduacao", nullable = true, insertable = true, updatable = true, length = 3)
    private String bolsaGraduacao;

    @Basic
    @Column(name = "ValorBolsaPos", nullable = true, insertable = true, updatable = true, precision = 4)
    private BigDecimal valorBolsaPos;

    @Basic
    @Column(name = "PoderaReceber", nullable = true, insertable = true, updatable = true, length = 26)
    private String poderaReceber;

    @Basic
    @Column(name = "PorQue", nullable = true, insertable = true, updatable = true, length = 50)
    private String porQue;

    @Basic
    @Column(name = "ValorMesada", nullable = true, insertable = true, updatable = true, precision = 4)
    private BigDecimal valorMesada;

    @Basic
    @Column(name = "DepDestaRenda", nullable = true, insertable = true, updatable = true, length = 12)
    private String depDestaRenda;

    @Basic
    @Column(name = "ContribuiRendaFamiliar", nullable = true, insertable = true, updatable = true, length = 3)
    private String contribuiRendaFamiliar;

    @Basic
    @Column(name = "Endereco", nullable = true, insertable = true, updatable = true, length = 50)
    private String endereco;

    @Basic
    @Column(name = "Cidade", nullable = true, insertable = true, updatable = true, length = 30)
    private String cidade;

    @Basic
    @Column(name = "CEP", nullable = true, insertable = true, updatable = true, length = 8)
    private String cep;

    @Basic
    @Column(name = "Telefone", nullable = true, insertable = true, updatable = true, length = 30)
    private String telefone;

    @Basic
    @Column(name = "ComoVoceReside", nullable = true, insertable = true, updatable = true, length = 52)
    private String comoVoceReside;

    @Basic
    @Column(name = "CustoSuaMoradia", nullable = true, insertable = true, updatable = true, precision = 4)
    private BigDecimal custoSuaMoradia;

    @Basic
    @Column(name = "ComQuemVoceMora", nullable = true, insertable = true, updatable = true, length = 9)
    private String comQuemVoceMora;

    @Basic
    @Column(name = "Tempo", nullable = true, insertable = true, updatable = true)
    private Short tempo;

    @Basic
    @Column(name = "OutraSitSuaMoradia", nullable = true, insertable = true, updatable = true)
    private String outraSitSuaMoradia;

    @Basic
    @Column(name = "ComoSuaFamiliaReside", nullable = true, insertable = true, updatable = true, length = 30)
    private String comoSuaFamiliaReside;

    @Basic
    @Column(name = "PrestacaoFinanc", nullable = true, insertable = true, updatable = true, precision = 4)
    private BigDecimal prestacaoFinanc;

    @Basic
    @Column(name = "ValorAluguel", nullable = true, insertable = true, updatable = true, precision = 4)
    private BigDecimal valorAluguel;

    @Basic
    @Column(name = "Cedente", nullable = true, insertable = true, updatable = true, length = 30)
    private String cedente;

    @Basic
    @Column(name = "OutraSitMoradiaSuaFamilia", nullable = true, insertable = true, updatable = true)
    private String outraSitMoradiaSuaFamilia;

    @Basic
    @Column(name = "EstadoCivil", nullable = true, insertable = true, updatable = true, length = 66)
    private String estadoCivil;

    @Basic
    @Column(name = "FilhosVivemCom", nullable = true, insertable = true, updatable = true, length = 25)
    private String filhosVivemCom;

    @Basic
    @Column(name = "RecebePensao", nullable = true, insertable = true, updatable = true, length = 3)
    private String recebePensao;

    @Basic
    @Column(name = "NomePai", nullable = true, insertable = true, updatable = true, length = 50)
    private String nomePai;

    @Basic
    @Column(name = "IdadePai", nullable = true, insertable = true, updatable = true)
    private Short idadePai;

    @Basic
    @Column(name = "CPFPai", nullable = true, insertable = true, updatable = true, length = 11)
    private String cpfPai;

    @Basic
    @Column(name = "EnderecoPai", nullable = true, insertable = true, updatable = true, length = 50)
    private String enderecoPai;

    @Basic
    @Column(name = "CidadePai", nullable = true, insertable = true, updatable = true, length = 30)
    private String cidadePai;

    @Basic
    @Column(name = "UFPai", nullable = true, insertable = true, updatable = true, length = 2)
    private String ufPai;

    @Basic
    @Column(name = "CEPPai", nullable = true, insertable = true, updatable = true, length = 8)
    private String cepPai;

    @Basic
    @Column(name = "TelefonePai", nullable = true, insertable = true, updatable = true, length = 30)
    private String telefonePai;

    @Basic
    @Column(name = "GrauInstrucaoPai", nullable = true, insertable = true, updatable = true, length = 21)
    private String grauInstrucaoPai;

    @Basic
    @Column(name = "CursoSuperiorPai", nullable = true, insertable = true, updatable = true, length = 30)
    private String cursoSuperiorPai;

    @Basic
    @Column(name = "ProfissaoPai", nullable = true, insertable = true, updatable = true, length = 30)
    private String profissaoPai;

    @Basic
    @Column(name = "RemuneracaoPai", nullable = true, insertable = true, updatable = true, precision = 4)
    private BigDecimal remuneracaoPai;

    @Basic
    @Column(name = "AnoAposentPai", nullable = true, insertable = true, updatable = true)
    private Integer anoAposentPai;

    @Basic
    @Column(name = "MotivoAposentPai", nullable = true, insertable = true, updatable = true, length = 18)
    private String motivoAposentPai;

    @Basic
    @Column(name = "ValorAposentPai", nullable = true, insertable = true, updatable = true, precision = 4)
    private BigDecimal valorAposentPai;

    @Basic
    @Column(name = "LocalTrabPai", nullable = true, insertable = true, updatable = true, length = 50)
    private String localTrabPai;

    @Basic
    @Column(name = "AnoSeparacao", nullable = true, insertable = true, updatable = true)
    private Integer anoSeparacao;

    @Basic
    @Column(name = "Legalizada", nullable = true, insertable = true, updatable = true, length = 3)
    private String legalizada;

    @Basic
    @Column(name = "ValorPensaoMae", nullable = true, insertable = true, updatable = true, precision = 4)
    private BigDecimal valorPensaoMae;

    @Basic
    @Column(name = "PensaoVitaliciaPai", nullable = true, insertable = true, updatable = true, precision = 4)
    private BigDecimal pensaoVitaliciaPai;

    @Basic
    @Column(name = "ProfisCompanheiraPai", nullable = true, insertable = true, updatable = true, length = 30)
    private String profisCompanheiraPai;

    @Basic
    @Column(name = "RemCompanheiraPai", nullable = true, insertable = true, updatable = true, precision = 4)
    private BigDecimal remCompanheiraPai;

    @Basic
    @Column(name = "OutAtivCompRendaPai", nullable = true, insertable = true, updatable = true)
    private String outAtivCompRendaPai;

    @Basic
    @Column(name = "RemMediaMensalPai", nullable = true, insertable = true, updatable = true, precision = 4)
    private BigDecimal remMediaMensalPai;

    @Basic
    @Column(name = "NomeMae", nullable = true, insertable = true, updatable = true, length = 50)
    private String nomeMae;

    @Basic
    @Column(name = "IdadeMae", nullable = true, insertable = true, updatable = true)
    private Short idadeMae;

    @Basic
    @Column(name = "CPFMae", nullable = true, insertable = true, updatable = true, length = 11)
    private String cpfMae;

    @Basic
    @Column(name = "EnderecoMae", nullable = true, insertable = true, updatable = true, length = 50)
    private String enderecoMae;

    @Basic
    @Column(name = "CidadeMae", nullable = true, insertable = true, updatable = true, length = 30)
    private String cidadeMae;

    @Basic
    @Column(name = "UFMae", nullable = true, insertable = true, updatable = true, length = 2)
    private String ufMae;

    @Basic
    @Column(name = "CEPMae", nullable = true, insertable = true, updatable = true, length = 8)
    private String cepMae;

    @Basic
    @Column(name = "TelefoneMae", nullable = true, insertable = true, updatable = true, length = 30)
    private String telefoneMae;

    @Basic
    @Column(name = "GrauInstrucaoMae", nullable = true, insertable = true, updatable = true, length = 20)
    private String grauInstrucaoMae;

    @Basic
    @Column(name = "CursoSuperiorMae", nullable = true, insertable = true, updatable = true, length = 30)
    private String cursoSuperiorMae;

    @Basic
    @Column(name = "ProfissaoMae", nullable = true, insertable = true, updatable = true, length = 30)
    private String profissaoMae;

    @Basic
    @Column(name = "RemuneracaoMae", nullable = true, insertable = true, updatable = true, precision = 4)
    private BigDecimal remuneracaoMae;

    @Basic
    @Column(name = "AnoAposentMae", nullable = true, insertable = true, updatable = true)
    private Integer anoAposentMae;

    @Basic
    @Column(name = "MotivoAposentMae", nullable = true, insertable = true, updatable = true, length = 18)
    private String motivoAposentMae;

    @Basic
    @Column(name = "ValorAposentMae", nullable = true, insertable = true, updatable = true, precision = 4)
    private BigDecimal valorAposentMae;

    @Basic
    @Column(name = "LocalTrabMae", nullable = true, insertable = true, updatable = true, length = 50)
    private String localTrabMae;

    @Basic
    @Column(name = "ValorPensaoPai", nullable = true, insertable = true, updatable = true, precision = 4)
    private BigDecimal valorPensaoPai;

    @Basic
    @Column(name = "PensaoVitaliciaMae", nullable = true, insertable = true, updatable = true, precision = 4)
    private BigDecimal pensaoVitaliciaMae;

    @Basic
    @Column(name = "ProfisCompanheiroMae", nullable = true, insertable = true, updatable = true, length = 30)
    private String profisCompanheiroMae;

    @Basic
    @Column(name = "RemCompanheiroMae", nullable = true, insertable = true, updatable = true, precision = 4)
    private BigDecimal remCompanheiroMae;

    @Basic
    @Column(name = "OutAtivCompRendaMae", nullable = true, insertable = true, updatable = true)
    private String outAtivCompRendaMae;

    @Basic
    @Column(name = "RemMediaMensalMae", nullable = true, insertable = true, updatable = true, precision = 4)
    private BigDecimal remMediaMensalMae;

    @Basic
    @Column(name = "NomeMantCon", nullable = true, insertable = true, updatable = true, length = 50)
    private String nomeMantCon;

    @Basic
    @Column(name = "IdadeMantCon", nullable = true, insertable = true, updatable = true)
    private Short idadeMantCon;

    @Basic
    @Column(name = "CPFMantCon", nullable = true, insertable = true, updatable = true, length = 11)
    private String cpfMantCon;

    @Basic
    @Column(name = "EnderecoMantCon", nullable = true, insertable = true, updatable = true, length = 50)
    private String enderecoMantCon;

    @Basic
    @Column(name = "CidadeMantCon", nullable = true, insertable = true, updatable = true, length = 30)
    private String cidadeMantCon;

    @Basic
    @Column(name = "UFMantCon", nullable = true, insertable = true, updatable = true, length = 2)
    private String ufMantCon;

    @Basic
    @Column(name = "CEPMantCon", nullable = true, insertable = true, updatable = true, length = 8)
    private String cepMantCon;

    @Basic
    @Column(name = "TelefoneMantCon", nullable = true, insertable = true, updatable = true, length = 30)
    private String telefoneMantCon;

    @Basic
    @Column(name = "GrauInstrucaoMantCon", nullable = true, insertable = true, updatable = true, length = 20)
    private String grauInstrucaoMantCon;

    @Basic
    @Column(name = "CursoSuperiorMantCon", nullable = true, insertable = true, updatable = true, length = 30)
    private String cursoSuperiorMantCon;

    @Basic
    @Column(name = "ProfissaoMantCon", nullable = true, insertable = true, updatable = true, length = 30)
    private String profissaoMantCon;

    @Basic
    @Column(name = "RemuneracaoMantCon", nullable = true, insertable = true, updatable = true, precision = 4)
    private BigDecimal remuneracaoMantCon;

    @Basic
    @Column(name = "LocalTrabMantCon", nullable = true, insertable = true, updatable = true, length = 50)
    private String localTrabMantCon;

    @Basic
    @Column(name = "AnoAposentMantCon", nullable = true, insertable = true, updatable = true)
    private Integer anoAposentMantCon;

    @Basic
    @Column(name = "MotivoAposentMantCon", nullable = true, insertable = true, updatable = true, length = 18)
    private String motivoAposentMantCon;

    @Basic
    @Column(name = "ValorAposentMantCon", nullable = true, insertable = true, updatable = true, precision = 4)
    private BigDecimal valorAposentMantCon;

    @Basic
    @Column(name = "AnoSeparacaoMantCon", nullable = true, insertable = true, updatable = true)
    private Integer anoSeparacaoMantCon;

    @Basic
    @Column(name = "LegalizadaMantCon", nullable = true, insertable = true, updatable = true, length = 3)
    private String legalizadaMantCon;

    @Basic
    @Column(name = "ValorPensaoMantCon", nullable = true, insertable = true, updatable = true, precision = 4)
    private BigDecimal valorPensaoMantCon;

    @Basic
    @Column(name = "PensaoVitaliciaMantCon", nullable = true, insertable = true, updatable = true, precision = 4)
    private BigDecimal pensaoVitaliciaMantCon;

    @Basic
    @Column(name = "ProfisCompanheiroMantCon", nullable = true, insertable = true, updatable = true, length = 30)
    private String profisCompanheiroMantCon;

    @Basic
    @Column(name = "RemCompanheiroMantCon", nullable = true, insertable = true, updatable = true, precision = 4)
    private BigDecimal remCompanheiroMantCon;

    @Basic
    @Column(name = "GrauParentesco", nullable = true, insertable = true, updatable = true, length = 30)
    private String grauParentesco;

    @Basic
    @Column(name = "OutAtivCompRendaMantCon", nullable = true, insertable = true, updatable = true)
    private String outAtivCompRendaMantCon;

    @Basic
    @Column(name = "RemMediaMensalMantCon", nullable = true, insertable = true, updatable = true, precision = 4)
    private BigDecimal remMediaMensalMantCon;

    @Basic
    @Column(name = "Apartamento", nullable = true, insertable = true, updatable = true, length = 21)
    private String apartamento;

    @Basic
    @Column(name = "Chacara", nullable = true, insertable = true, updatable = true, length = 43)
    private String chacara;

    @Basic
    @Column(name = "Terreno", nullable = true, insertable = true, updatable = true, length = 21)
    private String terreno;

    @Basic
    @Column(name = "ComercialIndustrial", nullable = true, insertable = true, updatable = true, length = 21)
    private String comercialIndustrial;

    @Basic
    @Column(name = "AspiradorPo", nullable = true, insertable = true, updatable = true, length = 6)
    private String aspiradorPo;

    @Basic
    @Column(name = "Computador", nullable = true, insertable = true, updatable = true, length = 6)
    private String computador;

    @Basic
    @Column(name = "Freezer", nullable = true, insertable = true, updatable = true, length = 6)
    private String freezer;

    @Basic
    @Column(name = "Geladeira", nullable = true, insertable = true, updatable = true, length = 6)
    private String geladeira;

    @Basic
    @Column(name = "MaqLavarRoupa", nullable = true, insertable = true, updatable = true, length = 6)
    private String maqLavarRoupa;

    @Basic
    @Column(name = "Radio", nullable = true, insertable = true, updatable = true, length = 6)
    private String radio;

    @Basic
    @Column(name = "TVCores", nullable = true, insertable = true, updatable = true, length = 6)
    private String tvCores;

    @Basic
    @Column(name = "TVCabo", nullable = true, insertable = true, updatable = true, length = 6)
    private String tvCabo;

    @Basic
    @Column(name = "VideoCassete", nullable = true, insertable = true, updatable = true, length = 6)
    private String videoCassete;

    @Basic
    @Column(name = "VeiculoBens", nullable = true, insertable = true, updatable = true)
    private String veiculoBens;

    @Basic
    @Column(name = "TelefoneBens", nullable = true, insertable = true, updatable = true)
    private String telefoneBens;

    @Basic
    @Column(name = "MeioTransporteSem", nullable = true, insertable = true, updatable = true, length = 68)
    private String meioTransporteSem;

    @Basic
    @Column(name = "VeicTransporteSem", nullable = true, insertable = true, updatable = true, length = 88)
    private String veicTransporteSem;

    @Basic
    @Column(name = "EmpregMensalista", nullable = true, insertable = true, updatable = true, length = 6)
    private String empregMensalista;

    @Basic
    @Column(name = "Banheiro", nullable = true, insertable = true, updatable = true, length = 6)
    private String banheiro;

    @Basic
    @Column(name = "PessoaDoencaGrave", nullable = true, insertable = true, updatable = true, length = 1450)
    private String pessoaDoencaGrave;

    @Basic
    @Column(name = "OutrosDepDDS", nullable = true, insertable = true, updatable = true, length = 1040)
    private String outrosDepDds;

    @Basic
    @Column(name = "GrupoFamiliar", nullable = true, insertable = true, updatable = true, length = 2110)
    private String grupoFamiliar;

    @Basic
    @Column(name = "Justificativa", nullable = true, insertable = true, updatable = true)
    private String justificativa;

    @Basic
    @Column(name = "Situacao", nullable = true, insertable = true, updatable = true)
    private Byte situacao;

    @Override
	public boolean equals(Object otherObject) {
		if (otherObject == this) {
			return true;
		}
		if (otherObject == null || !(otherObject instanceof EstudosSocioEconomicos)) {
			return false;
		}
		return false;
	}

    public String getDenominacao() {
		return aluno + semestreAno;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aluno == null) ? 0 : aluno.hashCode());
		result = prime * result + ((semestreAno == null) ? 0 : semestreAno.hashCode());
		return result;
	}

	public String toString() {
		return "tabela = EstudosSocioEconomicos , denominacao = " + ((getDenominacao() == null) ? "null" : getDenominacao().toString());
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

	public Timestamp getData() {
		return data;
	}

	public void setData(Timestamp data) {
		this.data = data;
	}

	public Byte getMotivo() {
		return motivo;
	}

	public void setMotivo(Byte motivo) {
		this.motivo = motivo;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public String getIsencaoTxVestibular() {
		return isencaoTxVestibular;
	}

	public void setIsencaoTxVestibular(String isencaoTxVestibular) {
		this.isencaoTxVestibular = isencaoTxVestibular;
	}

	public String getTeveAbatimento() {
		return teveAbatimento;
	}

	public void setTeveAbatimento(String teveAbatimento) {
		this.teveAbatimento = teveAbatimento;
	}

	public String getRaca() {
		return raca;
	}

	public void setRaca(String raca) {
		this.raca = raca;
	}

	public String getEnsinoMedio() {
		return ensinoMedio;
	}

	public void setEnsinoMedio(String ensinoMedio) {
		this.ensinoMedio = ensinoMedio;
	}

	public String getEscolaCidade() {
		return escolaCidade;
	}

	public void setEscolaCidade(String escolaCidade) {
		this.escolaCidade = escolaCidade;
	}

	public String getEscolaNome() {
		return escolaNome;
	}

	public void setEscolaNome(String escolaNome) {
		this.escolaNome = escolaNome;
	}

	public String getEscolaUf() {
		return escolaUf;
	}

	public void setEscolaUf(String escolaUf) {
		this.escolaUf = escolaUf;
	}

	public String getPreVestibular() {
		return preVestibular;
	}

	public void setPreVestibular(String preVestibular) {
		this.preVestibular = preVestibular;
	}

	public String getEnsinoSuperior() {
		return ensinoSuperior;
	}

	public void setEnsinoSuperior(String ensinoSuperior) {
		this.ensinoSuperior = ensinoSuperior;
	}

	public String getFazCursoFora() {
		return fazCursoFora;
	}

	public void setFazCursoFora(String fazCursoFora) {
		this.fazCursoFora = fazCursoFora;
	}

	public String getIesCursoFora() {
		return iesCursoFora;
	}

	public void setIesCursoFora(String iesCursoFora) {
		this.iesCursoFora = iesCursoFora;
	}

	public BigDecimal getMensIesCursoFora() {
		return mensIesCursoFora;
	}

	public void setMensIesCursoFora(BigDecimal mensIesCursoFora) {
		this.mensIesCursoFora = mensIesCursoFora;
	}

	public String getFezOutroCurso() {
		return fezOutroCurso;
	}

	public void setFezOutroCurso(String fezOutroCurso) {
		this.fezOutroCurso = fezOutroCurso;
	}

	public String getIesOutroCurso() {
		return iesOutroCurso;
	}

	public void setIesOutroCurso(String iesOutroCurso) {
		this.iesOutroCurso = iesOutroCurso;
	}

	public String getConcluiuOutroCurso() {
		return concluiuOutroCurso;
	}

	public void setConcluiuOutroCurso(String concluiuOutroCurso) {
		this.concluiuOutroCurso = concluiuOutroCurso;
	}

	public String getOutroCursoNaoConcluido() {
		return outroCursoNaoConcluido;
	}

	public void setOutroCursoNaoConcluido(String outroCursoNaoConcluido) {
		this.outroCursoNaoConcluido = outroCursoNaoConcluido;
	}

	public String getTgm() {
		return tgm;
	}

	public void setTgm(String tgm) {
		this.tgm = tgm;
	}

	public String getInstituicao() {
		return instituicao;
	}

	public void setInstituicao(String instituicao) {
		this.instituicao = instituicao;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public BigDecimal getRemuneracao() {
		return remuneracao;
	}

	public void setRemuneracao(BigDecimal remuneracao) {
		this.remuneracao = remuneracao;
	}

	public String getEstaLicenciado() {
		return estaLicenciado;
	}

	public void setEstaLicenciado(String estaLicenciado) {
		this.estaLicenciado = estaLicenciado;
	}

	public String getAtividade() {
		return atividade;
	}

	public void setAtividade(String atividade) {
		this.atividade = atividade;
	}

	public BigDecimal getRendaMensal() {
		return rendaMensal;
	}

	public void setRendaMensal(BigDecimal rendaMensal) {
		this.rendaMensal = rendaMensal;
	}

	public String getDependeRenda() {
		return dependeRenda;
	}

	public void setDependeRenda(String dependeRenda) {
		this.dependeRenda = dependeRenda;
	}

	public Integer getAnoAposent() {
		return anoAposent;
	}

	public void setAnoAposent(Integer anoAposent) {
		this.anoAposent = anoAposent;
	}

	public String getProfissaoExercida() {
		return profissaoExercida;
	}

	public void setProfissaoExercida(String profissaoExercida) {
		this.profissaoExercida = profissaoExercida;
	}

	public String getMotivoAposent() {
		return motivoAposent;
	}

	public void setMotivoAposent(String motivoAposent) {
		this.motivoAposent = motivoAposent;
	}

	public BigDecimal getValorAposent() {
		return valorAposent;
	}

	public void setValorAposent(BigDecimal valorAposent) {
		this.valorAposent = valorAposent;
	}

	public String getAtividadeExercida() {
		return atividadeExercida;
	}

	public void setAtividadeExercida(String atividadeExercida) {
		this.atividadeExercida = atividadeExercida;
	}

	public BigDecimal getPensaoVitaliciaAluno() {
		return pensaoVitaliciaAluno;
	}

	public void setPensaoVitaliciaAluno(BigDecimal pensaoVitaliciaAluno) {
		this.pensaoVitaliciaAluno = pensaoVitaliciaAluno;
	}

	public String getBolsaGraduacao() {
		return bolsaGraduacao;
	}

	public void setBolsaGraduacao(String bolsaGraduacao) {
		this.bolsaGraduacao = bolsaGraduacao;
	}

	public BigDecimal getValorBolsaPos() {
		return valorBolsaPos;
	}

	public void setValorBolsaPos(BigDecimal valorBolsaPos) {
		this.valorBolsaPos = valorBolsaPos;
	}

	public String getPoderaReceber() {
		return poderaReceber;
	}

	public void setPoderaReceber(String poderaReceber) {
		this.poderaReceber = poderaReceber;
	}

	public String getPorQue() {
		return porQue;
	}

	public void setPorQue(String porQue) {
		this.porQue = porQue;
	}

	public BigDecimal getValorMesada() {
		return valorMesada;
	}

	public void setValorMesada(BigDecimal valorMesada) {
		this.valorMesada = valorMesada;
	}

	public String getDepDestaRenda() {
		return depDestaRenda;
	}

	public void setDepDestaRenda(String depDestaRenda) {
		this.depDestaRenda = depDestaRenda;
	}

	public String getContribuiRendaFamiliar() {
		return contribuiRendaFamiliar;
	}

	public void setContribuiRendaFamiliar(String contribuiRendaFamiliar) {
		this.contribuiRendaFamiliar = contribuiRendaFamiliar;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getComoVoceReside() {
		return comoVoceReside;
	}

	public void setComoVoceReside(String comoVoceReside) {
		this.comoVoceReside = comoVoceReside;
	}

	public BigDecimal getCustoSuaMoradia() {
		return custoSuaMoradia;
	}

	public void setCustoSuaMoradia(BigDecimal custoSuaMoradia) {
		this.custoSuaMoradia = custoSuaMoradia;
	}

	public String getComQuemVoceMora() {
		return comQuemVoceMora;
	}

	public void setComQuemVoceMora(String comQuemVoceMora) {
		this.comQuemVoceMora = comQuemVoceMora;
	}

	public Short getTempo() {
		return tempo;
	}

	public void setTempo(Short tempo) {
		this.tempo = tempo;
	}

	public String getOutraSitSuaMoradia() {
		return outraSitSuaMoradia;
	}

	public void setOutraSitSuaMoradia(String outraSitSuaMoradia) {
		this.outraSitSuaMoradia = outraSitSuaMoradia;
	}

	public String getComoSuaFamiliaReside() {
		return comoSuaFamiliaReside;
	}

	public void setComoSuaFamiliaReside(String comoSuaFamiliaReside) {
		this.comoSuaFamiliaReside = comoSuaFamiliaReside;
	}

	public BigDecimal getPrestacaoFinanc() {
		return prestacaoFinanc;
	}

	public void setPrestacaoFinanc(BigDecimal prestacaoFinanc) {
		this.prestacaoFinanc = prestacaoFinanc;
	}

	public BigDecimal getValorAluguel() {
		return valorAluguel;
	}

	public void setValorAluguel(BigDecimal valorAluguel) {
		this.valorAluguel = valorAluguel;
	}

	public String getCedente() {
		return cedente;
	}

	public void setCedente(String cedente) {
		this.cedente = cedente;
	}

	public String getOutraSitMoradiaSuaFamilia() {
		return outraSitMoradiaSuaFamilia;
	}

	public void setOutraSitMoradiaSuaFamilia(String outraSitMoradiaSuaFamilia) {
		this.outraSitMoradiaSuaFamilia = outraSitMoradiaSuaFamilia;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getFilhosVivemCom() {
		return filhosVivemCom;
	}

	public void setFilhosVivemCom(String filhosVivemCom) {
		this.filhosVivemCom = filhosVivemCom;
	}

	public String getRecebePensao() {
		return recebePensao;
	}

	public void setRecebePensao(String recebePensao) {
		this.recebePensao = recebePensao;
	}

	public String getNomePai() {
		return nomePai;
	}

	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}

	public Short getIdadePai() {
		return idadePai;
	}

	public void setIdadePai(Short idadePai) {
		this.idadePai = idadePai;
	}

	public String getCpfPai() {
		return cpfPai;
	}

	public void setCpfPai(String cpfPai) {
		this.cpfPai = cpfPai;
	}

	public String getEnderecoPai() {
		return enderecoPai;
	}

	public void setEnderecoPai(String enderecoPai) {
		this.enderecoPai = enderecoPai;
	}

	public String getCidadePai() {
		return cidadePai;
	}

	public void setCidadePai(String cidadePai) {
		this.cidadePai = cidadePai;
	}

	public String getUfPai() {
		return ufPai;
	}

	public void setUfPai(String ufPai) {
		this.ufPai = ufPai;
	}

	public String getCepPai() {
		return cepPai;
	}

	public void setCepPai(String cepPai) {
		this.cepPai = cepPai;
	}

	public String getTelefonePai() {
		return telefonePai;
	}

	public void setTelefonePai(String telefonePai) {
		this.telefonePai = telefonePai;
	}

	public String getGrauInstrucaoPai() {
		return grauInstrucaoPai;
	}

	public void setGrauInstrucaoPai(String grauInstrucaoPai) {
		this.grauInstrucaoPai = grauInstrucaoPai;
	}

	public String getCursoSuperiorPai() {
		return cursoSuperiorPai;
	}

	public void setCursoSuperiorPai(String cursoSuperiorPai) {
		this.cursoSuperiorPai = cursoSuperiorPai;
	}

	public String getProfissaoPai() {
		return profissaoPai;
	}

	public void setProfissaoPai(String profissaoPai) {
		this.profissaoPai = profissaoPai;
	}

	public BigDecimal getRemuneracaoPai() {
		return remuneracaoPai;
	}

	public void setRemuneracaoPai(BigDecimal remuneracaoPai) {
		this.remuneracaoPai = remuneracaoPai;
	}

	public Integer getAnoAposentPai() {
		return anoAposentPai;
	}

	public void setAnoAposentPai(Integer anoAposentPai) {
		this.anoAposentPai = anoAposentPai;
	}

	public String getMotivoAposentPai() {
		return motivoAposentPai;
	}

	public void setMotivoAposentPai(String motivoAposentPai) {
		this.motivoAposentPai = motivoAposentPai;
	}

	public BigDecimal getValorAposentPai() {
		return valorAposentPai;
	}

	public void setValorAposentPai(BigDecimal valorAposentPai) {
		this.valorAposentPai = valorAposentPai;
	}

	public String getLocalTrabPai() {
		return localTrabPai;
	}

	public void setLocalTrabPai(String localTrabPai) {
		this.localTrabPai = localTrabPai;
	}

	public Integer getAnoSeparacao() {
		return anoSeparacao;
	}

	public void setAnoSeparacao(Integer anoSeparacao) {
		this.anoSeparacao = anoSeparacao;
	}

	public String getLegalizada() {
		return legalizada;
	}

	public void setLegalizada(String legalizada) {
		this.legalizada = legalizada;
	}

	public BigDecimal getValorPensaoMae() {
		return valorPensaoMae;
	}

	public void setValorPensaoMae(BigDecimal valorPensaoMae) {
		this.valorPensaoMae = valorPensaoMae;
	}

	public BigDecimal getPensaoVitaliciaPai() {
		return pensaoVitaliciaPai;
	}

	public void setPensaoVitaliciaPai(BigDecimal pensaoVitaliciaPai) {
		this.pensaoVitaliciaPai = pensaoVitaliciaPai;
	}

	public String getProfisCompanheiraPai() {
		return profisCompanheiraPai;
	}

	public void setProfisCompanheiraPai(String profisCompanheiraPai) {
		this.profisCompanheiraPai = profisCompanheiraPai;
	}

	public BigDecimal getRemCompanheiraPai() {
		return remCompanheiraPai;
	}

	public void setRemCompanheiraPai(BigDecimal remCompanheiraPai) {
		this.remCompanheiraPai = remCompanheiraPai;
	}

	public String getOutAtivCompRendaPai() {
		return outAtivCompRendaPai;
	}

	public void setOutAtivCompRendaPai(String outAtivCompRendaPai) {
		this.outAtivCompRendaPai = outAtivCompRendaPai;
	}

	public BigDecimal getRemMediaMensalPai() {
		return remMediaMensalPai;
	}

	public void setRemMediaMensalPai(BigDecimal remMediaMensalPai) {
		this.remMediaMensalPai = remMediaMensalPai;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}

	public Short getIdadeMae() {
		return idadeMae;
	}

	public void setIdadeMae(Short idadeMae) {
		this.idadeMae = idadeMae;
	}

	public String getCpfMae() {
		return cpfMae;
	}

	public void setCpfMae(String cpfMae) {
		this.cpfMae = cpfMae;
	}

	public String getEnderecoMae() {
		return enderecoMae;
	}

	public void setEnderecoMae(String enderecoMae) {
		this.enderecoMae = enderecoMae;
	}

	public String getCidadeMae() {
		return cidadeMae;
	}

	public void setCidadeMae(String cidadeMae) {
		this.cidadeMae = cidadeMae;
	}

	public String getUfMae() {
		return ufMae;
	}

	public void setUfMae(String ufMae) {
		this.ufMae = ufMae;
	}

	public String getCepMae() {
		return cepMae;
	}

	public void setCepMae(String cepMae) {
		this.cepMae = cepMae;
	}

	public String getTelefoneMae() {
		return telefoneMae;
	}

	public void setTelefoneMae(String telefoneMae) {
		this.telefoneMae = telefoneMae;
	}

	public String getGrauInstrucaoMae() {
		return grauInstrucaoMae;
	}

	public void setGrauInstrucaoMae(String grauInstrucaoMae) {
		this.grauInstrucaoMae = grauInstrucaoMae;
	}

	public String getCursoSuperiorMae() {
		return cursoSuperiorMae;
	}

	public void setCursoSuperiorMae(String cursoSuperiorMae) {
		this.cursoSuperiorMae = cursoSuperiorMae;
	}

	public String getProfissaoMae() {
		return profissaoMae;
	}

	public void setProfissaoMae(String profissaoMae) {
		this.profissaoMae = profissaoMae;
	}

	public BigDecimal getRemuneracaoMae() {
		return remuneracaoMae;
	}

	public void setRemuneracaoMae(BigDecimal remuneracaoMae) {
		this.remuneracaoMae = remuneracaoMae;
	}

	public Integer getAnoAposentMae() {
		return anoAposentMae;
	}

	public void setAnoAposentMae(Integer anoAposentMae) {
		this.anoAposentMae = anoAposentMae;
	}

	public String getMotivoAposentMae() {
		return motivoAposentMae;
	}

	public void setMotivoAposentMae(String motivoAposentMae) {
		this.motivoAposentMae = motivoAposentMae;
	}

	public BigDecimal getValorAposentMae() {
		return valorAposentMae;
	}

	public void setValorAposentMae(BigDecimal valorAposentMae) {
		this.valorAposentMae = valorAposentMae;
	}

	public String getLocalTrabMae() {
		return localTrabMae;
	}

	public void setLocalTrabMae(String localTrabMae) {
		this.localTrabMae = localTrabMae;
	}

	public BigDecimal getValorPensaoPai() {
		return valorPensaoPai;
	}

	public void setValorPensaoPai(BigDecimal valorPensaoPai) {
		this.valorPensaoPai = valorPensaoPai;
	}

	public BigDecimal getPensaoVitaliciaMae() {
		return pensaoVitaliciaMae;
	}

	public void setPensaoVitaliciaMae(BigDecimal pensaoVitaliciaMae) {
		this.pensaoVitaliciaMae = pensaoVitaliciaMae;
	}

	public String getProfisCompanheiroMae() {
		return profisCompanheiroMae;
	}

	public void setProfisCompanheiroMae(String profisCompanheiroMae) {
		this.profisCompanheiroMae = profisCompanheiroMae;
	}

	public BigDecimal getRemCompanheiroMae() {
		return remCompanheiroMae;
	}

	public void setRemCompanheiroMae(BigDecimal remCompanheiroMae) {
		this.remCompanheiroMae = remCompanheiroMae;
	}

	public String getOutAtivCompRendaMae() {
		return outAtivCompRendaMae;
	}

	public void setOutAtivCompRendaMae(String outAtivCompRendaMae) {
		this.outAtivCompRendaMae = outAtivCompRendaMae;
	}

	public BigDecimal getRemMediaMensalMae() {
		return remMediaMensalMae;
	}

	public void setRemMediaMensalMae(BigDecimal remMediaMensalMae) {
		this.remMediaMensalMae = remMediaMensalMae;
	}

	public String getNomeMantCon() {
		return nomeMantCon;
	}

	public void setNomeMantCon(String nomeMantCon) {
		this.nomeMantCon = nomeMantCon;
	}

	public Short getIdadeMantCon() {
		return idadeMantCon;
	}

	public void setIdadeMantCon(Short idadeMantCon) {
		this.idadeMantCon = idadeMantCon;
	}

	public String getCpfMantCon() {
		return cpfMantCon;
	}

	public void setCpfMantCon(String cpfMantCon) {
		this.cpfMantCon = cpfMantCon;
	}

	public String getEnderecoMantCon() {
		return enderecoMantCon;
	}

	public void setEnderecoMantCon(String enderecoMantCon) {
		this.enderecoMantCon = enderecoMantCon;
	}

	public String getCidadeMantCon() {
		return cidadeMantCon;
	}

	public void setCidadeMantCon(String cidadeMantCon) {
		this.cidadeMantCon = cidadeMantCon;
	}

	public String getUfMantCon() {
		return ufMantCon;
	}

	public void setUfMantCon(String ufMantCon) {
		this.ufMantCon = ufMantCon;
	}

	public String getCepMantCon() {
		return cepMantCon;
	}

	public void setCepMantCon(String cepMantCon) {
		this.cepMantCon = cepMantCon;
	}

	public String getTelefoneMantCon() {
		return telefoneMantCon;
	}

	public void setTelefoneMantCon(String telefoneMantCon) {
		this.telefoneMantCon = telefoneMantCon;
	}

	public String getGrauInstrucaoMantCon() {
		return grauInstrucaoMantCon;
	}

	public void setGrauInstrucaoMantCon(String grauInstrucaoMantCon) {
		this.grauInstrucaoMantCon = grauInstrucaoMantCon;
	}

	public String getCursoSuperiorMantCon() {
		return cursoSuperiorMantCon;
	}

	public void setCursoSuperiorMantCon(String cursoSuperiorMantCon) {
		this.cursoSuperiorMantCon = cursoSuperiorMantCon;
	}

	public String getProfissaoMantCon() {
		return profissaoMantCon;
	}

	public void setProfissaoMantCon(String profissaoMantCon) {
		this.profissaoMantCon = profissaoMantCon;
	}

	public BigDecimal getRemuneracaoMantCon() {
		return remuneracaoMantCon;
	}

	public void setRemuneracaoMantCon(BigDecimal remuneracaoMantCon) {
		this.remuneracaoMantCon = remuneracaoMantCon;
	}

	public String getLocalTrabMantCon() {
		return localTrabMantCon;
	}

	public void setLocalTrabMantCon(String localTrabMantCon) {
		this.localTrabMantCon = localTrabMantCon;
	}

	public Integer getAnoAposentMantCon() {
		return anoAposentMantCon;
	}

	public void setAnoAposentMantCon(Integer anoAposentMantCon) {
		this.anoAposentMantCon = anoAposentMantCon;
	}

	public String getMotivoAposentMantCon() {
		return motivoAposentMantCon;
	}

	public void setMotivoAposentMantCon(String motivoAposentMantCon) {
		this.motivoAposentMantCon = motivoAposentMantCon;
	}

	public BigDecimal getValorAposentMantCon() {
		return valorAposentMantCon;
	}

	public void setValorAposentMantCon(BigDecimal valorAposentMantCon) {
		this.valorAposentMantCon = valorAposentMantCon;
	}

	public Integer getAnoSeparacaoMantCon() {
		return anoSeparacaoMantCon;
	}

	public void setAnoSeparacaoMantCon(Integer anoSeparacaoMantCon) {
		this.anoSeparacaoMantCon = anoSeparacaoMantCon;
	}

	public String getLegalizadaMantCon() {
		return legalizadaMantCon;
	}

	public void setLegalizadaMantCon(String legalizadaMantCon) {
		this.legalizadaMantCon = legalizadaMantCon;
	}

	public BigDecimal getValorPensaoMantCon() {
		return valorPensaoMantCon;
	}

	public void setValorPensaoMantCon(BigDecimal valorPensaoMantCon) {
		this.valorPensaoMantCon = valorPensaoMantCon;
	}

	public BigDecimal getPensaoVitaliciaMantCon() {
		return pensaoVitaliciaMantCon;
	}

	public void setPensaoVitaliciaMantCon(BigDecimal pensaoVitaliciaMantCon) {
		this.pensaoVitaliciaMantCon = pensaoVitaliciaMantCon;
	}

	public String getProfisCompanheiroMantCon() {
		return profisCompanheiroMantCon;
	}

	public void setProfisCompanheiroMantCon(String profisCompanheiroMantCon) {
		this.profisCompanheiroMantCon = profisCompanheiroMantCon;
	}

	public BigDecimal getRemCompanheiroMantCon() {
		return remCompanheiroMantCon;
	}

	public void setRemCompanheiroMantCon(BigDecimal remCompanheiroMantCon) {
		this.remCompanheiroMantCon = remCompanheiroMantCon;
	}

	public String getGrauParentesco() {
		return grauParentesco;
	}

	public void setGrauParentesco(String grauParentesco) {
		this.grauParentesco = grauParentesco;
	}

	public String getOutAtivCompRendaMantCon() {
		return outAtivCompRendaMantCon;
	}

	public void setOutAtivCompRendaMantCon(String outAtivCompRendaMantCon) {
		this.outAtivCompRendaMantCon = outAtivCompRendaMantCon;
	}

	public BigDecimal getRemMediaMensalMantCon() {
		return remMediaMensalMantCon;
	}

	public void setRemMediaMensalMantCon(BigDecimal remMediaMensalMantCon) {
		this.remMediaMensalMantCon = remMediaMensalMantCon;
	}

	public String getApartamento() {
		return apartamento;
	}

	public void setApartamento(String apartamento) {
		this.apartamento = apartamento;
	}

	public String getChacara() {
		return chacara;
	}

	public void setChacara(String chacara) {
		this.chacara = chacara;
	}

	public String getTerreno() {
		return terreno;
	}

	public void setTerreno(String terreno) {
		this.terreno = terreno;
	}

	public String getComercialIndustrial() {
		return comercialIndustrial;
	}

	public void setComercialIndustrial(String comercialIndustrial) {
		this.comercialIndustrial = comercialIndustrial;
	}

	public String getAspiradorPo() {
		return aspiradorPo;
	}

	public void setAspiradorPo(String aspiradorPo) {
		this.aspiradorPo = aspiradorPo;
	}

	public String getComputador() {
		return computador;
	}

	public void setComputador(String computador) {
		this.computador = computador;
	}

	public String getFreezer() {
		return freezer;
	}

	public void setFreezer(String freezer) {
		this.freezer = freezer;
	}

	public String getGeladeira() {
		return geladeira;
	}

	public void setGeladeira(String geladeira) {
		this.geladeira = geladeira;
	}

	public String getMaqLavarRoupa() {
		return maqLavarRoupa;
	}

	public void setMaqLavarRoupa(String maqLavarRoupa) {
		this.maqLavarRoupa = maqLavarRoupa;
	}

	public String getRadio() {
		return radio;
	}

	public void setRadio(String radio) {
		this.radio = radio;
	}

	public String getTvCores() {
		return tvCores;
	}

	public void setTvCores(String tvCores) {
		this.tvCores = tvCores;
	}

	public String getTvCabo() {
		return tvCabo;
	}

	public void setTvCabo(String tvCabo) {
		this.tvCabo = tvCabo;
	}

	public String getVideoCassete() {
		return videoCassete;
	}

	public void setVideoCassete(String videoCassete) {
		this.videoCassete = videoCassete;
	}

	public String getVeiculoBens() {
		return veiculoBens;
	}

	public void setVeiculoBens(String veiculoBens) {
		this.veiculoBens = veiculoBens;
	}

	public String getTelefoneBens() {
		return telefoneBens;
	}

	public void setTelefoneBens(String telefoneBens) {
		this.telefoneBens = telefoneBens;
	}

	public String getMeioTransporteSem() {
		return meioTransporteSem;
	}

	public void setMeioTransporteSem(String meioTransporteSem) {
		this.meioTransporteSem = meioTransporteSem;
	}

	public String getVeicTransporteSem() {
		return veicTransporteSem;
	}

	public void setVeicTransporteSem(String veicTransporteSem) {
		this.veicTransporteSem = veicTransporteSem;
	}

	public String getEmpregMensalista() {
		return empregMensalista;
	}

	public void setEmpregMensalista(String empregMensalista) {
		this.empregMensalista = empregMensalista;
	}

	public String getBanheiro() {
		return banheiro;
	}

	public void setBanheiro(String banheiro) {
		this.banheiro = banheiro;
	}

	public String getPessoaDoencaGrave() {
		return pessoaDoencaGrave;
	}

	public void setPessoaDoencaGrave(String pessoaDoencaGrave) {
		this.pessoaDoencaGrave = pessoaDoencaGrave;
	}

	public String getOutrosDepDds() {
		return outrosDepDds;
	}

	public void setOutrosDepDds(String outrosDepDds) {
		this.outrosDepDds = outrosDepDds;
	}

	public String getGrupoFamiliar() {
		return grupoFamiliar;
	}

	public void setGrupoFamiliar(String grupoFamiliar) {
		this.grupoFamiliar = grupoFamiliar;
	}

	public String getJustificativa() {
		return justificativa;
	}

	public void setJustificativa(String justificativa) {
		this.justificativa = justificativa;
	}

	public Byte getSituacao() {
		return situacao;
	}

	public void setSituacao(Byte situacao) {
		this.situacao = situacao;
	}
	    
	
}
