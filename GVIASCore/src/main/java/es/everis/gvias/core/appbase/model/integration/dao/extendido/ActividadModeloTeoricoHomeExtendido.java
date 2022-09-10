package es.everis.gvias.core.appbase.model.integration.dao.extendido;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import es.everis.gvias.core.appbase.common.utilidades.HibernateTransactionManager;
import es.everis.gvias.core.appbase.model.integration.dao.generado.ActividadModeloTeorico;
import es.everis.gvias.core.appbase.model.integration.dao.generado.ActividadModeloTeoricoHome;
import es.everis.gvias.core.appbase.model.integration.dao.generado.Vereda;

// TODO: Auto-generated Javadoc
/**
 * Clase ActividadModeloTeoricoHomeExtendido.
 */
public class ActividadModeloTeoricoHomeExtendido extends ActividadModeloTeoricoHome{

	/**
	 * Obtiene all.
	 *
	 * @return  all
	 */
	public List<Vereda> getAll() {
    	Session session = null;
    	 try {
	         session = HibernateTransactionManager.getCurrentSession();
	         return session.createCriteria(ActividadModeloTeorico.class).list();
	   } catch (RuntimeException re) {
           throw re;
       }
	}

	/**
	 * Obtener actividades por via.
	 *
	 * @param idVia the id via
	 * @return list
	 */
	public List<ActividadModeloTeorico> obtenerActividadesPorVia(BigDecimal idVia) {
	    	Session session = null;

	        try {
	            session = HibernateTransactionManager.getCurrentSession();
	            Criteria c = session.createCriteria(ActividadModeloTeorico.class);
	            
	            c.createAlias("via", "via");
	            c.add(Restrictions.eq("via.idVia", idVia));
	            c.addOrder(Order.asc("fecha"));
	            
	            List<ActividadModeloTeorico> results = (List<ActividadModeloTeorico>) c.list();
	            return results;
	        } catch (RuntimeException re) {
	            throw re;
	        }
	}
	
	/**
	 * Obtener actividades por via Y anio.
	 *
	 * @param idVia the id via
	 * @param anio the anio
	 * @return list
	 */
	public List<ActividadModeloTeorico> obtenerActividadesPorViaYAnio(BigDecimal idVia, BigDecimal anio) {
    	Session session = null;
    	
    	Calendar calDesde = Calendar.getInstance();
    	calDesde.set(Calendar.YEAR, anio.intValue());
    	calDesde.set(Calendar.MONTH, 0);
    	calDesde.set(Calendar.DAY_OF_MONTH, 1);
    	Date desde = calDesde.getTime();
    	
    	Calendar calHasta = Calendar.getInstance();
    	calHasta.set(Calendar.YEAR, anio.intValue());
    	calHasta.set(Calendar.MONTH, 11);
    	calHasta.set(Calendar.DAY_OF_MONTH, 31);
    	Date hasta = calHasta.getTime();

        try {
            session = HibernateTransactionManager.getCurrentSession();
            Criteria c = session.createCriteria(ActividadModeloTeorico.class);
            
            c.createAlias("via", "via");
            c.add(Restrictions.eq("via.idVia", idVia));
            c.add(Restrictions.gt("fecha", desde));	
            c.add(Restrictions.lt("fecha", hasta));
            
            List<ActividadModeloTeorico> results = (List<ActividadModeloTeorico>) c.list();
            return results;
        } catch (RuntimeException re) {
            throw re;
        }
}
}