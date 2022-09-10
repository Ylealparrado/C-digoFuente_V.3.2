package es.everis.gvias.core.appbase.model.integration.dao.generado;

import java.math.BigDecimal;
import java.util.Date;

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
 * Clase Categorizacion.
 */
@Entity
@Table(name = "categorizacion")
public class Categorizacion implements java.io.Serializable {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/**  id categorizacion. */
	@Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categorizacion") 
	private BigDecimal idCategorizacion;
	
	/**  funcionario. */
	@Column(name = "funcionario")
	private String funcionario;
	
	/**  fecha. */
	@Column(name = "fecha")
	private Date fecha;
	
	/**  funcionalidad 1. */
	@Column(name = "funcionalidad_1")
	private Boolean funcionalidad1;
	
	/**  funcionalidad 1 obs. */
	@Column(name = "funcionalidad_1_obs")
	private String funcionalidad1Obs;
	
	/**  funcionalidad 2. */
	@Column(name = "funcionalidad_2")
	private Boolean funcionalidad2;
	
	/**  funcionalidad 2 obs. */
	@Column(name = "funcionalidad_2_obs")
	private String funcionalidad2Obs;
	
	/**  funcionalidad 3. */
	@Column(name = "funcionalidad_3")
	private Boolean funcionalidad3;
	
	/**  funcionalidad 3 obs. */
	@Column(name = "funcionalidad_3_obs")
	private String funcionalidad3Obs;
	
	/**  funcionalidad 4. */
	@Column(name = "funcionalidad_4")
	private Boolean funcionalidad4;
	
	/**  funcionalidad 4 obs. */
	@Column(name = "funcionalidad_4_obs")
	private String funcionalidad4Obs;
	
	/**  funcionalidad 5. */
	@Column(name = "funcionalidad_5")
	private Boolean funcionalidad5;
	
	/**  funcionalidad 5 obs. */
	@Column(name = "funcionalidad_5_obs")
	private String funcionalidad5Obs;
	
	/**  funcionalidad 6. */
	@Column(name = "funcionalidad_6")
	private Boolean funcionalidad6;
	
	/**  funcionalidad 6 obs. */
	@Column(name = "funcionalidad_6_obs")
	private String funcionalidad6Obs;
	
	/**  transito 1. */
	@Column(name = "transito_1")
	private Boolean transito1;
	
	/**  transito 1 obs. */
	@Column(name = "transito_1_obs")
	private String transito1Obs;
	
	/**  transito 2. */
	@Column(name = "transito_2")
	private Boolean transito2;
	
	/**  transito 2 obs. */
	@Column(name = "transito_2_obs")
	private String transito2Obs;
	
	/**  transito 3. */
	@Column(name = "transito_3")
	private Boolean transito3;
	
	/**  transito 3 obs. */
	@Column(name = "transito_3_obs")
	private String transito3Obs;
	
	/**  diseno 1. */
	@Column(name = "diseno_1")
	private Boolean diseno1;
	
	/**  diseno 1 obs. */
	@Column(name = "diseno_1_obs")
	private String diseno1Obs;
	
	/**  diseno 2. */
	@Column(name = "diseno_2")
	private Boolean diseno2;
	
	/**  diseno 2 obs. */
	@Column(name = "diseno_2_obs")
	private String diseno2Obs;
	
	/**  diseno 3. */
	@Column(name = "diseno_3")
	private Boolean diseno3;
	
	/**  diseno 3 obs. */
	@Column(name = "diseno_3_obs")
	private String diseno3Obs;
	
	/**  diseno 4. */
	@Column(name = "diseno_4")
	private Boolean diseno4;
	
	/**  diseno 4 obs. */
	@Column(name = "diseno_4_obs")
	private String diseno4Obs;
	
	/**  poblacion 1. */
	@Column(name = "poblacion_1")
	private Boolean poblacion1;
	
	/**  poblacion 1 obs. */
	@Column(name = "poblacion_1_obs")
	private String poblacion1Obs;
	
	/**  poblacion 2. */
	@Column(name = "poblacion_2")
	private Boolean poblacion2;
	
	/**  poblacion 2 obs. */
	@Column(name = "poblacion_2_obs")
	private String poblacion2Obs;
	
