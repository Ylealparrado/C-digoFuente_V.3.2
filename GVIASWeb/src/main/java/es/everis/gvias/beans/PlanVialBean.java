/*
 * @author APCA Eptisa-Tecnourban
 * @version 11/09/2015
 */
package es.everis.gvias.beans;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.primefaces.PrimeFaces;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;
import org.primefaces.model.DualListModel;

import es.everis.gvias.core.appbase.common.utilidades.Utilidades;
import es.everis.gvias.core.appbase.model.biz.fachada.Fachada;
import es.everis.gvias.core.appbase.model.integration.dao.generado.ActividadModeloTeorico;
import es.everis.gvias.core.appbase.model.integration.dao.generado.AmbientalPV;
import es.everis.gvias.core.appbase.model.integration.dao.generado.CentroSocialPV;
import es.everis.gvias.core.appbase.model.integration.dao.generado.Competencia;
import es.everis.gvias.core.appbase.model.integration.dao.generado.EcoVolumenTraficoPNVIR;
import es.everis.gvias.core.appbase.model.integration.dao.generado.EconomicoPV;
import es.everis.gvias.core.appbase.model.integration.dao.generado.IntervencionPV;
import es.everis.gvias.core.appbase.model.integration.dao.generado.ModeloTeoricoPV;
import es.everis.gvias.core.appbase.model.integration.dao.generado.PoblacionPV;
import es.everis.gvias.core.appbase.model.integration.dao.generado.ProductividadPV;
import es.everis.gvias.core.appbase.model.integration.dao.generado.ProductoRendimiento;
import es.everis.gvias.core.appbase.model.integration.dao.generado.TecnicosPV;
import es.everis.gvias.core.appbase.model.integration.dao.generado.Vereda;
import es.everis.gvias.core.appbase.model.integration.dao.generado.Via;
import es.everis.gvias.navigation.MigaBean;

