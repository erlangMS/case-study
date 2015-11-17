package br.unb.sigra.facade;

import java.util.List;

import javax.ejb.Singleton;
import javax.ejb.Startup;

import br.erlangms.EmsServiceFacade;
import br.erlangms.IEmsRequest;
import br.unb.sigra.model.Aluno;
import br.unb.sigra.service.SigraApplication;

@Singleton
@Startup
public class AlunoServiceFacade extends EmsServiceFacade{
	
	public Aluno findById(IEmsRequest request){
		Integer id = request.getParamAsInt("id");
		return SigraApplication.getInstance()
			.getAlunoService()
			.findById(id);
	}
	
	public List<Aluno> find(IEmsRequest request){
		String filtro = request.getQuery("filtro");
		String fields = request.getQuery("fields");
		int limit_ini = request.getQueryAsInt("limit_ini");
		int limit_fim = request.getQueryAsInt("limit_fim");
		String sort = request.getQuery("sort");
		return SigraApplication.getInstance()
			.getAlunoService()
			.find(filtro, fields, limit_ini, limit_fim, sort);
	}

	public Aluno insert(IEmsRequest request){
		Aluno aluno = (Aluno) request.getObject(Aluno.class);
		return SigraApplication.getInstance()
			.getAlunoService()
			.insert(aluno);
	}
	
	public Aluno update(IEmsRequest request){
		int id = request.getParamAsInt("id");
		Aluno aluno = SigraApplication.getInstance().getAlunoService().findById(id);
		request.mergeObjectFromPayload(aluno);
		return SigraApplication.getInstance()
			.getAlunoService()
			.update(aluno);
	}
	
	public Boolean delete(IEmsRequest request){
		int id = request.getParamAsInt("id");
		return SigraApplication.getInstance()
			.getAlunoService()
			.delete(id);
	}
	

}
