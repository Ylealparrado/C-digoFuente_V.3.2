package es.everis.gvias.core.appbase.common.utilidades;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Interceptor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import es.everis.gvias.core.appbase.model.integration.dao.FactorySession;
import es.everis.gvias.core.appbase.model.integration.dao.FactorySessionRuntimeConfiguration;

/**
 * Class HibernateTransactionManagerRuntimeConfiguration.
 */
public class HibernateTransactionManagerRuntimeConfiguration {

    /** Constante logger. */
	private static Logger logger = LogManager.getLogger();
	
    /** Constante NORMAL. */
    private static final String NORMAL = "Normal";
    
    /** Constante INSPECCIONES. */
    private static final String INSPECCIONES = "Inspecciones";
    
    /** Constante INSPECCIONES_SCHEMA. */
    public static final String INSPECCIONES_SCHEMA = "schema_inspecciones";
    
    /** Constante transactionManagers. */
    private static final ThreadLocal<HibernateTransactionManagerRuntimeConfiguration> transactionManagers = new ThreadLocal<>();
    
    /** Constante interceptors. */
    private static final ThreadLocal<Interceptor> interceptors = new ThreadLocal<>();
    
    /** Variable sf. */
    private SessionFactory sf;
    
    /** Variable session. */
    private Session session;
    
    /** Variable tipo. */
    private String tipo;

    /** Variable transacciones abiertas. */
    private int transaccionesAbiertas;

    /**
     * Crea una instancia de hibernate transaction manager runtime configuration.
     *
     * @param database valor de database
     */
    protected HibernateTransactionManagerRuntimeConfiguration(String database) {
        transaccionesAbiertas = 0;

        if (database!=null) {
            try {
                sf = FactorySessionRuntimeConfiguration.getDynamicSessionFactory(database);
                tipo = NORMAL;
            } catch (Throwable t) {
                logger.error(t.getMessage(), t);
            }
        } else {
            try {
                sf = FactorySession.getSessionFactory();
                tipo = NORMAL;
            } catch (Throwable t) {
                logger.error(t.getMessage(), t);
            }
        }
    }

    /**
     * Obtiene una instancia de HibernateTransactionManagerRuntimeConfiguration.
     *
     * @param database valor de database
     * @return instancia de HibernateTransactionManagerRuntimeConfiguration
     */
    public static synchronized HibernateTransactionManagerRuntimeConfiguration getInstance(String database) {
        HibernateTransactionManagerRuntimeConfiguration currentTransacctionManager = transactionManagers.get();

        if (currentTransacctionManager == null) {
            currentTransacctionManager = new HibernateTransactionManagerRuntimeConfiguration(database);

            transactionManagers.set(currentTransacctionManager);
        } else if (INSPECCIONES.equals(currentTransacctionManager.getTipo())) {
            throw new RuntimeException("Existe un session factory abierto de tipo " + NORMAL + " para este hilo");
        }

        return currentTransacctionManager;
    }


    /**
     * Begin transaction.
     */
    public void beginTransaction() {

        if (getSession().getTransaction().getStatus() != TransactionStatus.ACTIVE) {
            getSession().beginTransaction();
        }

        transaccionesAbiertas++;
    }

    /**
     * Obtiene el valor de session.
     *
     * @return session
     */
    private Session getSession() {
        if (session == null || !session.isOpen()) {
            openSession(getInterceptor());
        }
        return session;
    }

    /**
     * Obtiene el valor de current session.
     *
     * @return current session
     */
    public static Session getCurrentSession() {
        HibernateTransactionManagerRuntimeConfiguration h = transactionManagers.get();
        return h == null ? null : h.getSession();
    }

    /**
     * Commit.
     */
    public void commit() {
        transaccionesAbiertas--;

        if (transaccionesAbiertas <= 0) {
            getSession().flush();
            getSession().getTransaction().commit();
            
            closeSession();
            transactionManagers.remove();
            transaccionesAbiertas = 0;
        } 
    }

    /**
     * Rollback.
     */
    public void rollback() {
        transactionManagers.remove();
        if (transaccionesAbiertas > 0) {
            session.getTransaction().rollback();
        }
        transaccionesAbiertas = 0;
        closeSession();
    }

    /**
     * Obtiene el valor de tipo.
     *
     * @return tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Establece el valor de tipo.
     *
     * @param tipo nuevo valor de tipo
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Open session.
     *
     * @param interceptor valor de interceptor
     * @return session
     */
    private Session openSession(Interceptor interceptor) {
        if (session == null || !session.isOpen()) {
            if (interceptor != null) {
                session = getSessionFactory().withOptions().interceptor(interceptor).openSession();
            } else {
                session = getSessionFactory().openSession();
            }
        }

        return session;
    }

    /**
     * Obtiene el valor de session factory.
     *
     * @return session factory
     */
    private SessionFactory getSessionFactory() {
        return sf;
    }

    /**
     * Close session.
     */
    private void closeSession() {
        if (session != null && session.isOpen()) {
            session.close();
            session = null;
        }
    }

    /**
     * Comprueba el valor de he abierto transaccion.
     *
     * @return true, si he abierto transaccion
     */
    public boolean isHeAbiertoTransaccion() {
        return transaccionesAbiertas == 1;
    }

    /**
     * Establece el valor de interceptor.
     *
     * @param interceptor nuevo valor de interceptor
     */
    public static void setInterceptor(Interceptor interceptor) {
        interceptors.set(interceptor);
    }

    /**
     * Obtiene el valor de interceptor.
     *
     * @return interceptor
     */
    public static Interceptor getInterceptor() {
        return interceptors.get();
    }
}
