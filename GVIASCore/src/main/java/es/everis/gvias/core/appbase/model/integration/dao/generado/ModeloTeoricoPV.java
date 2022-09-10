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
 * Clase ModeloTeoricoPV.
 */
@Entity
@Table(name = "modelo_teorico_pv")
public class ModeloTeoricoPV implements java.io.Serializable {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/**  id modelo teorico PV. */
	@Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_modelo_teorico_pv") 
	private BigDecimal idModeloTeoricoPV;
	
	/**  est gen bueno. */
	@Column(name = "est_gen_bueno") 	
	private Boolean estGenBueno;
	
	/**  est gen bueno obs. */
	@Column(name = "est_gen_bueno_obs") 	
	private String estGenBuenoObs;

	/**  est gen regular. */
	@Column(name = "est_gen_regular") 	
	private Boolean estGenRegular;
	
	/**  est gen regular obs. */
	@Column(name = "est_gen_regular_obs") 	
	private String estGenRegularObs;
	
	/**  est gen malo. */
	@Column(name = "est_gen_malo") 	
	private Boolean estGenMalo;
	
	/**  est gen malo obs. */
	@Column(name = "est_gen_malo_obs") 	
	private String estGenMaloObs;
	
	/**  est gen pesimo. */
	@Column(name = "est_gen_pesimo") 	
	private Boolean estGenPesimo;
	
	/**  est gen pesimo obs. */
	@Column(name = "est_gen_pesimo_obs") 	
	private String estGenPesimoObs;
	
	/**  trans todo. */
	@Column(name = "trans_todo") 	
	private Boolean transTodo;
	
	/**  trans todo obs. */
	@Column(name = "trans_todo_obs") 	
	private String transTodoObs;

	/**  trans algun. */
	@Column(name = "trans_algun") 	
	private Boolean transAlgun;
	
	/**  trans algun obs. */
	@Column(name = "trans_algun_obs") 	
	private String transAlgunObs;
	
	/**  trans nada. */
	@Column(name = "trans_nada") 	
	private Boolean transNada;
	
	/**  trans nada obs. */
	@Column(name = "trans_nada_obs") 	
	private String transNadaObs;
	
	/**  nivel S bueno. */
	@Column(name = "nivel_s_bueno") 	
	private Boolean nivelSBueno;
	
	/**  nivel S bueno obs. */
	@Column(name = "nivel_s_bueno_obs") 	
	private String nivelSBuenoObs;

	/**  nivel S satisf. */
	@Column(name = "nivel_s_satisf") 	
	private Boolean nivelSSatisf;
	
	/**  nivel S satisf obs. */
	@Column(name = "nivel_s_satisf_obs") 	
	private String nivelSSatisfObs;
	
	/**  nivel S defic. */
	@Column(name = "nivel_s_defic") 	
	private Boolean nivelSDefic;
	
	/**  nivel S defic obs. */
	@Column(name = "nivel_s_defic_obs") 	
	private String nivelSDeficObs;
	
	/**  nivel S cal calzada. */
	@Column(name = "nivel_s_cal_calzada") 	
	private Double nivelSCalCalzada;
	
	/**  nivel S cal laterales. */
	@Column(name = "nivel_s_cal_laterales") 	
	private Double nivelSCalLaterales;
	
	/**  nivel S cal drenaje. */
	@Column(name = "nivel_s_cal_drenaje") 	
	private Double nivelSCalDrenaje;
	
	/**  nivel S cal estructuras. */
	@Column(name = "nivel_s_cal_estructuras") 	
	private Double nivelSCalEstructuras;
	
	/**  nivel S cal senalizacion. */
	@Column(name = "nivel_s_cal_senalizacion") 	
	private Double nivelSCalSenalizacion;
	
	/**  nivel S superficie. */
	@Column(name = "nivel_s_superficie") 	
	private String nivelSSuperficie;
	
	/**  nivel S formula. */
	@Column(name = "nivel_s_formula") 	
	private String nivelSFormula;
	
	/**  nivel SINS. */
	@Column(name = "nivel_s_INS") 	
	private Double nivelSINS;
	
	/**  nivel S recomendacion. */
	@Column(name = "nivel_s_recomendacion") 	
	private String nivelSRecomendacion;
	
	/**  nivel A bueno. */
	@Column(name = "nivel_a_bueno") 	
	private Boolean nivelABueno;
	
	/**  nivel A bueno obs. */
	@Column(name = "nivel_a_bueno_obs") 	
	private String nivelABuenoObs;
	
