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
 * Clase ProductoCuartiles.
 */
@Entity
@Table(name = "producto_cuartiles")
public class ProductoCuartiles implements java.io.Serializable {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**  id producto cuartiles. */
	@Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_producto_cuartiles") 
	private BigDecimal idProductoCuartiles;
	
	/**  producto. */
	@Column(name = "producto")
	private String producto;
	
	/**  cuartil 1. */
	@Column(name = "cuartil_1")
	private Double cuartil1;
	
	/**  cuartil 2. */
	@Column(name = "cuartil_2")
	private Double cuartil2;
	
	/**  cuartil 3. */
	@Column(name = "cuartil_3")
	private Double cuartil3;
	
	/**  cuartil 4. */
	@Column(name = "cuartil_4")
	private Double cuartil4;

	/**
	 * Instancia una nueva producto cuartiles.
	 */
	public ProductoCuartiles() {
	}

	/**
	 * Obtiene id producto cuartiles.
	 *
	 * @return  id producto cuartiles
	 */
	public BigDecimal getIdProductoCuartiles() {
		return idProductoCuartiles;
	}

	/**
	 * Establece id producto cuartiles.
	 *
	 * @param idProductoCuartiles  id producto cuartiles
	 */
	public void setIdProductoCuartiles(BigDecimal idProductoCuartiles) {
		this.idProductoCuartiles = idProductoCuartiles;
	}

	/**
	 * Obtiene producto.
	 *
	 * @return  producto
	 */
	public String getProducto() {
		return producto;
	}


	/**
	 * Establece producto.
	 *
	 * @param producto  producto
	 */
	public void setProducto(String producto) {
		this.producto = producto;
	}


	/**
	 * Obtiene cuartil 1.
	 *
	 * @return  cuartil 1
	 */
	public Double getCuartil1() {
		return cuartil1;
	}


	/**
	 * Establece cuartil 1.
	 *
	 * @param cuartil1  cuartil 1
	 */
	public void setCuartil1(Double cuartil1) {
		this.cuartil1 = cuartil1;
	}


	/**
	 * Obtiene cuartil 2.
	 *
	 * @return  cuartil 2
	 */
	public Double getCuartil2() {
		return cuartil2;
	}


	/**
	 * Establece cuartil 2.
	 *
	 * @param cuartil2  cuartil 2
	 */
	public void setCuartil2(Double cuartil2) {
		this.cuartil2 = cuartil2;
	}


	/**
	 * Obtiene cuartil 3.
	 *
	 * @return  cuartil 3
	 */
	public Double getCuartil3() {
		return cuartil3;
	}


	/**
	 * Establece cuartil 3.
	 *
	 * @param cuartil3  cuartil 3
	 */
	public void setCuartil3(Double cuartil3) {
		this.cuartil3 = cuartil3;
	}


	/**
	 * Obtiene cuartil 4.
	 *
	 * @return  cuartil 4
	 */
	public Double getCuartil4() {
		return cuartil4;
	}


	/**
	 * Establece cuartil 4.
	 *
	 * @param cuartil4  cuartil 4
	 */
	public void setCuartil4(Double cuartil4) {
		this.cuartil4 = cuartil4;
	}
}