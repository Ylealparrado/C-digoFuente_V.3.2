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
 * Clase SocPoblacionDiferencialPNVIR.
 */
@Entity
@Table(name = "soc_poblacion_diferencial_pnvir")
public class SocPoblacionDiferencialPNVIR implements java.io.Serializable {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/**  id soc poblacion diferencial PNVIR. */
	@Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_soc_poblacion_diferencial_pnvir") 
	private BigDecimal idSocPoblacionDiferencialPNVIR;
	
	/**  descripcion. */
	@Column(name = "descripcion")
	private String descripcion;
	
	/**  puntaje. */
	@Column(name = "puntaje")	
	private BigDecimal puntaje;

	/**
	 * Obtiene id soc poblacion diferencial PNVIR.
	 *
	 * @return  id soc poblacion diferencial PNVIR
	 */
	public BigDecimal getIdSocPoblacionDiferencialPNVIR() {
		return idSocPoblacionDiferencialPNVIR;
	}

	/**
	 * Establece id soc poblacion diferencial PNVIR.
	 *
	 * @param idSocPoblacionDiferencialPNVIR  id soc poblacion diferencial PNVIR
	 */
	public void setIdSocPoblacionDiferencialPNVIR(BigDecimal idSocPoblacionDiferencialPNVIR) {
		this.idSocPoblacionDiferencialPNVIR = idSocPoblacionDiferencialPNVIR;
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