@ManagedBean(name = "planVialBean")
@ViewScoped
public class PlanVialBean implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = -1809537380170748421L;

	/** Variable log. */
	private static Logger logger = LogManager.getLogger();
	
    private Fachada fachada = new Fachada();
    
    private Via via = new Via();
    
    private List<Competencia> listaCompetencias;
    
    private List<EcoVolumenTraficoPNVIR> listaTrafico;
    
    private List<ProductoRendimiento> listaProductos;
    
    private List<ActividadModeloTeorico> listaActividades;
    
    DualListModel<Vereda> veredasDualList;
	
	@ManagedProperty(value="#{migaBean}")
	private MigaBean migaBean;
    
	
    /**
     * Inits the page.
     *
     */
    @PostConstruct
    public void initPage() {
    	
    	if(migaBean.getViaId() != null && migaBean.getMunicipioId() != null) {
    		Via via = fachada.obtenerViaPorId(migaBean.getViaId(), true);
    		inicializarVia(via);
	    	cruzarDatos(via);
	        cargarDatos(via);
    	}
    }

    private void inicializarVia(Via via) {
//    	INICIALIZAR VARIABLES
    	
		if (via.getTecnicosPV() == null) {
			via.setTecnicosPV(new TecnicosPV());
		}
		
		if (via.getPoblacionPV() == null) {
			via.setPoblacionPV(new PoblacionPV());
		}
		
		if (via.getCentroSocialPV() == null) {
			via.setCentroSocialPV(new CentroSocialPV());
		}
		
		if (via.getAmbientalPV() == null) {
			via.setAmbientalPV(new AmbientalPV());
		}
		
		if (via.getEconomicoPV() == null) {
			via.setEconomicoPV(new EconomicoPV());
		}
		
		if (via.getProductividadPV() == null) {
			via.setProductividadPV(new ProductividadPV());
		}
		
		if (via.getIntervencionPV() == null) {
			via.setIntervencionPV(new IntervencionPV());
		}
		
		if (via.getModeloTeoricoPV() == null) {
			via.setModeloTeoricoPV(new ModeloTeoricoPV());
		}
		
		setVia(via);
	}

	private void cruzarDatos(Via via) {
    	//Consideramos que todas las vías deben interseccionar al menos con una vereda, por lo que lo usamos como control para solo ejecutarlo la primera vez
    	if (via.getVeredas() == null || via.getVeredas().size() == 0) {
//    		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Cruzando datos espaciales. Esto puede llevar unos minutos...", null));
//			PrimeFaces.current().ajax().update("growl");
    		fachada.realizarIntersecciones(via);
    	}
	}

	/**
     * Cargar datos
     */
    public void cargarDatos(Via via) {
    	logger.debug("PlanVialBean - cargarDatos - Inicio");

    	//actualizamos totales tipos superficie
    	onChangeTipoSuperficie();
    	
		//actualizamos valores técnicos
		onChangeTecnicoModal();
		onChangeTecnicoRegional();
		//actualizamos valores ambientales
		onChangeAmbiental();
		
		//actualizamos valores sociales
		onChangeCentroSocial();
		
		//veredas y poblaciones
		DualListModel<Vereda> veredasDualList = new DualListModel<Vereda>();
		
		List<Vereda> veredasPorMunicipio = fachada.obtenerVeredasPorMunicipio(migaBean.getMunicipioId());

		if (via.getVeredas() != null) {
			List<Vereda> veredasVia = Utilidades.fromSetToList(via.getVeredas());
			veredasDualList.setTarget(veredasVia);
			for (Vereda vereda : veredasVia) {
				veredasPorMunicipio.remove(vereda);
			}
		}
		veredasDualList.setSource(veredasPorMunicipio);
		setVeredasDualList(veredasDualList);
		onPickListSelect();//actualizo contador de población afectada
		
		onChangePorcPoblacion();
		onChangePorcPoblacionDiferencial();
		onChangePorcICV();	
		
		onChangeAmbiental();
		
		//competencias
		listaCompetencias = fachada.obtenerListaCompetencias();
				
		//volúmenes tráfico
		listaTrafico = fachada.obternerListaVolumenesTrafico();
		
		//cultivos
		listaProductos = fachada.obtenerListaCultivosPorMunicipio(migaBean.getMunicipioId());
		
		//actividades modelo teorico
		listaActividades = fachada.obtenerActividadesPorVia(via.getIdVia());
		
    	logger.debug("PlanVialBean - cargarDatos - Fin");
    }
    
    
	public void guardarPlanVial() {
		logger.debug("viaBean - guardarVia - Inicio");

		//veredas afectadas
		Set<Vereda> veredasAfectadas = new HashSet<Vereda>(0);
		veredasAfectadas.addAll(getVeredasDualList().getTarget());
		via.setVeredas(veredasAfectadas);
		
		//cálculo de puntaje total, solo cuando esté todo completo	
		via.setPuntajeTotalPv(new BigDecimal(calcularPuntajeTotal()));
		
		boolean guardado = fachada.actualizarVia(via);

		if(guardado) {
			//recalculamos porcentajes de población beneficiada
			fachada.recalcularPorcentajesPoblacionBeneficiada(via, true);
			PrimeFaces.current().ajax().update("planVialForm:PlanVialTabView:porcPoblacionBeneficiada");
			PrimeFaces.current().ajax().update("planVialForm:PlanVialTabView:porcPoblacionDifBeneficiada");
	    	PrimeFaces.current().ajax().update("planVialForm:PlanVialTabView:indicadorPoblacionBeneficiada");
	    	PrimeFaces.current().ajax().update("planVialForm:PlanVialTabView:indicadorPoblacionDif");
	    	

			//recalculamos prioridades
			fachada.recalcularPrioridadesPVMunicipio(migaBean.getMunicipioId());
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Datos guardados correctamente", null));
		}else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "No se han guardado los datos", null));
		}
		PrimeFaces.current().ajax().update("growl");
		
		logger.debug("viaBean - guardarVia - Fin");
	}

	public void onShowPorcentajes(){
		fachada.recalcularPorcentajesPoblacionBeneficiada(via, false);
		PrimeFaces.current().ajax().update("planVialForm:PlanVialTabView:porcPoblacionBeneficiada");
		PrimeFaces.current().ajax().update("planVialForm:PlanVialTabView:porcPoblacionDifBeneficiada");
    	PrimeFaces.current().ajax().update("planVialForm:PlanVialTabView:indicadorPoblacionBeneficiada");
    	PrimeFaces.current().ajax().update("planVialForm:PlanVialTabView:indicadorPoblacionDif");
	}
	
	private Integer calcularPuntajeTotal() {
		Integer puntajeTotal = new Integer(0);
		
		//Criterios Ambientales
		if (via.getAmbientalPV().getPuntajeAmbientalTotal() != null) {
			puntajeTotal += via.getAmbientalPV().getPuntajeAmbientalTotal().intValue();
		}
		
		if (puntajeTotal >= 0) { //Si el puntaje de ambiental es -1 es porque la vía superpone a parque natural, en ese caso el puntaje total es directamente 0
			
			//Técnicos
			if (via.getTecnicosPV().getTecConectividadModalPNVIR() != null && via.getTecnicosPV().getTecConectividadModalPNVIR().getPuntaje() != null) {
				puntajeTotal += via.getTecnicosPV().getTecConectividadModalPNVIR().getPuntaje().intValue();
			}
			if (via.getTecnicosPV().getTecConectividadRegionalPNVIR() != null && via.getTecnicosPV().getTecConectividadRegionalPNVIR().getPuntaje() != null) {
				puntajeTotal += via.getTecnicosPV().getTecConectividadRegionalPNVIR().getPuntaje().intValue();
			}
			//Población
			if (via.getPoblacionPV().getSocPoblacionBeneficiadaPNVIR() != null && via.getPoblacionPV().getSocPoblacionBeneficiadaPNVIR().getPuntaje() != null) {
				puntajeTotal += via.getPoblacionPV().getSocPoblacionBeneficiadaPNVIR().getPuntaje().intValue();
			}
			if (via.getPoblacionPV().getSocIcvPNVIR() != null && via.getPoblacionPV().getSocIcvPNVIR().getPuntaje() != null) {
				puntajeTotal += via.getPoblacionPV().getSocIcvPNVIR().getPuntaje().intValue();
			}
			if (via.getPoblacionPV().getSocPoblacionDiferencialPNVIR() != null && via.getPoblacionPV().getSocPoblacionDiferencialPNVIR().getPuntaje() != null) {
				puntajeTotal += via.getPoblacionPV().getSocPoblacionDiferencialPNVIR().getPuntaje().intValue();
			}
			if (via.getPoblacionPV().getSocSustitucionCultivosPNVIR() != null && via.getPoblacionPV().getSocSustitucionCultivosPNVIR().getPuntaje() != null) {
				puntajeTotal += via.getPoblacionPV().getSocSustitucionCultivosPNVIR().getPuntaje().intValue();
			}
			//Centros Sociales
			if (via.getCentroSocialPV().getSocCentrosSocialesPNVIR() != null && via.getCentroSocialPV().getSocCentrosSocialesPNVIR().getPuntaje() != null) {
				puntajeTotal += via.getCentroSocialPV().getSocCentrosSocialesPNVIR().getPuntaje().intValue();
			}
			//Economico
			if (via.getEconomicoPV().getEcoVolumenTraficoPNVIR() != null) {
				getVia().getEconomicoPV().setEcoVolumenTraficoPNVIR(listaTrafico.get(listaTrafico.indexOf(getVia().getEconomicoPV().getEcoVolumenTraficoPNVIR())));
				puntajeTotal += via.getEconomicoPV().getEcoVolumenTraficoPNVIR().getPuntaje().intValue();
			}
			if (via.getEconomicoPV().getEcoComercializacionPNVIR() != null  && via.getEconomicoPV().getEcoComercializacionPNVIR().getPuntaje() != null) {
				puntajeTotal += via.getEconomicoPV().getEcoComercializacionPNVIR().getPuntaje().intValue();
			}
			//Productividad
			if (via.getProductividadPV().getEcoRendimientoPNVIR() != null  && via.getProductividadPV().getEcoRendimientoPNVIR().getPuntaje() != null) {
				puntajeTotal += via.getProductividadPV().getEcoRendimientoPNVIR().getPuntaje().intValue();
			}
		} else {
			puntajeTotal = new Integer(0);
		}
		return puntajeTotal;
	}
	
	
	public void onChangeTipoSuperficie() {
		onChangePavim();
		onChangeAfirm();
		onChangeTierra();
		onChangeMejora();
	}
	
	public void onChangePavim() {
		Double bueno = getVia().getPavimBueno() != null ? getVia().getPavimBueno() : 0;
		Double regular = getVia().getPavimRegular() != null ? getVia().getPavimRegular() : 0;
		Double malo = getVia().getPavimMalo() != null ? getVia().getPavimMalo() : 0;
		getVia().setPavimTotal(bueno+regular+malo);
		
		Double totalAfirm = getVia().getAfirmTotal() != null ? getVia().getAfirmTotal() : 0;
		Double totalTierra = getVia().getTierraTotal() != null ? getVia().getTierraTotal() : 0;
		Double totalMejora = getVia().getMejoraTotal() != null ? getVia().getMejoraTotal() : 0;
		getVia().setLongitudTotal(getVia().getPavimTotal()+totalAfirm+totalMejora+totalTierra);
		
		PrimeFaces.current().ajax().update("planVialForm:PlanVialTabView:longitudTotal");
		PrimeFaces.current().ajax().update("planVialForm:PlanVialTabView:pavTotal");
	}
	
	public void onChangeAfirm() {
		Double bueno = getVia().getAfirmBueno() != null ? getVia().getAfirmBueno() : 0;
		Double regular = getVia().getAfirmRegular() != null ? getVia().getAfirmRegular() : 0;
		Double malo = getVia().getAfirmMalo() != null ? getVia().getAfirmMalo() : 0;
		getVia().setAfirmTotal(bueno+regular+malo);
		
		Double totalPavim = getVia().getPavimTotal() != null ? getVia().getPavimTotal() : 0;
		Double totalTierra = getVia().getTierraTotal() != null ? getVia().getTierraTotal() : 0;
		Double totalMejora = getVia().getMejoraTotal() != null ? getVia().getMejoraTotal() : 0;
		getVia().setLongitudTotal(getVia().getAfirmTotal()+totalPavim+totalMejora+totalTierra);
		
		PrimeFaces.current().ajax().update("planVialForm:PlanVialTabView:longitudTotal");
		PrimeFaces.current().ajax().update("planVialForm:PlanVialTabView:afirmTotal");
	}
	
	public void onChangeTierra() {
		Double bueno = getVia().getTierraBueno() != null ? getVia().getTierraBueno() : 0;
		Double regular = getVia().getTierraRegular() != null ? getVia().getTierraRegular() : 0;
		Double malo = getVia().getTierraMalo() != null ? getVia().getTierraMalo() : 0;
		getVia().setTierraTotal(bueno+regular+malo);
		
		Double totalPavim = getVia().getPavimTotal() != null ? getVia().getPavimTotal() : 0;
		Double totalAfirm = getVia().getAfirmTotal() != null ? getVia().getAfirmTotal() : 0;
		Double totalMejora = getVia().getMejoraTotal() != null ? getVia().getMejoraTotal() : 0;
		getVia().setLongitudTotal(getVia().getTierraTotal()+totalPavim+totalMejora+totalAfirm);
		
		PrimeFaces.current().ajax().update("planVialForm:PlanVialTabView:longitudTotal");
		PrimeFaces.current().ajax().update("planVialForm:PlanVialTabView:tierraTotal");
	}
	
	public void onChangeMejora() {
		Double bueno = getVia().getMejoraBueno() != null ? getVia().getMejoraBueno() : 0;
		Double regular = getVia().getMejoraRegular() != null ? getVia().getMejoraRegular() : 0;
		Double malo = getVia().getMejoraMalo() != null ? getVia().getMejoraMalo() : 0;
		getVia().setMejoraTotal(bueno+regular+malo);
		
		Double totalPavim = getVia().getPavimTotal() != null ? getVia().getPavimTotal() : 0;
		Double totalAfirm = getVia().getAfirmTotal() != null ? getVia().getAfirmTotal() : 0;
		Double totalTierra = getVia().getTierraTotal() != null ? getVia().getTierraTotal() : 0;
		getVia().setLongitudTotal(getVia().getMejoraTotal()+totalPavim+totalTierra+totalAfirm);
		
		PrimeFaces.current().ajax().update("planVialForm:PlanVialTabView:longitudTotal");
		PrimeFaces.current().ajax().update("planVialForm:PlanVialTabView:mejoraTotal");
	}

