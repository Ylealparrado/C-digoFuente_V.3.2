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
 * Clase ProductividadPV.
 */
@Entity
@Table(name = "productividad_pv")
public class ProductividadPV implements java.io.Serializable {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/**  id productividad PV. */
	@Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_productividad_pv") 
	private BigDecimal idProductividadPV;
	
	/**  otro permanente. */
	@Column(name = "otro_permanente") 	
	private String otroPermanente;
	
	/**  producto rendimiento. */
	@ManyToOne 
	@JoinColumn(name="id_producto_rendimiento")
	private ProductoRendimiento productoRendimiento;
	
	/**  eco rendimiento PNVIR. */
	@ManyToOne 
	@JoinColumn(name="id_eco_rendimiento_pnvir")
	private EcoRendimientoPNVIR ecoRendimientoPNVIR;

	/**
	 * Obtiene id productividad PV.
	 *
	 * @return  id productividad PV
	 */
	public BigDecimal getIdProductividadPV() {
		return idProductividadPV;
	}

	/**
	 * Establece id productividad PV.
	 *
	 * @param idProductividadPV  id productividad PV
	 */
	public void setIdProductividadPV(BigDecimal idProductividadPV) {
		this.idProductividadPV = idProductividadPV;
	}

	/**
	 * Obtiene otro permanente.
	 *
	 * @return  otro permanente
	 */
	public String getOtroPermanente() {
		return otroPermanente;
	}

	/**
	 * Establece otro permanente.
	 *
	 * @param otroPermanente  otro permanente
	 */
	public void setOtroPermanente(String otroPermanente) {
		this.otroPermanente = otroPermanente;
	}

	/**
	 * Obtiene producto rendimiento.
	 *
	 * @return  producto rendimiento
	 */
	public ProductoRendimiento getProductoRendimiento() {
		return productoRendimiento;
	}

	/**
	 * Establece producto rendimiento.
	 *
	 * @param productoRendimiento  producto rendimiento
	 */
	public void setProductoRendimiento(ProductoRendimiento productoRendimiento) {
		this.productoRendimiento = productoRendimiento;
	}

	/**
	 * Obtiene eco rendimiento PNVIR.
	 *
	 * @return  eco rendimiento PNVIR
	 */
	public EcoRendimientoPNVIR getEcoRendimientoPNVIR() {
		return ecoRendimientoPNVIR;
	}

	/**
	 * Establece eco rendimiento PNVIR.
	 *
	 * @param ecoRendimientoPNVIR  eco rendimiento PNVIR
	 */
	public void setEcoRendimientoPNVIR(EcoRendimientoPNVIR ecoRendimientoPNVIR) {
		this.ecoRendimientoPNVIR = ecoRendimientoPNVIR;
	}
}