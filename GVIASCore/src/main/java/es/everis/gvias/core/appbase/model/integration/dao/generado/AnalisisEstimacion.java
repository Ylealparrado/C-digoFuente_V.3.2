package es.everis.gvias.core.appbase.model.integration.dao.generado;

import java.lang.reflect.Method;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "analisis_estimacion")
public class AnalisisEstimacion implements java.io.Serializable {

	private static final long serialVersionUID = 8L;
	
	@Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_analisis_estimacion") 
	private BigDecimal idAnalisisEstimacion;
	
	@Column(name = "rutinario_1") 	
	private Double rutinario1;
	
	@Column(name = "periodico_1") 	
	private Double periodico1;
	
	@Column(name = "rehabilitacion_1") 	
	private Double rehabilitacion1;
	
	@Column(name = "repro_rutinario_1") 	
	private Double reproRutinario1;
	
	@Column(name = "repro_periodico_1") 	
	private Double reproPeriodico1;
	
	@Column(name = "repro_rehabilitacion_1") 	
	private Double reproRehabilitacion1;
	
	
	@Column(name = "rutinario_2") 	
	private Double rutinario2;
	
	@Column(name = "periodico_2") 	
	private Double periodico2;
	
	@Column(name = "rehabilitacion_2") 	
	private Double rehabilitacion2;
	
	@Column(name = "repro_rutinario_2") 	
	private Double reproRutinario2;
	
	@Column(name = "repro_periodico_2") 	
	private Double reproPeriodico2;
	
	@Column(name = "repro_rehabilitacion_2") 	
	private Double reproRehabilitacion2;
	
	
	@Column(name = "rutinario_3") 	
	private Double rutinario3;
	
	@Column(name = "periodico_3") 	
	private Double periodico3;
	
	@Column(name = "rehabilitacion_3") 	
	private Double rehabilitacion3;
	
	@Column(name = "repro_rutinario_3") 	
	private Double reproRutinario3;
	
	@Column(name = "repro_periodico_3") 	
	private Double reproPeriodico3;
	
	@Column(name = "repro_rehabilitacion_3") 	
	private Double reproRehabilitacion3;
	
	
	@Column(name = "rutinario_4") 	
	private Double rutinario4;
	
	@Column(name = "periodico_4") 	
	private Double periodico4;
	
	@Column(name = "rehabilitacion_4") 	
	private Double rehabilitacion4;
	
	@Column(name = "repro_rutinario_4") 	
	private Double reproRutinario4;
	
	@Column(name = "repro_periodico_4") 	
	private Double reproPeriodico4;
	
	@Column(name = "repro_rehabilitacion_4") 	
	private Double reproRehabilitacion4;
	
	
	@Column(name = "rutinario_5") 	
	private Double rutinario5;
	
	@Column(name = "periodico_5") 	
	private Double periodico5;
	
	@Column(name = "rehabilitacion_5") 	
	private Double rehabilitacion5;
	
	@Column(name = "repro_rutinario_5") 	
	private Double reproRutinario5;
	
	@Column(name = "repro_periodico_5") 	
	private Double reproPeriodico5;
	
	@Column(name = "repro_rehabilitacion_5") 	
	private Double reproRehabilitacion5;
	
	
	@Column(name = "rutinario_6") 	
	private Double rutinario6;
	
	@Column(name = "periodico_6") 	
	private Double periodico6;
	
	@Column(name = "rehabilitacion_6") 	
	private Double rehabilitacion6;
	
	@Column(name = "repro_rutinario_6") 	
	private Double reproRutinario6;
	
	@Column(name = "repro_periodico_6") 	
	private Double reproPeriodico6;
	
	@Column(name = "repro_rehabilitacion_6") 	
	private Double reproRehabilitacion6;
	
	
	@Column(name = "rutinario_7") 	
	private Double rutinario7;
	
	@Column(name = "periodico_7") 	
	private Double periodico7;
	
	@Column(name = "rehabilitacion_7") 	
	private Double rehabilitacion7;
	
	@Column(name = "repro_rutinario_7") 	
	private Double reproRutinario7;
	
	@Column(name = "repro_periodico_7") 	
	private Double reproPeriodico7;
	
	@Column(name = "repro_rehabilitacion_7") 	
	private Double reproRehabilitacion7;
	
	
	@Column(name = "rutinario_8") 	
	private Double rutinario8;
	
	@Column(name = "periodico_8") 	
	private Double periodico8;
	
	@Column(name = "rehabilitacion_8") 	
	private Double rehabilitacion8;
	
