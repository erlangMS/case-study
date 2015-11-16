package br.unb.sae.infra;

import java.util.Date;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.erlangms.EmsRepository;
import br.unb.sae.model.AlunoSae;
import br.unb.sae.model.Ocorrencia;

@Stateless
public class AlunoSaeRepository extends EmsRepository<AlunoSae> {

	@PersistenceContext(unitName = "service_context")
	public EntityManager saeContext;

	@Override
	public EntityManager getEntityManager() {
		return saeContext;
	}

	@Override
	public Class<AlunoSae> getClassOfModel() {
		return AlunoSae.class;
	}

	public Ocorrencia findOcorrenciaDoAlunoById(AlunoSae aluno, Integer idOcorrencia) {
		return (Ocorrencia) getEntityManager().createQuery("select this from Ocorrencia this where this.aluno=:pAluno and id=:pIdOcorrencia")
				.setParameter("pAluno", aluno)
				.setParameter("pIdOcorrencia", idOcorrencia)
				.getSingleResult();
	}

	public boolean existeOcorrenciaAbertoParaAluno(AlunoSae alunoSae, String semestreAno, Date dataInicio) {
		return false;
	}

	public boolean alunoAssinouTermoOcorrencia(AlunoSae alunoSae, String semestreAno) {
		return false;
	}

	public Ocorrencia adicionaOcorrenciaAluno(Ocorrencia ocorrencia) {
		getEntityManager().persist(ocorrencia);
		getEntityManager().flush();
		return ocorrencia;
	}

	public boolean removeOcorrencia(Integer ocorrencia) {
		return getEntityManager().createQuery("delete from Ocorrencia this where this.id = :pId")
			.setParameter("pId", ocorrencia)
			.executeUpdate() > 0;
	}

}