//	public void guardarVeredasAfectadas() {
//		log.debug("proyectoBean - guardarVeredasAfectadas - Inicio");
//		
//		Set<Vereda> veredasAfectadas = new HashSet<Vereda>(0);
//		veredasAfectadas.addAll(getVeredasDualList().getTarget());
//		
//		for (Vereda vereda : veredasAfectadas) {
//			System.out.println(vereda);
//		}
//		
//		via.setVeredas(veredasAfectadas);
//		
//		boolean guardado = fachada.actualizarVia(via);
//		
//		if(guardado) {
//			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Datos guardados correctamente", null));
//			
//			//Actualizar estado
//		}else {
//			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "No se han guardado los datos", null));
//		}
//		PrimeFaces.current().ajax().update("growl");
//		
//		log.debug("proyectoBean - guardarVeredasAfectadas - Fin");
//	}
	
	
	public void onChangeTecnicoModal () {
		String resultadoModal = "Con vía ";
		
    	if (getVia().getTecnicosPV().getTranspViaPrimaria() != null && getVia().getTecnicosPV().getTranspViaPrimaria()) {
    		resultadoModal = resultadoModal.concat("primaria y ");
    	}
    	if (getVia().getTecnicosPV().getTranspViaSecundaria() != null && getVia().getTecnicosPV().getTranspViaSecundaria()) {
    		resultadoModal = resultadoModal.concat("secundaria y ");
    	}
    	if (getVia().getTecnicosPV().getTranspViaTerciaria() != null && getVia().getTecnicosPV().getTranspViaTerciaria()) {
    		resultadoModal = resultadoModal.concat("terciaria y ");
    	}
    	if (getVia().getTecnicosPV().getTranspViaFluvial() != null && getVia().getTecnicosPV().getTranspViaFluvial()) {
    		resultadoModal = resultadoModal.concat("fluvial y ");
    	}
    	if (getVia().getTecnicosPV().getTranspViaAerea() != null && getVia().getTecnicosPV().getTranspViaAerea()) {
    		resultadoModal = resultadoModal.concat("aérea y ");
    	}
    	
    	if (resultadoModal.length() > 10) {
    		resultadoModal = resultadoModal.substring(0, resultadoModal.length()-2).trim();
    	} else {
    		resultadoModal = "No conecta";
    	}
    	
    	getVia().getTecnicosPV().setTecConectividadModalPNVIR(fachada.obtenerTecConectividadModalPNVIRPorDescripcion(resultadoModal));
    	
    	PrimeFaces.current().ajax().update("planVialForm:PlanVialTabView:conectividadModalPNVIR");
	}
	
	
	public void onChangeTecnicoRegional () {
		String resultadoRegional = "Comunica ";
		
    	if (via.getTecnicosPV().getConectOtrosDepartamentos() != null && via.getTecnicosPV().getConectOtrosDepartamentos()) {
    		resultadoRegional = resultadoRegional.concat("con otro(s) departamento(s) y ");
    	}
    	if (via.getTecnicosPV().getConectPdetZomac() != null && via.getTecnicosPV().getConectPdetZomac()) {
    		resultadoRegional = resultadoRegional.concat("con subregión PDET y/o ZOMAC y ");
    	}
    	if (via.getTecnicosPV().getConectCabeceraMunicipal() != null && via.getTecnicosPV().getConectCabeceraMunicipal()) {
    		resultadoRegional = resultadoRegional.concat("con cabecera(s) municipal(es) y ");
    	}
    	    	
    	if (resultadoRegional.length() > 10) {
    		resultadoRegional = resultadoRegional.substring(0, resultadoRegional.length()-2).trim();
    	} else {
    		resultadoRegional = "Ninguna";
    	}
    	
    	via.getTecnicosPV().setTecConectividadRegionalPNVIR(fachada.obtenerTecConectividadRegionalPNVIRPorDescripcion(resultadoRegional));
    	
    	PrimeFaces.current().ajax().update("planVialForm:PlanVialTabView:conectividadRegionalPNVIR");
	}

	public void onPickListSelect() {
		List<Vereda> target = getVeredasDualList().getTarget();
		int poblacionTotal = 0;
		for (Vereda vereda : target) {
			if (vereda.getPoblacion() != null) {
				poblacionTotal += vereda.getPoblacion().intValue();
			}
		}
		getVia().getPoblacionPV().setPoblacionTotalVeredas(new BigDecimal(poblacionTotal));
		
		PrimeFaces.current().ajax().update("planVialForm:PlanVialTabView:poblacionTotalVeredas");
	}
	
	
	
	public void onChangePorcICV() {
		Double porcentaje = getVia().getMunicipio().getIcv();
		BigDecimal idIndicador = null;

		if (porcentaje != null) {
			if (porcentaje > 59.99 ) {
				idIndicador = new BigDecimal(1); //"Mayor al 59,99%"; 
			} else if (porcentaje < 40 ) {
				idIndicador = new BigDecimal(3); //"Menor al 40,00%";
			} else {
				idIndicador = new BigDecimal(2); //"Entre el 59,99% y 40,00%";
			}
			getVia().getPoblacionPV().setSocIcvPNVIR(fachada.obtenerSocICVPNVIRPorId(idIndicador));
		}else {
			getVia().getPoblacionPV().setSocIcvPNVIR(null);
		}

    	PrimeFaces.current().ajax().update("planVialForm:PlanVialTabView:indicadorICV");
	}
	
	public void onChangeEtnica() {
		System.out.println("onChangeEtnica");

		BigDecimal indigena = getVia().getPoblacionPV().getEtnicaIndigena() != null ? getVia().getPoblacionPV().getEtnicaIndigena() : BigDecimal.ZERO;
		BigDecimal rom = getVia().getPoblacionPV().getEtnicaRom() != null ? getVia().getPoblacionPV().getEtnicaRom() : BigDecimal.ZERO;
		BigDecimal raizal = getVia().getPoblacionPV().getEtnicaRaizal() != null ? getVia().getPoblacionPV().getEtnicaRaizal() : BigDecimal.ZERO;
		BigDecimal color = getVia().getPoblacionPV().getEtnicaColor() != null ? getVia().getPoblacionPV().getEtnicaColor() : BigDecimal.ZERO;
		getVia().getPoblacionPV().setEtnicaTotal(indigena.add(rom).add(raizal).add(color));
		
		PrimeFaces.current().ajax().update("planVialForm:PlanVialTabView:etniaTotal");
	}
	
	
	
	public void onChangePromueveSustitucion() {
		System.out.println("onChangePromueveSustitucion");
		
		BigDecimal idIndicador = new BigDecimal(2);
		if (via.getPoblacionPV().getPromueveSustitucionCultivos()) {
			idIndicador = new BigDecimal(1);
		}
		
		getVia().getPoblacionPV().setSocSustitucionCultivosPNVIR(fachada.obtenerSocSustitucionCultivosPNVIRPorId(idIndicador));
		
	}
	
	public void onChangeCentroSocial() {
			
		BigDecimal idIndicador = new BigDecimal(0);
		if (getVia().getCentroSocialPV().getCentrosSalud() != null && getVia().getCentroSocialPV().getCentrosSalud()) {
			
			idIndicador = new BigDecimal(1); //Centros de salud
			
			if (getVia().getCentroSocialPV().getEscuelas() != null && getVia().getCentroSocialPV().getEscuelas()) {
				
				idIndicador = new BigDecimal(4); //Centros de salud y escuelas
				
				if ((getVia().getCentroSocialPV().getComunitarios() != null && getVia().getCentroSocialPV().getComunitarios())
						|| (getVia().getCentroSocialPV().getTurismo() != null && getVia().getCentroSocialPV().getTurismo())
						|| (getVia().getCentroSocialPV().getDeportivo() != null && getVia().getCentroSocialPV().getDeportivo())) {
				
					idIndicador = new BigDecimal(6); //Centros de salud y escuelas y centros comunitarios o similar, turismo y/o escenario deportivo			
				}
			
			} else {
				
				if ((getVia().getCentroSocialPV().getComunitarios() != null && getVia().getCentroSocialPV().getComunitarios())
						|| (getVia().getCentroSocialPV().getTurismo() != null && getVia().getCentroSocialPV().getTurismo())
						|| (getVia().getCentroSocialPV().getDeportivo() != null && getVia().getCentroSocialPV().getDeportivo())) {
				
					idIndicador = new BigDecimal(5); //Centros de salud y centros comunitarios o similar, turismo y/o escenario deportivo			

				}
			}
		} else if (getVia().getCentroSocialPV().getEscuelas() != null && getVia().getCentroSocialPV().getEscuelas()) {
			
			if ((getVia().getCentroSocialPV().getComunitarios() != null && getVia().getCentroSocialPV().getComunitarios())
					|| (getVia().getCentroSocialPV().getTurismo() != null && getVia().getCentroSocialPV().getTurismo())
					|| (getVia().getCentroSocialPV().getDeportivo() != null && getVia().getCentroSocialPV().getDeportivo())) {
			
				idIndicador = new BigDecimal(7); //Escuelas y centros comunitarios o similar, turismo y/o escenario deportivo			

			}else {
				idIndicador = new BigDecimal(2); //Escuelas
			}
			
		} else if ((getVia().getCentroSocialPV().getComunitarios() != null && getVia().getCentroSocialPV().getComunitarios())
				|| (getVia().getCentroSocialPV().getTurismo() != null && getVia().getCentroSocialPV().getTurismo())
				|| (getVia().getCentroSocialPV().getDeportivo() != null && getVia().getCentroSocialPV().getDeportivo())) {
		
			idIndicador = new BigDecimal(3); //Centros comunitarios o similar, turismo y/o escenario deportivo			

		}
		
		getVia().getCentroSocialPV().setSocCentrosSocialesPNVIR(fachada.obtenerSocCentrosSocialesPNVIRPorId(idIndicador));
		
	}
	
	public void onChangeAmbiental() {
		int puntajeAmbiental = 0;
		if (getVia().getAmbientalPV().getSuperpParquesNacionales() != null && getVia().getAmbientalPV().getSuperpParquesNacionales()) { //Si superpone a parque nacional, caso especial
			puntajeAmbiental = -1;
		} else {
			if (getVia().getAmbientalPV().getSuperpAreasEspecialInteres() == null || !getVia().getAmbientalPV().getSuperpAreasEspecialInteres()) {
				puntajeAmbiental += 3;
			}
			if (getVia().getAmbientalPV().getSuperpCoberturasBosques() == null || !getVia().getAmbientalPV().getSuperpCoberturasBosques()) {
				puntajeAmbiental += 3;
			}
			if (getVia().getAmbientalPV().getSuperpCoberturasAreasHumedas() == null || !getVia().getAmbientalPV().getSuperpCoberturasAreasHumedas()) {
				puntajeAmbiental += 3;
			}
			if (getVia().getAmbientalPV().getSuperpCorredoresEco() == null || !getVia().getAmbientalPV().getSuperpCorredoresEco()) {
				puntajeAmbiental += 3;
			}
			if (getVia().getAmbientalPV().getSuperpAreasFauna() == null || !getVia().getAmbientalPV().getSuperpAreasFauna()) {
				puntajeAmbiental += 3;
			}
		}
		getVia().getAmbientalPV().setPuntajeAmbientalTotal(new BigDecimal(puntajeAmbiental));
	}
	
	public void onChangeEconomico() {

		BigDecimal idIndicador = new BigDecimal(4); //Ninguno
		
    	if ((getVia().getEconomicoPV().getProyectos() != null && via.getEconomicoPV().getProyectos()) && (via.getEconomicoPV().getConectaInterModal() != null && via.getEconomicoPV().getConectaInterModal())) {
    		idIndicador = new BigDecimal(3); //"Proyectos de desarrollo rural contenidos en los planes de desarrollo municipales, departamentales y/o definidos por la ADR y Conecta con al menos un punto de intercambio modal";
    	} else if (getVia().getEconomicoPV().getConectaInterModal() != null && via.getEconomicoPV().getConectaInterModal()) {
    		idIndicador = new BigDecimal(2); //"Conecta con al menos un punto de intercambio modal";
    	} else if (getVia().getEconomicoPV().getProyectos() != null && via.getEconomicoPV().getProyectos()) {
    		idIndicador = new BigDecimal(1); //"Proyectos de desarrollo rural contenidos en los planes de desarrollo municipales, departamentales y/o definidos por la ADR";
    	}
    	
    	getVia().getEconomicoPV().setEcoComercializacionPNVIR(fachada.obtenerEcoComercializacionPNVIRPorId(idIndicador));
    	
    	PrimeFaces.current().ajax().update("planVialForm:PlanVialTabView:indicadorComercializacionPNVIR");
	}
	
	
	public void onChangeCultivo() {

		BigDecimal idIndicadorProductividad = new BigDecimal(4); //Ninguno
		Double rendimiento = 0., cuartil1 = 0., cuartil2 = 0., cuartil3 = 0., cuartil4 = 0.; 

		if (getVia().getProductividadPV().getProductoRendimiento() != null){
			getVia().getProductividadPV().setProductoRendimiento(listaProductos.get(listaProductos.indexOf(getVia().getProductividadPV().getProductoRendimiento())));
			
			rendimiento = getVia().getProductividadPV().getProductoRendimiento().getRendimiento();
			cuartil1 = getVia().getProductividadPV().getProductoRendimiento().getProductoCuartiles().getCuartil1();
			cuartil2 = getVia().getProductividadPV().getProductoRendimiento().getProductoCuartiles().getCuartil2();
			cuartil3 = getVia().getProductividadPV().getProductoRendimiento().getProductoCuartiles().getCuartil3();
			cuartil4 = getVia().getProductividadPV().getProductoRendimiento().getProductoCuartiles().getCuartil4();;
			
			if (rendimiento < cuartil1) {
				idIndicadorProductividad = new BigDecimal(3); //Rendimiento en el primer cuartil
			} else if (cuartil1 <= rendimiento && rendimiento <= cuartil3) {
				idIndicadorProductividad = new BigDecimal(2); //Rendimiento entre el segundo y tercer cuartil
			}else if (rendimiento > cuartil3){
				idIndicadorProductividad = new BigDecimal(1); //Rendimiento dentro del cuarto cuartil
			}
		}
		
    	getVia().getProductividadPV().setEcoRendimientoPNVIR(fachada.obtenerEcocoRendimientoPNVIRPorId(idIndicadorProductividad));
		
		PrimeFaces.current().ajax().update("planVialForm:PlanVialTabView:rendimiento");
		PrimeFaces.current().ajax().update("planVialForm:PlanVialTabView:cuartil1");
		PrimeFaces.current().ajax().update("planVialForm:PlanVialTabView:cuartil2");
		PrimeFaces.current().ajax().update("planVialForm:PlanVialTabView:cuartil3");
		PrimeFaces.current().ajax().update("planVialForm:PlanVialTabView:cuartil4");
		PrimeFaces.current().ajax().update("planVialForm:PlanVialTabView:rendimientoPNVIR");
	}
	
	public void onChangePorcPoblacion() {
		Double porcentaje = getVia().getPoblacionPV().getPorcPoblacionBeneficiada();
		BigDecimal idIndicador = null;
		if (porcentaje != null) {
			if (porcentaje != null) {
				if (porcentaje < 10 ) {
					idIndicador = new BigDecimal(1); //"Menor al 10% de la población rural de cada municipio"; 
				} else if (porcentaje > 30 ) {
					idIndicador = new BigDecimal(3); //"Mayor al 30% de la población rural de cada municipio";
				} else {
					idIndicador = new BigDecimal(2); //"Entre el 10% y el 30% de la población rural de cada municipio";
				}
			}
			
			getVia().getPoblacionPV().setSocPoblacionBeneficiadaPNVIR(fachada.obtenerSocPoblacionBeneficiadaPNVIRPorId(idIndicador));
		}else{
			getVia().getPoblacionPV().setSocPoblacionBeneficiadaPNVIR(null);
		}

    	PrimeFaces.current().ajax().update("planVialForm:PlanVialTabView:indicadorPolacionBeneficiada");
	}
	
	
	public void onChangePorcPoblacionDiferencial() {
		Double porcentaje = getVia().getPoblacionPV().getPorcPoblacionDiferencialBeneficiada();
		
		if (porcentaje != null) {
			BigDecimal idIndicador = null;
			if (porcentaje != null) {
				if (porcentaje > 59.99 ) {
					idIndicador = new BigDecimal(1); //Mayor al 59,99% del total de la población; 
				} else if (porcentaje < 40 ) {
					idIndicador = new BigDecimal(3); //"Menor al 40,00%";
				} else {
					idIndicador = new BigDecimal(2); //"Entre el 59,99% y 40,00% del total de la población";
				}
			}
			
			getVia().getPoblacionPV().setSocPoblacionDiferencialPNVIR(fachada.obtenerSocPoblacionDiferencialPNVIRPorId(idIndicador));
		}else {
			getVia().getPoblacionPV().setSocPoblacionDiferencialPNVIR(null);
		}

    	PrimeFaces.current().ajax().update("planVialForm:PlanVialTabView:indicadorPoblacionDif");
	}
	
	public void onChangePrecioKm() {
		Double estudios, estudiosPrecio, estudiosTotal = 0., mejoramiento, mejoramientoPrecio, mejoramientoTotal = 0., mantenimiento, mantenimientoPrecio, mantenimientoTotal = 0.;
		
		estudios = getVia().getIntervencionPV().getEstudiosDisenos();
		estudiosPrecio = getVia().getIntervencionPV().getEstudiosDisenosPrecio();
		mejoramiento = getVia().getIntervencionPV().getMejoramiento();
		mejoramientoPrecio = getVia().getIntervencionPV().getMejoramientoPrecio();
		mantenimiento = getVia().getIntervencionPV().getMantenimiento();
		mantenimientoPrecio = getVia().getIntervencionPV().getMantenimientoPrecio();
		
		if (estudios != null && estudiosPrecio != null) {
			estudiosTotal = estudios*estudiosPrecio;
		}
		
		if (mejoramiento != null && mejoramientoPrecio != null) {
			mejoramientoTotal = mejoramiento*mejoramientoPrecio;
		}
		
		if (mantenimiento != null && mantenimientoPrecio != null) {
			mantenimientoTotal = mantenimiento * mantenimientoPrecio;
		}
		
		getVia().getIntervencionPV().setCosto(estudiosTotal+mejoramientoTotal+mantenimientoTotal);
		
		PrimeFaces.current().ajax().update("planVialForm:PlanVialTabView:costoIntervencion");
	}
	