	/**  poblacion 3. */
	@Column(name = "poblacion_3")
	private Boolean poblacion3;
	
	/**  poblacion 3 obs. */
	@Column(name = "poblacion_3_obs")
	private String poblacion3Obs;
	
	/**  result funcionalidad 1 orden. */
	@Column(name = "result_funcionalidad_1_orden")
	private BigDecimal resultFuncionalidad1Orden;
	
	/**  result funcionalidad 2 orden. */
	@Column(name = "result_funcionalidad_2_orden")
	private BigDecimal resultFuncionalidad2Orden;
	
	/**  result funcionalidad 3 orden. */
	@Column(name = "result_funcionalidad_3_orden")
	private BigDecimal resultFuncionalidad3Orden;
	
	/**  result transito 1 orden. */
	@Column(name = "result_transito_1_orden")
	private BigDecimal resultTransito1Orden;

	/**  result transito 2 orden. */
	@Column(name = "result_transito_2_orden")
	private BigDecimal resultTransito2Orden;
	
	/**  result transito 3 orden. */
	@Column(name = "result_transito_3_orden")
	private BigDecimal resultTransito3Orden;
	
	/**  result diseno 1 orden. */
	@Column(name = "result_diseno_1_orden")
	private BigDecimal resultDiseno1Orden;
	
	/**  result diseno 2 orden. */
	@Column(name = "result_diseno_2_orden")
	private BigDecimal resultDiseno2Orden;
	
	/**  result diseno 3 orden. */
	@Column(name = "result_diseno_3_orden")
	private BigDecimal resultDiseno3Orden;
	
	/**  result poblacion 1 orden. */
	@Column(name = "result_poblacion_1_orden")
	private BigDecimal resultPoblacion1Orden;
	
	/**  result poblacion 2 orden. */
	@Column(name = "result_poblacion_2_orden")
	private BigDecimal resultPoblacion2Orden;
	
	/**  result poblacion 3 orden. */
	@Column(name = "result_poblacion_3_orden")
	private BigDecimal resultPoblacion3Orden;
	
	/**  total 1 orden. */
	@Column(name = "total_1_orden")
	private BigDecimal total1Orden;
	
	/**  total 2 orden. */
	@Column(name = "total_2_orden")
	private BigDecimal total2Orden;
	
	/**  total 3 orden. */
	@Column(name = "total_3_orden")
	private BigDecimal total3Orden;
	
	/**  categoria. */
	@ManyToOne 
	@JoinColumn(name="id_categoria")
	private Categoria categoria; 

	/**
	 * Obtiene id categorizacion.
	 *
	 * @return  id categorizacion
	 */
	public BigDecimal getIdCategorizacion() {
		return idCategorizacion;
	}

	/**
	 * Establece id categorizacion.
	 *
	 * @param idCategorizacion  id categorizacion
	 */
	public void setIdCategorizacion(BigDecimal idCategorizacion) {
		this.idCategorizacion = idCategorizacion;
	}

	/**
	 * Obtiene funcionario.
	 *
	 * @return  funcionario
	 */
	public String getFuncionario() {
		return funcionario;
	}

	/**
	 * Establece funcionario.
	 *
	 * @param funcionario  funcionario
	 */
	public void setFuncionario(String funcionario) {
		this.funcionario = funcionario;
	}

	/**
	 * Obtiene fecha.
	 *
	 * @return  fecha
	 */
	public Date getFecha() {
		return fecha;
	}

	/**
	 * Establece fecha.
	 *
	 * @param fecha  fecha
	 */
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	/**
	 * Obtiene funcionalidad 1.
	 *
	 * @return  funcionalidad 1
	 */
	public Boolean getFuncionalidad1() {
		return funcionalidad1;
	}

	/**
	 * Establece funcionalidad 1.
	 *
	 * @param funcionalidad1  funcionalidad 1
	 */
	public void setFuncionalidad1(Boolean funcionalidad1) {
		this.funcionalidad1 = funcionalidad1;
	}

	/**
	 * Obtiene funcionalidad 1 obs.
	 *
	 * @return  funcionalidad 1 obs
	 */
	public String getFuncionalidad1Obs() {
		return funcionalidad1Obs;
	}

