package es.everis.gvias.core.appbase.model.integration.dao.generado;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * Clase EconomicoPV.
 */
@Entity
@Table(name = "economico_pv")
public class EconomicoPV implements java.io.Serializable {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/**  id economico pv. */
	@Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_economico_pv") 
	private BigDecimal idEconomicoPv;
	
	/**  proyectos. */
	@Column(name = "proyectos") 	
	private Boolean proyectos;
	
	/**  proyectos obs. */
	@Column(name = "proyectos_obs") 	
	private String proyectosObs;

	/**  conecta inter modal. */
	@Column(name = "conecta_inter_modal") 	
	private Boolean conectaInterModal;
	
	/**  conecta inter modal obs. */
	@Column(name = "conecta_inter_modal_obs") 	
	private String conectaInterModalObs;
	
	/**  eco volumen trafico PNVIR. */
	@ManyToOne 
	@JoinColumn(name="id_eco_volumen_trafico_pnvir")
	private EcoVolumenTraficoPNVIR ecoVolumenTraficoPNVIR;
	
	/**  eco comercializacion PNVIR. */
	@ManyToOne 
	@JoinColumn(name="id_eco_comercializacion_pnvir")
	private EcoComercializacionPNVIR ecoComercializacionPNVIR;

	/**
	 * Obtiene id economico pv.
	 *
	 * @return  id economico pv
	 */
	public BigDecimal getIdEconomicoPv() {
		return idEconomicoPv;
	}

	/**
	 * Establece id economico pv.
	 *
	 * @param idEconomicoPv  id economico pv
	 */
	public void setIdEconomicoPv(BigDecimal idEconomicoPv) {
		this.idEconomicoPv = idEconomicoPv;
	}

	/**
	 * Obtiene proyectos.
	 *
	 * @return  proyectos
	 */
	public Boolean getProyectos() {
		return proyectos;
	}

	/**
	 * Establece proyectos.
	 *
	 * @param proyectos  proyectos
	 */
	public void setProyectos(Boolean proyectos) {
		this.proyectos = proyectos;
	}

	/**
	 * Obtiene proyectos obs.
	 *
	 * @return  proyectos obs
	 */
	public String getProyectosObs() {
		return proyectosObs;
	}

	/**
	 * Establece proyectos obs.
	 *
	 * @param proyectosObs  proyectos obs
	 */
	public void setProyectosObs(String proyectosObs) {
		this.proyectosObs = proyectosObs;
	}

	/**
	 * Obtiene conecta inter modal.
	 *
	 * @return  conecta inter modal
	 */
	public Boolean getConectaInterModal() {
		return conectaInterModal;
	}

	/**
	 * Establece conecta inter modal.
	 *
	 * @param conectaInterModal  conecta inter modal
	 */
	public void setConectaInterModal(Boolean conectaInterModal) {
		this.conectaInterModal = conectaInterModal;
	}

	/**
	 * Obtiene conecta inter modal obs.
	 *
	 * @return  conecta inter modal obs
	 */
	public String getConectaInterModalObs() {
		return conectaInterModalObs;
	}

	/**
	 * Establece conecta inter modal obs.
	 *
	 * @param conectaInterModalObs  conecta inter modal obs
	 */
	public void setConectaInterModalObs(String conectaInterModalObs) {
		this.conectaInterModalObs = conectaInterModalObs;
	}

	/**
	 * Obtiene eco volumen trafico PNVIR.
	 *
	 * @return  eco volumen trafico PNVIR
	 */
	public EcoVolumenTraficoPNVIR getEcoVolumenTraficoPNVIR() {
		return ecoVolumenTraficoPNVIR;
	}

	/**
	 * Establece eco volumen trafico PNVIR.
	 *
	 * @param ecoVolumenTraficoPNVIR  eco volumen trafico PNVIR
	 */
	public void setEcoVolumenTraficoPNVIR(EcoVolumenTraficoPNVIR ecoVolumenTraficoPNVIR) {
		this.ecoVolumenTraficoPNVIR = ecoVolumenTraficoPNVIR;
	}

	/**
	 * Obtiene eco comercializacion PNVIR.
	 *
	 * @return  eco comercializacion PNVIR
	 */
	public EcoComercializacionPNVIR getEcoComercializacionPNVIR() {
		return ecoComercializacionPNVIR;
	}

	/**
	 * Establece eco comercializacion PNVIR.
	 *
	 * @param ecoComercializacionPNVIR  eco comercializacion PNVIR
	 */
	public void setEcoComercializacionPNVIR(EcoComercializacionPNVIR ecoComercializacionPNVIR) {
		this.ecoComercializacionPNVIR = ecoComercializacionPNVIR;
	}
	
}