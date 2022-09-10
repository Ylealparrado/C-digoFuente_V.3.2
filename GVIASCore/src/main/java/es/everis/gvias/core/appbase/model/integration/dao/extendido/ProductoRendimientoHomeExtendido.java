package es.everis.gvias.core.appbase.model.integration.dao.extendido;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import es.everis.gvias.core.appbase.common.utilidades.HibernateTransactionManager;
import es.everis.gvias.core.appbase.model.integration.dao.generado.ProductoRendimiento;
import es.everis.gvias.core.appbase.model.integration.dao.generado.ProductoRendimientoHome;

// TODO: Auto-generated Javadoc
/**
 * Clase ProductoRendimientoHomeExtendido.
 */
public class ProductoRendimientoHomeExtendido extends ProductoRendimientoHome{

	/**
	 * Obtiene all.
	 *
	 * @return  all
	 */
	public List<ProductoRendimiento> getAll() {
    	Session session = null;
    	 try {
	         session = HibernateTransactionManager.getCurrentSession();
	         return session.createCriteria(ProductoRendimiento.class).list();
	   } catch (RuntimeException re) {
           throw re;
       }
	}

	/**
	 * Obtener lista cultivos por municipio.
	 *
	 * @param idMunicipio the id municipio
	 * @return list
	 */
	public List<ProductoRendimiento> obtenerListaCultivosPorMunicipio(BigDecimal idMunicipio) {
	    	Session session = null;

	        try {
	            session = HibernateTransactionManager.getCurrentSession();
	            Criteria c = session.createCriteria(ProductoRendimiento.class);
	            
	            c.createAlias("municipio", "municipio");
	            c.add(Restrictions.eq("municipio.idMunicipio", idMunicipio));
//	            c.addOrder(Order.asc("codVia"));
	            
	            List<ProductoRendimiento> results = (List<ProductoRendimiento>) c.list();
	            return results;
	        } catch (RuntimeException re) {
	            throw re;
	        }
	}

}