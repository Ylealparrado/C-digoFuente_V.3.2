package es.everis.gvias.core.appbase.model.integration.dao.extendido;

import java.util.List;

import org.hibernate.Session;

import es.everis.gvias.core.appbase.common.utilidades.HibernateTransactionManager;
import es.everis.gvias.core.appbase.model.integration.dao.generado.GeoTramoVia;
import es.everis.gvias.core.appbase.model.integration.dao.generado.GeoTramoViaHome;

// TODO: Auto-generated Javadoc
/**
 * Clase GeoTramoViaHomeExtendido.
 */
public class GeoTramoViaHomeExtendido extends GeoTramoViaHome{

	/**
	 * Obtiene all.
	 *
	 * @return  all
	 */
	public List<GeoTramoVia> getAll() {
    	Session session = null;
    	 try {
	         session = HibernateTransactionManager.getCurrentSession();
	         return session.createCriteria(GeoTramoVia.class).list();
	   } catch (RuntimeException re) {
           throw re;
       }
	}
	
}