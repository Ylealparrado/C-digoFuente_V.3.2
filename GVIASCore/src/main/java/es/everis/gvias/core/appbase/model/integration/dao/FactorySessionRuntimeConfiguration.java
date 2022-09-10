package es.everis.gvias.core.appbase.model.integration.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import es.everis.gvias.core.appbase.common.utilidades.Utilidades;

/**
 * Class FactorySessionRuntimeConfiguration.
 */
public class FactorySessionRuntimeConfiguration {

    /** Variable log. */
	private static Logger logger = LogManager.getLogger();
	
    /** Variable session factory. */
    private static SessionFactory sessionFactory;
    
    /** Variable session factory inspecciones. */
    private static SessionFactory sessionFactoryInspecciones;

    /**
     * Obtiene el valor de dynamic session factory.
     *
     * @param database valor de database
     * @return dynamic session factory
     */
    public static SessionFactory getDynamicSessionFactory(String database) {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                String datasource = Utilidades.damePropiedad(database+".hibernate.connection.datasource");
                if (datasource == null) {
                    String url = Utilidades.damePropiedad(database+".hibernate.connection.url");
                    String username = Utilidades.damePropiedad(database+".hibernate.connection.username");
                    String schema = Utilidades.damePropiedad(database+".hibernate.default_schema");
                    String password = Utilidades.damePropiedad(database+".hibernate.connection.password");

                    configuration.setProperty(database+".hibernate.connection.url", url);
                    configuration.setProperty(database+".hibernate.connection.username", username);
                    if (schema != null) {
                        configuration.setProperty(database+".hibernate.default_schema", schema);
                    }
                    configuration.setProperty(database+".hibernate.connection.password", password);
                } else {
                    configuration.setProperty(database+".hibernate.connection.datasource", datasource);
                }
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                        configuration.getProperties()).build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                logger.error("Initial SessionFactory creation failed." + e.getMessage(), e);
            }
        }

        return sessionFactory;
    }

}
