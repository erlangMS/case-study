package br.unb.questionario.infra;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import br.erlangms.EmsRepository;
import br.unb.questionario.model.CategoriaPergunta;
import br.unb.questionario.model.Pergunta;
import br.unb.questionario.model.Questionario;

@Stateless
public class CategoriaPerguntaRepository extends EmsRepository<CategoriaPergunta> {

	private static String SQL_LISTA_CATEGORIAS_VINCULADAS_AO_QUESTIONARIO;
	
	@Override
	public EntityManager getEntityManager() {
		return QuestionarioInfra.getInstance().getSaeContext();
	}

	@Override
	public Class<CategoriaPergunta> getClassOfModel() {
		return CategoriaPergunta.class;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<CategoriaPergunta> listaCategoriasVinculadasAoQuestionario(Integer idQuestionario){
		return getEntityManager()
			.createQuery(SQL_LISTA_CATEGORIAS_VINCULADAS_AO_QUESTIONARIO)
			.setParameter("idQuestionario", idQuestionario)
			.getResultList();
	}
	
	
	protected void createCacheSQL(){
		SQL_LISTA_CATEGORIAS_VINCULADAS_AO_QUESTIONARIO = "select this from CategoriaPergunta this "+
		    											 "where this.questionario = :idQuestionario";
	
	}

}
