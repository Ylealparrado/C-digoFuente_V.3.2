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
 * Clase TecnicosPV.
 */
@Entity
@Table(name = "tecnicos_pv")
public class TecnicosPV implements java.io.Serializable {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/**  id tecnicos PV. */
	@Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tecnicos_pv") 
	private BigDecimal idTecnicosPV;
	
	/**  transp via primaria. */
	@Column(name = "transp_via_primaria")
	private Boolean transpViaPrimaria;
	
	/**  transp via primaria obs. */
	@Column(name = "transp_via_primaria_obs")
	private String transpViaPrimariaObs;
	
	/**  transp via secundaria. */
	@Column(name = "transp_via_secundaria")
	private Boolean transpViaSecundaria;
	
	/**  transp via secundaria obs. */
	@Column(name = "transp_via_secundaria_obs")
	private String transpViaSecundariaObs;
	
	/**  transp via terciaria. */
	@Column(name = "transp_via_terciaria")
	private Boolean transpViaTerciaria;
	
	/**  transp via terciaria obs. */
	@Column(name = "transp_via_terciaria_obs")
	private String transpViaTerciariaObs;
	
	/**  transp via fluvial. */
	@Column(name = "transp_via_fluvial")
	private Boolean transpViaFluvial;
	
	/**  transp via fluvial obs. */
	@Column(name = "transp_via_fluvial_obs")
	private String transpViaFluvialObs;
	
	/**  transp via aerea. */
	@Column(name = "transp_via_aerea")
	private Boolean transpViaAerea;
		
	/**  transp via aerea obs. */
	@Column(name = "transp_via_aerea_obs")
	private String transpViaAereaObs;

	/**  tec conectividad modal PNVIR. */
	@ManyToOne 
	@JoinColumn(name="id_tec_conectividad_modal_pnvir")
	private TecConectividadModalPNVIR tecConectividadModalPNVIR;
	
	/**  conect otros departamentos. */
	@Column(name = "conect_otros_departamentos")
	private Boolean conectOtrosDepartamentos;
	
	/**  conect otros departamentos obs. */
	@Column(name = "conect_otros_departamentos_obs")
	private String conectOtrosDepartamentosObs;
	
	/**  conect pdet zomac. */
	@Column(name = "conect_pdet_zomac")
	private Boolean conectPdetZomac;
	
	/**  conect pdet zomac obs. */
	@Column(name = "conect_pdet_zomac_obs")
	private String conectPdetZomacObs;
	
	/**  conect cabecera municipal. */
	@Column(name = "conect_cabecera_municipal")
	private Boolean conectCabeceraMunicipal;
	
	/**  conect cabecera municipal obs. */
	@Column(name = "conect_cabecera_municipal_obs")
	private String conectCabeceraMunicipalObs;
	
	/**  tec conectividad regional PNVIR. */
	@ManyToOne 
	@JoinColumn(name="id_tec_conectividad_regional_pnvir")
	private TecConectividadRegionalPNVIR tecConectividadRegionalPNVIR;

	/**
	 * Obtiene id tecnicos PV.
	 *
	 * @return  id tecnicos PV
	 */
	public BigDecimal getIdTecnicosPV() {
		return idTecnicosPV;
	}

	/**
	 * Establece id tecnicos PV.
	 *
	 * @param idTecnicosPV  id tecnicos PV
	 */
	public void setIdTecnicosPV(BigDecimal idTecnicosPV) {
		this.idTecnicosPV = idTecnicosPV;
	}

	/**
	 * Obtiene transp via primaria.
	 *
	 * @return  transp via primaria
	 */
	public Boolean getTranspViaPrimaria() {
		return transpViaPrimaria;
	}

	/**
	 * Establece transp via primaria.
	 *
	 * @param transpViaPrimaria  transp via primaria
	 */
	public void setTranspViaPrimaria(Boolean transpViaPrimaria) {
		this.transpViaPrimaria = transpViaPrimaria;
	}

	/**
	 * Obtiene transp via primaria obs.
	 *
	 * @return  transp via primaria obs
	 */
	public String getTranspViaPrimariaObs() {
		return transpViaPrimariaObs;
	}

