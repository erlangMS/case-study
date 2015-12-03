package br.unb.sae.infra;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.erlangms.EmsRepository;
import br.unb.sae.model.Agendamento;
import br.unb.sae.model.AlunoSae;

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
	
	public int getQuantidadeAgendamentosMesmoHorario(Date dataHora) {
		final String sql = "SELECT COUNT(ag) FROM Agendamento ag WHERE ag.agenda.dataHora = :pDataHora";
		return getEntityManager()
			.createQuery(sql)
			.setParameter("pDataHora", dataHora)
			.getFirstResult();
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
		final String sql = "SELECT ag FROM Agendamento ag WHERE ag.aluno.nome like :nomeParte";
		return getEntityManager()
			.createQuery(sql)
			.setParameter("nomeParte", alunoSae.getNome()+"%")
			.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<Agendamento> pesquisarAgendamentoDoDia(Date dataDoDia){
		final String sql = "SELECT ag FROM Agendamento ag WHERE date(ag.agenda.dataHora) = date(:dataAutal)";
		return getEntityManager()
			.createQuery(sql)
			.setParameter("dataAutal", dataDoDia)
			.getResultList();
	}

}
