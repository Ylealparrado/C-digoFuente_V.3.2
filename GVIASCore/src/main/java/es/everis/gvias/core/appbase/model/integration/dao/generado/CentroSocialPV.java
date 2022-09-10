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
 * Clase CentroSocialPV.
 */
@Entity
@Table(name = "centro_social_pv")
public class CentroSocialPV implements java.io.Serializable {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/**  id centro social PV. */
	@Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_centro_social_pv") 
	private BigDecimal idCentroSocialPV;
	
	/**  centros salud. */
	@Column(name = "centros_salud") 	
	private Boolean centrosSalud;
	
	/**  centros salud obs. */
	@Column(name = "centros_salud_obs") 	
	private String centrosSaludObs;

	/**  escuelas. */
	@Column(name = "escuelas") 	
	private Boolean escuelas;
	
	/**  escuelas obs. */
	@Column(name = "escuelas_obs") 	
	private String escuelasObs;
	
	/**  comunitarios. */
	@Column(name = "comunitarios") 	
	private Boolean comunitarios;
	
	/**  comunitarios obs. */
	@Column(name = "comunitarios_obs") 	
	private String comunitariosObs;
	
	/**  turismo. */
	@Column(name = "turismo") 	
	private Boolean turismo;
	
	/**  turismo obs. */
	@Column(name = "turismo_obs") 	
	private String turismoObs;
	
	/**  deportivo. */
	@Column(name = "deportivo") 	
	private Boolean deportivo;
	
	/**  deportivo obs. */
	@Column(name = "deportivo_obs") 	
	private String deportivoObs;
	
	/**  soc centros sociales PNVIR. */
	@ManyToOne 
	@JoinColumn(name="id_soc_centros_sociales_pnvir")
	private SocCentrosSocialesPNVIR socCentrosSocialesPNVIR;

	/**
	 * Obtiene id centro social PV.
	 *
	 * @return  id centro social PV
	 */
	public BigDecimal getIdCentroSocialPV() {
		return idCentroSocialPV;
	}

	/**
	 * Establece id centro social PV.
	 *
	 * @param idCentroSocialPV  id centro social PV
	 */
	public void setIdCentroSocialPV(BigDecimal idCentroSocialPV) {
		this.idCentroSocialPV = idCentroSocialPV;
	}

	/**
	 * Obtiene centros salud.
	 *
	 * @return  centros salud
	 */
	public Boolean getCentrosSalud() {
		return centrosSalud;
	}

	/**
	 * Establece centros salud.
	 *
	 * @param centrosSalud  centros salud
	 */
	public void setCentrosSalud(Boolean centrosSalud) {
		this.centrosSalud = centrosSalud;
	}

	/**
	 * Obtiene centros salud obs.
	 *
	 * @return  centros salud obs
	 */
	public String getCentrosSaludObs() {
		return centrosSaludObs;
	}

	/**
	 * Establece centros salud obs.
	 *
	 * @param centrosSaludObs  centros salud obs
	 */
	public void setCentrosSaludObs(String centrosSaludObs) {
		this.centrosSaludObs = centrosSaludObs;
	}

	/**
	 * Obtiene escuelas.
	 *
	 * @return  escuelas
	 */
	public Boolean getEscuelas() {
		return escuelas;
	}

	/**
	 * Establece escuelas.
	 *
	 * @param escuelas  escuelas
	 */
	public void setEscuelas(Boolean escuelas) {
		this.escuelas = escuelas;
	}

	/**
	 * Obtiene escuelas obs.
	 *
	 * @return  escuelas obs
	 */
	public String getEscuelasObs() {
		return escuelasObs;
	}

	/**
	 * Establece escuelas obs.
	 *
	 * @param escuelasObs  escuelas obs
	 */
	public void setEscuelasObs(String escuelasObs) {
		this.escuelasObs = escuelasObs;
	}

	/**
	 * Obtiene comunitarios.
	 *
	 * @return  comunitarios
	 */
	public Boolean getComunitarios() {
		return comunitarios;
	}

	/**
	 * Establece comunitarios.
	 *
	 * @param comunitarios  comunitarios
	 */
	public void setComunitarios(Boolean comunitarios) {
		this.comunitarios = comunitarios;
	}

	/**
	 * Obtiene comunitarios obs.
	 *
	 * @return  comunitarios obs
	 */
	public String getComunitariosObs() {
		return comunitariosObs;
	}

	/**
	 * Establece comunitarios obs.
	 *
	 * @param comunitariosObs  comunitarios obs
	 */
	public void setComunitariosObs(String comunitariosObs) {
		this.comunitariosObs = comunitariosObs;
	}

	/**
	 * Obtiene turismo.
	 *
	 * @return  turismo
	 */
	public Boolean getTurismo() {
		return turismo;
	}

	/**
	 * Establece turismo.
	 *
	 * @param turismo  turismo
	 */
	public void setTurismo(Boolean turismo) {
		this.turismo = turismo;
	}

	/**
	 * Obtiene turismo obs.
	 *
	 * @return  turismo obs
	 */
	public String getTurismoObs() {
		return turismoObs;
	}

	/**
	 * Establece turismo obs.
	 *
	 * @param turismoObs  turismo obs
	 */
	public void setTurismoObs(String turismoObs) {
		this.turismoObs = turismoObs;
	}

	/**
	 * Obtiene deportivo.
	 *
	 * @return  deportivo
	 */
	public Boolean getDeportivo() {
		return deportivo;
	}

	/**
	 * Establece deportivo.
	 *
	 * @param deportivo  deportivo
	 */
	public void setDeportivo(Boolean deportivo) {
		this.deportivo = deportivo;
	}

	/**
	 * Obtiene deportivo obs.
	 *
	 * @return  deportivo obs
	 */
	public String getDeportivoObs() {
		return deportivoObs;
	}

	/**
	 * Establece deportivo obs.
	 *
	 * @param deportivoObs  deportivo obs
	 */
	public void setDeportivoObs(String deportivoObs) {
		this.deportivoObs = deportivoObs;
	}

	/**
	 * Obtiene soc centros sociales PNVIR.
	 *
	 * @return  soc centros sociales PNVIR
	 */
	public SocCentrosSocialesPNVIR getSocCentrosSocialesPNVIR() {
		return socCentrosSocialesPNVIR;
	}

	/**
	 * Establece soc centros sociales PNVIR.
	 *
	 * @param socCentrosSocialesPNVIR  soc centros sociales PNVIR
	 */
	public void setSocCentrosSocialesPNVIR(SocCentrosSocialesPNVIR socCentrosSocialesPNVIR) {
		this.socCentrosSocialesPNVIR = socCentrosSocialesPNVIR;
	}
}