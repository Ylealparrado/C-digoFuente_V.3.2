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
 * Clase EcoVolumenTraficoPNVIR.
 */
@Entity
@Table(name = "eco_volumen_trafico_pnvir")
public class EcoVolumenTraficoPNVIR implements java.io.Serializable {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/**  id eco volumen trafico PNVIR. */
	@Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_eco_volumen_trafico_pnvir") 
	private BigDecimal idEcoVolumenTraficoPNVIR;
	
	/**  descripcion. */
	@Column(name = "descripcion")
	private String descripcion;
	
	/**  puntaje. */
	@Column(name = "puntaje")
	private BigDecimal puntaje;

	/**
	 * Obtiene id eco volumen trafico PNVIR.
	 *
	 * @return  id eco volumen trafico PNVIR
	 */
	public BigDecimal getIdEcoVolumenTraficoPNVIR() {
		return idEcoVolumenTraficoPNVIR;
	}

	/**
	 * Establece id eco volumen trafico PNVIR.
	 *
	 * @param idEcoVolumenTraficoPNVIR  id eco volumen trafico PNVIR
	 */
	public void setIdEcoVolumenTraficoPNVIR(BigDecimal idEcoVolumenTraficoPNVIR) {
		this.idEcoVolumenTraficoPNVIR = idEcoVolumenTraficoPNVIR;
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
	 * Obtiene puntaje.
	 *
	 * @return  puntaje
	 */
	public BigDecimal getPuntaje() {
		return puntaje;
	}

	/**
	 * Establece puntaje.
	 *
	 * @param puntaje  puntaje
	 */
	public void setPuntaje(BigDecimal puntaje) {
		this.puntaje = puntaje;
	}
	
	/**
	 * To string.
	 *
	 * @return string
	 */
	@Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (idEcoVolumenTraficoPNVIR != null) {
            builder.append(idEcoVolumenTraficoPNVIR);
        } else {
            builder.append("-1");
        }

        builder.append("#");

        if (descripcion != null) {
            builder.append(descripcion);
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
        result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
        result = prime * result + ((idEcoVolumenTraficoPNVIR == null) ? 0 : idEcoVolumenTraficoPNVIR.hashCode());
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
        if (!(obj instanceof EcoVolumenTraficoPNVIR)) {
            return false;
        }
        EcoVolumenTraficoPNVIR other = (EcoVolumenTraficoPNVIR) obj;
        if (descripcion == null) {
            if (other.descripcion != null) {
                return false;
            }
        } else if (!descripcion.equals(other.descripcion)) {
            return false;
        }
        if (idEcoVolumenTraficoPNVIR == null) {
            if (other.idEcoVolumenTraficoPNVIR != null) {
                return false;
            }
        } else if (!idEcoVolumenTraficoPNVIR.equals(other.idEcoVolumenTraficoPNVIR)) {
            return false;
        }
        return true;
    }
}