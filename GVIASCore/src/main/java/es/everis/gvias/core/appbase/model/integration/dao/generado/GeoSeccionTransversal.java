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
 * Clase GeoSeccionTransversal.
 */
@Entity
@Table(name = "geo_inv_secciontransversal")
public class GeoSeccionTransversal implements java.io.Serializable {

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
	
	/**  longitud. */
	@Column(name = "longitud")
	private Double longitud;
	
	/**  ancho. */
	@Column(name = "anchocal")
	private Double ancho;
	
	/**  tipo superficie. */
	@Column(name = "tiposupcal")
	private Integer tipoSuperficie;

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
	 * Obtiene longitud.
	 *
	 * @return  longitud
	 */
	public Double getLongitud() {
		return longitud;
	}

	/**
	 * Establece longitud.
	 *
	 * @param longitud  longitud
	 */
	public void setLongitud(Double longitud) {
		this.longitud = longitud;
	}

	/**
	 * Obtiene ancho.
	 *
	 * @return  ancho
	 */
	public Double getAncho() {
		return ancho;
	}

	/**
	 * Establece ancho.
	 *
	 * @param ancho  ancho
	 */
	public void setAncho(Double ancho) {
		this.ancho = ancho;
	}

	/**
	 * Obtiene tipo superficie.
	 *
	 * @return  tipo superficie
	 */
	public Integer getTipoSuperficie() {
		return tipoSuperficie;
	}

	/**
	 * Establece tipo superficie.
	 *
	 * @param tipoSuperficie  tipo superficie
	 */
	public void setTipoSuperficie(Integer tipoSuperficie) {
		this.tipoSuperficie = tipoSuperficie;
	}
}