	/**  nivel A basico. */
	@Column(name = "nivel_a_basico") 	
	private Boolean nivelABasico;
	
	/**  nivel A basico obs. */
	@Column(name = "nivel_a_basico_obs") 	
	private String nivelABasicoObs;
	
	/**  nivel A deficiente. */
	@Column(name = "nivel_a_deficiente") 	
	private Boolean nivelADeficiente;
	
	/**  nivel A deficiente obs. */
	@Column(name = "nivel_a_deficiente_obs") 	
	private String nivelADeficienteObs;
	
	/**  nivel A parcial. */
	@Column(name = "nivel_a_parcial") 	
	private Boolean nivelAParcial;
	
	/**  nivel A parcial obs. */
	@Column(name = "nivel_a_parcial_obs") 	
	private String nivelAParcialObs;
	
	/**  nivel S costo total. */
	@Column(name = "nivel_s_costo_total") 	
	private Double nivelSCostoTotal;

	/**
	 * Obtiene id modelo teorico PV.
	 *
	 * @return  id modelo teorico PV
	 */
	public BigDecimal getIdModeloTeoricoPV() {
		return idModeloTeoricoPV;
	}

	/**
	 * Establece id modelo teorico PV.
	 *
	 * @param idModeloTeoricoPV  id modelo teorico PV
	 */
	public void setIdModeloTeoricoPV(BigDecimal idModeloTeoricoPV) {
		this.idModeloTeoricoPV = idModeloTeoricoPV;
	}

	/**
	 * Obtiene est gen bueno.
	 *
	 * @return  est gen bueno
	 */
	public Boolean getEstGenBueno() {
		return estGenBueno;
	}

	/**
	 * Establece est gen bueno.
	 *
	 * @param estGenBueno  est gen bueno
	 */
	public void setEstGenBueno(Boolean estGenBueno) {
		this.estGenBueno = estGenBueno;
	}

	/**
	 * Obtiene est gen bueno obs.
	 *
	 * @return  est gen bueno obs
	 */
	public String getEstGenBuenoObs() {
		return estGenBuenoObs;
	}

	/**
	 * Establece est gen bueno obs.
	 *
	 * @param estGenBuenoObs  est gen bueno obs
	 */
	public void setEstGenBuenoObs(String estGenBuenoObs) {
		this.estGenBuenoObs = estGenBuenoObs;
	}

	/**
	 * Obtiene est gen regular.
	 *
	 * @return  est gen regular
	 */
	public Boolean getEstGenRegular() {
		return estGenRegular;
	}

	/**
	 * Establece est gen regular.
	 *
	 * @param estGenRegular  est gen regular
	 */
	public void setEstGenRegular(Boolean estGenRegular) {
		this.estGenRegular = estGenRegular;
	}

	/**
	 * Obtiene est gen regular obs.
	 *
	 * @return  est gen regular obs
	 */
	public String getEstGenRegularObs() {
		return estGenRegularObs;
	}

	/**
	 * Establece est gen regular obs.
	 *
	 * @param estGenRegularObs  est gen regular obs
	 */
	public void setEstGenRegularObs(String estGenRegularObs) {
		this.estGenRegularObs = estGenRegularObs;
	}

	/**
	 * Obtiene est gen malo.
	 *
	 * @return  est gen malo
	 */
	public Boolean getEstGenMalo() {
		return estGenMalo;
	}

	/**
	 * Establece est gen malo.
	 *
	 * @param estGenMalo  est gen malo
	 */
	public void setEstGenMalo(Boolean estGenMalo) {
		this.estGenMalo = estGenMalo;
	}

	/**
	 * Obtiene est gen malo obs.
	 *
	 * @return  est gen malo obs
	 */
	public String getEstGenMaloObs() {
		return estGenMaloObs;
	}

	/**
	 * Establece est gen malo obs.
	 *
	 * @param estGenMaloObs  est gen malo obs
	 */
	public void setEstGenMaloObs(String estGenMaloObs) {
		this.estGenMaloObs = estGenMaloObs;
	}

	/**
	 * Obtiene est gen pesimo.
	 *
	 * @return  est gen pesimo
	 */
	public Boolean getEstGenPesimo() {
		return estGenPesimo;
	}

	/**
	 * Establece est gen pesimo.
	 *
	 * @param estGenPesimo  est gen pesimo
	 */
	public void setEstGenPesimo(Boolean estGenPesimo) {
		this.estGenPesimo = estGenPesimo;
	}

	/**
	 * Obtiene est gen pesimo obs.
	 *
	 * @return  est gen pesimo obs
	 */
	public String getEstGenPesimoObs() {
		return estGenPesimoObs;
	}

