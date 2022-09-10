package es.everis.gvias.core.appbase.model.biz.fachada;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.boot.Metadata;

import es.everis.gvias.core.appbase.model.biz.GestionVias;
import es.everis.gvias.core.appbase.model.integration.dao.generado.ActividadModeloTeorico;
import es.everis.gvias.core.appbase.model.integration.dao.generado.AnalisisPrecios;
import es.everis.gvias.core.appbase.model.integration.dao.generado.Categoria;
import es.everis.gvias.core.appbase.model.integration.dao.generado.Categorizacion;
import es.everis.gvias.core.appbase.model.integration.dao.generado.Competencia;
import es.everis.gvias.core.appbase.model.integration.dao.generado.Departamento;
import es.everis.gvias.core.appbase.model.integration.dao.generado.EcoComercializacionPNVIR;
import es.everis.gvias.core.appbase.model.integration.dao.generado.EcoRendimientoPNVIR;
import es.everis.gvias.core.appbase.model.integration.dao.generado.EcoVolumenTraficoPNVIR;
import es.everis.gvias.core.appbase.model.integration.dao.generado.GeoSeccionTransversal;
import es.everis.gvias.core.appbase.model.integration.dao.generado.GeoTramoVia;
import es.everis.gvias.core.appbase.model.integration.dao.generado.Municipio;
import es.everis.gvias.core.appbase.model.integration.dao.generado.ProductoRendimiento;
import es.everis.gvias.core.appbase.model.integration.dao.generado.SocCentrosSocialesPNVIR;
import es.everis.gvias.core.appbase.model.integration.dao.generado.SocIcvPNVIR;
import es.everis.gvias.core.appbase.model.integration.dao.generado.SocPoblacionBeneficiadaPNVIR;
import es.everis.gvias.core.appbase.model.integration.dao.generado.SocPoblacionDiferencialPNVIR;
import es.everis.gvias.core.appbase.model.integration.dao.generado.SocSustitucionCultivosPNVIR;
import es.everis.gvias.core.appbase.model.integration.dao.generado.TecConectividadModalPNVIR;
import es.everis.gvias.core.appbase.model.integration.dao.generado.TecConectividadRegionalPNVIR;
import es.everis.gvias.core.appbase.model.integration.dao.generado.VCentroSaludVereda;
import es.everis.gvias.core.appbase.model.integration.dao.generado.VSedeEducativaVereda;
import es.everis.gvias.core.appbase.model.integration.dao.generado.Vereda;
import es.everis.gvias.core.appbase.model.integration.dao.generado.Via;

// TODO: Auto-generated Javadoc
/**
 * Clase Fachada.
 */
public class Fachada {
	
	/** Constante PARQUES. */
	private static final int PARQUES = 0;
	
	/** Constante INTERES. */
	private static final int INTERES = 1;
	
	/** Constante BOSQUES. */
	private static final int BOSQUES = 2;
	
	/** Constante HUMEDAS. */
	private static final int HUMEDAS = 3;
	
	/** Constante CORREDORES. */
	private static final int CORREDORES = 4;
	
	/** Constante FAUNA. */
	private static final int FAUNA = 5;
	
	/** Constante PDET_OBS. */
	private static final String PDET_OBS = "Tiene conectividad con zona PDET.";
	
	/** Constante FAUNA_OBS. */
	private static final String FAUNA_OBS = "Presenta superposición con áreas de distribución de fauna.";
	
	/** Constante BOSQUE_OBS. */
	private static final String BOSQUE_OBS = "Presenta superposición con áreas de bosques o áreas seminaturales.";
	
	/** Constante HUMEDA_OBS. */
	private static final String HUMEDA_OBS = "Presenta superposición con áreas húmedas o superficies de agua.";
	
	/** The logger. */
	private static Logger logger = LogManager.getLogger();	
	
	/**
	 * Obtener lista vias.
	 *
	 * @return list
	 */
	public List<Via> obtenerListaVias() {
		if (logger.isDebugEnabled()) {
			logger.debug("obtenerListaVias() - start"); 
		}

		List<Via> returnList = new GestionVias().obtenerListaVias();
		
		if (logger.isDebugEnabled()) {
			logger.debug("obtenerListaVias() - end"); 
		}
        return returnList;
	}
	
	/**
	 * Obtener lista geo tramo via.
	 *
	 * @return list
	 */
	public List<GeoTramoVia> obtenerListaGeoTramoVia() {
		if (logger.isDebugEnabled()) {
			logger.debug("obtenerListaGeoTramoVia() - start"); 
		}

		List<GeoTramoVia> returnList = new GestionVias().obtenerListaGeoTramoVia();
		
		if (logger.isDebugEnabled()) {
			logger.debug("obtenerListaGeoTramoVia() - end"); 
		}
        return returnList;
	}
	
	/**
	 * Obtener geo tramo via por municipio.
	 *
	 * @param codMunicipio the cod municipio
	 * @return list
	 */
	public List<GeoTramoVia> obtenerGeoTramoViaPorMunicipio(String codMunicipio) {
		if (logger.isDebugEnabled()) {
			logger.debug("obtenerGeoTramoViaPorMunicipio() - start"); 
		}

		List<GeoTramoVia> returnList = new GestionVias().obtenerGeoTramoViaPorMunicipio(codMunicipio);
		
		if (logger.isDebugEnabled()) {
			logger.debug("obtenerGeoTramoViaPorMunicipio() - end"); 
		}
        return returnList;
	}
	
	
	/**
	 * Obtener vias por municipio.
	 *
	 * @param idMunicipio the id municipio
	 * @param isPlanVial the is plan vial
	 * @return list
	 */
	public List<Via> obtenerViasPorMunicipio(BigDecimal idMunicipio, boolean isPlanVial) {
		if (logger.isDebugEnabled()) {
			logger.debug("obtenerViasPorMunicipio() - start"); 
		}

		List<Via> returnList = new GestionVias().obtenerViasPorMunicipio(idMunicipio, isPlanVial);
		
		if (logger.isDebugEnabled()) {
			logger.debug("obtenerViasPorMunicipio() - end"); 
		}
        return returnList;
	}
	
	
	
