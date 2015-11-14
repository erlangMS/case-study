package br.unb.sigra.facade;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import br.erlangms.EmsServiceFacade;
import br.erlangms.IEmsRequest;
import br.unb.sae.facade.SaeApplication;
import br.unb.sae.model.AlunoSae;

@Singleton
@Startup
public class AlunoServiceFacade extends EmsServiceFacade{
	
	@EJB private SaeApplication saeApplication;
	
	public AlunoSae findById(IEmsRequest request){
		Integer id = request.getParamAsInt("id");
		return saeApplication.getAlunoService().findById(id);
	}
	
//	public List<Aluno> find(IEmsRequest request){
//		String filtro = request.getQuery("filtro");
//		String fields = request.getQuery("fields");
//		int limit_ini = request.getQueryAsInt("limit_ini");
//		int limit_fim = request.getQueryAsInt("limit_fim");
//		String sort = request.getQuery("sort");
//		return saeApplication.getAlunoService().find(filtro, fields, limit_ini, limit_fim, sort);
//	}

//	public Aluno insert(IEmsRequest request){
//		final Aluno obj = (Aluno) request.getObject(Aluno.class);
//		return saeApplication.getAlunoService().insert(obj);
//	}
	
	public AlunoSae update(IEmsRequest request){
		final int id = request.getParamAsInt("id");
		AlunoSae obj = saeApplication.getAlunoService().findById(id);
		request.mergeObjectFromPayload(obj);
		return saeApplication.getAlunoService().update(obj);
	}
	
//	public int delete(IEmsRequest request){
//		final int id = request.getParamAsInt("id");
//		return saeApplication.getAlunoService().delete(id);
//	}
	

}
