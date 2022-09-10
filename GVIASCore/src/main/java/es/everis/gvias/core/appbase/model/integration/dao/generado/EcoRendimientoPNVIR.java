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
 * Clase EcoRendimientoPNVIR.
 */
@Entity
@Table(name = "eco_rendimiento_pnvir")
public class EcoRendimientoPNVIR implements java.io.Serializable {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/**  id eco rendimiento PNVIR. */
	@Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_eco_rendimiento_pnvir") 
	private BigDecimal idEcoRendimientoPNVIR;
	
	/**  descripcion. */
	@Column(name = "descripcion")
	private String descripcion;
	
	/**  puntaje. */
	@Column(name = "puntaje")
	private BigDecimal puntaje;

	/**
	 * Obtiene id eco rendimiento PNVIR.
	 *
	 * @return  id eco rendimiento PNVIR
	 */
	public BigDecimal getIdEcoRendimientoPNVIR() {
		return idEcoRendimientoPNVIR;
	}

	/**
	 * Establece id eco rendimiento PNVIR.
	 *
	 * @param idEcoRendimientoPNVIR  id eco rendimiento PNVIR
	 */
	public void setIdEcoRendimientoPNVIR(BigDecimal idEcoRendimientoPNVIR) {
		this.idEcoRendimientoPNVIR = idEcoRendimientoPNVIR;
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