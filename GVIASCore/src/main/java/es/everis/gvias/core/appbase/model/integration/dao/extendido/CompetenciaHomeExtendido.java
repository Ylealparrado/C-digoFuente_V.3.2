package es.everis.gvias.core.appbase.model.integration.dao.extendido;

import java.util.List;

import org.hibernate.Session;

import es.everis.gvias.core.appbase.common.utilidades.HibernateTransactionManager;
import es.everis.gvias.core.appbase.model.integration.dao.generado.Competencia;
import es.everis.gvias.core.appbase.model.integration.dao.generado.CompetenciaHome;

// TODO: Auto-generated Javadoc
/**
 * Clase CompetenciaHomeExtendido.
 */
public class CompetenciaHomeExtendido extends CompetenciaHome{

	/**
	 * Obtiene all.
	 *
	 * @return  all
	 */
	public List<Competencia> getAll() {
    	Session session = null;
    	 try {
	         session = HibernateTransactionManager.getCurrentSession();
	         return session.createCriteria(Competencia.class).list();
	   } catch (RuntimeException re) {
           throw re;
       }
	}
    	 
}