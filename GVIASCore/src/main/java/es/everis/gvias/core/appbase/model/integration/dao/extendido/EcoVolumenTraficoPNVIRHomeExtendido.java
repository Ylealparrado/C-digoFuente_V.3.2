package es.everis.gvias.core.appbase.model.integration.dao.extendido;

import java.util.List;

import org.hibernate.Session;

import es.everis.gvias.core.appbase.common.utilidades.HibernateTransactionManager;
import es.everis.gvias.core.appbase.model.integration.dao.generado.EcoVolumenTraficoPNVIR;
import es.everis.gvias.core.appbase.model.integration.dao.generado.EcoVolumenTraficoPNVIRHome;

// TODO: Auto-generated Javadoc
/**
 * Clase EcoVolumenTraficoPNVIRHomeExtendido.
 */
public class EcoVolumenTraficoPNVIRHomeExtendido extends EcoVolumenTraficoPNVIRHome{

	/**
	 * Obtiene all.
	 *
	 * @return  all
	 */
	public List<EcoVolumenTraficoPNVIR> getAll() {
    	Session session = null;
    	 try {
	         session = HibernateTransactionManager.getCurrentSession();
	         return session.createCriteria(EcoVolumenTraficoPNVIR.class).list();
	   } catch (RuntimeException re) {
           throw re;
       }
	}
}