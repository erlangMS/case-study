package br.unb.sae.model;

import java.io.Serializable;
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

import br.erlangms.EmsValidationException;

@Entity
public class AlunoSae implements Serializable{

	private static final long serialVersionUID = 3641943651239114783L;

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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getBloqueado() {
		return bloqueado;
	}

	public void setBloqueado(Boolean bloqueado) {
		this.bloqueado = bloqueado;
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
	
	public void adicionaOcorrencia(Ocorrencia ocorrencia){
		if (ocorrencia == null){
			throw new EmsValidationException("Ocorrência inválida para o aluno.");
		}

		if (ocorrencia.getAluno() == null){
			throw new EmsValidationException("Ocorrência já pertence a um aluno.");
		}

		if (ocorrencia.getSemestreAno() == null){
			throw new EmsValidationException("Não foi informado semestre e ano na ocorrência.");
		}
		
		if (ocorrencia.getDataInicio() == null){
			throw new EmsValidationException("Não foi informado data de início na ocorrência.");
		}

		if (existeOcorrenciaAberto(ocorrencia.getSemestreAno(), ocorrencia.getDataInicio())){
			throw new EmsValidationException("O aluno já possui uma ocorrência aberta.");
		}
		
		if (assinouTermoOcorrencia(ocorrencia.getSemestreAno())){
			throw new EmsValidationException("Aluno não possui termo de concessão de BA assinado.");
		}
		
		ocorrencia.setAluno(this);
		listaOcorrencia.add(ocorrencia);
	}
	
	public void removeOcorrencia(Ocorrencia Ocorrencia){
		listaOcorrencia.remove(Ocorrencia);
	}
	
	public List<Ocorrencia> getListaOcorrencia() {
		return listaOcorrencia;
	}
	public void setListaOcorrencia(List<Ocorrencia> listaOcorrencia) {
		this.listaOcorrencia = listaOcorrencia;
	}
	
	public boolean existeOcorrenciaAberto(final String semestreAno, final Date dataInicio){
		// return InfraFactory.alunoSaeRepository.existeOcorrenciaAbertoParaAluno(this, semestreAno, dataInicio);
		return true;
	}
	
	public boolean assinouTermoOcorrencia(final String semestreAno){
		// return InfraFactory.alunoSaeRepository.alunoAssinouTermoOcorrencia(this, semestreAno);
		return true;
	}

	public void validar(){
		
	}
	
}
