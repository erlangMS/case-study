package br.unb.questionario.infra;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import br.erlangms.EmsRepository;
import br.unb.questionario.model.Pergunta;

@Stateless
public class PerguntaRepository extends EmsRepository<Pergunta> {
	
	private static String SQL_LISTA_PERGUNTAS_VINCULADAS_A_CATEGORIA;
	
	@Override
	public EntityManager getEntityManager() {
		return QuestionarioInfra.getInstance().getSaeContext();
	}

	@Override
	public Class<Pergunta> getClassOfModel() {
		return Pergunta.class;
	}

	@SuppressWarnings("unchecked")
	public List<Pergunta> listaPerguntasVincualadasACategoria(Integer idCategoria) {
		return getEntityManager()
				.createQuery(SQL_LISTA_PERGUNTAS_VINCULADAS_A_CATEGORIA)
				.setParameter("idCategoria", idCategoria)
				.getResultList();
	}

	
	protected void createCacheSQL(){
		SQL_LISTA_PERGUNTAS_VINCULADAS_A_CATEGORIA = "SELECT this from Pergunta this "+
		    											 "WHERE this.categoria = :idCategoria"
		    											 + " AND this.ativa = true";
	
	}


}