	@Column(name = "repro_rutinario_8") 	
	private Double reproRutinario8;
	
	@Column(name = "repro_periodico_8") 	
	private Double reproPeriodico8;
	
	@Column(name = "repro_rehabilitacion_8") 	
	private Double reproRehabilitacion8;
	
	
	@Column(name = "rutinario_9") 	
	private Double rutinario9;
	
	@Column(name = "periodico_9") 	
	private Double periodico9;
	
	@Column(name = "rehabilitacion_9") 	
	private Double rehabilitacion9;
	
	@Column(name = "repro_rutinario_9") 	
	private Double reproRutinario9;
	
	@Column(name = "repro_periodico_9") 	
	private Double reproPeriodico9;
	
	@Column(name = "repro_rehabilitacion_9") 	
	private Double reproRehabilitacion9;
	
	
	@Column(name = "rutinario_10") 	
	private Double rutinario10;
	
	@Column(name = "periodico_10") 	
	private Double periodico10;
	
	@Column(name = "rehabilitacion_10") 	
	private Double rehabilitacion10;
	
	@Column(name = "repro_rutinario_10") 	
	private Double reproRutinario10;
	
	@Column(name = "repro_periodico_10") 	
	private Double reproPeriodico10;
	
	@Column(name = "repro_rehabilitacion_10") 	
	private Double reproRehabilitacion10;

	public BigDecimal getIdAnalisisEstimacion() {
		return idAnalisisEstimacion;
	}

	public void setIdAnalisisEstimacion(BigDecimal idAnalisisEstimacion) {
		this.idAnalisisEstimacion = idAnalisisEstimacion;
	}

	public Double getRutinario1() {
		return rutinario1;
	}

	public void setRutinario1(Double rutinario1) {
		this.rutinario1 = rutinario1;
	}

	public Double getPeriodico1() {
		return periodico1;
	}

	public void setPeriodico1(Double periodico1) {
		this.periodico1 = periodico1;
	}

	public Double getRehabilitacion1() {
		return rehabilitacion1;
	}

	public void setRehabilitacion1(Double rehabilitacion1) {
		this.rehabilitacion1 = rehabilitacion1;
	}

	public Double getReproRutinario1() {
		return reproRutinario1;
	}

	public void setReproRutinario1(Double reproRutinario1) {
		this.reproRutinario1 = reproRutinario1;
	}

	public Double getReproPeriodico1() {
		return reproPeriodico1;
	}

	public void setReproPeriodico1(Double reproPeriodico1) {
		this.reproPeriodico1 = reproPeriodico1;
	}

	public Double getReproRehabilitacion1() {
		return reproRehabilitacion1;
	}

	public void setReproRehabilitacion1(Double reproRehabilitacion1) {
		this.reproRehabilitacion1 = reproRehabilitacion1;
	}

	public Double getRutinario2() {
		return rutinario2;
	}

	public void setRutinario2(Double rutinario2) {
		this.rutinario2 = rutinario2;
	}

	public Double getPeriodico2() {
		return periodico2;
	}

	public void setPeriodico2(Double periodico2) {
		this.periodico2 = periodico2;
	}

	public Double getRehabilitacion2() {
		return rehabilitacion2;
	}

	public void setRehabilitacion2(Double rehabilitacion2) {
		this.rehabilitacion2 = rehabilitacion2;
	}

	public Double getReproRutinario2() {
		return reproRutinario2;
	}

	public void setReproRutinario2(Double reproRutinario2) {
		this.reproRutinario2 = reproRutinario2;
	}

	public Double getReproPeriodico2() {
		return reproPeriodico2;
	}

	public void setReproPeriodico2(Double reproPeriodico2) {
		this.reproPeriodico2 = reproPeriodico2;
	}

	public Double getReproRehabilitacion2() {
		return reproRehabilitacion2;
	}

	public void setReproRehabilitacion2(Double reproRehabilitacion2) {
		this.reproRehabilitacion2 = reproRehabilitacion2;
	}

	public Double getRutinario3() {
		return rutinario3;
	}

	public void setRutinario3(Double rutinario3) {
		this.rutinario3 = rutinario3;
	}

	public Double getPeriodico3() {
		return periodico3;
	}

	public void setPeriodico3(Double periodico3) {
		this.periodico3 = periodico3;
	}

	public Double getRehabilitacion3() {
		return rehabilitacion3;
	}

	public void setRehabilitacion3(Double rehabilitacion3) {
		this.rehabilitacion3 = rehabilitacion3;
	}

	public Double getReproRutinario3() {
		return reproRutinario3;
	}

