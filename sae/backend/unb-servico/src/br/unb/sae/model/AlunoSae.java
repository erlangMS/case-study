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
import javax.persistence.Table;

import br.erlangms.EmsNotFoundException;
import br.erlangms.EmsValidationException;
import br.unb.sae.infra.SaeInfra;

@Entity
@Table(name="Aluno")
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
		EmsValidationException erro = new EmsValidationException();

		ocorrencia.validar();
		
		if (ocorrencia.getSemestreAno() != null) {
			if ((ocorrencia.getDataInicio() != null) &&
				 existeOcorrenciaAberto(ocorrencia.getSemestreAno(), ocorrencia.getDataInicio())){
					 erro.addError("O aluno já possui uma ocorrência aberta.");
			}
			
			if (assinouTermoOcorrencia(ocorrencia.getSemestreAno())){
				erro.addError("Aluno ainda não possui termo de concessão de BA assinado.");
			}
		}
		
		if (erro.getErrors().size() > 0){
			throw erro;
		}
		
		ocorrencia.setAluno(this);
		SaeInfra.getInstance().getAlunoSaeRepository().adicionaOcorrenciaAluno(ocorrencia);
	}
	
	public boolean removeOcorrencia(Integer idOcorrencia){
		return SaeInfra.getInstance().getAlunoSaeRepository().removeOcorrencia(idOcorrencia);
	}
	
	public List<Ocorrencia> getListaOcorrencia() {
		return listaOcorrencia;
	}
	public void setListaOcorrencia(List<Ocorrencia> listaOcorrencia) {
		this.listaOcorrencia = listaOcorrencia;
	}
	
	public boolean existeOcorrenciaAberto(final String semestreAno, final Date dataInicio){
		return SaeInfra.getInstance().getAlunoSaeRepository().existeOcorrenciaAbertoParaAluno(this, semestreAno, dataInicio);
	}
	
	public boolean assinouTermoOcorrencia(final String semestreAno){
		return SaeInfra.getInstance().getAlunoSaeRepository().alunoAssinouTermoOcorrencia(this, semestreAno);
	}

	public void validar(){
		
	}

	public Ocorrencia findOcorrenciaById(Integer idOcorrencia) {
		if (idOcorrencia != null){
			for (Ocorrencia o : getListaOcorrencia()){
				if (o.getId() == idOcorrencia){
					return o;
				}
			}
			throw new EmsNotFoundException("Ocorrencia não encontrada: "+ idOcorrencia.toString());
		}else{
			throw new IllegalArgumentException("Argumento idOcorrencia is null.");
		}
	}

	public void save() {
		validar();
		SaeInfra.getInstance().getAlunoSaeRepository().update(this);
	}

}
