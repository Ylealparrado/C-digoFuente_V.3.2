package es.everis.gvias.beans;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.primefaces.PrimeFaces;

import es.everis.gvias.core.appbase.model.biz.fachada.Fachada;
import es.everis.gvias.core.appbase.model.integration.dao.generado.Categorizacion;
import es.everis.gvias.core.appbase.model.integration.dao.generado.Via;
import es.everis.gvias.navigation.MigaBean;

@ManagedBean(name = "categorizarViaBean")
@ViewScoped
public class CategorizarViaBean implements Serializable{

    private static final String ERROR_VALIDACION_P1 = "Debe rellenar el campo \"Observaciones\" para el valor marcado en \"PARTE 1.- FUNCIONALIDAD\"";
    private static final String ERROR_VALIDACION_P2 = "Debe rellenar el campo \"Observaciones\" para el valor marcado en \"PARTE 2.- TRÁMSITO PROMEDIO DIARIO\"";
    private static final String ERROR_VALIDACION_P3 = "Debe rellenar el campo \"Observaciones\" para el valor marcado en \"PARTE 3.- DISEÑO GEOMÉTRICO\"";
    private static final String ERROR_VALIDACION_P4 = "Debe rellenar el campo \"Observaciones\" para el valor marcado en \"PARTE 4.- POBLACIÓN\"";

	/**
	 * 
	 */
	private static final long serialVersionUID = -1809537380170748421L;

	/** Variable log. */
	private static Logger logger = LogManager.getLogger();
	
    private Fachada fachada;
    
    private Via via = new Via();
    
    private boolean funcionalidad1Disabled = false;
    private boolean funcionalidad2Disabled = false;
    private boolean funcionalidad3Disabled = false;
    private boolean funcionalidad4Disabled = false;
    private boolean funcionalidad5Disabled = false;
    private boolean funcionalidad6Disabled = false;
    
    private boolean transito1Disabled = false;
    private boolean transito2Disabled = false;
    private boolean transito3Disabled = false;
    
    private boolean diseno1Disabled = false;
    private boolean diseno2Disabled = false;
    private boolean diseno3Disabled = false;
    private boolean diseno4Disabled = false;
    
    private boolean poblacion1Disabled = false;
    private boolean poblacion2Disabled = false;
    private boolean poblacion3Disabled = false;
	
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
    	logger.debug("ViaBean - cargarDatos - Inicio");
    	
    	logger.debug("ViaBean - cargarDatos - Cargando via:"+ migaBean.getViaId());

//    	INICIALIZAR VARIABLES
    	fachada = new Fachada();
    	
    	if(migaBean.getViaId() != null) {
    		Via via = fachada.obtenerViaPorId(migaBean.getViaId(), false);
    		
    		if (via.getCategorizacion() == null){
    			via.setCategorizacion(new Categorizacion());
    		}
    		
    		setVia(via);
    	}
    	
