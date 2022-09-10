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
 * Clase SocCentrosSocialesPNVIR.
 */
@Entity
@Table(name = "soc_centros_sociales_pnvir")
public class SocCentrosSocialesPNVIR implements java.io.Serializable {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/**  id soc centros sociales PNVIR. */
	@Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_soc_centros_sociales_pnvir") 
	private BigDecimal idSocCentrosSocialesPNVIR;
	
	/**  descripcion. */
	@Column(name = "descripcion")
	private String descripcion;
	
	/**  puntaje. */
	@Column(name = "puntaje")
	private BigDecimal puntaje;

	/**
	 * Obtiene id soc centros sociales PNVIR.
	 *
	 * @return  id soc centros sociales PNVIR
	 */
	public BigDecimal getIdSocCentrosSocialesPNVIR() {
		return idSocCentrosSocialesPNVIR;
	}

	/**
	 * Establece id soc centros sociales PNVIR.
	 *
	 * @param idSocCentrosSocialesPNVIR  id soc centros sociales PNVIR
	 */
	public void setIdSocCentrosSocialesPNVIR(BigDecimal idSocCentrosSocialesPNVIR) {
		this.idSocCentrosSocialesPNVIR = idSocCentrosSocialesPNVIR;
	}

	/**
	 * Obtiene descripcion.
	 *
	 * @return  descripcion
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Establece descripcion.
	 *
	 * @param descripcion  descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	/**
	 * Obtiene puntaje.
	 *
	 * @return  puntaje
	 */
	public BigDecimal getPuntaje() {
		return puntaje;
	}

	/**
	 * Establece puntaje.
	 *
	 * @param puntaje  puntaje
	 */
	public void setPuntaje(BigDecimal puntaje) {
		this.puntaje = puntaje;
	}
}