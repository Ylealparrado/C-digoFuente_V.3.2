package es.everis.gvias.core.appbase.model.integration.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import es.everis.gvias.core.appbase.common.utilidades.Utilidades;

/**
 * Class FactorySession.
 */
public class FactorySession {
    /** Variable log. */
	private static Logger logger = LogManager.getLogger();
	
    /** Variable session factory. */
    private static SessionFactory sessionFactory;
    
    /** Variable session factory inspecciones. */
    private static SessionFactory sessionFactoryInspecciones;
    
    private static StandardServiceRegistry registry;


    /**
     * Obtiene el valor de session factory.
     *
     * @return session factory
     */
    public static SessionFactory getSessionFactoryOLD() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration().configure();
                String datasource = Utilidades.damePropiedad("hibernate.connection.datasource");
                if (datasource == null) {
                    String url = Utilidades.damePropiedad("hibernate.connection.url");
                    String username = Utilidades.damePropiedad("hibernate.connection.username");
                    String schema = Utilidades.damePropiedad("hibernate.default_schema");
                    String password = Utilidades.damePropiedad("hibernate.connection.password");

                    configuration.setProperty("hibernate.connection.url", url);
                    configuration.setProperty("hibernate.connection.username", username);
                    if (schema != null) {
                        configuration.setProperty("hibernate.default_schema", schema);
                    }
                    configuration.setProperty("hibernate.connection.password", password);
                } else {
                    configuration.setProperty("hibernate.connection.datasource", datasource);
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
    
    
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                // Create registry
            	//registry = new StandardServiceRegistryBuilder().configure().build();
            	Configuration configuration = new Configuration().configure();
            	
                configuration.setProperty("hibernate.connection.url", Utilidades.damePropiedad("hibernate.connection.url"));
                configuration.setProperty("hibernate.connection.username", Utilidades.damePropiedad("hibernate.connection.username"));
                configuration.setProperty("hibernate.connection.password", Utilidades.damePropiedad("hibernate.connection.password"));
                
            	registry = new StandardServiceRegistryBuilder().applySettings(
                        configuration.getProperties()).configure().build();
                // Create MetadataSources
                MetadataSources sources = new MetadataSources(registry);
                // Create Metadata
                Metadata metadata = sources.getMetadataBuilder().build();
                // Create SessionFactory
                sessionFactory = metadata.getSessionFactoryBuilder().build();
            } catch (Exception e) {
                e.printStackTrace();
                if (registry != null) {
                    StandardServiceRegistryBuilder.destroy(registry);
                }
            }
        }
        return sessionFactory;
    }

    /**
     * Obtiene el valor de session factory.
     *
     * @param strSchema valor de str schema
     * @return session factory
     */
    public static SessionFactory getSessionFactory(String strSchema) {
        if (sessionFactoryInspecciones == null) {
            try {
                Configuration configuration = new Configuration().configure("hibernate_inspecciones.cfg.xml");
                String datasource = Utilidades.damePropiedad("hibernate.connection.datasource");
                if (datasource == null) {
                    String url = Utilidades.damePropiedad("hibernate.connection.url");
                    String username = Utilidades.damePropiedad("hibernate.connection.username.inspecciones");
                    String schema = strSchema;
                    String password = Utilidades.damePropiedad("hibernate.connection.password.inspecciones");

                    configuration.setProperty("hibernate.connection.url", url);
                    configuration.setProperty("hibernate.connection.username", username);
                    if (schema != null) {
                        configuration.setProperty("hibernate.default_schema", schema);
                    }
                    configuration.setProperty("hibernate.connection.password", password);
                } else {
                    configuration.setProperty("hibernate.connection.datasource", datasource);
                }
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                        configuration.getProperties()).build();
                sessionFactoryInspecciones = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                logger.error("Initial SessionFactory creation failed." + e.getMessage(), e);
            }
        }

        return sessionFactoryInspecciones;
    }

}