	public void setReproRutinario3(Double reproRutinario3) {
		this.reproRutinario3 = reproRutinario3;
	}

	public Double getReproPeriodico3() {
		return reproPeriodico3;
	}

	public void setReproPeriodico3(Double reproPeriodico3) {
		this.reproPeriodico3 = reproPeriodico3;
	}

	public Double getReproRehabilitacion3() {
		return reproRehabilitacion3;
	}

	public void setReproRehabilitacion3(Double reproRehabilitacion3) {
		this.reproRehabilitacion3 = reproRehabilitacion3;
	}

	public Double getRutinario4() {
		return rutinario4;
	}

	public void setRutinario4(Double rutinario4) {
		this.rutinario4 = rutinario4;
	}

	public Double getPeriodico4() {
		return periodico4;
	}

	public void setPeriodico4(Double periodico4) {
		this.periodico4 = periodico4;
	}

	public Double getRehabilitacion4() {
		return rehabilitacion4;
	}

	public void setRehabilitacion4(Double rehabilitacion4) {
		this.rehabilitacion4 = rehabilitacion4;
	}

	public Double getReproRutinario4() {
		return reproRutinario4;
	}

	public void setReproRutinario4(Double reproRutinario4) {
		this.reproRutinario4 = reproRutinario4;
	}

	public Double getReproPeriodico4() {
		return reproPeriodico4;
	}

	public void setReproPeriodico4(Double reproPeriodico4) {
		this.reproPeriodico4 = reproPeriodico4;
	}

	public Double getReproRehabilitacion4() {
		return reproRehabilitacion4;
	}

	public void setReproRehabilitacion4(Double reproRehabilitacion4) {
		this.reproRehabilitacion4 = reproRehabilitacion4;
	}

	public Double getRutinario5() {
		return rutinario5;
	}

	public void setRutinario5(Double rutinario5) {
		this.rutinario5 = rutinario5;
	}

	public Double getPeriodico5() {
		return periodico5;
	}

	public void setPeriodico5(Double periodico5) {
		this.periodico5 = periodico5;
	}

	public Double getRehabilitacion5() {
		return rehabilitacion5;
	}

	public void setRehabilitacion5(Double rehabilitacion5) {
		this.rehabilitacion5 = rehabilitacion5;
	}

	public Double getReproRutinario5() {
		return reproRutinario5;
	}

	public void setReproRutinario5(Double reproRutinario5) {
		this.reproRutinario5 = reproRutinario5;
	}

	public Double getReproPeriodico5() {
		return reproPeriodico5;
	}

	public void setReproPeriodico5(Double reproPeriodico5) {
		this.reproPeriodico5 = reproPeriodico5;
	}

	public Double getReproRehabilitacion5() {
		return reproRehabilitacion5;
	}

	public void setReproRehabilitacion5(Double reproRehabilitacion5) {
		this.reproRehabilitacion5 = reproRehabilitacion5;
	}

	public Double getRutinario6() {
		return rutinario6;
	}

	public void setRutinario6(Double rutinario6) {
		this.rutinario6 = rutinario6;
	}

	public Double getPeriodico6() {
		return periodico6;
	}

	public void setPeriodico6(Double periodico6) {
		this.periodico6 = periodico6;
	}

	public Double getRehabilitacion6() {
		return rehabilitacion6;
	}

	public void setRehabilitacion6(Double rehabilitacion6) {
		this.rehabilitacion6 = rehabilitacion6;
	}

	public Double getReproRutinario6() {
		return reproRutinario6;
	}

	public void setReproRutinario6(Double reproRutinario6) {
		this.reproRutinario6 = reproRutinario6;
	}

	public Double getReproPeriodico6() {
		return reproPeriodico6;
	}

	public void setReproPeriodico6(Double reproPeriodico6) {
		this.reproPeriodico6 = reproPeriodico6;
	}

	public Double getReproRehabilitacion6() {
		return reproRehabilitacion6;
	}

	public void setReproRehabilitacion6(Double reproRehabilitacion6) {
		this.reproRehabilitacion6 = reproRehabilitacion6;
	}

	public Double getRutinario7() {
		return rutinario7;
	}

	public void setRutinario7(Double rutinario7) {
		this.rutinario7 = rutinario7;
	}

	public Double getPeriodico7() {
		return periodico7;
	}

	public void setPeriodico7(Double periodico7) {
		this.periodico7 = periodico7;
	}

	public Double getRehabilitacion7() {
		return rehabilitacion7;
	}

