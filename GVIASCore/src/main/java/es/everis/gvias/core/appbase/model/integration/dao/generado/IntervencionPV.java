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
 * Clase IntervencionPV.
 */
@Entity
@Table(name = "intervencion_pv")
public class IntervencionPV implements java.io.Serializable {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/**  id intervencion PV. */
	@Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_intervencion_pv") 
	private BigDecimal idIntervencionPV;
	
	/**  descripcion. */
	@Column(name = "descripcion") 	
	private String descripcion;
	
	/**  estudios disenos. */
	@Column(name = "estudios_disenos") 	
	private Double estudiosDisenos;
	
	/**  mejoramiento. */
	@Column(name = "mejoramiento") 	
	private Double mejoramiento;
	
	/**  mantenimiento. */
	@Column(name = "mantenimiento") 	
	private Double mantenimiento;
	
	/**  estudios disenos precio. */
	@Column(name = "estudios_disenos_precio") 	
	private Double estudiosDisenosPrecio;
	
	/**  mejoramiento precio. */
	@Column(name = "mejoramiento_precio") 	
	private Double mejoramientoPrecio;
	
	/**  mantenimiento precio. */
	@Column(name = "mantenimiento_precio") 	
	private Double mantenimientoPrecio;
	
	/**  costo. */
	@Column(name = "costo") 	
	private Double costo;

	/**
	 * Obtiene id intervencion PV.
	 *
	 * @return  id intervencion PV
	 */
	public BigDecimal getIdIntervencionPV() {
		return idIntervencionPV;
	}

	/**
	 * Establece id intervencion PV.
	 *
	 * @param idIntervencionPV  id intervencion PV
	 */
	public void setIdIntervencionPV(BigDecimal idIntervencionPV) {
		this.idIntervencionPV = idIntervencionPV;
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
	 * Obtiene estudios disenos.
	 *
	 * @return  estudios disenos
	 */
	public Double getEstudiosDisenos() {
		return estudiosDisenos;
	}

	/**
	 * Establece estudios disenos.
	 *
	 * @param estudiosDisenos  estudios disenos
	 */
	public void setEstudiosDisenos(Double estudiosDisenos) {
		this.estudiosDisenos = estudiosDisenos;
	}

	/**
	 * Obtiene mejoramiento.
	 *
	 * @return  mejoramiento
	 */
	public Double getMejoramiento() {
		return mejoramiento;
	}

	/**
	 * Establece mejoramiento.
	 *
	 * @param mejoramiento  mejoramiento
	 */
	public void setMejoramiento(Double mejoramiento) {
		this.mejoramiento = mejoramiento;
	}

	/**
	 * Obtiene mantenimiento.
	 *
	 * @return  mantenimiento
	 */
	public Double getMantenimiento() {
		return mantenimiento;
	}

	/**
	 * Establece mantenimiento.
	 *
	 * @param mantenimiento  mantenimiento
	 */
	public void setMantenimiento(Double mantenimiento) {
		this.mantenimiento = mantenimiento;
	}

	/**
	 * Obtiene estudios disenos precio.
	 *
	 * @return  estudios disenos precio
	 */
	public Double getEstudiosDisenosPrecio() {
		return estudiosDisenosPrecio;
	}

	/**
	 * Establece estudios disenos precio.
	 *
	 * @param estudiosDisenosPrecio  estudios disenos precio
	 */
	public void setEstudiosDisenosPrecio(Double estudiosDisenosPrecio) {
		this.estudiosDisenosPrecio = estudiosDisenosPrecio;
	}

	/**
	 * Obtiene mejoramiento precio.
	 *
	 * @return  mejoramiento precio
	 */
	public Double getMejoramientoPrecio() {
		return mejoramientoPrecio;
	}

	/**
	 * Establece mejoramiento precio.
	 *
	 * @param mejoramientoPrecio  mejoramiento precio
	 */
	public void setMejoramientoPrecio(Double mejoramientoPrecio) {
		this.mejoramientoPrecio = mejoramientoPrecio;
	}

	/**
	 * Obtiene mantenimiento precio.
	 *
	 * @return  mantenimiento precio
	 */
	public Double getMantenimientoPrecio() {
		return mantenimientoPrecio;
	}

	/**
	 * Establece mantenimiento precio.
	 *
	 * @param mantenimientoPrecio  mantenimiento precio
	 */
	public void setMantenimientoPrecio(Double mantenimientoPrecio) {
		this.mantenimientoPrecio = mantenimientoPrecio;
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
	
}