package es.everis.gvias.core.appbase.model.biz;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;

import es.everis.gvias.core.appbase.common.utilidades.HibernateTransactionManager;
import es.everis.gvias.core.appbase.model.integration.dao.extendido.ActividadModeloTeoricoHomeExtendido;
import es.everis.gvias.core.appbase.model.integration.dao.extendido.AnalisisPreciosHomeExtendido;
import es.everis.gvias.core.appbase.model.integration.dao.extendido.CompetenciaHomeExtendido;
import es.everis.gvias.core.appbase.model.integration.dao.extendido.DepartamentoHomeExtendido;
import es.everis.gvias.core.appbase.model.integration.dao.extendido.EcoVolumenTraficoPNVIRHomeExtendido;
import es.everis.gvias.core.appbase.model.integration.dao.extendido.GeoTramoViaHomeExtendido;
import es.everis.gvias.core.appbase.model.integration.dao.extendido.MunicipioHomeExtendido;
import es.everis.gvias.core.appbase.model.integration.dao.extendido.ProductoRendimientoHomeExtendido;
import es.everis.gvias.core.appbase.model.integration.dao.extendido.VeredaHomeExtendido;
import es.everis.gvias.core.appbase.model.integration.dao.extendido.ViaHomeExtendido;
import es.everis.gvias.core.appbase.model.integration.dao.generado.ActividadModeloTeorico;
import es.everis.gvias.core.appbase.model.integration.dao.generado.ActividadModeloTeoricoHome;
import es.everis.gvias.core.appbase.model.integration.dao.generado.AnalisisPrecios;
import es.everis.gvias.core.appbase.model.integration.dao.generado.AnalisisPreciosHome;
import es.everis.gvias.core.appbase.model.integration.dao.generado.Categoria;
import es.everis.gvias.core.appbase.model.integration.dao.generado.CategoriaHome;
import es.everis.gvias.core.appbase.model.integration.dao.generado.Categorizacion;
import es.everis.gvias.core.appbase.model.integration.dao.generado.CategorizacionHome;
import es.everis.gvias.core.appbase.model.integration.dao.generado.Competencia;
import es.everis.gvias.core.appbase.model.integration.dao.generado.Departamento;
import es.everis.gvias.core.appbase.model.integration.dao.generado.DepartamentoHome;
import es.everis.gvias.core.appbase.model.integration.dao.generado.EcoComercializacionPNVIR;
import es.everis.gvias.core.appbase.model.integration.dao.generado.EcoComercializacionPNVIRHome;
import es.everis.gvias.core.appbase.model.integration.dao.generado.EcoRendimientoPNVIR;
import es.everis.gvias.core.appbase.model.integration.dao.generado.EcoRendimientoPNVIRHome;
import es.everis.gvias.core.appbase.model.integration.dao.generado.EcoVolumenTraficoPNVIR;
import es.everis.gvias.core.appbase.model.integration.dao.generado.GeoSeccionTransversal;
import es.everis.gvias.core.appbase.model.integration.dao.generado.GeoSeccionTransversalHome;
import es.everis.gvias.core.appbase.model.integration.dao.generado.GeoTramoVia;
import es.everis.gvias.core.appbase.model.integration.dao.generado.GeoTramoViaHome;
import es.everis.gvias.core.appbase.model.integration.dao.generado.Municipio;
import es.everis.gvias.core.appbase.model.integration.dao.generado.MunicipioHome;
import es.everis.gvias.core.appbase.model.integration.dao.generado.ProductoRendimiento;
import es.everis.gvias.core.appbase.model.integration.dao.generado.SocCentrosSocialesPNVIR;
import es.everis.gvias.core.appbase.model.integration.dao.generado.SocCentrosSocialesPNVIRHome;
import es.everis.gvias.core.appbase.model.integration.dao.generado.SocIcvPNVIR;
import es.everis.gvias.core.appbase.model.integration.dao.generado.SocIcvPNVIRHome;
import es.everis.gvias.core.appbase.model.integration.dao.generado.SocPoblacionBeneficiadaPNVIR;
import es.everis.gvias.core.appbase.model.integration.dao.generado.SocPoblacionBeneficiadaPNVIRHome;
import es.everis.gvias.core.appbase.model.integration.dao.generado.SocPoblacionDiferencialPNVIR;
import es.everis.gvias.core.appbase.model.integration.dao.generado.SocPoblacionDiferencialPNVIRHome;
import es.everis.gvias.core.appbase.model.integration.dao.generado.SocSustitucionCultivosPNVIR;
import es.everis.gvias.core.appbase.model.integration.dao.generado.SocSustitucionCultivosPNVIRHome;
import es.everis.gvias.core.appbase.model.integration.dao.generado.TecConectividadModalPNVIR;
import es.everis.gvias.core.appbase.model.integration.dao.generado.TecConectividadModalPNVIRHome;
import es.everis.gvias.core.appbase.model.integration.dao.generado.TecConectividadRegionalPNVIR;
import es.everis.gvias.core.appbase.model.integration.dao.generado.TecConectividadRegionalPNVIRHome;
import es.everis.gvias.core.appbase.model.integration.dao.generado.VCentroSaludVereda;
import es.everis.gvias.core.appbase.model.integration.dao.generado.VCentroSaludVeredaHome;
import es.everis.gvias.core.appbase.model.integration.dao.generado.VSedeEducativaVereda;
import es.everis.gvias.core.appbase.model.integration.dao.generado.VSedeEducativaVeredaHome;
import es.everis.gvias.core.appbase.model.integration.dao.generado.Vereda;
import es.everis.gvias.core.appbase.model.integration.dao.generado.VeredaHome;
import es.everis.gvias.core.appbase.model.integration.dao.generado.Via;
import es.everis.gvias.core.appbase.model.integration.dao.generado.ViaHome;

