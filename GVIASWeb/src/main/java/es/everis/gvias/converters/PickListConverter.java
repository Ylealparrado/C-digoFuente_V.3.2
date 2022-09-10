package es.everis.gvias.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.primefaces.component.picklist.PickList;
import org.primefaces.model.DualListModel;

import es.everis.gvias.core.appbase.model.integration.dao.generado.Vereda;

@FacesConverter(value = "picklistConverter")
public class PickListConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		Object ret = null;
		if (arg1 instanceof PickList) {
			Object dualList = ((PickList) arg1).getValue();
			DualListModel<?> dl = (DualListModel<?>) dualList;
			
			for (Object o : dl.getSource()) {
				String id = tratarStringId(o);
				if (arg2.equals(id)) {
					ret = o;
					break;
				}
			}
			
			if (ret == null) {
				for (Object o : dl.getTarget()) {
					String id = tratarStringId(o);
					if (arg2.equals(id)) {
						ret = o;
						break;
					}
				}
			}
		}
		return ret;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		return tratarStringId(arg2);
	}
	
	private String tratarStringId(Object o) {
		String id = "";
		if (o instanceof Vereda) {
			id = "" + ((Vereda) o).getIdVereda();
		}
//		else if(o instanceof PerPersona) {
//			id = "" + ((PerPersona) o).getPerId();
//		}
		return id;
	}

}