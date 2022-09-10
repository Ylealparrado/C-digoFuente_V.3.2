package es.everis.gvias.core.appbase.model.integration.dao.generado;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * Clase GeoTramoVia.
 */
@Entity
@Table(name = "geo_inv_tramovia")
public class GeoTramoVia implements java.io.Serializable {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**  id. */
	@Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
	private BigDecimal id;
	
	/**  cod via. */
	@Column(name = "codigovia")
	private String codVia;
	
	/**  nombre. */
	@Column(name = "nombre")
	private String nombre;
	
	/**  cod municipio. */
	@Column(name = "municipio")
	private BigDecimal codMunicipio;

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
	 * Obtiene cod via.
	 *
	 * @return  cod via
	 */
	public String getCodVia() {
		return codVia;
	}

	/**
	 * Establece cod via.
	 *
	 * @param codVia  cod via
	 */
	public void setCodVia(String codVia) {
		this.codVia = codVia;
	}

	/**
	 * Obtiene nombre.
	 *
	 * @return  nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Establece nombre.
	 *
	 * @param nombre  nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Obtiene cod municipio.
	 *
	 * @return  cod municipio
	 */
	public BigDecimal getCodMunicipio() {
		return codMunicipio;
	}

	/**
	 * Establece cod municipio.
	 *
	 * @param codMunicipio  cod municipio
	 */
	public void setCodMunicipio(BigDecimal codMunicipio) {
		this.codMunicipio = codMunicipio;
	}
}