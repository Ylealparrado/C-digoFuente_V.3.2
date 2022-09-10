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
 * Clase TecConectividadModalPNVIR.
 */
@Entity
@Table(name = "tec_conectividad_modal_pnvir")
public class TecConectividadModalPNVIR implements java.io.Serializable {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/**  id tec conectividad modal PNVIR. */
	@Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_tec_conectividad_modal_pnvir") 
	private BigDecimal idTecConectividadModalPNVIR;
	
	/**  descripcion. */
	@Column(name = "descripcion")
	private String descripcion;
	
	/**  puntaje. */
	@Column(name = "puntaje")
	private BigDecimal puntaje;

	/**
	 * Obtiene id tec conectividad modal PNVIR.
	 *
	 * @return  id tec conectividad modal PNVIR
	 */
	public BigDecimal getIdTecConectividadModalPNVIR() {
		return idTecConectividadModalPNVIR;
	}

	/**
	 * Establece id tec conectividad modal PNVIR.
	 *
	 * @param idTecConectividadModalPNVIR  id tec conectividad modal PNVIR
	 */
	public void setIdTecConectividadModalPNVIR(BigDecimal idTecConectividadModalPNVIR) {
		this.idTecConectividadModalPNVIR = idTecConectividadModalPNVIR;
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