	/**
	 * Obtener via por id.
	 *
	 * @param idVia the id via
	 * @param isPlanVial the is plan vial
	 * @return via
	 */
	public Via obtenerViaPorId(BigDecimal idVia, boolean isPlanVial) {
		if (logger.isDebugEnabled()) {
			logger.debug("obtenerViaPorId(BigDecimal, boolean) - start"); 
		}

		Via returnVia = new GestionVias().obtenerViaPorId(idVia, isPlanVial);
		
		if (logger.isDebugEnabled()) {
			logger.debug("obtenerViaPorId(BigDecimal, boolean) - end"); 
		}
        return returnVia;
	}
	
	/**
	 * Actualizar via.
	 *
	 * @param via the via
	 * @return true, si finaliza satisfactoriamente
	 */
	public boolean actualizarVia(Via via) {
		if (logger.isDebugEnabled()) {
			logger.debug("actualizarVia() - start"); 
		}

		boolean guardado = new GestionVias().actualizarVia(via);

		if (logger.isDebugEnabled()) {
			logger.debug("actualizarVia() - end"); 
		}
		
		return guardado;
	}


	/**
	 * Actualizar categorizacion.
	 *
	 * @param categorizacion the categorizacion
	 * @return true, si finaliza satisfactoriamente
	 */
	public boolean actualizarCategorizacion(Categorizacion categorizacion) {
		if (logger.isDebugEnabled()) {
			logger.debug("actualizarCategorizacion() - start"); 
		}

		boolean guardado = new GestionVias().actualizarCategorizacion(categorizacion);

		if (logger.isDebugEnabled()) {
			logger.debug("actualizarCategorizacion() - end"); 
		}
		
		return guardado;
	}



	/**
	 * Obtener municipios por departamento.
	 *
	 * @param depId the dep id
	 * @return list
	 */
	public List<Municipio> obtenerMunicipiosPorDepartamento(BigDecimal depId) {
		if (logger.isDebugEnabled()) {
			logger.debug("obtenerMunicipiosByDepId() - start"); 
		}

		List<Municipio> municipios = new GestionVias().obtenerMunicipiosPorDepartamento(depId);
		
		if (logger.isDebugEnabled()) {
			logger.debug("obtenerMunicipiosByDepId() - end"); 
		}
        return municipios;
	}

	/**
	 * Obtener lista departamentos.
	 *
	 * @return list
	 */
	public List<Departamento> obtenerListaDepartamentos() {
		if (logger.isDebugEnabled()) {
			logger.debug("obtenerListaDepartamentos() - start"); 
		}

		List<Departamento> listaDepartamentos = new GestionVias().obtenerListaDepartamentos();
		
		
		if (logger.isDebugEnabled()) {
			logger.debug("obtenerListaDepartamentos() - end"); 
		}
        return listaDepartamentos;
	}
	
	/**
	 * Obtener lista municipios.
	 *
	 * @return list
	 */
	public List<Municipio> obtenerListaMunicipios() {
		if (logger.isDebugEnabled()) {
			logger.debug("obtenerListaMunicipios() - start"); 
		}

		List<Municipio> listaMunicipios = new GestionVias().obtenerListaMunicipios();
		
		
		if (logger.isDebugEnabled()) {
			logger.debug("obtenerListaMunicipios() - end"); 
		}
        return listaMunicipios;
	}
	
	
	/**
	 * Obtener veredas por municipio.
	 *
	 * @param munId the mun id
	 * @return list
	 */
	public List<Vereda> obtenerVeredasPorMunicipio(BigDecimal munId) {
		if (logger.isDebugEnabled()) {
			logger.debug("obtenerVeredasPorMunicipio() - start"); 
		}

		List<Vereda> veredas = new GestionVias().obtenerVeredasPorMunicipio(munId);
		
		if (logger.isDebugEnabled()) {
			logger.debug("obtenerVeredasPorMunicipio() - end"); 
		}
        return veredas;
	}
	
	
	/**
	 * Obtener categoria por id.
	 *
	 * @param catId the cat id
	 * @return categoria
	 */
	public Categoria obtenerCategoriaPorId(BigDecimal catId) {
		if (logger.isDebugEnabled()) {
			logger.debug("obtenerCategoriaPorId() - start"); 
		}

		Categoria categoria = new GestionVias().obtenerCategoriaPorId(catId);
		
		if (logger.isDebugEnabled()) {
			logger.debug("obtenerCategoriaPorId() - end"); 
		}
        return categoria;
	}


	/**
	 * Obtener lista competencias.
	 *
	 * @return list
	 */
	public List<Competencia> obtenerListaCompetencias() {
		if (logger.isDebugEnabled()) {
			logger.debug("obtenerListaCompetencias() - start"); 
		}

		List<Competencia> listaCompetencias = new GestionVias().obtenerListaCompetencias();
		
		
		if (logger.isDebugEnabled()) {
			logger.debug("obtenerListaCompetencias() - end"); 
		}
        return listaCompetencias;
	}


