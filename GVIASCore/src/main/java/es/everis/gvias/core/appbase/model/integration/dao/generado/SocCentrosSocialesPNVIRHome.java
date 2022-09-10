package es.everis.gvias.core.appbase.model.integration.dao.generado;

import static org.hibernate.criterion.Example.create;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.LockMode;

import es.everis.gvias.core.appbase.common.utilidades.HibernateTransactionManager;

// TODO: Auto-generated Javadoc
/**
 * Clase SocCentrosSocialesPNVIRHome.
 */
public class SocCentrosSocialesPNVIRHome {

    /**  logger. */
	private static Logger logger = LogManager.getLogger();
	
    /**
     * Persist.
     *
     * @param transientInstance  transient instance
     */
    public void persist(SocCentrosSocialesPNVIR transientInstance) {
        logger.debug("persisting SocCentrosSocialesPNVIR instance");
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
    public void attachDirty(SocCentrosSocialesPNVIR instance) {
        logger.debug("attaching dirty SocCentrosSocialesPNVIR instance");
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
    public void attachClean(SocCentrosSocialesPNVIR instance) {
        logger.debug("attaching clean SocCentrosSocialesPNVIR instance");
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
    public void delete(SocCentrosSocialesPNVIR persistentInstance) {
        logger.debug("deleting SocCentrosSocialesPNVIR instance");
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
     * @return soc centros sociales PNVIR
     */
    public SocCentrosSocialesPNVIR merge(SocCentrosSocialesPNVIR detachedInstance) {
        logger.debug("merging SocCentrosSocialesPNVIR instance");
        try {
        	SocCentrosSocialesPNVIR result = (SocCentrosSocialesPNVIR) HibernateTransactionManager.getCurrentSession().merge(detachedInstance);
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
     * @return soc centros sociales PNVIR
     */
    public SocCentrosSocialesPNVIR findById(java.math.BigDecimal id) {
        logger.debug("getting SocCentrosSocialesPNVIR instance with id: " + id);
        try {
        	SocCentrosSocialesPNVIR instance = (SocCentrosSocialesPNVIR) HibernateTransactionManager.getCurrentSession().get(
                    "es.everis.gvias.core.appbase.model.integration.dao.generado.SocCentrosSocialesPNVIR", id);
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
    public List<SocCentrosSocialesPNVIR> findByExample(SocCentrosSocialesPNVIR instance) {
        logger.debug("finding SocCentrosSocialesPNVIR instance by example");
        try {
            List<SocCentrosSocialesPNVIR> results = (List<SocCentrosSocialesPNVIR>) HibernateTransactionManager.getCurrentSession()
                    .createCriteria("es.everis.gvias.core.appbase.model.integration.dao.generado.SocCentrosSocialesPNVIR")
                    .add(create(instance)).list();
            logger.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            logger.error("find by example failed", re);
            throw re;
        }
    }
}
