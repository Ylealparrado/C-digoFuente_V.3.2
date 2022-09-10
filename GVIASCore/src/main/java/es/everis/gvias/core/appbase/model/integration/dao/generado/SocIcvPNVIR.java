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
 * Clase SocIcvPNVIR.
 */
@Entity
@Table(name = "soc_icv_pnvir")
public class SocIcvPNVIR implements java.io.Serializable {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/**  id soc icv PNVIR. */
	@Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_soc_icv_pnvir") 
	private BigDecimal idSocIcvPNVIR;
	
	/**  descripcion. */
	@Column(name = "descripcion")
	private String descripcion;
	
	/**  puntaje. */
	@Column(name = "puntaje")
	private BigDecimal puntaje;

	/**
	 * Obtiene id soc icv PNVIR.
	 *
	 * @return  id soc icv PNVIR
	 */
	public BigDecimal getIdSocIcvPNVIR() {
		return idSocIcvPNVIR;
	}

	/**
	 * Establece id soc icv PNVIR.
	 *
	 * @param idSocIcvPNVIR  id soc icv PNVIR
	 */
	public void setIdSocIcvPNVIR(BigDecimal idSocIcvPNVIR) {
		this.idSocIcvPNVIR = idSocIcvPNVIR;
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