	/**
	 * Obtener tec conectividad modal PNVIR por descripcion.
	 *
	 * @param resultadoModal the resultado modal
	 * @return tec conectividad modal PNVIR
	 */
	public TecConectividadModalPNVIR obtenerTecConectividadModalPNVIRPorDescripcion(String resultadoModal) {
		if (logger.isDebugEnabled()) {
			logger.debug("obtenerTecConectividadModalPNVIRPorDescripcion(String resultadoModal) - start"); 
		}


		TecConectividadModalPNVIR tecConectividadModalPNVIR = new GestionVias().obtenerTecConectividadModalPNVIRPorDescripcion(resultadoModal);
		
		
		if (logger.isDebugEnabled()) {
			logger.debug("obtenerTecConectividadModalPNVIRPorDescripcion(String resultadoModal) - end"); 
		}
        return tecConectividadModalPNVIR;		
	}


	/**
	 * Obtener tec conectividad regional PNVIR por descripcion.
	 *
	 * @param resultadoRegional the resultado regional
	 * @return tec conectividad regional PNVIR
	 */
	public TecConectividadRegionalPNVIR obtenerTecConectividadRegionalPNVIRPorDescripcion(String resultadoRegional) {
		if (logger.isDebugEnabled()) {
			logger.debug("obtenerTecConectividadRegionalPNVIRPorDescripcion(String resultadoRegional) - start"); 
		}


		TecConectividadRegionalPNVIR tecConectividadRegionalPNVIR = new GestionVias().obtenerTecConectividadRegionalPNVIRPorDescripcion(resultadoRegional);
		
		
		if (logger.isDebugEnabled()) {
			logger.debug("obtenerTecConectividadRegionalPNVIRPorDescripcion(String resultadoRegional) - end"); 
		}
        return tecConectividadRegionalPNVIR;		
	}


	/**
	 * Obtener soc poblacion beneficiada PNVIR por descripcion.
	 *
	 * @param indicador the indicador
	 * @return soc poblacion beneficiada PNVIR
	 */
	public SocPoblacionBeneficiadaPNVIR obtenerSocPoblacionBeneficiadaPNVIRPorDescripcion(String indicador) {
		if (logger.isDebugEnabled()) {
			logger.debug("obtenerSocPoblacionBeneficiadaPNVIRPorDescripcion(String indicador) - start"); 
		}


		SocPoblacionBeneficiadaPNVIR socPoblacionBeneficiadaPNVIR = new GestionVias().obtenerSocPoblacionBeneficiadaPNVIRPorDescripcion(indicador);
		
		
		if (logger.isDebugEnabled()) {
			logger.debug("obtenerSocPoblacionBeneficiadaPNVIRPorDescripcion(String indicador) - end"); 
		}
        return socPoblacionBeneficiadaPNVIR;		
	}
	
	/**
	 * Obtener soc poblacion beneficiada PNVIR por id.
	 *
	 * @param idIndicador the id indicador
	 * @return soc poblacion beneficiada PNVIR
	 */
	public SocPoblacionBeneficiadaPNVIR obtenerSocPoblacionBeneficiadaPNVIRPorId(BigDecimal idIndicador) {
		if (logger.isDebugEnabled()) {
			logger.debug("obtenerSocPoblacionBeneficiadaPNVIRPorId(BigDecimal idIndicador) - start"); 
		}


		SocPoblacionBeneficiadaPNVIR socPoblacionBeneficiadaPNVIR = new GestionVias().obtenerSocPoblacionBeneficiadaPNVIRPorId(idIndicador);
		
		
		if (logger.isDebugEnabled()) {
			logger.debug("obtenerSocPoblacionBeneficiadaPNVIRPorId(BigDecimal idIndicador) - end"); 
		}
        return socPoblacionBeneficiadaPNVIR;		
	}


	/**
	 * Obtener soc ICVPNVIR por id.
	 *
	 * @param idIndicador the id indicador
	 * @return soc icv PNVIR
	 */
	public SocIcvPNVIR obtenerSocICVPNVIRPorId(BigDecimal idIndicador) {
		if (logger.isDebugEnabled()) {
			logger.debug("obtenerSocICVPNVIRPorId(BigDecimal idIndicador) - start"); 
		}


		SocIcvPNVIR socPoblacionBeneficiadaPNVIR = new GestionVias().obtenerSocICVPNVIRPorId(idIndicador);
		
		
		if (logger.isDebugEnabled()) {
			logger.debug("obtenerSocICVPNVIRPorId(BigDecimal idIndicador) - end"); 
		}
        return socPoblacionBeneficiadaPNVIR;		
	}


	/**
	 * Obtener soc poblacion diferencial PNVIR por id.
	 *
	 * @param idIndicador the id indicador
	 * @return soc poblacion diferencial PNVIR
	 */
	public SocPoblacionDiferencialPNVIR	obtenerSocPoblacionDiferencialPNVIRPorId(BigDecimal idIndicador) {
		if (logger.isDebugEnabled()) {
			logger.debug("SocPoblacionDiferencialPNVIR(BigDecimal idIndicador) - start"); 
		}


		SocPoblacionDiferencialPNVIR socPoblacionDiferencialPNVIR = new GestionVias().obtenerSocPoblacionDiferencialPNVIRPorId(idIndicador);
		
		
		if (logger.isDebugEnabled()) {
			logger.debug("SocPoblacionDiferencialPNVIR(BigDecimal idIndicador) - end"); 
		}
        return socPoblacionDiferencialPNVIR;		
	}


	/**
	 * Obtener soc sustitucion cultivos PNVIR por id.
	 *
	 * @param idIndicador the id indicador
	 * @return soc sustitucion cultivos PNVIR
	 */
	public SocSustitucionCultivosPNVIR obtenerSocSustitucionCultivosPNVIRPorId(BigDecimal idIndicador) {
		if (logger.isDebugEnabled()) {
			logger.debug("obtenerSocSustitucionCultivosPNVIRPorId(BigDecimal idIndicador) - start"); 
		}


		SocSustitucionCultivosPNVIR socSustitucionCultivosPNVIR = new GestionVias().obtenerSocSustitucionCultivosPNVIRPorId(idIndicador);
		
		
		if (logger.isDebugEnabled()) {
			logger.debug("obtenerSocSustitucionCultivosPNVIRPorId(BigDecimal idIndicador) - end"); 
		}
        return socSustitucionCultivosPNVIR;		
	}