	/**
	 * Establece transp via primaria obs.
	 *
	 * @param transpViaPrimariaObs  transp via primaria obs
	 */
	public void setTranspViaPrimariaObs(String transpViaPrimariaObs) {
		this.transpViaPrimariaObs = transpViaPrimariaObs;
	}

	/**
	 * Obtiene transp via secundaria.
	 *
	 * @return  transp via secundaria
	 */
	public Boolean getTranspViaSecundaria() {
		return transpViaSecundaria;
	}

	/**
	 * Establece transp via secundaria.
	 *
	 * @param transpViaSecundaria  transp via secundaria
	 */
	public void setTranspViaSecundaria(Boolean transpViaSecundaria) {
		this.transpViaSecundaria = transpViaSecundaria;
	}

	/**
	 * Obtiene transp via secundaria obs.
	 *
	 * @return  transp via secundaria obs
	 */
	public String getTranspViaSecundariaObs() {
		return transpViaSecundariaObs;
	}

	/**
	 * Establece transp via secundaria obs.
	 *
	 * @param transpViaSecundariaObs  transp via secundaria obs
	 */
	public void setTranspViaSecundariaObs(String transpViaSecundariaObs) {
		this.transpViaSecundariaObs = transpViaSecundariaObs;
	}

	/**
	 * Obtiene transp via terciaria.
	 *
	 * @return  transp via terciaria
	 */
	public Boolean getTranspViaTerciaria() {
		return transpViaTerciaria;
	}

	/**
	 * Establece transp via terciaria.
	 *
	 * @param transpViaTerciaria  transp via terciaria
	 */
	public void setTranspViaTerciaria(Boolean transpViaTerciaria) {
		this.transpViaTerciaria = transpViaTerciaria;
	}

	/**
	 * Obtiene transp via terciaria obs.
	 *
	 * @return  transp via terciaria obs
	 */
	public String getTranspViaTerciariaObs() {
		return transpViaTerciariaObs;
	}

	/**
	 * Establece transp via terciaria obs.
	 *
	 * @param transpViaTerciariaObs  transp via terciaria obs
	 */
	public void setTranspViaTerciariaObs(String transpViaTerciariaObs) {
		this.transpViaTerciariaObs = transpViaTerciariaObs;
	}

	/**
	 * Obtiene transp via fluvial.
	 *
	 * @return  transp via fluvial
	 */
	public Boolean getTranspViaFluvial() {
		return transpViaFluvial;
	}

	/**
	 * Establece transp via fluvial.
	 *
	 * @param transpViaFluvial  transp via fluvial
	 */
	public void setTranspViaFluvial(Boolean transpViaFluvial) {
		this.transpViaFluvial = transpViaFluvial;
	}

	/**
	 * Obtiene transp via fluvial obs.
	 *
	 * @return  transp via fluvial obs
	 */
	public String getTranspViaFluvialObs() {
		return transpViaFluvialObs;
	}

	/**
	 * Establece transp via fluvial obs.
	 *
	 * @param transpViaFluvialObs  transp via fluvial obs
	 */
	public void setTranspViaFluvialObs(String transpViaFluvialObs) {
		this.transpViaFluvialObs = transpViaFluvialObs;
	}

	/**
	 * Obtiene transp via aerea.
	 *
	 * @return  transp via aerea
	 */
	public Boolean getTranspViaAerea() {
		return transpViaAerea;
	}

	/**
	 * Establece transp via aerea.
	 *
	 * @param transpViaAerea  transp via aerea
	 */
	public void setTranspViaAerea(Boolean transpViaAerea) {
		this.transpViaAerea = transpViaAerea;
	}

	/**
	 * Obtiene transp via aerea obs.
	 *
	 * @return  transp via aerea obs
	 */
	public String getTranspViaAereaObs() {
		return transpViaAereaObs;
	}

	/**
	 * Establece transp via aerea obs.
	 *
	 * @param transpViaAereaObs  transp via aerea obs
	 */
	public void setTranspViaAereaObs(String transpViaAereaObs) {
		this.transpViaAereaObs = transpViaAereaObs;
	}

	/**
	 * Obtiene tec conectividad modal PNVIR.
	 *
	 * @return  tec conectividad modal PNVIR
	 */
	public TecConectividadModalPNVIR getTecConectividadModalPNVIR() {
		return tecConectividadModalPNVIR;
	}