public class GestionVias implements Serializable{


	private static final long serialVersionUID = -3405667529032554889L;
	private static Logger logger = LogManager.getLogger();
	
	public List<Via> obtenerListaVias() {
		List<Via> vias = new ArrayList<Via>();
		
		final HibernateTransactionManager h = HibernateTransactionManager.getInstance();

		try {
			h.beginTransaction();

			vias = new ViaHomeExtendido().getAll();

			h.commit();
		} catch (HibernateException e) {
			try {
				h.rollback();
			} catch (Exception e1) {
				logger.error(e1.getMessage(), e1);
			}
			logger.error(e.getMessage(), e);
		}
		return vias;
	}
	
	public List<GeoTramoVia> obtenerListaGeoTramoVia() {
		List<GeoTramoVia> geoVias = new ArrayList<GeoTramoVia>();
		
		final HibernateTransactionManager h = HibernateTransactionManager.getInstance();

		try {
			h.beginTransaction();

			geoVias = new GeoTramoViaHomeExtendido().getAll();

			h.commit();
		} catch (HibernateException e) {
			try {
				h.rollback();
			} catch (Exception e1) {
				logger.error(e1.getMessage(), e1);
			}
			logger.error(e.getMessage(), e);
		}
		return geoVias;
	}
	
	public List<GeoTramoVia> obtenerGeoTramoViaPorMunicipio(String codMunicipio) {
		List<GeoTramoVia> geoVias = new ArrayList<GeoTramoVia>();
		
		final HibernateTransactionManager h = HibernateTransactionManager.getInstance();

		try {
			h.beginTransaction();

			GeoTramoVia filter = new GeoTramoVia();
			filter.setCodMunicipio(new BigDecimal(codMunicipio));
			geoVias = new GeoTramoViaHome().findByExample(filter);

			h.commit();
		} catch (HibernateException e) {
			try {
				h.rollback();
			} catch (Exception e1) {
				logger.error(e1.getMessage(), e1);
			}
			logger.error(e.getMessage(), e);
		}
		return geoVias;
	}
	
	
	public Via obtenerViaPorId(BigDecimal idVia, boolean isPlanVial) {
		Via via = new Via();
		
		final HibernateTransactionManager h = HibernateTransactionManager.getInstance();

		try {
			h.beginTransaction();

			via = new ViaHome().findById(idVia);
			if (via != null && via.getCategorizacion() != null) {
				Hibernate.initialize(via.getCategorizacion());
			}
			
			if (isPlanVial) {
				if (via != null && via.getMunicipio() != null) {
					Hibernate.initialize(via.getMunicipio());
				}
				if (via != null && via.getVeredas() != null) {
					Hibernate.initialize(via.getVeredas());
				}
				if (via != null && via.getCompetencia() != null) {
					Hibernate.initialize(via.getCompetencia());
				}
				if (via != null && via.getTecnicosPV() != null) {
					Hibernate.initialize(via.getTecnicosPV());
				}
				if (via != null && via.getPoblacionPV() != null) {
					Hibernate.initialize(via.getPoblacionPV());
				}
				if (via != null && via.getCentroSocialPV() != null) {
					Hibernate.initialize(via.getCentroSocialPV());
				}
				if (via != null && via.getAmbientalPV() != null) {
					Hibernate.initialize(via.getAmbientalPV());
				}
				if (via != null && via.getEconomicoPV() != null) {
					Hibernate.initialize(via.getEconomicoPV());
				}
				if (via != null && via.getProductividadPV() != null) {
					Hibernate.initialize(via.getProductividadPV());
					if (via.getProductividadPV().getProductoRendimiento() != null) {
						Hibernate.initialize(via.getProductividadPV().getProductoRendimiento());
					}
				}
				if (via != null && via.getIntervencionPV() != null) {
					Hibernate.initialize(via.getIntervencionPV());
				}
				if (via != null && via.getModeloTeoricoPV() != null) {
					Hibernate.initialize(via.getModeloTeoricoPV());
				}
			}
						
			h.commit();
		} catch (HibernateException e) {
			try {
				h.rollback();
			} catch (Exception e1) {
				logger.error(e1.getMessage(), e1);
			}
			logger.error(e.getMessage(), e);
		}
		return via;
	}

	public boolean actualizarVia(Via via) {
		boolean operacionOk = false;
		HibernateTransactionManager h = HibernateTransactionManager.getInstance();
		try {
			h.beginTransaction();
			
			
			new ViaHome().attachDirty(via);
			
			h.commit();
			operacionOk = true;
		} catch (HibernateException e) {
			try {
				h.rollback();
			} catch (Exception e1) {
				logger.error(e1.getMessage(), e1);
			}
			logger.error(e.getMessage(), e);
		}
		return operacionOk;
	}
	
	
	public boolean actualizarCategorizacion(Categorizacion categorizacion) {
		boolean operacionOk = false;
		HibernateTransactionManager h = HibernateTransactionManager.getInstance();
		try {
			h.beginTransaction();
			
			
			new CategorizacionHome().attachDirty(categorizacion);
			
			h.commit();
			operacionOk = true;
		} catch (HibernateException e) {
			try {
				h.rollback();
			} catch (Exception e1) {
				logger.error(e1.getMessage(), e1);
			}
			logger.error(e.getMessage(), e);
		}
		return operacionOk;
	}