	/**
	 * Obtener soc centros sociales PNVIR por id.
	 *
	 * @param idIndicador the id indicador
	 * @return soc centros sociales PNVIR
	 */
	public SocCentrosSocialesPNVIR obtenerSocCentrosSocialesPNVIRPorId(BigDecimal idIndicador) {
		if (logger.isDebugEnabled()) {
			logger.debug("obtenerSocCentrosSocialesPNVIRPorId(BigDecimal idIndicador) - start"); 
		}


		SocCentrosSocialesPNVIR socCentrosSocialesPNVIR = new GestionVias().obtenerSocCentrosSocialesPNVIRPorId(idIndicador);
		
		
		if (logger.isDebugEnabled()) {
			logger.debug("obtenerSocCentrosSocialesPNVIRPorId(BigDecimal idIndicador) - end"); 
		}
        return socCentrosSocialesPNVIR;		
	}


	/**
	 * Obterner lista volumenes trafico.
	 *
	 * @return list
	 */
	public List<EcoVolumenTraficoPNVIR> obternerListaVolumenesTrafico() {
		if (logger.isDebugEnabled()) {
			logger.debug("obternerListaVolumenesTrafico() - start"); 
		}

		List<EcoVolumenTraficoPNVIR> listaVolumenesTrafico = new GestionVias().obternerListaVolumenesTrafico();
		
		
		if (logger.isDebugEnabled()) {
			logger.debug("obternerListaVolumenesTrafico() - end"); 
		}
        return listaVolumenesTrafico;
	}


	/**
	 * Obtener eco comercializacion PNVIR por id.
	 *
	 * @param idIndicador the id indicador
	 * @return eco comercializacion PNVIR
	 */
	public EcoComercializacionPNVIR obtenerEcoComercializacionPNVIRPorId(BigDecimal idIndicador) {
		if (logger.isDebugEnabled()) {
			logger.debug("obtenerEcoComercializacionPNVIRPorId(BigDecimal idIndicador) - start"); 
		}


		EcoComercializacionPNVIR ecoComercializacionPNVIR = new GestionVias().obtenerEcoComercializacionPNVIRPorId(idIndicador);
		
		
		if (logger.isDebugEnabled()) {
			logger.debug("obtenerEcoComercializacionPNVIRPorId(BigDecimal idIndicador) - end"); 
		}
        return ecoComercializacionPNVIR;		
	}


	/**
	 * Obtener lista cultivos por municipio.
	 *
	 * @param municipioId the municipio id
	 * @return list
	 */
	public List<ProductoRendimiento> obtenerListaCultivosPorMunicipio(BigDecimal municipioId) {
		if (logger.isDebugEnabled()) {
			logger.debug("obtenerListaCultivosPorMunicipio(municipioId) - start"); 
		}

		List<ProductoRendimiento> productos = new GestionVias().obtenerListaCultivosPorMunicipio(municipioId);
		
		if (logger.isDebugEnabled()) {
			logger.debug("obtenerListaCultivosPorMunicipio(municipioId) - end"); 
		}
        return productos;
	}


	/**
	 * Obtener ecoco rendimiento PNVIR por id.
	 *
	 * @param idIndicadorProductividad the id indicador productividad
	 * @return eco rendimiento PNVIR
	 */
	public EcoRendimientoPNVIR obtenerEcocoRendimientoPNVIRPorId(BigDecimal idIndicadorProductividad) {
		if (logger.isDebugEnabled()) {
			logger.debug("obtenerEcocoRendimientoPNVIRPorId(BigDecimal idIndicador) - start"); 
		}


		EcoRendimientoPNVIR ecoRendimientoPNVIR = new GestionVias().obtenerEcocoRendimientoPNVIRPorId(idIndicadorProductividad);
		
		
		if (logger.isDebugEnabled()) {
			logger.debug("obtenerEcocoRendimientoPNVIRPorId(BigDecimal idIndicador) - end"); 
		}
        return ecoRendimientoPNVIR;		
	}


