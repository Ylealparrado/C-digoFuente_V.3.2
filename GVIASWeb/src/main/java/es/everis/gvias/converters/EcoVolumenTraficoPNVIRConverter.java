package es.everis.gvias.converters;

import java.math.BigDecimal;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import es.everis.gvias.core.appbase.model.integration.dao.generado.EcoVolumenTraficoPNVIR;

@FacesConverter("ecoVolumenTraficoPNVIRConverter")
public class EcoVolumenTraficoPNVIRConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
        if (value == null || (value.trim().length() == 0))
        {
            return value;
        }		

        EcoVolumenTraficoPNVIR t = new EcoVolumenTraficoPNVIR();        
		String[] valores = value.split("#");
		boolean conversionError = false;

		if (valores.length == 2) {
			t.setIdEcoVolumenTraficoPNVIR(new BigDecimal(valores[0]));
			t.setDescripcion(valores[1]);
		} else if (valores.length == 1) {
			if (valores[0].length() > 2) {
				// Es solo la descripcion
				t.setIdEcoVolumenTraficoPNVIR(new BigDecimal(-1));
				t.setDescripcion(valores[0]);
			} else {
				// Es solo el ID
				t.setIdEcoVolumenTraficoPNVIR(new BigDecimal(valores[0]));
				t.setDescripcion("");				
			} 
		} else {
			throw new ConverterException();
		}
		
		return t;
	}	

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		EcoVolumenTraficoPNVIR t = null;
		
		if (value instanceof EcoVolumenTraficoPNVIR) {
			t = (EcoVolumenTraficoPNVIR)value;
			
			return t.toString();
		}
		
		return "";
	}

	
}