		public List<Municipio> obtenerMunicipiosPorDepartamento(BigDecimal depId) {
		List<Municipio> municipios = new ArrayList<Municipio>();
		final HibernateTransactionManager h = HibernateTransactionManager.getInstance();

		try {
			h.beginTransaction();

			municipios = new MunicipioHomeExtendido().obtenerMunicipiosByDepId(depId);

			h.commit();
		} catch (HibernateException e) {
			try {
				h.rollback();
			} catch (Exception e1) {
				logger.error(e1.getMessage(), e1);
			}
			logger.error(e.getMessage(), e);
		}
		return municipios;
	}
		
		
		public List<Departamento> obtenerListaDepartamentos() {
			List<Departamento> departamentos = new ArrayList<Departamento>();
			final HibernateTransactionManager h = HibernateTransactionManager.getInstance();

			try {
				h.beginTransaction();

				departamentos = new DepartamentoHomeExtendido().getAll();

				h.commit();
			} catch (HibernateException e) {
				try {
					h.rollback();
				} catch (Exception e1) {
					logger.error(e1.getMessage(), e1);
				}
				logger.error(e.getMessage(), e);
			}
			return departamentos;
		}
		
		public List<Municipio> obtenerListaMunicipios() {
			List<Municipio> municipios = new ArrayList<Municipio>();
			final HibernateTransactionManager h = HibernateTransactionManager.getInstance();

			try {
				h.beginTransaction();

				municipios = new MunicipioHomeExtendido().getAll();

				h.commit();
			} catch (HibernateException e) {
				try {
					h.rollback();
				} catch (Exception e1) {
					logger.error(e1.getMessage(), e1);
				}
				logger.error(e.getMessage(), e);
			}
			return municipios;
		}


		public List<Via> obtenerViasPorMunicipio(BigDecimal idMunicipio, boolean isPlanVial) {
			List<Via> vias = new ArrayList<Via>();
			
			final HibernateTransactionManager h = HibernateTransactionManager.getInstance();

			try {
				h.beginTransaction();
				
				vias = new ViaHomeExtendido().obtenerViasPorMunicipio(idMunicipio);
				for (Via via : vias) {
					if (via != null && via.getCategorizacion() != null && via.getCategorizacion().getCategoria() != null) {
						Hibernate.initialize(via.getCategorizacion().getCategoria());
					}
					
					if (isPlanVial) {
						if (via != null && via.getIntervencionPV() != null) {
							Hibernate.initialize(via.getIntervencionPV());
						}
						if (via != null && via.getPoblacionPV() != null) {
							Hibernate.initialize(via.getPoblacionPV());
						}
						if (via != null && via.getTecnicosPV() != null) {
							Hibernate.initialize(via.getTecnicosPV());
						}
						if (via != null && via.getCentroSocialPV() != null) {
							Hibernate.initialize(via.getCentroSocialPV());
						}
						if (via != null && via.getEconomicoPV() != null) {
							Hibernate.initialize(via.getEconomicoPV());
						}
						if (via != null && via.getProductividadPV() != null) {
							Hibernate.initialize(via.getProductividadPV());
						}
						if (via != null && via.getModeloTeoricoPV() != null) {
							Hibernate.initialize(via.getModeloTeoricoPV());
						}
						if (via != null && via.getAnalisisEstimacion() != null) {
							Hibernate.initialize(via.getAnalisisEstimacion());
						}
						
					}
				}
				

				h.commit();
			} catch (HibernateException e) {
				try {
					h.rollback();
				} catch (Exception e1) {
					logger.error(e1.getMessage(), e1);
				}
				logger.error(e.getMessage(), e);
			}
			return vias;
		}


		public List<Vereda> obtenerVeredasPorMunicipio(BigDecimal munId) {
			List<Vereda> veredas = new ArrayList<Vereda>();
			
			final HibernateTransactionManager h = HibernateTransactionManager.getInstance();

			try {
				h.beginTransaction();
				
				veredas = new VeredaHomeExtendido().obtenerVeredasPorMunicipio(munId);

				h.commit();
			} catch (HibernateException e) {
				try {
					h.rollback();
				} catch (Exception e1) {
					logger.error(e1.getMessage(), e1);
				}
				logger.error(e.getMessage(), e);
			}
			return veredas;
		}


		public Categoria obtenerCategoriaPorId(BigDecimal catId) {
			Categoria categoria = new Categoria();
			
			final HibernateTransactionManager h = HibernateTransactionManager.getInstance();

			try {
				h.beginTransaction();

				categoria = new CategoriaHome().findById(catId);

				h.commit();
			} catch (HibernateException e) {
				try {
					h.rollback();
				} catch (Exception e1) {
					logger.error(e1.getMessage(), e1);
				}
				logger.error(e.getMessage(), e);
			}
			return categoria;
		}


		public List<Competencia> obtenerListaCompetencias() {
			List<Competencia> competencias = new ArrayList<Competencia>();
			final HibernateTransactionManager h = HibernateTransactionManager.getInstance();

			try {
				h.beginTransaction();

				competencias = new CompetenciaHomeExtendido().getAll();

				h.commit();
			} catch (HibernateException e) {
				try {
					h.rollback();
				} catch (Exception e1) {
					logger.error(e1.getMessage(), e1);
				}
				logger.error(e.getMessage(), e);
			}
			return competencias;
		}


		public TecConectividadModalPNVIR obtenerTecConectividadModalPNVIRPorDescripcion(String resultadoModal) {
			List<TecConectividadModalPNVIR> conectividadModalPNVIR = new ArrayList<TecConectividadModalPNVIR>();
			
			final HibernateTransactionManager h = HibernateTransactionManager.getInstance();

			try {
				h.beginTransaction();

				TecConectividadModalPNVIR filter = new TecConectividadModalPNVIR();
				filter.setDescripcion(resultadoModal);
				
				conectividadModalPNVIR = new TecConectividadModalPNVIRHome().findByExample(filter);

				h.commit();
			} catch (HibernateException e) {
				try {
					h.rollback();
				} catch (Exception e1) {
					logger.error(e1.getMessage(), e1);
				}
				logger.error(e.getMessage(), e);
			}
			
			if (!conectividadModalPNVIR.isEmpty()) {
				return conectividadModalPNVIR.get(0);
			}
			return null;
		}


