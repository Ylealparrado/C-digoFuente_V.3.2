package es.everis.gvias.web.appbase.control.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.StaleObjectStateException;
import org.hibernate.resource.transaction.spi.TransactionStatus;

import es.everis.gvias.core.appbase.common.utilidades.HibernateTransactionManager;

/**
 * Class HibernateSessionRequestFilter.
 */
public class HibernateSessionRequestFilter implements Filter {

    /** Variable log. */
	private static Logger logger = LogManager.getLogger();    
    /** Variable h. */
    private HibernateTransactionManager h;  
  
    /* (non-Javadoc)
     * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
     */
    public void doFilter(ServletRequest request,  
                         ServletResponse response,  
                         FilterChain chain)  
            throws IOException, ServletException {  
  
        try {  
//            log.debug("Starting a database transaction");  
            h.beginTransaction();  
  
            // Call the next filter (continue request processing)  
            chain.doFilter(request, response);  
  
            // Commit and cleanup  
//            log.debug("Committing the database transaction");  
            h.commit();  
  
        } catch (StaleObjectStateException staleEx) {  
//            log.error("This interceptor does not implement optimistic concurrency control!");  
//            log.error("Your application will not work until you add compensation actions!");  
            // Rollback, close everything, possibly compensate for any permanent changes  
            // during the conversation, and finally restart business conversation. Maybe  
            // give the user of the application a chance to merge some of his work with  
            // fresh data... what you do here depends on your applications design.  
            throw staleEx;  
        } catch (Throwable ex) {  
            // Rollback only  
            ex.printStackTrace();  
            try {  
                if (h.getCurrentSession().getTransaction().getStatus() == TransactionStatus.ACTIVE) {
//                    log.debug("Trying to rollback database transaction after exception");  
                    h.rollback();  
                }  
            } catch (Throwable rbEx) {  
//                log.error("Could not rollback transaction after exception!", rbEx);  
            }  
  
            // Let others handle it... maybe another interceptor for exceptions?  
            throw new ServletException(ex);  
        }  
    }  
  
    /* (non-Javadoc)
     * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
     */
    public void init(FilterConfig filterConfig) throws ServletException {  
    	logger.debug("Initializing filter...");  
    	logger.debug("Obtaining SessionFactory from static HibernateUtil singleton");  
        h = HibernateTransactionManager.getInstance();
    }  
  
    /* (non-Javadoc)
     * @see javax.servlet.Filter#destroy()
     */
    public void destroy() {} 	
}
