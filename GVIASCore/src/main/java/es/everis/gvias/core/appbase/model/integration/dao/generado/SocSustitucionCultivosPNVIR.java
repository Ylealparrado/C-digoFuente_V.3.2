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
 * Clase SocSustitucionCultivosPNVIR.
 */
@Entity
@Table(name = "soc_sustitucion_cultivos_pnvir")
public class SocSustitucionCultivosPNVIR implements java.io.Serializable {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/**  id soc sustitucion cultivos PNVIR. */
	@Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_soc_sustitucion_cultivos_pnvir") 
	private BigDecimal idSocSustitucionCultivosPNVIR;
	
	/**  descripcion. */
	@Column(name = "descripcion")
	private String descripcion;
	
	/**  puntaje. */
	@Column(name = "puntaje")
	private BigDecimal puntaje;

	/**
	 * Obtiene id soc sustitucion cultivos PNVIR.
	 *
	 * @return  id soc sustitucion cultivos PNVIR
	 */
	public BigDecimal getIdSocSustitucionCultivosPNVIR() {
		return idSocSustitucionCultivosPNVIR;
	}

	/**
	 * Establece id soc sustitucion cultivos PNVIR.
	 *
	 * @param idSocSustitucionCultivosPNVIR  id soc sustitucion cultivos PNVIR
	 */
	public void setIdSocSustitucionCultivosPNVIR(BigDecimal idSocSustitucionCultivosPNVIR) {
		this.idSocSustitucionCultivosPNVIR = idSocSustitucionCultivosPNVIR;
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