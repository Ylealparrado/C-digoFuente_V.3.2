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
 * Clase Departamento.
 */
@Entity
@Table(name = "departamento")
public class Departamento implements java.io.Serializable {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**  id departamento. */
	@Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_departamento") 
	private BigDecimal idDepartamento;
	
	/**  cod departamento. */
	@Column(name = "cod_departamento")
	private String codDepartamento;
	
	/**  nombre. */
	@Column(name = "nombre")
	private String nombre;

	/**
	 * Instancia una nueva departamento.
	 */
	public Departamento() {
	}

	/**
	 * Obtiene id departamento.
	 *
	 * @return  id departamento
	 */
	public BigDecimal getIdDepartamento() {
		return idDepartamento;
	}

	/**
	 * Establece id departamento.
	 *
	 * @param idDepartamento  id departamento
	 */
	public void setIdDepartamento(BigDecimal idDepartamento) {
		this.idDepartamento = idDepartamento;
	}

	/**
	 * Obtiene cod departamento.
	 *
	 * @return  cod departamento
	 */
	public String getCodDepartamento() {
		return codDepartamento;
	}

	/**
	 * Establece cod departamento.
	 *
	 * @param codDepartamento  cod departamento
	 */
	public void setCodDepartamento(String codDepartamento) {
		this.codDepartamento = codDepartamento;
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
        if (idDepartamento != null) {
            builder.append(idDepartamento);
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
        result = prime * result + ((idDepartamento == null) ? 0 : idDepartamento.hashCode());
        return result;
    }

    /**
     * 
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
        if (!(obj instanceof Departamento)) {
            return false;
        }
        Departamento other = (Departamento) obj;
        if (nombre == null) {
            if (other.nombre != null) {
                return false;
            }
        } else if (!nombre.equals(other.nombre)) {
            return false;
        }
        if (idDepartamento == null) {
            if (other.idDepartamento != null) {
                return false;
            }
        } else if (!idDepartamento.equals(other.idDepartamento)) {
            return false;
        }
        return true;
    }

}