	public void setRehabilitacion7(Double rehabilitacion7) {
		this.rehabilitacion7 = rehabilitacion7;
	}

	public Double getReproRutinario7() {
		return reproRutinario7;
	}

	public void setReproRutinario7(Double reproRutinario7) {
		this.reproRutinario7 = reproRutinario7;
	}

	public Double getReproPeriodico7() {
		return reproPeriodico7;
	}

	public void setReproPeriodico7(Double reproPeriodico7) {
		this.reproPeriodico7 = reproPeriodico7;
	}

	public Double getReproRehabilitacion7() {
		return reproRehabilitacion7;
	}

	public void setReproRehabilitacion7(Double reproRehabilitacion7) {
		this.reproRehabilitacion7 = reproRehabilitacion7;
	}

	public Double getRutinario8() {
		return rutinario8;
	}

	public void setRutinario8(Double rutinario8) {
		this.rutinario8 = rutinario8;
	}

	public Double getPeriodico8() {
		return periodico8;
	}

	public void setPeriodico8(Double periodico8) {
		this.periodico8 = periodico8;
	}

	public Double getRehabilitacion8() {
		return rehabilitacion8;
	}

	public void setRehabilitacion8(Double rehabilitacion8) {
		this.rehabilitacion8 = rehabilitacion8;
	}

	public Double getReproRutinario8() {
		return reproRutinario8;
	}

	public void setReproRutinario8(Double reproRutinario8) {
		this.reproRutinario8 = reproRutinario8;
	}

	public Double getReproPeriodico8() {
		return reproPeriodico8;
	}

	public void setReproPeriodico8(Double reproPeriodico8) {
		this.reproPeriodico8 = reproPeriodico8;
	}

	public Double getReproRehabilitacion8() {
		return reproRehabilitacion8;
	}

	public void setReproRehabilitacion8(Double reproRehabilitacion8) {
		this.reproRehabilitacion8 = reproRehabilitacion8;
	}

	public Double getRutinario9() {
		return rutinario9;
	}

	public void setRutinario9(Double rutinario9) {
		this.rutinario9 = rutinario9;
	}

	public Double getPeriodico9() {
		return periodico9;
	}

	public void setPeriodico9(Double periodico9) {
		this.periodico9 = periodico9;
	}

	public Double getRehabilitacion9() {
		return rehabilitacion9;
	}

	public void setRehabilitacion9(Double rehabilitacion9) {
		this.rehabilitacion9 = rehabilitacion9;
	}

	public Double getReproRutinario9() {
		return reproRutinario9;
	}

	public void setReproRutinario9(Double reproRutinario9) {
		this.reproRutinario9 = reproRutinario9;
	}

	public Double getReproPeriodico9() {
		return reproPeriodico9;
	}

	public void setReproPeriodico9(Double reproPeriodico9) {
		this.reproPeriodico9 = reproPeriodico9;
	}

	public Double getReproRehabilitacion9() {
		return reproRehabilitacion9;
	}

	public void setReproRehabilitacion9(Double reproRehabilitacion9) {
		this.reproRehabilitacion9 = reproRehabilitacion9;
	}

	public Double getRutinario10() {
		return rutinario10;
	}

	public void setRutinario10(Double rutinario10) {
		this.rutinario10 = rutinario10;
	}

	public Double getPeriodico10() {
		return periodico10;
	}

	public void setPeriodico10(Double periodico10) {
		this.periodico10 = periodico10;
	}

	public Double getRehabilitacion10() {
		return rehabilitacion10;
	}

	public void setRehabilitacion10(Double rehabilitacion10) {
		this.rehabilitacion10 = rehabilitacion10;
	}

	public Double getReproRutinario10() {
		return reproRutinario10;
	}

	public void setReproRutinario10(Double reproRutinario10) {
		this.reproRutinario10 = reproRutinario10;
	}

	public Double getReproPeriodico10() {
		return reproPeriodico10;
	}

	public void setReproPeriodico10(Double reproPeriodico10) {
		this.reproPeriodico10 = reproPeriodico10;
	}

	public Double getReproRehabilitacion10() {
		return reproRehabilitacion10;
	}

	public void setReproRehabilitacion10(Double reproRehabilitacion10) {
		this.reproRehabilitacion10 = reproRehabilitacion10;
	}
	
    public void metodoSet(Method method, Double value) throws Exception {
        Object[] parameters = new Object[1];
        parameters[0] = value;
        method.invoke(this, parameters);
    }
    
    public Object metodoGet(Method method) throws Exception {
        return method.invoke(this);
    }
}