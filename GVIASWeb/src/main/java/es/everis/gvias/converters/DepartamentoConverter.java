package es.everis.gvias.converters;

import java.math.BigDecimal;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import es.everis.gvias.core.appbase.model.integration.dao.generado.Departamento;

@FacesConverter("departamentoConverter")
public class DepartamentoConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
        if (value == null || (value.trim().length() == 0))
        {
            return value;
        }		

        Departamento t = new Departamento();        
		String[] valores = value.split("#");
		boolean conversionError = false;

		if (valores.length == 2) {
			t.setIdDepartamento(new BigDecimal(valores[0]));
			t.setNombre(valores[1]);
		} else if (valores.length == 1) {
			if (valores[0].length() > 2) {
				// Es solo la descripcion
				t.setIdDepartamento(new BigDecimal(-1));
				t.setNombre(valores[0]);
			} else {
				// Es solo el ID
				t.setIdDepartamento(new BigDecimal(valores[0]));
				t.setNombre("");				
			} 
		} else {
			throw new ConverterException();
		}
		
		return t;
	}	

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		Departamento t = null;
		
		if (value instanceof Departamento) {
			t = (Departamento)value;
			
			return t.toString();
		}
		
		return "";
	}

	
}