	/**
	 * Establece tec conectividad modal PNVIR.
	 *
	 * @param tecConectividadModalPNVIR  tec conectividad modal PNVIR
	 */
	public void setTecConectividadModalPNVIR(TecConectividadModalPNVIR tecConectividadModalPNVIR) {
		this.tecConectividadModalPNVIR = tecConectividadModalPNVIR;
	}

	/**
	 * Obtiene conect otros departamentos.
	 *
	 * @return  conect otros departamentos
	 */
	public Boolean getConectOtrosDepartamentos() {
		return conectOtrosDepartamentos;
	}

	/**
	 * Establece conect otros departamentos.
	 *
	 * @param conectOtrosDepartamentos  conect otros departamentos
	 */
	public void setConectOtrosDepartamentos(Boolean conectOtrosDepartamentos) {
		this.conectOtrosDepartamentos = conectOtrosDepartamentos;
	}

	/**
	 * Obtiene conect otros departamentos obs.
	 *
	 * @return  conect otros departamentos obs
	 */
	public String getConectOtrosDepartamentosObs() {
		return conectOtrosDepartamentosObs;
	}

	/**
	 * Establece conect otros departamentos obs.
	 *
	 * @param conectOtrosDepartamentosObs  conect otros departamentos obs
	 */
	public void setConectOtrosDepartamentosObs(String conectOtrosDepartamentosObs) {
		this.conectOtrosDepartamentosObs = conectOtrosDepartamentosObs;
	}

	/**
	 * Obtiene conect pdet zomac.
	 *
	 * @return  conect pdet zomac
	 */
	public Boolean getConectPdetZomac() {
		return conectPdetZomac;
	}

	/**
	 * Establece conect pdet zomac.
	 *
	 * @param conectPdetZomac  conect pdet zomac
	 */
	public void setConectPdetZomac(Boolean conectPdetZomac) {
		this.conectPdetZomac = conectPdetZomac;
	}

	/**
	 * Obtiene conect pdet zomac obs.
	 *
	 * @return  conect pdet zomac obs
	 */
	public String getConectPdetZomacObs() {
		return conectPdetZomacObs;
	}

	/**
	 * Establece conect pdet zomac obs.
	 *
	 * @param conectPdetZomacObs  conect pdet zomac obs
	 */
	public void setConectPdetZomacObs(String conectPdetZomacObs) {
		this.conectPdetZomacObs = conectPdetZomacObs;
	}

	/**
	 * Obtiene conect cabecera municipal.
	 *
	 * @return  conect cabecera municipal
	 */
	public Boolean getConectCabeceraMunicipal() {
		return conectCabeceraMunicipal;
	}

	/**
	 * Establece conect cabecera municipal.
	 *
	 * @param conectCabeceraMunicipal  conect cabecera municipal
	 */
	public void setConectCabeceraMunicipal(Boolean conectCabeceraMunicipal) {
		this.conectCabeceraMunicipal = conectCabeceraMunicipal;
	}

	/**
	 * Obtiene conect cabecera municipal obs.
	 *
	 * @return  conect cabecera municipal obs
	 */
	public String getConectCabeceraMunicipalObs() {
		return conectCabeceraMunicipalObs;
	}

	/**
	 * Establece conect cabecera municipal obs.
	 *
	 * @param conectCabeceraMunicipalObs  conect cabecera municipal obs
	 */
	public void setConectCabeceraMunicipalObs(String conectCabeceraMunicipalObs) {
		this.conectCabeceraMunicipalObs = conectCabeceraMunicipalObs;
	}

	/**
	 * Obtiene tec conectividad regional PNVIR.
	 *
	 * @return  tec conectividad regional PNVIR
	 */
	public TecConectividadRegionalPNVIR getTecConectividadRegionalPNVIR() {
		return tecConectividadRegionalPNVIR;
	}

	/**
	 * Establece tec conectividad regional PNVIR.
	 *
	 * @param tecConectividadRegionalPNVIR  tec conectividad regional PNVIR
	 */
	public void setTecConectividadRegionalPNVIR(TecConectividadRegionalPNVIR tecConectividadRegionalPNVIR) {
		this.tecConectividadRegionalPNVIR = tecConectividadRegionalPNVIR;
	}
	
	
}