	/**
	 * Establece est gen pesimo obs.
	 *
	 * @param estGenPesimoObs  est gen pesimo obs
	 */
	public void setEstGenPesimoObs(String estGenPesimoObs) {
		this.estGenPesimoObs = estGenPesimoObs;
	}

	/**
	 * Obtiene trans todo.
	 *
	 * @return  trans todo
	 */
	public Boolean getTransTodo() {
		return transTodo;
	}

	/**
	 * Establece trans todo.
	 *
	 * @param transTodo  trans todo
	 */
	public void setTransTodo(Boolean transTodo) {
		this.transTodo = transTodo;
	}

	/**
	 * Obtiene trans todo obs.
	 *
	 * @return  trans todo obs
	 */
	public String getTransTodoObs() {
		return transTodoObs;
	}

	/**
	 * Establece trans todo obs.
	 *
	 * @param transTodoObs  trans todo obs
	 */
	public void setTransTodoObs(String transTodoObs) {
		this.transTodoObs = transTodoObs;
	}

	/**
	 * Obtiene trans algun.
	 *
	 * @return  trans algun
	 */
	public Boolean getTransAlgun() {
		return transAlgun;
	}

	/**
	 * Establece trans algun.
	 *
	 * @param transAlgun  trans algun
	 */
	public void setTransAlgun(Boolean transAlgun) {
		this.transAlgun = transAlgun;
	}

	/**
	 * Obtiene trans algun obs.
	 *
	 * @return  trans algun obs
	 */
	public String getTransAlgunObs() {
		return transAlgunObs;
	}

	/**
	 * Establece trans algun obs.
	 *
	 * @param transAlgunObs  trans algun obs
	 */
	public void setTransAlgunObs(String transAlgunObs) {
		this.transAlgunObs = transAlgunObs;
	}

	/**
	 * Obtiene trans nada.
	 *
	 * @return  trans nada
	 */
	public Boolean getTransNada() {
		return transNada;
	}

	/**
	 * Establece trans nada.
	 *
	 * @param transNada  trans nada
	 */
	public void setTransNada(Boolean transNada) {
		this.transNada = transNada;
	}

	/**
	 * Obtiene trans nada obs.
	 *
	 * @return  trans nada obs
	 */
	public String getTransNadaObs() {
		return transNadaObs;
	}

	/**
	 * Establece trans nada obs.
	 *
	 * @param transNadaObs  trans nada obs
	 */
	public void setTransNadaObs(String transNadaObs) {
		this.transNadaObs = transNadaObs;
	}

	/**
	 * Obtiene nivel S bueno.
	 *
	 * @return  nivel S bueno
	 */
	public Boolean getNivelSBueno() {
		return nivelSBueno;
	}

	/**
	 * Establece nivel S bueno.
	 *
	 * @param nivelSBueno  nivel S bueno
	 */
	public void setNivelSBueno(Boolean nivelSBueno) {
		this.nivelSBueno = nivelSBueno;
	}

	/**
	 * Obtiene nivel S bueno obs.
	 *
	 * @return  nivel S bueno obs
	 */
	public String getNivelSBuenoObs() {
		return nivelSBuenoObs;
	}

	/**
	 * Establece nivel S bueno obs.
	 *
	 * @param nivelSBuenoObs  nivel S bueno obs
	 */
	public void setNivelSBuenoObs(String nivelSBuenoObs) {
		this.nivelSBuenoObs = nivelSBuenoObs;
	}

	/**
	 * Obtiene nivel S satisf.
	 *
	 * @return  nivel S satisf
	 */
	public Boolean getNivelSSatisf() {
		return nivelSSatisf;
	}

	/**
	 * Establece nivel S satisf.
	 *
	 * @param nivelSSatisf  nivel S satisf
	 */
	public void setNivelSSatisf(Boolean nivelSSatisf) {
		this.nivelSSatisf = nivelSSatisf;
	}

	/**
	 * Obtiene nivel S satisf obs.
	 *
	 * @return  nivel S satisf obs
	 */
	public String getNivelSSatisfObs() {
		return nivelSSatisfObs;
	}

	/**
	 * Establece nivel S satisf obs.
	 *
	 * @param nivelSSatisfObs  nivel S satisf obs
	 */
	public void setNivelSSatisfObs(String nivelSSatisfObs) {
		this.nivelSSatisfObs = nivelSSatisfObs;
	}

	/**
	 * Obtiene nivel S defic.
	 *
	 * @return  nivel S defic
	 */
	public Boolean getNivelSDefic() {
		return nivelSDefic;
	}