		public TecConectividadRegionalPNVIR obtenerTecConectividadRegionalPNVIRPorDescripcion(String resultadoRegional) {
			List<TecConectividadRegionalPNVIR> conectividadRegionalPNVIR = new ArrayList<TecConectividadRegionalPNVIR>();
			
			final HibernateTransactionManager h = HibernateTransactionManager.getInstance();

			try {
				h.beginTransaction();

				TecConectividadRegionalPNVIR filter = new TecConectividadRegionalPNVIR();
				filter.setDescripcion(resultadoRegional);
				
				conectividadRegionalPNVIR = new TecConectividadRegionalPNVIRHome().findByExample(filter);

				h.commit();
			} catch (HibernateException e) {
				try {
					h.rollback();
				} catch (Exception e1) {
					logger.error(e1.getMessage(), e1);
				}
				logger.error(e.getMessage(), e);
			}
			
			if (!conectividadRegionalPNVIR.isEmpty()) {
				return conectividadRegionalPNVIR.get(0);
			}
			return null;
		}


		public SocPoblacionBeneficiadaPNVIR obtenerSocPoblacionBeneficiadaPNVIRPorDescripcion(String indicador) {
			List<SocPoblacionBeneficiadaPNVIR> socPoblacionBeneficiadaPNVIR = new ArrayList<SocPoblacionBeneficiadaPNVIR>();
			
			final HibernateTransactionManager h = HibernateTransactionManager.getInstance();

			try {
				h.beginTransaction();

				SocPoblacionBeneficiadaPNVIR filter = new SocPoblacionBeneficiadaPNVIR();
				filter.setDescripcion(indicador);
				
				socPoblacionBeneficiadaPNVIR = new SocPoblacionBeneficiadaPNVIRHome().findByExample(filter);

				h.commit();
			} catch (HibernateException e) {
				try {
					h.rollback();
				} catch (Exception e1) {
					logger.error(e1.getMessage(), e1);
				}
				logger.error(e.getMessage(), e);
			}
			
			if (!socPoblacionBeneficiadaPNVIR.isEmpty()) {
				return socPoblacionBeneficiadaPNVIR.get(0);
			}
			return null;
		}


		public SocPoblacionBeneficiadaPNVIR obtenerSocPoblacionBeneficiadaPNVIRPorId(BigDecimal idIndicador) {
			SocPoblacionBeneficiadaPNVIR socPoblacionBeneficiadaPNVIR = new SocPoblacionBeneficiadaPNVIR();
			
			final HibernateTransactionManager h = HibernateTransactionManager.getInstance();

			try {
				h.beginTransaction();

				socPoblacionBeneficiadaPNVIR = new SocPoblacionBeneficiadaPNVIRHome().findById(idIndicador);

				h.commit();
			} catch (HibernateException e) {
				try {
					h.rollback();
				} catch (Exception e1) {
					logger.error(e1.getMessage(), e1);
				}
				logger.error(e.getMessage(), e);
			}
			return socPoblacionBeneficiadaPNVIR;
		}


		public SocIcvPNVIR obtenerSocICVPNVIRPorId(BigDecimal idIndicador) {
			SocIcvPNVIR socIcvPNVIR = new SocIcvPNVIR();
			
			final HibernateTransactionManager h = HibernateTransactionManager.getInstance();

			try {
				h.beginTransaction();

				socIcvPNVIR = new SocIcvPNVIRHome().findById(idIndicador);

				h.commit();
			} catch (HibernateException e) {
				try {
					h.rollback();
				} catch (Exception e1) {
					logger.error(e1.getMessage(), e1);
				}
				logger.error(e.getMessage(), e);
			}
			return socIcvPNVIR;
		}


		public SocPoblacionDiferencialPNVIR obtenerSocPoblacionDiferencialPNVIRPorId(BigDecimal idIndicador) {
			SocPoblacionDiferencialPNVIR socPoblacionDiferencialPNVIR = new SocPoblacionDiferencialPNVIR();
			
			final HibernateTransactionManager h = HibernateTransactionManager.getInstance();

			try {
				h.beginTransaction();

				socPoblacionDiferencialPNVIR = new SocPoblacionDiferencialPNVIRHome().findById(idIndicador);

				h.commit();
			} catch (HibernateException e) {
				try {
					h.rollback();
				} catch (Exception e1) {
					logger.error(e1.getMessage(), e1);
				}
				logger.error(e.getMessage(), e);
			}
			return socPoblacionDiferencialPNVIR;
		}


		public SocSustitucionCultivosPNVIR obtenerSocSustitucionCultivosPNVIRPorId(BigDecimal idIndicador) {
			SocSustitucionCultivosPNVIR socSustitucionCultivosPNVIR = new SocSustitucionCultivosPNVIR();
			
			final HibernateTransactionManager h = HibernateTransactionManager.getInstance();

			try {
				h.beginTransaction();

				socSustitucionCultivosPNVIR = new SocSustitucionCultivosPNVIRHome().findById(idIndicador);

				h.commit();
			} catch (HibernateException e) {
				try {
					h.rollback();
				} catch (Exception e1) {
					logger.error(e1.getMessage(), e1);
				}
				logger.error(e.getMessage(), e);
			}
			return socSustitucionCultivosPNVIR;
		}


