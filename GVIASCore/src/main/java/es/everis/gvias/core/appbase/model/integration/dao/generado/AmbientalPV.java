package es.everis.gvias.core.appbase.model.integration.dao.generado;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * Clase AmbientalPV.
 */
@Entity
@Table(name = "ambiental_pv")
public class AmbientalPV implements java.io.Serializable {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The id ambiental PV. */
	@Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ambiental_pv") 
	private BigDecimal idAmbientalPV;
	
	/** The superp parques nacionales. */
	@Column(name = "superp_parques_nacionales") 	
	private Boolean superpParquesNacionales;
	
	/** The superp parques nacionales obs. */
	@Column(name = "superp_parques_nacionales_obs") 	
	private String superpParquesNacionalesObs;

	/** The superp areas especial interes. */
	@Column(name = "superp_areas_especial_interes") 	
	private Boolean superpAreasEspecialInteres;
	
	/** The superp areas especial interes obs. */
	@Column(name = "superp_areas_especial_interes_obs") 	
	private String superpAreasEspecialInteresObs;
	
	/** The superp coberturas bosques. */
	@Column(name = "superp_coberturas_bosques") 	
	private Boolean superpCoberturasBosques;
	
	/** The superp coberturas bosques obs. */
	@Column(name = "superp_coberturas_bosques_obs") 	
	private String superpCoberturasBosquesObs;
	
	/** The superp coberturas areas humedas. */
	@Column(name = "superp_coberturas_areas_humedas") 	
	private Boolean superpCoberturasAreasHumedas;
	
	/** The superp coberturas areas humedas obs. */
	@Column(name = "superp_coberturas_areas_humedas_obs") 	
	private String superpCoberturasAreasHumedasObs;
	
	/** The superp corredores eco. */
	@Column(name = "superp_corredores_eco") 	
	private Boolean superpCorredoresEco;
	
	/** The superp corredores eco obs. */
	@Column(name = "superp_corredores_eco_obs") 	
	private String superpCorredoresEcoObs;
	
	/** The superp areas fauna. */
	@Column(name = "superp_areas_fauna") 	
	private Boolean superpAreasFauna;
	
	/** The superp areas fauna obs. */
	@Column(name = "superp_areas_fauna_obs") 	
	private String superpAreasFaunaObs;
	
    /** The puntaje ambiental total. */
    @Column(name = "puntaje_ambiental_total") 
	private BigDecimal puntajeAmbientalTotal;

	/**
	 * Obtiene id ambiental PV.
	 *
	 * @return  id ambiental PV
	 */
	public BigDecimal getIdAmbientalPV() {
		return idAmbientalPV;
	}

	/**
	 * Establece id ambiental PV.
	 *
	 * @param idAmbientalPV  id ambiental PV
	 */
	public void setIdAmbientalPV(BigDecimal idAmbientalPV) {
		this.idAmbientalPV = idAmbientalPV;
	}

	/**
	 * Obtiene superp parques nacionales.
	 *
	 * @return  superp parques nacionales
	 */
	public Boolean getSuperpParquesNacionales() {
		return superpParquesNacionales;
	}

	/**
	 * Establece superp parques nacionales.
	 *
	 * @param superpParquesNacionales  superp parques nacionales
	 */
	public void setSuperpParquesNacionales(Boolean superpParquesNacionales) {
		this.superpParquesNacionales = superpParquesNacionales;
	}

	/**
	 * Obtiene superp parques nacionales obs.
	 *
	 * @return  superp parques nacionales obs
	 */
	public String getSuperpParquesNacionalesObs() {
		return superpParquesNacionalesObs;
	}

	/**
	 * Establece superp parques nacionales obs.
	 *
	 * @param superpParquesNacionalesObs  superp parques nacionales obs
	 */
	public void setSuperpParquesNacionalesObs(String superpParquesNacionalesObs) {
		this.superpParquesNacionalesObs = superpParquesNacionalesObs;
	}

	/**
	 * Obtiene superp areas especial interes.
	 *
	 * @return  superp areas especial interes
	 */
	public Boolean getSuperpAreasEspecialInteres() {
		return superpAreasEspecialInteres;
	}

	/**
	 * Establece superp areas especial interes.
	 *
	 * @param superpAreasEspecialInteres  superp areas especial interes
	 */
	public void setSuperpAreasEspecialInteres(Boolean superpAreasEspecialInteres) {
		this.superpAreasEspecialInteres = superpAreasEspecialInteres;
	}

	/**
	 * Obtiene superp areas especial interes obs.
	 *
	 * @return  superp areas especial interes obs
	 */
	public String getSuperpAreasEspecialInteresObs() {
		return superpAreasEspecialInteresObs;
	}

	/**
	 * Establece superp areas especial interes obs.
	 *
	 * @param superpAreasEspecialInteresObs  superp areas especial interes obs
	 */
	public void setSuperpAreasEspecialInteresObs(String superpAreasEspecialInteresObs) {
		this.superpAreasEspecialInteresObs = superpAreasEspecialInteresObs;
	}