    	logger.debug("ViaBean - cargarDatos - Fin");
    }
    
    
    
    public void onChangeFuncionalidadCheck(String check, Boolean marcado) {
    	System.out.println("Cambio Funcionalidad");
    	System.out.println(check);
    	
    	if (marcado) {
	    	switch (check) {
			case "funcionalidad1":
					//validaciones
		    		getVia().getCategorizacion().setFuncionalidad6(false);
		    		setFuncionalidad6Disabled(true);
					//puntajes
		    		getVia().getCategorizacion().setResultFuncionalidad2Orden(null);
		    		getVia().getCategorizacion().setResultFuncionalidad3Orden(null);
		    		getVia().getCategorizacion().setResultFuncionalidad1Orden(new BigDecimal(40));
		    	break;
			case "funcionalidad2":
			case "funcionalidad3":
			case "funcionalidad4":
					//validaciones
					getVia().getCategorizacion().setFuncionalidad5(false);
					setFuncionalidad5Disabled(true);
					getVia().getCategorizacion().setFuncionalidad6(false);
					setFuncionalidad6Disabled(true);
					//puntajes
		    		getVia().getCategorizacion().setResultFuncionalidad2Orden(null);
		    		getVia().getCategorizacion().setResultFuncionalidad3Orden(null);
					getVia().getCategorizacion().setResultFuncionalidad1Orden(new BigDecimal(40));
				break;
			case "funcionalidad5":
					//validaciones
					getVia().getCategorizacion().setFuncionalidad2(false);
					setFuncionalidad2Disabled(true);
					getVia().getCategorizacion().setFuncionalidad3(false);
					setFuncionalidad3Disabled(true);
					getVia().getCategorizacion().setFuncionalidad4(false);
					setFuncionalidad4Disabled(true);
					getVia().getCategorizacion().setFuncionalidad6(false);
					setFuncionalidad6Disabled(true);
					//puntajes
					if (getVia().getCategorizacion().getResultFuncionalidad1Orden() == null) {
			    		getVia().getCategorizacion().setResultFuncionalidad3Orden(null);
						getVia().getCategorizacion().setResultFuncionalidad2Orden(new BigDecimal(40));
					}	
				break;
			case "funcionalidad6":
					//validaciones
					getVia().getCategorizacion().setFuncionalidad1(false);
					setFuncionalidad1Disabled(true);
					getVia().getCategorizacion().setFuncionalidad2(false);
					setFuncionalidad2Disabled(true);
					getVia().getCategorizacion().setFuncionalidad3(false);
					setFuncionalidad3Disabled(true);
					getVia().getCategorizacion().setFuncionalidad4(false);
					setFuncionalidad4Disabled(true);
					getVia().getCategorizacion().setFuncionalidad5(false);
					setFuncionalidad5Disabled(true);
					//puntajes
		    		getVia().getCategorizacion().setResultFuncionalidad1Orden(null);
		    		getVia().getCategorizacion().setResultFuncionalidad2Orden(null);
					getVia().getCategorizacion().setResultFuncionalidad3Orden(new BigDecimal(40));
				break;
			default:
				break;
			}
    	}else{//desmarcar
    		switch (check) {
			case "funcionalidad1":
				if ((getVia().getCategorizacion().getFuncionalidad2() == null || !getVia().getCategorizacion().getFuncionalidad2()) &&
						(getVia().getCategorizacion().getFuncionalidad3() == null || !getVia().getCategorizacion().getFuncionalidad3()) && 
						(getVia().getCategorizacion().getFuncionalidad4() == null || !getVia().getCategorizacion().getFuncionalidad4()) &&
						(getVia().getCategorizacion().getFuncionalidad5() == null || !getVia().getCategorizacion().getFuncionalidad5())) {
					setFuncionalidad6Disabled(false);
				}
				//puntajes
				getVia().getCategorizacion().setResultFuncionalidad1Orden(null);
				if (getVia().getCategorizacion().getFuncionalidad5() != null && getVia().getCategorizacion().getFuncionalidad5()){
					getVia().getCategorizacion().setResultFuncionalidad2Orden(new BigDecimal(40));	
				}
				break;
			case "funcionalidad2":
			case "funcionalidad3":
			case "funcionalidad4": //5 y 6 están off. la 6 depende de la 1
				if ((getVia().getCategorizacion().getFuncionalidad1() == null || !getVia().getCategorizacion().getFuncionalidad1()) &&
						(getVia().getCategorizacion().getFuncionalidad2() == null || !getVia().getCategorizacion().getFuncionalidad2()) && 
						(getVia().getCategorizacion().getFuncionalidad3() == null || !getVia().getCategorizacion().getFuncionalidad3()) &&
						(getVia().getCategorizacion().getFuncionalidad4() == null || !getVia().getCategorizacion().getFuncionalidad4())) {
					setFuncionalidad6Disabled(false);
				}
				if ((getVia().getCategorizacion().getFuncionalidad2() == null || !getVia().getCategorizacion().getFuncionalidad2()) && 
						(getVia().getCategorizacion().getFuncionalidad3() == null || !getVia().getCategorizacion().getFuncionalidad3()) &&
						(getVia().getCategorizacion().getFuncionalidad4() == null || !getVia().getCategorizacion().getFuncionalidad4())) {
					setFuncionalidad5Disabled(false);
				}
				//puntajes
				getVia().getCategorizacion().setResultFuncionalidad1Orden(null);
				break;
			case "funcionalidad5": //2,3,4 y 6 están off
				if ((getVia().getCategorizacion().getFuncionalidad1() == null || !getVia().getCategorizacion().getFuncionalidad1())) {
					setFuncionalidad6Disabled(false);
				}
					setFuncionalidad2Disabled(false);
					setFuncionalidad3Disabled(false);
					setFuncionalidad4Disabled(false);
				//puntajes
				getVia().getCategorizacion().setResultFuncionalidad2Orden(null);
				break;
			case "funcionalidad6": //1,2,3,4,5 están off
				setFuncionalidad1Disabled(false);
				setFuncionalidad2Disabled(false);
				setFuncionalidad3Disabled(false);
				setFuncionalidad4Disabled(false);
				setFuncionalidad5Disabled(false);
				//puntajes
				getVia().getCategorizacion().setResultFuncionalidad3Orden(null);
				break;
			default:
				break;
    		}
    	}
    	
    	calcularTotales();
    	
    	//Validaciones
    	PrimeFaces.current().ajax().update("categorizarViaForm:categorizacionTabView:funcionalidad1");
    	PrimeFaces.current().ajax().update("categorizarViaForm:categorizacionTabView:funcionalidad2");
    	PrimeFaces.current().ajax().update("categorizarViaForm:categorizacionTabView:funcionalidad3");
    	PrimeFaces.current().ajax().update("categorizarViaForm:categorizacionTabView:funcionalidad4");
    	PrimeFaces.current().ajax().update("categorizarViaForm:categorizacionTabView:funcionalidad5");
    	PrimeFaces.current().ajax().update("categorizarViaForm:categorizacionTabView:funcionalidad6");
    	//Puntjes
    	PrimeFaces.current().ajax().update("categorizarViaForm:categorizacionTabView:resultFuncionalidad1Orden");
    	PrimeFaces.current().ajax().update("categorizarViaForm:categorizacionTabView:resultFuncionalidad2Orden");
    	PrimeFaces.current().ajax().update("categorizarViaForm:categorizacionTabView:resultFuncionalidad3Orden");
    	PrimeFaces.current().ajax().update("categorizarViaForm:categorizacionTabView:total1Orden");
    	PrimeFaces.current().ajax().update("categorizarViaForm:categorizacionTabView:total2Orden");
    	PrimeFaces.current().ajax().update("categorizarViaForm:categorizacionTabView:total3Orden");
    	PrimeFaces.current().ajax().update("categorizarViaForm:categorizacionTabView:categoriaFinal");
    }
    
    
    public void onChangeTransitoCheck(String check, Boolean marcado) {
    	System.out.println("Cambio Transito");
    	System.out.println(check);
    	
    	if (marcado) {
	    	switch (check) {
			case "transito1":
				//validaciones
				getVia().getCategorizacion().setTransito2(false);
	    		setTransito2Disabled(true);
	    		getVia().getCategorizacion().setTransito3(false);
	    		setTransito3Disabled(true);
	    		//puntajes
	    		getVia().getCategorizacion().setResultTransito2Orden(null);
	    		getVia().getCategorizacion().setResultTransito3Orden(null);
	    		getVia().getCategorizacion().setResultTransito1Orden(new BigDecimal(20));
		    	break;
			case "transito2":
				//validaciones
				getVia().getCategorizacion().setTransito1(false);
	    		setTransito1Disabled(true);
	    		getVia().getCategorizacion().setTransito3(false);
	    		setTransito3Disabled(true);
	    		//puntajes
	    		getVia().getCategorizacion().setResultTransito1Orden(null);
	    		getVia().getCategorizacion().setResultTransito3Orden(null);
	    		getVia().getCategorizacion().setResultTransito2Orden(new BigDecimal(20));
				break;
			case "transito3":
				//validaciones
				getVia().getCategorizacion().setTransito1(false);
	    		setTransito1Disabled(true);
	    		getVia().getCategorizacion().setTransito2(false);
	    		setTransito2Disabled(true);
	    		//puntajes
	    		getVia().getCategorizacion().setResultTransito1Orden(null);
	    		getVia().getCategorizacion().setResultTransito2Orden(null);
	    		getVia().getCategorizacion().setResultTransito3Orden(new BigDecimal(20));
				break;
			default:
				break;
			}
    	}else{//desmarcar
    		switch (check) {
			case "transito1":
				setTransito2Disabled(false);
				setTransito3Disabled(false);
				getVia().getCategorizacion().setResultTransito1Orden(null);
				break;
			case "transito2":
				setTransito1Disabled(false);
				setTransito3Disabled(false);
				getVia().getCategorizacion().setResultTransito2Orden(null);
				break;
			case "transito3":
				setTransito1Disabled(false);
				setTransito2Disabled(false);
				getVia().getCategorizacion().setResultTransito3Orden(null);
				break;
			default:
				break;
    		}
    	}
    	
    	calcularTotales();
    	
    	//validaciones
    	PrimeFaces.current().ajax().update("categorizarViaForm:categorizacionTabView:transito1");
    	PrimeFaces.current().ajax().update("categorizarViaForm:categorizacionTabView:transito2");
    	PrimeFaces.current().ajax().update("categorizarViaForm:categorizacionTabView:transito3");
    	//Puntajes
    	PrimeFaces.current().ajax().update("categorizarViaForm:categorizacionTabView:resultTransito1Orden");
    	PrimeFaces.current().ajax().update("categorizarViaForm:categorizacionTabView:resultTransito2Orden");
    	PrimeFaces.current().ajax().update("categorizarViaForm:categorizacionTabView:resultTransito3Orden");
    	PrimeFaces.current().ajax().update("categorizarViaForm:categorizacionTabView:total1Orden");
    	PrimeFaces.current().ajax().update("categorizarViaForm:categorizacionTabView:total2Orden");
    	PrimeFaces.current().ajax().update("categorizarViaForm:categorizacionTabView:total3Orden");
    	PrimeFaces.current().ajax().update("categorizarViaForm:categorizacionTabView:categoriaFinal");

    }
    
    public void onChangeDisenoCheck(String check, Boolean marcado) {
    	System.out.println("Cambio Diseno");
    	System.out.println(check);
    	
    	if (marcado) {
	    	switch (check) {
			case "diseno1":
			case "diseno2":
				//validaciones
				getVia().getCategorizacion().setDiseno3(false);
	    		setDiseno3Disabled(true);
	    		getVia().getCategorizacion().setDiseno4(false);
	    		setDiseno4Disabled(true);
	    		//puntaje
	    		getVia().getCategorizacion().setResultDiseno2Orden(null);
	    		getVia().getCategorizacion().setResultDiseno3Orden(null);
	    		getVia().getCategorizacion().setResultDiseno1Orden(new BigDecimal(20));

				break;
			case "diseno3":
				//validaciones
				getVia().getCategorizacion().setDiseno1(false);
	    		setDiseno1Disabled(true);
	    		getVia().getCategorizacion().setDiseno2(false);
	    		setDiseno2Disabled(true);
	    		getVia().getCategorizacion().setDiseno4(false);
	    		setDiseno4Disabled(true);
	    		//puntaje
	    		getVia().getCategorizacion().setResultDiseno1Orden(null);
	    		getVia().getCategorizacion().setResultDiseno3Orden(null);
	    		getVia().getCategorizacion().setResultDiseno2Orden(new BigDecimal(20));
				break;
			case "diseno4":
				//validaciones
				getVia().getCategorizacion().setDiseno1(false);
	    		setDiseno1Disabled(true);
	    		getVia().getCategorizacion().setDiseno2(false);
	    		setDiseno2Disabled(true);
	    		getVia().getCategorizacion().setDiseno3(false);
	    		setDiseno3Disabled(true);
	    		//puntaje
	    		getVia().getCategorizacion().setResultDiseno1Orden(null);
	    		getVia().getCategorizacion().setResultDiseno2Orden(null);
	    		getVia().getCategorizacion().setResultDiseno3Orden(new BigDecimal(20));
				break;
			default:
				break;
			}
    	}else{//desmarcar
    		switch (check) {
			case "diseno1":
			case "diseno2":
				if ((getVia().getCategorizacion().getDiseno1() == null || !getVia().getCategorizacion().getDiseno1()) &&
						(getVia().getCategorizacion().getDiseno2() == null || !getVia().getCategorizacion().getDiseno2())){
					setDiseno3Disabled(false);
					setDiseno4Disabled(false);
				}
				if ((getVia().getCategorizacion().getDiseno1() == null || !getVia().getCategorizacion().getDiseno1()) &&
						(getVia().getCategorizacion().getDiseno2() == null || !getVia().getCategorizacion().getDiseno2())){
					getVia().getCategorizacion().setResultDiseno1Orden(null);
				}	
				break;
			case "diseno3":
				setDiseno1Disabled(false);
				setDiseno2Disabled(false);
				setDiseno4Disabled(false);
				getVia().getCategorizacion().setResultDiseno2Orden(null);
				break;
			case "diseno4":
				setDiseno1Disabled(false);
				setDiseno2Disabled(false);
				setDiseno3Disabled(false);
				getVia().getCategorizacion().setResultDiseno3Orden(null);
				break;
			default:
				break;
    		}
    	}
    	
    	calcularTotales();
    	
    	//validaciones
    	PrimeFaces.current().ajax().update("categorizarViaForm:categorizacionTabView:diseno1");
    	PrimeFaces.current().ajax().update("categorizarViaForm:categorizacionTabView:diseno2");
    	PrimeFaces.current().ajax().update("categorizarViaForm:categorizacionTabView:diseno3");
    	PrimeFaces.current().ajax().update("categorizarViaForm:categorizacionTabView:diseno4");
    	//Puntajes
    	PrimeFaces.current().ajax().update("categorizarViaForm:categorizacionTabView:resultDiseno1Orden");
    	PrimeFaces.current().ajax().update("categorizarViaForm:categorizacionTabView:resultDiseno2Orden");
    	PrimeFaces.current().ajax().update("categorizarViaForm:categorizacionTabView:resultDiseno3Orden");
    	PrimeFaces.current().ajax().update("categorizarViaForm:categorizacionTabView:total1Orden");
    	PrimeFaces.current().ajax().update("categorizarViaForm:categorizacionTabView:total2Orden");
    	PrimeFaces.current().ajax().update("categorizarViaForm:categorizacionTabView:total3Orden");
    	PrimeFaces.current().ajax().update("categorizarViaForm:categorizacionTabView:categoriaFinal");
    }
    
    public void onChangePoblacionCheck(String check, Boolean marcado) {
    	System.out.println("Cambio Poblacion");
    	System.out.println(check);
    	
    	if (marcado) {
	    	switch (check) {
			case "poblacion1":
				//validaciones
				getVia().getCategorizacion().setPoblacion2(false);
	    		setPoblacion2Disabled(true);
	    		getVia().getCategorizacion().setPoblacion3(false);
	    		setPoblacion3Disabled(true);
	    		//puntajes
	    		getVia().getCategorizacion().setResultPoblacion2Orden(null);
	    		getVia().getCategorizacion().setResultPoblacion3Orden(null);
	    		getVia().getCategorizacion().setResultPoblacion1Orden(new BigDecimal(20));
		    	break;
			case "poblacion2":
				//validaciones
				getVia().getCategorizacion().setPoblacion1(false);
	    		setPoblacion1Disabled(true);
	    		getVia().getCategorizacion().setPoblacion3(false);
	    		setPoblacion3Disabled(true);
	    		//puntajes
	    		getVia().getCategorizacion().setResultPoblacion1Orden(null);
	    		getVia().getCategorizacion().setResultPoblacion3Orden(null);
	    		getVia().getCategorizacion().setResultPoblacion2Orden(new BigDecimal(20));
				break;
			case "poblacion3":
				//validaciones
				getVia().getCategorizacion().setPoblacion1(false);
	    		setPoblacion1Disabled(true);
	    		getVia().getCategorizacion().setPoblacion2(false);
	    		setPoblacion2Disabled(true);
	    		//puntajes
	    		getVia().getCategorizacion().setResultPoblacion1Orden(null);
	    		getVia().getCategorizacion().setResultPoblacion2Orden(null);
	    		getVia().getCategorizacion().setResultPoblacion3Orden(new BigDecimal(20));
				break;
			default:
				break;
			}
    	}else{//desmarcar
    		switch (check) {
			case "poblacion1":
				setPoblacion2Disabled(false);
				setPoblacion3Disabled(false);
	    		getVia().getCategorizacion().setResultPoblacion1Orden(null);
				break;
			case "poblacion2":
				setPoblacion1Disabled(false);
				setPoblacion3Disabled(false);
				getVia().getCategorizacion().setResultPoblacion2Orden(null);
				break;
			case "poblacion3":
				setPoblacion1Disabled(false);
				setPoblacion2Disabled(false);
				getVia().getCategorizacion().setResultPoblacion3Orden(null);
				break;
			default:
				break;
    		}
    	}
    	
    	calcularTotales();
    	
    	//validaciones
    	PrimeFaces.current().ajax().update("categorizarViaForm:categorizacionTabView:poblacion1");
    	PrimeFaces.current().ajax().update("categorizarViaForm:categorizacionTabView:poblacion2");
    	PrimeFaces.current().ajax().update("categorizarViaForm:categorizacionTabView:poblacion3");
    	//Puntajes
    	PrimeFaces.current().ajax().update("categorizarViaForm:categorizacionTabView:resultPoblacion1Orden");
    	PrimeFaces.current().ajax().update("categorizarViaForm:categorizacionTabView:resultPoblacion2Orden");
    	PrimeFaces.current().ajax().update("categorizarViaForm:categorizacionTabView:resultPoblacion3Orden");
    	PrimeFaces.current().ajax().update("categorizarViaForm:categorizacionTabView:total1Orden");
    	PrimeFaces.current().ajax().update("categorizarViaForm:categorizacionTabView:total2Orden");
    	PrimeFaces.current().ajax().update("categorizarViaForm:categorizacionTabView:total3Orden");
    	PrimeFaces.current().ajax().update("categorizarViaForm:categorizacionTabView:categoriaFinal");

    }
    
    
    public void calcularTotales() {
    	Integer total1Orden = 0,total2Orden = 0,total3Orden = 0;
    	
    	getVia().getCategorizacion().setCategoria(null);
    	
    	total1Orden += getVia().getCategorizacion().getResultFuncionalidad1Orden() != null ? getVia().getCategorizacion().getResultFuncionalidad1Orden().intValue():0; 
    	total1Orden += getVia().getCategorizacion().getResultTransito1Orden() != null ? getVia().getCategorizacion().getResultTransito1Orden().intValue():0;
    	total1Orden += getVia().getCategorizacion().getResultDiseno1Orden() != null ? getVia().getCategorizacion().getResultDiseno1Orden().intValue():0;
    	total1Orden += getVia().getCategorizacion().getResultPoblacion1Orden() != null ? getVia().getCategorizacion().getResultPoblacion1Orden().intValue():0;
    	
    	total2Orden += getVia().getCategorizacion().getResultFuncionalidad2Orden() != null ? getVia().getCategorizacion().getResultFuncionalidad2Orden().intValue():0; 
    	total2Orden += getVia().getCategorizacion().getResultTransito2Orden() != null ? getVia().getCategorizacion().getResultTransito2Orden().intValue():0;
    	total2Orden += getVia().getCategorizacion().getResultDiseno2Orden() != null ? getVia().getCategorizacion().getResultDiseno2Orden().intValue():0;
    	total2Orden += getVia().getCategorizacion().getResultPoblacion2Orden() != null ? getVia().getCategorizacion().getResultPoblacion2Orden().intValue():0;
    	
    	total3Orden += getVia().getCategorizacion().getResultFuncionalidad3Orden() != null ? getVia().getCategorizacion().getResultFuncionalidad3Orden().intValue():0; 
    	total3Orden += getVia().getCategorizacion().getResultTransito3Orden() != null ? getVia().getCategorizacion().getResultTransito3Orden().intValue():0;
    	total3Orden += getVia().getCategorizacion().getResultDiseno3Orden() != null ? getVia().getCategorizacion().getResultDiseno3Orden().intValue():0;
    	total3Orden += getVia().getCategorizacion().getResultPoblacion3Orden() != null ? getVia().getCategorizacion().getResultPoblacion3Orden().intValue():0;
    	
    	getVia().getCategorizacion().setTotal1Orden(new BigDecimal(total1Orden));
    	getVia().getCategorizacion().setTotal2Orden(new BigDecimal(total2Orden));
    	getVia().getCategorizacion().setTotal3Orden(new BigDecimal(total3Orden));
    	
    	 if (total1Orden >= total2Orden) {
             if (total1Orden >= total3Orden) {
				logger.debug("El mayor es: " + total1Orden);   
				getVia().getCategorizacion().setCategoria(fachada.obtenerCategoriaPorId(BigDecimal.ONE));
             } else {
				logger.debug("el mayor es: " + total3Orden);     
				getVia().getCategorizacion().setCategoria(fachada.obtenerCategoriaPorId(new BigDecimal(3)));
             }
         } else if (total2Orden >= total3Orden) {
        	 logger.debug("el mayor es: " + total2Orden);
             getVia().getCategorizacion().setCategoria(fachada.obtenerCategoriaPorId(new BigDecimal(2)));
         } else {
        	 logger.debug("el mayor es: " + total3Orden);
             getVia().getCategorizacion().setCategoria(fachada.obtenerCategoriaPorId(new BigDecimal(3)));
         }
    		
    }
    
	public void guardarCategorizacion() {
		logger.debug("categorizarViaBean - guardarCategorizacion - Inicio");
		
		String resValidacion = validarFormulario();
		
		if (resValidacion != null) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, resValidacion, null));
		}else {
			//boolean guardado = fachada.actualizarCategorizacion(via.getCategorizacion());
			boolean guardado = fachada.actualizarVia(via);
	
			if(guardado) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Datos guardados correctamente", null));
				
			}else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "No se han guardado los datos", null));
			}
		}
		PrimeFaces.current().ajax().update("growl");
		
		logger.debug("categorizarViaBean - guardarCategorizacion - Fin");
	}
  
	private String validarFormulario() {
		if (getVia().getCategorizacion().getFuncionalidad1()) {
			if (getVia().getCategorizacion().getFuncionalidad1Obs().isEmpty()) {
				return ERROR_VALIDACION_P1;   
			}
		}
		if (getVia().getCategorizacion().getFuncionalidad2()) {
			if (getVia().getCategorizacion().getFuncionalidad2Obs().isEmpty()) {
				return ERROR_VALIDACION_P1;   
			}
		}
		if (getVia().getCategorizacion().getFuncionalidad3()) {
			if (getVia().getCategorizacion().getFuncionalidad3Obs().isEmpty()) {
				return ERROR_VALIDACION_P1;   
			}
		}
		if (getVia().getCategorizacion().getFuncionalidad4()) {
			if (getVia().getCategorizacion().getFuncionalidad4Obs().isEmpty()) {
				return ERROR_VALIDACION_P1;   
			}
		}
		if (getVia().getCategorizacion().getFuncionalidad5()) {
			if (getVia().getCategorizacion().getFuncionalidad5Obs().isEmpty()) {
				return ERROR_VALIDACION_P1;   
			}
		}
		if (getVia().getCategorizacion().getFuncionalidad6()) {
			if (getVia().getCategorizacion().getFuncionalidad6Obs().isEmpty()) {
				return ERROR_VALIDACION_P1;   
			}
		}
		if (getVia().getCategorizacion().getTransito1()) {
			if (getVia().getCategorizacion().getTransito1Obs().isEmpty()) {
				return ERROR_VALIDACION_P2;   
			}
		}
		if (getVia().getCategorizacion().getTransito2()) {
			if (getVia().getCategorizacion().getTransito2Obs().isEmpty()) {
				return ERROR_VALIDACION_P2;   
			}
		}
		if (getVia().getCategorizacion().getTransito3()) {
			if (getVia().getCategorizacion().getTransito3Obs().isEmpty()) {
				return ERROR_VALIDACION_P2;   
			}
		}
		if (getVia().getCategorizacion().getDiseno1()) {
			if (getVia().getCategorizacion().getDiseno1Obs().isEmpty()) {
				return ERROR_VALIDACION_P3;   
			}
		}
		if (getVia().getCategorizacion().getDiseno2()) {
			if (getVia().getCategorizacion().getDiseno2Obs().isEmpty()) {
				return ERROR_VALIDACION_P3;   
			}
		}
		if (getVia().getCategorizacion().getDiseno3()) {
			if (getVia().getCategorizacion().getDiseno3Obs().isEmpty()) {
				return ERROR_VALIDACION_P3;   
			}
		}
		if (getVia().getCategorizacion().getPoblacion1()) {
			if (getVia().getCategorizacion().getPoblacion1Obs().isEmpty()) {
				return ERROR_VALIDACION_P4;   
			}
		}
		if (getVia().getCategorizacion().getPoblacion2()) {
			if (getVia().getCategorizacion().getPoblacion2Obs().isEmpty()) {
				return ERROR_VALIDACION_P4;   
			}
		}
		if (getVia().getCategorizacion().getPoblacion3()) {
			if (getVia().getCategorizacion().getPoblacion3Obs().isEmpty()) {
				return ERROR_VALIDACION_P4;   
			}
		}
		if (getVia().getCategorizacion().getDiseno1()) {
			if (getVia().getCategorizacion().getDiseno1Obs().isEmpty()) {
				return ERROR_VALIDACION_P3;   
			}
		}
		
		return null;
	}

	public Via getVia() {
		return via;
	}

	public void setVia(Via via) {
		this.via = via;
	}

	public MigaBean getMigaBean() {
		return migaBean;
	}

	public void setMigaBean(MigaBean migaBean) {
		this.migaBean = migaBean;
	}

	public boolean isFuncionalidad1Disabled() {
		return funcionalidad1Disabled;
	}

	public void setFuncionalidad1Disabled(boolean funcionalidad1Disabled) {
		this.funcionalidad1Disabled = funcionalidad1Disabled;
	}

	public boolean isFuncionalidad2Disabled() {
		return funcionalidad2Disabled;
	}

	public void setFuncionalidad2Disabled(boolean funcionalidad2Disabled) {
		this.funcionalidad2Disabled = funcionalidad2Disabled;
	}

	public boolean isFuncionalidad3Disabled() {
		return funcionalidad3Disabled;
	}

	public void setFuncionalidad3Disabled(boolean funcionalidad3Disabled) {
		this.funcionalidad3Disabled = funcionalidad3Disabled;
	}

	public boolean isFuncionalidad4Disabled() {
		return funcionalidad4Disabled;
	}

	public void setFuncionalidad4Disabled(boolean funcionalidad4Disabled) {
		this.funcionalidad4Disabled = funcionalidad4Disabled;
	}

	public boolean isFuncionalidad5Disabled() {
		return funcionalidad5Disabled;
	}

	public void setFuncionalidad5Disabled(boolean funcionalidad5Disabled) {
		this.funcionalidad5Disabled = funcionalidad5Disabled;
	}

	public boolean isFuncionalidad6Disabled() {
		return funcionalidad6Disabled;
	}

	public void setFuncionalidad6Disabled(boolean funcionalidad6Disabled) {
		this.funcionalidad6Disabled = funcionalidad6Disabled;
	}

	public boolean isTransito1Disabled() {
		return transito1Disabled;
	}

	public void setTransito1Disabled(boolean transito1Disabled) {
		this.transito1Disabled = transito1Disabled;
	}

	public boolean isTransito2Disabled() {
		return transito2Disabled;
	}

	public void setTransito2Disabled(boolean transito2Disabled) {
		this.transito2Disabled = transito2Disabled;
	}

	public boolean isTransito3Disabled() {
		return transito3Disabled;
	}

	public void setTransito3Disabled(boolean transito3Disabled) {
		this.transito3Disabled = transito3Disabled;
	}

	public boolean isDiseno1Disabled() {
		return diseno1Disabled;
	}

	public void setDiseno1Disabled(boolean diseno1Disabled) {
		this.diseno1Disabled = diseno1Disabled;
	}

	public boolean isDiseno2Disabled() {
		return diseno2Disabled;
	}

	public void setDiseno2Disabled(boolean diseno2Disabled) {
		this.diseno2Disabled = diseno2Disabled;
	}

	public boolean isDiseno3Disabled() {
		return diseno3Disabled;
	}

	public void setDiseno3Disabled(boolean diseno3Disabled) {
		this.diseno3Disabled = diseno3Disabled;
	}

	public boolean isDiseno4Disabled() {
		return diseno4Disabled;
	}

	public void setDiseno4Disabled(boolean diseno4Disabled) {
		this.diseno4Disabled = diseno4Disabled;
	}

	public boolean isPoblacion1Disabled() {
		return poblacion1Disabled;
	}

	public void setPoblacion1Disabled(boolean poblacion1Disabled) {
		this.poblacion1Disabled = poblacion1Disabled;
	}

	public boolean isPoblacion2Disabled() {
		return poblacion2Disabled;
	}

	public void setPoblacion2Disabled(boolean poblacion2Disabled) {
		this.poblacion2Disabled = poblacion2Disabled;
	}

	public boolean isPoblacion3Disabled() {
		return poblacion3Disabled;
	}

	public void setPoblacion3Disabled(boolean poblacion3Disabled) {
		this.poblacion3Disabled = poblacion3Disabled;
	}
}
