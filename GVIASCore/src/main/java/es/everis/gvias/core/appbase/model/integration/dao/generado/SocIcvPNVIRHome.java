package es.everis.gvias.core.appbase.model.integration.dao.generado;

import static org.hibernate.criterion.Example.create;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.LockMode;

import es.everis.gvias.core.appbase.common.utilidades.HibernateTransactionManager;

/**
 * Class SocIcvPNVIRHome.
 */
public class SocIcvPNVIRHome {

    /** Constante log. */
	private static Logger logger = LogManager.getLogger();
	
    /**
     * Persist.
     *
     * @param transientInstance valor de transient instance
     */
    public void persist(SocIcvPNVIR transientInstance) {
        logger.debug("persisting SocIcvPNVIR instance");
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
    public void attachDirty(SocIcvPNVIR instance) {
        logger.debug("attaching dirty SocIcvPNVIR instance");
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
    public void attachClean(SocIcvPNVIR instance) {
        logger.debug("attaching clean SocIcvPNVIR instance");
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
    public void delete(SocIcvPNVIR persistentInstance) {
        logger.debug("deleting SocIcvPNVIR instance");
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
    public SocIcvPNVIR merge(SocIcvPNVIR detachedInstance) {
        logger.debug("merging SocIcvPNVIR instance");
        try {
        	SocIcvPNVIR result = (SocIcvPNVIR) HibernateTransactionManager.getCurrentSession().merge(detachedInstance);
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
    public SocIcvPNVIR findById(java.math.BigDecimal id) {
        logger.debug("getting SocIcvPNVIR instance with id: " + id);
        try {
        	SocIcvPNVIR instance = (SocIcvPNVIR) HibernateTransactionManager.getCurrentSession().get(
                    "es.everis.gvias.core.appbase.model.integration.dao.generado.SocIcvPNVIR", id);
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
    public List<SocIcvPNVIR> findByExample(SocIcvPNVIR instance) {
        logger.debug("finding SocIcvPNVIR instance by example");
        try {
            List<SocIcvPNVIR> results = (List<SocIcvPNVIR>) HibernateTransactionManager.getCurrentSession()
                    .createCriteria("es.everis.gvias.core.appbase.model.integration.dao.generado.SocIcvPNVIR")
                    .add(create(instance)).list();
            logger.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            logger.error("find by example failed", re);
            throw re;
        }
    }
}