	/**
	 * Obtiene superp coberturas bosques.
	 *
	 * @return  superp coberturas bosques
	 */
	public Boolean getSuperpCoberturasBosques() {
		return superpCoberturasBosques;
	}

	/**
	 * Establece superp coberturas bosques.
	 *
	 * @param superpCoberturasBosques  superp coberturas bosques
	 */
	public void setSuperpCoberturasBosques(Boolean superpCoberturasBosques) {
		this.superpCoberturasBosques = superpCoberturasBosques;
	}

	/**
	 * Obtiene superp coberturas bosques obs.
	 *
	 * @return  superp coberturas bosques obs
	 */
	public String getSuperpCoberturasBosquesObs() {
		return superpCoberturasBosquesObs;
	}

	/**
	 * Establece superp coberturas bosques obs.
	 *
	 * @param superpCoberturasBosquesObs  superp coberturas bosques obs
	 */
	public void setSuperpCoberturasBosquesObs(String superpCoberturasBosquesObs) {
		this.superpCoberturasBosquesObs = superpCoberturasBosquesObs;
	}

	/**
	 * Obtiene superp coberturas areas humedas.
	 *
	 * @return  superp coberturas areas humedas
	 */
	public Boolean getSuperpCoberturasAreasHumedas() {
		return superpCoberturasAreasHumedas;
	}

	/**
	 * Establece superp coberturas areas humedas.
	 *
	 * @param superpCoberturasAreasHumedas  superp coberturas areas humedas
	 */
	public void setSuperpCoberturasAreasHumedas(Boolean superpCoberturasAreasHumedas) {
		this.superpCoberturasAreasHumedas = superpCoberturasAreasHumedas;
	}

	/**
	 * Obtiene superp coberturas areas humedas obs.
	 *
	 * @return  superp coberturas areas humedas obs
	 */
	public String getSuperpCoberturasAreasHumedasObs() {
		return superpCoberturasAreasHumedasObs;
	}

	/**
	 * Establece superp coberturas areas humedas obs.
	 *
	 * @param superpCoberturasAreasHumedasObs  superp coberturas areas humedas obs
	 */
	public void setSuperpCoberturasAreasHumedasObs(String superpCoberturasAreasHumedasObs) {
		this.superpCoberturasAreasHumedasObs = superpCoberturasAreasHumedasObs;
	}

	/**
	 * Obtiene superp corredores eco.
	 *
	 * @return  superp corredores eco
	 */
	public Boolean getSuperpCorredoresEco() {
		return superpCorredoresEco;
	}

	/**
	 * Establece superp corredores eco.
	 *
	 * @param superpCorredoresEco  superp corredores eco
	 */
	public void setSuperpCorredoresEco(Boolean superpCorredoresEco) {
		this.superpCorredoresEco = superpCorredoresEco;
	}

	/**
	 * Obtiene superp corredores eco obs.
	 *
	 * @return  superp corredores eco obs
	 */
	public String getSuperpCorredoresEcoObs() {
		return superpCorredoresEcoObs;
	}

	/**
	 * Establece superp corredores eco obs.
	 *
	 * @param superpCorredoresEcoObs  superp corredores eco obs
	 */
	public void setSuperpCorredoresEcoObs(String superpCorredoresEcoObs) {
		this.superpCorredoresEcoObs = superpCorredoresEcoObs;
	}

	/**
	 * Obtiene superp areas fauna.
	 *
	 * @return  superp areas fauna
	 */
	public Boolean getSuperpAreasFauna() {
		return superpAreasFauna;
	}

	/**
	 * Establece superp areas fauna.
	 *
	 * @param superpAreasFauna  superp areas fauna
	 */
	public void setSuperpAreasFauna(Boolean superpAreasFauna) {
		this.superpAreasFauna = superpAreasFauna;
	}

	/**
	 * Obtiene superp areas fauna obs.
	 *
	 * @return  superp areas fauna obs
	 */
	public String getSuperpAreasFaunaObs() {
		return superpAreasFaunaObs;
	}

	/**
	 * Establece superp areas fauna obs.
	 *
	 * @param superpAreasFaunaObs  superp areas fauna obs
	 */
	public void setSuperpAreasFaunaObs(String superpAreasFaunaObs) {
		this.superpAreasFaunaObs = superpAreasFaunaObs;
	}

	/**
	 * Obtiene puntaje ambiental total.
	 *
	 * @return  puntaje ambiental total
	 */
	public BigDecimal getPuntajeAmbientalTotal() {
		return puntajeAmbientalTotal;
	}

	/**
	 * Establece puntaje ambiental total.
	 *
	 * @param puntajeAmbientalTotal  puntaje ambiental total
	 */
	public void setPuntajeAmbientalTotal(BigDecimal puntajeAmbientalTotal) {
		this.puntajeAmbientalTotal = puntajeAmbientalTotal;
	}
}