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
 * Clase VSedeEducativaVereda.
 */
@Entity
@Immutable
@Table(name = "v_sede_educativa_vereda")
public class VSedeEducativaVereda implements java.io.Serializable {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**  id. */
	@Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id") 
	private BigDecimal id;
	
	/**  nombre sede. */
	@Column(name = "nombre_sede")
	private String nombreSede;
	
	/**  codigo vereda. */
	@Column(name = "codigo_ver")
	private String codigoVereda;

	/**
	 * Instancia una nueva v sede educativa vereda.
	 */
	public VSedeEducativaVereda() {
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
	 * Obtiene nombre sede.
	 *
	 * @return  nombre sede
	 */
	public String getNombreSede() {
		return nombreSede;
	}

	/**
	 * Establece nombre sede.
	 *
	 * @param nombreSede  nombre sede
	 */
	public void setNombreSede(String nombreSede) {
		this.nombreSede = nombreSede;
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