		public SocCentrosSocialesPNVIR obtenerSocCentrosSocialesPNVIRPorId(BigDecimal idIndicador) {
			SocCentrosSocialesPNVIR socCentrosSocialesPNVIR = new SocCentrosSocialesPNVIR();
			
			final HibernateTransactionManager h = HibernateTransactionManager.getInstance();

			try {
				h.beginTransaction();

				socCentrosSocialesPNVIR = new SocCentrosSocialesPNVIRHome().findById(idIndicador);

				h.commit();
			} catch (HibernateException e) {
				try {
					h.rollback();
				} catch (Exception e1) {
					logger.error(e1.getMessage(), e1);
				}
				logger.error(e.getMessage(), e);
			}
			return socCentrosSocialesPNVIR;
		}


		public List<EcoVolumenTraficoPNVIR> obternerListaVolumenesTrafico() {
			List<EcoVolumenTraficoPNVIR> volumenesTrafico = new ArrayList<EcoVolumenTraficoPNVIR>();
			final HibernateTransactionManager h = HibernateTransactionManager.getInstance();

			try {
				h.beginTransaction();

				volumenesTrafico = new EcoVolumenTraficoPNVIRHomeExtendido().getAll();

				h.commit();
			} catch (HibernateException e) {
				try {
					h.rollback();
				} catch (Exception e1) {
					logger.error(e1.getMessage(), e1);
				}
				logger.error(e.getMessage(), e);
			}
			return volumenesTrafico;
		}


		public EcoComercializacionPNVIR obtenerEcoComercializacionPNVIRPorId(BigDecimal idIndicador) {
			EcoComercializacionPNVIR ecoComercializacionPNVIR = new EcoComercializacionPNVIR();
			
			final HibernateTransactionManager h = HibernateTransactionManager.getInstance();

			try {
				h.beginTransaction();

				ecoComercializacionPNVIR = new EcoComercializacionPNVIRHome().findById(idIndicador);

				h.commit();
			} catch (HibernateException e) {
				try {
					h.rollback();
				} catch (Exception e1) {
					logger.error(e1.getMessage(), e1);
				}
				logger.error(e.getMessage(), e);
			}
			return ecoComercializacionPNVIR;
		}


		public List<ProductoRendimiento> obtenerListaCultivosPorMunicipio(BigDecimal municipioId) {
			List<ProductoRendimiento> productos = new ArrayList<ProductoRendimiento>();
			final HibernateTransactionManager h = HibernateTransactionManager.getInstance();

			try {
				h.beginTransaction();

				productos = new ProductoRendimientoHomeExtendido().obtenerListaCultivosPorMunicipio(municipioId);

				h.commit();
			} catch (HibernateException e) {
				try {
					h.rollback();
				} catch (Exception e1) {
					logger.error(e1.getMessage(), e1);
				}
				logger.error(e.getMessage(), e);
			}
			return productos;
		}


		public EcoRendimientoPNVIR obtenerEcocoRendimientoPNVIRPorId(BigDecimal idIndicadorProductividad) {
			EcoRendimientoPNVIR ecoRendimientoPNVIR = new EcoRendimientoPNVIR();
			
			final HibernateTransactionManager h = HibernateTransactionManager.getInstance();

			try {
				h.beginTransaction();

				ecoRendimientoPNVIR = new EcoRendimientoPNVIRHome().findById(idIndicadorProductividad);

				h.commit();
			} catch (HibernateException e) {
				try {
					h.rollback();
				} catch (Exception e1) {
					logger.error(e1.getMessage(), e1);
				}
				logger.error(e.getMessage(), e);
			}
			return ecoRendimientoPNVIR;
		}

		
		public List<Via> obtenerViasConPuntajePorMunicipio(BigDecimal idMunicipio) {
			List<Via> vias = new ArrayList<Via>();
			
			final HibernateTransactionManager h = HibernateTransactionManager.getInstance();

			try {
				h.beginTransaction();
				
				vias = new ViaHomeExtendido().obtenerViasConPuntajePorMunicipio(idMunicipio);				

				h.commit();
			} catch (HibernateException e) {
				try {
					h.rollback();
				} catch (Exception e1) {
					logger.error(e1.getMessage(), e1);
				}
				logger.error(e.getMessage(), e);
			}
			return vias;
		}
		
		public Integer obtenerNumeroViasPorMunicipio(BigDecimal idMunicipio) {
			Integer result = new Integer(0);	
			final HibernateTransactionManager h = HibernateTransactionManager.getInstance();

			try {
				h.beginTransaction();
				
				result = new ViaHomeExtendido().obtenerNumeroViasPorMunicipio(idMunicipio);		

				h.commit();
			} catch (HibernateException e) {
				try {
					h.rollback();
				} catch (Exception e1) {
					logger.error(e1.getMessage(), e1);
				}
				logger.error(e.getMessage(), e);
			}
			return result;
		}

