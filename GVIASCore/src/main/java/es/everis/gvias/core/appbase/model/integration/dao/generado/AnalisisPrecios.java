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
 * Clase AnalisisPrecios.
 */
@Entity
@Table(name = "analisis_precios")
public class AnalisisPrecios implements java.io.Serializable {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**  id analisis precios. */
	@Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_analisis_precios") 
	private BigDecimal idAnalisisPrecios;
	
	/**  municipio. */
	@ManyToOne 
	@JoinColumn(name="id_municipio")
	private Municipio municipio; 
	
	/**  ipc. */
	@Column (name = "ipc")
	private Double ipc;

	/**  afirm bueno 1. */
	@Column (name = "afirm_bueno_1")
	private Double afirmBueno1;
	
	/**  afirm regular 1. */
	@Column (name = "afirm_regular_1")
	private Double afirmRegular1;
	
	/**  afirm malo 1. */
	@Column (name = "afirm_malo_1")
	private Double afirmMalo1;
	
	/**  tierra bueno 1. */
	@Column (name = "tierra_bueno_1")
	private Double tierraBueno1;
	
	/**  tierra regular 1. */
	@Column (name = "tierra_regular_1")
	private Double tierraRegular1;
	
	/**  tierra malo 1. */
	@Column (name = "tierra_malo_1")
	private Double tierraMalo1;
	
	/**  pavim bueno 1. */
	@Column (name = "pavim_bueno_1")
	private Double pavimBueno1;
	
	/**  pavim regular 1. */
	@Column (name = "pavim_regular_1")
	private Double pavimRegular1;
	
	/**  pavim malo 1. */
	@Column (name = "pavim_malo_1")
	private Double pavimMalo1;
	
	/**  afirm bueno 2. */
	@Column (name = "afirm_bueno_2")
	private Double afirmBueno2;
	
	/**  afirm regular 2. */
	@Column (name = "afirm_regular_2")
	private Double afirmRegular2;
	
	/**  afirm malo 2. */
	@Column (name = "afirm_malo_2")
	private Double afirmMalo2;
	
	/**  tierra bueno 2. */
	@Column (name = "tierra_bueno_2")
	private Double tierraBueno2;
	
	/**  tierra regular 2. */
	@Column (name = "tierra_regular_2")
	private Double tierraRegular2;
	
	/**  tierra malo 2. */
	@Column (name = "tierra_malo_2")
	private Double tierraMalo2;
	
	/**  pavim bueno 2. */
	@Column (name = "pavim_bueno_2")
	private Double pavimBueno2;
	
	/**  pavim regular 2. */
	@Column (name = "pavim_regular_2")
	private Double pavimRegular2;
	
	/**  pavim malo 2. */
	@Column (name = "pavim_malo_2")
	private Double pavimMalo2;
	
	/**  afirm bueno 3. */
	@Column (name = "afirm_bueno_3")
	private Double afirmBueno3;
	
	/**  afirm regular 3. */
	@Column (name = "afirm_regular_3")
	private Double afirmRegular3;
	
	/**  afirm malo 3. */
	@Column (name = "afirm_malo_3")
	private Double afirmMalo3;
	
	/**  tierra bueno 3. */
	@Column (name = "tierra_bueno_3")
	private Double tierraBueno3;
	
	/**  tierra regular 3. */
	@Column (name = "tierra_regular_3")
	private Double tierraRegular3;
	
	/**  tierra malo 3. */
	@Column (name = "tierra_malo_3")
	private Double tierraMalo3;
	
	/**  pavim bueno 3. */
	@Column (name = "pavim_bueno_3")
	private Double pavimBueno3;
	
	/**  pavim regular 3. */
	@Column (name = "pavim_regular_3")
	private Double pavimRegular3;
	
	/**  pavim malo 3. */
	@Column (name = "pavim_malo_3")
	private Double pavimMalo3;
	
	/**  afirm bueno 4. */
	@Column (name = "afirm_bueno_4")
	private Double afirmBueno4;
	
	/**  afirm regular 4. */
	@Column (name = "afirm_regular_4")
	private Double afirmRegular4;
	
	/**  afirm malo 4. */
	@Column (name = "afirm_malo_4")
	private Double afirmMalo4;
	
	/**  tierra bueno 4. */
	@Column (name = "tierra_bueno_4")
	private Double tierraBueno4;
	
	/**  tierra regular 4. */
	@Column (name = "tierra_regular_4")
	private Double tierraRegular4;
	
	/**  tierra malo 4. */
	@Column (name = "tierra_malo_4")
	private Double tierraMalo4;
	
	/**  pavim bueno 4. */
	@Column (name = "pavim_bueno_4")
	private Double pavimBueno4;
	
	/**  pavim regular 4. */
	@Column (name = "pavim_regular_4")
	private Double pavimRegular4;
	
	/**  pavim malo 4. */
	@Column (name = "pavim_malo_4")
	private Double pavimMalo4;
	
	/**  afirm bueno 5. */
	@Column (name = "afirm_bueno_5")
	private Double afirmBueno5;
	
	/**  afirm regular 5. */
	@Column (name = "afirm_regular_5")
	private Double afirmRegular5;
	
	/**  afirm malo 5. */
	@Column (name = "afirm_malo_5")
	private Double afirmMalo5;
	
	/**  tierra bueno 5. */
	@Column (name = "tierra_bueno_5")
	private Double tierraBueno5;
	
	/**  tierra regular 5. */
	@Column (name = "tierra_regular_5")
	private Double tierraRegular5;
	
	/**  tierra malo 5. */
	@Column (name = "tierra_malo_5")
	private Double tierraMalo5;
	
	/**  pavim bueno 5. */
	@Column (name = "pavim_bueno_5")
	private Double pavimBueno5;
	
	/**  pavim regular 5. */
	@Column (name = "pavim_regular_5")
	private Double pavimRegular5;
	
	/**  pavim malo 5. */
	@Column (name = "pavim_malo_5")
	private Double pavimMalo5;
	
	/**  afirm bueno 6. */
	@Column (name = "afirm_bueno_6")
	private Double afirmBueno6;
	
	/**  afirm regular 6. */
	@Column (name = "afirm_regular_6")
	private Double afirmRegular6;
	
	/**  afirm malo 6. */
	@Column (name = "afirm_malo_6")
	private Double afirmMalo6;
	
	/**  tierra bueno 6. */
	@Column (name = "tierra_bueno_6")
	private Double tierraBueno6;
	
	/**  tierra regular 6. */
	@Column (name = "tierra_regular_6")
	private Double tierraRegular6;
	
