package veterinaria.estoque.util.jsf.converters;

import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import veterinaria.estoque.model.entidades.Saida;
import veterinaria.estoque.service.ServiceSaida;

@RequestScoped
@FacesConverter(forClass = Saida.class)
public class ConverterSaida implements Converter {
	
	@Inject
	private ServiceSaida serviceSaida;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value == null) {
			return null;
		}
		
		return serviceSaida.buscarPorId(new Long(value));
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value == null) {
			return "";
		}
		
		Saida saida = (Saida) value;
		
		if (saida.getId() == null) {
			return null;
		}
		
		return saida.getId().toString();
	}

}