		public void recalcularPrioridadesPVMunicipio(BigDecimal municipioId) {
			
			Integer intervalo1 = null; 
			Integer intervalo2 = null;
					
			//Obtener todas las vías del municipio que tengan puntos != null
			List<Via> listadoViasPuntuadas = obtenerViasConPuntajePorMunicipio(municipioId);
			
			//Para obtener los rangos de colores, dividimos el n de vías entre 3 y vamos formamos 3 intervalos iguales
			Integer numeroViasMunicipio = listadoViasPuntuadas.size();
			if (numeroViasMunicipio >= 3) {
				intervalo1 = Math.round(numeroViasMunicipio / 3); 
				intervalo2 = intervalo1*2;
			} else {
				intervalo1 = 1;
				intervalo2 = 3;
			}

			//Ordenar de mayor a menor
			Collections.sort(listadoViasPuntuadas, (x, y) -> y.getPuntajeTotalPv().compareTo(x.getPuntajeTotalPv()));
			//Asignar prioridad empezando en 1
			Integer prioridad = new Integer(1);
			BigDecimal prioridadAnterior = new BigDecimal(1);
			BigDecimal puntajeAnterior = new BigDecimal(-1);
			for (Via via : listadoViasPuntuadas) {
				if (via.getPuntajeTotalPv().equals(puntajeAnterior)) { //si el puntaje coincide se duplica la prioridad
					via.setPrioridadPv(prioridadAnterior);
				}else {
					via.setPrioridadPv(new BigDecimal(prioridad));
				}
				
				if (intervalo1 != null) {
					if (via.getPrioridadPv().intValue()  <= intervalo1) {
						via.setGrupoPrioridadPv(new BigDecimal(1));//Estrategico
					} else if (via.getPrioridadPv().intValue() <= intervalo2) {
						via.setGrupoPrioridadPv(new BigDecimal(2));//Medio
					}else {
						via.setGrupoPrioridadPv(new BigDecimal(3));//Bajo
					}
				}
				
  				actualizarVia(via);
				prioridad++;
				puntajeAnterior = via.getPuntajeTotalPv();
				prioridadAnterior = via.getPrioridadPv();
			}
		}
		
		
		public Municipio obtenerMunicipioPorId(BigDecimal idMunicipio) {
			Municipio municipio = new Municipio();
			
			final HibernateTransactionManager h = HibernateTransactionManager.getInstance();

			try {
				h.beginTransaction();

				municipio = new MunicipioHome().findById(idMunicipio);
							
				h.commit();
			} catch (HibernateException e) {
				try {
					h.rollback();
				} catch (Exception e1) {
					logger.error(e1.getMessage(), e1);
				}
				logger.error(e.getMessage(), e);
			}
			return municipio;
		}
		
		
		public boolean actualizarVereda(Vereda vereda) {
			boolean operacionOk = false;
			HibernateTransactionManager h = HibernateTransactionManager.getInstance();
			try {
				h.beginTransaction();
				
				new VeredaHome().attachDirty(vereda);
				
				h.commit();
				operacionOk = true;
			} catch (HibernateException e) {
				try {
					h.rollback();
				} catch (Exception e1) {
					logger.error(e1.getMessage(), e1);
				}
				logger.error(e.getMessage(), e);
			}
			return operacionOk;
		}
		
		public List<Vereda> obtenerVeredasIntersectas(String codVia) {
			List<String> codVeredasIntersectas = new ArrayList<String>();
			List<Vereda> veredasIntersectas = new ArrayList<Vereda>();
			
			final HibernateTransactionManager h = HibernateTransactionManager.getInstance();

			try {
				h.beginTransaction();

				codVeredasIntersectas = new ViaHomeExtendido().obtenerVeredasIntersectas(codVia);
				
				Vereda filter = new Vereda();
				for (String codVereda : codVeredasIntersectas) {
					filter.setCodVereda(codVereda);
					List<Vereda> veredas = new VeredaHome().findByExample(filter);
					veredasIntersectas.addAll(veredas);
				}
							
				h.commit();
			} catch (HibernateException e) {
				try {
					h.rollback();
				} catch (Exception e1) {
					logger.error(e1.getMessage(), e1);
				}
				logger.error(e.getMessage(), e);
			}
			return veredasIntersectas;
		}
		
		public List<String> obtenerViasIntersectas(String codVia, int tipo) {
			List<String> codViasIntersectas = new ArrayList<String>();
						
			final HibernateTransactionManager h = HibernateTransactionManager.getInstance();

			try {
				h.beginTransaction();

				codViasIntersectas = new ViaHomeExtendido().obtenerViasIntersectas(codVia, tipo);
									
				h.commit();
			} catch (HibernateException e) {
				try {
					h.rollback();
				} catch (Exception e1) {
					logger.error(e1.getMessage(), e1);
				}
				logger.error(e.getMessage(), e);
			}
			return codViasIntersectas;
		}


		public List<VSedeEducativaVereda> obtenerSedesEducativasAfectadas(Set<Vereda> veredas) {
			List<VSedeEducativaVereda> sedesEducativasAfectadas = new ArrayList<VSedeEducativaVereda>();
						
			final HibernateTransactionManager h = HibernateTransactionManager.getInstance();

			try {
				h.beginTransaction();
				
				for (Vereda vereda : veredas) {
					VSedeEducativaVereda filter = new VSedeEducativaVereda();
					filter.setCodigoVereda(vereda.getCodVereda());
					List<VSedeEducativaVereda> sedesAfectadas = new VSedeEducativaVeredaHome().findByExample(filter);
					sedesEducativasAfectadas.addAll(sedesAfectadas);
				}

				h.commit();
			} catch (HibernateException e) {
				try {
					h.rollback();
				} catch (Exception e1) {
					logger.error(e1.getMessage(), e1);
				}
				logger.error(e.getMessage(), e);
			}
			return sedesEducativasAfectadas;
		}
		
		public List<VCentroSaludVereda> obtenerCentrosSaludAfectados(Set<Vereda> veredas) {
			List<VCentroSaludVereda> centrosSaludAfectados = new ArrayList<VCentroSaludVereda>();
						
			final HibernateTransactionManager h = HibernateTransactionManager.getInstance();

			try {
				h.beginTransaction();
				
				for (Vereda vereda : veredas) {
					VCentroSaludVereda filter = new VCentroSaludVereda();
					filter.setCodigoVereda(vereda.getCodVereda());
					List<VCentroSaludVereda> centrosAfectados = new VCentroSaludVeredaHome().findByExample(filter);
					centrosSaludAfectados.addAll(centrosAfectados);
				}

				h.commit();
			} catch (HibernateException e) {
				try {
					h.rollback();
				} catch (Exception e1) {
					logger.error(e1.getMessage(), e1);
				}
				logger.error(e.getMessage(), e);
			}
			return centrosSaludAfectados;
		}


