package es.everis.gvias.core.appbase.model.integration.dao.generado;

import static org.hibernate.criterion.Example.create;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.LockMode;

import es.everis.gvias.core.appbase.common.utilidades.HibernateTransactionManager;

// TODO: Auto-generated Javadoc
/**
 * Clase EcoComercializacionPNVIRHome.
 */
public class EcoComercializacionPNVIRHome {

    /**  logger. */
	private static Logger logger = LogManager.getLogger();
	
    /**
     * Persist.
     *
     * @param transientInstance  transient instance
     */
    public void persist(EcoComercializacionPNVIR transientInstance) {
        logger.debug("persisting EcoComercializacionPNVIR instance");
        try {
            HibernateTransactionManager.getCurrentSession().persist(transientInstance);
            logger.debug("persist successful");
        } catch (RuntimeException re) {
            logger.error("persist failed", re);
            throw re;
        }
    }

    /**
     * Attach dirty.
     *
     * @param instance  instance
     */
    public void attachDirty(EcoComercializacionPNVIR instance) {
        logger.debug("attaching dirty EcoComercializacionPNVIR instance");
        try {
            HibernateTransactionManager.getCurrentSession().saveOrUpdate(instance);
            logger.debug("attach successful");
        } catch (RuntimeException re) {
            logger.error("attach failed", re);
            throw re;
        }
    }

    /**
     * Attach clean.
     *
     * @param instance  instance
     */
    public void attachClean(EcoComercializacionPNVIR instance) {
        logger.debug("attaching clean EcoComercializacionPNVIR instance");
        try {
            HibernateTransactionManager.getCurrentSession().lock(instance, LockMode.NONE);
            logger.debug("attach successful");
        } catch (RuntimeException re) {
            logger.error("attach failed", re);
            throw re;
        }
    }

    /**
     * Delete.
     *
     * @param persistentInstance  persistent instance
     */
    public void delete(EcoComercializacionPNVIR persistentInstance) {
        logger.debug("deleting EcoComercializacionPNVIR instance");
        try {
            HibernateTransactionManager.getCurrentSession().delete(persistentInstance);
            logger.debug("delete successful");
        } catch (RuntimeException re) {
            logger.error("delete failed", re);
            throw re;
        }
    }

    /**
     * Merge.
     *
     * @param detachedInstance  detached instance
     * @return eco comercializacion PNVIR
     */
    public EcoComercializacionPNVIR merge(EcoComercializacionPNVIR detachedInstance) {
        logger.debug("merging EcoComercializacionPNVIR instance");
        try {
        	EcoComercializacionPNVIR result = (EcoComercializacionPNVIR) HibernateTransactionManager.getCurrentSession().merge(detachedInstance);
            logger.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            logger.error("merge failed", re);
            throw re;
        }
    }

    /**
     * Find by id.
     *
     * @param id  id
     * @return eco comercializacion PNVIR
     */
    public EcoComercializacionPNVIR findById(java.math.BigDecimal id) {
        logger.debug("getting EcoComercializacionPNVIR instance with id: " + id);
        try {
        	EcoComercializacionPNVIR instance = (EcoComercializacionPNVIR) HibernateTransactionManager.getCurrentSession().get(
                    "es.everis.gvias.core.appbase.model.integration.dao.generado.EcoComercializacionPNVIR", id);
            if (instance == null) {
                logger.debug("get successful, no instance found");
            } else {
                logger.debug("get successful, instance found");
            }
            return instance;
        } catch (RuntimeException re) {
            logger.error("get failed", re);
            throw re;
        }
    }

    /**
     * Find by example.
     *
     * @param instance  instance
     * @return list
     */
    public List<EcoComercializacionPNVIR> findByExample(EcoComercializacionPNVIR instance) {
        logger.debug("finding EcoComercializacionPNVIR instance by example");
        try {
            List<EcoComercializacionPNVIR> results = (List<EcoComercializacionPNVIR>) HibernateTransactionManager.getCurrentSession()
                    .createCriteria("es.everis.gvias.core.appbase.model.integration.dao.generado.EcoComercializacionPNVIR")
                    .add(create(instance)).list();
            logger.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            logger.error("find by example failed", re);
            throw re;
        }
    }
}
