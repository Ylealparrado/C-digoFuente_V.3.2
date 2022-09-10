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
 * Clase EcoComercializacionPNVIR.
 */
@Entity
@Table(name = "eco_comercializacion_pnvir")
public class EcoComercializacionPNVIR implements java.io.Serializable {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/**  id eco comercializacion PNVIR. */
	@Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_eco_comercializacion_pnvir") 
	private BigDecimal idEcoComercializacionPNVIR;
	
	/**  descripcion. */
	@Column(name = "descripcion")
	private String descripcion;
	
	/**  puntaje. */
	@Column(name = "puntaje")
	private BigDecimal puntaje;

	/**
	 * Obtiene id eco comercializacion PNVIR.
	 *
	 * @return  id eco comercializacion PNVIR
	 */
	public BigDecimal getIdEcoComercializacionPNVIR() {
		return idEcoComercializacionPNVIR;
	}

	/**
	 * Establece id eco comercializacion PNVIR.
	 *
	 * @param idEcoComercializacionPNVIR  id eco comercializacion PNVIR
	 */
	public void setIdEcoComercializacionPNVIR(BigDecimal idEcoComercializacionPNVIR) {
		this.idEcoComercializacionPNVIR = idEcoComercializacionPNVIR;
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