	/**
	 * Recalcular prioridades PV municipio.
	 *
	 * @param municipioId the municipio id
	 */
	public void recalcularPrioridadesPVMunicipio(BigDecimal municipioId) {
		if (logger.isDebugEnabled()) {
			logger.debug("recalcularPrioridadesPVMunicipio(BigDecimal municipioId) - start"); 
		}


		new GestionVias().recalcularPrioridadesPVMunicipio(municipioId);
		
		
		if (logger.isDebugEnabled()) {
			logger.debug("recalcularPrioridadesPVMunicipio(BigDecimal municipioId) - end"); 
		}
	}
	
	
	/**
	 * Obtener municipio por id.
	 *
	 * @param idMunicipio the id municipio
	 * @return municipio
	 */
	public Municipio obtenerMunicipioPorId(BigDecimal idMunicipio) {
		if (logger.isDebugEnabled()) {
			logger.debug("obtenerMunicipioPorId(BigDecimal) - start"); 
		}

		Municipio returnVia = new GestionVias().obtenerMunicipioPorId(idMunicipio);
		
		if (logger.isDebugEnabled()) {
			logger.debug("obtenerMunicipioPorId(BigDecimal) - end"); 
		}
        return returnVia;
	}
	
	
	/**
	 * Actualizar vereda.
	 *
	 * @param vereda the vereda
	 * @return true, si finaliza satisfactoriamente
	 */
	public boolean actualizarVereda(Vereda vereda) {
		if (logger.isDebugEnabled()) {
			logger.debug("actualizarVereda() - start"); 
		}

		boolean guardado = new GestionVias().actualizarVereda(vereda);

		if (logger.isDebugEnabled()) {
			logger.debug("actualizarVereda() - end"); 
		}
		
		return guardado;
	}

	
	/**
	 * Realizar intersecciones.
	 *
	 * @param via the via
	 * @return true, si finaliza satisfactoriamente
	 */
	public boolean realizarIntersecciones (Via via) {
		
		String observaciones = "";
		
		//VEREDAS
		List<Vereda> veredasIntersectas = new GestionVias().obtenerVeredasIntersectas(via.getCodVia());
		via.setVeredas(new HashSet<Vereda>(veredasIntersectas));

		//VIAS PRIMARIAS
		List<String> viasPrimariasIntersectas = new GestionVias().obtenerViasIntersectas(via.getCodVia(),1);
		if (viasPrimariasIntersectas != null && viasPrimariasIntersectas.size() > 0) {
			via.getTecnicosPV().setTranspViaPrimaria(true);
			for (String codigoVia : viasPrimariasIntersectas) {
				observaciones = observaciones.concat(codigoVia).concat(" / ");
			}
			observaciones = observaciones.substring(0, observaciones.trim().length()-1);
			via.getTecnicosPV().setTranspViaPrimariaObs(observaciones);
		}

		//VIAS SECUNDARIAS
		List<String> viasSecundariasIntersectas = new GestionVias().obtenerViasIntersectas(via.getCodVia(),2);
		if (viasSecundariasIntersectas != null && viasSecundariasIntersectas.size() > 0) {
			observaciones = "";
			via.getTecnicosPV().setTranspViaSecundaria(true);
			for (String codigoVia : viasSecundariasIntersectas) {
				observaciones = observaciones.concat(codigoVia).concat(" / ");
			}
			observaciones = observaciones.substring(0, observaciones.trim().length()-1);
			via.getTecnicosPV().setTranspViaSecundariaObs(observaciones);
		}
		
		//VIAS TERCIARIAS
		List<String> viasTerciariasIntersectas = new GestionVias().obtenerViasIntersectas(via.getCodVia(),3);
		if (viasTerciariasIntersectas != null && viasTerciariasIntersectas.size() > 1) {//siempre devuelve la propia vía
			observaciones = "";
			viasTerciariasIntersectas.remove(via.getCodVia());
			via.getTecnicosPV().setTranspViaTerciaria(true);
			for (String codigoVia : viasTerciariasIntersectas) {
				observaciones = observaciones.concat(codigoVia).concat(" / ");
			}
			observaciones = observaciones.substring(0, observaciones.trim().length()-1);
			via.getTecnicosPV().setTranspViaTerciariaObs(observaciones);
		}

		//COLEGIOS
		List<VSedeEducativaVereda> sedesEducativasEnVeredasAfectadas = new GestionVias().obtenerSedesEducativasAfectadas(via.getVeredas());
		if (sedesEducativasEnVeredasAfectadas != null && sedesEducativasEnVeredasAfectadas.size() > 0) {
			observaciones = "";
			via.getCentroSocialPV().setEscuelas(true);
			for (VSedeEducativaVereda vSedeEducativaVereda : sedesEducativasEnVeredasAfectadas) {
				observaciones = observaciones.concat(vSedeEducativaVereda.getNombreSede()).concat(" / ");
			}
			observaciones = observaciones.substring(0, observaciones.trim().length()-1);
			via.getCentroSocialPV().setEscuelasObs(observaciones);
		}
		
		//HOSPITALES
		List<VCentroSaludVereda> centrosSaludEnVeredasAfectadas = new GestionVias().obtenerCentrosSaludAfectados(via.getVeredas());
		if (centrosSaludEnVeredasAfectadas != null && centrosSaludEnVeredasAfectadas.size() > 0) {
			observaciones = "";
			via.getCentroSocialPV().setCentrosSalud(true);
			for (VCentroSaludVereda vCentroSaludVereda : centrosSaludEnVeredasAfectadas) {
				observaciones = observaciones.concat(vCentroSaludVereda.getNombreCentro()).concat(" / ");
			}
			observaciones = observaciones.substring(0, observaciones.trim().length()-1);
			via.getCentroSocialPV().setCentrosSaludObs(observaciones);
		}
		
		//ZONAS PDET
		Boolean intersectaZonaPDET = new GestionVias().intersectaZonaPDET(via.getCodVia());
		if (intersectaZonaPDET) {
			via.getTecnicosPV().setConectPdetZomac(true);
			via.getTecnicosPV().setConectPdetZomacObs(PDET_OBS);
		}

		//OTROS DEPARTAMENTOS
		List<Departamento> departamentosIntersectos = new GestionVias().obtenerDepartamentosIntersectos(via.getCodVia());
		if (departamentosIntersectos != null && departamentosIntersectos.size() > 1) {
			observaciones = "";
			via.getTecnicosPV().setConectOtrosDepartamentos(true);
			for (Departamento departamento : departamentosIntersectos) {
				if (!departamento.getNombre().equals(via.getMunicipio().getDepartamento().getNombre())) {
					observaciones = observaciones.concat(departamento.getNombre()).concat(" / ");
				}
			}
			observaciones = observaciones.substring(0, observaciones.trim().length()-1);
			via.getTecnicosPV().setConectOtrosDepartamentosObs(observaciones);
		}
		
		//OTROS MUNICIPIOS
		List<Municipio> municipiosIntersectos = new GestionVias().obtenerMunicipiosIntersectos(via.getCodVia());
		if (municipiosIntersectos != null && municipiosIntersectos.size() > 1) {
			observaciones = "";
			via.getTecnicosPV().setConectOtrosDepartamentos(true);
			for (Municipio municipio : municipiosIntersectos) {
				if (!municipio.getNombre().equals(via.getMunicipio().getNombre())) {
					observaciones = observaciones.concat(municipio.getNombre()).concat(" / ");
				}
			}
			observaciones = observaciones.substring(0, observaciones.trim().length()-1);
			via.getTecnicosPV().setConectOtrosDepartamentosObs(observaciones);
		}
		
		//AMBIENTAL - 0 - PARQUES
		List<String> parquesIntersectos = new GestionVias().intersectaAmbiental(via.getCodVia(), PARQUES);
		if (parquesIntersectos != null && parquesIntersectos.size() > 0) {
			observaciones = "";
			via.getAmbientalPV().setSuperpParquesNacionales(true);
			for (String parque : parquesIntersectos) {
				observaciones = observaciones.concat(parque).concat(" / ");
			}
			observaciones = observaciones.substring(0, observaciones.trim().length()-1);
			via.getAmbientalPV().setSuperpParquesNacionalesObs(observaciones);
		}
		
		//AMBIENTAL - 1 - INTERES
		List<String> zonasInteresIntersectos = new GestionVias().intersectaAmbiental(via.getCodVia(), INTERES);
		if (zonasInteresIntersectos != null && zonasInteresIntersectos.size() > 0) {
			observaciones = "";
			via.getAmbientalPV().setSuperpAreasEspecialInteres(true);
			for (String zonaInteres : zonasInteresIntersectos) {
				observaciones = observaciones.concat(zonaInteres).concat(" / ");
			}
			observaciones = observaciones.substring(0, observaciones.trim().length()-1);
			via.getAmbientalPV().setSuperpAreasEspecialInteresObs(observaciones);
		}
		
		//AMBIENTAL - 2 - BOSQUES
		List<String> bosquesIntersectos = new GestionVias().intersectaAmbiental(via.getCodVia(), BOSQUES);
		if (bosquesIntersectos != null && bosquesIntersectos.size() > 0) {
			via.getAmbientalPV().setSuperpCoberturasBosques(true);			
			via.getAmbientalPV().setSuperpCoberturasBosquesObs(BOSQUE_OBS);
		}
		
		//AMBIENTAL - 3 - HUMEDAS
		List<String> zonasHumedasIntersectos = new GestionVias().intersectaAmbiental(via.getCodVia(), HUMEDAS);
		if (zonasHumedasIntersectos != null && zonasHumedasIntersectos.size() > 0) {
			via.getAmbientalPV().setSuperpCoberturasAreasHumedas(true);
			via.getAmbientalPV().setSuperpCoberturasAreasHumedasObs(HUMEDA_OBS);
		}
		
		//AMBIENTAL - 4 - CORREDORES
		List<String> corredoresIntersectos = new GestionVias().intersectaAmbiental(via.getCodVia(), CORREDORES);
		if (corredoresIntersectos != null && corredoresIntersectos.size() > 0) {
			observaciones = "";
			via.getAmbientalPV().setSuperpCorredoresEco(true);
			for (String corredor : corredoresIntersectos) {
				observaciones = observaciones.concat(corredor).concat(" / ");				
			}
			observaciones = observaciones.substring(0, observaciones.trim().length()-1);
			via.getAmbientalPV().setSuperpCorredoresEcoObs(observaciones);
		}
		
		//AMBIENTAL - 5 - FAUNA
		List<String> faunaIntersectos = new GestionVias().intersectaAmbiental(via.getCodVia(), FAUNA);
		if (faunaIntersectos != null && faunaIntersectos.size() > 0) {
			observaciones = "";
			via.getAmbientalPV().setSuperpAreasFauna(true);
			via.getAmbientalPV().setSuperpAreasFaunaObs(FAUNA_OBS);
		}
		
		return true;
	}