	/**
	 * Establece funcionalidad 1 obs.
	 *
	 * @param funcionalidad1Obs  funcionalidad 1 obs
	 */
	public void setFuncionalidad1Obs(String funcionalidad1Obs) {
		this.funcionalidad1Obs = funcionalidad1Obs;
	}

	/**
	 * Obtiene funcionalidad 2.
	 *
	 * @return  funcionalidad 2
	 */
	public Boolean getFuncionalidad2() {
		return funcionalidad2;
	}

	/**
	 * Establece funcionalidad 2.
	 *
	 * @param funcionalidad2  funcionalidad 2
	 */
	public void setFuncionalidad2(Boolean funcionalidad2) {
		this.funcionalidad2 = funcionalidad2;
	}

	/**
	 * Obtiene funcionalidad 2 obs.
	 *
	 * @return  funcionalidad 2 obs
	 */
	public String getFuncionalidad2Obs() {
		return funcionalidad2Obs;
	}

	/**
	 * Establece funcionalidad 2 obs.
	 *
	 * @param funcionalidad2Obs  funcionalidad 2 obs
	 */
	public void setFuncionalidad2Obs(String funcionalidad2Obs) {
		this.funcionalidad2Obs = funcionalidad2Obs;
	}
	
	/**
	 * Obtiene funcionalidad 3.
	 *
	 * @return  funcionalidad 3
	 */
	public Boolean getFuncionalidad3() {
		return funcionalidad3;
	}

	/**
	 * Establece funcionalidad 3.
	 *
	 * @param funcionalidad3  funcionalidad 3
	 */
	public void setFuncionalidad3(Boolean funcionalidad3) {
		this.funcionalidad3 = funcionalidad3;
	}

	/**
	 * Obtiene funcionalidad 3 obs.
	 *
	 * @return  funcionalidad 3 obs
	 */
	public String getFuncionalidad3Obs() {
		return funcionalidad3Obs;
	}

	/**
	 * Establece funcionalidad 3 obs.
	 *
	 * @param funcionalidad3Obs  funcionalidad 3 obs
	 */
	public void setFuncionalidad3Obs(String funcionalidad3Obs) {
		this.funcionalidad3Obs = funcionalidad3Obs;
	}

	/**
	 * Obtiene funcionalidad 4.
	 *
	 * @return  funcionalidad 4
	 */
	public Boolean getFuncionalidad4() {
		return funcionalidad4;
	}

	/**
	 * Establece funcionalidad 4.
	 *
	 * @param funcionalidad4  funcionalidad 4
	 */
	public void setFuncionalidad4(Boolean funcionalidad4) {
		this.funcionalidad4 = funcionalidad4;
	}

	/**
	 * Obtiene funcionalidad 4 obs.
	 *
	 * @return  funcionalidad 4 obs
	 */
	public String getFuncionalidad4Obs() {
		return funcionalidad4Obs;
	}

	/**
	 * Establece funcionalidad 4 obs.
	 *
	 * @param funcionalidad4Obs  funcionalidad 4 obs
	 */
	public void setFuncionalidad4Obs(String funcionalidad4Obs) {
		this.funcionalidad4Obs = funcionalidad4Obs;
	}

	/**
	 * Obtiene funcionalidad 5.
	 *
	 * @return  funcionalidad 5
	 */
	public Boolean getFuncionalidad5() {
		return funcionalidad5;
	}

	/**
	 * Establece funcionalidad 5.
	 *
	 * @param funcionalidad5  funcionalidad 5
	 */
	public void setFuncionalidad5(Boolean funcionalidad5) {
		this.funcionalidad5 = funcionalidad5;
	}

	/**
	 * Obtiene funcionalidad 5 obs.
	 *
	 * @return  funcionalidad 5 obs
	 */
	public String getFuncionalidad5Obs() {
		return funcionalidad5Obs;
	}

	/**
	 * Establece funcionalidad 5 obs.
	 *
	 * @param funcionalidad5Obs  funcionalidad 5 obs
	 */
	public void setFuncionalidad5Obs(String funcionalidad5Obs) {
		this.funcionalidad5Obs = funcionalidad5Obs;
	}