		public Boolean intersectaZonaPDET(String codVia) {
			Boolean intersectaPDET = false;
			List<String> idsPDETIntersectos = null;
			final HibernateTransactionManager h = HibernateTransactionManager.getInstance();

			try {
				h.beginTransaction();

				idsPDETIntersectos = new ViaHomeExtendido().obtenerPDETIntersectos(codVia);
				
				if (idsPDETIntersectos != null && idsPDETIntersectos.size() > 0) {
					intersectaPDET = true;
				}
							
				h.commit();
			} catch (HibernateException e) {
				try {
					h.rollback();
				} catch (Exception e1) {
					logger.error(e1.getMessage(), e1);
				}
				logger.error(e.getMessage(), e);
			}
			return intersectaPDET;
		}


		public List<Departamento> obtenerDepartamentosIntersectos(String codVia) {
			List<String> codDepartamentosIntersectos = new ArrayList<String>();
			List<Departamento> DepartamentosIntersectos = new ArrayList<Departamento>();
			
			final HibernateTransactionManager h = HibernateTransactionManager.getInstance();

			try {
				h.beginTransaction();

				codDepartamentosIntersectos = new ViaHomeExtendido().obtenerDepartamentosIntersectos(codVia);
				
				Departamento filter = new Departamento();
				for (String codDepartamento : codDepartamentosIntersectos) {
					filter.setCodDepartamento(codDepartamento);
					List<Departamento> departamentos = new DepartamentoHome().findByExample(filter);
					DepartamentosIntersectos.addAll(departamentos);
				}
							
				h.commit();
			} catch (HibernateException e) {
				try {
					h.rollback();
				} catch (Exception e1) {
					logger.error(e1.getMessage(), e1);
				}
				logger.error(e.getMessage(), e);
			}
			return DepartamentosIntersectos;
		}


		public List<Municipio> obtenerMunicipiosIntersectos(String codVia) {
			List<String> codMunicipiosIntersectos = new ArrayList<String>();
			List<Municipio> municipiosIntersectos = new ArrayList<Municipio>();
			
			final HibernateTransactionManager h = HibernateTransactionManager.getInstance();

			try {
				h.beginTransaction();

				codMunicipiosIntersectos = new ViaHomeExtendido().obtenerMunicipiosIntersectos(codVia);
				
				Municipio filter = new Municipio();
				for (String codMunicipio : codMunicipiosIntersectos) {
					filter.setCodMunicipio(codMunicipio);
					List<Municipio> municipios = new MunicipioHome().findByExample(filter);
					municipiosIntersectos.addAll(municipios);
				}
							
				h.commit();
			} catch (HibernateException e) {
				try {
					h.rollback();
				} catch (Exception e1) {
					logger.error(e1.getMessage(), e1);
				}
				logger.error(e.getMessage(), e);
			}
			return municipiosIntersectos;
		}


		public List<String> intersectaAmbiental(String codVia, int tipo) {
			List<String> ambientalIntersectos = null;
			final HibernateTransactionManager h = HibernateTransactionManager.getInstance();

			try {
				h.beginTransaction();

				ambientalIntersectos = new ViaHomeExtendido().obtenerAmbientalIntersectos(codVia, tipo);
							
				h.commit();
			} catch (HibernateException e) {
				try {
					h.rollback();
				} catch (Exception e1) {
					logger.error(e1.getMessage(), e1);
				}
				logger.error(e.getMessage(), e);
			}
			return ambientalIntersectos;
		}


		public List<Via> obtenerViasConPoblacionPorMunicipio(BigDecimal idMunicipio) {
			List<Via> vias = new ArrayList<Via>();
			
			final HibernateTransactionManager h = HibernateTransactionManager.getInstance();

			try {
				h.beginTransaction();
				
				vias = new ViaHomeExtendido().obtenerViasConPoblacionPorMunicipio(idMunicipio);
				for (Via via : vias) {
					if (via != null && via.getPoblacionPV() != null) {
						Hibernate.initialize(via.getPoblacionPV());
					}
				}
				

				h.commit();
			} catch (HibernateException e) {
				try {
					h.rollback();
				} catch (Exception e1) {
					logger.error(e1.getMessage(), e1);
				}
				logger.error(e.getMessage(), e);
			}
			return vias;
		}
		
		
		public List<String> obtenerListaCodigosVias() {
			List<String> codigos = new ArrayList<String>();
			
			final HibernateTransactionManager h = HibernateTransactionManager.getInstance();

			try {
				h.beginTransaction();

				codigos = new ViaHomeExtendido().getAllCodigosVia();

				h.commit();
			} catch (HibernateException e) {
				try {
					h.rollback();
				} catch (Exception e1) {
					logger.error(e1.getMessage(), e1);
				}
				logger.error(e.getMessage(), e);
			}
			return codigos;
		}
		
		
		public List<String> obtenerListaCodigosViasPorMunicipio(BigDecimal idMunicipio) {
			List<String> codigos = new ArrayList<String>();
			
			final HibernateTransactionManager h = HibernateTransactionManager.getInstance();

			try {
				h.beginTransaction();

				codigos = new ViaHomeExtendido().getCodigosViaPorMunicipio(idMunicipio);

				h.commit();
			} catch (HibernateException e) {
				try {
					h.rollback();
				} catch (Exception e1) {
					logger.error(e1.getMessage(), e1);
				}
				logger.error(e.getMessage(), e);
			}
			return codigos;
		}

		
		
