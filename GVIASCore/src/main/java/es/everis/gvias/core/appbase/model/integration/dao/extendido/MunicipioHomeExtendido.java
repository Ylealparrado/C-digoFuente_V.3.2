package es.everis.gvias.core.appbase.model.integration.dao.extendido;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import es.everis.gvias.core.appbase.common.utilidades.HibernateTransactionManager;
import es.everis.gvias.core.appbase.model.integration.dao.generado.Municipio;
import es.everis.gvias.core.appbase.model.integration.dao.generado.MunicipioHome;

// TODO: Auto-generated Javadoc
/**
 * Clase MunicipioHomeExtendido.
 */
public class MunicipioHomeExtendido extends MunicipioHome{

	/**
	 * Obtiene all.
	 *
	 * @return  all
	 */
	public List<Municipio> getAll() {
    	Session session = null;
    	 try {
	         session = HibernateTransactionManager.getCurrentSession();
	         return session.createCriteria(Municipio.class).list();
	   } catch (RuntimeException re) {
           throw re;
       }
	}
    	 
	 /**
 	 * Obtener municipios by dep id.
 	 *
 	 * @param depId the dep id
 	 * @return list
 	 */
 	public List<Municipio> obtenerMunicipiosByDepId(BigDecimal depId) {
	    	Session session = null;

	        try {
	            session = HibernateTransactionManager.getCurrentSession();
	            Criteria c = session.createCriteria(Municipio.class);
	            
	            c.add(Restrictions.eq("departamento.idDepartamento", depId));
	            c.addOrder(Order.asc("nombre"));
	            
	            List<Municipio> results = (List<Municipio>) c.list();
	            
	            for (Municipio mun : results) {
	            	Hibernate.initialize(mun.getDepartamento());
				}
	            
	            return results;
	        } catch (RuntimeException re) {
	            throw re;
	        }
		}
}