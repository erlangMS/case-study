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
public class AlunoFacade extends EmsServiceFacade{
	
	public Aluno findById(IEmsRequest request){
		Integer id = request.getParamAsInt("id");
		return SigraApplication.getInstance()
			.getAlunoService()
			.findById(id);
	}
	
	public List<Aluno> find(IEmsRequest request){
		String filter = request.getQuery("filter");
		String fields = request.getQuery("fields");
		int offset = request.getQueryAsInt("offset");
		int limit = request.getQueryAsInt("limit");
		String sort = request.getQuery("sort");
		return SigraApplication.getInstance()
			.getAlunoService()
			.find(filter, fields, limit, offset, sort);
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
		Integer id = request.getParamAsInt("id");
		return SigraApplication.getInstance()
			.getAlunoService()
			.delete(id);
	}
	

}
