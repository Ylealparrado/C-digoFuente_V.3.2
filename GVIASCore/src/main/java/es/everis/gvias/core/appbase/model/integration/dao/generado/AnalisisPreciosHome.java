package es.everis.gvias.core.appbase.model.integration.dao.generado;

import static org.hibernate.criterion.Example.create;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.LockMode;

import es.everis.gvias.core.appbase.common.utilidades.HibernateTransactionManager;

// TODO: Auto-generated Javadoc
/**
 * Clase AnalisisPreciosHome.
 */
public class AnalisisPreciosHome {

    /**  logger. */
	private static Logger logger = LogManager.getLogger();

    /**
     * Persist.
     *
     * @param transientInstance  transient instance
     */
    public void persist(AnalisisPrecios transientInstance) {
        logger.debug("persisting AnalisisPrecios instance");
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
    public void attachDirty(AnalisisPrecios instance) {
        logger.debug("attaching dirty AnalisisPrecios instance");
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
    public void attachClean(AnalisisPrecios instance) {
        logger.debug("attaching clean AnalisisPrecios instance");
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
    public void delete(AnalisisPrecios persistentInstance) {
        logger.debug("deleting AnalisisPrecios instance");
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
     * @return analisis precios
     */
    public AnalisisPrecios merge(AnalisisPrecios detachedInstance) {
        logger.debug("merging AnalisisPrecios instance");
        try {
        	AnalisisPrecios result = (AnalisisPrecios) HibernateTransactionManager.getCurrentSession().merge(detachedInstance);
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
     * @return analisis precios
     */
    public AnalisisPrecios findById(java.math.BigDecimal id) {
        logger.debug("getting AnalisisPrecios instance with id: " + id);
        try {
        	AnalisisPrecios instance = (AnalisisPrecios) HibernateTransactionManager.getCurrentSession().get(
                    "es.everis.gvias.core.appbase.model.integration.dao.generado.AnalisisPrecios", id);
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
    public List<AnalisisPrecios> findByExample(AnalisisPrecios instance) {
        logger.debug("finding AnalisisPrecios instance by example");
        try {
            List<AnalisisPrecios> results = (List<AnalisisPrecios>) HibernateTransactionManager.getCurrentSession()
                    .createCriteria("es.everis.gvias.core.appbase.model.integration.dao.generado.AnalisisPrecios")
                    .add(create(instance)).list();
            logger.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            logger.error("find by example failed", re);
            throw re;
        }
    }
}
