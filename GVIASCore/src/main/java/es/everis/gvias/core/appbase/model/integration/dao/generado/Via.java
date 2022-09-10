package es.everis.gvias.core.appbase.model.integration.dao.generado;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * Clase Via.
 */
@Entity
@Table(name = "via")
public class Via implements java.io.Serializable {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**  id via. */
	@Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_via") 
	private BigDecimal idVia;
	
	/**  cod via. */
	@Column(name = "cod_via")
	private String codVia;
	
	/**  nombre. */
	@Column(name = "nombre")
	private String nombre;
	
	/**  longitud total. */
	@Column(name = "longitud_total")
	private Double longitudTotal;
	
	/**  ancho promedio. */
	@Column(name = "ancho_promedio")
	private Double anchoPromedio;
	
	/**  pavim bueno. */
	@Column(name = "pavim_bueno")
	private Double pavimBueno;
	
	/**  pavim regular. */
	@Column(name = "pavim_regular")
	private Double pavimRegular;
	
	/**  pavim malo. */
	@Column(name = "pavim_malo")
	private Double pavimMalo;
	
	/**  pavim total. */
	@Column(name = "pavim_total")
	private Double pavimTotal;
	
	/**  afirm bueno. */
	@Column(name = "afirm_bueno")
	private Double afirmBueno;
	
	/**  afirm regular. */
	@Column(name = "afirm_regular")
	private Double afirmRegular;
	
	/**  afirm malo. */
	@Column(name = "afirm_malo")
	private Double afirmMalo;
	
	/**  afirm total. */
	@Column(name = "afirm_total")
	private Double afirmTotal;
	
	/**  tierra bueno. */
	@Column(name = "tierra_bueno")
	private Double tierraBueno;
	
	/**  tierra regular. */
	@Column(name = "tierra_regular")
	private Double tierraRegular;
	
	/**  tierra malo. */
	@Column(name = "tierra_malo")
	private Double tierraMalo;
	
	/**  tierra total. */
	@Column(name = "tierra_total")
	private Double tierraTotal;
	
	/**  mejora bueno. */
	@Column(name = "mejora_bueno")
	private Double mejoraBueno;
	
	/**  mejora regular. */
	@Column(name = "mejora_regular")
	private Double mejoraRegular;
	
	/**  mejora malo. */
	@Column(name = "mejora_malo")
	private Double mejoraMalo;
	
	/**  mejora total. */
	@Column(name = "mejora_total")
	private Double mejoraTotal;
	
	/**  estudios diseno. */
	@Column(name = "estudios_diseno")
	private Boolean estudiosDiseno;
	
	/**  proy estructurado. */
	@Column(name = "proy_estructurado")
	private Boolean proyEstructurado;
	
	/**  proy aprobado. */
	@Column(name = "proy_aprobado")
	private Boolean proyAprobado;
	
	/**  observaciones. */
	@Column(name = "observaciones")
	private String observaciones;
	
	/**  puntaje total pv. */
	@Column(name = "puntaje_total_pv")
	private BigDecimal puntajeTotalPv;
	
	/**  prioridad pv. */
	@Column(name = "prioridad_pv")
	private BigDecimal prioridadPv;
	
	/**  grupo prioridad pv. */
	@Column(name = "grupo_prioridad_pv")
	private BigDecimal grupoPrioridadPv;
	
	/**  categorizacion. */
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_categorizacion")
	Categorizacion categorizacion;
	
	/**  tecnicos PV. */
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_tecnicos_pv")
	TecnicosPV tecnicosPV;
	
	/**  poblacion PV. */
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_poblacion_pv")
	PoblacionPV poblacionPV;
	
	/**  centro social PV. */
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_centro_social_pv")
	CentroSocialPV centroSocialPV;
	
	/**  ambiental PV. */
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_ambiental_pv")
	AmbientalPV ambientalPV;
	
	/**  economico PV. */
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_economico_pv")
	EconomicoPV economicoPV;
	
	/**  productividad PV. */
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_productividad_pv")
	ProductividadPV productividadPV;
	
	/**  intervencion PV. */
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_intervencion_pv")
	IntervencionPV intervencionPV;
	
	/**  modelo teorico PV. */
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_modelo_teorico_pv")
	ModeloTeoricoPV modeloTeoricoPV;
	