		public Municipio obtenerMunicipioPorCodigo(String codMunicipio) {
			List<Municipio> municipios = new ArrayList<Municipio>();
			
			final HibernateTransactionManager h = HibernateTransactionManager.getInstance();

			try {
				h.beginTransaction();
				Municipio filter = new Municipio();
				filter.setCodMunicipio(codMunicipio);
				municipios = new MunicipioHome().findByExample(filter);

				h.commit();
			} catch (HibernateException e) {
				try {
					h.rollback();
				} catch (Exception e1) {
					logger.error(e1.getMessage(), e1);
				}
				logger.error(e.getMessage(), e);
			}
			if (municipios != null && municipios.size()>0) {
				return municipios.get(0);
			}
			return null;
		}

		public List<GeoSeccionTransversal> obtenerSeccionesVia(String codVia) {
			List<GeoSeccionTransversal> secciones = new ArrayList<GeoSeccionTransversal>();
			
			final HibernateTransactionManager h = HibernateTransactionManager.getInstance();

			try {
				h.beginTransaction();
				GeoSeccionTransversal filter = new GeoSeccionTransversal();
				filter.setCodVia(codVia);
				secciones = new GeoSeccionTransversalHome().findByExample(filter);

				h.commit();
			} catch (HibernateException e) {
				try {
					h.rollback();
				} catch (Exception e1) {
					logger.error(e1.getMessage(), e1);
				}
				logger.error(e.getMessage(), e);
			}
			return secciones;
		}

		public boolean existeCodigoVereda(String codVereda) {
			List<Vereda> veredas = new ArrayList<Vereda>();
			
			final HibernateTransactionManager h = HibernateTransactionManager.getInstance();

			try {
				h.beginTransaction();
				Vereda filter = new Vereda();
				filter.setCodVereda(codVereda);
				veredas = new VeredaHome().findByExample(filter);

				h.commit();
			} catch (HibernateException e) {
				try {
					h.rollback();
				} catch (Exception e1) {
					logger.error(e1.getMessage(), e1);
				}
				logger.error(e.getMessage(), e);
			}
			
			if (veredas.size() > 0) {
				return true;
			}
			return false;
		}

		public List<ActividadModeloTeorico> obtenerActividadesPorVia(BigDecimal viaId) {

			List<ActividadModeloTeorico> actividades = new ArrayList<ActividadModeloTeorico>();
			
			final HibernateTransactionManager h = HibernateTransactionManager.getInstance();

			try {
				h.beginTransaction();
				
				actividades = new ActividadModeloTeoricoHomeExtendido().obtenerActividadesPorVia(viaId);

				h.commit();
			} catch (HibernateException e) {
				try {
					h.rollback();
				} catch (Exception e1) {
					logger.error(e1.getMessage(), e1);
				}
				logger.error(e.getMessage(), e);
			}
			return actividades;
		}

		public boolean actualizarActividad(ActividadModeloTeorico actividad) {
			boolean operacionOk = false;
			HibernateTransactionManager h = HibernateTransactionManager.getInstance();
			try {
				h.beginTransaction();
				
				new ActividadModeloTeoricoHome().attachDirty(actividad);
				
				h.commit();
				operacionOk = true;
			} catch (HibernateException e) {
				try {
					h.rollback();
				} catch (Exception e1) {
					logger.error(e1.getMessage(), e1);
				}
				logger.error(e.getMessage(), e);
			}
			return operacionOk;
		}

		public boolean eliminarActividad(ActividadModeloTeorico actividad) {
			boolean operacionOk = false;
			HibernateTransactionManager h = HibernateTransactionManager.getInstance();
			try {
				h.beginTransaction();
				
				new ActividadModeloTeoricoHome().delete(actividad);
				
				h.commit();
				operacionOk = true;
			} catch (HibernateException e) {
				try {
					h.rollback();
				} catch (Exception e1) {
					logger.error(e1.getMessage(), e1);
				}
				logger.error(e.getMessage(), e);
			}
			return operacionOk;
		}
		
		public AnalisisPrecios obtenerPreciosPorMunicipio(BigDecimal idMunicipio) {
			AnalisisPrecios preciosMunicipio = new AnalisisPrecios();
			
			final HibernateTransactionManager h = HibernateTransactionManager.getInstance();

			try {
				h.beginTransaction();

				preciosMunicipio = new AnalisisPreciosHomeExtendido().obtenerPreciosByIdMunicipio(idMunicipio);

				h.commit();
			} catch (HibernateException e) {
				try {
					h.rollback();
				} catch (Exception e1) {
					logger.error(e1.getMessage(), e1);
				}
				logger.error(e.getMessage(), e);
			}
			return preciosMunicipio;
		}
		
		
		public boolean actualizarPrecios(AnalisisPrecios precios) {
			boolean operacionOk = false;
			HibernateTransactionManager h = HibernateTransactionManager.getInstance();
			try {
				h.beginTransaction();
				
				new AnalisisPreciosHome().attachDirty(precios);
				
				h.commit();
				operacionOk = true;
			} catch (HibernateException e) {
				try {
					h.rollback();
				} catch (Exception e1) {
					logger.error(e1.getMessage(), e1);
				}
				logger.error(e.getMessage(), e);
			}
			return operacionOk;
		}

		public List<ActividadModeloTeorico> obtenerActividadesPorVia(BigDecimal idVia, BigDecimal anioActual) {

			List<ActividadModeloTeorico> actividades = new ArrayList<ActividadModeloTeorico>();
			
			final HibernateTransactionManager h = HibernateTransactionManager.getInstance();

			try {
				h.beginTransaction();
				
				actividades = new ActividadModeloTeoricoHomeExtendido().obtenerActividadesPorViaYAnio(idVia, anioActual);

				h.commit();
			} catch (HibernateException e) {
				try {
					h.rollback();
				} catch (Exception e1) {
					logger.error(e1.getMessage(), e1);
				}
				logger.error(e.getMessage(), e);
			}
			return actividades;
		}

}