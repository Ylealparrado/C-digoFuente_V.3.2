package es.everis.gvias.core.appbase.model.integration.dao.extendido;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

import es.everis.gvias.core.appbase.common.utilidades.HibernateTransactionManager;
import es.everis.gvias.core.appbase.model.integration.dao.generado.Via;
import es.everis.gvias.core.appbase.model.integration.dao.generado.ViaHome;

// TODO: Auto-generated Javadoc
/**
 * Clase ViaHomeExtendido.
 */
public class ViaHomeExtendido extends ViaHome{

	/**
	 * Obtiene all.
	 *
	 * @return  all
	 */
	public List<Via> getAll() {
    	Session session = null;
    	 try {
	         session = HibernateTransactionManager.getCurrentSession();
	         return session.createCriteria(Via.class).list();
	   } catch (RuntimeException re) {
           throw re;
       }
	}

	/**
	 * Obtener vias por municipio.
	 *
	 * @param idMunicipio the id municipio
	 * @return list
	 */
	public List<Via> obtenerViasPorMunicipio(BigDecimal idMunicipio) {
	    	Session session = null;

	        try {
	            session = HibernateTransactionManager.getCurrentSession();
	            Criteria c = session.createCriteria(Via.class);
	            
	            c.createAlias("municipio", "municipio");
	            c.add(Restrictions.eq("municipio.idMunicipio", idMunicipio));
//	            if (isPlanVial) {
//	            	c.addOrder(Order.asc("prioridadPv"));
//	            }
	            c.addOrder(Order.asc("codVia"));
	            
	            List<Via> results = (List<Via>) c.list();
	            return results;
	        } catch (RuntimeException re) {
	            throw re;
	        }
	}

	/**
	 * Obtener numero vias por municipio.
	 *
	 * @param idMunicipio the id municipio
	 * @return integer
	 */
	public Integer obtenerNumeroViasPorMunicipio(BigDecimal idMunicipio) {
    	Session session = null;

        try {
            session = HibernateTransactionManager.getCurrentSession();
            Criteria c = session.createCriteria(Via.class);
            
            c.createAlias("municipio", "municipio");
            c.add(Restrictions.eq("municipio.idMunicipio", idMunicipio));

        	Integer totalResult = ((Number)c.setProjection(Projections.rowCount()).uniqueResult()).intValue();

            return totalResult;
        } catch (RuntimeException re) {
            throw re;
        }
}	

	/**
	 * Obtener vias con puntaje por municipio.
	 *
	 * @param idMunicipio the id municipio
	 * @return list
	 */
	public List<Via> obtenerViasConPuntajePorMunicipio(BigDecimal idMunicipio) {
    	Session session = null;

        try {
            session = HibernateTransactionManager.getCurrentSession();
            Criteria c = session.createCriteria(Via.class);
            
            c.createAlias("municipio", "municipio");
            c.add(Restrictions.eq("municipio.idMunicipio", idMunicipio));
            c.add(Restrictions.isNotNull("puntajeTotalPv"));
            
            List<Via> results = (List<Via>) c.list();
            return results;
        } catch (RuntimeException re) {
            throw re;
        }
	}
	
	/**
	 * Obtener veredas intersectas.
	 *
	 * @param codVia the cod via
	 * @return list
	 */
	public List<String> obtenerVeredasIntersectas(String codVia) {
    	Session session = null;
    	 try {
	         session = HibernateTransactionManager.getCurrentSession();
	         List<String> codigosVeredas = session.createSQLQuery("select c1.codigo_ver from geo_vereda c1, geo_inv_tramovia c2 where c2.codigovia = '"+codVia.trim()+"' and ST_Intersects( c1.geom, c2.geom)").list();
	         	         
	         return codigosVeredas;
	   } catch (RuntimeException re) {
           throw re;
       }
	}
	
	
	/**
	 * Obtener vias intersectas.
	 *
	 * @param codVia the cod via
	 * @param tipo the tipo
	 * @return list
	 */
	public List<String> obtenerViasIntersectas(String codVia, int tipo) {
    	Session session = null;
    	String capaVia = null, campoCodigo = null;
    	 try {
    		 
    		switch (tipo) {
    		case 1:
    			campoCodigo = "codigo_via";
				capaVia = "geo_via_primaria";
				break;
				
    		case 2:
    			campoCodigo = "codigo_via";
				capaVia = "geo_via_secundaria";
				break;
				
    		case 3:
    			campoCodigo = "codigovia";
				capaVia = "geo_inv_tramovia"; //terciarias
				break;

			default:
				break;
			}
	         session = HibernateTransactionManager.getCurrentSession();
	         //Aplicamos pequeño buffer porque hemos detectado que no coinciden exactamente las capas de vías
	         List<String> sectorViasIntersectas = session.createSQLQuery("select c1."+campoCodigo+" from "+capaVia+" c1, geo_inv_tramovia c2 where c2.codigovia = '"+codVia.trim()+"' and ST_Intersects( c1.geom, ST_BUFFER(c2.geom,0.00001))").list();
	         
	         return sectorViasIntersectas;
	   } catch (RuntimeException re) {
           throw re;
       }
	}