	/**  analisis estimacion. */
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_analisis_estimacion")
	AnalisisEstimacion analisisEstimacion;
	
	/**  municipio. */
	@ManyToOne 
	@JoinColumn(name="id_municipio")
	private Municipio municipio; 
	
	/**  competencia. */
	@ManyToOne 
	@JoinColumn(name="id_competencia")
	private Competencia competencia; 
	
    /**  veredas. */
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "via_vereda", 
        joinColumns = { @JoinColumn(name = "id_via") }, 
        inverseJoinColumns = { @JoinColumn(name = "id_vereda") }
    )
    Set<Vereda> veredas = new HashSet<Vereda>();
	

	/**
	 * Instancia una nueva via.
	 */
	public Via() {
	}


	/**
	 * Instancia una nueva via.
	 *
	 * @param codVia  cod via
	 * @param nombre  nombre
	 */
	public Via(String codVia, String nombre) {
		this.codVia = codVia;
		this.nombre = nombre;
	}


	/**
	 * Obtiene id via.
	 *
	 * @return  id via
	 */
	public BigDecimal getIdVia() {
		return idVia;
	}


	/**
	 * Establece id via.
	 *
	 * @param idVia  id via
	 */
	public void setIdVia(BigDecimal idVia) {
		this.idVia = idVia;
	}


	/**
	 * Obtiene cod via.
	 *
	 * @return  cod via
	 */
	public String getCodVia() {
		return codVia;
	}


	/**
	 * Establece cod via.
	 *
	 * @param codVia  cod via
	 */
	public void setCodVia(String codVia) {
		this.codVia = codVia;
	}


	/**
	 * Obtiene nombre.
	 *
	 * @return  nombre
	 */
	public String getNombre() {
		return nombre;
	}


	/**
	 * Establece nombre.
	 *
	 * @param nombre  nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	/**
	 * Obtiene categorizacion.
	 *
	 * @return  categorizacion
	 */
	public Categorizacion getCategorizacion() {
		return categorizacion;
	}


	/**
	 * Establece categorizacion.
	 *
	 * @param categorizacion  categorizacion
	 */
	public void setCategorizacion(Categorizacion categorizacion) {
		this.categorizacion = categorizacion;
	}


	/**
	 * Obtiene municipio.
	 *
	 * @return  municipio
	 */
	public Municipio getMunicipio() {
		return municipio;
	}


	/**
	 * Establece municipio.
	 *
	 * @param municipio  municipio
	 */
	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}


	/**
	 * Obtiene veredas.
	 *
	 * @return  veredas
	 */
	public Set<Vereda> getVeredas() {
		return veredas;
	}


	/**
	 * Establece veredas.
	 *
	 * @param veredas  veredas
	 */
	public void setVeredas(Set<Vereda> veredas) {
		this.veredas = veredas;
	}


	/**
	 * Obtiene competencia.
	 *
	 * @return  competencia
	 */
	public Competencia getCompetencia() {
		return competencia;
	}


	/**
	 * Establece competencia.
	 *
	 * @param competencia  competencia
	 */
	public void setCompetencia(Competencia competencia) {
		this.competencia = competencia;
	}


	/**
	 * Obtiene longitud total.
	 *
	 * @return  longitud total
	 */
	public Double getLongitudTotal() {
		return longitudTotal;
	}


	/**
	 * Establece longitud total.
	 *
	 * @param longitudTotal  longitud total
	 */
	public void setLongitudTotal(Double longitudTotal) {
		this.longitudTotal = longitudTotal;
	}


	/**
	 * Obtiene ancho promedio.
	 *
	 * @return  ancho promedio
	 */
	public Double getAnchoPromedio() {
		return anchoPromedio;
	}


	/**
	 * Establece ancho promedio.
	 *
	 * @param anchoPromedio  ancho promedio
	 */
	public void setAnchoPromedio(Double anchoPromedio) {
		this.anchoPromedio = anchoPromedio;
	}


	/**
	 * Obtiene pavim bueno.
	 *
	 * @return  pavim bueno
	 */
	public Double getPavimBueno() {
		return pavimBueno;
	}


	/**
	 * Establece pavim bueno.
	 *
	 * @param pavimBueno  pavim bueno
	 */
	public void setPavimBueno(Double pavimBueno) {
		this.pavimBueno = pavimBueno;
	}


	/**
	 * Obtiene pavim regular.
	 *
	 * @return  pavim regular
	 */
	public Double getPavimRegular() {
		return pavimRegular;
	}


	/**
	 * Establece pavim regular.
	 *
	 * @param pavimRegular  pavim regular
	 */
	public void setPavimRegular(Double pavimRegular) {
		this.pavimRegular = pavimRegular;
	}


	/**
	 * Obtiene pavim malo.
	 *
	 * @return  pavim malo
	 */
	public Double getPavimMalo() {
		return pavimMalo;
	}


	/**
	 * Establece pavim malo.
	 *
	 * @param pavimMalo  pavim malo
	 */
	public void setPavimMalo(Double pavimMalo) {
		this.pavimMalo = pavimMalo;
	}


	/**
	 * Obtiene afirm bueno.
	 *
	 * @return  afirm bueno
	 */
	public Double getAfirmBueno() {
		return afirmBueno;
	}


	/**
	 * Establece afirm bueno.
	 *
	 * @param afirmBueno  afirm bueno
	 */
	public void setAfirmBueno(Double afirmBueno) {
		this.afirmBueno = afirmBueno;
	}


	/**
	 * Obtiene afirm regular.
	 *
	 * @return  afirm regular
	 */
	public Double getAfirmRegular() {
		return afirmRegular;
	}


	/**
	 * Establece afirm regular.
	 *
	 * @param afirmRegular  afirm regular
	 */
	public void setAfirmRegular(Double afirmRegular) {
		this.afirmRegular = afirmRegular;
	}


	/**
	 * Obtiene afirm malo.
	 *
	 * @return  afirm malo
	 */
	public Double getAfirmMalo() {
		return afirmMalo;
	}


	/**
	 * Establece afirm malo.
	 *
	 * @param afirmMalo  afirm malo
	 */
	public void setAfirmMalo(Double afirmMalo) {
		this.afirmMalo = afirmMalo;
	}


	/**
	 * Obtiene tierra bueno.
	 *
	 * @return  tierra bueno
	 */
	public Double getTierraBueno() {
		return tierraBueno;
	}


	/**
	 * Establece tierra bueno.
	 *
	 * @param tierraBueno  tierra bueno
	 */
	public void setTierraBueno(Double tierraBueno) {
		this.tierraBueno = tierraBueno;
	}


	/**
	 * Obtiene tierra regular.
	 *
	 * @return  tierra regular
	 */
	public Double getTierraRegular() {
		return tierraRegular;
	}


	/**
	 * Establece tierra regular.
	 *
	 * @param tierraRegular  tierra regular
	 */
	public void setTierraRegular(Double tierraRegular) {
		this.tierraRegular = tierraRegular;
	}


	/**
	 * Obtiene tierra malo.
	 *
	 * @return  tierra malo
	 */
	public Double getTierraMalo() {
		return tierraMalo;
	}


	/**
	 * Establece tierra malo.
	 *
	 * @param tierraMalo  tierra malo
	 */
	public void setTierraMalo(Double tierraMalo) {
		this.tierraMalo = tierraMalo;
	}


	/**
	 * Obtiene mejora bueno.
	 *
	 * @return  mejora bueno
	 */
	public Double getMejoraBueno() {
		return mejoraBueno;
	}


	/**
	 * Establece mejora bueno.
	 *
	 * @param mejoraBueno  mejora bueno
	 */
	public void setMejoraBueno(Double mejoraBueno) {
		this.mejoraBueno = mejoraBueno;
	}


	/**
	 * Obtiene mejora regular.
	 *
	 * @return  mejora regular
	 */
	public Double getMejoraRegular() {
		return mejoraRegular;
	}


	/**
	 * Establece mejora regular.
	 *
	 * @param mejoraRegular  mejora regular
	 */
	public void setMejoraRegular(Double mejoraRegular) {
		this.mejoraRegular = mejoraRegular;
	}


	/**
	 * Obtiene mejora malo.
	 *
	 * @return  mejora malo
	 */
	public Double getMejoraMalo() {
		return mejoraMalo;
	}


	/**
	 * Establece mejora malo.
	 *
	 * @param mejoraMalo  mejora malo
	 */
	public void setMejoraMalo(Double mejoraMalo) {
		this.mejoraMalo = mejoraMalo;
	}


	/**
	 * Obtiene estudios diseno.
	 *
	 * @return  estudios diseno
	 */
	public Boolean getEstudiosDiseno() {
		return estudiosDiseno;
	}


	/**
	 * Establece estudios diseno.
	 *
	 * @param estudiosDiseno  estudios diseno
	 */
	public void setEstudiosDiseno(Boolean estudiosDiseno) {
		this.estudiosDiseno = estudiosDiseno;
	}


	/**
	 * Obtiene proy estructurado.
	 *
	 * @return  proy estructurado
	 */
	public Boolean getProyEstructurado() {
		return proyEstructurado;
	}


	/**
	 * Establece proy estructurado.
	 *
	 * @param proyEstructurado  proy estructurado
	 */
	public void setProyEstructurado(Boolean proyEstructurado) {
		this.proyEstructurado = proyEstructurado;
	}


	/**
	 * Obtiene proy aprobado.
	 *
	 * @return  proy aprobado
	 */
	public Boolean getProyAprobado() {
		return proyAprobado;
	}


	/**
	 * Establece proy aprobado.
	 *
	 * @param proyAprobado  proy aprobado
	 */
	public void setProyAprobado(Boolean proyAprobado) {
		this.proyAprobado = proyAprobado;
	}


	/**
	 * Obtiene observaciones.
	 *
	 * @return  observaciones
	 */
	public String getObservaciones() {
		return observaciones;
	}


	/**
	 * Establece observaciones.
	 *
	 * @param observaciones  observaciones
	 */
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}


	/**
	 * Obtiene puntaje total pv.
	 *
	 * @return  puntaje total pv
	 */
	public BigDecimal getPuntajeTotalPv() {
		return puntajeTotalPv;
	}


	/**
	 * Establece puntaje total pv.
	 *
	 * @param puntajeTotalPv  puntaje total pv
	 */
	public void setPuntajeTotalPv(BigDecimal puntajeTotalPv) {
		this.puntajeTotalPv = puntajeTotalPv;
	}


	/**
	 * Obtiene prioridad pv.
	 *
	 * @return  prioridad pv
	 */
	public BigDecimal getPrioridadPv() {
		return prioridadPv;
	}


	/**
	 * Establece prioridad pv.
	 *
	 * @param prioridadPv  prioridad pv
	 */
	public void setPrioridadPv(BigDecimal prioridadPv) {
		this.prioridadPv = prioridadPv;
	}


	/**
	 * Obtiene pavim total.
	 *
	 * @return  pavim total
	 */
	public Double getPavimTotal() {
		return pavimTotal;
	}


	/**
	 * Establece pavim total.
	 *
	 * @param pavimTotal  pavim total
	 */
	public void setPavimTotal(Double pavimTotal) {
		this.pavimTotal = pavimTotal;
	}


	/**
	 * Obtiene afirm total.
	 *
	 * @return  afirm total
	 */
	public Double getAfirmTotal() {
		return afirmTotal;
	}


	/**
	 * Establece afirm total.
	 *
	 * @param afirmTotal  afirm total
	 */
	public void setAfirmTotal(Double afirmTotal) {
		this.afirmTotal = afirmTotal;
	}


	/**
	 * Obtiene tierra total.
	 *
	 * @return  tierra total
	 */
	public Double getTierraTotal() {
		return tierraTotal;
	}


	/**
	 * Establece tierra total.
	 *
	 * @param tierraTotal  tierra total
	 */
	public void setTierraTotal(Double tierraTotal) {
		this.tierraTotal = tierraTotal;
	}


	/**
	 * Obtiene mejora total.
	 *
	 * @return  mejora total
	 */
	public Double getMejoraTotal() {
		return mejoraTotal;
	}


	/**
	 * Establece mejora total.
	 *
	 * @param mejoraTotal  mejora total
	 */
	public void setMejoraTotal(Double mejoraTotal) {
		this.mejoraTotal = mejoraTotal;
	}


	/**
	 * Obtiene tecnicos PV.
	 *
	 * @return  tecnicos PV
	 */
	public TecnicosPV getTecnicosPV() {
		return tecnicosPV;
	}


	/**
	 * Establece tecnicos PV.
	 *
	 * @param tecnicosPV  tecnicos PV
	 */
	public void setTecnicosPV(TecnicosPV tecnicosPV) {
		this.tecnicosPV = tecnicosPV;
	}


	/**
	 * Obtiene poblacion PV.
	 *
	 * @return  poblacion PV
	 */
	public PoblacionPV getPoblacionPV() {
		return poblacionPV;
	}


	/**
	 * Establece poblacion PV.
	 *
	 * @param poblacionPV  poblacion PV
	 */
	public void setPoblacionPV(PoblacionPV poblacionPV) {
		this.poblacionPV = poblacionPV;
	}


	/**
	 * Obtiene centro social PV.
	 *
	 * @return  centro social PV
	 */
	public CentroSocialPV getCentroSocialPV() {
		return centroSocialPV;
	}


	/**
	 * Establece centro social PV.
	 *
	 * @param centroSocialPV  centro social PV
	 */
	public void setCentroSocialPV(CentroSocialPV centroSocialPV) {
		this.centroSocialPV = centroSocialPV;
	}


	/**
	 * Obtiene ambiental PV.
	 *
	 * @return  ambiental PV
	 */
	public AmbientalPV getAmbientalPV() {
		return ambientalPV;
	}


	/**
	 * Establece ambiental PV.
	 *
	 * @param ambientalPV  ambiental PV
	 */
	public void setAmbientalPV(AmbientalPV ambientalPV) {
		this.ambientalPV = ambientalPV;
	}


	/**
	 * Obtiene economico PV.
	 *
	 * @return  economico PV
	 */
	public EconomicoPV getEconomicoPV() {
		return economicoPV;
	}


	/**
	 * Establece economico PV.
	 *
	 * @param economicoPV  economico PV
	 */
	public void setEconomicoPV(EconomicoPV economicoPV) {
		this.economicoPV = economicoPV;
	}


	/**
	 * Obtiene productividad PV.
	 *
	 * @return  productividad PV
	 */
	public ProductividadPV getProductividadPV() {
		return productividadPV;
	}


	/**
	 * Establece productividad PV.
	 *
	 * @param productividadPV  productividad PV
	 */
	public void setProductividadPV(ProductividadPV productividadPV) {
		this.productividadPV = productividadPV;
	}


	/**
	 * Obtiene grupo prioridad pv.
	 *
	 * @return  grupo prioridad pv
	 */
	public BigDecimal getGrupoPrioridadPv() {
		return grupoPrioridadPv;
	}


	/**
	 * Establece grupo prioridad pv.
	 *
	 * @param grupoPrioridadPv  grupo prioridad pv
	 */
	public void setGrupoPrioridadPv(BigDecimal grupoPrioridadPv) {
		this.grupoPrioridadPv = grupoPrioridadPv;
	}


	/**
	 * Obtiene intervencion PV.
	 *
	 * @return  intervencion PV
	 */
	public IntervencionPV getIntervencionPV() {
		return intervencionPV;
	}


	/**
	 * Establece intervencion PV.
	 *
	 * @param intervencionPV  intervencion PV
	 */
	public void setIntervencionPV(IntervencionPV intervencionPV) {
		this.intervencionPV = intervencionPV;
	}


	/**
	 * Obtiene modelo teorico PV.
	 *
	 * @return  modelo teorico PV
	 */
	public ModeloTeoricoPV getModeloTeoricoPV() {
		return modeloTeoricoPV;
	}


	/**
	 * Establece modelo teorico PV.
	 *
	 * @param modeloTeoricoPV  modelo teorico PV
	 */
	public void setModeloTeoricoPV(ModeloTeoricoPV modeloTeoricoPV) {
		this.modeloTeoricoPV = modeloTeoricoPV;
	}

	/**
	 * Obtiene analisis estimacion.
	 *
	 * @return  analisis estimacion
	 */
	public AnalisisEstimacion getAnalisisEstimacion() {
		return analisisEstimacion;
	}

	/**
	 * Establece analisis estimacion.
	 *
	 * @param analisisEstimacion  analisis estimacion
	 */
	public void setAnalisisEstimacion(AnalisisEstimacion analisisEstimacion) {
		this.analisisEstimacion = analisisEstimacion;
	}
}