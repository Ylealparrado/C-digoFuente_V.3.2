package es.everis.gvias.converters;

import java.math.BigDecimal;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import es.everis.gvias.core.appbase.model.integration.dao.generado.ProductoCuartiles;
import es.everis.gvias.core.appbase.model.integration.dao.generado.ProductoRendimiento;

@FacesConverter("productoRendimientoConverter")
public class ProductoRendimientoConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		
        if (value == null || (value.trim().length() == 0))
        {
            return value;
        }		

        ProductoRendimiento t = new ProductoRendimiento();
		String[] valores = value.split("#");
		boolean conversionError = false;

		if (valores.length == 2) {
			t.setIdProductoRendimiento(new BigDecimal(valores[0]));
			t.setProductoCuartiles(new ProductoCuartiles());
			t.getProductoCuartiles().setProducto(valores[1]);
		} else if (valores.length == 1) {
			if (valores[0].length() > 2) {
				// Es solo la descripcion
				t.setIdProductoRendimiento(new BigDecimal(-1));
				t.setProductoCuartiles(new ProductoCuartiles());
				t.getProductoCuartiles().setProducto(valores[0]);
			} else {
				// Es solo el ID
				t.setIdProductoRendimiento(new BigDecimal(valores[0]));
				t.getProductoCuartiles().setProducto("");				
			} 
		} else {
			throw new ConverterException();
		}
		
		return t;
	}	

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		ProductoRendimiento t = null;
		
		if (value instanceof ProductoRendimiento) {
			t = (ProductoRendimiento)value;
			
			return t.toString();
		}
		
		return "";
	}

	
}
