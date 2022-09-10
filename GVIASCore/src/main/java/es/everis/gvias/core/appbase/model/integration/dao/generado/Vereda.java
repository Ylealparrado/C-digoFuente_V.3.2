package es.everis.gvias.core.appbase.model.integration.dao.generado;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * Clase Vereda.
 */
@Entity
@Table(name = "vereda")
public class Vereda implements java.io.Serializable {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**  id vereda. */
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vereda") 
	private BigDecimal idVereda;

	/**  nombre. */
	@Column(name = "nombre")
	private String nombre;
	
	/**  cod vereda. */
	@Column(name = "cod_vereda")
	private String codVereda;
	
    /**  poblacion. */
    @Column(name = "poblacion") 
	private BigDecimal poblacion;
    
	/**  municipio. */
	@ManyToOne 
	@JoinColumn(name="id_municipio")
	private Municipio municipio; 

    /**  vias. */
    @ManyToMany(mappedBy = "veredas")
    private Set<Via> vias = new HashSet<Via>();
	

	/**
	 * Instancia una nueva vereda.
	 */
	public Vereda() {
	}
	
	
	/**
	 * Obtiene id vereda.
	 *
	 * @return  id vereda
	 */
	public BigDecimal getIdVereda() {
		return idVereda;
	}


	/**
	 * Establece id vereda.
	 *
	 * @param idVereda  id vereda
	 */
	public void setIdVereda(BigDecimal idVereda) {
		this.idVereda = idVereda;
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
	 * Obtiene poblacion.
	 *
	 * @return  poblacion
	 */
	public BigDecimal getPoblacion() {
		return poblacion;
	}

	/**
	 * Establece poblacion.
	 *
	 * @param poblacion  poblacion
	 */
	public void setPoblacion(BigDecimal poblacion) {
		this.poblacion = poblacion;
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
	 * Obtiene vias.
	 *
	 * @return  vias
	 */
	public Set<Via> getVias() {
		return vias;
	}

	/**
	 * Establece vias.
	 *
	 * @param vias  vias
	 */
	public void setVias(Set<Via> vias) {
		this.vias = vias;
	}
	
	/**
	 * Obtiene cod vereda.
	 *
	 * @return  cod vereda
	 */
	public String getCodVereda() {
		return codVereda;
	}


	/**
	 * Establece cod vereda.
	 *
	 * @param codVereda  cod vereda
	 */
	public void setCodVereda(String codVereda) {
		this.codVereda = codVereda;
	}


	/**
	 * To string.
	 *
	 * @return string
	 */
	@Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (idVereda != null) {
            builder.append(idVereda);
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
	        result = prime * result + ((idVereda == null) ? 0 : idVereda.hashCode());
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
	        if (!(obj instanceof Vereda)) {
	            return false;
	        }
	        Vereda other = (Vereda) obj;
	        if (nombre == null) {
	            if (other.nombre != null) {
	                return false;
	            }
	        } else if (!nombre.equals(other.nombre)) {
	            return false;
	        }
	        if (idVereda == null) {
	            if (other.idVereda != null) {
	                return false;
	            }
	        } else if (!idVereda.equals(other.idVereda)) {
	            return false;
	        }
	        return true;
	    }
	

}