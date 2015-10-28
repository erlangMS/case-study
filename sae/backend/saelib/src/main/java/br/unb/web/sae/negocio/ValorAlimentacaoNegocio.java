package br.unb.web.sae.negocio;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import br.erlangms.EmsValidationException;
import br.unb.web.sae.persistencia.ValorAlimentacaoDAO;
import br.unb.web.sae.pojo.ValorAlimentacao;

@Stateless
public class ValorAlimentacaoNegocio {

	@EJB
	private ValorAlimentacaoDAO dao;

	public ValorAlimentacao findById(Integer id) {
		return dao.findById(id);
	}

	public List<ValorAlimentacao> find(String filtro, String fields, int limit_ini, int limit_fim, String sort) {
		return dao.find(filtro, fields, limit_ini, limit_fim, sort);
	}

	public ValorAlimentacao update(ValorAlimentacao obj) throws EmsValidationException{
		validar(obj);
		return dao.update(obj);
	}

	public ValorAlimentacao insert(ValorAlimentacao obj) {
		validar(obj);
		return dao.insert(obj);
	}
	
	private void validar(ValorAlimentacao obj) throws EmsValidationException {
		EmsValidationException validation = new EmsValidationException();
		
		if (obj.getCampus() == null){
			validation.addError("O campo campus é obrigatório.");
		}
		
		if (obj.getInicioVigencia() == null){
			validation.addError("O campo data de início de vigência é obrigatório.");
		}

		if(obj.getPagaBeneficio() == null) {
			validation.addError("Informe se paga benefício.");
		}
		
		if(obj.getValorBeneficio() == null) {
			validation.addError("O campo valor do benefício é obrigatório.");
		}

		if(obj.getFimVigencia() != null && 
		   obj.getInicioVigencia() != null && 
		   obj.getFimVigencia().before(obj.getInicioVigencia())) {
				validation.addError("A data do fim de vigência deve ser maior que a data de início de vigência.");
		}
		
		if (obj.getId() == null){
			if (dao.existePeriodoVigenciaAberto(obj)){
				validation.addError("Existe registro com período em aberto.");
			}
		}else{
			if (dao.existePeriodoFimMaiorPeriodoInicio(obj)){
				validation.addError("Existe registro com período vigência maior ou igual ao período vigência inicial.");
			}
		}
		
		if(validation.getErrors().size() > 0) {
			throw validation;
		}
	}

	public int delete(Integer id) {
		// incluir validação se pode excluir aqui...
		return dao.delete(id);
	}

	

	
}
