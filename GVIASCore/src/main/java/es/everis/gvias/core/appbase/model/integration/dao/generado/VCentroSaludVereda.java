package es.everis.gvias.core.appbase.model.integration.dao.generado;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

// TODO: Auto-generated Javadoc
/**
 * Clase VCentroSaludVereda.
 */
@Entity
@Immutable
@Table(name = "v_centro_salud_vereda")
public class VCentroSaludVereda implements java.io.Serializable {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**  id. */
	@Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id") 
	private BigDecimal id;
	
	/**  nombre centro. */
	@Column(name = "nombre_centro")
	private String nombreCentro;
	
	/**  codigo vereda. */
	@Column(name = "codigo_ver")
	private String codigoVereda;

	/**
	 * Instancia una nueva v centro salud vereda.
	 */
	public VCentroSaludVereda() {
	}

	/**
	 * Obtiene id.
	 *
	 * @return  id
	 */
	public BigDecimal getId() {
		return id;
	}

	/**
	 * Establece id.
	 *
	 * @param id  id
	 */
	public void setId(BigDecimal id) {
		this.id = id;
	}

	/**
	 * Obtiene nombre centro.
	 *
	 * @return  nombre centro
	 */
	public String getNombreCentro() {
		return nombreCentro;
	}

	/**
	 * Establece nombre centro.
	 *
	 * @param nombreCentro  nombre centro
	 */
	public void setNombreCentro(String nombreCentro) {
		this.nombreCentro = nombreCentro;
	}

	/**
	 * Obtiene codigo vereda.
	 *
	 * @return  codigo vereda
	 */
	public String getCodigoVereda() {
		return codigoVereda;
	}

	/**
	 * Establece codigo vereda.
	 *
	 * @param codigoVereda  codigo vereda
	 */
	public void setCodigoVereda(String codigoVereda) {
		this.codigoVereda = codigoVereda;
	}
}