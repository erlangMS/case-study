package br.unb.sae.facade;

import javax.ejb.Singleton;
import javax.ejb.Startup;

import br.erlangms.EmsJsonModelAdapter;
import br.erlangms.EmsNotFoundException;
import br.erlangms.EmsServiceFacade;
import br.erlangms.IEmsRequest;
import br.unb.sae.model.Agenda;
import br.unb.sae.model.Agendamento;
import br.unb.sae.model.AlunoSae;
import br.unb.sae.service.SaeApplication;

/**
 * Classe de fachada para Agendamento.
 * Contem métodos para incluir um novo agendamento e pesquisar agendamentos por dados do Aluno
 */
@Singleton
@Startup
public class AgendamentoAlunoFacade extends EmsServiceFacade{
	
	public Agendamento agendarEntrevista (IEmsRequest request) {
		
		//Cria um objeto Agendamento
		Agendamento agendamento = request.getObject(Agendamento.class, new EmsJsonModelAdapter() {
			
			//Cria objetos de referencia a Agenda e Aluno caso tenham sido informados os respectivos IDs
			@Override
			public Object findById(Class<?> classOfModel, Integer id) {
				if (classOfModel == Agenda.class) {
					return SaeApplication.getInstance()
						.getAgendaService()
						.findById(id);
				}
				else if (classOfModel == AlunoSae.class) {
					return SaeApplication.getInstance()
							.getAlunoService()
							.findById(id);
				}
				else {
					throw new EmsNotFoundException("Nao existe o atributo");
				}
			}
		});
		
		SaeApplication.getInstance()
			.getAgendamentoService()
			.agendarEntrevista(agendamento);
		
		return agendamento;
	}
	
	public boolean removeAgendamento(IEmsRequest request){
		final int id = request.getParamAsInt("id");
		return SaeApplication.getInstance()
			.getAgendamentoService()
			.removeAgendamento(id);
	}

}
