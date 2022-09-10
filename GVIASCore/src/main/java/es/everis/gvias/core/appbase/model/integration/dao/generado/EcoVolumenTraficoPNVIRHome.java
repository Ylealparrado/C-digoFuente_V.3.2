package es.everis.gvias.core.appbase.model.integration.dao.generado;

import static org.hibernate.criterion.Example.create;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.LockMode;

import es.everis.gvias.core.appbase.common.utilidades.HibernateTransactionManager;

/**
 * Class EcoVolumenTraficoPNVIRHome.
 */
public class EcoVolumenTraficoPNVIRHome {

    /** Constante log. */
	private static Logger logger = LogManager.getLogger();
	
    /**
     * Persist.
     *
     * @param transientInstance valor de transient instance
     */
    public void persist(EcoVolumenTraficoPNVIR transientInstance) {
        logger.debug("persisting EcoVolumenTraficoPNVIR instance");
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
    public void attachDirty(EcoVolumenTraficoPNVIR instance) {
        logger.debug("attaching dirty EcoVolumenTraficoPNVIR instance");
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
    public void attachClean(EcoVolumenTraficoPNVIR instance) {
        logger.debug("attaching clean EcoVolumenTraficoPNVIR instance");
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
    public void delete(EcoVolumenTraficoPNVIR persistentInstance) {
        logger.debug("deleting EcoVolumenTraficoPNVIR instance");
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
    public EcoVolumenTraficoPNVIR merge(EcoVolumenTraficoPNVIR detachedInstance) {
        logger.debug("merging EcoVolumenTraficoPNVIR instance");
        try {
        	EcoVolumenTraficoPNVIR result = (EcoVolumenTraficoPNVIR) HibernateTransactionManager.getCurrentSession().merge(detachedInstance);
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
    public EcoVolumenTraficoPNVIR findById(java.math.BigDecimal id) {
        logger.debug("getting EcoVolumenTraficoPNVIR instance with id: " + id);
        try {
        	EcoVolumenTraficoPNVIR instance = (EcoVolumenTraficoPNVIR) HibernateTransactionManager.getCurrentSession().get(
                    "es.everis.gvias.core.appbase.model.integration.dao.generado.EcoVolumenTraficoPNVIR", id);
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
    public List<EcoVolumenTraficoPNVIR> findByExample(EcoVolumenTraficoPNVIR instance) {
        logger.debug("finding EcoVolumenTraficoPNVIR instance by example");
        try {
            List<EcoVolumenTraficoPNVIR> results = (List<EcoVolumenTraficoPNVIR>) HibernateTransactionManager.getCurrentSession()
                    .createCriteria("es.everis.gvias.core.appbase.model.integration.dao.generado.EcoVolumenTraficoPNVIR")
                    .add(create(instance)).list();
            logger.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            logger.error("find by example failed", re);
            throw re;
        }
    }
}
