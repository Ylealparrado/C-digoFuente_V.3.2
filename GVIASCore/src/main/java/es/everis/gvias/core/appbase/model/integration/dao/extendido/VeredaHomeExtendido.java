package es.everis.gvias.core.appbase.model.integration.dao.extendido;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import es.everis.gvias.core.appbase.common.utilidades.HibernateTransactionManager;
import es.everis.gvias.core.appbase.model.integration.dao.generado.Vereda;
import es.everis.gvias.core.appbase.model.integration.dao.generado.VeredaHome;

// TODO: Auto-generated Javadoc
/**
 * Clase VeredaHomeExtendido.
 */
public class VeredaHomeExtendido extends VeredaHome{

	/**
	 * Obtiene all.
	 *
	 * @return  all
	 */
	public List<Vereda> getAll() {
    	Session session = null;
    	 try {
	         session = HibernateTransactionManager.getCurrentSession();
	         return session.createCriteria(Vereda.class).list();
	   } catch (RuntimeException re) {
           throw re;
       }
	}

	/**
	 * Obtener veredas por municipio.
	 *
	 * @param idMunicipio the id municipio
	 * @return list
	 */
	public List<Vereda> obtenerVeredasPorMunicipio(BigDecimal idMunicipio) {
	    	Session session = null;

	        try {
	            session = HibernateTransactionManager.getCurrentSession();
	            Criteria c = session.createCriteria(Vereda.class);
	            
	            c.createAlias("municipio", "municipio");
	            c.add(Restrictions.eq("municipio.idMunicipio", idMunicipio));
	            c.addOrder(Order.asc("nombre"));
	            
	            List<Vereda> results = (List<Vereda>) c.list();
	            return results;
	        } catch (RuntimeException re) {
	            throw re;
	        }
	}
}