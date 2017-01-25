package br.unb.questionario.infra;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import br.erlangms.EmsRepository;
import br.unb.questionario.model.Opcao;

@Stateless
public class OpcaoRepository extends EmsRepository<Opcao> {
	
	private static String SQL_LISTA_OPCOES_VINCULADAS_A_PERGUNTA;
	
	@Override
	public EntityManager getEntityManager() {
		return QuestionarioInfra.getInstance().getSaeContext();
	}

	@Override
	public Class<Opcao> getClassOfModel() {
		return Opcao.class;
	}

	@SuppressWarnings("unchecked")
	public List<Opcao> listaOpcoesVinculadasAPergunta(Integer idPergunta) {
		return getEntityManager()
				.createQuery(SQL_LISTA_OPCOES_VINCULADAS_A_PERGUNTA)
				.setParameter("idPergunta", idPergunta)
				.getResultList();
	}
	
	
	protected void createCacheSQL(){
		SQL_LISTA_OPCOES_VINCULADAS_A_PERGUNTA = "SELECT this from Opcao this "+
		    											 "WHERE this.pergunta = :idPergunta"
		    											 + " AND this.ativa = true  ";
	
	}
	

}
