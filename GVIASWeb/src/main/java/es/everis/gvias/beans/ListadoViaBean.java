package es.everis.gvias.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import es.everis.gvias.core.appbase.model.biz.fachada.Fachada;
import es.everis.gvias.core.appbase.model.integration.dao.generado.Via;
import es.everis.gvias.navigation.MigaBean;

@ManagedBean(name = "listadoViaBean")
@ViewScoped
public class ListadoViaBean implements Serializable{
	
	private static final long serialVersionUID = -662525153579275538L;
    private Fachada fachada;
	private List<Via> listaVias = new ArrayList<Via>();
	private String nombreMunicipio;
	private BigDecimal test;
	
	@ManagedProperty(value="#{migaBean}")
	private MigaBean migaBean;
	
	@PostConstruct
    public void initPage() {
        cargarDatos();
        test = new BigDecimal(1);
    }
	
	public void cargarDatos() {
    	fachada = new Fachada();
    	  
    	if (migaBean.getMunicipioId() != null) {
    		listaVias = fachada.obtenerViasPorMunicipio(migaBean.getMunicipioId(), migaBean.isPlanVial());
    	}
    	
//    	setNombreMunicipio(inicioBean.getMunicipioSelected().getNombre());
	}
	
    
	public List<Via> getListaVias() {
		return listaVias;
	}

	public void setListaVias(List<Via> listaVias) {
		this.listaVias = listaVias;
	}

	public MigaBean getMigaBean() {
		return migaBean;
	}

	public void setMigaBean(MigaBean migaBean) {
		this.migaBean = migaBean;
	}

	public String getNombreMunicipio() {
		return nombreMunicipio;
	}

	public void setNombreMunicipio(String nombreMunicipio) {
		this.nombreMunicipio = nombreMunicipio;
	}

	public BigDecimal getTest() {
		return test;
	}

	public void setTest(BigDecimal test) {
		this.test = test;
	}	
}
