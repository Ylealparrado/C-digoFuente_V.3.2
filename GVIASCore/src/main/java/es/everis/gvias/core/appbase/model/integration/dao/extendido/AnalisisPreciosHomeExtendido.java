package es.everis.gvias.core.appbase.model.integration.dao.extendido;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import es.everis.gvias.core.appbase.common.utilidades.HibernateTransactionManager;
import es.everis.gvias.core.appbase.model.integration.dao.generado.AnalisisPrecios;
import es.everis.gvias.core.appbase.model.integration.dao.generado.AnalisisPreciosHome;
import es.everis.gvias.core.appbase.model.integration.dao.generado.Municipio;

// TODO: Auto-generated Javadoc
/**
 * Clase AnalisisPreciosHomeExtendido.
 */
public class AnalisisPreciosHomeExtendido extends AnalisisPreciosHome{	
    	 
	 /**
 	 * Obtener precios by id municipio.
 	 *
 	 * @param munId the mun id
 	 * @return analisis precios
 	 */
 	public AnalisisPrecios obtenerPreciosByIdMunicipio(BigDecimal munId) {
	    	Session session = null;

	        try {
	            session = HibernateTransactionManager.getCurrentSession();
	            Criteria c = session.createCriteria(AnalisisPrecios.class);
	            
	            c.add(Restrictions.eq("municipio.idMunicipio", munId));
	            
	            AnalisisPrecios result = (AnalisisPrecios) c.uniqueResult();
	            
	            return result;
	            
	        } catch (RuntimeException re) {
	            throw re;
	        }
		}
}