	/**
	 * Obtiene funcionalidad 6.
	 *
	 * @return  funcionalidad 6
	 */
	public Boolean getFuncionalidad6() {
		return funcionalidad6;
	}

	/**
	 * Establece funcionalidad 6.
	 *
	 * @param funcionalidad6  funcionalidad 6
	 */
	public void setFuncionalidad6(Boolean funcionalidad6) {
		this.funcionalidad6 = funcionalidad6;
	}

	/**
	 * Obtiene funcionalidad 6 obs.
	 *
	 * @return  funcionalidad 6 obs
	 */
	public String getFuncionalidad6Obs() {
		return funcionalidad6Obs;
	}

	/**
	 * Establece funcionalidad 6 obs.
	 *
	 * @param funcionalidad6Obs  funcionalidad 6 obs
	 */
	public void setFuncionalidad6Obs(String funcionalidad6Obs) {
		this.funcionalidad6Obs = funcionalidad6Obs;
	}

	/**
	 * Obtiene transito 1.
	 *
	 * @return  transito 1
	 */
	public Boolean getTransito1() {
		return transito1;
	}

	/**
	 * Establece transito 1.
	 *
	 * @param transito1  transito 1
	 */
	public void setTransito1(Boolean transito1) {
		this.transito1 = transito1;
	}

	/**
	 * Obtiene transito 1 obs.
	 *
	 * @return  transito 1 obs
	 */
	public String getTransito1Obs() {
		return transito1Obs;
	}

	/**
	 * Establece transito 1 obs.
	 *
	 * @param transito1Obs  transito 1 obs
	 */
	public void setTransito1Obs(String transito1Obs) {
		this.transito1Obs = transito1Obs;
	}

	/**
	 * Obtiene transito 2.
	 *
	 * @return  transito 2
	 */
	public Boolean getTransito2() {
		return transito2;
	}

	/**
	 * Establece transito 2.
	 *
	 * @param transito2  transito 2
	 */
	public void setTransito2(Boolean transito2) {
		this.transito2 = transito2;
	}

	/**
	 * Obtiene transito 2 obs.
	 *
	 * @return  transito 2 obs
	 */
	public String getTransito2Obs() {
		return transito2Obs;
	}

	/**
	 * Establece transito 2 obs.
	 *
	 * @param transito2Obs  transito 2 obs
	 */
	public void setTransito2Obs(String transito2Obs) {
		this.transito2Obs = transito2Obs;
	}

	/**
	 * Obtiene transito 3.
	 *
	 * @return  transito 3
	 */
	public Boolean getTransito3() {
		return transito3;
	}

	/**
	 * Establece transito 3.
	 *
	 * @param transito3  transito 3
	 */
	public void setTransito3(Boolean transito3) {
		this.transito3 = transito3;
	}

	/**
	 * Obtiene transito 3 obs.
	 *
	 * @return  transito 3 obs
	 */
	public String getTransito3Obs() {
		return transito3Obs;
	}

	/**
	 * Establece transito 3 obs.
	 *
	 * @param transito3Obs  transito 3 obs
	 */
	public void setTransito3Obs(String transito3Obs) {
		this.transito3Obs = transito3Obs;
	}

	/**
	 * Obtiene diseno 1.
	 *
	 * @return  diseno 1
	 */
	public Boolean getDiseno1() {
		return diseno1;
	}

	/**
	 * Establece diseno 1.
	 *
	 * @param diseno1  diseno 1
	 */
	public void setDiseno1(Boolean diseno1) {
		this.diseno1 = diseno1;
	}

	/**
	 * Obtiene diseno 1 obs.
	 *
	 * @return  diseno 1 obs
	 */
	public String getDiseno1Obs() {
		return diseno1Obs;
	}

	/**
	 * Establece diseno 1 obs.
	 *
	 * @param diseno1Obs  diseno 1 obs
	 */
	public void setDiseno1Obs(String diseno1Obs) {
		this.diseno1Obs = diseno1Obs;
	}

	/**
	 * Obtiene diseno 2.
	 *
	 * @return  diseno 2
	 */
	public Boolean getDiseno2() {
		return diseno2;
	}