	/**
	 * Recalcular porcentajes poblacion beneficiada.
	 *
	 * @param viaActual the via actual
	 * @param guardar the guardar
	 */
	public void recalcularPorcentajesPoblacionBeneficiada(Via viaActual, boolean guardar) {
		
		boolean isPloblacionMayor = false, isPloblacionDiferencialMayor = false;
		
		List<Via> vias = new Fachada().obtenerViasConPoblacionPorMunicipio(viaActual.getMunicipio().getIdMunicipio());
		BigDecimal poblacionMayor = null, poblacionDiferencialMayor = null;
		
		if (vias != null && vias.size() > 0) {
			Collections.sort(vias, (x, y) -> y.getPoblacionPV().getPoblacionTotalVeredas().compareTo(x.getPoblacionPV().getPoblacionTotalVeredas()));
			
			poblacionMayor = vias.get(0).getPoblacionPV().getPoblacionTotalVeredas();
			
			if (viaActual.getPoblacionPV().getPoblacionTotalVeredas()!=null) {
				if (viaActual.getPoblacionPV().getPoblacionTotalVeredas().compareTo(poblacionMayor) >= 0) { //la poblacion mayor corresponde a la via actual, le ponemos el 100%
					isPloblacionMayor = true;
					viaActual.getPoblacionPV().setPorcPoblacionBeneficiada(100.);
				}else {
					viaActual.getPoblacionPV().setPorcPoblacionBeneficiada((viaActual.getPoblacionPV().getPoblacionTotalVeredas().doubleValue() / poblacionMayor.doubleValue()) * 100);
				}
			}
			
			//si los datos etnicos son a nivel de municipio (todos iguales) se introducen manualmente y no se recalcula, ya que siempre saldría el 100%
			if (!viaActual.getPoblacionPV().getPorcPobDiferMunicipio()) {
				if (viaActual.getPoblacionPV().getEtnicaTotal() != null) {
					Collections.sort(vias, (x, y) -> y.getPoblacionPV().getEtnicaTotal()!=null&&x.getPoblacionPV().getEtnicaTotal()!=null?y.getPoblacionPV().getEtnicaTotal().compareTo(x.getPoblacionPV().getEtnicaTotal()):0);
				}
				
				poblacionDiferencialMayor = vias.get(0).getPoblacionPV().getEtnicaTotal()!=null?vias.get(0).getPoblacionPV().getEtnicaTotal():BigDecimal.ZERO;
				
				if (viaActual.getPoblacionPV().getEtnicaTotal()!=null) {
				
					if (viaActual.getPoblacionPV().getEtnicaTotal().compareTo(poblacionDiferencialMayor) >= 0) { //la poblacion diferencial mayor corresponde a la via actual, le ponemos el 100%
						isPloblacionDiferencialMayor = true;
						viaActual.getPoblacionPV().setPorcPoblacionDiferencialBeneficiada(100.);
					}else {
						viaActual.getPoblacionPV().setPorcPoblacionDiferencialBeneficiada((viaActual.getPoblacionPV().getEtnicaTotal().doubleValue() / poblacionDiferencialMayor.doubleValue()) * 100);
					}
				
				}
			}			
			
		}else { //caso de que se está trabajando con la primera vía y aun no se ha guardado, se pulsa en recalcular porcentajes
			if (viaActual.getPoblacionPV().getPoblacionTotalVeredas() != null && viaActual.getPoblacionPV().getPoblacionTotalVeredas().compareTo(BigDecimal.ZERO) >  0) {
				viaActual.getPoblacionPV().setPorcPoblacionBeneficiada(100.);
			}
			if (viaActual.getPoblacionPV().getEtnicaTotal() != null && viaActual.getPoblacionPV().getEtnicaTotal().compareTo(BigDecimal.ZERO) >  0 && !viaActual.getPoblacionPV().getPorcPobDiferMunicipio()) {
				viaActual.getPoblacionPV().setPorcPoblacionDiferencialBeneficiada(100.);
			}
		}
			
		onChangePorcPoblacion(viaActual);
		onChangePorcPoblacionDiferencial(viaActual);
		if (guardar) {
			actualizarVia(viaActual);
		}
		
		if (guardar) {
			if (isPloblacionMayor) { //la poblacion mayor corresponde a la via actual, hay que actualizar todas ya que cambian los porcentajes
				for (Via via : vias) {
					if (via.getPoblacionPV() != null && via.getPoblacionPV().getPoblacionTotalVeredas() != null) {
						via.getPoblacionPV().setPorcPoblacionBeneficiada((via.getPoblacionPV().getPoblacionTotalVeredas().doubleValue() / poblacionMayor.doubleValue()) * 100);
						 actualizarVia(via);
					}
				}
			}
			
			if (isPloblacionDiferencialMayor && !viaActual.getPoblacionPV().getPorcPobDiferMunicipio()) { //la poblacion diferencial mayor corresponde a la via actual, hay que actualizar todas ya que cambian los porcentajes
				for (Via via : vias) {
					if (via.getPoblacionPV() != null && via.getPoblacionPV().getEtnicaTotal() != null) {
						via.getPoblacionPV().setPorcPoblacionDiferencialBeneficiada((via.getPoblacionPV().getEtnicaTotal().doubleValue() / poblacionDiferencialMayor.doubleValue()) * 100);
						actualizarVia(via);
					}
				}
			}
		}
	}
	
