package es.everis.gvias.core.appbase.model.integration.dao.generado;

import java.math.BigDecimal;

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
 * Clase ProductoRendimiento.
 */
@Entity
@Table(name = "producto_rendimiento")
public class ProductoRendimiento implements java.io.Serializable {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**  id producto rendimiento. */
	@Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_producto_rendimiento") 
	private BigDecimal idProductoRendimiento;
	
    /**  rendimiento. */
    @Column(name = "rendimiento") 
	private Double rendimiento;
	
	/**  municipio. */
	@ManyToOne 
	@JoinColumn(name="id_municipio")
	private Municipio municipio;
	
	/**  producto cuartiles. */
	@ManyToOne 
	@JoinColumn(name="id_producto_cuartiles")
	private ProductoCuartiles productoCuartiles;
	
	/**
	 * Instancia una nueva producto rendimiento.
	 */
	public ProductoRendimiento() {
	}

	/**
	 * Obtiene id producto rendimiento.
	 *
	 * @return  id producto rendimiento
	 */
	public BigDecimal getIdProductoRendimiento() {
		return idProductoRendimiento;
	}

	/**
	 * Establece id producto rendimiento.
	 *
	 * @param idProductoRendimiento  id producto rendimiento
	 */
	public void setIdProductoRendimiento(BigDecimal idProductoRendimiento) {
		this.idProductoRendimiento = idProductoRendimiento;
	}

	/**
	 * Obtiene rendimiento.
	 *
	 * @return  rendimiento
	 */
	public Double getRendimiento() {
		return rendimiento;
	}

	/**
	 * Establece rendimiento.
	 *
	 * @param rendimiento  rendimiento
	 */
	public void setRendimiento(Double rendimiento) {
		this.rendimiento = rendimiento;
	}

	/**
	 * Obtiene municipio.
	 *
	 * @return  municipio
	 */
	public Municipio getMunicipio() {
		return municipio;
	}

	/**
	 * Establece municipio.
	 *
	 * @param municipio  municipio
	 */
	public void setMunicipio(Municipio municipio) {
		this.municipio = municipio;
	}

	/**
	 * Obtiene producto cuartiles.
	 *
	 * @return  producto cuartiles
	 */
	public ProductoCuartiles getProductoCuartiles() {
		return productoCuartiles;
	}

	/**
	 * Establece producto cuartiles.
	 *
	 * @param productoCuartiles  producto cuartiles
	 */
	public void setProductoCuartiles(ProductoCuartiles productoCuartiles) {
		this.productoCuartiles = productoCuartiles;
	}
	
	/**
	 * To string.
	 *
	 * @return string
	 */
	@Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (idProductoRendimiento != null) {
            builder.append(idProductoRendimiento);
        } else {
            builder.append("-1");
        }

        builder.append("#");

        if (productoCuartiles.getProducto() != null) {
            builder.append(productoCuartiles.getProducto());
        }
        return builder.toString();
    }

    /**
     * Hash code.
     *
     * @return int
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((productoCuartiles.getProducto() == null) ? 0 : productoCuartiles.getProducto().hashCode());
        result = prime * result + ((idProductoRendimiento == null) ? 0 : idProductoRendimiento.hashCode());
        return result;
    }

    /**
     * Equals.
     *
     * @param obj  obj
     * @return true, si finaliza satisfactoriamente
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof ProductoRendimiento)) {
            return false;
        }
        ProductoRendimiento other = (ProductoRendimiento) obj;
        if (productoCuartiles.getProducto() == null) {
            if (other.productoCuartiles.getProducto() != null) {
                return false;
            }
        } else if (!productoCuartiles.getProducto().equals(other.productoCuartiles.getProducto())) {
            return false;
        }
        if (idProductoRendimiento == null) {
            if (other.idProductoRendimiento != null) {
                return false;
            }
        } else if (!idProductoRendimiento.equals(other.idProductoRendimiento)) {
            return false;
        }
        return true;
    }
}