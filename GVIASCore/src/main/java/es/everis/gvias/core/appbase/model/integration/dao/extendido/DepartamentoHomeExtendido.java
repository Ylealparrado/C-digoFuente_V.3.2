package es.everis.gvias.core.appbase.model.integration.dao.extendido;

import java.util.List;

import org.hibernate.Session;

import es.everis.gvias.core.appbase.common.utilidades.HibernateTransactionManager;
import es.everis.gvias.core.appbase.model.integration.dao.generado.Departamento;
import es.everis.gvias.core.appbase.model.integration.dao.generado.DepartamentoHome;

// TODO: Auto-generated Javadoc
/**
 * Clase DepartamentoHomeExtendido.
 */
public class DepartamentoHomeExtendido extends DepartamentoHome{

	/**
	 * Obtiene all.
	 *
	 * @return  all
	 */
	public List<Departamento> getAll() {
    	Session session = null;
    	 try {
	         session = HibernateTransactionManager.getCurrentSession();
	         return session.createCriteria(Departamento.class).list();
	   } catch (RuntimeException re) {
           throw re;
       }
	}    	 
}