package es.everis.gvias.converters;

import java.math.BigDecimal;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import es.everis.gvias.core.appbase.model.integration.dao.generado.Competencia;

@FacesConverter("competenciaConverter")
public class CompetenciaConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
        if (value == null || (value.trim().length() == 0))
        {
            return value;
        }		

        Competencia t = new Competencia();        
		String[] valores = value.split("#");
		boolean conversionError = false;

		if (valores.length == 2) {
			t.setIdCompetencia(new BigDecimal(valores[0]));
			t.setNombre(valores[1]);
		} else if (valores.length == 1) {
			if (valores[0].length() > 2) {
				// Es solo la descripcion
				t.setIdCompetencia(new BigDecimal(-1));
				t.setNombre(valores[0]);
			} else {
				// Es solo el ID
				t.setIdCompetencia(new BigDecimal(valores[0]));
				t.setNombre("");				
			} 
		} else {
			throw new ConverterException();
		}
		
		return t;
	}	

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		Competencia t = null;
		
		if (value instanceof Competencia) {
			t = (Competencia)value;
			
			return t.toString();
		}
		
		return "";
	}

	
}
