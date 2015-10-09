package br.unb.service.aluno;

import javax.ejb.Singleton;
import javax.ejb.Startup;

import br.erlangms.EmsServiceFacade;
import br.erlangms.IEmsRequest;
import br.erlangms.IEmsServiceFacade;

@Singleton
@Startup
public class AlunoService extends EmsServiceFacade implements IEmsServiceFacade{
	
	public Aluno findById(IEmsRequest request) {
		
		if(request.getParamAsInt("id") == 100) {
			Aluno aluno = new Aluno();
			aluno.setMatricula("100");
			aluno.setNome("Riane");
			aluno.setCpf("123");
			aluno.setIngresso(2014);
			aluno.setFormaIngresso(FormaIngresso.VESTIBULAR);
			return aluno;
		}
		
		return null;
		
	}
	
	enum FormaIngresso {
		VESTIBULAR, 
		PAS, 
		SISU,
		PORTADOR_DE_DIPLOMA
	};
	
	class Aluno {
		
		private String matricula;
		private String nome;
		private String cpf;
		private Integer ingresso;
		private FormaIngresso formaIngresso;
		
		
		public String getMatricula() {
			return matricula;
		}
		public void setMatricula(String matricula) {
			this.matricula = matricula;
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
		public Integer getIngresso() {
			return ingresso;
		}
		public void setIngresso(Integer ingresso) {
			this.ingresso = ingresso;
		}
		public FormaIngresso getFormaIngresso() {
			return formaIngresso;
		}
		public void setFormaIngresso(FormaIngresso formaIngresso) {
			this.formaIngresso = formaIngresso;
		}
		
		
		
	}

}
