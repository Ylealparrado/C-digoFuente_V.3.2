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
 * Clase Competencia.
 */
@Entity
@Table(name = "competencia")
public class Competencia implements java.io.Serializable {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**  id competencia. */
	@Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_competencia") 
	private BigDecimal idCompetencia;
	
	/**  nombre. */
	@Column(name = "nombre")
	private String nombre;

	/**
	 * Instancia una nueva competencia.
	 */
	public Competencia() {
	}

	/**
	 * Obtiene id competencia.
	 *
	 * @return  id competencia
	 */
	public BigDecimal getIdCompetencia() {
		return idCompetencia;
	}

	/**
	 * Establece id competencia.
	 *
	 * @param idCompetencia  id competencia
	 */
	public void setIdCompetencia(BigDecimal idCompetencia) {
		this.idCompetencia = idCompetencia;
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
	 * To string.
	 *
	 * @return string
	 */
	@Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (idCompetencia != null) {
            builder.append(idCompetencia);
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
        result = prime * result + ((idCompetencia == null) ? 0 : idCompetencia.hashCode());
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
        if (!(obj instanceof Competencia)) {
            return false;
        }
        Competencia other = (Competencia) obj;
        if (nombre == null) {
            if (other.nombre != null) {
                return false;
            }
        } else if (!nombre.equals(other.nombre)) {
            return false;
        }
        if (idCompetencia == null) {
            if (other.idCompetencia != null) {
                return false;
            }
        } else if (!idCompetencia.equals(other.idCompetencia)) {
            return false;
        }
        return true;
    }

}