	/**
	 * Establece diseno 2.
	 *
	 * @param diseno2  diseno 2
	 */
	public void setDiseno2(Boolean diseno2) {
		this.diseno2 = diseno2;
	}

	/**
	 * Obtiene diseno 2 obs.
	 *
	 * @return  diseno 2 obs
	 */
	public String getDiseno2Obs() {
		return diseno2Obs;
	}

	/**
	 * Establece diseno 2 obs.
	 *
	 * @param diseno2Obs  diseno 2 obs
	 */
	public void setDiseno2Obs(String diseno2Obs) {
		this.diseno2Obs = diseno2Obs;
	}

	/**
	 * Obtiene diseno 3.
	 *
	 * @return  diseno 3
	 */
	public Boolean getDiseno3() {
		return diseno3;
	}

	/**
	 * Establece diseno 3.
	 *
	 * @param diseno3  diseno 3
	 */
	public void setDiseno3(Boolean diseno3) {
		this.diseno3 = diseno3;
	}

	/**
	 * Obtiene diseno 3 obs.
	 *
	 * @return  diseno 3 obs
	 */
	public String getDiseno3Obs() {
		return diseno3Obs;
	}

	/**
	 * Establece diseno 3 obs.
	 *
	 * @param diseno3Obs  diseno 3 obs
	 */
	public void setDiseno3Obs(String diseno3Obs) {
		this.diseno3Obs = diseno3Obs;
	}

	/**
	 * Obtiene diseno 4.
	 *
	 * @return  diseno 4
	 */
	public Boolean getDiseno4() {
		return diseno4;
	}

	/**
	 * Establece diseno 4.
	 *
	 * @param diseno4  diseno 4
	 */
	public void setDiseno4(Boolean diseno4) {
		this.diseno4 = diseno4;
	}

	/**
	 * Obtiene diseno 4 obs.
	 *
	 * @return  diseno 4 obs
	 */
	public String getDiseno4Obs() {
		return diseno4Obs;
	}

	/**
	 * Establece diseno 4 obs.
	 *
	 * @param diseno4Obs  diseno 4 obs
	 */
	public void setDiseno4Obs(String diseno4Obs) {
		this.diseno4Obs = diseno4Obs;
	}

	/**
	 * Obtiene poblacion 1.
	 *
	 * @return  poblacion 1
	 */
	public Boolean getPoblacion1() {
		return poblacion1;
	}

	/**
	 * Establece poblacion 1.
	 *
	 * @param poblacion1  poblacion 1
	 */
	public void setPoblacion1(Boolean poblacion1) {
		this.poblacion1 = poblacion1;
	}

	/**
	 * Obtiene poblacion 1 obs.
	 *
	 * @return  poblacion 1 obs
	 */
	public String getPoblacion1Obs() {
		return poblacion1Obs;
	}

	/**
	 * Establece poblacion 1 obs.
	 *
	 * @param poblacion1Obs  poblacion 1 obs
	 */
	public void setPoblacion1Obs(String poblacion1Obs) {
		this.poblacion1Obs = poblacion1Obs;
	}

	/**
	 * Obtiene poblacion 2.
	 *
	 * @return  poblacion 2
	 */
	public Boolean getPoblacion2() {
		return poblacion2;
	}

	/**
	 * Establece poblacion 2.
	 *
	 * @param poblacion2  poblacion 2
	 */
	public void setPoblacion2(Boolean poblacion2) {
		this.poblacion2 = poblacion2;
	}

	/**
	 * Obtiene poblacion 2 obs.
	 *
	 * @return  poblacion 2 obs
	 */
	public String getPoblacion2Obs() {
		return poblacion2Obs;
	}

	/**
	 * Establece poblacion 2 obs.
	 *
	 * @param poblacion2Obs  poblacion 2 obs
	 */
	public void setPoblacion2Obs(String poblacion2Obs) {
		this.poblacion2Obs = poblacion2Obs;
	}

	/**
	 * Obtiene poblacion 3.
	 *
	 * @return  poblacion 3
	 */
	public Boolean getPoblacion3() {
		return poblacion3;
	}

	/**
	 * Establece poblacion 3.
	 *
	 * @param poblacion3  poblacion 3
	 */
	public void setPoblacion3(Boolean poblacion3) {
		this.poblacion3 = poblacion3;
	}

