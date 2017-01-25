package br.unb.questionario.infra;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import br.erlangms.EmsRepository;
import br.unb.questionario.model.RespostaPergunta;

@Stateless
public class RespostaRepository extends EmsRepository<RespostaPergunta> {
	
	private static String SQL_LISTA_RESPOSTAS_VINCULADAS_A_PERGUNTA;
	
	@Override
	public EntityManager getEntityManager() {
		return QuestionarioInfra.getInstance().getSaeContext();
	}

	@Override
	public Class<RespostaPergunta> getClassOfModel() {
		return RespostaPergunta.class;
	}

	@SuppressWarnings("unchecked")
	public List<RespostaPergunta> listaRespostasVinculadasAPergunta(Integer idPergunta) {
		return getEntityManager()
				.createQuery(SQL_LISTA_RESPOSTAS_VINCULADAS_A_PERGUNTA)
				.setParameter("idPergunta", idPergunta)
				.getResultList();
	}
	
	
	protected void createCacheSQL(){
		SQL_LISTA_RESPOSTAS_VINCULADAS_A_PERGUNTA = "SELECT this from RespostaPergunta this "+
		    											 "WHERE this.pergunta = :idPergunta"
		    											 + " AND this.ativa = true  ";
	
	}
	

}