	/**  tierra malo 6. */
	@Column (name = "tierra_malo_6")
	private Double tierraMalo6;
	
	/**  pavim bueno 6. */
	@Column (name = "pavim_bueno_6")
	private Double pavimBueno6;
	
	/**  pavim regular 6. */
	@Column (name = "pavim_regular_6")
	private Double pavimRegular6;
	
	/**  pavim malo 6. */
	@Column (name = "pavim_malo_6")
	private Double pavimMalo6;
	
	/**  afirm bueno 7. */
	@Column (name = "afirm_bueno_7")
	private Double afirmBueno7;
	
	/**  afirm regular 7. */
	@Column (name = "afirm_regular_7")
	private Double afirmRegular7;
	
	/**  afirm malo 7. */
	@Column (name = "afirm_malo_7")
	private Double afirmMalo7;
	
	/**  tierra bueno 7. */
	@Column (name = "tierra_bueno_7")
	private Double tierraBueno7;
	
	/**  tierra regular 7. */
	@Column (name = "tierra_regular_7")
	private Double tierraRegular7;
	
	/**  tierra malo 7. */
	@Column (name = "tierra_malo_7")
	private Double tierraMalo7;
	
	/**  pavim bueno 7. */
	@Column (name = "pavim_bueno_7")
	private Double pavimBueno7;
	
	/**  pavim regular 7. */
	@Column (name = "pavim_regular_7")
	private Double pavimRegular7;
	
	/**  pavim malo 7. */
	@Column (name = "pavim_malo_7")
	private Double pavimMalo7;
	
	/**  afirm bueno 8. */
	@Column (name = "afirm_bueno_8")
	private Double afirmBueno8;
	
	/**  afirm regular 8. */
	@Column (name = "afirm_regular_8")
	private Double afirmRegular8;
	
	/**  afirm malo 8. */
	@Column (name = "afirm_malo_8")
	private Double afirmMalo8;
	
	/**  tierra bueno 8. */
	@Column (name = "tierra_bueno_8")
	private Double tierraBueno8;
	
	/**  tierra regular 8. */
	@Column (name = "tierra_regular_8")
	private Double tierraRegular8;
	
	/**  tierra malo 8. */
	@Column (name = "tierra_malo_8")
	private Double tierraMalo8;
	
	/**  pavim bueno 8. */
	@Column (name = "pavim_bueno_8")
	private Double pavimBueno8;
	
	/**  pavim regular 8. */
	@Column (name = "pavim_regular_8")
	private Double pavimRegular8;
	
	/**  pavim malo 8. */
	@Column (name = "pavim_malo_8")
	private Double pavimMalo8;
	
	/**  afirm bueno 9. */
	@Column (name = "afirm_bueno_9")
	private Double afirmBueno9;
	
	/**  afirm regular 9. */
	@Column (name = "afirm_regular_9")
	private Double afirmRegular9;
	
	/**  afirm malo 9. */
	@Column (name = "afirm_malo_9")
	private Double afirmMalo9;
	
	/**  tierra bueno 9. */
	@Column (name = "tierra_bueno_9")
	private Double tierraBueno9;
	
	/**  tierra regular 9. */
	@Column (name = "tierra_regular_9")
	private Double tierraRegular9;
	
	/**  tierra malo 9. */
	@Column (name = "tierra_malo_9")
	private Double tierraMalo9;
	
	/**  pavim bueno 9. */
	@Column (name = "pavim_bueno_9")
	private Double pavimBueno9;
	
	/**  pavim regular 9. */
	@Column (name = "pavim_regular_9")
	private Double pavimRegular9;
	
	/**  pavim malo 9. */
	@Column (name = "pavim_malo_9")
	private Double pavimMalo9;
	
	/**  afirm bueno 10. */
	@Column (name = "afirm_bueno_10")
	private Double afirmBueno10;
	
	/**  afirm regular 10. */
	@Column (name = "afirm_regular_10")
	private Double afirmRegular10;
	
	/**  afirm malo 10. */
	@Column (name = "afirm_malo_10")
	private Double afirmMalo10;
	
	/**  tierra bueno 10. */
	@Column (name = "tierra_bueno_10")
	private Double tierraBueno10;
	
	/**  tierra regular 10. */
	@Column (name = "tierra_regular_10")
	private Double tierraRegular10;
	
	/**  tierra malo 10. */
	@Column (name = "tierra_malo_10")
	private Double tierraMalo10;
	
	/**  pavim bueno 10. */
	@Column (name = "pavim_bueno_10")
	private Double pavimBueno10;
	
	/**  pavim regular 10. */
	@Column (name = "pavim_regular_10")
	private Double pavimRegular10;
	
	/**  pavim malo 10. */
	@Column (name = "pavim_malo_10")
	private Double pavimMalo10;
	
	/**  anio actual. */
	@Column (name = "anio_actual")
	private BigDecimal anioActual;
	
	/**  anio reprogramacion. */
	@Column (name = "anio_reprogramacion")
	private BigDecimal anioReprogramacion;
	
	
	/**
	 * Obtiene id analisis precios.
	 *
	 * @return  id analisis precios
	 */
	public BigDecimal getIdAnalisisPrecios() {
		return idAnalisisPrecios;
	}
	
