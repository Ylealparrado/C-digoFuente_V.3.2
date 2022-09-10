package es.everis.gvias.core.appbase.model.integration.dao.generado;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * Clase ActividadModeloTeorico.
 */
@Entity
@Table(name = "actividad_modelo_teorico")
public class ActividadModeloTeorico implements java.io.Serializable {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/**  id actividad modelo teorico. */
	@Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_actividad_modelo_teorico") 
	private BigDecimal idActividadModeloTeorico;
	
	/**  fecha. */
	@Column(name = "fecha") 	
	private Date fecha;
	
	/**  tipo. */
	@Column(name = "tipo") 	
	private String tipo;

	/**  actividad. */
	@Column(name = "actividad") 	
	private String actividad;
	
	/**  situacion. */
	@Column(name = "situacion") 	
	private String situacion;
	
	/**  situacion hasta. */
	@Column(name = "situacion_hasta") 	
	private String situacionHasta;
	
	/**  longitud. */
	@Column(name = "longitud") 	
	private Double longitud;
	
	/**  latitud. */
	@Column(name = "latitud") 	
	private Double latitud;
	
	/**  costo. */
	@Column(name = "costo") 	
	private Double costo;
	
	/**  comentario. */
	@Column(name = "comentario") 	
	private String comentario;
	
	/**  via. */
	@ManyToOne 
	@JoinColumn(name="id_via")
	private Via via;

	/**
	 * Obtiene id actividad modelo teorico.
	 *
	 * @return  id actividad modelo teorico
	 */
	public BigDecimal getIdActividadModeloTeorico() {
		return idActividadModeloTeorico;
	}

	/**
	 * Establece id actividad modelo teorico.
	 *
	 * @param idActividadModeloTeorico  id actividad modelo teorico
	 */
	public void setIdActividadModeloTeorico(BigDecimal idActividadModeloTeorico) {
		this.idActividadModeloTeorico = idActividadModeloTeorico;
	}

	/**
	 * Obtiene fecha.
	 *
	 * @return  fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * Establece fecha.
	 *
	 * @param fecha  fecha
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * Obtiene tipo.
	 *
	 * @return  tipo
	 */
	public String getTipo() {
		return tipo;
	}

	/**
	 * Establece tipo.
	 *
	 * @param tipo  tipo
	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
	 * Obtiene actividad.
	 *
	 * @return  actividad
	 */
	public String getActividad() {
		return actividad;
	}

	/**
	 * Establece actividad.
	 *
	 * @param actividad  actividad
	 */
	public void setActividad(String actividad) {
		this.actividad = actividad;
	}

	/**
	 * Obtiene situacion.
	 *
	 * @return  situacion
	 */
	public String getSituacion() {
		return situacion;
	}

	/**
	 * Establece situacion.
	 *
	 * @param situacion  situacion
	 */
	public void setSituacion(String situacion) {
		this.situacion = situacion;
	}

	/**
	 * Obtiene costo.
	 *
	 * @return  costo
	 */
	public Double getCosto() {
		return costo;
	}

	/**
	 * Establece costo.
	 *
	 * @param costo  costo
	 */
	public void setCosto(Double costo) {
		this.costo = costo;
	}

	/**
	 * Obtiene comentario.
	 *
	 * @return  comentario
	 */
	public String getComentario() {
		return comentario;
	}

	/**
	 * Establece comentario.
	 *
	 * @param comentario  comentario
	 */
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	/**
	 * Obtiene via.
	 *
	 * @return  via
	 */
	public Via getVia() {
		return via;
	}

	/**
	 * Establece via.
	 *
	 * @param via  via
	 */
	public void setVia(Via via) {
		this.via = via;
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
	 * Obtiene latitud.
	 *
	 * @return  latitud
	 */
	public Double getLatitud() {
		return latitud;
	}

	/**
	 * Establece latitud.
	 *
	 * @param latitud  latitud
	 */
	public void setLatitud(Double latitud) {
		this.latitud = latitud;
	}

	/**
	 * Obtiene situacionHasta.
	 *
	 * @return  situacionHasta
	 */
	public String getSituacionHasta() {
		return situacionHasta;
	}

	/**
	 * Establece situacionHasta.
	 *
	 * @param latitud  situacionHasta
	 */
	public void setSituacionHasta(String situacionHasta) {
		this.situacionHasta = situacionHasta;
	}
	
	
}