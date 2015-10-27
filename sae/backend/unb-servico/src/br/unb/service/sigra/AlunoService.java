package br.unb.service.sigra;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import br.erlangms.EmsServiceFacade;
import br.erlangms.IEmsRequest;
import br.unb.service.test.AllTests;
import br.unb.service.test.AlunoServiceTest;
import br.unb.web.sae.negocio.AlunoNegocio;
import br.unb.web.sae.pojo.Aluno;

@Singleton
@Startup
public class AlunoService extends EmsServiceFacade{
	
	@EJB
	private AlunoNegocio negocio;
	
	public Aluno findById(IEmsRequest request){
		Integer id = request.getParamAsInt("id");
		return negocio.findById(id);
	}
	
	public List<Aluno> find(IEmsRequest request){
		String filtro = request.getQuery("filtro");
		String fields = request.getQuery("fields");
		int limit_ini = request.getQueryAsInt("limit_ini");
		int limit_fim = request.getQueryAsInt("limit_fim");
		String sort = request.getQuery("sort");
		return negocio.find(filtro, fields, limit_ini, limit_fim, sort);
	}

	public Aluno insert(IEmsRequest request){
		AllTests t = new AllTests();
		AlunoServiceTest x = new AlunoServiceTest();
		
		Result result = JUnitCore.runClasses(AlunoServiceTest.class);
	      for (Failure failure : result.getFailures()) {
	         System.out.println(failure.toString());
	      }
	      System.out.println(result.wasSuccessful());
	      
	      
		final Aluno obj = (Aluno) request.getObject(Aluno.class);
		return negocio.insert(obj);
	}
	
	public Aluno update(IEmsRequest request){
		final int id = request.getParamAsInt("id");
		Aluno obj = negocio.findById(id);
		request.mergeObjectFromPayload(obj);
		return negocio.update(obj);
	}
	
	public int delete(IEmsRequest request){
		final int id = request.getParamAsInt("id");
		return negocio.delete(id);
	}
	

}