	/**
	 * Obtener PDET intersectos.
	 *
	 * @param codVia the cod via
	 * @return list
	 */
	public List<String> obtenerPDETIntersectos(String codVia) {
		Session session = null;
	
		 try {
	         session = HibernateTransactionManager.getCurrentSession();
	         List<String> idsPDET = session.createSQLQuery("select c1.id from geo_zona_pdet c1, geo_inv_tramovia c2 where c2.codigovia = '"+codVia.trim()+"' and ST_Intersects( c1.geom, c2.geom)").list();
	         	         
	         return idsPDET;
	   } catch (RuntimeException re) {
	       throw re;
	   }
	}

	/**
	 * Obtener departamentos intersectos.
	 *
	 * @param codVia the cod via
	 * @return list
	 */
	public List<String> obtenerDepartamentosIntersectos(String codVia) {
		Session session = null;
		
		 try {
	         session = HibernateTransactionManager.getCurrentSession();
	         List<String> codDepartamentos = session.createSQLQuery("select c1.decodigo from geo_departamento c1, geo_inv_tramovia c2 where c2.codigovia = '"+codVia.trim()+"' and ST_Intersects( c1.geom, c2.geom)").list();
	         	         
	         return codDepartamentos;
	   } catch (RuntimeException re) {
	       throw re;
	   }
	}
	
	/**
	 * Obtener municipios intersectos.
	 *
	 * @param codVia the cod via
	 * @return list
	 */
	public List<String> obtenerMunicipiosIntersectos(String codVia) {
		Session session = null;
		
		 try {
	         session = HibernateTransactionManager.getCurrentSession();
	         List<String> codMunicipios = session.createSQLQuery("select c1.mpcodigo from geo_municipio c1, geo_inv_tramovia c2 where c2.codigovia = '"+codVia.trim()+"' and ST_Intersects( c1.geom, c2.geom)").list();
	         	         
	         return codMunicipios;
	   } catch (RuntimeException re) {
	       throw re;
	   }
	}

	/**
	 * Obtener ambiental intersectos.
	 *
	 * @param codVia the cod via
	 * @param tipo the tipo
	 * @return list
	 */
	public List<String> obtenerAmbientalIntersectos(String codVia, int tipo) {
		Session session = null;
		String capa = null, campo = null;
		
		switch (tipo) {
		case 0:
			campo = "nombre";
			capa = "geo_ambiental_0_parque";
			break;
			
		case 1:
			campo = "nombre";
			capa = "geo_ambiental_1_interes";
			break;
			
		case 2:
			campo = "id";
			capa = "geo_ambiental_2_bosque";
			break;
			
		case 3:
			campo = "id";
			capa = "geo_ambiental_3_humeda";
			break;

		case 4:
			campo = "nombre";
			capa = "geo_ambiental_4_corredor";
			break;
			
		case 5:
			campo = "id";
			capa = "geo_ambiental_5_fauna";
			break;
		default:
			break;
		}
		
		 try {
	         session = HibernateTransactionManager.getCurrentSession();
	         List<String> ambientalIntersectos = session.createSQLQuery("select c1."+campo+" from "+capa+" c1, geo_inv_tramovia c2 where c2.codigovia = '"+codVia.trim()+"' and ST_Intersects( c1.geom, c2.geom)").list();
	         	         
	         return ambientalIntersectos;
	   } catch (RuntimeException re) {
	       throw re;
	   }
	}
	
	
	/**
	 * Obtener vias con poblacion por municipio.
	 *
	 * @param idMunicipio the id municipio
	 * @return list
	 */
	public List<Via> obtenerViasConPoblacionPorMunicipio(BigDecimal idMunicipio) {
    	Session session = null;

        try {
            session = HibernateTransactionManager.getCurrentSession();
            Criteria c = session.createCriteria(Via.class);
            
            c.createAlias("municipio", "municipio");
            c.add(Restrictions.eq("municipio.idMunicipio", idMunicipio));
            c.createAlias("poblacionPV", "poblacionPV");
            c.add(Restrictions.isNotNull("poblacionPV.porcPoblacionBeneficiada"));
            
            List<Via> results = (List<Via>) c.list();
            return results;
        } catch (RuntimeException re) {
            throw re;
        }
	}
	
	/**
	 * Obtiene all codigos via.
	 *
	 * @return  all codigos via
	 */
	public List<String> getAllCodigosVia() {
    	Session session = null;
    	 try {
	         session = HibernateTransactionManager.getCurrentSession();
	         return session.createCriteria(Via.class).setProjection(Projections.property("codVia")).list();
	   } catch (RuntimeException re) {
           throw re;
       }
	}
	
	/**
	 * Obtiene codigos via por municipio.
	 *
	 * @param idMunicipio the id municipio
	 * @return  codigos via por municipio
	 */
	public List<String> getCodigosViaPorMunicipio(BigDecimal idMunicipio) {
    	Session session = null;

        try {
            session = HibernateTransactionManager.getCurrentSession();
            Criteria c = session.createCriteria(Via.class);
            
            c.createAlias("municipio", "municipio");
            c.add(Restrictions.eq("municipio.idMunicipio", idMunicipio));
            c.setProjection(Projections.property("codVia"));
            
            List<String> results = (List<String>) c.list();
            return results;
        } catch (RuntimeException re) {
            throw re;
        }
}
}