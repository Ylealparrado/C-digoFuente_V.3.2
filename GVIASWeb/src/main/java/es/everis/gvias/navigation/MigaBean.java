package es.everis.gvias.navigation;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.primefaces.PrimeFaces;

@ManagedBean(name = "migaBean")
@SessionScoped
public class MigaBean implements Serializable{

	private static final long serialVersionUID = 8522812865247173245L;

	/** Variable log. */
	private static Logger logger = LogManager.getLogger();
	
    private BigDecimal viaId;
    
    private BigDecimal municipioId;
    private String municipioNombre;
    private boolean isPlanVial;

	public String abrirBienvenida() {
		logger.debug("migaBean - abrirBienvenida - Inicio");	
		logger.debug("migaBean - abrirBienvenida - Fin");
		return "bienvenida";
	}
		
	public String abrirCategorizarVia(BigDecimal viaId, String codVia) {
		logger.debug("migaBean - abrirCategorizarVia - Inicio");
		setViaId(viaId);
		PrimeFaces.current().executeScript("centrarVia('"+codVia+"')");
		logger.debug("migaBean - abrirCategorizarVia - Fin");
		return "categorizarVia";
	}
	
	
	public String abrirPlanVialVia(BigDecimal viaId, String codVia) {
		logger.debug("migaBean - abrirPlanVialVia - Inicio");
		setViaId(viaId);
		PrimeFaces.current().executeScript("centrarVia('"+codVia+"')");
		logger.debug("migaBean - abrirPlanVialVia - Fin");
		return "planVialVia";
	}
	
	
	public String abrirListarViasCategorizacion(BigDecimal municipioId, String municipioNombre) {
		logger.debug("migaBean - abrirListarViasCategorizacion - Inicio");
		setMunicipioId(municipioId);
		setMunicipioNombre(municipioNombre);
		setPlanVial(false);
		//TODO obtener el codMunicipio y pasarlo en lugar del nombre
		PrimeFaces.current().executeScript("setMunicipio('"+municipioNombre+"')");
		logger.debug("migaBean - abrirListarViasCategorizacion - Fin");
		return "listarViasCategorizacion";
	}
	
	public String abrirListarViasCategorizacion() {
		logger.debug("migaBean - abrirListarViasCategorizacion - Inicio");
		PrimeFaces.current().executeScript("setMunicipio('"+municipioNombre+"')");
		logger.debug("migaBean - abrirListarViasCategorizacion - Fin");
		return "listarViasCategorizacion";
	}
	
	public String abrirListarViasPlanVial(BigDecimal municipioId, String municipioNombre) {
		logger.debug("migaBean - abrirListarViasPlanVial - Inicio");
		setMunicipioId(municipioId);
		setMunicipioNombre(municipioNombre);
		setPlanVial(true);
		//TODO obtener el codMunicipio y pasarlo en lugar del nombre
		PrimeFaces.current().executeScript("setMunicipio('"+municipioNombre+"')");
		logger.debug("migaBean - abrirListarViasPlanVial - Fin");
		return "listarViasPlanVial";
	}
	
	public String abrirAdministracionDatos(BigDecimal municipioId, String municipioNombre) {
		logger.debug("migaBean - abrirAdministracionDatos - Inicio");
		setMunicipioId(municipioId);
		setMunicipioNombre(municipioNombre);
		logger.debug("migaBean - abrirAdministracionDatos - Fin");
		return "administracion";
	}
	
	public String abrirListarViasPlanVial() {
		logger.debug("migaBean - abrirListarViasPlanVial - Inicio");
		PrimeFaces.current().executeScript("setMunicipio('"+municipioNombre+"')");
		logger.debug("migaBean - abrirListarViasPlanVial - Fin");
		return "listarViasPlanVial";
	}
	
	public String abrirMapa(String municipioNombre) {
		//TODO obtener el codMunicipio y pasarlo en lugar del nombre
		PrimeFaces.current().executeScript("setMunicipio('"+municipioNombre+"')");
		return "mapa";
	}
	
	public void centrarViaMapa(String codVia) {
		logger.debug("migaBean - centrarViaMapa - Inicio");
		PrimeFaces.current().executeScript("centrarVia('"+codVia+"')");
		logger.debug("migaBean - centrarViaMapa - Fin");
	}
	
	public String abrirAnalisisCostos (BigDecimal municipioId, String municipioNombre) {
		logger.debug("migaBean - abrirAnalisisCostos - Inicio");
		setMunicipioId(municipioId);
		setMunicipioNombre(municipioNombre);
		logger.debug("migaBean - abrirAnalisisCostos - Fin");
		return "analisis";
	}
    
	public BigDecimal getViaId() {
		return viaId;
	}

	public void setViaId(BigDecimal viaId) {
		this.viaId = viaId;
	}

	public BigDecimal getMunicipioId() {
		return municipioId;
	}

	public void setMunicipioId(BigDecimal municipioId) {
		this.municipioId = municipioId;
	}

	public String getMunicipioNombre() {
		return municipioNombre;
	}

	public void setMunicipioNombre(String municipioNombre) {
		this.municipioNombre = municipioNombre;
	}

	public boolean isPlanVial() {
		return isPlanVial;
	}

	public void setPlanVial(boolean isPlanVial) {
		this.isPlanVial = isPlanVial;
	}
}
