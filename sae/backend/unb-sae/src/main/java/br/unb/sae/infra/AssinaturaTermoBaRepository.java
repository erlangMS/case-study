package br.unb.sae.infra;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import br.erlangms.EmsRepository;
import br.unb.sae.model.AssinaturaTermoBa;

@Stateless
public class AssinaturaTermoBaRepository extends EmsRepository<AssinaturaTermoBa> {
	
	private String sql_alunoAssinouTermoOcorrencia;
	
	public AssinaturaTermoBaRepository(){
	
	}
	
	@PersistenceContext(unitName = "service_context")
	public EntityManager saeContext;
	
	@Override
	public EntityManager getEntityManager() {
		return saeContext;
	}

	@Override
	public Class<AssinaturaTermoBa> getClassOfModel() {
		return AssinaturaTermoBa.class;
	}

	public boolean alunoAssinouTermoOcorrencia(Integer aluno, final String semestreAno) {
		try{
			getEntityManager().createQuery(sql_alunoAssinouTermoOcorrencia)
				.setParameter("pAluno",  aluno)
				.setParameter("pPeriodo", semestreAno)
				.getSingleResult();
			return true;
		}catch (NoResultException e){
			return false;
		}
	}

	protected void createCacheSQL() {
		sql_alunoAssinouTermoOcorrencia = new StringBuilder("select 1 from AssinaturaTermoBa this ")
												    .append("where this.aluno = :pAluno and ")
												    .append("      this.periodo = :pPeriodo").toString();
	}
	
}
