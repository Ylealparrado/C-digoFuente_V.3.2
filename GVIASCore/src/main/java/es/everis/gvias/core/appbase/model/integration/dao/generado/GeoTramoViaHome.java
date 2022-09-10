package es.everis.gvias.core.appbase.model.integration.dao.generado;

import static org.hibernate.criterion.Example.create;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.LockMode;

import es.everis.gvias.core.appbase.common.utilidades.HibernateTransactionManager;

/**
 * Class GeoTramoViaHome.
 */
public class GeoTramoViaHome {

    /** Constante log. */
	private static Logger logger = LogManager.getLogger();
	
    /**
     * Persist.
     *
     * @param transientInstance valor de transient instance
     */
    public void persist(GeoTramoVia transientInstance) {
        logger.debug("persisting GeoTramoVia instance");
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
    public void attachDirty(GeoTramoVia instance) {
        logger.debug("attaching dirty GeoTramoVia instance");
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
    public void attachClean(GeoTramoVia instance) {
        logger.debug("attaching clean GeoTramoVia instance");
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
    public void delete(GeoTramoVia persistentInstance) {
        logger.debug("deleting GeoTramoVia instance");
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
    public GeoTramoVia merge(GeoTramoVia detachedInstance) {
        logger.debug("merging GeoTramoVia instance");
        try {
        	GeoTramoVia result = (GeoTramoVia) HibernateTransactionManager.getCurrentSession().merge(detachedInstance);
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
    public GeoTramoVia findById(java.math.BigDecimal id) {
        logger.debug("getting GeoTramoVia instance with id: " + id);
        try {
        	GeoTramoVia instance = (GeoTramoVia) HibernateTransactionManager.getCurrentSession().get(
                    "es.everis.gvias.core.appbase.model.integration.dao.generado.GeoTramoVia", id);
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
    public List<GeoTramoVia> findByExample(GeoTramoVia instance) {
        logger.debug("finding GeoTramoVia instance by example");
        try {
            List<GeoTramoVia> results = (List<GeoTramoVia>) HibernateTransactionManager.getCurrentSession()
                    .createCriteria("es.everis.gvias.core.appbase.model.integration.dao.generado.GeoTramoVia")
                    .add(create(instance)).list();
            logger.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            logger.error("find by example failed", re);
            throw re;
        }
    }
}
