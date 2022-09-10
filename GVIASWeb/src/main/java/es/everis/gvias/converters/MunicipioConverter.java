package es.everis.gvias.converters;

import java.math.BigDecimal;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import es.everis.gvias.core.appbase.model.integration.dao.generado.Municipio;

@FacesConverter("municipioConverter")
public class MunicipioConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
        if (value == null || (value.trim().length() == 0))
        {
            return value;
        }		

        Municipio t = new Municipio();        
		String[] valores = value.split("#");
		boolean conversionError = false;

		if (valores.length == 2) {
			t.setIdMunicipio(new BigDecimal(valores[0]));
			t.setNombre(valores[1]);
		} else if (valores.length == 1) {
			if (valores[0].length() > 2) {
				// Es solo la descripcion
				t.setIdMunicipio(new BigDecimal(-1));
				t.setNombre(valores[0]);
			} else {
				// Es solo el ID
				t.setIdMunicipio(new BigDecimal(valores[0]));
				t.setNombre("");				
			} 
		} else {
			throw new ConverterException();
		}
		
		return t;
	}	

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		Municipio t = null;
		
		if (value instanceof Municipio) {
			t = (Municipio)value;
			
			return t.toString();
		}
		
		return "";
	}

	
}