	/**
	 * Establece nivel S defic.
	 *
	 * @param nivelSDefic  nivel S defic
	 */
	public void setNivelSDefic(Boolean nivelSDefic) {
		this.nivelSDefic = nivelSDefic;
	}

	/**
	 * Obtiene nivel S defic obs.
	 *
	 * @return  nivel S defic obs
	 */
	public String getNivelSDeficObs() {
		return nivelSDeficObs;
	}

	/**
	 * Establece nivel S defic obs.
	 *
	 * @param nivelSDeficObs  nivel S defic obs
	 */
	public void setNivelSDeficObs(String nivelSDeficObs) {
		this.nivelSDeficObs = nivelSDeficObs;
	}

	/**
	 * Obtiene nivel S cal calzada.
	 *
	 * @return  nivel S cal calzada
	 */
	public Double getNivelSCalCalzada() {
		return nivelSCalCalzada;
	}

	/**
	 * Establece nivel S cal calzada.
	 *
	 * @param nivelSCalCalzada  nivel S cal calzada
	 */
	public void setNivelSCalCalzada(Double nivelSCalCalzada) {
		this.nivelSCalCalzada = nivelSCalCalzada;
	}

	/**
	 * Obtiene nivel S cal laterales.
	 *
	 * @return  nivel S cal laterales
	 */
	public Double getNivelSCalLaterales() {
		return nivelSCalLaterales;
	}

	/**
	 * Establece nivel S cal laterales.
	 *
	 * @param nivelSCalLaterales  nivel S cal laterales
	 */
	public void setNivelSCalLaterales(Double nivelSCalLaterales) {
		this.nivelSCalLaterales = nivelSCalLaterales;
	}

	/**
	 * Obtiene nivel S cal drenaje.
	 *
	 * @return  nivel S cal drenaje
	 */
	public Double getNivelSCalDrenaje() {
		return nivelSCalDrenaje;
	}

	/**
	 * Establece nivel S cal drenaje.
	 *
	 * @param nivelSCalDrenaje  nivel S cal drenaje
	 */
	public void setNivelSCalDrenaje(Double nivelSCalDrenaje) {
		this.nivelSCalDrenaje = nivelSCalDrenaje;
	}

	/**
	 * Obtiene nivel S cal estructuras.
	 *
	 * @return  nivel S cal estructuras
	 */
	public Double getNivelSCalEstructuras() {
		return nivelSCalEstructuras;
	}

	/**
	 * Establece nivel S cal estructuras.
	 *
	 * @param nivelSCalEstructuras  nivel S cal estructuras
	 */
	public void setNivelSCalEstructuras(Double nivelSCalEstructuras) {
		this.nivelSCalEstructuras = nivelSCalEstructuras;
	}

	/**
	 * Obtiene nivel S cal senalizacion.
	 *
	 * @return  nivel S cal senalizacion
	 */
	public Double getNivelSCalSenalizacion() {
		return nivelSCalSenalizacion;
	}

	/**
	 * Establece nivel S cal senalizacion.
	 *
	 * @param nivelSCalSenalizacion  nivel S cal senalizacion
	 */
	public void setNivelSCalSenalizacion(Double nivelSCalSenalizacion) {
		this.nivelSCalSenalizacion = nivelSCalSenalizacion;
	}

	/**
	 * Obtiene nivel S superficie.
	 *
	 * @return  nivel S superficie
	 */
	public String getNivelSSuperficie() {
		return nivelSSuperficie;
	}

	/**
	 * Establece nivel S superficie.
	 *
	 * @param nivelSSuperficie  nivel S superficie
	 */
	public void setNivelSSuperficie(String nivelSSuperficie) {
		this.nivelSSuperficie = nivelSSuperficie;
	}

	/**
	 * Obtiene nivel S formula.
	 *
	 * @return  nivel S formula
	 */
	public String getNivelSFormula() {
		return nivelSFormula;
	}

	/**
	 * Establece nivel S formula.
	 *
	 * @param nivelSFormula  nivel S formula
	 */
	public void setNivelSFormula(String nivelSFormula) {
		this.nivelSFormula = nivelSFormula;
	}

	/**
	 * Obtiene nivel SINS.
	 *
	 * @return  nivel SINS
	 */
	public Double getNivelSINS() {
		return nivelSINS;
	}

	/**
	 * Establece nivel SINS.
	 *
	 * @param nivelSINS  nivel SINS
	 */
	public void setNivelSINS(Double nivelSINS) {
		this.nivelSINS = nivelSINS;
	}

