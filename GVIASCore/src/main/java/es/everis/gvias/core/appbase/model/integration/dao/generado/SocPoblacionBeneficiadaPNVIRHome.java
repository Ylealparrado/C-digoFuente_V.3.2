package es.everis.gvias.core.appbase.model.integration.dao.generado;

import static org.hibernate.criterion.Example.create;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.LockMode;

import es.everis.gvias.core.appbase.common.utilidades.HibernateTransactionManager;

/**
 * Class SocPoblacionBeneficiadaPNVIRHome.
 */
public class SocPoblacionBeneficiadaPNVIRHome {

    /** Constante log. */
	private static Logger logger = LogManager.getLogger();
	
    /**
     * Persist.
     *
     * @param transientInstance valor de transient instance
     */
    public void persist(SocPoblacionBeneficiadaPNVIR transientInstance) {
        logger.debug("persisting SocPoblacionBeneficiadaPNVIR instance");
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
    public void attachDirty(SocPoblacionBeneficiadaPNVIR instance) {
        logger.debug("attaching dirty SocPoblacionBeneficiadaPNVIR instance");
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
    public void attachClean(SocPoblacionBeneficiadaPNVIR instance) {
        logger.debug("attaching clean SocPoblacionBeneficiadaPNVIR instance");
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
    public void delete(SocPoblacionBeneficiadaPNVIR persistentInstance) {
        logger.debug("deleting SocPoblacionBeneficiadaPNVIR instance");
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
    public SocPoblacionBeneficiadaPNVIR merge(SocPoblacionBeneficiadaPNVIR detachedInstance) {
        logger.debug("merging SocPoblacionBeneficiadaPNVIR instance");
        try {
        	SocPoblacionBeneficiadaPNVIR result = (SocPoblacionBeneficiadaPNVIR) HibernateTransactionManager.getCurrentSession().merge(detachedInstance);
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
    public SocPoblacionBeneficiadaPNVIR findById(java.math.BigDecimal id) {
        logger.debug("getting SocPoblacionBeneficiadaPNVIR instance with id: " + id);
        try {
        	SocPoblacionBeneficiadaPNVIR instance = (SocPoblacionBeneficiadaPNVIR) HibernateTransactionManager.getCurrentSession().get(
                    "es.everis.gvias.core.appbase.model.integration.dao.generado.SocPoblacionBeneficiadaPNVIR", id);
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
    public List<SocPoblacionBeneficiadaPNVIR> findByExample(SocPoblacionBeneficiadaPNVIR instance) {
        logger.debug("finding SocPoblacionBeneficiadaPNVIR instance by example");
        try {
            List<SocPoblacionBeneficiadaPNVIR> results = (List<SocPoblacionBeneficiadaPNVIR>) HibernateTransactionManager.getCurrentSession()
                    .createCriteria("es.everis.gvias.core.appbase.model.integration.dao.generado.SocPoblacionBeneficiadaPNVIR")
                    .add(create(instance)).list();
            logger.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            logger.error("find by example failed", re);
            throw re;
        }
    }
}
