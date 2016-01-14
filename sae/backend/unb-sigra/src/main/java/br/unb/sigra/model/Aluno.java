package br.unb.sigra.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.erlangms.EmsUtil;
import br.erlangms.EmsValidationException;

@Entity
@Table(name="TB_Aluno")
public class Aluno {

	@Id
    @Column(name = "AluMatricula", nullable = false, insertable = true, updatable = true)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "AluBloqueado", nullable = false)
	private Boolean bloqueado = false;
	
	@Column(name = "AluNome", nullable = false, length = 60)
	private String nome;

	@Column(name = "AluSexo", nullable = true)
	private String sexo;

	@Column(name = "AluCpf", nullable = false, unique = true)
	private String cpf;
	
	@Column(name = "AluSenha", nullable = false)
	private String senha;

	@Column(name = "AluDtNasc", nullable = true)
	private Date dataNascimento;

	
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


	public String getSexo() {
		return sexo;
	}


	public void setSexo(String sexo) {
		this.sexo = sexo;
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


	public Date getDataNascimento() {
		return dataNascimento;
	}


	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}


	public void validar(){
		EmsValidationException erro = new EmsValidationException();

		if(!EmsUtil.isFieldStrValid(getNome())){
			erro.addError("Informe o nome do aluno.");
		}
		
		if(!EmsUtil.isFieldStrValid(getCpf())){
			erro.addError("Informe o cpf do aluno.");
		}

		if(!EmsUtil.isFieldStrValid(getSenha())){
			erro.addError("Informe a senha do aluno.");
		}
		
		if(erro.getErrors().size() > 0) {
			throw erro;
		}
	}
}