	/**
	 * Obtener vias con poblacion por municipio.
	 *
	 * @param idMunicipio the id municipio
	 * @return list
	 */
	private List<Via> obtenerViasConPoblacionPorMunicipio(BigDecimal idMunicipio) {
		if (logger.isDebugEnabled()) {
			logger.debug("obtenerViasPorMunicipio() - start"); 
		}

		List<Via> returnList = new GestionVias().obtenerViasConPoblacionPorMunicipio(idMunicipio);
		
		if (logger.isDebugEnabled()) {
			logger.debug("obtenerViasPorMunicipio() - end"); 
		}
        return returnList;
	}


	/**
	 * Cambia porc poblacion.
	 *
	 * @param via the via
	 */
	public void onChangePorcPoblacion(Via via) {
		Double porcentaje = via.getPoblacionPV().getPorcPoblacionBeneficiada();
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
			
			via.getPoblacionPV().setSocPoblacionBeneficiadaPNVIR(obtenerSocPoblacionBeneficiadaPNVIRPorId(idIndicador));
		}else{
			via.getPoblacionPV().setSocPoblacionBeneficiadaPNVIR(null);
		}
	}
	
	/**
	 * Cambia porc poblacion diferencial.
	 *
	 * @param via the via
	 */
	public void onChangePorcPoblacionDiferencial(Via via) {
		Double porcentaje = via.getPoblacionPV().getPorcPoblacionDiferencialBeneficiada();
		
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
			
			via.getPoblacionPV().setSocPoblacionDiferencialPNVIR(obtenerSocPoblacionDiferencialPNVIRPorId(idIndicador));
		}else {
			via.getPoblacionPV().setSocPoblacionDiferencialPNVIR(null);
		}

	}

	/**
	 * Obtener lista codigos vias.
	 *
	 * @return list
	 */
	public List<String> obtenerListaCodigosVias() {
		if (logger.isDebugEnabled()) {
			logger.debug("obtenerListaCodigosVias() - start"); 
		}

		List<String> returnList = new GestionVias().obtenerListaCodigosVias();
		
		if (logger.isDebugEnabled()) {
			logger.debug("obtenerListaCodigosVias() - end"); 
		}
        return returnList;
	}
	
	/**
	 * Obtener lista codigos vias por municipio.
	 *
	 * @param idMunicipio the id municipio
	 * @return list
	 */
	public List<String> obtenerListaCodigosViasPorMunicipio(BigDecimal idMunicipio) {
		if (logger.isDebugEnabled()) {
			logger.debug("obtenerListaCodigosViasPorMunicipio() - start"); 
		}

		List<String> returnList = new GestionVias().obtenerListaCodigosViasPorMunicipio(idMunicipio);
		
		if (logger.isDebugEnabled()) {
			logger.debug("obtenerListaCodigosViasPorMunicipio() - end"); 
		}
        return returnList;
	}

	/**
	 * Obtener municipio por codigo.
	 *
	 * @param codMunicipio the cod municipio
	 * @return municipio
	 */
	public Municipio obtenerMunicipioPorCodigo(String codMunicipio) {
		if (logger.isDebugEnabled()) {
			logger.debug("obtenerMunicipioPorCodigo(codMunicipio) - start"); 
		}

		Municipio municipio = new GestionVias().obtenerMunicipioPorCodigo(codMunicipio);
		
		if (logger.isDebugEnabled()) {
			logger.debug("obtenerMunicipioPorCodigo(codMunicipio) - end"); 
		}
        return municipio;
	}

	/**
	 * Obtener secciones via.
	 *
	 * @param codVia the cod via
	 * @return list
	 */
	public List<GeoSeccionTransversal> obtenerSeccionesVia(String codVia) {
		if (logger.isDebugEnabled()) {
			logger.debug("obtenerSeccionesVia(codVia) - start"); 
		}

		List<GeoSeccionTransversal> returnList = new GestionVias().obtenerSeccionesVia(codVia);
		
		if (logger.isDebugEnabled()) {
			logger.debug("obtenerSeccionesVia(codVia) - end"); 
		}
        return returnList;
	}

	/**
	 * Existe codigo vereda.
	 *
	 * @param codVereda the cod vereda
	 * @return true, si finaliza satisfactoriamente
	 */
	public boolean existeCodigoVereda(String codVereda) {
		if (logger.isDebugEnabled()) {
			logger.debug("validarCodigoVereda(codVereda) - start"); 
		}

		boolean returnList = new GestionVias().existeCodigoVereda(codVereda);
		
		if (logger.isDebugEnabled()) {
			logger.debug("validarCodigoVereda(codVereda) - end"); 
		}
        return returnList;
	}
	
	
	/**
	 * Obtener actividades por via.
	 *
	 * @param viaId the via id
	 * @return list
	 */
	public List<ActividadModeloTeorico> obtenerActividadesPorVia(BigDecimal viaId) {
		if (logger.isDebugEnabled()) {
			logger.debug("obtenerActividadesPorVia(viaId) - start"); 
		}

		List<ActividadModeloTeorico> actividades = new GestionVias().obtenerActividadesPorVia(viaId);
		
		if (logger.isDebugEnabled()) {
			logger.debug("obtenerActividadesPorVia(viaId) - end"); 
		}
        return actividades;
	}
	
	/**
	 * Actualizar actividad.
	 *
	 * @param actividad the actividad
	 * @return true, si finaliza satisfactoriamente
	 */
	public boolean actualizarActividad(ActividadModeloTeorico actividad) {
		if (logger.isDebugEnabled()) {
			logger.debug("actualizarActividad() - start"); 
		}

		boolean guardado = new GestionVias().actualizarActividad(actividad);

		if (logger.isDebugEnabled()) {
			logger.debug("actualizarActividad() - end"); 
		}
		
		return guardado;
	}

	/**
	 * Eliminar actividad.
	 *
	 * @param idActividad the id actividad
	 * @return true, si finaliza satisfactoriamente
	 */
	public boolean eliminarActividad(ActividadModeloTeorico idActividad) {
		if (logger.isDebugEnabled()) {
			logger.debug("eliminarActividad() - start"); 
		}

		boolean eliminado = new GestionVias().eliminarActividad(idActividad);

		if (logger.isDebugEnabled()) {
			logger.debug("eliminarActividad() - end"); 
		}
		
		return eliminado;
	}

	/**
	 * Obtener precios por municipio.
	 *
	 * @param municipioId the municipio id
	 * @return analisis precios
	 */
	public AnalisisPrecios obtenerPreciosPorMunicipio(BigDecimal municipioId) {
		if (logger.isDebugEnabled()) {
			logger.debug("obtenerPreciosPorMunicipio() - start"); 
		}

		AnalisisPrecios preciosMunicipio = new GestionVias().obtenerPreciosPorMunicipio(municipioId);
		
		if (logger.isDebugEnabled()) {
			logger.debug("obtenerPreciosPorMunicipio() - end"); 
		}
        return preciosMunicipio;
	}

	/**
	 * Actualizar precios.
	 *
	 * @param preciosMunicipio the precios municipio
	 * @return true, si finaliza satisfactoriamente
	 */
	public boolean actualizarPrecios(AnalisisPrecios preciosMunicipio) {
		if (logger.isDebugEnabled()) {
			logger.debug("actualizarPrecios() - start"); 
		}

		boolean guardado = new GestionVias().actualizarPrecios(preciosMunicipio);

		if (logger.isDebugEnabled()) {
			logger.debug("actualizarPrecios() - end"); 
		}
		
		return guardado;
	}

	/**
	 * Obtener actividades por via Y fecha.
	 *
	 * @param idVia the id via
	 * @param anioActual the anio actual
	 * @return list
	 */
	public List<ActividadModeloTeorico> obtenerActividadesPorViaYFecha(BigDecimal idVia, BigDecimal anioActual) {
		if (logger.isDebugEnabled()) {
			logger.debug("obtenerActividadesPorViaYFecha(viaId, anioActual) - start"); 
		}

		List<ActividadModeloTeorico> actividades = new GestionVias().obtenerActividadesPorVia(idVia, anioActual);
		
		if (logger.isDebugEnabled()) {
			logger.debug("obtenerActividadesPorViaYFecha(viaId, anioActual) - end"); 
		}
        return actividades;
	}
	
}