	/**
	 * Obtiene poblacion 3 obs.
	 *
	 * @return  poblacion 3 obs
	 */
	public String getPoblacion3Obs() {
		return poblacion3Obs;
	}

	/**
	 * Establece poblacion 3 obs.
	 *
	 * @param poblacion3Obs  poblacion 3 obs
	 */
	public void setPoblacion3Obs(String poblacion3Obs) {
		this.poblacion3Obs = poblacion3Obs;
	}

	/**
	 * Obtiene result funcionalidad 1 orden.
	 *
	 * @return  result funcionalidad 1 orden
	 */
	public BigDecimal getResultFuncionalidad1Orden() {
		return resultFuncionalidad1Orden;
	}

	/**
	 * Establece result funcionalidad 1 orden.
	 *
	 * @param resultFuncionalidad1Orden  result funcionalidad 1 orden
	 */
	public void setResultFuncionalidad1Orden(BigDecimal resultFuncionalidad1Orden) {
		this.resultFuncionalidad1Orden = resultFuncionalidad1Orden;
	}

	/**
	 * Obtiene result funcionalidad 2 orden.
	 *
	 * @return  result funcionalidad 2 orden
	 */
	public BigDecimal getResultFuncionalidad2Orden() {
		return resultFuncionalidad2Orden;
	}

	/**
	 * Establece result funcionalidad 2 orden.
	 *
	 * @param resultFuncionalidad2Orden  result funcionalidad 2 orden
	 */
	public void setResultFuncionalidad2Orden(BigDecimal resultFuncionalidad2Orden) {
		this.resultFuncionalidad2Orden = resultFuncionalidad2Orden;
	}

	/**
	 * Obtiene result funcionalidad 3 orden.
	 *
	 * @return  result funcionalidad 3 orden
	 */
	public BigDecimal getResultFuncionalidad3Orden() {
		return resultFuncionalidad3Orden;
	}

	/**
	 * Establece result funcionalidad 3 orden.
	 *
	 * @param resultFuncionalidad3Orden  result funcionalidad 3 orden
	 */
	public void setResultFuncionalidad3Orden(BigDecimal resultFuncionalidad3Orden) {
		this.resultFuncionalidad3Orden = resultFuncionalidad3Orden;
	}

	/**
	 * Obtiene result transito 1 orden.
	 *
	 * @return  result transito 1 orden
	 */
	public BigDecimal getResultTransito1Orden() {
		return resultTransito1Orden;
	}

	/**
	 * Establece result transito 1 orden.
	 *
	 * @param resultTransito1Orden  result transito 1 orden
	 */
	public void setResultTransito1Orden(BigDecimal resultTransito1Orden) {
		this.resultTransito1Orden = resultTransito1Orden;
	}

	/**
	 * Obtiene result transito 2 orden.
	 *
	 * @return  result transito 2 orden
	 */
	public BigDecimal getResultTransito2Orden() {
		return resultTransito2Orden;
	}

	/**
	 * Establece result transito 2 orden.
	 *
	 * @param resultTransito2Orden  result transito 2 orden
	 */
	public void setResultTransito2Orden(BigDecimal resultTransito2Orden) {
		this.resultTransito2Orden = resultTransito2Orden;
	}

	/**
	 * Obtiene result transito 3 orden.
	 *
	 * @return  result transito 3 orden
	 */
	public BigDecimal getResultTransito3Orden() {
		return resultTransito3Orden;
	}

	/**
	 * Establece result transito 3 orden.
	 *
	 * @param resultTransito3Orden  result transito 3 orden
	 */
	public void setResultTransito3Orden(BigDecimal resultTransito3Orden) {
		this.resultTransito3Orden = resultTransito3Orden;
	}

	/**
	 * Obtiene result diseno 1 orden.
	 *
	 * @return  result diseno 1 orden
	 */
	public BigDecimal getResultDiseno1Orden() {
		return resultDiseno1Orden;
	}

	/**
	 * Establece result diseno 1 orden.
	 *
	 * @param resultDiseno1Orden  result diseno 1 orden
	 */
	public void setResultDiseno1Orden(BigDecimal resultDiseno1Orden) {
		this.resultDiseno1Orden = resultDiseno1Orden;
	}