	/**
	 * Obtiene nivel S recomendacion.
	 *
	 * @return  nivel S recomendacion
	 */
	public String getNivelSRecomendacion() {
		return nivelSRecomendacion;
	}

	/**
	 * Establece nivel S recomendacion.
	 *
	 * @param nivelSRecomendacion  nivel S recomendacion
	 */
	public void setNivelSRecomendacion(String nivelSRecomendacion) {
		this.nivelSRecomendacion = nivelSRecomendacion;
	}

	/**
	 * Obtiene nivel A bueno.
	 *
	 * @return  nivel A bueno
	 */
	public Boolean getNivelABueno() {
		return nivelABueno;
	}

	/**
	 * Establece nivel A bueno.
	 *
	 * @param nivelABueno  nivel A bueno
	 */
	public void setNivelABueno(Boolean nivelABueno) {
		this.nivelABueno = nivelABueno;
	}

	/**
	 * Obtiene nivel A bueno obs.
	 *
	 * @return  nivel A bueno obs
	 */
	public String getNivelABuenoObs() {
		return nivelABuenoObs;
	}

	/**
	 * Establece nivel A bueno obs.
	 *
	 * @param nivelABuenoObs  nivel A bueno obs
	 */
	public void setNivelABuenoObs(String nivelABuenoObs) {
		this.nivelABuenoObs = nivelABuenoObs;
	}

	/**
	 * Obtiene nivel A basico.
	 *
	 * @return  nivel A basico
	 */
	public Boolean getNivelABasico() {
		return nivelABasico;
	}

	/**
	 * Establece nivel A basico.
	 *
	 * @param nivelABasico  nivel A basico
	 */
	public void setNivelABasico(Boolean nivelABasico) {
		this.nivelABasico = nivelABasico;
	}

	/**
	 * Obtiene nivel A basico obs.
	 *
	 * @return  nivel A basico obs
	 */
	public String getNivelABasicoObs() {
		return nivelABasicoObs;
	}

	/**
	 * Establece nivel A basico obs.
	 *
	 * @param nivelABasicoObs  nivel A basico obs
	 */
	public void setNivelABasicoObs(String nivelABasicoObs) {
		this.nivelABasicoObs = nivelABasicoObs;
	}

	/**
	 * Obtiene nivel A deficiente.
	 *
	 * @return  nivel A deficiente
	 */
	public Boolean getNivelADeficiente() {
		return nivelADeficiente;
	}

	/**
	 * Establece nivel A deficiente.
	 *
	 * @param nivelADeficiente  nivel A deficiente
	 */
	public void setNivelADeficiente(Boolean nivelADeficiente) {
		this.nivelADeficiente = nivelADeficiente;
	}

	/**
	 * Obtiene nivel A deficiente obs.
	 *
	 * @return  nivel A deficiente obs
	 */
	public String getNivelADeficienteObs() {
		return nivelADeficienteObs;
	}

	/**
	 * Establece nivel A deficiente obs.
	 *
	 * @param nivelADeficienteObs  nivel A deficiente obs
	 */
	public void setNivelADeficienteObs(String nivelADeficienteObs) {
		this.nivelADeficienteObs = nivelADeficienteObs;
	}

	/**
	 * Obtiene nivel A parcial.
	 *
	 * @return  nivel A parcial
	 */
	public Boolean getNivelAParcial() {
		return nivelAParcial;
	}

	/**
	 * Establece nivel A parcial.
	 *
	 * @param nivelAParcial  nivel A parcial
	 */
	public void setNivelAParcial(Boolean nivelAParcial) {
		this.nivelAParcial = nivelAParcial;
	}

	/**
	 * Obtiene nivel A parcial obs.
	 *
	 * @return  nivel A parcial obs
	 */
	public String getNivelAParcialObs() {
		return nivelAParcialObs;
	}

	/**
	 * Establece nivel A parcial obs.
	 *
	 * @param nivelAParcialObs  nivel A parcial obs
	 */
	public void setNivelAParcialObs(String nivelAParcialObs) {
		this.nivelAParcialObs = nivelAParcialObs;
	}

	/**
	 * Obtiene nivel S costo total.
	 *
	 * @return  nivel S costo total
	 */
	public Double getNivelSCostoTotal() {
		return nivelSCostoTotal;
	}

	/**
	 * Establece nivel S costo total.
	 *
	 * @param nivelSCostoTotal  nivel S costo total
	 */
	public void setNivelSCostoTotal(Double nivelSCostoTotal) {
		this.nivelSCostoTotal = nivelSCostoTotal;
	}
}