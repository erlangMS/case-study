package br.unb.service.autenticacao;

import javax.ejb.Singleton;
import javax.ejb.Startup;

import br.erlangms.EmsServiceFacade;

@Singleton
@Startup
public class UsuarioService extends EmsServiceFacade {
	//@EJB private IUsuarioNegocio usuarioNegocio;
	//@EJB private br.unb.web.sca.negocio.IUsuarioNegocio usuarioNegocio2;

	public UsuarioService() throws Exception {
		super();
	}

	/*public Usuario findById(IEmsRequest request){
		Integer id = request.getParamAsInt("id");
		return usuarioNegocio2.buscar(id);
	}

	public UsuarioVo autenticar(IEmsRequest request){
		String cpf = request.getQuery("cpf");
		String senha = request.getQuery("senha");
		try {
			return usuarioNegocio.autenticar(cpf, senha);
		} catch (Exception e) {
			return null;
		}
	}*/
	
}