	/**
	 * Obtiene result diseno 2 orden.
	 *
	 * @return  result diseno 2 orden
	 */
	public BigDecimal getResultDiseno2Orden() {
		return resultDiseno2Orden;
	}

	/**
	 * Establece result diseno 2 orden.
	 *
	 * @param resultDiseno2Orden  result diseno 2 orden
	 */
	public void setResultDiseno2Orden(BigDecimal resultDiseno2Orden) {
		this.resultDiseno2Orden = resultDiseno2Orden;
	}

	/**
	 * Obtiene result diseno 3 orden.
	 *
	 * @return  result diseno 3 orden
	 */
	public BigDecimal getResultDiseno3Orden() {
		return resultDiseno3Orden;
	}

	/**
	 * Establece result diseno 3 orden.
	 *
	 * @param resultDiseno3Orden  result diseno 3 orden
	 */
	public void setResultDiseno3Orden(BigDecimal resultDiseno3Orden) {
		this.resultDiseno3Orden = resultDiseno3Orden;
	}

	/**
	 * Obtiene result poblacion 1 orden.
	 *
	 * @return  result poblacion 1 orden
	 */
	public BigDecimal getResultPoblacion1Orden() {
		return resultPoblacion1Orden;
	}

	/**
	 * Establece result poblacion 1 orden.
	 *
	 * @param resultPoblacion1Orden  result poblacion 1 orden
	 */
	public void setResultPoblacion1Orden(BigDecimal resultPoblacion1Orden) {
		this.resultPoblacion1Orden = resultPoblacion1Orden;
	}

	/**
	 * Obtiene result poblacion 2 orden.
	 *
	 * @return  result poblacion 2 orden
	 */
	public BigDecimal getResultPoblacion2Orden() {
		return resultPoblacion2Orden;
	}

	/**
	 * Establece result poblacion 2 orden.
	 *
	 * @param resultPoblacion2Orden  result poblacion 2 orden
	 */
	public void setResultPoblacion2Orden(BigDecimal resultPoblacion2Orden) {
		this.resultPoblacion2Orden = resultPoblacion2Orden;
	}

	/**
	 * Obtiene result poblacion 3 orden.
	 *
	 * @return  result poblacion 3 orden
	 */
	public BigDecimal getResultPoblacion3Orden() {
		return resultPoblacion3Orden;
	}

	/**
	 * Establece result poblacion 3 orden.
	 *
	 * @param resultPoblacion3Orden  result poblacion 3 orden
	 */
	public void setResultPoblacion3Orden(BigDecimal resultPoblacion3Orden) {
		this.resultPoblacion3Orden = resultPoblacion3Orden;
	}

	/**
	 * Obtiene total 1 orden.
	 *
	 * @return  total 1 orden
	 */
	public BigDecimal getTotal1Orden() {
		return total1Orden;
	}

	/**
	 * Establece total 1 orden.
	 *
	 * @param total1Orden  total 1 orden
	 */
	public void setTotal1Orden(BigDecimal total1Orden) {
		this.total1Orden = total1Orden;
	}

	/**
	 * Obtiene total 2 orden.
	 *
	 * @return  total 2 orden
	 */
	public BigDecimal getTotal2Orden() {
		return total2Orden;
	}

	/**
	 * Establece total 2 orden.
	 *
	 * @param total2Orden  total 2 orden
	 */
	public void setTotal2Orden(BigDecimal total2Orden) {
		this.total2Orden = total2Orden;
	}

	/**
	 * Obtiene total 3 orden.
	 *
	 * @return  total 3 orden
	 */
	public BigDecimal getTotal3Orden() {
		return total3Orden;
	}

	/**
	 * Establece total 3 orden.
	 *
	 * @param total3Orden  total 3 orden
	 */
	public void setTotal3Orden(BigDecimal total3Orden) {
		this.total3Orden = total3Orden;
	}

	/**
	 * Obtiene categoria.
	 *
	 * @return  categoria
	 */
	public Categoria getCategoria() {
		return categoria;
	}

	/**
	 * Establece categoria.
	 *
	 * @param categoria  categoria
	 */
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
}