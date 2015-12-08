package br.unb.sae.infra;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.erlangms.EmsRepository;
import br.unb.sae.model.Agenda;
import br.unb.sae.model.Agendamento;

import br.unb.sae.model.AlunoSae;

/**
 * Classe Repository para Agendamento.
 * Contem métodos para realizar consultas referentes a agendamentos.
 */
@Stateless
public class AgendamentoRepository extends EmsRepository<Agendamento> {
	
	@PersistenceContext(unitName = "service_context")
	public EntityManager saeContext;
	
	@Override
	public EntityManager getEntityManager() {
		return saeContext;
	}

	@Override
	public Class<Agendamento> getClassOfModel() {
		return Agendamento.class;
	}
	
	
	/**
	 * Método que consulta a quantidade de agendamentos já realizados para uma determinada agenda.
	 */
	public int getQuantidadeAgendamentosMesmoHorario(Agenda agenda) {
		final String sql = "SELECT COUNT(ag) FROM Agendamento ag WHERE ag.agenda.id = :pAgenda";

		//Como a instrução COUNT retorna apenas uma linha, deve-se utilizar o .getSingleResult()
		return ((Long)getEntityManager()
			.createQuery(sql)
			.setParameter("pAgenda", agenda.getId())
			.getSingleResult()).intValue();
		
	}

	
	/**
	 * Método que consulta se um aluno já está agendado para a mesma agenda.
	 */
	public boolean alunoJaAgendadoParaMesmaDataHora(AlunoSae aluno, Agenda agenda) { 
		final String sql = "SELECT ag FROM Agendamento ag WHERE ag.aluno.id = :pAluno AND ag.agenda.id = :pAgenda";

		//Se a lista não estiver vazia, retorna true
		return !getEntityManager()
			.createQuery(sql)
			.setParameter("pAluno", aluno.getId())
			.setParameter("pAgenda", agenda.getId())
			.getResultList().isEmpty();
		
	}

	
	@SuppressWarnings("unchecked")
	public List<Agendamento> pesquisarAgendamentoPorAlunoCPF(AlunoSae alunoSae){
		final String sql = "SELECT ag FROM Agendamento ag WHERE ag.aluno.cpf = :cpf";
		return getEntityManager()
			.createQuery(sql)
			.setParameter("cpf", alunoSae.getCpf())
			.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Agendamento> pesquisarAgendamentoPorAlunoPorParteNome(AlunoSae alunoSae){
		final String sql = "SELECT ag FROM Agendamento ag WHERE ag.aluno.nome LIKE :nomeParte";
		return getEntityManager()
			.createQuery(sql)
			.setParameter("nomeParte", alunoSae.getNome()+"%")
			.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Agendamento> pesquisarAgendamentoDoDia(Date dataDoDia){
		final String sql = "SELECT ag FROM Agendamento ag WHERE date(ag.agenda.datahora) = date(:data)";
		return getEntityManager()
			.createQuery(sql)
			.setParameter("data", dataDoDia)
			.getResultList();
	}

}