//	public void onChangePorcDiferencialMunicipal() {
//	
//		PrimeFaces.current().ajax().update("planVialForm:PlanVialTabView:costoIntervencion");
//		
//	}
	
	public void onChangeINSCalificacion() {
		
		if (via.getModeloTeoricoPV().getNivelSSuperficie() != null && via.getModeloTeoricoPV().getNivelSSuperficie().length() > 1
				&& via.getModeloTeoricoPV().getNivelSCalCalzada() != null
				&& via.getModeloTeoricoPV().getNivelSCalLaterales() != null
				&& via.getModeloTeoricoPV().getNivelSCalDrenaje() != null
				&& via.getModeloTeoricoPV().getNivelSCalEstructuras() != null
				&& via.getModeloTeoricoPV().getNivelSCalSenalizacion() != null){
			double factA = 0, factB = 0, factC = 0, factD = 0, factE = 0;
			switch (via.getModeloTeoricoPV().getNivelSSuperficie()) {
			case "Pavimentada":
				factA = 0.45;
				factB = 0.1;
				factC = factD = factE = 0.15;
				break; 
			case "Granular":
				factA = 0.5;
				factB = 0.1;
				factC = 0.2;
				factD = 0.15;
				factE = 0.05;
				break;
			case "Tierra":
				factA = 0.5;
				factB = 0.1;
				factC = 0.3;
				factD = 0.1;
				factE = 0.0;
				break;
			default:
				break;
			}
			
			via.getModeloTeoricoPV().setNivelSFormula("("+factA+"x"+via.getModeloTeoricoPV().getNivelSCalCalzada()+") + "
					+ "("+factB+"x"+via.getModeloTeoricoPV().getNivelSCalLaterales()+") + "
					+ "("+factC+"x"+via.getModeloTeoricoPV().getNivelSCalDrenaje()+") + "
					+ "("+factD+"x"+via.getModeloTeoricoPV().getNivelSCalEstructuras()+") + "
					+ "("+factE+"x"+via.getModeloTeoricoPV().getNivelSCalSenalizacion()+")");
			
			via.getModeloTeoricoPV().setNivelSINS(factA*via.getModeloTeoricoPV().getNivelSCalCalzada()+factB*via.getModeloTeoricoPV().getNivelSCalLaterales()
					+factC*via.getModeloTeoricoPV().getNivelSCalDrenaje()+factD*via.getModeloTeoricoPV().getNivelSCalEstructuras()
					+factE*via.getModeloTeoricoPV().getNivelSCalSenalizacion());
		
			if (via.getModeloTeoricoPV().getNivelSINS() < 4) {
				via.getModeloTeoricoPV().setNivelSRecomendacion("RECONSTRUCCIÓN");
			} else if (via.getModeloTeoricoPV().getNivelSINS() < 6) {
				via.getModeloTeoricoPV().setNivelSRecomendacion("REHABILITACIÓN");
			} else if (via.getModeloTeoricoPV().getNivelSINS() < 8) {
				via.getModeloTeoricoPV().setNivelSRecomendacion("MANTENIMIENTO PERIÓDICO");
			} else { //>=8
				via.getModeloTeoricoPV().setNivelSRecomendacion("La vía ya se encuentra en estado Bueno(A)");
			}
			
			PrimeFaces.current().ajax().update("planVialForm:PlanVialTabView:ModeloTeoricoView:nivelSFormula");
			PrimeFaces.current().ajax().update("planVialForm:PlanVialTabView:ModeloTeoricoView:nivelSINS");
			PrimeFaces.current().ajax().update("planVialForm:PlanVialTabView:ModeloTeoricoView:nivelSRecomendacion");
		}
	}
	
    public void onRowEdit(RowEditEvent<ActividadModeloTeorico> event) {
		if (fachada.actualizarActividad(event.getObject())) {
			Double costoTotal = 0.0; 
        	
        	for (ActividadModeloTeorico actividadModeloTeorico : listaActividades) {
        		if (actividadModeloTeorico.getCosto() != null) {
        			costoTotal += actividadModeloTeorico.getCosto();
        		}
			}
        	via.getModeloTeoricoPV().setNivelSCostoTotal(costoTotal);
        	PrimeFaces.current().ajax().update("planVialForm:PlanVialTabView:ModeloTeoricoView:costoEstimadoTotal");
        	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Actividad modificada", null));
        }else{
        	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Se ha producido un error. No se han guardado los datos", null));
        }     
    }
     
    public void onRowCancel(RowEditEvent<ActividadModeloTeorico> event) {
        FacesMessage msg = new FacesMessage("Modificación cancelada", event.getObject().getActividad());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
 
    public void onAddNew() {
    	ActividadModeloTeorico actividadNueva = new ActividadModeloTeorico();
    	actividadNueva.setVia(getVia());
    	actividadNueva.setActividad("Nueva actividad");
        getListaActividades().add(actividadNueva);
        
        if (fachada.actualizarActividad(actividadNueva)) {
        	Double costoTotal = 0.0; 
        	
        	for (ActividadModeloTeorico actividadModeloTeorico : listaActividades) {
        		if (actividadModeloTeorico.getCosto() != null) {
        			costoTotal += actividadModeloTeorico.getCosto();
        		}
			}
        	via.getModeloTeoricoPV().setNivelSCostoTotal(costoTotal);
        	PrimeFaces.current().ajax().update("planVialForm:PlanVialTabView:ModeloTeoricoView:costoEstimadoTotal");
        	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Nueva actividad añadida", null));
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

    
    public void eliminarActividad(ActividadModeloTeorico actividad) {
    	getListaActividades().remove(actividad);
    	if (fachada.eliminarActividad(actividad)) {
    		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Actividad eliminada", null));
    	} else {
    		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Fallo al eliminar la actividad", null));
    	}
    	PrimeFaces.current().ajax().update("planVialForm:PlanVialTabView:ModeloTeoricoView:actividadesTable");
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

	public DualListModel<Vereda> getVeredasDualList() {
		return veredasDualList;
	}

	public void setVeredasDualList(DualListModel<Vereda> veredasDualList) {
		this.veredasDualList = veredasDualList;
	}

	public List<Competencia> getListaCompetencias() {
		return listaCompetencias;
	}

	public void setListaCompetencias(List<Competencia> listaCompetencias) {
		this.listaCompetencias = listaCompetencias;
	}

	public List<EcoVolumenTraficoPNVIR> getListaTrafico() {
		return listaTrafico;
	}

	public void setListaTrafico(List<EcoVolumenTraficoPNVIR> listaTrafico) {
		this.listaTrafico = listaTrafico;
	}

	public List<ProductoRendimiento> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(List<ProductoRendimiento> listaProductos) {
		this.listaProductos = listaProductos;
	}

	public List<ActividadModeloTeorico> getListaActividades() {
		return listaActividades;
	}

	public void setListaActividades(List<ActividadModeloTeorico> listaActividades) {
		this.listaActividades = listaActividades;
	}
}
