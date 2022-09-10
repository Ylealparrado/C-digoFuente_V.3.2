package es.everis.gvias.beans;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import es.everis.gvias.core.appbase.model.integration.dao.generado.ActividadModeloTeorico;
import es.everis.gvias.core.appbase.model.integration.dao.generado.AnalisisEstimacion;
import es.everis.gvias.core.appbase.model.integration.dao.generado.AnalisisPrecios;
import es.everis.gvias.core.appbase.model.integration.dao.generado.Municipio;
import es.everis.gvias.core.appbase.model.integration.dao.generado.Via;
import es.everis.gvias.navigation.MigaBean;

@ManagedBean(name = "analisisBean")
@ViewScoped
public class AnalisisBean implements Serializable{

	private static final String MANTENIMIENTO_RUTINARIO = "Mantenimiento Rutinario";
	private static final String MANTENIMIENTO_PERIODICO = "Mantenimiento Periódico";
	private static final String REHABILITACION = "Rehabilitación";   

	/**
	 * 
	 */
	private static final long serialVersionUID = -1809537380170748421L;

	/** Variable log. */
	private static Logger logger = LogManager.getLogger();
	
    private Fachada fachada;
    
	@ManagedProperty(value="#{migaBean}")
	private MigaBean migaBean;
    
    @ManagedProperty("#{listadoViaBean.listaVias}")
    private List<Via> listaVias;
    
    private AnalisisPrecios preciosMunicipio;
	
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
    	logger.debug("EstimacionBean - cargarDatos - Inicio");
    	
//    	INICIALIZAR VARIABLES
    	fachada = new Fachada();

    	if(migaBean.getMunicipioId() != null) {
    		
    		preciosMunicipio = fachada.obtenerPreciosPorMunicipio(migaBean.getMunicipioId());
    		
    		if (preciosMunicipio == null) {
    			preciosMunicipio = new AnalisisPrecios();
    			Municipio municipio = fachada.obtenerMunicipioPorId(migaBean.getMunicipioId());
    			preciosMunicipio.setMunicipio(municipio);
    		}

    	}

