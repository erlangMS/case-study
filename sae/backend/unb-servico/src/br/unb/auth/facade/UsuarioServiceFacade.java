package br.unb.auth.facade;

import javax.ejb.Singleton;
import javax.ejb.Startup;

import br.erlangms.EmsServiceFacade;

@Singleton
@Startup
public class UsuarioServiceFacade extends EmsServiceFacade {
	//@EJB private IUsuarioservice usuarioservice;
	//@EJB private br.unb.web.sca.service.IUsuarioservice usuarioservice2;

	public UsuarioServiceFacade() throws Exception {
		super();
	}

	/*public Usuario findById(IEmsRequest request){
		Integer id = request.getParamAsInt("id");
		return usuarioservice2.buscar(id);
	}

	public UsuarioVo autenticar(IEmsRequest request){
		String cpf = request.getQuery("cpf");
		String senha = request.getQuery("senha");
		try {
			return usuarioservice.autenticar(cpf, senha);
		} catch (Exception e) {
			return null;
		}
	}*/
	
}
