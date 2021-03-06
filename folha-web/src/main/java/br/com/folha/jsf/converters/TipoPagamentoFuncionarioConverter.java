package br.com.folha.jsf.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import br.com.folha.entity.TipoPagamentoFuncionario;
import br.com.folha.facade.TipoPagamentoFuncionarioFacade;
import br.com.folha.utils.FacadeLocator;

@FacesConverter(forClass=TipoPagamentoFuncionario.class,value="tipoPagamentoFuncionarioConverter")
public class TipoPagamentoFuncionarioConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String newvalue) {
		try {
			TipoPagamentoFuncionarioFacade facade = FacadeLocator.getService(TipoPagamentoFuncionarioFacade.class);
			return facade.consultar(Long.parseLong(newvalue));
		} catch (Exception e) {
			e.printStackTrace();
			throw new ConverterException(e.getMessage());
		}
	  }

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		TipoPagamentoFuncionario tipoPagamentoFuncionario = (TipoPagamentoFuncionario)arg2;
	    return String.valueOf(tipoPagamentoFuncionario.getId());
	  }
}
