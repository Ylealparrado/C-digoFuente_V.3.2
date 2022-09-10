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
 * Clase PoblacionPV.
 */
@Entity
@Table(name = "poblacion_pv")
public class PoblacionPV implements java.io.Serializable {

	/** Constante serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/**  id poblacion PV. */
	@Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_poblacion_pv") 
	private BigDecimal idPoblacionPV;
	
	/**  poblacion total veredas. */
	@Column(name = "poblacion_total_veredas") 	
	private BigDecimal poblacionTotalVeredas;
	
	/**  porc poblacion beneficiada. */
	@Column(name = "porc_poblacion_beneficiada") 	
	private Double porcPoblacionBeneficiada;
	
	/**  etnica indigena. */
	@Column(name = "etnica_indigena") 	
	private BigDecimal etnicaIndigena;
	
	/**  etnica rom. */
	@Column(name = "etnica_rom") 	
	private BigDecimal etnicaRom;
	
	/**  etnica raizal. */
	@Column(name = "etnica_raizal") 	
	private BigDecimal etnicaRaizal;
	
	/**  etnica color. */
	@Column(name = "etnica_color") 	
	private BigDecimal etnicaColor;
	
	/**  etnica total. */
	@Column(name = "etnica_total") 	
	private BigDecimal etnicaTotal;
		
	/**  porc poblacion diferencial beneficiada. */
	@Column(name = "porc_poblacion_diferencial_beneficiada") 	
	private Double porcPoblacionDiferencialBeneficiada;
	
	/**  promueve sustitucion cultivos. */
	@Column(name = "promueve_sustitucion_cultivos") 	
	private Boolean promueveSustitucionCultivos;
	
	/**  porc pob difer municipio. */
	@Column(name = "porc_pob_difer_municipio") 	
	private Boolean porcPobDiferMunicipio;
	
	/**  soc poblacion beneficiada PNVIR. */
	@ManyToOne 
	@JoinColumn(name="id_soc_poblacion_beneficiada_pnvir")
	private SocPoblacionBeneficiadaPNVIR socPoblacionBeneficiadaPNVIR;
	
	/**  soc icv PNVIR. */
	@ManyToOne 
	@JoinColumn(name="id_soc_icv_pnvir")
	private SocIcvPNVIR socIcvPNVIR;
	
	/**  soc poblacion diferencial PNVIR. */
	@ManyToOne 
	@JoinColumn(name="id_soc_poblacion_diferencial_pnvir")
	private SocPoblacionDiferencialPNVIR socPoblacionDiferencialPNVIR;
	
	/**  soc sustitucion cultivos PNVIR. */
	@ManyToOne 
	@JoinColumn(name="id_soc_sustitucion_cultivos_pnvir")
	private SocSustitucionCultivosPNVIR socSustitucionCultivosPNVIR;

	/**
	 * Obtiene id poblacion PV.
	 *
	 * @return  id poblacion PV
	 */
	public BigDecimal getIdPoblacionPV() {
		return idPoblacionPV;
	}

	/**
	 * Establece id poblacion PV.
	 *
	 * @param idPoblacionPV  id poblacion PV
	 */
	public void setIdPoblacionPV(BigDecimal idPoblacionPV) {
		this.idPoblacionPV = idPoblacionPV;
	}

	/**
	 * Obtiene poblacion total veredas.
	 *
	 * @return  poblacion total veredas
	 */
	public BigDecimal getPoblacionTotalVeredas() {
		return poblacionTotalVeredas;
	}

	/**
	 * Establece poblacion total veredas.
	 *
	 * @param poblacionTotalVeredas  poblacion total veredas
	 */
	public void setPoblacionTotalVeredas(BigDecimal poblacionTotalVeredas) {
		this.poblacionTotalVeredas = poblacionTotalVeredas;
	}

	/**
	 * Obtiene porc poblacion beneficiada.
	 *
	 * @return  porc poblacion beneficiada
	 */
	public Double getPorcPoblacionBeneficiada() {
		return porcPoblacionBeneficiada;
	}

	/**
	 * Establece porc poblacion beneficiada.
	 *
	 * @param porcPoblacionBeneficiada  porc poblacion beneficiada
	 */
	public void setPorcPoblacionBeneficiada(Double porcPoblacionBeneficiada) {
		this.porcPoblacionBeneficiada = porcPoblacionBeneficiada;
	}

	/**
	 * Obtiene etnica indigena.
	 *
	 * @return  etnica indigena
	 */
	public BigDecimal getEtnicaIndigena() {
		return etnicaIndigena;
	}

	/**
	 * Establece etnica indigena.
	 *
	 * @param etnicaIndigena  etnica indigena
	 */
	public void setEtnicaIndigena(BigDecimal etnicaIndigena) {
		this.etnicaIndigena = etnicaIndigena;
	}

	/**
	 * Obtiene etnica rom.
	 *
	 * @return  etnica rom
	 */
	public BigDecimal getEtnicaRom() {
		return etnicaRom;
	}

	/**
	 * Establece etnica rom.
	 *
	 * @param etnicaRom  etnica rom
	 */
	public void setEtnicaRom(BigDecimal etnicaRom) {
		this.etnicaRom = etnicaRom;
	}

	/**
	 * Obtiene etnica raizal.
	 *
	 * @return  etnica raizal
	 */
	public BigDecimal getEtnicaRaizal() {
		return etnicaRaizal;
	}

