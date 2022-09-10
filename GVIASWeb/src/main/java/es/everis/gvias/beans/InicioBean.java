package es.everis.gvias.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.primefaces.PrimeFaces;

import es.everis.gvias.core.appbase.common.utilidades.Utilidades;
import es.everis.gvias.core.appbase.model.biz.fachada.Fachada;
import es.everis.gvias.core.appbase.model.integration.dao.generado.Departamento;
import es.everis.gvias.core.appbase.model.integration.dao.generado.GeoSeccionTransversal;
import es.everis.gvias.core.appbase.model.integration.dao.generado.GeoTramoVia;
import es.everis.gvias.core.appbase.model.integration.dao.generado.Municipio;
import es.everis.gvias.core.appbase.model.integration.dao.generado.Via;
import es.everis.gvias.navigation.MigaBean;

@ManagedBean(name = "inicioBean")
@SessionScoped
public class InicioBean implements Serializable{
	
	private static final long serialVersionUID = -662525153579275538L;
	private static Logger logger = LogManager.getLogger(InicioBean.class);
	private Fachada fachada;
	private String leo;
    private Departamento departamentoSelected;
    private Municipio municipioSelected;
    
    private List<Departamento> listaDepartamentos;
    private List<Municipio> listaMunicipios;
    
    private Boolean botonesDisabled;

	@ManagedProperty(value="#{migaBean}")
	private MigaBean migaBean;
	
	@PostConstruct
    public void initPage() {
        cargarDatos();
    }
		
	public void cargarDatos() {
    	logger.debug("InicioBean - cargarDatos - Inicio");
    	fachada = new Fachada();
    	
    	setLeo("ENTRO!!");

    	botonesDisabled = true;
    	
    	//PRECARGAR COMBOS
    	listaDepartamentos = fachada.obtenerListaDepartamentos();
    	listaMunicipios = fachada.obtenerListaMunicipios();
    	
	}
	
    
    public void onChangeDepartamento(Departamento dep) {
    	logger.debug("onChangeDepartamento - Inicio");
    	
    	if(dep != null && !dep.getIdDepartamento().equals(new BigDecimal(-1))) {
    		logger.debug("onChangeDepartamento: "+dep.getIdDepartamento() + " " + dep.getNombre());
    		listaMunicipios=fachada.obtenerMunicipiosPorDepartamento(dep.getIdDepartamento());
    	}else{
    		listaMunicipios=fachada.obtenerListaMunicipios();
    		setMunicipioSelected(null);
    	}
    	setBotonesDisabled(true);

    	logger.debug("onChangeDepartamento - Fin");
    }
    
    
    public void onChangeMunicipio (Municipio mun) {
    	logger.debug("onChangeMunicipio - Inicio");
    	if(mun != null && !mun.getIdMunicipio().equals(new BigDecimal(-1))) {
    		setBotonesDisabled(false);
    	}else {
    		setBotonesDisabled(true);
    	}
    	logger.debug("onChangeMunicipio - Fin");
    }
    
    public void sincronizarDatos (BigDecimal municipioId) {
    	logger.debug("sincronizarDatos - Inicio");
    	Municipio municipio = fachada.obtenerMunicipioPorId(municipioId);
    	List<String> viasCodigos = new Fachada().obtenerListaCodigosViasPorMunicipio(municipioId);
    	List<GeoTramoVia> geoVias = new Fachada().obtenerGeoTramoViaPorMunicipio(municipio.getCodMunicipio());
    	double anchoPromedio = 0.0, tierra = 0.0, afirmadas = 0.0, pavimentadas = 0.0, mejoramiento = 0.0, otros = 0.0, total=0.0;
    	int cont = 0;
    	for (GeoTramoVia geoVia : geoVias) {
			if (geoVia.getCodVia() != null && viasCodigos != null && !viasCodigos.contains(geoVia.getCodVia())) {
				Via viaNueva = new Via(geoVia.getCodVia(), geoVia.getNombre());
				viaNueva.setMunicipio(municipio);
				List<GeoSeccionTransversal> secciones = new Fachada().obtenerSeccionesVia(geoVia.getCodVia());
				for (GeoSeccionTransversal seccion : secciones) {
					if (seccion.getAncho() != null && seccion.getAncho() > 0) {
						anchoPromedio += seccion.getAncho();	
						cont++;
					}
					
					if (seccion.getTipoSuperficie() != null) {
						switch (seccion.getTipoSuperficie()) {
						case 1:
							tierra += seccion.getLongitud();
							break;
						case 2:
							afirmadas += seccion.getLongitud();
							break;
						case 3:
						case 5:
							pavimentadas += seccion.getLongitud();
							break;
						case 4:
							mejoramiento += seccion.getLongitud();
							break;
						default:
							otros += seccion.getLongitud();
							break;
						}					
					}						
				}
				
				if (anchoPromedio > 0) {
					viaNueva.setAnchoPromedio(Utilidades.round(anchoPromedio / cont,2));
				}
				
				if (tierra > 0) {
					viaNueva.setTierraRegular(Utilidades.round(tierra/1000,2));
					total += tierra;
				}
				
				if (afirmadas > 0) {
					viaNueva.setAfirmRegular(Utilidades.round(afirmadas/1000,2));
					total += afirmadas;
				}
				
				if (pavimentadas > 0) {
					viaNueva.setPavimRegular(Utilidades.round(pavimentadas/1000,2));
					total += pavimentadas;
				}
				
				if (mejoramiento > 0) {
					viaNueva.setMejoraRegular(Utilidades.round(mejoramiento/1000,2));	
					total += mejoramiento;
				}
				
				if (total > 0) {
					viaNueva.setLongitudTotal(Utilidades.round(total/1000,2));
				}
				
				new Fachada().actualizarVia(viaNueva);
			}
		}
    	   	
    	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Vías sincronizadas para el municipio "+municipio.getNombre(), null));
    	PrimeFaces.current().ajax().update("growl");
    	
    	logger.debug("sincronizarDatos - Fin");
    }

	public String getLeo() {
		return leo;
	}

	public void setLeo(String leo) {
		this.leo = leo;
	}

	public Departamento getDepartamentoSelected() {
		return departamentoSelected;
	}

	public void setDepartamentoSelected(Departamento departamentoSelected) {
		this.departamentoSelected = departamentoSelected;
	}

	public Municipio getMunicipioSelected() {
		return municipioSelected;
	}

	public void setMunicipioSelected(Municipio municipioSelected) {
		this.municipioSelected = municipioSelected;
	}

	public List<Departamento> getListaDepartamentos() {
		return listaDepartamentos;
	}

	public void setListaDepartamentos(List<Departamento> listaDepartamentos) {
		this.listaDepartamentos = listaDepartamentos;
	}

	public List<Municipio> getListaMunicipios() {
		return listaMunicipios;
	}

	public void setListaMunicipios(List<Municipio> listaMunicipios) {
		this.listaMunicipios = listaMunicipios;
	}

	public Boolean getBotonesDisabled() {
		return botonesDisabled;
	}

	public void setBotonesDisabled(Boolean botonesDisabled) {
		this.botonesDisabled = botonesDisabled;
	}

	public MigaBean getMigaBean() {
		return migaBean;
	}

	public void setMigaBean(MigaBean migaBean) {
		this.migaBean = migaBean;
	}
	
}
