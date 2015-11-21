package br.unb.sae.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.erlangms.EmsValidationException;
import br.unb.sae.infra.SaeInfra;

@Entity
@Table(name="Aluno")
public class AlunoSae{

	@Id
    @Column(name = "codigoPessoa", nullable = false, insertable = true, updatable = true)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "bloqueado", nullable = false, insertable = true, updatable = true)
	private Boolean bloqueado;
	
	@Column(name = "nome", nullable = false, insertable = true, updatable = true)
	private String nome;

	@Column(name = "cpf", nullable = false, insertable = true, updatable = true)
	private String cpf;

	@Column(name = "senha", nullable = false, insertable = true, updatable = true)
	private String senha;
	
	@OneToMany(fetch=FetchType.EAGER, mappedBy="aluno", cascade=CascadeType.ALL)  
	private List<Ocorrencia> listaOcorrencia;

	@OneToMany(fetch=FetchType.EAGER, mappedBy="aluno", cascade=CascadeType.ALL)
	private List<AssinaturaTermoBa> listaAssinaturaTermoConcessaoValeAlimentacao;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setBloqueado(Boolean bloqueado) {
		this.bloqueado = bloqueado;
	}

	public Boolean getBloqueado() {
		return bloqueado;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public void registraOcorrencia(Ocorrencia ocorrencia){
		EmsValidationException erro = new EmsValidationException();

		ocorrencia.validar();
		
		if (ocorrencia.getSemestreAno() != null) {
			if ((ocorrencia.getDataInicio() != null) &&
				 existeOcorrenciaAberto(ocorrencia.getSemestreAno(), ocorrencia.getDataInicio())){
					 erro.addError("O aluno já possui uma ocorrência aberta.");
			}
			
			if (assinouTermoConcessaoValeAlimentacao(ocorrencia.getSemestreAno())){
				erro.addError("Aluno ainda não possui termo de concessão do benefício socioeconômico assinado.");
			}
		}
		
		if (erro.getErrors().size() > 0){
			throw erro;
		}
		
		ocorrencia.setAluno(this);

		SaeInfra.getInstance()
			.getAlunoSaeRepository()
			.insertOrUpdate(ocorrencia);
	}
	
	public boolean removeOcorrencia(Integer idOcorrencia){
		return SaeInfra.getInstance()
			.getAlunoSaeRepository()
			.delete(Ocorrencia.class, idOcorrencia);
	}
	
	public List<Ocorrencia> getListaOcorrencia() {
		return listaOcorrencia;
	}
	public void setListaOcorrencia(List<Ocorrencia> listaOcorrencia) {
		this.listaOcorrencia = listaOcorrencia;
	}
	
	public boolean existeOcorrenciaAberto(final String semestreAno, final Date dataInicio){
		return SaeInfra.getInstance()
			.getAlunoSaeRepository()
			.existeOcorrenciaAbertoParaAluno(this, semestreAno, dataInicio);
	}
	
	public boolean assinouTermoConcessaoValeAlimentacao(final String semestreAno){
		return SaeInfra.getInstance()
			.getAlunoSaeRepository()
			.assinouTermoConcessaoValeAlimentacao(this, semestreAno);
	}

	public AssinaturaTermoBa findAssinaturaTermoConcessaoValeAlimentacaoById(int idAssinatura) {
		return (AssinaturaTermoBa) SaeInfra.getInstance()
			.getAlunoSaeRepository()
			.findById(AssinaturaTermoBa.class, idAssinatura);
	}	

	public Ocorrencia findOcorrenciaById(Integer idOcorrencia) {
		return (Ocorrencia) SaeInfra.getInstance()
			.getAlunoSaeRepository()
			.findById(Ocorrencia.class, idOcorrencia);
	}

	public void assinaTermoConcessaoValeAlimentacao(AssinaturaTermoBa assinatura){
		assinatura.validar();
		if (!existeEstudoSocioeconomicoPontuadoComoParticipanteDoProgramaAssistenciaEstudantil()){
			throw new EmsValidationException("Aluno não possui estudo socioeconômico válido pontuado como Participante dos Programas de Assistência Estudantil.");
		}
		assinatura.setAluno(this);
		SaeInfra.getInstance()
			.getAlunoSaeRepository()
			.insertOrUpdate(assinatura);
	}
	
	private boolean existeEstudoSocioeconomicoPontuadoComoParticipanteDoProgramaAssistenciaEstudantil() {
		return true;
	}


	public List<AssinaturaTermoBa> getListaAssinaturaTermoConcessaoValeAlimentacao() {
		return listaAssinaturaTermoConcessaoValeAlimentacao;
	}

	public boolean removeAssinaturaTermoConcessaoValeAlimentacao(Integer idAssinatura) {
		return SaeInfra.getInstance()
			.getAlunoSaeRepository()
			.delete(AssinaturaTermoBa.class, idAssinatura);
	}
	
	public void validar(){
		
	}

}
