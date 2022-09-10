package es.everis.gvias.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

import es.everis.gvias.core.appbase.model.biz.fachada.Fachada;
import es.everis.gvias.core.appbase.model.integration.dao.generado.Vereda;
import es.everis.gvias.navigation.MigaBean;

@ManagedBean(name = "administracionBean")
@ViewScoped
public class AdministracionBean implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = -1809537380170748421L;

	/** Variable log. */
	private static Logger logger = LogManager.getLogger();
	
    private Fachada fachada;
    
    List<Vereda> veredasPorMunicipio;
	
	@ManagedProperty(value="#{migaBean}")
	private MigaBean migaBean;
	
    /**
     * Inits the page.
     *
     */
    @PostConstruct
    public void initPage() {
        cargarDatos();
    }

    /**
     * Cargar datos
     */
    public void cargarDatos() {
    	logger.debug("AdministracionBean - cargarDatos - Inicio");
    	
//    	INICIALIZAR VARIABLES
    	fachada = new Fachada();

    	if(migaBean.getMunicipioId() != null) {
    		
    		veredasPorMunicipio = fachada.obtenerVeredasPorMunicipio(migaBean.getMunicipioId());

    	}

    	logger.debug("AdministracionBean - cargarDatos - Fin");
    }
    
    public void onRowEdit(RowEditEvent<Vereda> event) {

    	//TODO REVISAR ESTA COMPROBACION PORQUE NO SIRVE PARA LA EDICION, SOLO PARA LA CREACION
//    	if (!fachada.existeCodigoVereda(event.getObject().getCodVereda())){
    		if (fachada.actualizarVereda(event.getObject())) {
            	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Vereda modificada", null));
            }else{
            	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Se ha producido un error. No se han guardado los datos", null));
            }
//    	}else{
//    		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "El código de vereda ya existe. No se han guardado los datos", null));
//    	}
        
        
    }
     
    public void onRowCancel(RowEditEvent<Vereda> event) {
        FacesMessage msg = new FacesMessage("Modificación cancelada", event.getObject().getNombre());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
 
    public void onAddNew() {
        Vereda veredaNueva = new Vereda();
        veredaNueva.setMunicipio(fachada.obtenerMunicipioPorId(migaBean.getMunicipioId()));
        veredaNueva.setNombre("Nueva vereda");
        getVeredasPorMunicipio().add(veredaNueva);
        
        if (fachada.actualizarVereda(veredaNueva)) {
        	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Nueva vereda añadida", null));
//        	cargarDatos();
        }else {
        	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "No se han guardado los datos", null));
        }
    }
    
    public void onCellEdit(CellEditEvent event) {
        Object oldValue = event.getOldValue();
        Object newValue = event.getNewValue();
         
        if(newValue != null && !newValue.equals(oldValue)) {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell Changed", "Old: " + oldValue + ", New:" + newValue);
            FacesContext.getCurrentInstance().addMessage(null, msg);
        }
    }

	public List<Vereda> getVeredasPorMunicipio() {
		return veredasPorMunicipio;
	}

	public void setVeredasPorMunicipio(List<Vereda> veredasPorMunicipio) {
		this.veredasPorMunicipio = veredasPorMunicipio;
	}

	public MigaBean getMigaBean() {
		return migaBean;
	}

	public void setMigaBean(MigaBean migaBean) {
		this.migaBean = migaBean;
	}
}
