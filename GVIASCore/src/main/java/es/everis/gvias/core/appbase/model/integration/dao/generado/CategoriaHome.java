package es.everis.gvias.core.appbase.model.integration.dao.generado;

import static org.hibernate.criterion.Example.create;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.LockMode;

import es.everis.gvias.core.appbase.common.utilidades.HibernateTransactionManager;

/**
 * Class CategoriaHome.
 */
public class CategoriaHome {

    /** Constante log. */
	private static Logger logger = LogManager.getLogger();

    /**
     * Persist.
     *
     * @param transientInstance valor de transient instance
     */
    public void persist(Categoria transientInstance) {
        logger.debug("persisting Categoria instance");
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
    public void attachDirty(Categoria instance) {
        logger.debug("attaching dirty Categoria instance");
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
    public void attachClean(Categoria instance) {
        logger.debug("attaching clean Categoria instance");
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
    public void delete(Categoria persistentInstance) {
        logger.debug("deleting Categoria instance");
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
    public Categoria merge(Categoria detachedInstance) {
        logger.debug("merging Categoria instance");
        try {
        	Categoria result = (Categoria) HibernateTransactionManager.getCurrentSession().merge(detachedInstance);
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
    public Categoria findById(java.math.BigDecimal id) {
        logger.debug("getting Categoria instance with id: " + id);
        try {
        	Categoria instance = (Categoria) HibernateTransactionManager.getCurrentSession().get(
                    "es.everis.gvias.core.appbase.model.integration.dao.generado.Categoria", id);
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
    public List<Categoria> findByExample(Categoria instance) {
        logger.debug("finding Categoria instance by example");
        try {
            List<Categoria> results = (List<Categoria>) HibernateTransactionManager.getCurrentSession()
                    .createCriteria("es.everis.gvias.core.appbase.model.integration.dao.generado.Categoria")
                    .add(create(instance)).list();
            logger.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            logger.error("find by example failed", re);
            throw re;
        }
    }
}
