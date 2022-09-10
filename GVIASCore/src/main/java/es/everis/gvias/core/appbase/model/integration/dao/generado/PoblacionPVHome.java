package es.everis.gvias.core.appbase.model.integration.dao.generado;

import static org.hibernate.criterion.Example.create;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.LockMode;

import es.everis.gvias.core.appbase.common.utilidades.HibernateTransactionManager;

/**
 * Class PoblacionPVHome.
 */
public class PoblacionPVHome {

    /** Constante log. */
	private static Logger logger = LogManager.getLogger();
	
    /**
     * Persist.
     *
     * @param transientInstance valor de transient instance
     */
    public void persist(PoblacionPV transientInstance) {
        logger.debug("persisting PoblacionPV instance");
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
     * @param instance valor de instance
     */
    public void attachDirty(PoblacionPV instance) {
        logger.debug("attaching dirty PoblacionPV instance");
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
     * @param instance valor de instance
     */
    public void attachClean(PoblacionPV instance) {
        logger.debug("attaching clean PoblacionPV instance");
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
     * @param persistentInstance valor de persistent instance
     */
    public void delete(PoblacionPV persistentInstance) {
        logger.debug("deleting PoblacionPV instance");
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
     * @param detachedInstance valor de detached instance
     * @return v usr tipo estado
     */
    public PoblacionPV merge(PoblacionPV detachedInstance) {
        logger.debug("merging PoblacionPV instance");
        try {
        	PoblacionPV result = (PoblacionPV) HibernateTransactionManager.getCurrentSession().merge(detachedInstance);
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
     * @param id valor de id
     * @return v usr tipo estado
     */
    public PoblacionPV findById(java.math.BigDecimal id) {
        logger.debug("getting PoblacionPV instance with id: " + id);
        try {
        	PoblacionPV instance = (PoblacionPV) HibernateTransactionManager.getCurrentSession().get(
                    "es.everis.gvias.core.appbase.model.integration.dao.generado.PoblacionPV", id);
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
     * @param instance valor de instance
     * @return list
     */
    public List<PoblacionPV> findByExample(PoblacionPV instance) {
        logger.debug("finding PoblacionPV instance by example");
        try {
            List<PoblacionPV> results = (List<PoblacionPV>) HibernateTransactionManager.getCurrentSession()
                    .createCriteria("es.everis.gvias.core.appbase.model.integration.dao.generado.PoblacionPV")
                    .add(create(instance)).list();
            logger.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            logger.error("find by example failed", re);
            throw re;
        }
    }
}