	/**
	 * Establece id analisis precios.
	 *
	 * @param idAnalisisPrecios  id analisis precios
	 */
	public void setIdAnalisisPrecios(BigDecimal idAnalisisPrecios) {
		this.idAnalisisPrecios = idAnalisisPrecios;
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
	 * Obtiene ipc.
	 *
	 * @return  ipc
	 */
	public Double getIpc() {
		return ipc;
	}
	
	/**
	 * Establece ipc.
	 *
	 * @param ipc  ipc
	 */
	public void setIpc(Double ipc) {
		this.ipc = ipc;
	}
	
	/**
	 * Obtiene afirm bueno 1.
	 *
	 * @return  afirm bueno 1
	 */
	public Double getAfirmBueno1() {
		return afirmBueno1;
	}
	
	/**
	 * Establece afirm bueno 1.
	 *
	 * @param afirmBueno1  afirm bueno 1
	 */
	public void setAfirmBueno1(Double afirmBueno1) {
		this.afirmBueno1 = afirmBueno1;
	}
	
	/**
	 * Obtiene afirm regular 1.
	 *
	 * @return  afirm regular 1
	 */
	public Double getAfirmRegular1() {
		return afirmRegular1;
	}
	
	/**
	 * Establece afirm regular 1.
	 *
	 * @param afirmRegular1  afirm regular 1
	 */
	public void setAfirmRegular1(Double afirmRegular1) {
		this.afirmRegular1 = afirmRegular1;
	}
	
	/**
	 * Obtiene afirm malo 1.
	 *
	 * @return  afirm malo 1
	 */
	public Double getAfirmMalo1() {
		return afirmMalo1;
	}
	
	/**
	 * Establece afirm malo 1.
	 *
	 * @param afirmMalo1  afirm malo 1
	 */
	public void setAfirmMalo1(Double afirmMalo1) {
		this.afirmMalo1 = afirmMalo1;
	}
	
	/**
	 * Obtiene tierra bueno 1.
	 *
	 * @return  tierra bueno 1
	 */
	public Double getTierraBueno1() {
		return tierraBueno1;
	}
	
	/**
	 * Establece tierra bueno 1.
	 *
	 * @param tierraBueno1  tierra bueno 1
	 */
	public void setTierraBueno1(Double tierraBueno1) {
		this.tierraBueno1 = tierraBueno1;
	}
	
	/**
	 * Obtiene tierra regular 1.
	 *
	 * @return  tierra regular 1
	 */
	public Double getTierraRegular1() {
		return tierraRegular1;
	}
	
	/**
	 * Establece tierra regular 1.
	 *
	 * @param tierraRegular1  tierra regular 1
	 */
	public void setTierraRegular1(Double tierraRegular1) {
		this.tierraRegular1 = tierraRegular1;
	}
	
	/**
	 * Obtiene tierra malo 1.
	 *
	 * @return  tierra malo 1
	 */
	public Double getTierraMalo1() {
		return tierraMalo1;
	}
	
	/**
	 * Establece tierra malo 1.
	 *
	 * @param tierraMalo1  tierra malo 1
	 */
	public void setTierraMalo1(Double tierraMalo1) {
		this.tierraMalo1 = tierraMalo1;
	}
	
	/**
	 * Obtiene pavim bueno 1.
	 *
	 * @return  pavim bueno 1
	 */
	public Double getPavimBueno1() {
		return pavimBueno1;
	}
	
	/**
	 * Establece pavim bueno 1.
	 *
	 * @param pavimBueno1  pavim bueno 1
	 */
	public void setPavimBueno1(Double pavimBueno1) {
		this.pavimBueno1 = pavimBueno1;
	}
	
	/**
	 * Obtiene pavim regular 1.
	 *
	 * @return  pavim regular 1
	 */
	public Double getPavimRegular1() {
		return pavimRegular1;
	}
	
	/**
	 * Establece pavim regular 1.
	 *
	 * @param pavimRegular1  pavim regular 1
	 */
	public void setPavimRegular1(Double pavimRegular1) {
		this.pavimRegular1 = pavimRegular1;
	}
	
	/**
	 * Obtiene pavim malo 1.
	 *
	 * @return  pavim malo 1
	 */
	public Double getPavimMalo1() {
		return pavimMalo1;
	}
	
	/**
	 * Establece pavim malo 1.
	 *
	 * @param pavimMalo1  pavim malo 1
	 */
	public void setPavimMalo1(Double pavimMalo1) {
		this.pavimMalo1 = pavimMalo1;
	}
	
	/**
	 * Obtiene afirm bueno 2.
	 *
	 * @return  afirm bueno 2
	 */
	public Double getAfirmBueno2() {
		return afirmBueno2;
	}
	
	/**
	 * Establece afirm bueno 2.
	 *
	 * @param afirmBueno2  afirm bueno 2
	 */
	public void setAfirmBueno2(Double afirmBueno2) {
		this.afirmBueno2 = afirmBueno2;
	}
	
	/**
	 * Obtiene afirm regular 2.
	 *
	 * @return  afirm regular 2
	 */
	public Double getAfirmRegular2() {
		return afirmRegular2;
	}
	
	/**
	 * Establece afirm regular 2.
	 *
	 * @param afirmRegular2  afirm regular 2
	 */
	public void setAfirmRegular2(Double afirmRegular2) {
		this.afirmRegular2 = afirmRegular2;
	}
	
	/**
	 * Obtiene afirm malo 2.
	 *
	 * @return  afirm malo 2
	 */
	public Double getAfirmMalo2() {
		return afirmMalo2;
	}
	
	/**
	 * Establece afirm malo 2.
	 *
	 * @param afirmMalo2  afirm malo 2
	 */
	public void setAfirmMalo2(Double afirmMalo2) {
		this.afirmMalo2 = afirmMalo2;
	}
	
	/**
	 * Obtiene tierra bueno 2.
	 *
	 * @return  tierra bueno 2
	 */
	public Double getTierraBueno2() {
		return tierraBueno2;
	}
	
	/**
	 * Establece tierra bueno 2.
	 *
	 * @param tierraBueno2  tierra bueno 2
	 */
	public void setTierraBueno2(Double tierraBueno2) {
		this.tierraBueno2 = tierraBueno2;
	}
	
	/**
	 * Obtiene tierra regular 2.
	 *
	 * @return  tierra regular 2
	 */
	public Double getTierraRegular2() {
		return tierraRegular2;
	}
	
	/**
	 * Establece tierra regular 2.
	 *
	 * @param tierraRegular2  tierra regular 2
	 */
	public void setTierraRegular2(Double tierraRegular2) {
		this.tierraRegular2 = tierraRegular2;
	}
	
	/**
	 * Obtiene tierra malo 2.
	 *
	 * @return  tierra malo 2
	 */
	public Double getTierraMalo2() {
		return tierraMalo2;
	}
	
	/**
	 * Establece tierra malo 2.
	 *
	 * @param tierraMalo2  tierra malo 2
	 */
	public void setTierraMalo2(Double tierraMalo2) {
		this.tierraMalo2 = tierraMalo2;
	}
	
	/**
	 * Obtiene pavim bueno 2.
	 *
	 * @return  pavim bueno 2
	 */
	public Double getPavimBueno2() {
		return pavimBueno2;
	}
	
	/**
	 * Establece pavim bueno 2.
	 *
	 * @param pavimBueno2  pavim bueno 2
	 */
	public void setPavimBueno2(Double pavimBueno2) {
		this.pavimBueno2 = pavimBueno2;
	}
	
	/**
	 * Obtiene pavim regular 2.
	 *
	 * @return  pavim regular 2
	 */
	public Double getPavimRegular2() {
		return pavimRegular2;
	}
	
	/**
	 * Establece pavim regular 2.
	 *
	 * @param pavimRegular2  pavim regular 2
	 */
	public void setPavimRegular2(Double pavimRegular2) {
		this.pavimRegular2 = pavimRegular2;
	}
	
	/**
	 * Obtiene pavim malo 2.
	 *
	 * @return  pavim malo 2
	 */
	public Double getPavimMalo2() {
		return pavimMalo2;
	}
	
	/**
	 * Establece pavim malo 2.
	 *
	 * @param pavimMalo2  pavim malo 2
	 */
	public void setPavimMalo2(Double pavimMalo2) {
		this.pavimMalo2 = pavimMalo2;
	}
	
	/**
	 * Obtiene afirm bueno 3.
	 *
	 * @return  afirm bueno 3
	 */
	public Double getAfirmBueno3() {
		return afirmBueno3;
	}
	
	/**
	 * Establece afirm bueno 3.
	 *
	 * @param afirmBueno3  afirm bueno 3
	 */
	public void setAfirmBueno3(Double afirmBueno3) {
		this.afirmBueno3 = afirmBueno3;
	}
	
	/**
	 * Obtiene afirm regular 3.
	 *
	 * @return  afirm regular 3
	 */
	public Double getAfirmRegular3() {
		return afirmRegular3;
	}
	
	/**
	 * Establece afirm regular 3.
	 *
	 * @param afirmRegular3  afirm regular 3
	 */
	public void setAfirmRegular3(Double afirmRegular3) {
		this.afirmRegular3 = afirmRegular3;
	}
	
	/**
	 * Obtiene afirm malo 3.
	 *
	 * @return  afirm malo 3
	 */
	public Double getAfirmMalo3() {
		return afirmMalo3;
	}
	
	/**
	 * Establece afirm malo 3.
	 *
	 * @param afirmMalo3  afirm malo 3
	 */
	public void setAfirmMalo3(Double afirmMalo3) {
		this.afirmMalo3 = afirmMalo3;
	}
	
	/**
	 * Obtiene tierra bueno 3.
	 *
	 * @return  tierra bueno 3
	 */
	public Double getTierraBueno3() {
		return tierraBueno3;
	}
	
	/**
	 * Establece tierra bueno 3.
	 *
	 * @param tierraBueno3  tierra bueno 3
	 */
	public void setTierraBueno3(Double tierraBueno3) {
		this.tierraBueno3 = tierraBueno3;
	}
	
	/**
	 * Obtiene tierra regular 3.
	 *
	 * @return  tierra regular 3
	 */
	public Double getTierraRegular3() {
		return tierraRegular3;
	}
	
	/**
	 * Establece tierra regular 3.
	 *
	 * @param tierraRegular3  tierra regular 3
	 */
	public void setTierraRegular3(Double tierraRegular3) {
		this.tierraRegular3 = tierraRegular3;
	}
	
	/**
	 * Obtiene tierra malo 3.
	 *
	 * @return  tierra malo 3
	 */
	public Double getTierraMalo3() {
		return tierraMalo3;
	}
	
	/**
	 * Establece tierra malo 3.
	 *
	 * @param tierraMalo3  tierra malo 3
	 */
	public void setTierraMalo3(Double tierraMalo3) {
		this.tierraMalo3 = tierraMalo3;
	}
	
	/**
	 * Obtiene pavim bueno 3.
	 *
	 * @return  pavim bueno 3
	 */
	public Double getPavimBueno3() {
		return pavimBueno3;
	}
	
	/**
	 * Establece pavim bueno 3.
	 *
	 * @param pavimBueno3  pavim bueno 3
	 */
	public void setPavimBueno3(Double pavimBueno3) {
		this.pavimBueno3 = pavimBueno3;
	}
	
	/**
	 * Obtiene pavim regular 3.
	 *
	 * @return  pavim regular 3
	 */
	public Double getPavimRegular3() {
		return pavimRegular3;
	}
	
	/**
	 * Establece pavim regular 3.
	 *
	 * @param pavimRegular3  pavim regular 3
	 */
	public void setPavimRegular3(Double pavimRegular3) {
		this.pavimRegular3 = pavimRegular3;
	}
	
	/**
	 * Obtiene pavim malo 3.
	 *
	 * @return  pavim malo 3
	 */
	public Double getPavimMalo3() {
		return pavimMalo3;
	}
	
	/**
	 * Establece pavim malo 3.
	 *
	 * @param pavimMalo3  pavim malo 3
	 */
	public void setPavimMalo3(Double pavimMalo3) {
		this.pavimMalo3 = pavimMalo3;
	}
	
	/**
	 * Obtiene afirm bueno 4.
	 *
	 * @return  afirm bueno 4
	 */
	public Double getAfirmBueno4() {
		return afirmBueno4;
	}
	
	/**
	 * Establece afirm bueno 4.
	 *
	 * @param afirmBueno4  afirm bueno 4
	 */
	public void setAfirmBueno4(Double afirmBueno4) {
		this.afirmBueno4 = afirmBueno4;
	}
	
	/**
	 * Obtiene afirm regular 4.
	 *
	 * @return  afirm regular 4
	 */
	public Double getAfirmRegular4() {
		return afirmRegular4;
	}
	
	/**
	 * Establece afirm regular 4.
	 *
	 * @param afirmRegular4  afirm regular 4
	 */
	public void setAfirmRegular4(Double afirmRegular4) {
		this.afirmRegular4 = afirmRegular4;
	}
	
	/**
	 * Obtiene afirm malo 4.
	 *
	 * @return  afirm malo 4
	 */
	public Double getAfirmMalo4() {
		return afirmMalo4;
	}
	
	/**
	 * Establece afirm malo 4.
	 *
	 * @param afirmMalo4  afirm malo 4
	 */
	public void setAfirmMalo4(Double afirmMalo4) {
		this.afirmMalo4 = afirmMalo4;
	}
	
	/**
	 * Obtiene tierra bueno 4.
	 *
	 * @return  tierra bueno 4
	 */
	public Double getTierraBueno4() {
		return tierraBueno4;
	}
	
	/**
	 * Establece tierra bueno 4.
	 *
	 * @param tierraBueno4  tierra bueno 4
	 */
	public void setTierraBueno4(Double tierraBueno4) {
		this.tierraBueno4 = tierraBueno4;
	}
	
	/**
	 * Obtiene tierra regular 4.
	 *
	 * @return  tierra regular 4
	 */
	public Double getTierraRegular4() {
		return tierraRegular4;
	}
	
	/**
	 * Establece tierra regular 4.
	 *
	 * @param tierraRegular4  tierra regular 4
	 */
	public void setTierraRegular4(Double tierraRegular4) {
		this.tierraRegular4 = tierraRegular4;
	}
	
	/**
	 * Obtiene tierra malo 4.
	 *
	 * @return  tierra malo 4
	 */
	public Double getTierraMalo4() {
		return tierraMalo4;
	}
	
	/**
	 * Establece tierra malo 4.
	 *
	 * @param tierraMalo4  tierra malo 4
	 */
	public void setTierraMalo4(Double tierraMalo4) {
		this.tierraMalo4 = tierraMalo4;
	}
	
	/**
	 * Obtiene pavim bueno 4.
	 *
	 * @return  pavim bueno 4
	 */
	public Double getPavimBueno4() {
		return pavimBueno4;
	}
	
	/**
	 * Establece pavim bueno 4.
	 *
	 * @param pavimBueno4  pavim bueno 4
	 */
	public void setPavimBueno4(Double pavimBueno4) {
		this.pavimBueno4 = pavimBueno4;
	}
	
	/**
	 * Obtiene pavim regular 4.
	 *
	 * @return  pavim regular 4
	 */
	public Double getPavimRegular4() {
		return pavimRegular4;
	}
	
	/**
	 * Establece pavim regular 4.
	 *
	 * @param pavimRegular4  pavim regular 4
	 */
	public void setPavimRegular4(Double pavimRegular4) {
		this.pavimRegular4 = pavimRegular4;
	}
	
	/**
	 * Obtiene pavim malo 4.
	 *
	 * @return  pavim malo 4
	 */
	public Double getPavimMalo4() {
		return pavimMalo4;
	}
	
	/**
	 * Establece pavim malo 4.
	 *
	 * @param pavimMalo4  pavim malo 4
	 */
	public void setPavimMalo4(Double pavimMalo4) {
		this.pavimMalo4 = pavimMalo4;
	}
	
	/**
	 * Obtiene afirm bueno 5.
	 *
	 * @return  afirm bueno 5
	 */
	public Double getAfirmBueno5() {
		return afirmBueno5;
	}
	
	/**
	 * Establece afirm bueno 5.
	 *
	 * @param afirmBueno5  afirm bueno 5
	 */
	public void setAfirmBueno5(Double afirmBueno5) {
		this.afirmBueno5 = afirmBueno5;
	}
	
	/**
	 * Obtiene afirm regular 5.
	 *
	 * @return  afirm regular 5
	 */
	public Double getAfirmRegular5() {
		return afirmRegular5;
	}
	
	/**
	 * Establece afirm regular 5.
	 *
	 * @param afirmRegular5  afirm regular 5
	 */
	public void setAfirmRegular5(Double afirmRegular5) {
		this.afirmRegular5 = afirmRegular5;
	}
	
	/**
	 * Obtiene afirm malo 5.
	 *
	 * @return  afirm malo 5
	 */
	public Double getAfirmMalo5() {
		return afirmMalo5;
	}
	
	/**
	 * Establece afirm malo 5.
	 *
	 * @param afirmMalo5  afirm malo 5
	 */
	public void setAfirmMalo5(Double afirmMalo5) {
		this.afirmMalo5 = afirmMalo5;
	}
	
	/**
	 * Obtiene tierra bueno 5.
	 *
	 * @return  tierra bueno 5
	 */
	public Double getTierraBueno5() {
		return tierraBueno5;
	}
	
	/**
	 * Establece tierra bueno 5.
	 *
	 * @param tierraBueno5  tierra bueno 5
	 */
	public void setTierraBueno5(Double tierraBueno5) {
		this.tierraBueno5 = tierraBueno5;
	}
	
	/**
	 * Obtiene tierra regular 5.
	 *
	 * @return  tierra regular 5
	 */
	public Double getTierraRegular5() {
		return tierraRegular5;
	}
	
	/**
	 * Establece tierra regular 5.
	 *
	 * @param tierraRegular5  tierra regular 5
	 */
	public void setTierraRegular5(Double tierraRegular5) {
		this.tierraRegular5 = tierraRegular5;
	}
	
	/**
	 * Obtiene tierra malo 5.
	 *
	 * @return  tierra malo 5
	 */
	public Double getTierraMalo5() {
		return tierraMalo5;
	}
	
	/**
	 * Establece tierra malo 5.
	 *
	 * @param tierraMalo5  tierra malo 5
	 */
	public void setTierraMalo5(Double tierraMalo5) {
		this.tierraMalo5 = tierraMalo5;
	}
	
	/**
	 * Obtiene pavim bueno 5.
	 *
	 * @return  pavim bueno 5
	 */
	public Double getPavimBueno5() {
		return pavimBueno5;
	}
	
	/**
	 * Establece pavim bueno 5.
	 *
	 * @param pavimBueno5  pavim bueno 5
	 */
	public void setPavimBueno5(Double pavimBueno5) {
		this.pavimBueno5 = pavimBueno5;
	}
	
	/**
	 * Obtiene pavim regular 5.
	 *
	 * @return  pavim regular 5
	 */
	public Double getPavimRegular5() {
		return pavimRegular5;
	}
	
	/**
	 * Establece pavim regular 5.
	 *
	 * @param pavimRegular5  pavim regular 5
	 */
	public void setPavimRegular5(Double pavimRegular5) {
		this.pavimRegular5 = pavimRegular5;
	}
	
	/**
	 * Obtiene pavim malo 5.
	 *
	 * @return  pavim malo 5
	 */
	public Double getPavimMalo5() {
		return pavimMalo5;
	}
	
	/**
	 * Establece pavim malo 5.
	 *
	 * @param pavimMalo5  pavim malo 5
	 */
	public void setPavimMalo5(Double pavimMalo5) {
		this.pavimMalo5 = pavimMalo5;
	}
	
	/**
	 * Obtiene afirm bueno 6.
	 *
	 * @return  afirm bueno 6
	 */
	public Double getAfirmBueno6() {
		return afirmBueno6;
	}
	
	/**
	 * Establece afirm bueno 6.
	 *
	 * @param afirmBueno6  afirm bueno 6
	 */
	public void setAfirmBueno6(Double afirmBueno6) {
		this.afirmBueno6 = afirmBueno6;
	}
	
	/**
	 * Obtiene afirm regular 6.
	 *
	 * @return  afirm regular 6
	 */
	public Double getAfirmRegular6() {
		return afirmRegular6;
	}
	
	/**
	 * Establece afirm regular 6.
	 *
	 * @param afirmRegular6  afirm regular 6
	 */
	public void setAfirmRegular6(Double afirmRegular6) {
		this.afirmRegular6 = afirmRegular6;
	}
	
	/**
	 * Obtiene afirm malo 6.
	 *
	 * @return  afirm malo 6
	 */
	public Double getAfirmMalo6() {
		return afirmMalo6;
	}
	
	/**
	 * Establece afirm malo 6.
	 *
	 * @param afirmMalo6  afirm malo 6
	 */
	public void setAfirmMalo6(Double afirmMalo6) {
		this.afirmMalo6 = afirmMalo6;
	}
	
	/**
	 * Obtiene tierra bueno 6.
	 *
	 * @return  tierra bueno 6
	 */
	public Double getTierraBueno6() {
		return tierraBueno6;
	}
	
	/**
	 * Establece tierra bueno 6.
	 *
	 * @param tierraBueno6  tierra bueno 6
	 */
	public void setTierraBueno6(Double tierraBueno6) {
		this.tierraBueno6 = tierraBueno6;
	}
	
	/**
	 * Obtiene tierra regular 6.
	 *
	 * @return  tierra regular 6
	 */
	public Double getTierraRegular6() {
		return tierraRegular6;
	}
	
	/**
	 * Establece tierra regular 6.
	 *
	 * @param tierraRegular6  tierra regular 6
	 */
	public void setTierraRegular6(Double tierraRegular6) {
		this.tierraRegular6 = tierraRegular6;
	}
	
	/**
	 * Obtiene tierra malo 6.
	 *
	 * @return  tierra malo 6
	 */
	public Double getTierraMalo6() {
		return tierraMalo6;
	}
	
	/**
	 * Establece tierra malo 6.
	 *
	 * @param tierraMalo6  tierra malo 6
	 */
	public void setTierraMalo6(Double tierraMalo6) {
		this.tierraMalo6 = tierraMalo6;
	}
	
	/**
	 * Obtiene pavim bueno 6.
	 *
	 * @return  pavim bueno 6
	 */
	public Double getPavimBueno6() {
		return pavimBueno6;
	}
	
	/**
	 * Establece pavim bueno 6.
	 *
	 * @param pavimBueno6  pavim bueno 6
	 */
	public void setPavimBueno6(Double pavimBueno6) {
		this.pavimBueno6 = pavimBueno6;
	}
	
	/**
	 * Obtiene pavim regular 6.
	 *
	 * @return  pavim regular 6
	 */
	public Double getPavimRegular6() {
		return pavimRegular6;
	}
	
	/**
	 * Establece pavim regular 6.
	 *
	 * @param pavimRegular6  pavim regular 6
	 */
	public void setPavimRegular6(Double pavimRegular6) {
		this.pavimRegular6 = pavimRegular6;
	}
	
	/**
	 * Obtiene pavim malo 6.
	 *
	 * @return  pavim malo 6
	 */
	public Double getPavimMalo6() {
		return pavimMalo6;
	}
	
	/**
	 * Establece pavim malo 6.
	 *
	 * @param pavimMalo6  pavim malo 6
	 */
	public void setPavimMalo6(Double pavimMalo6) {
		this.pavimMalo6 = pavimMalo6;
	}
	
	/**
	 * Obtiene afirm bueno 7.
	 *
	 * @return  afirm bueno 7
	 */
	public Double getAfirmBueno7() {
		return afirmBueno7;
	}
	
	/**
	 * Establece afirm bueno 7.
	 *
	 * @param afirmBueno7  afirm bueno 7
	 */
	public void setAfirmBueno7(Double afirmBueno7) {
		this.afirmBueno7 = afirmBueno7;
	}
	
	/**
	 * Obtiene afirm regular 7.
	 *
	 * @return  afirm regular 7
	 */
	public Double getAfirmRegular7() {
		return afirmRegular7;
	}
	
	/**
	 * Establece afirm regular 7.
	 *
	 * @param afirmRegular7  afirm regular 7
	 */
	public void setAfirmRegular7(Double afirmRegular7) {
		this.afirmRegular7 = afirmRegular7;
	}
	
	/**
	 * Obtiene afirm malo 7.
	 *
	 * @return  afirm malo 7
	 */
	public Double getAfirmMalo7() {
		return afirmMalo7;
	}
	
	/**
	 * Establece afirm malo 7.
	 *
	 * @param afirmMalo7  afirm malo 7
	 */
	public void setAfirmMalo7(Double afirmMalo7) {
		this.afirmMalo7 = afirmMalo7;
	}
	
	/**
	 * Obtiene tierra bueno 7.
	 *
	 * @return  tierra bueno 7
	 */
	public Double getTierraBueno7() {
		return tierraBueno7;
	}
	
	/**
	 * Establece tierra bueno 7.
	 *
	 * @param tierraBueno7  tierra bueno 7
	 */
	public void setTierraBueno7(Double tierraBueno7) {
		this.tierraBueno7 = tierraBueno7;
	}
	
	/**
	 * Obtiene tierra regular 7.
	 *
	 * @return  tierra regular 7
	 */
	public Double getTierraRegular7() {
		return tierraRegular7;
	}
	
	/**
	 * Establece tierra regular 7.
	 *
	 * @param tierraRegular7  tierra regular 7
	 */
	public void setTierraRegular7(Double tierraRegular7) {
		this.tierraRegular7 = tierraRegular7;
	}
	
	/**
	 * Obtiene tierra malo 7.
	 *
	 * @return  tierra malo 7
	 */
	public Double getTierraMalo7() {
		return tierraMalo7;
	}
	
	/**
	 * Establece tierra malo 7.
	 *
	 * @param tierraMalo7  tierra malo 7
	 */
	public void setTierraMalo7(Double tierraMalo7) {
		this.tierraMalo7 = tierraMalo7;
	}
	
	/**
	 * Obtiene pavim bueno 7.
	 *
	 * @return  pavim bueno 7
	 */
	public Double getPavimBueno7() {
		return pavimBueno7;
	}
	
	/**
	 * Establece pavim bueno 7.
	 *
	 * @param pavimBueno7  pavim bueno 7
	 */
	public void setPavimBueno7(Double pavimBueno7) {
		this.pavimBueno7 = pavimBueno7;
	}
	
	/**
	 * Obtiene pavim regular 7.
	 *
	 * @return  pavim regular 7
	 */
	public Double getPavimRegular7() {
		return pavimRegular7;
	}
	
	/**
	 * Establece pavim regular 7.
	 *
	 * @param pavimRegular7  pavim regular 7
	 */
	public void setPavimRegular7(Double pavimRegular7) {
		this.pavimRegular7 = pavimRegular7;
	}
	
	/**
	 * Obtiene pavim malo 7.
	 *
	 * @return  pavim malo 7
	 */
	public Double getPavimMalo7() {
		return pavimMalo7;
	}
	
	/**
	 * Establece pavim malo 7.
	 *
	 * @param pavimMalo7  pavim malo 7
	 */
	public void setPavimMalo7(Double pavimMalo7) {
		this.pavimMalo7 = pavimMalo7;
	}
	
	/**
	 * Obtiene afirm bueno 8.
	 *
	 * @return  afirm bueno 8
	 */
	public Double getAfirmBueno8() {
		return afirmBueno8;
	}
	
	/**
	 * Establece afirm bueno 8.
	 *
	 * @param afirmBueno8  afirm bueno 8
	 */
	public void setAfirmBueno8(Double afirmBueno8) {
		this.afirmBueno8 = afirmBueno8;
	}
	
	/**
	 * Obtiene afirm regular 8.
	 *
	 * @return  afirm regular 8
	 */
	public Double getAfirmRegular8() {
		return afirmRegular8;
	}
	
	/**
	 * Establece afirm regular 8.
	 *
	 * @param afirmRegular8  afirm regular 8
	 */
	public void setAfirmRegular8(Double afirmRegular8) {
		this.afirmRegular8 = afirmRegular8;
	}
	
	/**
	 * Obtiene afirm malo 8.
	 *
	 * @return  afirm malo 8
	 */
	public Double getAfirmMalo8() {
		return afirmMalo8;
	}
	
	/**
	 * Establece afirm malo 8.
	 *
	 * @param afirmMalo8  afirm malo 8
	 */
	public void setAfirmMalo8(Double afirmMalo8) {
		this.afirmMalo8 = afirmMalo8;
	}
	
	/**
	 * Obtiene tierra bueno 8.
	 *
	 * @return  tierra bueno 8
	 */
	public Double getTierraBueno8() {
		return tierraBueno8;
	}
	
	/**
	 * Establece tierra bueno 8.
	 *
	 * @param tierraBueno8  tierra bueno 8
	 */
	public void setTierraBueno8(Double tierraBueno8) {
		this.tierraBueno8 = tierraBueno8;
	}
	
	/**
	 * Obtiene tierra regular 8.
	 *
	 * @return  tierra regular 8
	 */
	public Double getTierraRegular8() {
		return tierraRegular8;
	}
	
	/**
	 * Establece tierra regular 8.
	 *
	 * @param tierraRegular8  tierra regular 8
	 */
	public void setTierraRegular8(Double tierraRegular8) {
		this.tierraRegular8 = tierraRegular8;
	}
	
	/**
	 * Obtiene tierra malo 8.
	 *
	 * @return  tierra malo 8
	 */
	public Double getTierraMalo8() {
		return tierraMalo8;
	}
	
	/**
	 * Establece tierra malo 8.
	 *
	 * @param tierraMalo8  tierra malo 8
	 */
	public void setTierraMalo8(Double tierraMalo8) {
		this.tierraMalo8 = tierraMalo8;
	}
	
	/**
	 * Obtiene pavim bueno 8.
	 *
	 * @return  pavim bueno 8
	 */
	public Double getPavimBueno8() {
		return pavimBueno8;
	}
	
	/**
	 * Establece pavim bueno 8.
	 *
	 * @param pavimBueno8  pavim bueno 8
	 */
	public void setPavimBueno8(Double pavimBueno8) {
		this.pavimBueno8 = pavimBueno8;
	}
	
	/**
	 * Obtiene pavim regular 8.
	 *
	 * @return  pavim regular 8
	 */
	public Double getPavimRegular8() {
		return pavimRegular8;
	}
	
	/**
	 * Establece pavim regular 8.
	 *
	 * @param pavimRegular8  pavim regular 8
	 */
	public void setPavimRegular8(Double pavimRegular8) {
		this.pavimRegular8 = pavimRegular8;
	}
	
	/**
	 * Obtiene pavim malo 8.
	 *
	 * @return  pavim malo 8
	 */
	public Double getPavimMalo8() {
		return pavimMalo8;
	}
	
	/**
	 * Establece pavim malo 8.
	 *
	 * @param pavimMalo8  pavim malo 8
	 */
	public void setPavimMalo8(Double pavimMalo8) {
		this.pavimMalo8 = pavimMalo8;
	}
	
	/**
	 * Obtiene afirm bueno 9.
	 *
	 * @return  afirm bueno 9
	 */
	public Double getAfirmBueno9() {
		return afirmBueno9;
	}
	
	/**
	 * Establece afirm bueno 9.
	 *
	 * @param afirmBueno9  afirm bueno 9
	 */
	public void setAfirmBueno9(Double afirmBueno9) {
		this.afirmBueno9 = afirmBueno9;
	}
	
	/**
	 * Obtiene afirm regular 9.
	 *
	 * @return  afirm regular 9
	 */
	public Double getAfirmRegular9() {
		return afirmRegular9;
	}
	
	/**
	 * Establece afirm regular 9.
	 *
	 * @param afirmRegular9  afirm regular 9
	 */
	public void setAfirmRegular9(Double afirmRegular9) {
		this.afirmRegular9 = afirmRegular9;
	}
	
	/**
	 * Obtiene afirm malo 9.
	 *
	 * @return  afirm malo 9
	 */
	public Double getAfirmMalo9() {
		return afirmMalo9;
	}
	
	/**
	 * Establece afirm malo 9.
	 *
	 * @param afirmMalo9  afirm malo 9
	 */
	public void setAfirmMalo9(Double afirmMalo9) {
		this.afirmMalo9 = afirmMalo9;
	}
	
	/**
	 * Obtiene tierra bueno 9.
	 *
	 * @return  tierra bueno 9
	 */
	public Double getTierraBueno9() {
		return tierraBueno9;
	}
	
	/**
	 * Establece tierra bueno 9.
	 *
	 * @param tierraBueno9  tierra bueno 9
	 */
	public void setTierraBueno9(Double tierraBueno9) {
		this.tierraBueno9 = tierraBueno9;
	}
	
	/**
	 * Obtiene tierra regular 9.
	 *
	 * @return  tierra regular 9
	 */
	public Double getTierraRegular9() {
		return tierraRegular9;
	}
	
	/**
	 * Establece tierra regular 9.
	 *
	 * @param tierraRegular9  tierra regular 9
	 */
	public void setTierraRegular9(Double tierraRegular9) {
		this.tierraRegular9 = tierraRegular9;
	}
	
	/**
	 * Obtiene tierra malo 9.
	 *
	 * @return  tierra malo 9
	 */
	public Double getTierraMalo9() {
		return tierraMalo9;
	}
	
	/**
	 * Establece tierra malo 9.
	 *
	 * @param tierraMalo9  tierra malo 9
	 */
	public void setTierraMalo9(Double tierraMalo9) {
		this.tierraMalo9 = tierraMalo9;
	}
	
	/**
	 * Obtiene pavim bueno 9.
	 *
	 * @return  pavim bueno 9
	 */
	public Double getPavimBueno9() {
		return pavimBueno9;
	}
	
	/**
	 * Establece pavim bueno 9.
	 *
	 * @param pavimBueno9  pavim bueno 9
	 */
	public void setPavimBueno9(Double pavimBueno9) {
		this.pavimBueno9 = pavimBueno9;
	}
	
	/**
	 * Obtiene pavim regular 9.
	 *
	 * @return  pavim regular 9
	 */
	public Double getPavimRegular9() {
		return pavimRegular9;
	}
	
	/**
	 * Establece pavim regular 9.
	 *
	 * @param pavimRegular9  pavim regular 9
	 */
	public void setPavimRegular9(Double pavimRegular9) {
		this.pavimRegular9 = pavimRegular9;
	}
	
	/**
	 * Obtiene pavim malo 9.
	 *
	 * @return  pavim malo 9
	 */
	public Double getPavimMalo9() {
		return pavimMalo9;
	}
	
	/**
	 * Establece pavim malo 9.
	 *
	 * @param pavimMalo9  pavim malo 9
	 */
	public void setPavimMalo9(Double pavimMalo9) {
		this.pavimMalo9 = pavimMalo9;
	}
	
	/**
	 * Obtiene afirm bueno 10.
	 *
	 * @return  afirm bueno 10
	 */
	public Double getAfirmBueno10() {
		return afirmBueno10;
	}
	
	/**
	 * Establece afirm bueno 10.
	 *
	 * @param afirmBueno10  afirm bueno 10
	 */
	public void setAfirmBueno10(Double afirmBueno10) {
		this.afirmBueno10 = afirmBueno10;
	}
	
	/**
	 * Obtiene afirm regular 10.
	 *
	 * @return  afirm regular 10
	 */
	public Double getAfirmRegular10() {
		return afirmRegular10;
	}
	
	/**
	 * Establece afirm regular 10.
	 *
	 * @param afirmRegular10  afirm regular 10
	 */
	public void setAfirmRegular10(Double afirmRegular10) {
		this.afirmRegular10 = afirmRegular10;
	}
	
	/**
	 * Obtiene afirm malo 10.
	 *
	 * @return  afirm malo 10
	 */
	public Double getAfirmMalo10() {
		return afirmMalo10;
	}
	
	/**
	 * Establece afirm malo 10.
	 *
	 * @param afirmMalo10  afirm malo 10
	 */
	public void setAfirmMalo10(Double afirmMalo10) {
		this.afirmMalo10 = afirmMalo10;
	}
	
	/**
	 * Obtiene tierra bueno 10.
	 *
	 * @return  tierra bueno 10
	 */
	public Double getTierraBueno10() {
		return tierraBueno10;
	}
	
	/**
	 * Establece tierra bueno 10.
	 *
	 * @param tierraBueno10  tierra bueno 10
	 */
	public void setTierraBueno10(Double tierraBueno10) {
		this.tierraBueno10 = tierraBueno10;
	}
	
	/**
	 * Obtiene tierra regular 10.
	 *
	 * @return  tierra regular 10
	 */
	public Double getTierraRegular10() {
		return tierraRegular10;
	}
	
	/**
	 * Establece tierra regular 10.
	 *
	 * @param tierraRegular10  tierra regular 10
	 */
	public void setTierraRegular10(Double tierraRegular10) {
		this.tierraRegular10 = tierraRegular10;
	}
	
	/**
	 * Obtiene tierra malo 10.
	 *
	 * @return  tierra malo 10
	 */
	public Double getTierraMalo10() {
		return tierraMalo10;
	}
	
	/**
	 * Establece tierra malo 10.
	 *
	 * @param tierraMalo10  tierra malo 10
	 */
	public void setTierraMalo10(Double tierraMalo10) {
		this.tierraMalo10 = tierraMalo10;
	}
	
	/**
	 * Obtiene pavim bueno 10.
	 *
	 * @return  pavim bueno 10
	 */
	public Double getPavimBueno10() {
		return pavimBueno10;
	}
	
	/**
	 * Establece pavim bueno 10.
	 *
	 * @param pavimBueno10  pavim bueno 10
	 */
	public void setPavimBueno10(Double pavimBueno10) {
		this.pavimBueno10 = pavimBueno10;
	}
	
	/**
	 * Obtiene pavim regular 10.
	 *
	 * @return  pavim regular 10
	 */
	public Double getPavimRegular10() {
		return pavimRegular10;
	}
	
	/**
	 * Establece pavim regular 10.
	 *
	 * @param pavimRegular10  pavim regular 10
	 */
	public void setPavimRegular10(Double pavimRegular10) {
		this.pavimRegular10 = pavimRegular10;
	}
	
	/**
	 * Obtiene pavim malo 10.
	 *
	 * @return  pavim malo 10
	 */
	public Double getPavimMalo10() {
		return pavimMalo10;
	}
	
	/**
	 * Establece pavim malo 10.
	 *
	 * @param pavimMalo10  pavim malo 10
	 */
	public void setPavimMalo10(Double pavimMalo10) {
		this.pavimMalo10 = pavimMalo10;
	}
	
	/**
	 * Obtiene anio actual.
	 *
	 * @return  anio actual
	 */
	public BigDecimal getAnioActual() {
		return anioActual;
	}
	
	/**
	 * Establece anio actual.
	 *
	 * @param anioActual  anio actual
	 */
	public void setAnioActual(BigDecimal anioActual) {
		this.anioActual = anioActual;
	}
	
	/**
	 * Obtiene anio reprogramacion.
	 *
	 * @return  anio reprogramacion
	 */
	public BigDecimal getAnioReprogramacion() {
		return anioReprogramacion;
	}
	
	/**
	 * Establece anio reprogramacion.
	 *
	 * @param anioReprogramacion  anio reprogramacion
	 */
	public void setAnioReprogramacion(BigDecimal anioReprogramacion) {
		this.anioReprogramacion = anioReprogramacion;
	}
}