    	logger.debug("EstimacionBean - cargarDatos - Fin");
    }
    
    
	public void guardarAnalisis() {
		logger.debug("EstimacionBean - guardarAnalisis - Inicio");
		
//		String resValidacion = validarFormulario();
		String resValidacion = null;
		
		if (resValidacion != null) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, resValidacion, null));
		}else {
			
			  //////////////////////////////////
			 //Cálculo de precios años 2 a 10//
			//////////////////////////////////
			if (preciosMunicipio.getIpc() != null) {
				Double IPC = 1+preciosMunicipio.getIpc()/100;
				
				if (preciosMunicipio.getAfirmBueno1() != null) {
					preciosMunicipio.setAfirmBueno2((preciosMunicipio.getAfirmBueno1() - (preciosMunicipio.getAfirmBueno1()*25/100)) * IPC); //(precio1 - 25%) * IPC
					preciosMunicipio.setAfirmBueno3(preciosMunicipio.getAfirmBueno2() * (IPC));
					preciosMunicipio.setAfirmBueno4(preciosMunicipio.getAfirmBueno3() * (IPC));
					preciosMunicipio.setAfirmBueno5(preciosMunicipio.getAfirmBueno4() * (IPC));
					preciosMunicipio.setAfirmBueno6(preciosMunicipio.getAfirmBueno5() * (IPC));
					preciosMunicipio.setAfirmBueno7(preciosMunicipio.getAfirmBueno6() * (IPC));
					preciosMunicipio.setAfirmBueno8(preciosMunicipio.getAfirmBueno7() * (IPC));
					preciosMunicipio.setAfirmBueno9(preciosMunicipio.getAfirmBueno8() * (IPC));
					preciosMunicipio.setAfirmBueno10(preciosMunicipio.getAfirmBueno9() * (IPC));
				}
				
				if (preciosMunicipio.getAfirmRegular1() != null) {
					preciosMunicipio.setAfirmRegular2(preciosMunicipio.getAfirmRegular1() * (IPC));
					preciosMunicipio.setAfirmRegular3(preciosMunicipio.getAfirmRegular2() * (IPC));
					preciosMunicipio.setAfirmRegular4(preciosMunicipio.getAfirmRegular3() * (IPC));
					preciosMunicipio.setAfirmRegular5(preciosMunicipio.getAfirmRegular4() * (IPC));
					preciosMunicipio.setAfirmRegular6(preciosMunicipio.getAfirmRegular5() * (IPC));
					preciosMunicipio.setAfirmRegular7(preciosMunicipio.getAfirmRegular6() * (IPC));
					preciosMunicipio.setAfirmRegular8(preciosMunicipio.getAfirmRegular7() * (IPC));
					preciosMunicipio.setAfirmRegular9(preciosMunicipio.getAfirmRegular8() * (IPC));
					preciosMunicipio.setAfirmRegular10(preciosMunicipio.getAfirmRegular9() * (IPC));
				}
	
				if (preciosMunicipio.getAfirmMalo1() != null) {
					preciosMunicipio.setAfirmMalo2(preciosMunicipio.getAfirmMalo1() * (IPC));
					preciosMunicipio.setAfirmMalo3(preciosMunicipio.getAfirmMalo2() * (IPC));
					preciosMunicipio.setAfirmMalo4(preciosMunicipio.getAfirmMalo3() * (IPC));
					preciosMunicipio.setAfirmMalo5(preciosMunicipio.getAfirmMalo4() * (IPC));
					preciosMunicipio.setAfirmMalo6(preciosMunicipio.getAfirmMalo5() * (IPC));
					preciosMunicipio.setAfirmMalo7(preciosMunicipio.getAfirmMalo6() * (IPC));
					preciosMunicipio.setAfirmMalo8(preciosMunicipio.getAfirmMalo7() * (IPC));
					preciosMunicipio.setAfirmMalo9(preciosMunicipio.getAfirmMalo8() * (IPC));
					preciosMunicipio.setAfirmMalo10(preciosMunicipio.getAfirmMalo9() * (IPC));
				}
				
				if (preciosMunicipio.getTierraBueno1() != null) {
					preciosMunicipio.setTierraBueno2((preciosMunicipio.getTierraBueno1() - (preciosMunicipio.getTierraBueno1()*25/100)) * IPC); //(precio1 - 25%) * IPC
					preciosMunicipio.setTierraBueno3(preciosMunicipio.getTierraBueno2() * (IPC));
					preciosMunicipio.setTierraBueno4(preciosMunicipio.getTierraBueno3() * (IPC));
					preciosMunicipio.setTierraBueno5(preciosMunicipio.getTierraBueno4() * (IPC));
					preciosMunicipio.setTierraBueno6(preciosMunicipio.getTierraBueno5() * (IPC));
					preciosMunicipio.setTierraBueno7(preciosMunicipio.getTierraBueno6() * (IPC));
					preciosMunicipio.setTierraBueno8(preciosMunicipio.getTierraBueno7() * (IPC));
					preciosMunicipio.setTierraBueno9(preciosMunicipio.getTierraBueno8() * (IPC));
					preciosMunicipio.setTierraBueno10(preciosMunicipio.getTierraBueno9() * (IPC));
				}
				
				if (preciosMunicipio.getTierraRegular1() != null) {
					preciosMunicipio.setTierraRegular2(preciosMunicipio.getTierraRegular1() * (IPC));
					preciosMunicipio.setTierraRegular3(preciosMunicipio.getTierraRegular2() * (IPC));
					preciosMunicipio.setTierraRegular4(preciosMunicipio.getTierraRegular3() * (IPC));
					preciosMunicipio.setTierraRegular5(preciosMunicipio.getTierraRegular4() * (IPC));
					preciosMunicipio.setTierraRegular6(preciosMunicipio.getTierraRegular5() * (IPC));
					preciosMunicipio.setTierraRegular7(preciosMunicipio.getTierraRegular6() * (IPC));
					preciosMunicipio.setTierraRegular8(preciosMunicipio.getTierraRegular7() * (IPC));
					preciosMunicipio.setTierraRegular9(preciosMunicipio.getTierraRegular8() * (IPC));
					preciosMunicipio.setTierraRegular10(preciosMunicipio.getTierraRegular9() * (IPC));
				}
	
				if (preciosMunicipio.getTierraMalo1() != null) {
					preciosMunicipio.setTierraMalo2(preciosMunicipio.getTierraMalo1() * (IPC));
					preciosMunicipio.setTierraMalo3(preciosMunicipio.getTierraMalo2() * (IPC));
					preciosMunicipio.setTierraMalo4(preciosMunicipio.getTierraMalo3() * (IPC));
					preciosMunicipio.setTierraMalo5(preciosMunicipio.getTierraMalo4() * (IPC));
					preciosMunicipio.setTierraMalo6(preciosMunicipio.getTierraMalo5() * (IPC));
					preciosMunicipio.setTierraMalo7(preciosMunicipio.getTierraMalo6() * (IPC));
					preciosMunicipio.setTierraMalo8(preciosMunicipio.getTierraMalo7() * (IPC));
					preciosMunicipio.setTierraMalo9(preciosMunicipio.getTierraMalo8() * (IPC));
					preciosMunicipio.setTierraMalo10(preciosMunicipio.getTierraMalo9() * (IPC));
				}
				
				if (preciosMunicipio.getPavimBueno1() != null) {
					preciosMunicipio.setPavimBueno2((preciosMunicipio.getPavimBueno1() - (preciosMunicipio.getPavimBueno1()*25/100)) * IPC); //(precio1 - 25%) * IPC
					preciosMunicipio.setPavimBueno3(preciosMunicipio.getPavimBueno2() * (IPC));
					preciosMunicipio.setPavimBueno4(preciosMunicipio.getPavimBueno3() * (IPC));
					preciosMunicipio.setPavimBueno5(preciosMunicipio.getPavimBueno4() * (IPC));
					preciosMunicipio.setPavimBueno6(preciosMunicipio.getPavimBueno5() * (IPC));
					preciosMunicipio.setPavimBueno7(preciosMunicipio.getPavimBueno6() * (IPC));
					preciosMunicipio.setPavimBueno8(preciosMunicipio.getPavimBueno7() * (IPC));
					preciosMunicipio.setPavimBueno9(preciosMunicipio.getPavimBueno8() * (IPC));
					preciosMunicipio.setPavimBueno10(preciosMunicipio.getPavimBueno9() * (IPC));
				}
				
				if (preciosMunicipio.getPavimRegular1() != null) {
					preciosMunicipio.setPavimRegular2(preciosMunicipio.getPavimRegular1() * (IPC));
					preciosMunicipio.setPavimRegular3(preciosMunicipio.getPavimRegular2() * (IPC));
					preciosMunicipio.setPavimRegular4(preciosMunicipio.getPavimRegular3() * (IPC));
					preciosMunicipio.setPavimRegular5(preciosMunicipio.getPavimRegular4() * (IPC));
					preciosMunicipio.setPavimRegular6(preciosMunicipio.getPavimRegular5() * (IPC));
					preciosMunicipio.setPavimRegular7(preciosMunicipio.getPavimRegular6() * (IPC));
					preciosMunicipio.setPavimRegular8(preciosMunicipio.getPavimRegular7() * (IPC));
					preciosMunicipio.setPavimRegular9(preciosMunicipio.getPavimRegular8() * (IPC));
					preciosMunicipio.setPavimRegular10(preciosMunicipio.getPavimRegular9() * (IPC));
				}
	
				if (preciosMunicipio.getPavimMalo1() != null) {
					preciosMunicipio.setPavimMalo2(preciosMunicipio.getPavimMalo1() * (IPC));
					preciosMunicipio.setPavimMalo3(preciosMunicipio.getPavimMalo2() * (IPC));
					preciosMunicipio.setPavimMalo4(preciosMunicipio.getPavimMalo3() * (IPC));
					preciosMunicipio.setPavimMalo5(preciosMunicipio.getPavimMalo4() * (IPC));
					preciosMunicipio.setPavimMalo6(preciosMunicipio.getPavimMalo5() * (IPC));
					preciosMunicipio.setPavimMalo7(preciosMunicipio.getPavimMalo6() * (IPC));
					preciosMunicipio.setPavimMalo8(preciosMunicipio.getPavimMalo7() * (IPC));
					preciosMunicipio.setPavimMalo9(preciosMunicipio.getPavimMalo8() * (IPC));
					preciosMunicipio.setPavimMalo10(preciosMunicipio.getPavimMalo9() * (IPC));
				}
				Calendar cal = Calendar.getInstance();
				preciosMunicipio.setAnioActual(new BigDecimal(cal.get(Calendar.YEAR)));
				preciosMunicipio.setAnioReprogramacion(BigDecimal.ONE);
			}
			
			boolean guardado = fachada.actualizarPrecios(preciosMunicipio);

			  ////////////////////////////////////////////////////
			 //Cálculo de estimaciones de inversión años 1 a 10//
			////////////////////////////////////////////////////
			if (guardado) {
				for (Via via : listaVias) {
					//Coger vía, sacar longitud buenaAfirm, regularAfirm. malaAfirm, buenaTierra, regularTierra. malaTierra, buenaPavim, regularPavim. malaPavim,  
					double rutinario1 = 0, rutinario2 = 0, rutinario3 = 0, rutinario4 = 0, rutinario5 = 0, rutinario6 = 0, rutinario7 = 0, rutinario8 = 0, rutinario9 = 0, rutinario10 = 0,
							periodico1 = 0, periodico2 = 0, periodico3 = 0, periodico4 = 0, periodico5 = 0, periodico6 = 0, periodico7 = 0, periodico8 = 0, periodico9 = 0, periodico10 = 0,
							rehabilitacion1 = 0, rehabilitacion2 = 0, rehabilitacion3 = 0, rehabilitacion4 = 0, rehabilitacion5 = 0, rehabilitacion6 = 0, rehabilitacion7 = 0, rehabilitacion8 = 0, rehabilitacion9 = 0, rehabilitacion10 = 0;
					
										
					//MANTENIMIENTO RUTINARIO, todos los años a todas las vías
					if (via.getAfirmTotal() != null && via.getAfirmTotal() > 0) {
						rutinario1 += preciosMunicipio.getAfirmBueno1()*via.getAfirmTotal();
						rutinario2 += preciosMunicipio.getAfirmBueno2()*via.getAfirmTotal();
						rutinario3 += preciosMunicipio.getAfirmBueno3()*via.getAfirmTotal();
						rutinario4 += preciosMunicipio.getAfirmBueno4()*via.getAfirmTotal();
						rutinario5 += preciosMunicipio.getAfirmBueno5()*via.getAfirmTotal();
						rutinario6 += preciosMunicipio.getAfirmBueno6()*via.getAfirmTotal();
						rutinario7 += preciosMunicipio.getAfirmBueno7()*via.getAfirmTotal();
						rutinario8 += preciosMunicipio.getAfirmBueno8()*via.getAfirmTotal();
						rutinario9 += preciosMunicipio.getAfirmBueno9()*via.getAfirmTotal();
						rutinario10 += preciosMunicipio.getAfirmBueno10()*via.getAfirmTotal();
					}
					
					if (via.getTierraTotal() != null && via.getTierraTotal() > 0) {
						rutinario1 += preciosMunicipio.getTierraBueno1()*via.getTierraTotal();
						rutinario2 += preciosMunicipio.getTierraBueno2()*via.getTierraTotal();
						rutinario3 += preciosMunicipio.getTierraBueno3()*via.getTierraTotal();
						rutinario4 += preciosMunicipio.getTierraBueno4()*via.getTierraTotal();
						rutinario5 += preciosMunicipio.getTierraBueno5()*via.getTierraTotal();
						rutinario6 += preciosMunicipio.getTierraBueno6()*via.getTierraTotal();
						rutinario7 += preciosMunicipio.getTierraBueno7()*via.getTierraTotal();
						rutinario8 += preciosMunicipio.getTierraBueno8()*via.getTierraTotal();
						rutinario9 += preciosMunicipio.getTierraBueno9()*via.getTierraTotal();
						rutinario10 += preciosMunicipio.getTierraBueno10()*via.getTierraTotal();
					}
					if (via.getPavimTotal() != null && via.getPavimTotal() > 0) {
						rutinario1 += preciosMunicipio.getPavimBueno1()*via.getPavimTotal();
						rutinario2 += preciosMunicipio.getPavimBueno2()*via.getPavimTotal();
						rutinario3 += preciosMunicipio.getPavimBueno3()*via.getPavimTotal();
						rutinario4 += preciosMunicipio.getPavimBueno4()*via.getPavimTotal();
						rutinario5 += preciosMunicipio.getPavimBueno5()*via.getPavimTotal();
						rutinario6 += preciosMunicipio.getPavimBueno6()*via.getPavimTotal();
						rutinario7 += preciosMunicipio.getPavimBueno7()*via.getPavimTotal();
						rutinario8 += preciosMunicipio.getPavimBueno8()*via.getPavimTotal();
						rutinario9 += preciosMunicipio.getPavimBueno9()*via.getPavimTotal();
						rutinario10 += preciosMunicipio.getPavimBueno10()*via.getPavimTotal();
					}
					
					
					//Año1 periodico a tramos regulares de vías verdes // Rehabilitacion a tramos malos de vías verdes
					if (via.getGrupoPrioridadPv().equals(BigDecimal.ONE)) {//verde
						if (via.getAfirmRegular() != null && via.getAfirmRegular() > 0) {
							periodico1 += preciosMunicipio.getAfirmRegular1() * via.getAfirmRegular();
						}
						if (via.getTierraRegular() != null && via.getTierraRegular() > 0) {
							periodico1 += preciosMunicipio.getTierraRegular1() * via.getTierraRegular();
						}
						if (via.getPavimRegular() != null && via.getPavimRegular() > 0) {
							periodico1 += preciosMunicipio.getPavimRegular1() * via.getPavimRegular();
						}
						
						if (via.getAfirmMalo() != null && via.getAfirmMalo() > 0) {
							rehabilitacion1 += preciosMunicipio.getAfirmMalo1() * via.getAfirmMalo();
						}
						if (via.getTierraRegular() != null && via.getTierraRegular() > 0) {
							rehabilitacion1 += preciosMunicipio.getTierraMalo1() * via.getTierraMalo();
						}
						if (via.getPavimMalo() != null && via.getPavimMalo() > 0) {
							rehabilitacion1 += preciosMunicipio.getPavimMalo1() * via.getPavimMalo();
						}
						
						//Año 5 periódico a toda la longitud de las vías verdes
						periodico5 += preciosMunicipio.getAfirmRegular5() * via.getAfirmTotal();
						periodico5 += preciosMunicipio.getTierraRegular5() * via.getTierraTotal();
						periodico5 += preciosMunicipio.getPavimRegular5() * via.getPavimTotal();
						
						//Año 9 periódico a toda la longitud de las vías verdes
						periodico9 += preciosMunicipio.getAfirmRegular9() * via.getAfirmTotal();
						periodico9 += preciosMunicipio.getTierraRegular9() * via.getTierraTotal();
						periodico9 += preciosMunicipio.getPavimRegular9() * via.getPavimTotal();
					}
					
					//Año2 periodico a tramos regulares de vías verdes // Rehabilitacion a tramos malos de vías naranjas
					if (via.getGrupoPrioridadPv().equals(new BigDecimal(2))) {//naranja
						if (via.getAfirmRegular() != null && via.getAfirmRegular() > 0) {
							periodico2 += preciosMunicipio.getAfirmRegular2() * via.getAfirmRegular();
						}
						if (via.getTierraRegular() != null && via.getTierraRegular() > 0) {
							periodico2 += preciosMunicipio.getTierraRegular2() * via.getTierraRegular();
						}
						if (via.getPavimRegular() != null && via.getPavimRegular() > 0) {
							periodico2 += preciosMunicipio.getPavimRegular2() * via.getPavimRegular();
						}
						
						if (via.getAfirmMalo() != null && via.getAfirmMalo() > 0) {
							rehabilitacion2 += preciosMunicipio.getAfirmMalo2() * via.getAfirmMalo();
						}
						if (via.getTierraRegular() != null && via.getTierraRegular() > 0) {
							rehabilitacion2 += preciosMunicipio.getTierraMalo2() * via.getTierraMalo();
						}
						if (via.getPavimMalo() != null && via.getPavimMalo() > 0) {
							rehabilitacion2 += preciosMunicipio.getPavimMalo2() * via.getPavimMalo();
						}
						//Año 6 periódico a toda la longitud de las vías naranjas
						periodico6 += preciosMunicipio.getAfirmRegular6() * via.getAfirmTotal();
						periodico6 += preciosMunicipio.getTierraRegular6() * via.getTierraTotal();
						periodico6 += preciosMunicipio.getPavimRegular6() * via.getPavimTotal();
						
						//Año 10 periódico a toda la longitud de las vías naranjas
						periodico10 += preciosMunicipio.getAfirmRegular10() * via.getAfirmTotal();
						periodico10 += preciosMunicipio.getTierraRegular10() * via.getTierraTotal();
						periodico10 += preciosMunicipio.getPavimRegular10() * via.getPavimTotal();
					}
					
					//Año3 periodico a tramos regulares de vías verdes // Rehabilitacion a tramos malos de vías rojas
					if (via.getGrupoPrioridadPv().equals(new BigDecimal(3))) {//naranja
						if (via.getAfirmRegular() != null && via.getAfirmRegular() > 0) {
							periodico3 += preciosMunicipio.getAfirmRegular3() * via.getAfirmRegular();
						}
						if (via.getTierraRegular() != null && via.getTierraRegular() > 0) {
							periodico3 += preciosMunicipio.getTierraRegular3() * via.getTierraRegular();
						}
						if (via.getPavimRegular() != null && via.getPavimRegular() > 0) {
							periodico3 += preciosMunicipio.getPavimRegular3() * via.getPavimRegular();
						}
						
						if (via.getAfirmMalo() != null && via.getAfirmMalo() > 0) {
							rehabilitacion3 += preciosMunicipio.getAfirmMalo3() * via.getAfirmMalo();
						}
						if (via.getTierraRegular() != null && via.getTierraRegular() > 0) {
							rehabilitacion3 += preciosMunicipio.getTierraMalo3() * via.getTierraMalo();
						}
						if (via.getPavimMalo() != null && via.getPavimMalo() > 0) {
							rehabilitacion3 += preciosMunicipio.getPavimMalo3() * via.getPavimMalo();
						}
						
						//Año 7 periódico a toda la longitud de las vías rojas
						periodico7 += preciosMunicipio.getAfirmRegular7() * via.getAfirmTotal();
						periodico7 += preciosMunicipio.getTierraRegular7() * via.getTierraTotal();
						periodico7 += preciosMunicipio.getPavimRegular7() * via.getPavimTotal();
					}
					
					
					if (via.getAnalisisEstimacion() == null) {
						via.setAnalisisEstimacion(new AnalisisEstimacion());
					}
					
					via.getAnalisisEstimacion().setRutinario1(rutinario1);
					via.getAnalisisEstimacion().setRutinario2(rutinario2);
					via.getAnalisisEstimacion().setRutinario3(rutinario3);
					via.getAnalisisEstimacion().setRutinario4(rutinario4);
					via.getAnalisisEstimacion().setRutinario5(rutinario5);
					via.getAnalisisEstimacion().setRutinario6(rutinario6);
					via.getAnalisisEstimacion().setRutinario7(rutinario7);
					via.getAnalisisEstimacion().setRutinario8(rutinario8);
					via.getAnalisisEstimacion().setRutinario9(rutinario9);
					via.getAnalisisEstimacion().setRutinario10(rutinario10);
					
					via.getAnalisisEstimacion().setPeriodico1(periodico1);
					via.getAnalisisEstimacion().setPeriodico2(periodico2);
					via.getAnalisisEstimacion().setPeriodico3(periodico3);
					via.getAnalisisEstimacion().setPeriodico4(periodico4);
					via.getAnalisisEstimacion().setPeriodico5(periodico5);
					via.getAnalisisEstimacion().setPeriodico6(periodico6);
					via.getAnalisisEstimacion().setPeriodico7(periodico7);
					via.getAnalisisEstimacion().setPeriodico8(periodico8);
					via.getAnalisisEstimacion().setPeriodico9(periodico9);
					via.getAnalisisEstimacion().setPeriodico10(periodico10);

					via.getAnalisisEstimacion().setRehabilitacion1(rehabilitacion1);
					via.getAnalisisEstimacion().setRehabilitacion2(rehabilitacion2);
					via.getAnalisisEstimacion().setRehabilitacion3(rehabilitacion3);
					via.getAnalisisEstimacion().setRehabilitacion4(rehabilitacion4);
					via.getAnalisisEstimacion().setRehabilitacion5(rehabilitacion5);
					via.getAnalisisEstimacion().setRehabilitacion6(rehabilitacion6);
					via.getAnalisisEstimacion().setRehabilitacion7(rehabilitacion7);
					via.getAnalisisEstimacion().setRehabilitacion8(rehabilitacion8);
					via.getAnalisisEstimacion().setRehabilitacion9(rehabilitacion9);
					via.getAnalisisEstimacion().setRehabilitacion10(rehabilitacion10);
					
					via.getAnalisisEstimacion().setReproRutinario1(rutinario1);
					via.getAnalisisEstimacion().setReproPeriodico1(periodico1);
					via.getAnalisisEstimacion().setReproRehabilitacion1(rehabilitacion1);
					
					via.getAnalisisEstimacion().setReproRutinario2(null);
					via.getAnalisisEstimacion().setReproRutinario3(null);
					via.getAnalisisEstimacion().setReproRutinario4(null);
					via.getAnalisisEstimacion().setReproRutinario5(null);
					via.getAnalisisEstimacion().setReproRutinario6(null);
					via.getAnalisisEstimacion().setReproRutinario7(null);
					via.getAnalisisEstimacion().setReproRutinario8(null);
					via.getAnalisisEstimacion().setReproRutinario9(null);
					via.getAnalisisEstimacion().setReproRutinario10(null);

					via.getAnalisisEstimacion().setReproPeriodico2(null);
					via.getAnalisisEstimacion().setReproPeriodico3(null);
					via.getAnalisisEstimacion().setReproPeriodico4(null);
					via.getAnalisisEstimacion().setReproPeriodico5(null);
					via.getAnalisisEstimacion().setReproPeriodico6(null);
					via.getAnalisisEstimacion().setReproPeriodico7(null);
					via.getAnalisisEstimacion().setReproPeriodico8(null);
					via.getAnalisisEstimacion().setReproPeriodico9(null);
					via.getAnalisisEstimacion().setReproPeriodico10(null);

					via.getAnalisisEstimacion().setReproRehabilitacion2(null);
					via.getAnalisisEstimacion().setReproRehabilitacion3(null);
					via.getAnalisisEstimacion().setReproRehabilitacion4(null);
					via.getAnalisisEstimacion().setReproRehabilitacion5(null);
					via.getAnalisisEstimacion().setReproRehabilitacion6(null);
					via.getAnalisisEstimacion().setReproRehabilitacion7(null);
					via.getAnalisisEstimacion().setReproRehabilitacion8(null);
					via.getAnalisisEstimacion().setReproRehabilitacion9(null);
					via.getAnalisisEstimacion().setReproRehabilitacion10(null);
					
					guardado = fachada.actualizarVia(via);
				}
			}
	
			if(guardado) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Datos guardados correctamente", null));
				PrimeFaces.current().ajax().update("analisisCostesForm:analisisCostesView:panelPrecios");
				PrimeFaces.current().ajax().update("analisisCostesForm:analisisCostesView:estimacionTable");
				PrimeFaces.current().ajax().update("analisisCostesForm:analisisCostesView:reproTable");
				PrimeFaces.current().ajax().update("analisisCostesForm:analisisCostesView:anioActualRepro");
				PrimeFaces.current().ajax().update("analisisCostesForm:analisisCostesView:anioActualPrecios");
				PrimeFaces.current().ajax().update("analisisCostesForm:analisisCostesView:anioActualEstimacion");
			}else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "No se han guardado los datos", null));
			}
		}
		PrimeFaces.current().ajax().update("growl");
		
		logger.debug("EstimacionBean - guardarAnalisis -Fin");
	}
	
	
	public void reprogramarAnalisis() {
		
		
		boolean guardado = false;
				
		Map<String, Double> costesPorActividad = new HashMap<String, Double>();
				
		for (Via via : listaVias) {
			costesPorActividad.put(MANTENIMIENTO_RUTINARIO, 0.);
			costesPorActividad.put(MANTENIMIENTO_PERIODICO, 0.);
			costesPorActividad.put(REHABILITACION, 0.);
			
			//BORRAR!!! 
			costesPorActividad.put("leo", 0.);
			
			List<ActividadModeloTeorico> actividadesAnio = fachada.obtenerActividadesPorViaYFecha(via.getIdVia(), preciosMunicipio.getAnioActual());
			for (ActividadModeloTeorico actividad : actividadesAnio) {
				costesPorActividad.put(actividad.getTipo(), costesPorActividad.get(actividad.getTipo())+actividad.getCosto());
			}
	
			switch (preciosMunicipio.getAnioReprogramacion().intValue()) {
			case 1:				//1 al 2
				if (costesPorActividad.get(MANTENIMIENTO_RUTINARIO) < via.getAnalisisEstimacion().getRutinario1()) { //si se ha invertido menos de lo necesario
					via.getAnalisisEstimacion().setReproRutinario2(via.getAnalisisEstimacion().getRutinario2() + (via.getAnalisisEstimacion().getRutinario1() - costesPorActividad.get(MANTENIMIENTO_RUTINARIO))); //en repro2 ponemos el estimado + el déficit
				} else {
					via.getAnalisisEstimacion().setReproRutinario2(via.getAnalisisEstimacion().getRutinario2()); //en repro2 ponemos el estimado
				}
				via.getAnalisisEstimacion().setReproRutinario1(costesPorActividad.get(MANTENIMIENTO_RUTINARIO)); //en repro1 dejamos el real 
				
				if (costesPorActividad.get(MANTENIMIENTO_PERIODICO) < via.getAnalisisEstimacion().getPeriodico1()) { //si se ha invertido menos de lo necesario
					via.getAnalisisEstimacion().setReproPeriodico2(via.getAnalisisEstimacion().getPeriodico2() + (via.getAnalisisEstimacion().getPeriodico1() - costesPorActividad.get(MANTENIMIENTO_PERIODICO))); //en repro2 ponemos el estimado + el déficit
				} else {
					via.getAnalisisEstimacion().setReproPeriodico2(via.getAnalisisEstimacion().getPeriodico2()); //en repro2 ponemos el estimado
				}
				via.getAnalisisEstimacion().setReproPeriodico1(costesPorActividad.get(MANTENIMIENTO_PERIODICO)); //en repro1 dejamos el real 
				
				if (costesPorActividad.get(REHABILITACION) < via.getAnalisisEstimacion().getRehabilitacion1()) { //si se ha invertido menos de lo necesario
					via.getAnalisisEstimacion().setReproRehabilitacion2(via.getAnalisisEstimacion().getRehabilitacion2() + (via.getAnalisisEstimacion().getRehabilitacion1() - costesPorActividad.get(REHABILITACION))); //en repro2 ponemos el estimado + el déficit
				} else {
					via.getAnalisisEstimacion().setReproRehabilitacion2(via.getAnalisisEstimacion().getRehabilitacion2()); //en repro2 ponemos el estimado
				}
				via.getAnalisisEstimacion().setReproRehabilitacion1(costesPorActividad.get(REHABILITACION)); //en repro1 dejamos el real 
				
				break;
				
			case 2:			//2 al 3		
				if (costesPorActividad.get(MANTENIMIENTO_RUTINARIO) < via.getAnalisisEstimacion().getReproRutinario2()) { //si se ha invertido menos de lo necesario según lo reprogramado
					via.getAnalisisEstimacion().setReproRutinario3(via.getAnalisisEstimacion().getRutinario3() + (via.getAnalisisEstimacion().getReproRutinario2() - costesPorActividad.get(MANTENIMIENTO_RUTINARIO))); //en repro3 ponemos el reprogramado2 + el déficit
				} else {
					via.getAnalisisEstimacion().setReproRutinario3(via.getAnalisisEstimacion().getRutinario3()); //en repro3 ponemos el estimado
				}
				via.getAnalisisEstimacion().setReproRutinario2(costesPorActividad.get(MANTENIMIENTO_RUTINARIO)); //en repro2 dejamos el real 
				
				if (costesPorActividad.get(MANTENIMIENTO_PERIODICO) < via.getAnalisisEstimacion().getReproPeriodico2()) { //si se ha invertido menos de lo necesario egún lo reprogramado
					via.getAnalisisEstimacion().setReproPeriodico3(via.getAnalisisEstimacion().getPeriodico3() + (via.getAnalisisEstimacion().getReproPeriodico2() - costesPorActividad.get(MANTENIMIENTO_PERIODICO))); //en repro2 ponemos el estimado + el déficit
				} else {
					via.getAnalisisEstimacion().setReproPeriodico3(via.getAnalisisEstimacion().getPeriodico3()); //en repro3 ponemos el estimado
				}
				via.getAnalisisEstimacion().setReproPeriodico2(costesPorActividad.get(MANTENIMIENTO_PERIODICO)); //en repro2 dejamos el real 
				
				if (costesPorActividad.get(REHABILITACION) < via.getAnalisisEstimacion().getReproRehabilitacion2()) { //si se ha invertido menos de lo necesario egún lo reprogramado
					via.getAnalisisEstimacion().setReproRehabilitacion3(via.getAnalisisEstimacion().getRehabilitacion3() + (via.getAnalisisEstimacion().getReproRehabilitacion2() - costesPorActividad.get(REHABILITACION))); //en repro2 ponemos el estimado + el déficit
				} else {
					via.getAnalisisEstimacion().setReproRehabilitacion3(via.getAnalisisEstimacion().getRehabilitacion3()); //en repro3 ponemos el estimado
				}
				via.getAnalisisEstimacion().setReproRehabilitacion2(costesPorActividad.get(REHABILITACION)); //en repro2 dejamos el real 
				
				break;
				
				
			case 3:			//3 al 4		
				if (costesPorActividad.get(MANTENIMIENTO_RUTINARIO) < via.getAnalisisEstimacion().getReproRutinario3()) { //si se ha invertido menos de lo necesario según lo reprogramado
					via.getAnalisisEstimacion().setReproRutinario4(via.getAnalisisEstimacion().getRutinario4() + (via.getAnalisisEstimacion().getReproRutinario3() - costesPorActividad.get(MANTENIMIENTO_RUTINARIO))); //en repro3 ponemos el reprogramado2 + el déficit
				} else {
					via.getAnalisisEstimacion().setReproRutinario4(via.getAnalisisEstimacion().getRutinario4()); //en repro4 ponemos el estimado
				}
				via.getAnalisisEstimacion().setReproRutinario3(costesPorActividad.get(MANTENIMIENTO_RUTINARIO)); //en repro3 dejamos el real 
				
				if (costesPorActividad.get(MANTENIMIENTO_PERIODICO) < via.getAnalisisEstimacion().getReproPeriodico3()) { //si se ha invertido menos de lo necesario egún lo reprogramado
					via.getAnalisisEstimacion().setReproPeriodico4(via.getAnalisisEstimacion().getPeriodico4() + (via.getAnalisisEstimacion().getReproPeriodico3() - costesPorActividad.get(MANTENIMIENTO_PERIODICO))); //en repro2 ponemos el estimado + el déficit
				} else {
					via.getAnalisisEstimacion().setReproPeriodico4(via.getAnalisisEstimacion().getPeriodico4()); //en repro4 ponemos el estimado
				}
				via.getAnalisisEstimacion().setReproPeriodico3(costesPorActividad.get(MANTENIMIENTO_PERIODICO)); //en repro3 dejamos el real 
				
				if (costesPorActividad.get(REHABILITACION) < via.getAnalisisEstimacion().getReproRehabilitacion3()) { //si se ha invertido menos de lo necesario egún lo reprogramado
					via.getAnalisisEstimacion().setReproRehabilitacion3(via.getAnalisisEstimacion().getRehabilitacion4() + (via.getAnalisisEstimacion().getReproRehabilitacion3() - costesPorActividad.get(REHABILITACION))); //en repro2 ponemos el estimado + el déficit
				} else {
					via.getAnalisisEstimacion().setReproRehabilitacion4(via.getAnalisisEstimacion().getRehabilitacion4()); //en repro4 ponemos el estimado
				}
				via.getAnalisisEstimacion().setReproRehabilitacion3(costesPorActividad.get(REHABILITACION)); //en repro3 dejamos el real 
				
				break;
	
			default:
				break;
			}			
			
			guardado = fachada.actualizarVia(via);
		}
		
		preciosMunicipio.setAnioActual(preciosMunicipio.getAnioActual().add(BigDecimal.ONE)); //sumamos 1 al año actual para filtrar actividades
		preciosMunicipio.setAnioReprogramacion(preciosMunicipio.getAnioReprogramacion().add(BigDecimal.ONE));//sumamos 1 al año de reprogramacion
		
		if (guardado) {
			guardado = fachada.actualizarPrecios(preciosMunicipio);
		}
		
		if(guardado) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Reprogramación completada correctamente", null));
			PrimeFaces.current().ajax().update("analisisCostesForm:analisisCostesView:reproTable");
			PrimeFaces.current().ajax().update("analisisCostesForm:analisisCostesView:anioActualRepro");
			PrimeFaces.current().ajax().update("analisisCostesForm:analisisCostesView:anioActualPrecios");
			PrimeFaces.current().ajax().update("analisisCostesForm:analisisCostesView:anioActualEstimacion");
		}else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error al reprogramar", null));
		}
		PrimeFaces.current().ajax().update("growl");
	}

	public static void main(String[] args) {
		AnalisisEstimacion leo = new AnalisisEstimacion();

        try {
            Method methodToPass = AnalisisEstimacion.class.getMethod("setRehabilitacion2", Double.class);
            Method methodToPass2 = AnalisisEstimacion.class.getMethod("getRehabilitacion2");
			leo.metodoSet(methodToPass, 5.0);
			System.out.println (leo.metodoGet(methodToPass2));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

	public AnalisisPrecios getPreciosMunicipio() {
		return preciosMunicipio;
	}

	public void setPreciosMunicipio(AnalisisPrecios preciosMunicipio) {
		this.preciosMunicipio = preciosMunicipio;
	}
	
}
