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
 * Clase Municipio.
 */
@Entity
@Table(name = "municipio")
public class Municipio implements java.io.Serializable {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**  id municipio. */
	@Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_municipio") 
	private BigDecimal idMunicipio;
	
	/**  cod municipio. */
	@Column(name = "cod_municipio")
	private String codMunicipio;
	
	/**  nombre. */
	@Column(name = "nombre")
	private String nombre;
	
	/**  icv. */
	@Column(name = "icv")
	private Double icv;
	
	/**  departamento. */
	@ManyToOne 
	@JoinColumn(name="id_departamento")
	private Departamento departamento; 
	

	/**
	 * Instancia una nueva municipio.
	 */
	public Municipio() {
	}


	/**
	 * Obtiene id municipio.
	 *
	 * @return  id municipio
	 */
	public BigDecimal getIdMunicipio() {
		return idMunicipio;
	}


	/**
	 * Establece id municipio.
	 *
	 * @param idMunicipio  id municipio
	 */
	public void setIdMunicipio(BigDecimal idMunicipio) {
		this.idMunicipio = idMunicipio;
	}


	/**
	 * Obtiene cod municipio.
	 *
	 * @return  cod municipio
	 */
	public String getCodMunicipio() {
		return codMunicipio;
	}


	/**
	 * Establece cod municipio.
	 *
	 * @param codMunicipio  cod municipio
	 */
	public void setCodMunicipio(String codMunicipio) {
		this.codMunicipio = codMunicipio;
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
	 * Obtiene departamento.
	 *
	 * @return  departamento
	 */
	public Departamento getDepartamento() {
		return departamento;
	}


	/**
	 * Establece departamento.
	 *
	 * @param departamento  departamento
	 */
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
	/**
	 * Obtiene icv.
	 *
	 * @return  icv
	 */
	public Double getIcv() {
		return icv;
	}


	/**
	 * Establece icv.
	 *
	 * @param icv  icv
	 */
	public void setIcv(Double icv) {
		this.icv = icv;
	}


	/**
	 * To string.
	 *
	 * @return string
	 */
	@Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (idMunicipio != null) {
            builder.append(idMunicipio);
        } else {
            builder.append("-1");
        }

        builder.append("#");

        if (nombre != null) {
            builder.append(nombre);
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
	        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
	        result = prime * result + ((idMunicipio == null) ? 0 : idMunicipio.hashCode());
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
	        if (!(obj instanceof Municipio)) {
	            return false;
	        }
	        Municipio other = (Municipio) obj;
	        if (nombre == null) {
	            if (other.nombre != null) {
	                return false;
	            }
	        } else if (!nombre.equals(other.nombre)) {
	            return false;
	        }
	        if (idMunicipio == null) {
	            if (other.idMunicipio != null) {
	                return false;
	            }
	        } else if (!idMunicipio.equals(other.idMunicipio)) {
	            return false;
	        }
	        return true;
	    }
	

}