	/**
	 * Establece etnica raizal.
	 *
	 * @param etnicaRaizal  etnica raizal
	 */
	public void setEtnicaRaizal(BigDecimal etnicaRaizal) {
		this.etnicaRaizal = etnicaRaizal;
	}

	/**
	 * Obtiene etnica color.
	 *
	 * @return  etnica color
	 */
	public BigDecimal getEtnicaColor() {
		return etnicaColor;
	}

	/**
	 * Establece etnica color.
	 *
	 * @param etnicaColor  etnica color
	 */
	public void setEtnicaColor(BigDecimal etnicaColor) {
		this.etnicaColor = etnicaColor;
	}

	/**
	 * Obtiene etnica total.
	 *
	 * @return  etnica total
	 */
	public BigDecimal getEtnicaTotal() {
		return etnicaTotal;
	}

	/**
	 * Establece etnica total.
	 *
	 * @param etnicaTotal  etnica total
	 */
	public void setEtnicaTotal(BigDecimal etnicaTotal) {
		this.etnicaTotal = etnicaTotal;
	}

	/**
	 * Obtiene porc poblacion diferencial beneficiada.
	 *
	 * @return  porc poblacion diferencial beneficiada
	 */
	public Double getPorcPoblacionDiferencialBeneficiada() {
		return porcPoblacionDiferencialBeneficiada;
	}

	/**
	 * Establece porc poblacion diferencial beneficiada.
	 *
	 * @param porcPoblacionDiferencialBeneficiada  porc poblacion diferencial beneficiada
	 */
	public void setPorcPoblacionDiferencialBeneficiada(Double porcPoblacionDiferencialBeneficiada) {
		this.porcPoblacionDiferencialBeneficiada = porcPoblacionDiferencialBeneficiada;
	}

	/**
	 * Obtiene soc poblacion beneficiada PNVIR.
	 *
	 * @return  soc poblacion beneficiada PNVIR
	 */
	public SocPoblacionBeneficiadaPNVIR getSocPoblacionBeneficiadaPNVIR() {
		return socPoblacionBeneficiadaPNVIR;
	}

	/**
	 * Establece soc poblacion beneficiada PNVIR.
	 *
	 * @param socPoblacionBeneficiadaPNVIR  soc poblacion beneficiada PNVIR
	 */
	public void setSocPoblacionBeneficiadaPNVIR(SocPoblacionBeneficiadaPNVIR socPoblacionBeneficiadaPNVIR) {
		this.socPoblacionBeneficiadaPNVIR = socPoblacionBeneficiadaPNVIR;
	}

	/**
	 * Obtiene soc icv PNVIR.
	 *
	 * @return  soc icv PNVIR
	 */
	public SocIcvPNVIR getSocIcvPNVIR() {
		return socIcvPNVIR;
	}

	/**
	 * Establece soc icv PNVIR.
	 *
	 * @param socIcvPNVIR  soc icv PNVIR
	 */
	public void setSocIcvPNVIR(SocIcvPNVIR socIcvPNVIR) {
		this.socIcvPNVIR = socIcvPNVIR;
	}

	/**
	 * Obtiene soc poblacion diferencial PNVIR.
	 *
	 * @return  soc poblacion diferencial PNVIR
	 */
	public SocPoblacionDiferencialPNVIR getSocPoblacionDiferencialPNVIR() {
		return socPoblacionDiferencialPNVIR;
	}

	/**
	 * Establece soc poblacion diferencial PNVIR.
	 *
	 * @param socPoblacionDiferencialPNVIR  soc poblacion diferencial PNVIR
	 */
	public void setSocPoblacionDiferencialPNVIR(SocPoblacionDiferencialPNVIR socPoblacionDiferencialPNVIR) {
		this.socPoblacionDiferencialPNVIR = socPoblacionDiferencialPNVIR;
	}

	/**
	 * Obtiene soc sustitucion cultivos PNVIR.
	 *
	 * @return  soc sustitucion cultivos PNVIR
	 */
	public SocSustitucionCultivosPNVIR getSocSustitucionCultivosPNVIR() {
		return socSustitucionCultivosPNVIR;
	}

	/**
	 * Establece soc sustitucion cultivos PNVIR.
	 *
	 * @param socSustitucionCultivosPNVIR  soc sustitucion cultivos PNVIR
	 */
	public void setSocSustitucionCultivosPNVIR(SocSustitucionCultivosPNVIR socSustitucionCultivosPNVIR) {
		this.socSustitucionCultivosPNVIR = socSustitucionCultivosPNVIR;
	}

	/**
	 * Obtiene promueve sustitucion cultivos.
	 *
	 * @return  promueve sustitucion cultivos
	 */
	public Boolean getPromueveSustitucionCultivos() {
		return promueveSustitucionCultivos;
	}

	/**
	 * Establece promueve sustitucion cultivos.
	 *
	 * @param promueveSustitucionCultivos  promueve sustitucion cultivos
	 */
	public void setPromueveSustitucionCultivos(Boolean promueveSustitucionCultivos) {
		this.promueveSustitucionCultivos = promueveSustitucionCultivos;
	}

	/**
	 * Obtiene porc pob difer municipio.
	 *
	 * @return  porc pob difer municipio
	 */
	public Boolean getPorcPobDiferMunicipio() {
		return porcPobDiferMunicipio;
	}

	/**
	 * Establece porc pob difer municipio.
	 *
	 * @param porcPobDiferMunicipio  porc pob difer municipio
	 */
	public void setPorcPobDiferMunicipio(Boolean porcPobDiferMunicipio) {
		this.porcPobDiferMunicipio = porcPobDiferMunicipio;
	}
}