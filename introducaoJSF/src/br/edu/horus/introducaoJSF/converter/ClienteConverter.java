package br.edu.horus.introducaoJSF.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.edu.horus.introducaoJSF.model.Cliente;

@FacesConverter(forClass=Cliente.class, value="clienteConverter")
public class ClienteConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, 
			UIComponent component, String value) {
		Cliente cliente = new Cliente();
		cliente.setCodigo(Integer.valueOf(value));
		return cliente;
	}

	@Override
	public String getAsString(FacesContext context, 
			UIComponent componente, Object value) {
		if(value instanceof Cliente){
			return ((Cliente) value).getCodigo().toString();
		}
		return null;
	}

}
