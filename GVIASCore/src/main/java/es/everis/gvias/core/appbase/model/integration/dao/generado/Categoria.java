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
 * Clase Categoria.
 */
@Entity
@Table(name = "categoria")
public class Categoria implements java.io.Serializable {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**  id categoria. */
	@Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_categoria") 
	private BigDecimal idCategoria;
	
	/**  nombre. */
	@Column(name = "nombre")
	private String nombre;

	/**
	 * Instancia una nueva categoria.
	 */
	public Categoria() {
	}

	/**
	 * Obtiene id categoria.
	 *
	 * @return  id categoria
	 */
	public BigDecimal getIdCategoria() {
		return idCategoria;
	}

	/**
	 * Establece id categoria.
	 *
	 * @param idCategoria  id categoria
	 */
	public void setIdCategoria(BigDecimal idCategoria) {
		this.idCategoria = idCategoria;
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
}